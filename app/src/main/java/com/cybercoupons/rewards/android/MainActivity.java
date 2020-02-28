package com.cybercoupons.rewards.android;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.SystemClock;
import android.provider.Settings.Secure;
import android.text.Html;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import util.CloverAccount;
import util.CloverAuth;
import util.Platform;
import v1.BindingException;
import v1.ClientException;
import v1.Intents;
import v1.ResultStatus;
import v1.ServiceException;
import v1.merchant.Merchant;
import v1.merchant.MerchantConnector;
import v1.tender.ITenderService;
import v1.tender.Tender;
import v1.tender.TenderConnector;
import v3.apps.App;
import v3.employees.Employee;
import v3.employees.EmployeeConnector;
import v3.order.Order;
import v3.payments.ServiceChargeAmount;

import java.net.URLEncoder;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Currency;
import java.util.Date;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class MainActivity extends Activity implements EmployeeConnector.OnActiveEmployeeChangedListener{
    private static final int REQUEST_ACCOUNT = 1;
    public static final int OAUTH_REQUEST_CODE = 2;

    private TenderConnector tenderConnector;
    private v3.base.Tender c_Tender;
    private EmployeeConnector mEmployeeConnector;
    private MerchantConnector mMerchantDemographics;
    private Account mMerchAccount;
    private CloverAuth.AuthResult mCloverAuth;
    private CloverAuth testauth;
    private TextView resultText;
    private String orderId;
    private String merchantId;
    public static final String PREFS_NAME = "CyberPrefs";
    private ValueCallback<Uri> mUploadMessage;
    private final static int FILECHOOSER_RESULTCODE=2;
    private String c_strAccountName;
    private String selectedImagePath;
    private String mOwnerName;
    private static String c_strOwnerEmail;
    //private String mOwnerId;
    private String mEmpID;
    private String mEmpName;
    private String mEmpEmail;
    public static String c_strMerchantID;
    private String mMerchName;
    private String mMerchAddr1;
    private String mMerchAddr2;
    private String mMerchAddr3;
    private String mMerchCity;
    private String mMerchState;
    private String mMerchZip;
    private String mMerchCountry;
    private String mMerchPhone;
    private static String c_strMerchantProvidedEmail;
    private String c_strAccessToken;
    public static String c_strStoreID = "";
    private WebView myWebView;
    private VideoView c_vvMain;
    private RelativeLayout c_llVideo;
    private com.cybercoupons.rewards.android.VideoController c_VideoController;
    public static ImageView c_imgSetup;
    private int i_FirstLoad;                                            // Indicates app's First Load (prevents reloading on Resume)
    public static String c_strCyberCouponsHost = "https://www.cybercoupons.com";
    private String c_strAndroidID = "";
    public SetupCategoryAdapter c_SetupCategoryAdapter;
    public static TextView c_tvSetup_Category_Items;
    public static GridView c_gvSetup_Category_Items;
    public static Button c_btnSetup_Continue;

    private String c_strPOSID;
    private ProgressBar c_ctrlActivityIndicator;

    public static final String ACCESS_TOKEN_KEY = "access_token";
    public static final String MERCHANT_ID_KEY = "merchant_id";
    public static final String EMPLOYEE_ID_KEY = "employee_id";

    /* The GTN's POS IDs as of 12/22/2015 <CarlB>
    public enum POSEnvironment
    {
        Unknown =0,
        Clover = 1,
        Poynt = 2,
        CloverMini = 3,
        CloverMobile = 4
    }
    */
    private String c_strCloverStation = "1";
    private String c_strCloverMini = "3";
    private String c_strCloverMobile = "4";
    private String c_strErrorLine = "";

    private PackageInfo c_pInfo;
    private String c_strAppVersion;
    private boolean c_bInternetConnected = false;
    private boolean c_bPopupShowing = false;
    private boolean c_bIsBlankPageLoaded = false;
    public static boolean c_bShowSetupVideo = false;
    public static boolean c_boolSetup = false;
    static AlertDialog.Builder DialogBuilder_Custom_Dialog;
    static View c_View_Custom_Dialog;
    LayoutInflater c_liCustomDialog;
    final Context c_Context = this;
    private static MenuItem c_miOptionsSettings = null;
    private static Menu c_OptionsMenu = null;
    public static boolean c_bDebugMode = false;

    public void AllCerts()
    {
        TrustManager[] trustAllCerts = new TrustManager[]
                { new X509TrustManager()
                {
                    public java.security.cert.X509Certificate[] getAcceptedIssuers()  { return null; }
                    public void checkClientTrusted( X509Certificate[] chain, String authType) {}
                    public void checkServerTrusted( X509Certificate[] chain, String authType) {}
                }
                };

        try
        {
            SSLContext sc = SSLContext.getInstance("SSL"); // "TLS" "SSL"
            sc.init( null, trustAllCerts, null);
            // sc.init( null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            HttpsURLConnection.setDefaultHostnameVerifier(
                    new HostnameVerifier()
                    {
                        public boolean verify( String hostname, SSLSession session) { return true; }
                    } );
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public void LoadWebWebView(final WebView myWebView, String accessToken)
    {
        try
        {
            c_strErrorLine = " (101)";
            String l_strURL;
            String android_id = Secure.getString(getContentResolver(), Secure.ANDROID_ID);

            c_strErrorLine = " (102)";

            if(accessToken == null)
            {
                return;
            }

            if (accessToken.length() > 0)
            {
                c_strErrorLine = " (103)";

                String l_strStoreID = "";
                String l_strMerchantID = "";
                String l_strEmployeeID = "";
                String l_strEmployeeEmail = "";
                String l_strMerchantName = "";
                String l_strEmployeeName = "";
                String l_strMerchantAddress1 = "";
                String l_strMerchantAddress2 = "";
                String l_strMerchantAddress3 = "";
                String l_strMerchantCity = "";
                String l_strMerchantState = "";
                String l_strMerchantZip = "";
                String l_strMerchantCountry = "";
                String l_strMerchantPhone = "";

                if(c_strStoreID != null)
                {
                    l_strStoreID = c_strStoreID;
                }
                if(c_strMerchantID != null)
                {
                    l_strMerchantID = c_strMerchantID;
                }
                if(mEmpID != null)
                {
                    l_strEmployeeID = mEmpID;
                }
                if(mEmpEmail != null)
                {
                    l_strEmployeeEmail = mEmpEmail;
                }
                if(android_id != null)
                {
                    c_strAndroidID = android_id;
                }
                if(mEmpName != null)
                {
                    l_strEmployeeName = mEmpName;
                }
                if(mMerchName != null)
                {
                    l_strMerchantName = mMerchName;
                }
                if(mMerchAddr1 != null)
                {
                    l_strMerchantAddress1 = mMerchAddr1;
                }
                if(mMerchAddr2 != null)
                {
                    l_strMerchantAddress2 = mMerchAddr2;
                }
                if(mMerchAddr3 != null)
                {
                    l_strMerchantAddress3 = mMerchAddr3;
                }
                if(mMerchCity != null)
                {
                    l_strMerchantCity = mMerchCity;
                }
                if(mMerchState != null)
                {
                    l_strMerchantState = mMerchState;
                }
                if(mMerchZip != null)
                {
                    l_strMerchantZip = mMerchZip;
                }
                if(mMerchCountry != null)
                {
                    l_strMerchantCountry = mMerchCountry;
                }
                if(mMerchPhone != null)
                {
                    l_strMerchantPhone = mMerchPhone;
                }

                //str_storeID = ""; // Test

                if (l_strStoreID.length() > 0)
                {
                    c_strErrorLine = " (104)";
                    if(c_strCyberCouponsHost.contains("test."))
                    {
                        l_strURL = c_strCyberCouponsHost + "/merchant/Login/CloverApp.aspx?POSID=" + c_strPOSID + "&token=" + accessToken + "&storeid=" + l_strStoreID + "&merchant_id=" + l_strMerchantID + "&employee_id=" + l_strEmployeeID + "&email=" + l_strEmployeeEmail + "&android_id=" + c_strAndroidID + "&app_version=" + c_strAppVersion + "&app_name=OPT-IN%20Rewards%20(Clover)";
                    }
                    else
                    {
                        l_strURL = c_strCyberCouponsHost + "/merchant/Login/CloverApp.aspx?POSID=" + c_strPOSID + "&token=" + accessToken + "&storeid=" + l_strStoreID + "&merchant_id=" + l_strMerchantID + "&employee_id=" + l_strEmployeeID + "&email=" + l_strEmployeeEmail + "&android_id=" + c_strAndroidID + "&app_version=" + c_strAppVersion + "&app_name=OPT-IN%20Rewards%20(Clover)";
                    }
                }
                else
                {
                    c_strErrorLine = " (104)";

                    c_boolSetup = true;
                    c_bShowSetupVideo = true;

                    LoadVideo("https://www.cybercoupons.com/vids/Clover/Clover_Overview.mp4");

                    //c_imgSetup.setVisibility(View.VISIBLE);
                    //c_tvSetup_Category_Items.setVisibility(View.VISIBLE);
                    //c_gvSetup_Category_Items.setVisibility(View.VISIBLE);
                    //c_btnSetup_Continue.setVisibility(View.VISIBLE);

                    // Turn off the Activity Indicator <CarlB 12-07-2017>
                    if (c_ctrlActivityIndicator != null) {
                        c_ctrlActivityIndicator.setVisibility(View.INVISIBLE);
                    }

                    c_btnSetup_Continue.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            try {
                                String l_strTmp = c_tvSetup_Category_Items.getText().toString();
                                if (l_strTmp.contains("Selected Industry:") == true) {
                                    //c_boolSetup = true;

                                    // Turn off the Activity Indicator <CarlB 12-07-2017>
                                    if (c_ctrlActivityIndicator != null) {
                                        c_ctrlActivityIndicator.setVisibility(View.VISIBLE);
                                    }

                                    c_imgSetup.setVisibility(View.INVISIBLE);
                                    c_tvSetup_Category_Items.setVisibility(View.INVISIBLE);
                                    c_gvSetup_Category_Items.setVisibility(View.INVISIBLE);
                                    c_btnSetup_Continue.setVisibility(View.INVISIBLE);

                                    myWebView.setVisibility(View.VISIBLE);

                                    CreateGTNAccount();
                                } else {
                                    //Toast.makeText(MainActivity.this, "Please Select Your Type Of Industry:", Toast.LENGTH_SHORT).show();
                                    ShowPopupMessage("Please Select Your Type Of Industry:", 5);
                                }
                            }
                            catch (Exception ex)
                            {
                                ex.printStackTrace();
                            }
                        }
                    });

                    return;

                }

                c_strErrorLine = " (105)";

                //myWebView.loadUrl(c_strSDCardBrowse);

                //myWebView.loadUrl("https://www.opt-inmedia.com/test/olo.html");

                if(c_bDebugMode ==  true) {
                    Log.d("MainAcivity", "LoadWebWebView: loadUrl(" + l_strURL + ")");
                }
                myWebView.loadUrl(l_strURL);

                //LoadVideo("https://vtiger.cybercoupons.com/mp4/Clover_Overview.mp4");
                //Log.d("MainAcivity", "LoadVideo");
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Unable to obtain a Merchant Account", Toast.LENGTH_LONG).show();
            }
        }
        catch(final Exception ex)
        {
            SendCloverStackTrace(URLEncoder.encode(Log.getStackTraceString(ex)));

            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(), "OPT-IN Rewards: LoadWebWebView Exception=" + ex.getMessage() + c_strErrorLine, Toast.LENGTH_LONG).show();
                    ex.printStackTrace();
                }
            });

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        try
        {
            c_strErrorLine = " (101)";
            c_strPOSID = c_strCloverStation; // Default to Clover Station, in case it's the Asus (Dev Device).
            // Determine the POS ID
            if (Platform.isCloverStation())
            {
                c_strPOSID = c_strCloverStation;
            }
            else if (Platform.isCloverMini())
            {
                c_strPOSID = c_strCloverMini;
            }
            else if (Platform.isCloverMobile())
            {
                c_strPOSID = c_strCloverMobile;
            }

            if(c_bInternetConnected == false)
            {
                c_bInternetConnected = IsInternetConnected();

                if(c_bInternetConnected == false) {
                    Toast.makeText(this, "The Internet is unavailable\nPlease Contact OPT-IN Rewards 253-333-6784", Toast.LENGTH_LONG).show();
                }
            }

            // Change to our Test Site if the app is in Debug mode <Carlb 11-16-2017>
            /*
            if (BuildConfig.DEBUG) {
                c_bDebugMode = true;
                c_strCyberCouponsHost = c_strCyberCouponsHost.replace("www.", "test.");
            }
            */

            SendAppVersion(); // Send the App Version Info to the Merchant Dashboard

            //c_pInfo.packageName.trim(); // Crash The App

            c_pInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            c_strAppVersion = c_pInfo.versionName;

            final AlertDialog.Builder adb = new AlertDialog.Builder(this);

            c_strErrorLine = " (102)"; // This helps pinpoint the last code execution before the error

            super.onCreate(savedInstanceState);

            i_FirstLoad = 1;

            // Cause an Exception
            //mMerchAccount.getClass(); // Testing

            //if they haven't set their storeID and storePassword make them set it
            /*
            c_strErrorLine = " (103)";
            SharedPreferences prfs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
            c_strErrorLine = " (104)";
            c_strStoreID = prfs.getString("Store_ID", "");
            c_strErrorLine = " (105)";
            String str_storePassword = prfs.getString("Store_Password", "");
            c_strErrorLine = " (106)";
            c_strAccessToken = prfs.getString("Access_Token", "");
            c_strErrorLine = " (107)";
            //SharedPreferences preferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
            c_strErrorLine = " (108)";
            SharedPreferences.Editor editor = prfs.edit();
            */

            //c_boolSetup = (c_strStoreID.trim().length() < 1);
            //c_bShowSetupVideo = c_boolSetup;

        c_strErrorLine = " (109)";
        if (mMerchAccount == null)
        {
            mMerchAccount = CloverAccount.getAccount(this);
            if(mMerchAccount != null) {
                c_strAccountName = mMerchAccount.name;
            }
        }

            c_strErrorLine = " (110)";
            if (mMerchAccount != null)
            {
                if(mEmployeeConnector == null) {
                    mEmployeeConnector = new EmployeeConnector(this, mMerchAccount, null);
                }
                if(mEmployeeConnector.isConnected() == false) {
                    mEmployeeConnector.connect();
                }
                if(mMerchantDemographics == null) {
                    mMerchantDemographics = new MerchantConnector(this, mMerchAccount, null);
                }
                if(mMerchantDemographics.isConnected() == false) {
                    mMerchantDemographics.connect();
                }
            }
            else
            {   // Try Again?
                mMerchAccount = CloverAccount.getAccount(this);
            }

            // Get the merchant object
            c_strErrorLine = " (111)";
            getMerchant();

            // Get Merchant Demographics
            c_strErrorLine = " (112)";
            getMerchantDemographics();

            //otherwise load the merchant dashboard.
            c_strErrorLine = " (113)";
            setContentView(R.layout.activity_main);

            c_strErrorLine = " (114)";
            myWebView = (WebView) findViewById(R.id.webview);
            c_strErrorLine = " (115)";
            WebSettings settings = myWebView.getSettings();
            c_strErrorLine = " (116)";
            myWebView.getSettings().setPluginsEnabled(true);
            c_strErrorLine = " (117)";
            myWebView.getSettings().setAllowFileAccess(true);
            c_strErrorLine = " (118)";
            myWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            myWebView.getSettings().setJavaScriptEnabled(true);

            //myWebView.getSettings().setSupportMultipleWindows(true); // This might help allow the Support Page to popup in a separate window.

            myWebView.addJavascriptInterface(new MyJavaScriptInterface(MainActivity.this), "HtmlViewer");

            myWebView.setOnKeyListener(new OnKeyListener() {
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
            myWebView.setWebChromeClient(new WebChromeClient() {
                //The undocumented magic method override
                //Eclipse will swear at you if you try to put @Override here
                // For Android 3.0+
                public void openFileChooser(ValueCallback<Uri> uploadMsg) {

                    mUploadMessage = uploadMsg;
                    Intent i = new Intent(Intent.ACTION_GET_CONTENT);
                    i.addCategory(Intent.CATEGORY_OPENABLE);
                    i.setType("image/*");
                    MainActivity.this.startActivityForResult(Intent.createChooser(i, "Select Picture"), FILECHOOSER_RESULTCODE);

                }

                // For Android 3.0+
                public void openFileChooser(ValueCallback uploadMsg, String acceptType) {
                    mUploadMessage = uploadMsg;
                    Intent i = new Intent(Intent.ACTION_GET_CONTENT);
                    i.addCategory(Intent.CATEGORY_OPENABLE);
                    i.setType("*/*");
                    MainActivity.this.startActivityForResult(
                            Intent.createChooser(i, "Select Picture"),
                            FILECHOOSER_RESULTCODE);
                }

                //For Android 4.1
                public void openFileChooser(ValueCallback<Uri> uploadMsg, String acceptType, String capture) {
                    mUploadMessage = uploadMsg;
                    Intent i = new Intent(Intent.ACTION_GET_CONTENT);
                    i.addCategory(Intent.CATEGORY_OPENABLE);
                    i.setType("image/*");
                    MainActivity.this.startActivityForResult(Intent.createChooser(i, "Select Picture"), MainActivity.FILECHOOSER_RESULTCODE);
                }
            });

            myWebView.setWebViewClient(new MyWebViewClient()
            {
                @Override
                public void onPageStarted(WebView view, String url, Bitmap favicon)
                {
                    // Show the Busy indicator
                    if (c_ctrlActivityIndicator != null)
                    {
                        c_ctrlActivityIndicator.setVisibility(View.VISIBLE);
                    }
                }

                @Override
                public void onPageFinished(WebView view, String url)
                {
                    // Hide the Busy indicator
                    if (c_ctrlActivityIndicator != null)
                    {
                        c_ctrlActivityIndicator.setVisibility(View.INVISIBLE);
                    }

                    myWebView.loadUrl("javascript:HtmlViewer.showHTML" +
                            "('<html>'+document.getElementsByTagName('html')[0].innerHTML+'</html>');");
                }


            });

            if (c_llVideo == null) {
                c_llVideo = (RelativeLayout) findViewById(R.id.llVideo);
            }
            if (c_vvMain == null) {
                c_vvMain = (VideoView) findViewById(R.id.vvMain);
            }

            if(c_gvSetup_Category_Items == null)
            {
                c_gvSetup_Category_Items = (GridView)findViewById(R.id.gvSetup_Category_Items);
            }
            if(c_tvSetup_Category_Items == null)
            {
                c_tvSetup_Category_Items = (TextView)findViewById(R.id.tvSetup_Category_Items);
            }

            if (c_SetupCategoryAdapter == null) {
                c_SetupCategoryAdapter = new SetupCategoryAdapter(this, c_gvSetup_Category_Items, this, myWebView);
                c_gvSetup_Category_Items.setAdapter(c_SetupCategoryAdapter);
            }

            if(c_btnSetup_Continue == null)
            {
                c_btnSetup_Continue = (Button)findViewById(R.id.btnSetup_Continue);
            }

            if (c_imgSetup == null) {
                c_imgSetup = (ImageView) findViewById(R.id.imgSetup);
            }
            c_strMerchantProvidedEmail = "";

            c_liCustomDialog = LayoutInflater.from(c_Context);
            c_View_Custom_Dialog = c_liCustomDialog.inflate(R.layout.custom_dialog, null);
            DialogBuilder_Custom_Dialog = new AlertDialog.Builder(c_Context);
            DialogBuilder_Custom_Dialog.setCancelable(false);
        }
        catch(final Exception ex)
        {
            SendCloverStackTrace(URLEncoder.encode(Log.getStackTraceString(ex)));

            new Handler(Looper.getMainLooper()).post(new Runnable()
            {
                @Override
                public void run()
                {
                    if (ex != null)
                    {
                        Toast.makeText(getApplicationContext(), "OPT-IN Rewards: onCreate Exception=" + ex.getMessage() + c_strErrorLine, Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "OPT-IN Rewards: onCreate Exception=NULL" + c_strErrorLine, Toast.LENGTH_LONG).show();
                    }

                    ex.printStackTrace();
                }
            });
        }
    }

    private class MyWebViewClient extends WebViewClient
    {

        //private WebView webView;

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url)
        {
            try
            {
                    if (url != null)
                    {
                        // This is your web site, so do not override; let the WebView to load the page
                        return false;
                    }
                    // Otherwise, the link is not for a page on my site, so launch another Activity that handles URLs
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intent);
                return true;
            }
            catch (final Exception ex)
            {
                SendCloverStackTrace(URLEncoder.encode(Log.getStackTraceString(ex)));

                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), "OPT-IN Rewards: MyWebViewClient::shouldOverrideUrlLoading Exception=" + ex.getMessage(), Toast.LENGTH_LONG).show();
                        ex.printStackTrace();
                    }
                });
                return false;
            }
        }

        @Override
        public void onPageFinished(WebView view, String url)
        {
            super.onPageFinished(view, url);
        }
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon)
        {
            try
            {
                super.onPageStarted(view, url, favicon);
                if (url.contains("access_token="))
                {
                    //save that code..., make them reinstall app if they get it wrong.
                    int index1 = url.indexOf("access_token=") + 13;
                    int index2 = url.length();

                    String stringholder = url.substring(index1, index2);

                    SharedPreferences preferences2 = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor2 = preferences2.edit();
                    editor2.putString("Access_Token", stringholder);
                    editor2.apply();

                }
            }
            catch(final Exception ex)
            {
                SendCloverStackTrace(URLEncoder.encode(Log.getStackTraceString(ex)));

                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), "OPT-IN Rewards: MyWebViewClient::onPageStarted Exception=" + ex.getMessage(), Toast.LENGTH_LONG).show();
                        ex.printStackTrace();
                    }
                });
            }
        }
    }

    class MyJavaScriptInterface
    {
        private Context ctx;

        MyJavaScriptInterface(Context ctx)
        {
            this.ctx = ctx;
        }

        @JavascriptInterface
        public void showHTML(String html)
        {
            try
            {
                String l_strStoreID = "";
                String l_strStorePassword = "";

                Log.d("MainActivity::showHTML", "html=" + html);

                if (html.indexOf("#STOREID#") > 0)
                {
                    SharedPreferences preferences2 = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor2 = preferences2.edit();

                    int index1 = html.indexOf("#STOREID#") + 9;
                    int index2 = html.indexOf("#/STOREID#");

                    l_strStoreID = html.substring(index1, index2);

                    index1 = html.indexOf("#STOREPASSWORD#") + 15;
                    index2 = html.indexOf("#/STOREPASSWORD#");

                    l_strStorePassword = html.substring(index1, index2);

                    editor2.putString("Store_ID", l_strStoreID);
                    editor2.putString("Store_Password", l_strStorePassword);
                    editor2.apply();

                    c_strStoreID = l_strStoreID;
                }

                Log.d("MainActivity::showHTML", "c_boolSetup=" + c_boolSetup + ", c_strStoreID=" + c_strStoreID);

                if (html.indexOf("#FINISHED#") > 0) {
                    if (c_boolSetup == true) {
                        final String l_strHTML = html;
                        //c_strStoreID = l_strStoreID;
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Log.d("MainActivity::showHTML", "l_strHTML=" + l_strHTML);

                                if (l_strHTML.contains("#OFFERLIST#") == true) {
                                    //Log.d("MyJavaScriptInterface", "showHTML: 7 LoadBlankWebPage()");
                                    //LoadBlankWebPage();
                                    if (c_miOptionsSettings != null) {
                                        c_miOptionsSettings.setEnabled(true);
                                    }
                                    c_imgSetup.setVisibility(View.INVISIBLE);
                                    c_tvSetup_Category_Items.setVisibility(View.INVISIBLE);
                                    c_gvSetup_Category_Items.setVisibility(View.INVISIBLE);
                                    c_btnSetup_Continue.setVisibility(View.INVISIBLE);

                                    myWebView.setVisibility(View.VISIBLE);

                                    //LoadBlankWebPage();
                                    Log.d("MyJavaScriptInterface", "showHTML: LoadOfferList()");
                                    LoadOfferList();
                                } else {
                                    Log.d("MyJavaScriptInterface", "showHTML: 8 LoadBlankWebPage()");
                                    //LoadBlankWebPage();
                                    LoadWebWebView(myWebView, c_strAccessToken);
                                }
                                c_bShowSetupVideo = false;
                                c_boolSetup = false;

                                if (c_ctrlActivityIndicator == null) {
                                    c_ctrlActivityIndicator = (ProgressBar) findViewById(R.id.ctrlActivityIndicator);
                                }
                                if (c_ctrlActivityIndicator != null) {
                                    // Hide the Busy indicator
                                    if (c_ctrlActivityIndicator != null) {
                                        c_ctrlActivityIndicator.setVisibility(View.INVISIBLE);
                                    }
                                }
                                c_boolSetup = false;
                            }
                        });
                    }
                }

                if (html.indexOf("AddUser") > 0) {

                    final String l_strHTML2 = html;
                    int l_index1 = l_strHTML2.indexOf("#AddUser#") + 9;
                    String l_strStatus = l_strHTML2.substring(l_index1);
                    l_strStatus = l_strStatus.substring(0, 1);
                    final int  l_iStatus = Integer.parseInt(l_strStatus);
                    String l_strMemberValues = l_strHTML2.substring(l_strHTML2.indexOf("AddUser") + 10);
                    l_strMemberValues = l_strMemberValues.substring(0, l_strMemberValues.indexOf("#/"));
                    String [] l_arrMemberValue = l_strMemberValues.split(";");
                    final String l_strCustomerID = l_arrMemberValue[0];
                    final String l_strCustomerName = l_arrMemberValue[1] + "^" + l_arrMemberValue[2];
                    final String l_strMemberSince = l_arrMemberValue[3];
                    final String l_strEmail = l_arrMemberValue[4];
                    final String l_strPhone1 = l_arrMemberValue[5];
                    final String l_strPhone2 = l_arrMemberValue[6];


                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            String l_strURL;

                            Log.d("MyJavaScriptInterface", "showHTML: 11 LoadBlankWebPage()");
                            myWebView.loadUrl("about:blank");
                            LoadBlankWebPage();

                            // Did we Add a New User?
                            switch(l_iStatus) {
                                case 0:
                                    // Cancel
                                    Toast.makeText(getApplicationContext(), "Member Was Not Added", Toast.LENGTH_LONG).show();

                                    l_strURL = c_strCyberCouponsHost + "/merchant/AddMember.aspx";
                                    myWebView.stopLoading();
                                    myWebView.loadUrl(l_strURL);

                                    break;
                                case 1:
                                    // Success
                                    Toast.makeText(getApplicationContext(), "Member Was Added Successfully!", Toast.LENGTH_LONG).show();

                                    l_strURL = c_strCyberCouponsHost + "/merchant/Customers.aspx?FullName=" + l_strCustomerName;
                                    myWebView.stopLoading();
                                    myWebView.loadUrl(l_strURL);
                                    break;
                            }
                        }
                    });
                }


                // Clover Instructional Video Link <CarlB 12-06-2017>
                if (html.contains("action=\"./newOfferList.aspx?CloverLink=") == true) {
                    String l_strLink = html.substring(html.indexOf("action=\"./newOfferList.aspx?CloverLink=")+39);
                    l_strLink = l_strLink.substring(0, l_strLink.indexOf("mp4")+3);
                    //final String l_strVidURL = "http://vtiger.cybercoupons.com:8080/mp4/" + l_strLink;
                    //final String l_strVidURL = "https://vtiger.cybercoupons.com/mp4/" + l_strLink;
                    //final String l_strVidURL = c_strCyberCouponsHost +"/merchant/vids/" + l_strLink;
                    final String l_strVidURL = "https://www.cybercoupons.com/vid/Clover/" + l_strLink;

                    Log.d("MainActivity::showHTML", "l_strLink=" + l_strLink);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            LoadVideo(l_strVidURL);
                        }
                    });
                }
            }
            catch (final Exception ex)
            {
                SendCloverStackTrace(URLEncoder.encode(Log.getStackTraceString(ex)));

                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), "OPT-IN Rewards: MyJavaScriptInterface::showHTML Exception=" + ex.getMessage(), Toast.LENGTH_LONG).show();
                        ex.printStackTrace();
                    }
                });
            }
        }
    }

    final Runnable _setButton = new Runnable()
    {
        public void run()
        {
        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        try
        {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.main, menu);

            c_OptionsMenu = menu;

            if (c_OptionsMenu != null) {
                c_miOptionsSettings = c_OptionsMenu.findItem(R.id.action_settings);
                if (c_miOptionsSettings != null) {
                    //c_miOptionsSettings.setEnabled(c_boolSetup == false);
                    c_miOptionsSettings.setEnabled(c_strStoreID.trim().length() > 0);

                    //c_miOptionsSettings.setEnabled(true);
                }
            }

        }
        catch(final Exception ex)
        {
            SendCloverStackTrace(URLEncoder.encode(Log.getStackTraceString(ex)));

            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(), "OPT-IN Rewards: onCreateOptionsMenu Exception=" + ex.getMessage(), Toast.LENGTH_LONG).show();
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
            switch (item.getItemId())
            {
                case R.id.action_settings:
                    //finish();
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
                    Toast.makeText(getApplicationContext(), "OPT-IN Rewards: onOptionsItemSelected Exception=" + ex.getMessage(), Toast.LENGTH_LONG).show();
                    ex.printStackTrace();
                }
            });
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        try
        {
            if (requestCode == FILECHOOSER_RESULTCODE)
            {
                if (null == mUploadMessage) return;
                Uri result = data == null || resultCode != RESULT_OK ? null
                        : data.getData();
                mUploadMessage.onReceiveValue(result);
                mUploadMessage = null;
                //Uri selectedImageUri = data.getData();
                //selectedImagePath = getPath(selectedImageUri);
            }

            if (requestCode == REQUEST_ACCOUNT && resultCode == RESULT_OK) {
                String name = data.getStringExtra(AccountManager.KEY_ACCOUNT_NAME);
                String type = data.getStringExtra(AccountManager.KEY_ACCOUNT_TYPE);
                mMerchAccount = new Account(name, type);
            }
        }
        catch(final Exception ex)
        {
            SendCloverStackTrace(URLEncoder.encode(Log.getStackTraceString(ex)));

            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(), "OPT-IN Rewards: onActivityResult Exception=" + ex.getMessage(), Toast.LENGTH_LONG).show();
                    ex.printStackTrace();
                }
            });
        }
    }

    private void startAccountChooser()
    {
        try
        {
            Intent intent = AccountManager.newChooseAccountIntent(null, null, new String[]{CloverAccount.CLOVER_ACCOUNT_TYPE}, false, null, null, null, null);
            startActivityForResult(intent, REQUEST_ACCOUNT);
        }
        catch(final Exception ex)
        {
            SendCloverStackTrace(URLEncoder.encode(Log.getStackTraceString(ex)));

            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(), "OPT-IN Rewards: startAccountChooser Exception=" + ex.getMessage(), Toast.LENGTH_LONG).show();
                    ex.printStackTrace();
                }
            });
        }

    }

    @Override
    protected void onResume()
    {
        try
        {
            c_strErrorLine = " (101)";
            super.onResume();

            c_bInternetConnected = IsInternetConnected();

            c_strErrorLine = " (102)";
            // Get a reference to the Activity Indicator control (busy icon)
            if (c_ctrlActivityIndicator == null)
            {
                c_ctrlActivityIndicator = (ProgressBar) findViewById(R.id.ctrlActivityIndicator);
            }

            // Get the Store ID and Password from storage in case it has been changed <CarlB 01-06-2017>
            SharedPreferences prfs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
            String l_strStoreID = prfs.getString("Store_ID", "");

            String l_strToken = prfs.getString("Access_Token", "");

            // Only replace the Token string if the stored on is valid <CarlB 12-01-2017>
            if(l_strToken != "") {
                c_strAccessToken = l_strToken;
            }

            if(i_FirstLoad == 1 && c_strStoreID.length() == 0)
            {
                c_strStoreID = l_strStoreID;
            }

            if (i_FirstLoad == 0 && l_strStoreID.length() > 0 && c_strStoreID != l_strStoreID) {
                // Load the Merchant Dashboard  <CarlB 12-13-2017>
                c_strStoreID = l_strStoreID;

                c_boolSetup = false;
                c_bShowSetupVideo = false;

                c_tvSetup_Category_Items.setVisibility(View.INVISIBLE);
                c_gvSetup_Category_Items.setVisibility(View.INVISIBLE);
                c_btnSetup_Continue.setVisibility(View.INVISIBLE);
                c_imgSetup.setVisibility(View.INVISIBLE);

                myWebView.setVisibility(View.VISIBLE);

                c_miOptionsSettings.setEnabled(true);
                LoadWebWebView(myWebView, c_strAccessToken);
            }
            else if(i_FirstLoad == 0 && l_strStoreID.length() == 0)
            {
                // Enable Setup Mode  <CarlB 12-13-2017>
                c_boolSetup = true;
                myWebView.setVisibility(View.INVISIBLE);
            }

            // If we are in Setup Mode, show Setup UI and bail  <CarlB 12-07-2017>
            if(c_boolSetup == true && c_bShowSetupVideo == false) {
                c_imgSetup.setVisibility(View.VISIBLE);
                c_tvSetup_Category_Items.setVisibility(View.VISIBLE);
                c_gvSetup_Category_Items.setVisibility(View.VISIBLE);
                c_btnSetup_Continue.setVisibility(View.VISIBLE);
                return;
            }

            c_strErrorLine = " (103)";
            if (mMerchAccount != null)
            {
                connect();
                createTender();
            } else
            {
                startAccountChooser();
            }

            c_strErrorLine = " (104)";
            // Get our Auth Code (formally Access Token)
            getCloverAuth();

            c_strErrorLine = " (105)";

            // Get the Logged In Employee
            getEmployee();
        }
        catch(final Exception ex)
        {
            SendCloverStackTrace(URLEncoder.encode(Log.getStackTraceString(ex)));

            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(), "OPT-IN Rewards: onResume Exception=" + ex.getMessage() + c_strErrorLine, Toast.LENGTH_LONG).show();
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
            disconnect();
            super.onPause();
        }
        catch(final Exception ex)
        {
            SendCloverStackTrace(URLEncoder.encode(Log.getStackTraceString(ex)));

            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(), "OPT-IN Rewards: onPause Exception=" + ex.getMessage(), Toast.LENGTH_LONG).show();
                    ex.printStackTrace();
                }
            });
        }
    }

    private void connect()
    {
        try
        {
            disconnect();
            if (mMerchAccount != null)
            {
                if(tenderConnector == null) {
                    tenderConnector = new TenderConnector(this, mMerchAccount, null);
                }
                if(tenderConnector.isConnected() == false) {
                    tenderConnector.connect();
                }

                if(mEmployeeConnector == null) {
                    mEmployeeConnector = new EmployeeConnector(this, mMerchAccount, null);
                }
                if(mEmployeeConnector.isConnected() == false) {
                    mEmployeeConnector.connect();
                }
            }
        }
        catch(final Exception ex)
        {
            SendCloverStackTrace(URLEncoder.encode(Log.getStackTraceString(ex)));

            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(), "OPT-IN Rewards: connect Exception=" + ex.getMessage(), Toast.LENGTH_LONG).show();
                    ex.printStackTrace();
                }
            });
        }
    }

    private void disconnect()
    {
        try {
            if (tenderConnector != null)
            {
                tenderConnector.disconnect();
                tenderConnector = null;
            }

            if (mEmployeeConnector != null)
            {
                mEmployeeConnector.disconnect();
                mEmployeeConnector = null;
            }
        }
        catch(final Exception ex)
        {
            SendCloverStackTrace(URLEncoder.encode(Log.getStackTraceString(ex)));

            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(), "OPT-IN Rewards: disconnect Exception=" + ex.getMessage(), Toast.LENGTH_LONG).show();
                    ex.printStackTrace();
                }
            });


        }
    }

    private void getTenders()
    {
        try
        {
            tenderConnector.getTenders(new TenderConnector.TenderCallback<List<Tender>>() {
                @Override
                public void onServiceSuccess(List<Tender> result, ResultStatus status) {
                    super.onServiceSuccess(result, status);
                    String text = "Tenders:\n";
                    for (Tender t : result) {
                        text += "  " + t.getId() + " , " + t.getLabel() + " , " + t.getLabelKey() + " , " + t.getEnabled() + " , " + t.getOpensCashDrawer() + "\n";
                    }
                }

                @Override
                public void onServiceFailure(ResultStatus status) {
                    super.onServiceFailure(status);
                }

                @Override
                public void onServiceConnectionFailure() {
                    super.onServiceConnectionFailure();
                }
            });
        }
        catch(final Exception ex)
        {
            SendCloverStackTrace(URLEncoder.encode(Log.getStackTraceString(ex)));

            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(), "OPT-IN Rewards: getTenders Exception=" + ex.getMessage(), Toast.LENGTH_LONG).show();
                    ex.printStackTrace();
                }
            });
        }
    }

    private void createTender()
    {
        try
        {
            //final String oldtenderName = "Cyber Coupons";
            // It still has the Tender Name set to "Cyber Coupons" even though we tried to change it <CarlB 20160825>
            final String tenderName = "OPT-IN Rewards Gift Card";
            final String packageName = getPackageName();


            tenderConnector.checkAndCreateTender(tenderName, packageName, true, false, new TenderConnector.TenderCallback<Tender>() {


                @Override
                public void onServiceSuccess(Tender result, ResultStatus status) {
                    super.onServiceSuccess(result, status);
                    String text = "Custom Tender:\n";
                    final String strID;
                    text += "  " + result.getId() + " , " + result.getLabel() + " , " + result.getLabelKey() + " , " + result.getEnabled() + " , " + result.getOpensCashDrawer() + "\n";

                    strID = result.getId();

                    new AsyncTask<Void, Void, Void>() {
                        @Override
                        protected Void doInBackground(Void... params) {
                            try {
                                tenderConnector.setLabel(strID, tenderName);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            return null;
                        }
                    }.execute();
                }


                @Override
                public void onServiceFailure(ResultStatus status) {
                    super.onServiceFailure(status);
                }

                @Override
                public void onServiceConnectionFailure() {
                    super.onServiceConnectionFailure();
                }
            });
        }
        catch(final Exception ex)
        {
            SendCloverStackTrace(URLEncoder.encode(Log.getStackTraceString(ex)));

            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(), "OPT-IN Rewards: createTender Exception=" + ex.getMessage(), Toast.LENGTH_LONG).show();
                    ex.printStackTrace();
                }
            });
        }
    }

    private void getMerchant()
    {
        try
        {
            new AsyncTask<Void, Void, Employee>() {

                @Override
                protected void onPreExecute() {
                    super.onPreExecute();
                }

                @Override
                protected Employee doInBackground(Void... params) {
                    try {

                        SystemClock.sleep(500);

                        if(mEmployeeConnector != null) {
                            if (mEmployeeConnector.isConnected() == false)
                            {
                                mEmployeeConnector.connect();
                                SystemClock.sleep(500);
                            }

                            List<Employee> employees = mEmployeeConnector.getEmployees();

                            String l_strTmp = "";

                            if(employees != null) {
                                for (Employee employee : employees) {
                                    // Default to an Employee
                                    if (employee.getIsOwner()) {
                                        return employee;
                                    }
                                }
                            }
                        }
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    } catch (ClientException e) {
                        e.printStackTrace();
                    } catch (ServiceException e) {
                        e.printStackTrace();
                    } catch (BindingException e) {
                        e.printStackTrace();
                    }
                    return null;
                }

                @Override
                protected void onPostExecute(Employee owner)
                {
                    super.onPostExecute(owner);

                    try
                    {
                        //testauth.wait();

                        if (!isFinishing())
                        {
                            // Populate the owner information
                            if (owner != null)
                            {
                                //mOwnerId = owner.getId();
                                mOwnerName = owner.getName();
                                c_strOwnerEmail = owner.getEmail();
                            }
                        }
                    }
                    catch(Exception ex)
                    {
                        SendCloverStackTrace(URLEncoder.encode(Log.getStackTraceString(ex)));
                    }
                }
            }.execute();
        }
        catch(final Exception ex)
        {
            SendCloverStackTrace(URLEncoder.encode(Log.getStackTraceString(ex)));

            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(), "OPT-IN Rewards: getMerchant Exception=" + ex.getMessage(), Toast.LENGTH_LONG).show();
                    ex.printStackTrace();
                }
            });


        }
    }

    private void getMerchantDemographics()
    {
        try
        {
            new AsyncTask<Void, Void, Merchant>()
            {

                @Override
                protected void onPreExecute() {
                    super.onPreExecute();
                }

                @Override
                protected Merchant doInBackground(Void... params) {
                    Merchant merchant = null;
                    try
                    {
                        if(mMerchantDemographics != null)
                        {
                            if(mMerchantDemographics.isConnected() == false)
                            {
                                mMerchantDemographics.connect();
                                SystemClock.sleep(500);
                            }
                            merchant = mMerchantDemographics.getMerchant();
                        }
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    } catch (ClientException e) {
                        e.printStackTrace();
                    } catch (ServiceException e) {
                        e.printStackTrace();
                    } catch (BindingException e) {
                        e.printStackTrace();
                    }
                    return merchant;
                }

                @Override
                protected void onPostExecute(Merchant merchant)
                {
                    super.onPostExecute(merchant);

                    try
                    {
                        //URLEncoder.encode(null);

                        if (!isFinishing())
                        {
                            // Populate the merchant information
                            if (merchant != null)
                            {
                                String l_strMID;
                                String l_strMerchName;
                                String l_strAddr1;
                                String l_strAddr2;
                                String l_strAddr3;
                                String l_strCity;
                                String l_strState;
                                String l_strZip;
                                String l_strCountry;
                                String l_strPhone;

                                l_strMID = merchant.getId();
                                l_strMerchName = merchant.getName();
                                l_strAddr1 = merchant.getAddress().getAddress1();
                                l_strAddr2 = merchant.getAddress().getAddress2();
                                l_strAddr3 = merchant.getAddress().getAddress3();
                                l_strCity = merchant.getAddress().getCity();
                                l_strState = merchant.getAddress().getState();
                                l_strZip = merchant.getAddress().getZip();
                                l_strCountry = merchant.getAddress().getCountry();
                                l_strPhone = merchant.getPhoneNumber();

                                if(l_strMID != null)
                                {
                                    c_strMerchantID = URLEncoder.encode(l_strMID);
                                }
                                else
                                {
                                    c_strMerchantID = "";
                                }
                                if(l_strMerchName != null)
                                {
                                    mMerchName = URLEncoder.encode(l_strMerchName);
                                }
                                else
                                {
                                    mMerchName = "";
                                }
                                if(l_strAddr1 != null)
                                {
                                    mMerchAddr1 = URLEncoder.encode(l_strAddr1);
                                }
                                else
                                {
                                    mMerchAddr1 = "";
                                }
                                if(l_strAddr2 != null)
                                {
                                    mMerchAddr2 = URLEncoder.encode(l_strAddr2);
                                }
                                else
                                {
                                    mMerchAddr2 = "";
                                }
                                if(l_strAddr3 != null)
                                {
                                    mMerchAddr3 = URLEncoder.encode(l_strAddr3);
                                }
                                else
                                {
                                    mMerchAddr3 = "";
                                }
                                if(l_strCity != null)
                                {
                                    mMerchCity = URLEncoder.encode(l_strCity);
                                }
                                else
                                {
                                    mMerchCity = "";
                                }
                                if(l_strState != null)
                                {
                                    mMerchState = URLEncoder.encode(l_strState);
                                }
                                else
                                {
                                    mMerchState = "";
                                }
                                if(l_strZip != null)
                                {
                                    mMerchZip = URLEncoder.encode(l_strZip);
                                }
                                else
                                {
                                    mMerchZip = "";
                                }
                                if(l_strCountry != null)
                                {
                                    mMerchCountry = URLEncoder.encode(l_strCountry);
                                }
                                else
                                {
                                    mMerchCountry = "";
                                }
                                if(l_strPhone != null)
                                {
                                    mMerchPhone = URLEncoder.encode(l_strPhone);
                                }
                                else
                                {
                                    mMerchPhone = "'";
                                }
                            }
                        }
                    }
                    catch (Exception ex)
                    {
                        SendCloverStackTrace(URLEncoder.encode(Log.getStackTraceString(ex)));
                    }

                }
            }.execute();
        }
        catch(final Exception ex)
        {
            SendCloverStackTrace(URLEncoder.encode(Log.getStackTraceString(ex)));

            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(), "OPT-IN Rewards: getMerchantDemographics Exception=" + ex.getMessage(), Toast.LENGTH_LONG).show();
                    ex.printStackTrace();
                }
            });
        }
    }

    private void getCloverAuth()
    {
        try
        {
            // This needs to be done on a background thread
            new AsyncTask<Void, Void, CloverAuth.AuthResult>() {
                @Override
                protected CloverAuth.AuthResult doInBackground(Void... params) {
                    try {
                        return CloverAuth.authenticate(MainActivity.this, mMerchAccount);
                    } catch (OperationCanceledException e) {
                        //Log.e(TAG, "Authentication cancelled", e);
                    } catch (final Exception e) {

                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getApplicationContext
                                        (), "OPT-IN Rewards: getCloverAuth Exception=" + e.getMessage(), Toast.LENGTH_LONG).show();
                                e.printStackTrace();
                            }
                        });
                        //Log.e(TAG, "Error retrieving authentication", e);
                    }
                    return null;
                }

                @Override
                protected void onPostExecute(CloverAuth.AuthResult result)
                {
                    mCloverAuth = result;

                    // To get a valid auth result you need to have installed the app from the App Market. The Clover servers
                    // only creates the token once installed the first time.
                    if (mCloverAuth != null && mCloverAuth.authToken != null)
                    {
                        c_strAccessToken = mCloverAuth.authToken;

                        // Save the Token for use with Tendering and Transaction Processing
                        SharedPreferences preferences2 = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor2 = preferences2.edit();
                        editor2.putString("Access_Token", c_strAccessToken);
                        editor2.apply();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "OPT-IN Rewards must be installed from the Clover App Store.", Toast.LENGTH_LONG).show();
                    }
                }

            }.execute();
        }
        catch(final Exception ex)
        {
            SendCloverStackTrace(URLEncoder.encode(Log.getStackTraceString(ex)));

            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(), "OPT-IN Rewards: getCloverAuth Exception=" + ex.getMessage(), Toast.LENGTH_LONG).show();
                    ex.printStackTrace();
                }
            });

        }
    }

    private void getEmployee()
    {
        try
        {
            if(mEmployeeConnector != null) {
                mEmployeeConnector.getEmployee(new EmployeeConnector.EmployeeCallback<Employee>() {
                    @Override
                    public void onServiceSuccess(Employee employee, ResultStatus status) {
                        if (employee != null) {
                            super.onServiceSuccess(employee, status);
                            mEmpID = employee.getId().toString();
                            mEmpName = employee.getName();
                            mEmpEmail = employee.getEmail();
                        }

                        // Load the Web View based on which variables we have set <CarlB>
                        if (i_FirstLoad == 1)
                        {
                            //Log.d("MainAcivity", "getEmployee: LoadWebWebView(" + c_strAccessToken + ")");
                            LoadWebWebView(myWebView, c_strAccessToken);
                            i_FirstLoad = 0;
                        }
                    }
                });
            }
            else
            {
                // Load the Web View based on which variables we have set <CarlB>
                if (i_FirstLoad == 1)
                {
                    //Log.d("MainAcivity", "getEmployee: 2 LoadWebWebView(" + c_strAccessToken + ")");
                    LoadWebWebView(myWebView, c_strAccessToken);
                    i_FirstLoad = 0;
                }
            }
        }
        catch(final Exception ex)
        {
            SendCloverStackTrace(URLEncoder.encode(Log.getStackTraceString(ex)));

            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(), "OPT-IN Rewards: getEmployee Exception=" + ex.getMessage(), Toast.LENGTH_LONG).show();
                    ex.printStackTrace();
                }
            });


        }
    }

    @Override
    public void onActiveEmployeeChanged(Employee employee)
    {
        try
        {
            if (employee != null)
            {
                mEmpID = employee.getId().toString();
                mEmpName = employee.getName();
                //employee.getRole().toString();
                mEmpEmail = employee.getEmail();
            }
        }
        catch(final Exception ex)
        {
            SendCloverStackTrace(URLEncoder.encode(Log.getStackTraceString(ex)));

            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(), "OPT-IN Rewards: onActiveEmployeeChanged Exception=" + ex.getMessage(), Toast.LENGTH_LONG).show();
                    ex.printStackTrace();
                }
            });


        }
    }

    void SendAppVersion()
    {
        String l_strURL = "";

        try
        {
            PackageInfo pInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            String version = pInfo.versionName;
            String android_id = Secure.getString(getContentResolver(), Secure.ANDROID_ID);

            if(version !=  null && android_id != null)
            {
                l_strURL = c_strCyberCouponsHost + "/merchant/Login/CloverCallback.aspx?app_version=" + version + "&POSID=" + c_strPOSID + "&android_id=" + android_id + "&app_name=OPT-IN%20Rewards%20(Clover)";

                setContentView(R.layout.activity_main);
                if (myWebView == null)
                {
                    myWebView = (WebView) findViewById(R.id.webview);
                }
                if (myWebView != null)
                {
                    if(c_bDebugMode ==  true) {
                        Log.d("MainAcivity", "SendAppVersion: loadUrl(" + l_strURL + ")");
                    }

                    myWebView.loadUrl(l_strURL);
                }
            }
        }
        catch (Exception ex)
        {
            SendCloverStackTrace(URLEncoder.encode(Log.getStackTraceString(ex)));
            ex.printStackTrace();
        }
    }

    private boolean IsInternetConnected() {

        Log.d("IsInternetConnected", "=====START=====");

        try {
            boolean haveConnectedWifi = false;
            boolean haveConnectedMobile = false;

            ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getActiveNetworkInfo();
            if(netInfo != null) {
                if (netInfo.getTypeName().equalsIgnoreCase("WIFI")) {
                    if (netInfo.isConnected()) {
                        haveConnectedWifi = true;
                    }
                }
                if (netInfo.getTypeName().equalsIgnoreCase("MOBILE")) {
                    if (netInfo.isConnected()) {
                        haveConnectedMobile = true;
                    }
                }
            }
            Log.d("IsInternetConnected", "=====FINISH=====");
            return haveConnectedWifi || haveConnectedMobile;

        } catch (Exception ex) {
            ex.printStackTrace();
            SendCloverStackTrace(ex.getStackTrace().toString());
        }

        Log.d("IsInternetConnected", "=====FINISH=====");

        return false;
    }

    void ShowPopupMessage(String p_strMessage, int p_iSeconds) {
        try {

            Log.d("ShowPopupMessage", "=====START=====");

            if (c_bPopupShowing == true) {

                Log.d("ShowPopupMessage", "(Already Showing) =====FINISH=====");
                return;
            }
            final int SHORT_TOAST_DURATION = 2000;

            long l_lDurationInMillisecons = p_iSeconds * 1000;

            final Toast tag = Toast.makeText(getBaseContext(), p_strMessage, Toast.LENGTH_SHORT);

            tag.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);

            tag.show();

            Log.d("ShowPopupMessage", "p_strMessage=" + p_strMessage);

            new CountDownTimer(l_lDurationInMillisecons, 1000) {
                //new CountDownTimer(Math.max(l_lDurationInMillisecons - SHORT_TOAST_DURATION, 1000), 1000) {

                public void onTick(long millisUntilFinished) {
                    //Log.d("ShowPopupMessage", "onTick");
                    tag.show();
                }

                public void onFinish() {
                    Log.d("ShowPopupMessage", "onFinish");
                    tag.show();
                    c_bPopupShowing = false;
                }

            }.start();
        } catch (Exception ex) {
            SendCloverStackTrace(ex.getStackTrace().toString());
        }

        Log.d("ShowPopupMessage", "=====FINISH=====");
    }

    private void selectVideo(String p_strURL) {

        try {

            Log.d("MainActivity::selectVideo", "=====START=====");

            FrameLayout l_flAnchor = (FrameLayout)findViewById(R.id.controllerAnchor);

            c_VideoController = new com.cybercoupons.rewards.android.VideoController(this, l_flAnchor, c_vvMain, myWebView, p_strURL);

            c_VideoController.setSystemUiVisibility(View.VISIBLE);
            c_VideoController.setVisibility(View.VISIBLE);
            c_VideoController.setActivated(true);

            c_VideoController.setAnchorView(l_flAnchor);

            c_VideoController.requestLayout();

            //mVideo is the VideoView where I insert the video
            c_vvMain.setMediaController(c_VideoController);

            //c_vvMain.pause();

            //c_VideoController.show();
        } catch (Exception ex) {
            SendCloverStackTrace(ex.getStackTrace().toString());
        }

        Log.d("MainActivity::selectVideo", "=====FINISH=====");
    }

    public boolean CreateGTNAccount() {
        boolean l_bResult = false;

        try {

            Log.d("MainAcivity", "CreateGTNAccount: =====START=====");

            if (c_ctrlActivityIndicator == null) {
                c_ctrlActivityIndicator = (ProgressBar) findViewById(R.id.ctrlActivityIndicator);
                // Hide the Busy indicator
                if (c_ctrlActivityIndicator != null) {
                    c_ctrlActivityIndicator.setVisibility(View.VISIBLE);
                }
            }

            String l_strTmp = c_tvSetup_Category_Items.getText().toString();
            String l_strURL;

            c_tvSetup_Category_Items.setVisibility(View.VISIBLE);
            c_tvSetup_Category_Items.setText("Finishing Your Store Setup, Please Wait...");

            l_strTmp = l_strTmp.substring(l_strTmp.indexOf(":") + 2);

            //c_tvSetup_Category_Items.setText("");

            if(l_strTmp.toUpperCase().contains("HOME AND GARDEN") == true)
            {
                l_strTmp = "2";
            }
            else if(l_strTmp.toUpperCase().contains("DINING") == true)
            {
                l_strTmp = "3";
            }
            else if(l_strTmp.toUpperCase().contains("ENTERTAINMENT") == true)
            {
                l_strTmp = "4";
            }
            else if(l_strTmp.toUpperCase().contains("AUTOMOTIVE") == true)
            {
                l_strTmp = "5";
            }
            else if(l_strTmp.toUpperCase().contains("PROFESSIONAL SERVICES") == true)
            {
                l_strTmp = "6";
            }
            else if(l_strTmp.toUpperCase().contains("HEALTH AND BEAUTY") == true)
            {
                l_strTmp = "7";
            }
            else if(l_strTmp.toUpperCase().contains("RETAIL") == true)
            {
                l_strTmp = "8";
            }

            if (c_bInternetConnected == true) {
                l_strURL = c_strCyberCouponsHost + "/merchant/Login/CloverCallback.aspx?POSID="+ c_strPOSID +"&token=" + c_strAccessToken + "&storeid=" + c_strStoreID + "&merchant_id=" + c_strMerchantID + "&username=" + mEmpName + "&email=" + mEmpEmail + "&storename=" + mMerchName + "&storeaddr1=" + mMerchAddr1 + "&storeaddr2=" + mMerchAddr2 + "&storeaddr3=" + mMerchAddr3 + "&storecity=" + mMerchCity + "&storestate=" + mMerchState + "&storezip=" + mMerchZip + "&storecountry=" + mMerchCountry + "&storephone=" + mMerchPhone + "&android_id=" + c_strAndroidID + "&app_version=" + c_strAppVersion + "&clover_setup_category=" + l_strTmp + "&OfferList=1&device_id=" + c_strAndroidID + "&EmailNewMerchant=" + c_strMerchantProvidedEmail;
                if (myWebView != null) {
                    myWebView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);

                    if(c_bDebugMode ==  true) {
                        Log.d("MainAcivity", "CreateGTNAccount: myWebView.loadUrl(" + l_strURL + ")");
                    }

                    myWebView.loadUrl(l_strURL);

                    c_bIsBlankPageLoaded = false;


                    c_tvSetup_Category_Items.setVisibility(View.INVISIBLE);
                    myWebView.setVisibility(View.VISIBLE);
                }
                //ShowDashboard(View.VISIBLE, myWebView);
                //c_tvSetup_Category_Items.setText("Finishing Your Store Setup, Please Wait...");
            } else {
                //Toaster.makeLongToast(getApplicationContext(), "NO INTERNET CONNECTION, CHECK WIFI / CELLULAR", 10000);
                ShowPopupMessage("There is no INTERNET CONNECTION, check WIFI / CELLULAR", 5);
            }


            Log.d("MainAcivity", "CreateGTNAccount: =====FINISH=====");
        } catch (Exception ex) {
            SendCloverStackTrace(ex.getStackTrace().toString());
        }

        return l_bResult;
    }

    public void LoadVideo(String p_strURL) {
        try {
            Log.d("MainActivity::LoadVideo", "=====START=====");

            myWebView.setEnabled(false);

            final String l_strURL = p_strURL;
            Uri l_uri = Uri.parse(p_strURL); //Declare your url here.

            c_vvMain.setVisibility(View.VISIBLE);
            c_llVideo.setVisibility(View.VISIBLE);

            Log.d("MainActivity::LoadVideo", "l_strURL=" + l_strURL);

            //c_vvMain.setVideoPath(getDataSource(p_strURL));
            //c_vvMain.setVideoPath(p_strURL);

            //c_vvMain.requestFocus();

            c_vvMain.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                public void onCompletion(MediaPlayer mp) {
                    // Do whatever u need to do here
                    c_vvMain.stopPlayback();

                    // Hide the Busy indicator
                    if (c_ctrlActivityIndicator != null) {
                        c_ctrlActivityIndicator.setVisibility(View.INVISIBLE);
                    }

                    if (c_llVideo != null) {
                        c_llVideo.setVisibility(View.INVISIBLE);
                    }
                    if (c_vvMain != null) {
                        c_vvMain.setVisibility(View.INVISIBLE);
                    }

                    if (c_VideoController != null) {
                        c_VideoController.setVisibility(View.INVISIBLE);
                    }

                    myWebView.setEnabled(true);

                    if (c_bShowSetupVideo == true) {
                        c_bShowSetupVideo = false;
                        //c_imgSetup.setImageResource(R.drawable.getstarted);
                        c_imgSetup.setVisibility(View.VISIBLE);
                        c_tvSetup_Category_Items.setVisibility(View.VISIBLE);
                        c_gvSetup_Category_Items.setVisibility(View.VISIBLE);
                        c_btnSetup_Continue.setVisibility(View.VISIBLE);

                        //c_tvSetup_Category_Items.setVisibility(View.VISIBLE);
                        //ShowSetup(View.VISIBLE, myWebView);

                        // Prompt Clover Merchant for Email Address to send info to <CarlB 10-06-2017>
                        GetEmailDialog();
                   }

                }
            });

            c_vvMain.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {

                    c_vvMain.start();
                    c_VideoController.show();
                }
            });

            //c_vvMain.setZOrderOnTop(true);

            //c_vvMain.setVideoPath(getDataSource(p_strURL));

            c_vvMain.canPause();
            c_vvMain.canSeekBackward();
            c_vvMain.canSeekForward();

            selectVideo(l_strURL);
            c_vvMain.requestFocus();

            if (c_ctrlActivityIndicator != null) {
                c_ctrlActivityIndicator.setVisibility(View.INVISIBLE);
            }
        } catch (Exception ex) {
            SendCloverStackTrace(ex.getStackTrace().toString());
        }

        Log.d("MainActivity::LoadVideo", "=====FINISH=====");
    }

    public static void GetEmailDialog() {
        try {

            // set title
            DialogBuilder_Custom_Dialog.setTitle("Enter Email Address");
            // set custom dialog icon
            DialogBuilder_Custom_Dialog.setIcon(R.drawable.ic_optin_24);
            // set custom_dialog.xml to alertdialog builder
            DialogBuilder_Custom_Dialog.setView(c_View_Custom_Dialog);
            final EditText l_edUserInput = (EditText) c_View_Custom_Dialog.findViewById(R.id.et_input);

            if (l_edUserInput != null) {
                l_edUserInput.setText (c_strOwnerEmail);
                if (c_strOwnerEmail != null) {
                    if (c_strOwnerEmail.length() > 0) {
                        l_edUserInput.selectAll();
                    }
                }
            }
            l_edUserInput.requestFocus();

            // set dialog message
            DialogBuilder_Custom_Dialog
                    .setCancelable(false)

                    .setPositiveButton("Send",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {

                                    // Re-enable the Settings option menu, in case the Merchant needs to set the Store ID and Password manually <CarlB 12-13-2017>
                                    if (c_miOptionsSettings != null) {
                                        c_miOptionsSettings.setEnabled(true);
                                    }

                                    // get user input
                                    c_strMerchantProvidedEmail = l_edUserInput.getText().toString();
                                    if (c_strMerchantProvidedEmail.length() < 6 || c_strMerchantProvidedEmail.contains("@") == false) {
                                        c_strMerchantProvidedEmail = "";
                                        return;
                                    } else {
                                        //c_bEmailDialogResponded = true;
                                        dialog.dismiss();
                                    }
                                }
                            })

            ;
            // create alert dialog
            final AlertDialog alertDialog = DialogBuilder_Custom_Dialog.create();
            // show it
            alertDialog.show();

            alertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {

                @Override
                public void onDismiss(DialogInterface dialog) {
                    //If the error flag was set to true then show the dialog again
                    if (c_strMerchantProvidedEmail == "") {
                        alertDialog.show();
                    } else {
                        alertDialog.dismiss();
                        return;
                    }

                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
            //c_PoyntError.SendPoyntStackTrace(ex.getStackTrace().toString());
        }
    }

    public void LoadOfferList() {

        String l_strURL;

        Log.d("MainAcivity", "LoadOfferList: =====START=====");

        try {

            // Show the Busy indicator
            if (c_ctrlActivityIndicator != null) {
                c_ctrlActivityIndicator.setVisibility(View.VISIBLE);
            }

            if (c_strStoreID != null) {
                Log.d("MainAcivity", "LoadOfferList: =====START=====");

                l_strURL = c_strCyberCouponsHost + "/merchant/Login/CloverApp.aspx?POSID="+ c_strPOSID +"&merchant_id=" + c_strMerchantID + "&token=" + c_strAccessToken + "&username=" + c_strAccountName + "&storeid=" + c_strStoreID + "&OfferList=1&device_id=" + c_strAndroidID;
                //l_strURL = l_strURL.replace(" ", "%20").replace(" ", "_").replace("", "(").replace("", ")");
                l_strURL = l_strURL.replace(" ", "%20").replace(" ", "_");

                Log.d("LoadOfferList", String.format("l_strURL=%s", l_strURL));

                if (myWebView != null) {
                    myWebView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
                    myWebView.clearCache(true);

                    if(c_bDebugMode ==  true) {
                        Log.d("MainAcivity", "LoadOfferList: c_wvwMain.loadUrl(" + l_strURL + ")");
                    }

                    myWebView.loadUrl(l_strURL);
                    myWebView.setVisibility(View.VISIBLE);
                    c_bIsBlankPageLoaded = false;


                }

                myWebView.setVisibility(View.VISIBLE);

                ShowPopupMessage("Please take a moment to review your Pre-created Sample Offers.", 15);

                c_tvSetup_Category_Items.setVisibility(View.INVISIBLE);
                c_imgSetup.setVisibility(View.INVISIBLE);

                ShowPopupMessage("You can Edit, Disable, and Create Offers here.\n\nThis is best done from a Computer e.g. Upload your own pictures.", 30);

                ShowPopupMessage("There are also Video Tutorials to help get you started.", 45);

                ShowPopupMessage("To get started: \nTAP \"Register Customer\" to register yourself in your new Loyalty Program.", 60);

            }
        } catch (Exception ex) {
            SendCloverStackTrace(ex.getStackTrace().toString());
        }
        Log.d("MainAcivity", "LoadOfferList: =====FINISH=====");
    }

    public void LoadBlankWebPage() {
        Log.d("LoadBlankWebPage", "=====START=====");

        try {

            if (c_bIsBlankPageLoaded == true) {
                Log.d("LoadBlankWebPage", "(c_bIsBlankPageLoaded == true) =====FINISH=====");
                return;
            }

            if (c_boolSetup == true) {
                return;
            }

            if (c_strStoreID == null) {
                return;
            }

            if (c_strStoreID == "") {
                return;
            }

            if (myWebView != null) {
                String l_strURL = c_strCyberCouponsHost + "/merchant/Login/CloverBlank.html";
                myWebView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);

                if(c_bDebugMode ==  true) {
                    Log.d("MainAcivity", "LoadBlankWebPage: c_wvwMain.loadUrl(" + l_strURL + ")");
                }

                myWebView.loadUrl(l_strURL);
                myWebView.setVisibility(View.VISIBLE);
                c_bIsBlankPageLoaded = true;

                //Log.d("MainAcivity", "LoadBlankWebPage: c_wvwMain.loadUrl(" + l_strURL + ")");
            }
        } catch (Exception ex) {
            SendCloverStackTrace(ex.getStackTrace().toString());
        }

        Log.d("LoadBlankWebPage", "=====FINISH=====");
    }

    void SendCloverStackTrace(String p_strExceptioMesssage)
    {
        String l_strURL = "";

        setContentView(R.layout.activity_main);
        if(myWebView == null)
        {
            myWebView = (WebView) findViewById(R.id.webview);
        }
        if(myWebView != null)
        {
            if(c_strStoreID == null || c_strMerchantID == null)
            {
                if(c_strStoreID == null && c_strMerchantID == null)
                {
                    l_strURL = c_strCyberCouponsHost + "/merchant/Login/CloverCallback.aspx?StoreID=0&MID=0&CloverStackTrace=" + p_strExceptioMesssage;
                }
                else
                {
                    if(c_strStoreID == null)
                    {
                        l_strURL = c_strCyberCouponsHost + "/merchant/Login/CloverCallback.aspx?StoreID=0&MID=" + c_strMerchantID + "&CloverStackTrace=" + p_strExceptioMesssage;
                    }
                    else
                    {
                        l_strURL = c_strCyberCouponsHost + "/merchant/Login/CloverCallback.aspx?StoreID=" + c_strStoreID + "&MID=0&CloverStackTrace=" + p_strExceptioMesssage;
                    }
                }
            }
            else
            {
                l_strURL = c_strCyberCouponsHost + "/merchant/Login/CloverCallback.aspx?StoreID=" + c_strStoreID + "&MID=" + c_strMerchantID + "&CloverStackTrace=" + p_strExceptioMesssage;
            }

            if(l_strURL != "")
            {

                if(c_bDebugMode ==  true) {
                    Log.d("MainAcivity", "SendCloverStackTrace: loadUrl(" + l_strURL + ")");
                }

                myWebView.loadUrl(l_strURL);
            }
        }
    }
}

