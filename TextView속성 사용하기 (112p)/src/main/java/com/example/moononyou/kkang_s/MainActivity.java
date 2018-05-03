package com.example.moononyou.kkang_s;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView=(TextView)findViewById(R.id.fontView);
        Typeface typeface=Typeface.createFromAsset(getAssets(),"xmas.ttf");
        textView.setTypeface(typeface);

        checkBox=(CheckBox)findViewById(R.id.checkbox);
        checkBox.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener(){
                    // Ctrl + o 누르면, overwrite 할 수 있는 메서드 목록이 나온다.
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if(isChecked){
                            checkBox.setText("is Checked");
                        }else {
                            checkBox.setText("is unChecked");
                        }
                    }
                }
        );
    }
}
