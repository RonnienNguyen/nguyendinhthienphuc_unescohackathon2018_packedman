package tabian.com.instagramclone;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import tabian.com.instagramclone.Home.*;
import tabian.com.instagramclone.R;

/**
 * Created by dell on 3/4/2018.
 */

public class splashscreenhome extends AppCompatActivity {
    private TextView tv;
    private ImageView iv;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Anhxa();


    }


    private void Anhxa(){
        tv = (TextView)findViewById(R.id.tv);
        iv = (ImageView)findViewById(R.id.iv);

        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.mytransition);
        tv.startAnimation(myanim);
        iv.startAnimation(myanim);

        final Intent i = new Intent(this, tabian.com.instagramclone.Home.HomeActivity.class);

        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    startActivity(i);
                    finish();

                }
            }
        };
        timer.start();
    }
}
