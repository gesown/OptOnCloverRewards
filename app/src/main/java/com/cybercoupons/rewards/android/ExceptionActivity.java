package com.cybercoupons.rewards.android;
//package com.clover.optin.rewards.android;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.cybercoupons.rewards.android.ExceptionHandler;

public class ExceptionActivity extends Activity {

    TextView error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler(this));
        setContentView(R.layout.activity_error);

        error = (TextView) findViewById(R.id.error);

        error.setText(getIntent().getStringExtra("error"));
    }
}