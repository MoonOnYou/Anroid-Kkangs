package com.example.moononyou.challenge01_mission01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button=(Button)findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Toast toast= Toast.makeText(MainActivity.this,"안녕하시렵니까",Toast.LENGTH_LONG);
                toast.show();
            }
        });

    }
}
