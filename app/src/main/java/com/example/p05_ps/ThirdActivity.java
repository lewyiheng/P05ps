package com.example.p05_ps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    TextView tvID;
    EditText etTitle,etSinger,etYear;
    RadioGroup rg;
    RadioButton rb;
    Button btncancel, btndelete, btnupdate;
    Song data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);


        tvID = findViewById(R.id.tvID);

        etTitle = findViewById(R.id.etTitle);
        etSinger = findViewById(R.id.etSinger);
        etYear = findViewById(R.id.etYear);

        rg = findViewById(R.id.rg);
        rb =findViewById(rg.getCheckedRadioButtonId());

        btncancel = findViewById(R.id.btnCancel);
        btnupdate = findViewById(R.id.btnUpdate);
        btndelete = findViewById(R.id.btnDelete);

        final Intent i = getIntent();
        data = (Song) i.getSerializableExtra("data");

        tvID.setText(data.get_id());
        etTitle.setText(data.getTitle());
        etSinger.setText(data.getSingers());
        etYear.setText(data.getYears());
        ((RadioButton)rg.getChildAt(data.getStars())).setChecked(true);



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
                data.setTitle(etTitle.getText().toString());
                data.setSingers(etSinger.getText().toString());
                data.setYears(Integer.parseInt(etYear.getText().toString()));
                data.setStars(Integer.parseInt(rb.getText().toString()));
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
