package com.cybercoupons.rewards.android;

import android.accounts.Account;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.IInterface;
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
import util.CloverAuth;
import util.Platform;
import v1.BindingException;
import v1.ClientException;
import v1.ForbiddenException;
import v1.Intents;
import v1.ResultStatus;
import v1.ServiceConnector;
import v1.ServiceException;
//import v1.app.AppConnector;
import v1.merchant.MerchantConnector;
import v1.tender.Tender;
import v1.tender.TenderConnector;
import v3.apps.App;
import v3.base.TenderConstants;
import v3.order.Discount;
import v3.order.LineItem;
import v3.order.Order;
import v3.order.OrderCalc;
import v3.order.OrderConnector;
import v3.payments.LineItemPayment;
import v3.payments.Payment;
import v3.payments.ServiceChargeAmount;
import v3.scanner.BarcodeScanner;

import org.apache.http.util.EncodingUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

/**
 * Created by CarlB on 8/25/2016.
 */
public class GiftCardActivity extends Activity implements View.OnClickListener, ServiceConnector.OnServiceConnectedListener {
    private long c_lAmount;
    private Currency c_Currency;
    private String c_strOrderID;
    private String c_strLastOrderID;
    private String c_strMerchantID;
    private String c_strGlobalHTML;
    private int c_iBarcodeScanner = 1; // Use this to enable / disable the Scanner functionality (0=Disable, 1=Enable)
    //private CloverAuth c_CloverAuth;
    private CloverAuth.AuthResult c_AuthResult;
    private OrderConnector c_OrderConnector;
    private Order c_Order;
    private List<LineItem> c_LineItems;
    private MerchantConnector mMerchantDemographics;
    private Payment c_Payment;
    private TenderConnector c_TenderConnector;
    private Tender c_Tender;

    public static final String PREFS_NAME = "CyberPrefs";
    final Activity activity = this;

    private Account mAccount;
    private BarcodeScanner mBarcodeScanner;
    public static Button btnSubmit;
    public static Button btnCancel;
    public static Button btnCancelTransaction;
    public static Button btnTransactionComplete;
    final Handler _handler = new Handler();
    private String c_strCyberCouponsHost = "cybercoupons.com";
    private String c_strAndroid_ID;
    private String c_strPOSID;
    private String c_strCloverStation = "1";
    private String c_strCloverMini = "3";
    private String c_strCloverMobile = "4";

    public BroadcastReceiver barcodeReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            try {
                SharedPreferences prfs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
                String barcode = intent.getStringExtra("Barcode");
                String str_storeID = prfs.getString("Store_ID", "");
                String str_storePassword = prfs.getString("Store_Password", "");
                String str_accessToken = prfs.getString("Access_Token", "");

                SharedPreferences preferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("StartPage", "tender");
                editor.apply();

                final WebView myWebView = (WebView) findViewById(R.id.webview);
                myWebView.setWebChromeClient(new WebChromeClient());
                myWebView.getSettings().setJavaScriptEnabled(true);
                myWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
                myWebView.addJavascriptInterface(new MyJavaScriptInterface(GiftCardActivity.this), "HtmlViewer");
                myWebView.setWebViewClient(new WebViewClient() {
                    @Override
                    public void onPageFinished(WebView view, String url) {
                        myWebView.loadUrl("javascript:HtmlViewer.showHTML" +
                                "('<html>'+document.getElementsByTagName('html')[0].innerHTML+'</html>');");
                    }
                });

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

                myWebView.setVisibility(View.VISIBLE);
                barcodeTxt.setVisibility(View.INVISIBLE);
                btnSubmit.setVisibility(View.INVISIBLE);
                btnCancel.setVisibility(View.INVISIBLE);
                textView.setVisibility(View.INVISIBLE);
                textView2.setVisibility(View.INVISIBLE);
                btnCancelTransaction.setVisibility(View.VISIBLE);

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

                if (optionsValue == 0)
                    optionsValue = 9;

                if (str_storeID.length() == 0) {
                    //Test mode, load the store details for test mode..
                    str_storeID = "99429833";
                    str_storePassword = "CM3966Z898";
                }

                c_strAndroid_ID = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);

