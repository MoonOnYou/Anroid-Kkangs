package com.example.moononyou.sqlite;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText titleView;
    EditText contentView;
    Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleView=(EditText)findViewById(R.id.add_title);
        contentView=(EditText)findViewById(R.id.add_content);
        addBtn=(Button)findViewById(R.id.add_btn);

        addBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String title=titleView.getText().toString();
        String content=contentView.getText().toString();

        DBHelper helper =new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("insert into tb_memo(title,content) values (?,?)",
                new String[]{title,content});
        db.close();

        Intent intent=new Intent(this,ReadDBActivity.class);
        startActivity(intent);
    }
}
