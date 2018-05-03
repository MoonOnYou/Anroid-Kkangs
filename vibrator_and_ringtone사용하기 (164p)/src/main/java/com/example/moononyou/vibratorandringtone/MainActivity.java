package com.example.moononyou.vibratorandringtone;

import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button vibrationBtn;
    Button systemBeepBtn;
    Button customBeepBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vibrationBtn=(Button)findViewById(R.id.btn_vibration);
        systemBeepBtn=(Button)findViewById(R.id.btn_system_beep);
        customBeepBtn=(Button)findViewById(R.id.btn_custom_sound);

        vibrationBtn.setOnClickListener(this);
        systemBeepBtn.setOnClickListener(this);
        customBeepBtn.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        if(v==vibrationBtn){
            Vibrator vib=(Vibrator)getSystemService(VIBRATOR_SERVICE);
            vib.vibrate(1000);
        }else if(v==systemBeepBtn){
            Uri notification= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            Ringtone ringtone =RingtoneManager.getRingtone(getApplicationContext(),notification);
            ringtone.play();
        } else if (v == customBeepBtn) {
            MediaPlayer player=MediaPlayer.create(this,R.raw.fallbackring);
            player.start();
        }
    }
}
