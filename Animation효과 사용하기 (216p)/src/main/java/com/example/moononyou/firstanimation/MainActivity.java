package com.example.moononyou.firstanimation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView=(ImageView)findViewById(R.id.img); //애니매이션 획득
        Animation anim = AnimationUtils.loadAnimation(this,R.anim.in);
        anim.setAnimationListener(new Animation.AnimationListener(){
            @Override
            public void onAnimationStart(Animation animation){}
            @Override
            public void onAnimationEnd(Animation animation){
                Animation anim = AnimationUtils.loadAnimation(MainActivity.this,R.anim.move);
                //마지막 상황에서 멈추게 ,안그러면 원상복귀
                anim.setFillAfter(true);
                imageView.startAnimation(anim);
            }
            @Override
            public void onAnimationRepeat(Animation animation){

            }
        });
        //애니메이션 시작
        imageView.startAnimation(anim);
    }

}