class SetupCategoryAdapter extends BaseAdapter {

    private Context c_Context;
    private View c_vCategory;
    private Activity c_Act;
    private GridView c_GridView;
    private WebView c_WebView;
    private List<List<String>> c_SetupCategoryItem = new ArrayList<List<String>>();
    private TextView l_tvSetup_Category_Items;
    private String l_strIndustrYText;
    private PoyntErrorHandler c_PoyntError = new PoyntErrorHandler();

    public class PoyntErrorHandler
    {
        void SendPoyntStackTrace(String p_strExceptionMesssage)
        {
            try {

                String l_strURL = "";

                if(c_WebView != null)
                {
                    if(MainActivity.c_strStoreID == null || MainActivity.c_strMerchantID == null)
                    {
                        if(MainActivity.c_strStoreID == null && MainActivity.c_strMerchantID == null)
                        {
                            l_strURL = MainActivity.c_strCyberCouponsHost + "/merchant/Login/CloverCallback.aspx?StoreID=0&MID=0&PoyntStackTrace=" + p_strExceptionMesssage;
                        }
                        else
                        {
                            if(MainActivity.c_strStoreID == null)
                            {
                                l_strURL = MainActivity.c_strCyberCouponsHost + "/merchant/Login/CloverCallback.aspx?StoreID=0&MID=" + MainActivity.c_strMerchantID + "&PoyntStackTrace=" + p_strExceptionMesssage;
                            }
                            else
                            {
                                l_strURL = MainActivity.c_strCyberCouponsHost + "/merchant/Login/CloverCallback.aspx?StoreID=" + MainActivity.c_strMerchantID + "&MID=0&PoyntStackTrace=" + p_strExceptionMesssage;
                            }
                        }
                    }
                    else
                    {
                        l_strURL = MainActivity.c_strCyberCouponsHost + "/merchant/Login/CloverCallback.aspx?StoreID=" + MainActivity.c_strStoreID + "&MID=" + MainActivity.c_strMerchantID + "&PoyntStackTrace=" + p_strExceptionMesssage;
                    }

                    if(l_strURL != "")
                    {
                        c_WebView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);

                        if(MainActivity.c_bDebugMode ==  true) {
                            Log.d("MainAcivity", "SendPoyntStackTrace: c_WebView.loadUrl(" + l_strURL + ")");
                        }

                        c_WebView.loadUrl(l_strURL);
                        //MainActivity.c_strLastURL = l_strURL;

                    }

                    Log.d("PoyntErrorHandler", "SendPoyntStackTrace: LoadBlankWebPage()");
                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
                //c_PoyntError.SendPoyntStackTrace(ex.getStackTrace().toString());
            }
        }
    }

