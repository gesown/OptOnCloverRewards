package com.cybercoupons.rewards.android;
//package com.clover.optin.rewards.android;

import android.accounts.Account;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.RemoteException;
import android.provider.Settings;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import util.CloverAccount;
import util.Platform;
import v1.BindingException;
import v1.ClientException;
import v1.Intents;
//import v3.base.Tender;
import v1.ServiceException;
import v3.order.Order;
import v3.order.OrderCalc;
import v3.order.OrderConnector;
import v3.payments.LineItemPayment;
import v3.payments.ServiceChargeAmount;
import v3.scanner.BarcodeScanner;
import v3.payments.Payment;
import com.cybercoupons.rewards.android.ExceptionHandler;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Currency;

public class TenderHandlerActivity extends Activity implements View.OnClickListener {
    private static final int SERVICE_CONNECTION_TIMEOUT = 3000;
    private static final int SERVICE_MAX_RETRY_ATTEMPTS = 3;

    private long amount;
    private long taxamount;
    private long untaxedamount;
    private String lastOrderId;
    private String merchantId;
    private String globalHTML;
    private int iBarcodeScanner = 1; // Use this to enable / disable the Scanner functionality (0=Disable, 1=Enable)

    public static final String PREFS_NAME = "CyberPrefs";
    final Activity activity = this;

    private Account mAccount;
    private BarcodeScanner mBarcodeScanner;
    public static Button btnSubmit;
    public static Button btnCancel;
    public static Button btnCancelTransaction;
    public static Button btnTransactionComplete;
    final Handler _handler = new Handler();
    private String c_strCyberCouponsHost = "https://www.cybercoupons.com";
    private String c_strAndroid_ID;
    private String c_strPOSID;
    private String c_strCloverStation = "1";
    private String c_strCloverMini = "3";
    private String c_strCloverMobile = "4";
    private static OrderConnector c_OrderConnector;
    private Order c_Order;
    private OrderCalc c_OrderCalc;
    private String c_strOrderID;
    private String str_storeID;

    public BroadcastReceiver barcodeReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            try {

                Log.d("MainAcivity", "BroadcastReceiver::onReceive: START");

                SharedPreferences prfs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
                String barcode = intent.getStringExtra("Barcode");
                str_storeID = prfs.getString("Store_ID", "");
                String str_storePassword = prfs.getString("Store_Password", "");
                String str_accessToken = prfs.getString("Access_Token", "");

                //Log.d("MainAcivity", "BroadcastReceiver::onReceive: str_accessToken=" + str_accessToken);

                SharedPreferences preferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("StartPage", "tender");
                editor.apply();

                //Log.d("MainAcivity", "BroadcastReceiver::onReceive: 2");

                final WebView myWebView = (WebView) findViewById(R.id.webview);
                myWebView.setWebChromeClient(new WebChromeClient());
                myWebView.getSettings().setJavaScriptEnabled(true);
                myWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
                myWebView.addJavascriptInterface(new MyJavaScriptInterface(TenderHandlerActivity.this), "HtmlViewer");
                myWebView.setWebViewClient(new WebViewClient() {
                    @Override
                    public void onPageFinished(WebView view, String url) {
                        myWebView.loadUrl("javascript:HtmlViewer.showHTML" +
                                "('<html>'+document.getElementsByTagName('html')[0].innerHTML+'</html>');");
                    }
                });

                //Log.d("MainAcivity", "BroadcastReceiver::onReceive: 3");

                myWebView.setOnKeyListener(new View.OnKeyListener() {
                    @Override
                    public boolean onKey(View v, int keyCode, KeyEvent event) {
                        if (event.getAction() == KeyEvent.ACTION_DOWN) {
                            WebView webView = (WebView) v;
                            switch (keyCode) {
                                case KeyEvent.KEYCODE_BACK:
                                    if (webView.canGoBack()) {
                                        webView.goBack();
                                        return true;
                                    }
                                    break;
                            }
                        }
                        return false;
                    }
                });

                EditText barcodeTxt = (EditText) findViewById(R.id.barcodeTxt);
                TextView textView = (TextView) findViewById(R.id.textView);
                TextView textView2 = (TextView) findViewById(R.id.textView2);

                //Log.d("MainAcivity", "BroadcastReceiver::onReceive: 4");

                // User may have tapped the X on the camera window <CarlB 04-20-2018>
                if(barcode == null)
                {
                    // Set focus to the Text input and bail <CarlB 04-20-2018>
                    barcodeTxt.requestFocus();
                    return;
                 }

                myWebView.setVisibility(View.VISIBLE);
                barcodeTxt.setVisibility(View.INVISIBLE);
                btnSubmit.setVisibility(View.INVISIBLE);
                btnCancel.setVisibility(View.INVISIBLE);
                textView.setVisibility(View.INVISIBLE);
                textView2.setVisibility(View.INVISIBLE);
                btnCancelTransaction.setVisibility(View.VISIBLE);

                //Log.d("MainAcivity", "BroadcastReceiver::onReceive: 5");

                String Checkbox1_Checked = prfs.getString("Checkbox1_Checked", "");
                String Checkbox2_Checked = prfs.getString("Checkbox2_Checked", "");
                String Checkbox3_Checked = prfs.getString("Checkbox3_Checked", "");
                String Checkbox4_Checked = prfs.getString("Checkbox4_Checked", "");

                Toast.makeText(getApplicationContext(), "Processing Scan...", Toast.LENGTH_LONG).show();

                int optionsValue = 0;
                if (Boolean.parseBoolean(Checkbox1_Checked.toString())) {
                    optionsValue += 4;
                }
                if (Boolean.parseBoolean(Checkbox2_Checked.toString())) {
                    optionsValue += 2;
                }
                if (Boolean.parseBoolean(Checkbox3_Checked.toString())) {
                    optionsValue += 1;
                }
                if (Boolean.parseBoolean(Checkbox4_Checked.toString())) {
                    optionsValue += 8;
                }

                //Log.d("MainAcivity", "BroadcastReceiver::onReceive: 6");

                if (optionsValue == 0)
                    optionsValue = 9;

                if (str_storeID.length() == 0) {
                    //Test mode, load the store details for test mode..
                    str_storeID = "99429833";
                    str_storePassword = "CM3966Z898";
                }

                //Log.d("MainAcivity", "BroadcastReceiver::onReceive: 7");

                c_strAndroid_ID = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);

