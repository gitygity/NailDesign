package ir.harmonyapp.gity.naildesign;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {
    ImageView logoapp;
    TextView titleapp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        logoapp = (ImageView) findViewById(R.id.logoapp);
        titleapp = (TextView) findViewById(R.id.titleapp);


        Animation animation= AnimationUtils.loadAnimation(SplashActivity.this,R.anim.fade);
        animation.reset();
        titleapp.startAnimation(animation);
        logoapp.startAnimation(animation);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, Main.class);
                startActivity(intent);
                finish();

            }
        }, 4000);
    }
}
