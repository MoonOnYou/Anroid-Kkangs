package com.example.moononyou.mrkkang_s_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button trueBtn;
    TextView targetTextView;
    Button fasleBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //View객체획득

        trueBtn=(Button)findViewById(R.id.btn_visible_true);
        targetTextView=(TextView)findViewById(R.id.text_visible_target);
        fasleBtn=(Button)findViewById(R.id.btn_visible_false); //Button이벤트 등록
        trueBtn.setOnClickListener(this);
        fasleBtn.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        if (v==trueBtn) {
            //truebtn이 눌리면 targetTextView를 visible상태로 변경
            targetTextView.setVisibility(View.VISIBLE);
        }else if(v==fasleBtn){
            //fasleBtn이 눌리면targetTextView를 invisible상태로 변경
            targetTextView.setVisibility(View.INVISIBLE);

        }
    }
}
