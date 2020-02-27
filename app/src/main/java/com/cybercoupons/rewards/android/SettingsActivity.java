package com.cybercoupons.rewards.android;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.clover.android.sdk.BuildConfig;
import com.cybercoupons.rewards.android.ExceptionHandler;

import java.net.URLEncoder;

public class SettingsActivity extends Activity implements OnClickListener {
    public static final String PREFS_NAME = "CyberPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        try
        {
            super.onCreate(savedInstanceState);

            Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler(this));

            setContentView(R.layout.activity_settings);

            Button buttonA = (Button) findViewById(R.id.button);
            buttonA.setOnClickListener(this);

            Button buttonB = (Button) findViewById(R.id.button2);
            buttonB.setOnClickListener(this);

            Button buttonC = (Button) findViewById(R.id.button3);
            buttonC.setOnClickListener(this);

            SharedPreferences prfs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
            String str_storeID = prfs.getString("Store_ID", "");
            String str_storePassword = prfs.getString("Store_Password", "");
            String str_timeout = prfs.getString("Timeout", "");
            String str_timeoutChecked = prfs.getString("Timeout_Checked", "");

            String Checkbox1_Checked = prfs.getString("Checkbox1_Checked", "");
            String Checkbox2_Checked = prfs.getString("Checkbox2_Checked", "");
            String Checkbox3_Checked = prfs.getString("Checkbox3_Checked", "");
            String Checkbox4_Checked = prfs.getString("Checkbox4_Checked", "");

            TextView storeID = (TextView) findViewById(R.id.txt_storeID);
            TextView storePassword = (TextView) findViewById(R.id.txt_storePassword);
            TextView timeoutText = (TextView) findViewById(R.id.timeoutText);
            TextView versionText = (TextView) findViewById(R.id.textViewVersion);
            CheckBox timeoutCheckbox = (CheckBox) findViewById(R.id.timeoutCheckbox);

            CheckBox Checkbox1 = (CheckBox) findViewById(R.id.checkBox1);
            CheckBox Checkbox2 = (CheckBox) findViewById(R.id.checkBox2);
            CheckBox Checkbox3 = (CheckBox) findViewById(R.id.checkBox3);
            CheckBox Checkbox4 = (CheckBox) findViewById(R.id.checkBox4);

            storeID.setText(str_storeID.toString());
            storePassword.setText(str_storePassword.toString());
            versionText.setText("Version: " + BuildConfig.VERSION_NAME + " " + BuildConfig.VERSION_CODE);

            //this part not working
            if (str_timeout.length() > 0)
                timeoutText.setText(str_timeout.toString());
            //this part working fine...
            if (str_timeoutChecked.length() > 0)
                timeoutCheckbox.setChecked(Boolean.parseBoolean(str_timeoutChecked.toString()));
            if (Checkbox1_Checked.length() > 0) {
                Checkbox1.setChecked(Boolean.parseBoolean(Checkbox1_Checked.toString()));
            } else {
                //set it
                SharedPreferences preferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("Checkbox1_Checked", "false");
                Checkbox1.setChecked(false);
            }
            if (Checkbox2_Checked.length() > 0) {
                Checkbox2.setChecked(Boolean.parseBoolean(Checkbox2_Checked.toString()));
            } else {
                //set it
                SharedPreferences preferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("Checkbox2_Checked", "false");
                Checkbox2.setChecked(false);
            }
            if (Checkbox3_Checked.length() > 0) {
                Checkbox3.setChecked(Boolean.parseBoolean(Checkbox3_Checked.toString()));
            } else {
                //set it
                SharedPreferences preferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("Checkbox3_Checked", "true");
                Checkbox3.setChecked(true);
            }
            if (Checkbox4_Checked.length() > 0) {
                Checkbox4.setChecked(Boolean.parseBoolean(Checkbox4_Checked.toString()));
            } else {
                //set it
                SharedPreferences preferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("Checkbox4_Checked", "true");
                Checkbox4.setChecked(true);
            }
        }
        catch(final Exception ex)
        {
            //SendCloverStackTrace(URLEncoder.encode(Log.getStackTraceString(ex)));

            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(), "CyberCoupons Rewards: Settings.onCreate Exception=" + ex.getMessage(), Toast.LENGTH_LONG).show();
                    ex.printStackTrace();
                }
            });


        }
    }

    DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which)
            {
                case DialogInterface.BUTTON_POSITIVE:
                    //Yes button clicked
                    SharedPreferences preferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("Access_Token","");
                    finish();
                    //startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    break;

                case DialogInterface.BUTTON_NEGATIVE:
                    //No button clicked
                    break;
            }
        }
    };

    public void onClick(View v)
    {
        try {
            SharedPreferences preferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            switch (v.getId()) {
                case R.id.button3:
                    AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                    builder.setMessage("Are you sure you want to reset the Clover Merchant Key?").setPositiveButton("Yes", dialogClickListener)
                            .setNegativeButton("No", dialogClickListener).show();
                    break;
                case R.id.button2:
                    finish();
                    //startActivity(new Intent(this, MainActivity.class));
                    break;
                case R.id.button:
                    //set
                    TextView storeID = (TextView) findViewById(R.id.txt_storeID);
                    TextView storePassword = (TextView) findViewById(R.id.txt_storePassword);

                    CheckBox Checkbox1 = (CheckBox) findViewById(R.id.checkBox1);
                    CheckBox Checkbox2 = (CheckBox) findViewById(R.id.checkBox2);
                    CheckBox Checkbox3 = (CheckBox) findViewById(R.id.checkBox3);
                    CheckBox Checkbox4 = (CheckBox) findViewById(R.id.checkBox4);

                    editor.putString("Store_ID", storeID.getText().toString());
                    editor.putString("Store_Password", storePassword.getText().toString());

                    editor.putString("Checkbox1_Checked", String.valueOf(Checkbox1.isChecked()));
                    editor.putString("Checkbox2_Checked", String.valueOf(Checkbox2.isChecked()));
                    editor.putString("Checkbox3_Checked", String.valueOf(Checkbox3.isChecked()));
                    editor.putString("Checkbox4_Checked", String.valueOf(Checkbox4.isChecked()));

                    editor.putString("Authenticated", "true");
                    editor.apply();
                    finish();
                    //startActivity(new Intent(this, MainActivity.class));
                    break;
            }
        }
        catch(final Exception ex)
        {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(), "CyberCoupons Rewards: Settings.onClick Exception=" + ex.getMessage(), Toast.LENGTH_LONG).show();
                    ex.printStackTrace();
                }
            });


        }
    }
}
