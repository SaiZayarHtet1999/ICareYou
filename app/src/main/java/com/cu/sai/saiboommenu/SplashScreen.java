package com.cu.sai.saiboommenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.Objects;

public class SplashScreen extends AppCompatActivity {
    VideoView videoView;
    TextView textView;
Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash_screen);
        animation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.anim);
        Objects.requireNonNull(getSupportActionBar()).hide();
        videoView=findViewById(R.id.splashScreenVideo);
        textView=findViewById(R.id.textSplash);
        textView.setAnimation(animation);
        Uri video= Uri.parse(("android.resource://"+getPackageName()+"/"+R.raw.we_care_you_final_animation));
        videoView.setVideoURI(video);
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                if(isFinishing())
                    return;

               if (!isFirstTimeStatApp()){
                   Intent intent=new Intent(SplashScreen.this,MainActivity.class);
                   startActivity(intent);
                }
                else{
                    startMainActivity();
                   }

                finish();
            }
        });
        videoView.start();
    }

    private boolean isFirstTimeStatApp(){
        SharedPreferences ref=getApplicationContext().getSharedPreferences("IntroSliderApp", Context.MODE_PRIVATE);
        return ref.getBoolean("FirstTimeStartFlag",true);
    }
    private void setFirstTimeStartStatus(boolean stt) {
        SharedPreferences ref = getApplicationContext().getSharedPreferences("IntroSliderApp", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = ref.edit();
        editor.putBoolean("FirstTimeStartFlag", stt);
        editor.apply();
    }

    private void startMainActivity() {
        setFirstTimeStartStatus(true);///this is important<<<<<<<<<change<to<<<<<<true<<<<<<<for<Testing<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
        startActivity(new Intent(SplashScreen.this, ForRequestUserInformation1.class));
        finish();
    }
}