                String l_strURL = "http://" + c_strCyberCouponsHost + "/processtransaction.aspx?POSID=" + c_strPOSID + "&options=" + optionsValue + "&totalBill=" + (double) c_lAmount / 100 + "&c_orderID=" + c_strOrderID + "&c_merchantID=" + c_strMerchantID + "&c_accessToken=" + str_accessToken + "&storeID=" + str_storeID + "&storePassword=" + str_storePassword + "&barcode=" + barcode + "&android_id=" + c_strAndroid_ID;
                myWebView.loadUrl(l_strURL);
            }
            catch(final Exception ex)
            {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), "CyberCoupons Rewards: Tender.BroadcastReceiver.onReceive Exception=" + ex.getMessage(), Toast.LENGTH_LONG).show();
                        ex.printStackTrace();
                    }
                });




            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        String l_strException = "";
        Intent l_intent;

        try {

            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_gift_card);

            l_intent = getIntent();

            //c_lAmount = l_intent.getLongExtra("clover.intent.extra.AMOUNT", 0l);
            c_strOrderID = l_intent.getStringExtra("clover.intent.extra.ORDER_ID");
            //c_strMerchantID = l_intent.getStringExtra("clover.intent.extra.MERCHANT_ID");

            mAccount = CloverAccount.getAccount(this);
            if(mAccount != null)
            {
                mMerchantDemographics = new MerchantConnector(this, mAccount, null);
                mMerchantDemographics.connect();
            }

            new Thread(new Runnable() {

                String l_strException = "";

                public void run()
                {
                    try {
                        //v3.order.Order o = c_OrderConnector.getOrder(c_strOrderID);
                        //OrderCalc oc = new OrderCalc(o);
                        //long tax = oc.getTax();
                        //long subtotal = oc.getLineSubtotal(o.getLineItems());

                        if(mMerchantDemographics != null)
                        {
                 //           c_strMerchantID = mMerchantDemographics.getMerchant().getId();
                        }

                        if(c_OrderConnector == null)
                        {
                            c_OrderConnector = new OrderConnector(GiftCardActivity.this, CloverAccount.getAccount(GiftCardActivity.this), null);
                        }
                        c_OrderConnector.connect();
                        while(c_OrderConnector.isConnected() == false)
                        {
                            //c_OrderConnector.wait(500);
                            c_OrderConnector.connect();
                        }

                        c_Order = c_OrderConnector.getOrder(c_strOrderID);
                        if(c_Order != null)
                        {
                            Intent l_intent;

                            c_lAmount = c_Order.getTotal();
                            c_LineItems = c_Order.getLineItems();

                            l_intent = new Intent(GiftCardActivity.this, TenderHandlerActivity.class);
                            l_intent.setAction("clover.intent.action.PAY");
                            //l_intent.setAction("clover.intent.action.MERCHANT_TENDER");

                            l_intent.putExtra("AMOUNT", c_lAmount);
                            //l_intent.putExtra(Intents.EXTRA_CURRENCY, c_Currency);
                            l_intent.putExtra("ORDER_ID", c_strOrderID);
                            l_intent.putExtra("MERCHANT_ID", c_strMerchantID);

                            GiftCardActivity.this.startActivity(l_intent);
                        }
                    }
                    catch (Exception ex)
                    {
                        l_strException = ex.getMessage();
                        Toast.makeText(getApplicationContext(), "CyberCoupons Rewards: c_OrderConnector.getOrder Exception=" + l_strException, Toast.LENGTH_LONG).show();
                    }
                }
            }).start();


            /*
            l_intent.putExtra("EXTRA_AMOUNT", c_lAmount);
            //l_intent.putExtra(Intents.EXTRA_CURRENCY, c_Currency);
            l_intent.putExtra("ORDER_ID", c_strOrderID);
            l_intent.putExtra("MERCHANT_ID", c_strMerchantID);
            */

            /*
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

            setContentView(R.layout.activity_gift_card);

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
            c_strLastOrderID = prfs.getString("Last_Order_ID", "");
            SharedPreferences preferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("StartPage", "tender");
            editor.apply();
            if (str_storeID.length() == 0 && str_storePassword.length() == 0) {
                Toast.makeText(getApplicationContext(), "Test Mode. Set Up An Account By Clicking The Merchant Dashboard Button On The Home Screen.", Toast.LENGTH_LONG).show();
                Intent intent = getIntent();
                //https://www.clover.com/reference/android/javadoc/constant-values.html
                if (intent.getAction().equals("clover.intent.action.PAY")) {

                    c_lAmount = intent.getLongExtra("clover.intent.extra.AMOUNT", 0l);
                    c_strOrderID = intent.getStringExtra("clover.intent.extra.ORDER_ID");
                    c_strMerchantID = intent.getStringExtra("clover.intent.extra.MERCHANT_ID");

                    if (!c_strLastOrderID.equals(c_strOrderID))
                    {
                        //that's nice, lets get the barcode scan first....

                        // Call the Barcode Camera, if we have it enabled (ASUS test device does not have the camera scanner)
                        if (c_iBarcodeScanner == 1) {
                            Toast.makeText(getApplicationContext(), "Please Scan Card", Toast.LENGTH_LONG).show();
                            mBarcodeScanner = new BarcodeScanner(this);
                            try {
                                Bundle extras = new Bundle();
                                extras.putBoolean(Intents.EXTRA_LED_ON, true);
                                extras.putBoolean(Intents.EXTRA_SCAN_QR_CODE, true);
                                extras.putBoolean(Intents.EXTRA_SCAN_1D_CODE, true);
                                mBarcodeScanner.executeStartScan(extras);
                                barcodeTxt.setOnFocusChangeListener(new View.OnFocusChangeListener()
                                {
                                    @Override
                                    public void onFocusChange(View v, boolean hasFocus)
                                    {
                                        if (hasFocus)
                                        {
                                            Bundle extras1 = new Bundle();
                                            mBarcodeScanner.stopScan(extras1);
                                        }

                                    }
                                });
                            }
                            catch (Exception e)
                            {

                            }
                        }
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "A CyberCoupons Discount has already been applied to this order.", Toast.LENGTH_LONG).show();
                        Intent intent2 = new Intent("com.clover.intent.action.START_REGISTER");
                        setResult(Activity.RESULT_OK, intent2);
                        finish();
                    }
                }
            } else {
                Intent intent = getIntent();
                //https://www.clover.com/reference/android/javadoc/constant-values.html
                if (intent.getAction().equals("clover.intent.action.MODIFY_ORDER"))
                {
                    if (!c_strLastOrderID.equals(c_strOrderID))
                    {
                        c_lAmount = intent.getLongExtra("clover.intent.extra.AMOUNT", 0l);
                        c_strOrderID = intent.getStringExtra("clover.intent.extra.ORDER_ID");
                        c_strMerchantID = intent.getStringExtra("clover.intent.extra.MERCHANT_ID");

                        mAccount = CloverAccount.getAccount(this);
                        if(mAccount != null)
                        {
                            mMerchantDemographics = new MerchantConnector(this, mAccount, null);
                            mMerchantDemographics.connect();
                        }


                        if(c_AuthResult == null)
                        {
                            new Thread(new Runnable() {

                                String l_strException = "";

                                public void run()
                                {
                                    try
                                    {
                                        c_AuthResult = CloverAuth.authenticate(GiftCardActivity.this, mAccount);
                                    }
                                    catch (IOException ix)
                                    {
                                        l_strException = ix.getMessage();
                                    }
                                    catch (OperationCanceledException ox)
                                    {
                                        l_strException = ox.getMessage();
                                    }
                                    catch (AuthenticatorException ax)
                                    {
                                        l_strException = ax.getMessage();
                                    }
                                    if(l_strException != "")
                                    {
                                        l_strException += "!";
                                    }
                                }
                            }).start();
                        }

                        c_OrderConnector = new OrderConnector(GiftCardActivity.this, CloverAccount.getAccount(GiftCardActivity.this), null);
                        if(c_OrderConnector != null)
                        {
                            c_OrderConnector.connect();

                            if(c_TenderConnector == null)
                            {
                                c_TenderConnector = new TenderConnector(this, mAccount, this);
                                c_TenderConnector.connect();
                            }

                            new Thread(new Runnable() {

                                String l_strException = "";

                                public void run() {
                                   try
                                    {
                                        if(mMerchantDemographics != null)
                                        {
                                            c_strMerchantID = mMerchantDemographics.getMerchant().getId();
                                        }

                                        c_Order = c_OrderConnector.getOrder(c_strOrderID);
                                        if(c_Order != null)
                                        {
                                            c_lAmount = c_Order.getTotal();
                                            c_LineItems = c_Order.getLineItems();
                                        }
                                    }
                                    catch (RemoteException rx)
                                    {
                                        l_strException += "\r\nRemote Exception: " + rx.getMessage();
                                    }
                                    catch (ServiceException sx)
                                    {
                                        l_strException += "\r\nService Exception: " + sx.getMessage();

                                    }
                                    catch (BindingException bx)
                                    {
                                        l_strException += "\r\nBinding Exception: " + bx.getMessage();
                                    }
                                    catch(ClientException cx)
                                    {
                                        l_strException += "\r\nClient Exception: " + cx.getMessage();
                                    }
                                    if(l_strException != "")
                                    {
                                        l_strException += "!";
                                    }
                                }
                            }).start() ;
                        }

                        // Call the Barcode Camera, if we have it enabled (ASUS test device does not have the camera scanner)
                        if (c_iBarcodeScanner == 1)
                        {
                            Toast.makeText(getApplicationContext(), "Please Scan Card", Toast.LENGTH_LONG).show();
                            try
                            {
                                mBarcodeScanner = new BarcodeScanner(this);
                                Bundle extras = new Bundle();
                                extras.putBoolean(Intents.EXTRA_LED_ON, true);
                                extras.putBoolean(Intents.EXTRA_SCAN_QR_CODE, true);
                                extras.putBoolean(Intents.EXTRA_SCAN_1D_CODE, true);
                                mBarcodeScanner.executeStartScan(extras);
                                barcodeTxt.setOnFocusChangeListener(
                                        new View.OnFocusChangeListener() {
                                            @Override
                                            public void onFocusChange(View v, boolean hasFocus) {
                                                if (hasFocus) {
                                                    Bundle extras1 = new Bundle();
                                                    mBarcodeScanner.stopScan(extras1);
                                                }
                                            }
                                        });
                            }
                            catch (Exception e) {

                            }
                        }
                    } else
                    {
                        Toast.makeText(getApplicationContext(), "A CyberCoupons Discount has already been applied to this order.", Toast.LENGTH_LONG).show();
                        Intent intent2 = new Intent("com.clover.intent.action.START_REGISTER");
                        setResult(Activity.RESULT_OK, intent2);
                        finish();
                    }
                }
            }

            //if(c_TenderConnector.isConnected() == true)
            //{
                getTenders();
            //}
            */

            finish();
        }
        catch(final Exception ex)
        {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(), "CyberCoupons Rewards: Tender.onCreate Exception=" + ex.getMessage(), Toast.LENGTH_LONG).show();
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
              //      myWebView.getSettings().setPluginsEnabled(true);
                    myWebView.getSettings().setAllowFileAccess(true);
                    myWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
                    myWebView.addJavascriptInterface(new MyJavaScriptInterface(GiftCardActivity.this), "HtmlViewer");
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

                    if (str_storeID.length() == 0) {
                        //Test mode, load the store details for test mode..
                        str_storeID = "99429833";
                        str_storePassword = "CM3966Z898";
                    }

                    c_strAndroid_ID = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);

                    String strURL = "http://" + c_strCyberCouponsHost + "/processtransaction.aspx?POSID=11&options=" + optionsValue + "&totalBill=" + (double) c_lAmount / 100 + "&c_orderID=" + c_strOrderID + "&c_merchantID=" + c_strMerchantID + "&storeID=" + str_storeID + "&c_accessToken=" + str_accessToken + "&storePassword=" + str_storePassword + "&barcode=" + barcode.getText().toString() + "&android_id=" + "&android_id=" + c_strAndroid_ID;

                    final WebView l_WebView = (WebView) findViewById(R.id.webview);
                    l_WebView.loadUrl(strURL);

                    //GiftCardTender l_CBQGiftCard = new GiftCardTender();
                    //l_CBQGiftCard.Init(getApplicationContext());

                    InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                    imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);

                    break;
                case R.id.btnCancel:
                    final Intent returnIntent = new Intent();
                    Bundle extras2 = new Bundle();
                    if (c_iBarcodeScanner == 1)
                    {
                        if(mBarcodeScanner != null)
                        {
                            mBarcodeScanner.stopScan(extras2);
                        }
                    }

                    getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

                    setResult(Activity.RESULT_OK, returnIntent);
                    finish();
                    break;
                case R.id.btnCancelTransaction:
                    //in the cancel state, just cancel it..
                    final Intent returnIntent2 = new Intent();
                    Bundle extras3 = new Bundle();
                    getWindow().setSoftInputMode(
                            WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

                    setResult(Activity.RESULT_OK, returnIntent2);
                    finish();
                    break;
                case R.id.btnTransactionComplete:
                    //submit it..
                    int index1 = c_strGlobalHTML.indexOf("#AMOUNT#") + 8;
                    int index2 = c_strGlobalHTML.indexOf("#/AMOUNT#");

                    String stringholder = c_strGlobalHTML.substring(index1, index2);
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
                    finish();
                    break;
            }
        }
        catch(final Exception ex)
        {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(), "CyberCoupons Rewards: Tender.onClick Exception=" + ex.getMessage(), Toast.LENGTH_LONG).show();
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
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(), "CyberCoupons Rewards: Tender.onCreateOptionsMenu Exception=" + ex.getMessage(), Toast.LENGTH_LONG).show();
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
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(), "CyberCoupons Rewards: Tender.onOptionsItemSelected Exception=" + ex.getMessage(), Toast.LENGTH_LONG).show();
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
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(), "CyberCoupons Rewards: Tender.onResume Exception=" + ex.getMessage(), Toast.LENGTH_LONG).show();
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
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(), "CyberCoupons Rewards: Tender.onPause Exception=" + ex.getMessage(), Toast.LENGTH_LONG).show();
                    ex.printStackTrace();
                }
            });


        }
    }

    private void registerBarcodeScanner()
    {
        try
        {
            registerReceiver(barcodeReceiver, new IntentFilter("com.clover.stripes.BarcodeBroadcast"));
        }
        catch(final Exception ex)
        {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(), "CyberCoupons Rewards: Tender.registerBarcodeScanner Exception=" + ex.getMessage(), Toast.LENGTH_LONG).show();
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
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(), "CyberCoupons Rewards: Tender.unregisterBarcodeScanner Exception=" + ex.getMessage(), Toast.LENGTH_LONG).show();
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
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), "CyberCoupons Rewards: Tender.showHTML Exception=" + ex.getMessage(), Toast.LENGTH_LONG).show();
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
                            Toast.makeText(getApplicationContext(), "CyberCoupons Rewards: Tender._setButton Exception=" + ex.getMessage(), Toast.LENGTH_LONG).show();
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
                c_strGlobalHTML = html;
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
                finish();
            }
            catch(final Exception ex)
            {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), "CyberCoupons Rewards: Tender.returnToClover Exception=" + ex.getMessage(), Toast.LENGTH_LONG).show();
                        ex.printStackTrace();
                        finish();
                    }
                });
            }
        }

    }

    private void GiftCardPay(long p_lAmount)
    {
        String l_strException = "";

        try
        {
            /*
            c_Payment = new Payment();

            if(c_Payment != null)
            {
                c_Payment.setAmount(p_lAmount);
                c_Payment.setNote("OPT-IN Gift Card");
                c_Payment.setOrder(c_Order.getDevice());
                c_OrderConnector.addPayment(c_strOrderID, c_Payment, c_LineItems);
                c_OrderConnector.fire(c_strOrderID);
                c_OrderConnector.disconnect();
            }
            */



            /*
            String l_strPaymentURI = "/v3/merchants/" + c_strMerchantID + "/orders/" + c_strOrderID + "/payments";
            String l_strURL = c_AuthResult.baseUrl + l_strPaymentURI +"?access_token=" + c_AuthResult.authToken;
            String l_strPostData = "";
            l_strPostData = "{";
            l_strPostData += "\"amount\": -" + p_lAmount + ",";
            l_strPostData += "\"tender\": {\"visible\":false,\"editable\":false,\"id\": \"XRM7EF5XP61P8\",\"label\": \"External Gift Card\",\"labelKey\": \"com.clover.tender.external_gift_card\",\"opensCashDrawer\": false,\"supportsTipping\": false,\"enabled\": false),";
            l_strPostData += "\"employee\": {\"id\": \"7N99YV47R6QV8\"},";
            l_strPostData += "\"createTime\": 1472583457000,";
            l_strPostData += "\"taxAmount\": 0,";
            l_strPostData += "\"order\": {\"id\": \"SSTC06SBD4F24\"},";
            l_strPostData += "}";
            final WebView l_WebView = (WebView) findViewById(R.id.webview);
            l_WebView.postUrl(l_strURL, EncodingUtils.getBytes(l_strPostData, "UTF-8"));
            */
            //        postData = "{";
            //        postData += @"""amount"": -" + l_lDiscount.ToString() + ",";
            //        postData += @"""name"": ""Gift Card""";
            //        postData += "}";



            /*
            v3.base.Tender l_Tender;
            c_Payment = new Payment();
            if(c_Payment != null)
            {
                l_Tender = new v3.base.Tender();

                l_Tender.setEnabled(c_Tender.getEnabled());
                l_Tender.setId(c_Tender.getId());
                l_Tender.setLabel(c_Tender.getLabel());
                l_Tender.setLabelKey(c_Tender.getLabelKey());
                l_Tender.setOpensCashDrawer(c_Tender.getOpensCashDrawer());
                l_Tender.setSupportsTipping(c_Tender.getSupportsTipping());

                c_Payment.setAmount(p_lAmount);
                c_Payment.setNote("OPT-IN Gift Card");
                c_Payment.setOrder(c_Order.getDevice());
                c_Payment.setTender(l_Tender);
                c_OrderConnector.addPayment(c_strOrderID, c_Payment, c_LineItems);
                c_OrderConnector.fire(c_strOrderID);
                c_OrderConnector.disconnect();
            }
            */


        }
        catch (Exception ex)
        {
            l_strException = ex.getMessage();
        }

    }

    @Override
    public void onServiceConnected(ServiceConnector<? extends IInterface> serviceConnector) {
    }

    @Override
    public void onServiceDisconnected(ServiceConnector<? extends IInterface> serviceConnector) {
    }

    /*private void getTenders() {
        c_TenderConnector.getTenders(new TenderConnector.TenderCallback<List<Tender>>() {
            @Override
            public void onServiceSuccess(List<Tender> result, ResultStatus status) {
                super.onServiceSuccess(result, status);
                String text = "Tenders:\n";
                for (Tender t : result)
                {
                    text += "  " + t.getId() + " , " + t.getLabel() + " , " + t.getLabelKey() + " , " + t.getEnabled() + " , " + t.getOpensCashDrawer() + "\n";
                    if (t.getLabelKey().equalsIgnoreCase(TenderConstants.CREDIT_CARD))
                    {
                        //c_Tender = getV3TenderFromV1(tender);
                        c_Tender = t;
                        break;
                    }
                }
                //resultText.setText(text);
            }

            @Override
            public void onServiceFailure(ResultStatus status) {
                super.onServiceFailure(status);
                //resultText.setText(status.getStatusMessage());
            }

            @Override
            public void onServiceConnectionFailure() {
                super.onServiceConnectionFailure();
                //resultText.setText("Service Connection Failure");
            }
        });
    }*/

}