    public SetupCategoryAdapter(Context p_Context, GridView p_ListView, Activity p_Act, WebView p_WebView)
    {
        Log.d("SetupCategoryAdapter", "===============START===============");

        try {
            this.c_Context = p_Context;
            this.c_GridView = p_ListView;
            this.c_Act = p_Act;
            this.c_WebView = p_WebView;

            c_SetupCategoryItem.add(Arrays.asList("2", "Home And Garden"));
            c_SetupCategoryItem.add(Arrays.asList("3","Dining"));
            c_SetupCategoryItem.add(Arrays.asList("4","Entertainment"));
            c_SetupCategoryItem.add(Arrays.asList("5", "Automotive"));
            c_SetupCategoryItem.add(Arrays.asList("6", "Professional Services"));
            c_SetupCategoryItem.add(Arrays.asList("7", "Health And Beauty"));
            c_SetupCategoryItem.add(Arrays.asList("8", "Retail"));

            l_tvSetup_Category_Items = (TextView)p_Act.findViewById(R.id.tvSetup_Category_Items);
        }
        catch (Exception ex)
        {
            c_PoyntError.SendPoyntStackTrace(ex.getStackTrace().toString());
        }
    }

    @Override
    public int getCount()
    {
        int l_iCount = 0;

        //Log.d("SetupCategoryAdapter", "getCount: ===============START===============");
        try
        {
            if(c_SetupCategoryItem != null)
            {
                l_iCount = c_SetupCategoryItem.size();
            }
        }
        catch (Exception ex)
        {
            c_PoyntError.SendPoyntStackTrace(ex.getStackTrace().toString());
        }

        //Log.d("SetupCategoryAdapter", "getCount: ===============FINISH===============");
        return l_iCount;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        //Log.d("SetupCategoryAdapter", "getView: ===============START===============");
        try
        {
            //Log.d("SetupCategoryAdapter", String.format("getView: position=%d, parent.getChildCount()=%d", position, parent.getChildCount()));

            LayoutInflater inflater = (LayoutInflater) c_Context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            if (convertView == null)
            {
                //Log.d("SetupCategoryAdapter", "getView: convertView == null");
                c_vCategory = new View(c_Context);
            }
            else
            {
                //Log.d("SetupCategoryAdapter", "getView: convertView != null");
                c_vCategory = (View) convertView;
            }

            c_vCategory = inflater.inflate(R.layout.setup_cat_layout, null);

            //Log.d("SetupCategoryAdapter", String.format("getView: position=%d", position));

            if(c_vCategory != null)
            {
                if (c_SetupCategoryItem.get(position).get(1) != null)
                {
                    final String l_strName = c_SetupCategoryItem.get(position).get(1);

                    //Log.d("SetupCategoryAdapter", String.format("getView: l_strName=%s", l_strName));

                    final Button l_btnCat = (Button) c_vCategory.findViewById(R.id.btnCat);

                    if(l_btnCat != null)
                    {
                        l_btnCat.setText(l_strName);

                        l_btnCat.setOnClickListener(new View.OnClickListener()
                        {
                            final int l_iPosition = position;
                            @Override
                            public void onClick(View view)
                            {
                                try
                                {
                                    if(l_tvSetup_Category_Items != null) {
                                        l_strIndustrYText = "Selected Industry: <b>" + l_strName + "</b>";
                                        l_tvSetup_Category_Items.setText(Html.fromHtml(l_strIndustrYText));

                                    }
                                }
                                catch (Exception ex)
                                {
                                    ex.printStackTrace();
                                }
                            }
                        });
                    }
                }
            }
            else
            {
                final String l_strCat = c_SetupCategoryItem.get(position).get(0);
                if (l_strCat != " ")
                {
                    Button l_btnCat = null;

                    //Button l_btnCat = (Button) c_vCategory.findViewById(R.id.btnCat);
                    if (l_btnCat != null)
                    {
                        l_btnCat.setText(l_strCat);
                        l_btnCat.setLayoutParams(new TableRow.LayoutParams(200, 75));
                        l_btnCat.setGravity(Gravity.CENTER | Gravity.CENTER_VERTICAL);

                        l_btnCat.setOnClickListener(new View.OnClickListener()
                        {
                            final int l_iPosition = position;

                            @Override
                            public void onClick(View view)
                            {
                                try
                                {
                                    if(l_tvSetup_Category_Items != null) {
                                        l_strIndustrYText = "Selected Industry: <b>" + l_strCat + "</b>";
                                        l_tvSetup_Category_Items.setText(Html.fromHtml(l_strIndustrYText));
                                    }                                    //AddProductToSale(l_strName);
                                }
                                catch (Exception ex)
                                {
                                    ex.printStackTrace();
                                }
                            }
                        });

                    }
                }

            }
            //Log.d("SetupCategoryAdapter", "getView: ===============FINISH===============");
        }
        catch (Exception ex)
        {
            Log.d("SetupCategoryAdapter", "Exception=" + ex.getMessage());
            c_PoyntError.SendPoyntStackTrace(ex.getStackTrace().toString());
        }

        return c_vCategory;
    }

