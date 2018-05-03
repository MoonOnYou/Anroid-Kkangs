package com.example.moononyou.delegationevent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener,CompoundButton.OnCheckedChangeListener{

    TextView bellTextView;
    TextView labelTextView;
    CheckBox repeatCheckView;
    CheckBox vibrateCheckView;
    Switch switchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bellTextView = (TextView)findViewById(R.id.bell_name);
        labelTextView=(TextView)findViewById(R.id.label);
        repeatCheckView=(CheckBox)findViewById(R.id.repeatCheck);
        vibrateCheckView=(CheckBox)findViewById(R.id.vibrate);
        switchView=(Switch)findViewById(R.id.onOff);

        bellTextView.setOnClickListener(this);
        labelTextView.setOnClickListener(this);

        repeatCheckView.setOnCheckedChangeListener(this);
        vibrateCheckView.setOnCheckedChangeListener(this);
        switchView.setOnCheckedChangeListener(this);
    }

    private void showToast(String message){
        Toast toast=Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void onClick(View v){
        if(v==bellTextView){
            showToast("bell text click event...");
        } else if (v == labelTextView) {
            showToast("label text click event...");
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView,boolean isChecked){
        if(buttonView==repeatCheckView){
            showToast("repeat checkbox is"+isChecked);
        }else if(buttonView==vibrateCheckView){
            showToast("vibrate checkbox is"+isChecked);
        }else if(buttonView==switchView){
            showToast("switch is"+isChecked);
        }
    }

    float initX;
    @Override
    public boolean onTouchEvent(MotionEvent event){
        if(event.getAction()==MotionEvent.ACTION_DOWN){
            initX=event.getRawX();
        }else if(event.getAction()==MotionEvent.ACTION_UP) {
            float diffX = initX - event.getRawX();
            if (diffX > 30) {
                showToast("왼쪽으로 화면을 밀었습니다.");
            } else if (diffX < 30) {
                showToast("오른쪽으로 화면을 밀었습니다.");
            }
        }return true;
    }

    long initTime;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if(keyCode==KeyEvent.KEYCODE_BACK){
            if(System.currentTimeMillis()-initTime>3000){
                //back버튼을 누른지 3초가 지나면
                showToast("종료하려면 한번 더 누루세요");
                //현재 시간 저장
                initTime=System.currentTimeMillis();
            }else {
                //3초 이내에 back버튼이 2번 눌린경우 activity종료
                finish();
            }
            return  true;
        }
        return super.onKeyDown(keyCode,event);
    }


}
