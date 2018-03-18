package com.example.moononyou.challenge01_mission2_answer;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setMessage("정말 나가실 거에요?");
        builder.setPositiveButton("확인",dialogListener);
        builder.setNegativeButton("취소",null);
        AlertDialog dialog= builder.create();
        dialog.show();
    }
    DialogInterface.OnCancelListener dialogListener=new DialogInterface.OnClickListener(){
        @Override
        public void onClick(DialogInterface dialog,int which){
            finish();
        }
    };
}
