package com.example.p05_ps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    TextView tvID;
    Button btncancel, btndelete, btnupdate;
    Song data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);


        tvID = findViewById(R.id.tvID);
        btncancel = findViewById(R.id.btnCancel);
        btnupdate = findViewById(R.id.btnUpdate);
        btndelete = findViewById(R.id.btnDelete);

        final Intent i = getIntent();
        data = (Song) i.getSerializableExtra("data");


        btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(ThirdActivity.this);

                dbh.updateNote(data);
                dbh.close();
                setResult(RESULT_OK,i);
                finish();
            }
        });

        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(ThirdActivity.this);
                dbh.deleteNote(tvID.getId());
                dbh.close();
                setResult(RESULT_OK,i);
                finish();
            }
        });

    }


}