    @Override
    public Object getItem(int position) {
        //Log.d("SetupCategoryAdapter", "getItem: ===============START===============");
        try {
            //c_Index = position;

            Log.d("SetupCategoryAdapter", String.format("getItem: getItem(%d)", position));

            if(c_SetupCategoryItem.size()/2 >= position)
            {
                //Log.d("SetupCategoryAdapter", "getItem: ===============FINISH===============");
                return c_SetupCategoryItem.get(position);
            }
            else
            {
                //Log.d("SetupCategoryAdapter", "getItem: ===============FINISH===============");
                return null;
            }
        }
        catch (Exception ex)
        {
            c_PoyntError.SendPoyntStackTrace(ex.getStackTrace().toString());
        }
        return null;
    }

    @Override
    public long getItemId(int position)
    {
        long l_lID;

        //Log.d("SetupCategoryAdapter", "getItemId: ===============START===============");

        try
        {
            l_lID = (long)position;

            //Log.d("SetupCategoryAdapter", String.format("getItemId: l_lID=%d", l_lID));

            //Log.d("SetupCategoryAdapter", "getItemId: ===============FINISH===============");
            return l_lID;
        }
        catch (Exception ex)
        {
            c_PoyntError.SendPoyntStackTrace(ex.getStackTrace().toString());
        }
        return 0;
    }
}

