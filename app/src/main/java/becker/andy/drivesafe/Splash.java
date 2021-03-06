package becker.andy.drivesafe;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash extends AppCompatActivity {
    private ImageView car_logo;
    private TextView slogan;
    private static int splashTimeOut=1900;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        car_logo=(ImageView)findViewById(R.id.car_logo);
        slogan=(TextView)findViewById(R.id.slogan);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Splash.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        },splashTimeOut);

        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.car_gone);
        car_logo.startAnimation(myanim);

        Animation myanime=AnimationUtils.loadAnimation(this, R.anim.fadein);
        slogan.startAnimation(myanime);

    }
}
