package com.example.human;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.example.human.home.PageNavigation;

/**
 * Created by Millochka on 1/26/17.
 */

public class SplashScreen extends Activity {

    Thread splashTread;

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        window.setFormat(PixelFormat.RGBA_8888);
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        StartAnimations();
    }


    private void StartAnimations() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        anim.reset();

        Animation anim2=AnimationUtils.loadAnimation(this, R.anim.beta);
        anim2.reset();
        LinearLayout l= findViewById(R.id.splash_screen);
        l.clearAnimation();
        l.startAnimation(anim);
        anim = AnimationUtils.loadAnimation(this, R.anim.translate);
        anim.reset();
        ImageView iv = findViewById(R.id.profile_image);
        ImageView tx= findViewById(R.id.app_name);
        iv.clearAnimation();
        iv.startAnimation(anim);
        tx.clearAnimation();
        tx.startAnimation(anim2);
        splashTread = new Thread() {

            @Override
            public void run() {
                try {
                    int waited = 0;
// Splash screen pause time
                    while (waited < 5000) {
                        sleep(100);
                        waited += 100;
                    }
                    Intent intent = new Intent(SplashScreen.this,
                            PageNavigation.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    SplashScreen.this.finish();
                } catch (InterruptedException e) {
// do nothing
                } finally {
                    SplashScreen.this.finish();
                }
            }
        };
        splashTread.start();

        }
}
