package com.example.p05_ps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    EditText etSong, etSinger, etYear;
    RadioGroup rg;
    RadioButton rb;
    Button btnInsert, btnShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etSong=findViewById(R.id.editTextTittle);
        etSinger=findViewById(R.id.editTextSinger);
        etYear=findViewById(R.id.editTextYear);
        rg=findViewById(R.id.RadioGroup);

        int selectedButtonId=rg.getCheckedRadioButtonId();
        rb=findViewById(selectedButtonId);

        btnInsert=findViewById(R.id.buttonInsert);
        btnShow=findViewById(R.id.buttonShow);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String singer=etSinger.getText().toString();
                String song=etSong.getText().toString();
                int year=Integer.parseInt(etYear.getText().toString());
                int star=Integer.parseInt(rb.getText().toString());
                DBHelper dbh=new DBHelper(MainActivity.this);
                long row_affected=dbh.insertSong(song);
                long row_affected=dbh.insertSinger(singer);
                long row_affected=dbh.insertYear(year);
                long row_affected=dbh.insertStar(star);
                dbh.close();




            }
        });





    }
}