                String l_strURL = c_strCyberCouponsHost + "/processtransaction.aspx?POSID=" + c_strPOSID + "&options=" + optionsValue + "&totalBill=" + (double) amount / 100 + "&c_orderID=" + c_strOrderID + "&c_merchantID=" + merchantId + "&c_accessToken=" + str_accessToken + "&storeID=" + str_storeID + "&storePassword=" + str_storePassword + "&barcode=" + barcode + "&android_id=" + c_strAndroid_ID;

                //Log.d("MainAcivity", "BroadcastReceiver::onReceive: l_strURL=" + l_strURL);

                myWebView.loadUrl(l_strURL);

                //Log.d("MainAcivity", "BroadcastReceiver::onReceive: 8");
                Log.d("MainAcivity", "BroadcastReceiver::onReceive: FINISH");
            }
            catch(final Exception ex)
            {
                Log.d("MainAcivity", "BroadcastReceiver: Exception=" + ex.getMessage());
                SendCloverStackTrace(URLEncoder.encode(Log.getStackTraceString(ex)));

                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), "OPT-IN Rewards: Tender.BroadcastReceiver.onReceive Exception=" + ex.getMessage(), Toast.LENGTH_LONG).show();
                        ex.printStackTrace();
                    }
                });

                Log.d("MainAcivity", "BroadcastReceiver::onReceive: FINISH");
            }
      }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        try {

            // Change to our Test Site if the app is in Debug mode <Carlb 11-16-2017>
            if (BuildConfig.DEBUG) {
                c_strCyberCouponsHost = c_strCyberCouponsHost.replace("www.", "test.");
            }


            c_strPOSID = c_strCloverStation; // Default to Clover Station, in case it's the Asus (Dev Device).

            // Determine the POS ID
            if (Platform.isCloverStation()) {
                c_strPOSID = c_strCloverStation;
            } else if (Platform.isCloverMini()) {
                c_strPOSID = c_strCloverMini;
            } else if (Platform.isCloverMobile()) {
                c_strPOSID = c_strCloverMobile;
            }

            super.onCreate(savedInstanceState);

            Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler(this));

            setContentView(R.layout.activity_tenderhandler_test);

            // Cause Exception (Test Only)
            //btnSubmit.setText("Crash!");

            btnSubmit = (Button) findViewById(R.id.btnSubmit);
            btnCancel = (Button) findViewById(R.id.btnCancel);
            btnCancelTransaction = (Button) findViewById(R.id.btnCancelTransaction);
            btnTransactionComplete = (Button) findViewById(R.id.btnTransactionComplete);
            EditText barcodeTxt = (EditText) findViewById(R.id.barcodeTxt);

            btnSubmit.setOnClickListener(this);
            btnCancel.setOnClickListener(this);
            btnCancelTransaction.setOnClickListener(this);
            btnTransactionComplete.setOnClickListener(this);

            //if they haven't set their storeID and storePassword make them set it, this needs updating
            SharedPreferences prfs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
            String str_storeID = prfs.getString("Store_ID", "");
            String str_storePassword = prfs.getString("Store_Password", "");
            lastOrderId = prfs.getString("Last_Order_ID", "");
            SharedPreferences preferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("StartPage", "tender");
            editor.apply();
            if (str_storeID.length() == 0 && str_storePassword.length() == 0) {
                Toast.makeText(getApplicationContext(), "Test Mode. Set Up An Account By Clicking The Merchant Dashboard Button On The Home Screen.", Toast.LENGTH_LONG).show();
                Intent intent = getIntent();
                //https://www.clover.com/reference/android/javadoc/constant-values.html
                if (intent.getAction().equals("clover.intent.action.PAY")) {

                    amount = intent.getLongExtra("clover.intent.extra.AMOUNT", 0l);
                    taxamount = intent.getLongExtra("clover.intent.extra.TAX_AMOUNT", 0l);
                    c_strOrderID = intent.getStringExtra("clover.intent.extra.ORDER_ID");
                    merchantId = intent.getStringExtra("clover.intent.extra.MERCHANT_ID");

                    if (!lastOrderId.equals(c_strOrderID))
                    {
                        //that's nice, lets get the barcode scan first....

                        // Call the Barcode Camera, if we have it enabled (ASUS test device does not have the camera scanner)
                        if (iBarcodeScanner == 1) {
                            Toast.makeText(getApplicationContext(), "Please Scan Card", Toast.LENGTH_LONG).show();
                            mBarcodeScanner = new BarcodeScanner(this);
                            try {
                                Bundle extras = new Bundle();
                                extras.putBoolean(Intents.EXTRA_LED_ON, true);
                                extras.putBoolean(Intents.EXTRA_SCAN_QR_CODE, true);
                                extras.putBoolean(Intents.EXTRA_SCAN_1D_CODE, true);
                                mBarcodeScanner.executeStartScan(extras);
                                barcodeTxt.setOnFocusChangeListener(new OnFocusChangeListener() {
                                    @Override
                                    public void onFocusChange(View v, boolean hasFocus) {
                                        if (hasFocus) {
                                            Bundle extras1 = new Bundle();
                                            mBarcodeScanner.stopScan(extras1);
                                        }

                                    }
                                });
                            } catch (Exception e) {

                            }
                        }

                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "An OPT-IN Discount has already been applied to this order.", Toast.LENGTH_LONG).show();
                        Intent intent2 = new Intent("com.clover.intent.action.START_REGISTER");
                        setResult(Activity.RESULT_OK, intent2);
                        if(c_OrderConnector.isConnected() == true)
                        {
                            c_OrderConnector.disconnect();
                        }
                        finish();
                    }
                }
            } else {
                Intent intent = getIntent();
                //https://www.clover.com/reference/android/javadoc/constant-values.html
                if (intent.getAction().equals("clover.intent.action.PAY"))
                {
                    if (!lastOrderId.equals(c_strOrderID))
                    {

                        amount = intent.getLongExtra("clover.intent.extra.AMOUNT", 0l);
                        taxamount = intent.getLongExtra("clover.intent.extra.TAX_AMOUNT", 0);
                        c_strOrderID = intent.getStringExtra("clover.intent.extra.ORDER_ID");
                        merchantId = intent.getStringExtra("clover.intent.extra.MERCHANT_ID");

                        //final Order order = getIntent().getParcelableExtra("clover.intent.extra.EXTRA_ORDER");
                        //amount = intent.getLongExtra("AMOUNT", 0l);
                        //c_strOrderID = intent.getStringExtra("ORDER_ID");
                        //merchantId = intent.getStringExtra("MERCHANT_ID");

                        new Thread(new Runnable() {
                            String l_strException = "";

                            public void run()
                            {
                                if(c_OrderConnector == null)
                                {
                                    c_OrderConnector = new OrderConnector(TenderHandlerActivity.this, CloverAccount.getAccount(TenderHandlerActivity.this), null);
                                }
                                if(c_OrderConnector.isConnected() == false) {
                                    c_OrderConnector.connect();
                                }
                                //while(c_OrderConnector.isConnected() == false)
                                //{
                                    try {
                                        c_OrderConnector.wait(SERVICE_CONNECTION_TIMEOUT);
                                    } catch (InterruptedException e) {
                                        Log.i("", "waitForConnection interrupted...");
                                        return;
                                    }
                                    //c_OrderConnector.connect();
                                //}
                                try
                                {
                                    if(c_OrderConnector.isConnected() == false) {
                                        c_Order = c_OrderConnector.getOrder(c_strOrderID);
                                    }
                                }
                                catch (RemoteException re)
                                {
                                    Toast.makeText(getApplicationContext(), "OPT-IN Rewards: OnCreate OrderConnector. RemoteException=" + re.getMessage(), Toast.LENGTH_LONG).show();
                                }
                                catch (ServiceException se)
                                {
                                    Toast.makeText(getApplicationContext(), "OPT-IN Rewards: OnCreate OrderConnector. ServiceException=" + se.getMessage(), Toast.LENGTH_LONG).show();
                                }
                                catch(BindingException be)
                                {
                                    Toast.makeText(getApplicationContext(), "OPT-IN Rewards: OnCreate OrderConnector. BindingException=" + be.getMessage(), Toast.LENGTH_LONG).show();
                                }
                                catch (ClientException ce)
                                {
                                    Toast.makeText(getApplicationContext(), "OPT-IN Rewards: OnCreate OrderConnector. ClientException=" + ce.getMessage(), Toast.LENGTH_LONG).show();
                                }
                            }
                        }).start();

                        // Call the Barcode Camera, if we have it enabled (ASUS test device does not have the camera scanner)
                        if (iBarcodeScanner == 1) {
                            Toast.makeText(getApplicationContext(), "Please Scan Card", Toast.LENGTH_LONG).show();
                            try {
                                mBarcodeScanner = new BarcodeScanner(this);
                                Bundle extras = new Bundle();
                                extras.putBoolean(Intents.EXTRA_LED_ON, true);
                                extras.putBoolean(Intents.EXTRA_SCAN_QR_CODE, true);
                                extras.putBoolean(Intents.EXTRA_SCAN_1D_CODE, true);
                                mBarcodeScanner.executeStartScan(extras);
                                barcodeTxt.setOnFocusChangeListener(
                                        new OnFocusChangeListener() {
                                            @Override
                                            public void onFocusChange(View v, boolean hasFocus) {
                                                if (hasFocus) {
                                                    Bundle extras1 = new Bundle();
                                                    mBarcodeScanner.stopScan(extras1);
                                                }
                                            }
                                        });
                            } catch (Exception ex) {
                                SendCloverStackTrace(URLEncoder.encode(Log.getStackTraceString(ex)));
                            }
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "An OPT-IN Discount has already been applied to this order.", Toast.LENGTH_LONG).show();
                        Intent intent2 = new Intent("com.clover.intent.action.START_REGISTER");
                        setResult(Activity.RESULT_OK, intent2);
                        if(c_OrderConnector.isConnected() == true)
                        {
                            c_OrderConnector.disconnect();
                        }
                        finish();
                    }
                }
            }

        }
        catch(final Exception ex)
        {
            SendCloverStackTrace(URLEncoder.encode(Log.getStackTraceString(ex)));

            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(), "OPT-IN Rewards: Tender.onCreate Exception=" + ex.getMessage(), Toast.LENGTH_LONG).show();
                    ex.printStackTrace();
                }
            });


        }
    }


    public void onClick(View v)
    {
        try {
            switch (v.getId()) {
                case R.id.btnSubmit:
                    EditText barcodeTxt = (EditText) findViewById(R.id.barcodeTxt);
                    TextView textView = (TextView) findViewById(R.id.textView);
                    TextView textView2 = (TextView) findViewById(R.id.textView2);
                    SharedPreferences prfs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
                    String str_storeID = prfs.getString("Store_ID", "");
                    String str_storePassword = prfs.getString("Store_Password", "");
                    String str_accessToken = prfs.getString("Access_Token", "");
                    String Checkbox1_Checked = prfs.getString("Checkbox1_Checked", "");
                    String Checkbox2_Checked = prfs.getString("Checkbox2_Checked", "");
                    String Checkbox3_Checked = prfs.getString("Checkbox3_Checked", "");
                    String Checkbox4_Checked = prfs.getString("Checkbox4_Checked", "");

                    SharedPreferences preferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("StartPage", "tender");
                    editor.apply();

                    final WebView myWebView = (WebView) findViewById(R.id.webview);
                    myWebView.setWebChromeClient(new WebChromeClient());
                    myWebView.getSettings().setJavaScriptEnabled(true);
                    myWebView.getSettings().setPluginsEnabled(true);
                    myWebView.getSettings().setAllowFileAccess(true);
                    myWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
                    myWebView.addJavascriptInterface(new MyJavaScriptInterface(TenderHandlerActivity.this), "HtmlViewer");
                    myWebView.setWebViewClient(new WebViewClient() {
                        @Override
                        public void onPageFinished(WebView view, String url) {
                            myWebView.loadUrl("javascript:HtmlViewer.showHTML" +
                                    "('<html>'+document.getElementsByTagName('html')[0].innerHTML+'</html>');");
                        }
                    });

                    myWebView.setWebChromeClient(new WebChromeClient());

                    TextView barcode = (TextView) findViewById(R.id.barcodeTxt);

                    myWebView.setVisibility(View.VISIBLE);
                    barcodeTxt.setVisibility(View.INVISIBLE);
                    btnSubmit.setVisibility(View.INVISIBLE);
                    btnCancel.setVisibility(View.INVISIBLE);
                    textView.setVisibility(View.INVISIBLE);
                    textView2.setVisibility(View.INVISIBLE);
                    btnCancelTransaction.setVisibility(View.VISIBLE);

                    Bundle extras1 = new Bundle();

                    if (mBarcodeScanner != null) {
                        mBarcodeScanner.stopScan(extras1);
                    }

                    //Button 3 long OPTION_AllowQuickScan = 0x01;  //allows us to do a quick scan if all conditions are met
                    //Button 2 long OPTION_IgnoreGiftCard = 0x02;  //No gift card requirements for this transaction
                    //Button 1 long OPTION_IgnorePunches = 0x04;   //No punches required for this transaction
                    //Button 4 long OPTION_AllowPartialQuickScan = 0x08;  //auto select if only single offer but don't submit.
                    //Should be 8 + 1 = 9

                    int optionsValue = 0;
                    if (Boolean.parseBoolean(Checkbox1_Checked.toString())) {
                        optionsValue += 4;
                    }
                    if (Boolean.parseBoolean(Checkbox2_Checked.toString())) {
                        optionsValue += 2;
                    }
                    if (Boolean.parseBoolean(Checkbox3_Checked.toString())) {
                        optionsValue += 1;
                    }
                    if (Boolean.parseBoolean(Checkbox4_Checked.toString())) {
                        optionsValue += 8;
                    }

                    if (optionsValue == 0)
                        optionsValue = 9;

                    if (str_storeID.length() == 0)
                    {
                        //Test mode, load the store details for test mode..
                        str_storeID = "99429833";
                        str_storePassword = "CM3966Z898";
                    }

                    c_strAndroid_ID = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);

                    GetUntaxedAmount();

                    // I changed the HTTP to HTTPS as a customer got an error stating HTTP is not allowed <CarlB 05-19-2017>
                    String strURL = c_strCyberCouponsHost + "/processtransaction.aspx?POSID=11&options=" + optionsValue + "&totalBill=" + (double) amount / 100  + "&preTax=" + (double) untaxedamount / 100 + "&c_orderID=" + c_strOrderID + "&c_merchantID=" + merchantId + "&storeID=" + str_storeID + "&c_accessToken=" + str_accessToken + "&storePassword=" + str_storePassword + "&barcode=" + barcode.getText().toString() + "&android_id=" + c_strAndroid_ID;

                    myWebView.loadUrl(strURL);

                    //GiftCardTender l_CBQGiftCard = new GiftCardTender();
                    //l_CBQGiftCard.Init(getApplicationContext());

                    break;
                case R.id.btnCancel:
                    final Intent returnIntent = new Intent();
                    Bundle extras2 = new Bundle();
                    if (iBarcodeScanner == 1) {
                        mBarcodeScanner.stopScan(extras2);
                    }

                    getWindow().setSoftInputMode(
                            WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

                    setResult(Activity.RESULT_OK, returnIntent);
                    if(c_OrderConnector.isConnected() == true)
                    {
                        c_OrderConnector.disconnect();
                    }
                    finish();
                    break;
                case R.id.btnCancelTransaction:
                    //in the cancel state, just cancel it..
                    final Intent returnIntent2 = new Intent();
                    Bundle extras3 = new Bundle();
                    getWindow().setSoftInputMode(
                            WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

                    setResult(Activity.RESULT_OK, returnIntent2);
                    if(c_OrderConnector.isConnected() == true)
                    {
                        c_OrderConnector.disconnect();
                    }
                    finish();
                    break;
                case R.id.btnTransactionComplete:
                    //submit it..
                    int index1 = globalHTML.indexOf("#AMOUNT#") + 8;
                    int index2 = globalHTML.indexOf("#/AMOUNT#");

                    String stringholder = globalHTML.substring(index1, index2);
                    stringholder = stringholder.replace("build/intermediates/exploded-aar/com.clover.sdk/clover-android-sdk/86/res", "");

                    double theamount = Double.parseDouble(stringholder);
                    final double longamount = theamount;

                    Intent returnIntent3 = new Intent();
                    returnIntent3.putExtra("clover.intent.extra.AMOUNT", longamount);
                    SharedPreferences preferences2 = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor2 = preferences2.edit();
                    editor2.putString("Last_Order_ID", c_strOrderID);
                    editor2.apply();
                    setResult(Activity.RESULT_OK, returnIntent3);
                    if(c_OrderConnector.isConnected() == true)
                    {
                        c_OrderConnector.disconnect();
                    }
                    finish();
                    break;
            }
        }
        catch(final Exception ex)
        {
            SendCloverStackTrace(URLEncoder.encode(Log.getStackTraceString(ex)));

            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(), "OPT-IN Rewards: Tender.onClick Exception=" + ex.getMessage(), Toast.LENGTH_LONG).show();
                    ex.printStackTrace();
                }
            });



        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        try
        {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.main, menu);
        }
        catch(final Exception ex)
        {
            SendCloverStackTrace(URLEncoder.encode(Log.getStackTraceString(ex)));

            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(), "OPT-IN Rewards: Tender.onCreateOptionsMenu Exception=" + ex.getMessage(), Toast.LENGTH_LONG).show();
                    ex.printStackTrace();
                }
            });
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        try
        {
            switch (item.getItemId()) {
                case R.id.action_settings:
                    startActivity(new Intent(this, SettingsActivity.class));
                    return true;
                default:
                    return super.onOptionsItemSelected(item);
            }
        }
        catch(final Exception ex)
        {
            SendCloverStackTrace(URLEncoder.encode(Log.getStackTraceString(ex)));

            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(), "OPT-IN Rewards: Tender.onOptionsItemSelected Exception=" + ex.getMessage(), Toast.LENGTH_LONG).show();
                    ex.printStackTrace();
                }
            });

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume()
    {
        try
        {
            super.onResume();
            registerBarcodeScanner();
        }
        catch(final Exception ex)
        {
            SendCloverStackTrace(URLEncoder.encode(Log.getStackTraceString(ex)));

            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(), "OPT-IN Rewards: Tender.onResume Exception=" + ex.getMessage(), Toast.LENGTH_LONG).show();
                    ex.printStackTrace();
                }
            });
        }
    }

    @Override
    protected void onPause()
    {
        try
        {
            super.onPause();
            unregisterBarcodeScanner();
        }
        catch(final Exception ex)
        {
            SendCloverStackTrace(URLEncoder.encode(Log.getStackTraceString(ex)));

            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(), "OPT-IN Rewards: Tender.onPause Exception=" + ex.getMessage(), Toast.LENGTH_LONG).show();
                    ex.printStackTrace();
                }
            });


        }
    }

    private void registerBarcodeScanner()
    {
        try
        {
            //registerReceiver(barcodeReceiver, new IntentFilter("com.clover.stripes.BarcodeBroadcast"));

            // Clover changed their Broadcast IntentFilter (without telling us :( ) <CarlB 11-16-2017>
            registerReceiver(barcodeReceiver, new IntentFilter("com.clover.BarcodeBroadcast"));

        }
        catch(final Exception ex)
        {
            SendCloverStackTrace(URLEncoder.encode(Log.getStackTraceString(ex)));

            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(), "OPT-IN Rewards: Tender.registerBarcodeScanner Exception=" + ex.getMessage(), Toast.LENGTH_LONG).show();
                    ex.printStackTrace();
                }
            });


        }
    }

    private void unregisterBarcodeScanner()
    {
        try
        {
            unregisterReceiver(barcodeReceiver);
        }
        catch(final Exception ex)
        {
            SendCloverStackTrace(URLEncoder.encode(Log.getStackTraceString(ex)));

            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(), "OPT-IN Rewards: Tender.unregisterBarcodeScanner Exception=" + ex.getMessage(), Toast.LENGTH_LONG).show();
                    ex.printStackTrace();
                }
            });


        }
    }

    class MyJavaScriptInterface
    {
        private Context ctx;
        MyJavaScriptInterface(Context ctx) {
            this.ctx = ctx;
        }
        @JavascriptInterface
        public void showHTML(String html)
        {
            try
            {
                //new AlertDialog.Builder(ctx).setTitle("HTML").setMessage(html)
                //        .setPositiveButton(android.R.string.ok, null).setCancelable(false).create().show();
                if (html.contains("#FINISHED#")) {
                    if (html.indexOf("#AMOUNT#")> 0) {
                        //setButtonText();
                        _handler.post(_setButton);

                        returnToClover(html);
                    }
                }
            }
            catch(final Exception ex)
            {
                SendCloverStackTrace(URLEncoder.encode(Log.getStackTraceString(ex)));

                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), "OPT-IN Rewards: Tender.showHTML Exception=" + ex.getMessage(), Toast.LENGTH_LONG).show();
                        ex.printStackTrace();
                    }
                });


            }

        }

        final Runnable _setButton = new Runnable() {
            public void run() {
                try
                {
                    btnCancelTransaction.setVisibility(View.INVISIBLE);
                    btnTransactionComplete.setVisibility(View.VISIBLE);
                }
                catch(final Exception ex)
                {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(), "OPT-IN Rewards: Tender._setButton Exception=" + ex.getMessage(), Toast.LENGTH_LONG).show();
                            ex.printStackTrace();
                        }
                    });


                }
            }
        };

        public void returnToClover(String html)
        {
            try
            {
                globalHTML = html;
                final String localHTML = html;
                final Intent returnIntent = new Intent();

                int index1 = localHTML.indexOf("#AMOUNT#") + 8;
                int index2 = localHTML.indexOf("#/AMOUNT#");

                String stringholder = localHTML.substring(index1, index2);
                stringholder = stringholder.replace("build/intermediates/exploded-aar/com.clover.sdk/clover-android-sdk/86/res", "");

                //double theamount = double.parseInt(stringholder);
                //final long longamount = Long.valueOf(theamount);
                final long longamount = Long.valueOf(stringholder.replace(".", ""));

                // Do we have a Gift Card Pay-Off?
                if(localHTML.indexOf("#GCPAYOFF#") > 0)
                {
                    stringholder = localHTML.substring(localHTML.indexOf("#GCPAYOFF#") + 10);
                    stringholder = stringholder.substring(0, stringholder.indexOf("#/GCPAYOFF#"));
                    long l_gcamount = Long.valueOf(stringholder.replace(".", ""));
                    GiftCardPay(l_gcamount);
                }
                // Do we have a Gift Card Pay (partial payment)?
                if(localHTML.indexOf("#GCPAY#") > 0)
                {
                    stringholder = localHTML.substring(localHTML.indexOf("#GCPAY#") + 7);
                    stringholder = stringholder.substring(0, stringholder.indexOf("#/GCPAY#"));
                    long l_gcamount = Long.valueOf(stringholder.replace(".", ""));
                    GiftCardPay(l_gcamount);
                }

                SharedPreferences prfs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
                String str_timeout = prfs.getString("Timeout", "");
                String str_timeoutChecked = prfs.getString("Timeout_Checked", "");

                SharedPreferences preferences2 = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

                if (longamount > 0) {
                    SharedPreferences.Editor editor2 = preferences2.edit();
                    editor2.putString("Last_Order_ID", c_strOrderID);
                    editor2.apply();
                }
                setResult(Activity.RESULT_OK, returnIntent);
                if(c_OrderConnector.isConnected() == true)
                {
                    c_OrderConnector.disconnect();
                }
                finish();
            }
            catch(final Exception ex)
            {
                SendCloverStackTrace(URLEncoder.encode(Log.getStackTraceString(ex)));

                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        //Toast.makeText(getApplicationContext(), "OPT-IN Rewards: Tender.returnToClover Exception=" + ex.getMessage(), Toast.LENGTH_LONG).show();
                        ex.printStackTrace();
                        if(c_OrderConnector.isConnected() == true)
                        {
                            c_OrderConnector.disconnect();
                        }
                        finish();
                    }
                });
            }
        }

    }

    private void GiftCardPay(long p_lAmount)
    {
        try {
            LineItemPayment l_LineItemPayment = new LineItemPayment();

            l_LineItemPayment.setId("GiftCard");
            //l_LineItemPayment.setPercentage();
            l_LineItemPayment.setRefunded(false);

            setResult(RESULT_CANCELED);

            /**
             * @see Intents.ACTION_MERCHANT_TENDER
             */
            final long amount = getIntent().getLongExtra(Intents.EXTRA_AMOUNT, 0);
            final Currency currency = (Currency) getIntent().getSerializableExtra(Intents.EXTRA_CURRENCY);
            final long taxAmount = getIntent().getLongExtra(Intents.EXTRA_TAX_AMOUNT, 0);
            final ArrayList<Parcelable> taxableAmounts = getIntent().getParcelableArrayListExtra(Intents.EXTRA_TAXABLE_AMOUNTS);
            final ServiceChargeAmount serviceCharge = getIntent().getParcelableExtra(Intents.EXTRA_SERVICE_CHARGE_AMOUNT);

            //final String orderId = getIntent().getStringExtra(Intents.EXTRA_ORDER_ID);
            c_strOrderID = getIntent().getStringExtra(Intents.EXTRA_ORDER_ID);
            final String employeeId = getIntent().getStringExtra(Intents.EXTRA_EMPLOYEE_ID);
            final String merchantId = getIntent().getStringExtra(Intents.EXTRA_MERCHANT_ID);

            //final Tender tender = getIntent().getParcelableExtra(Intents.EXTRA_TENDER);

            // Merchant Facing specific fields
            //final Order order = getIntent().getParcelableExtra(Intents.EXTRA_ORDER);
            final String note = getIntent().getStringExtra(Intents.EXTRA_NOTE);

            Intent data = new Intent();
            data.putExtra(Intents.EXTRA_AMOUNT, p_lAmount);
            data.putExtra(Intents.EXTRA_CLIENT_ID, merchantId);
            data.putExtra(Intents.EXTRA_NOTE, "Gift Card Pay");
            data.putExtra(Intents.EXTRA_LINE_ITEM_IDS, "GC Pay-Off");
            data.putExtra(Intents.EXTRA_TITLE, "Gift Card Payment");
            data.putExtra(Intents.EXTRA_LINE_ITEM_PAYMENTS, l_LineItemPayment);

            setResult(RESULT_OK, data);
            if(c_OrderConnector.isConnected() == true)
            {
                c_OrderConnector.disconnect();
            }
            finish();
        }
        catch(final Exception ex)
        {
            SendCloverStackTrace(URLEncoder.encode(Log.getStackTraceString(ex)));

            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    //Toast.makeText(getApplicationContext(), "OPT-IN Rewards: Tender.GiftCardPay Exception=" + ex.getMessage(), Toast.LENGTH_LONG).show();
                    ex.printStackTrace();
                    if(c_OrderConnector.isConnected() == true)
                    {
                        c_OrderConnector.disconnect();
                    }
                    finish();
                }
            });
        }
    }

    private long GetUntaxedAmount()
    {
        untaxedamount = 0;
        if(c_Order != null) {
            c_OrderCalc = new OrderCalc(c_Order);
            if (c_OrderCalc != null) {
                taxamount = c_OrderCalc.getTax();

                untaxedamount = amount - taxamount;

                return untaxedamount;
            }

        }
        return untaxedamount;
    }

    void SendCloverStackTrace(String p_strExceptioMesssage)
    {
        String l_strURL = "";
        WebView myWebView = (WebView) findViewById(R.id.webview);

        //setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_settings);

        if(myWebView != null)
        {
            if(str_storeID == null || merchantId == null)
            {
                if(str_storeID == null && merchantId == null)
                {
                    l_strURL = c_strCyberCouponsHost + "/merchant/Login/CloverCallback.aspx?StoreID=0&MID=0&CloverStackTrace=" + p_strExceptioMesssage;
                }
                else
                {
                    if(str_storeID == null)
                    {
                        l_strURL = c_strCyberCouponsHost + "/merchant/Login/CloverCallback.aspx?StoreID=0&MID=" + merchantId + "&CloverStackTrace=" + p_strExceptioMesssage;
                    }
                    else
                    {
                        l_strURL = c_strCyberCouponsHost + "/merchant/Login/CloverCallback.aspx?StoreID=" + str_storeID + "&MID=0&CloverStackTrace=" + p_strExceptioMesssage;
                    }
                }
            }
            else
            {
                l_strURL = c_strCyberCouponsHost + "/merchant/Login/CloverCallback.aspx?StoreID=" + str_storeID + "&MID=" + merchantId + "&CloverStackTrace=" + p_strExceptioMesssage;
            }

            if(l_strURL != "")
            {
                myWebView.loadUrl(l_strURL);
            }
        }
    }
}

