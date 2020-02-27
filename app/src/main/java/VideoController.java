package com.cybercoupons.rewards.android;

import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.VideoView;

import com.cybercoupons.rewards.android.R;

/**
 * Created by CarlB on 9/7/2017.
 */
public class VideoController extends MediaController {

    private Button l_btnStop;
    private Context l_Context;
    private VideoView l_Player;
    private WebView l_WebView;
    public boolean c_bVideoStarted = false;
    private RelativeLayout c_llVideo;
    private FrameLayout c_anchorView;
    private ImageView c_btnClose;

    public VideoController(Context p_context, FrameLayout p_anchorView, VideoView p_Player, WebView p_WebView, String p_strURL) {
        super(p_context);

        Log.d("VideoController", "=====START=====");

        try {
            l_Context = p_context;
            l_Player = p_Player;
            l_WebView = p_WebView;
            c_llVideo = (RelativeLayout)l_Player.getParent();
            c_anchorView = p_anchorView;

            this.requestLayout();

            setHovered(true);
            setSystemUiVisibility(View.VISIBLE);
            setVisibility(View.VISIBLE);
            setEnabled(true);
            setMediaPlayer(l_Player);
            l_Player.setVideoPath(p_strURL);

            //c_llVideo.setVisibility(View.VISIBLE);
            //l_Player.setVisibility(View.VISIBLE);

            //show();
            c_bVideoStarted = true;

            //show(900000000);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }

        Log.d(":VideoController", "=====FINISH=====");
    }

    @Override
    public void setAnchorView(View view) {
        super.setAnchorView(view);

        try {

            Log.d("VideoController::setAnchorView", "=====START=====");

            c_btnClose = new ImageView(getContext());

            if(c_btnClose!= null) {

                c_btnClose.setImageResource(android.R.drawable.ic_menu_close_clear_cancel);
                float padding = getResources().getDimension(R.dimen.text_margin);
                c_btnClose.setPadding((int) padding, (int) padding, (int) padding, (int) padding);
                FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

                params.gravity = Gravity.START;
                addView(c_btnClose, params);

                c_btnClose.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        l_Player.stopPlayback();
                        //l_Player.setVisibility(View.INVISIBLE);
                        l_Player.setVisibility(View.GONE);
                        l_Player.setSystemUiVisibility(View.INVISIBLE);
                        setVisibility(View.INVISIBLE);
                        setSystemUiVisibility(View.INVISIBLE);
                        if (c_llVideo != null) {
                            c_llVideo.setVisibility(View.INVISIBLE);
                        }
                        hide();

                        l_WebView.setVerticalScrollBarEnabled(true);

                        if (MainActivity.c_bShowSetupVideo == true) {
                            l_WebView.setVisibility(View.INVISIBLE);
                            MainActivity.c_bShowSetupVideo = false;

                            MainActivity.c_imgSetup.setVisibility(View.VISIBLE);
                            MainActivity.c_tvSetup_Category_Items.setVisibility(View.VISIBLE);
                            MainActivity.c_gvSetup_Category_Items.setVisibility(View.VISIBLE);
                            MainActivity.c_btnSetup_Continue.setVisibility(View.VISIBLE);

                            // Prompt Clover Merchant for Email Address to send info to <CarlB 10-06-2017>
                            MainActivity.GetEmailDialog();
                        }
                    }
                });
            }

            Log.d("VideoController::setAnchorView", "=====FINISH=====");
        }
        catch (Exception ex)
        {
            ex.getStackTrace();
        }
    }

    @Override
    public void show(int timeout) {
        try {


            super.show(timeout);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    @Override
    public void hide() {
        try {

            Log.d("VideoController::hide", "=====START=====");

            if(c_bVideoStarted == true) {
                if (l_Player.isPlaying() == false) {
                    super.hide();
                }
            }
            Log.d("VideoController::hide", "=====FINISH=====");
        }
        catch (Exception ex)
        {
            ex.getStackTrace();
        }
    }

    @Override
    protected void onSizeChanged(int xNew, int yNew, int xOld, int yOld)
    {
        super.onSizeChanged(xNew, yNew, xOld, yOld);

        RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) c_anchorView.getLayoutParams();
        lp.setMargins(0, 0, 0, yNew);
        c_anchorView.setLayoutParams(lp);
        c_anchorView.requestLayout();
    }

}