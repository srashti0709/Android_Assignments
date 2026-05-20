package com.example.myapplication;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
EditText name , mob , add;
TextView t1 , t2 , t3,t4,t5,t6;
Button btn;
RadioGroup rg;
ImageButton dpd;
String d;
CheckBox ch1,ch2,ch3,ch4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            name= findViewById(R.id.name);
            t1 = findViewById(R.id.tname1);
            btn = findViewById(R.id.btn);
            mob = findViewById(R.id.mob);
            t2 = findViewById(R.id.tname2);
            add = findViewById(R.id.add);
            t3 = findViewById(R.id.tname3);
            t4 = findViewById(R.id.tname4);
            rg = findViewById(R.id.rg);
            t5 =  findViewById(R.id.tname5);
            ch1 = findViewById(R.id.ch1);
            ch2 = findViewById(R.id.ch2);
            ch3 = findViewById(R.id.ch3);
            ch4 = findViewById(R.id.ch4);
            t6 =findViewById(R.id.tname6);
            dpd = findViewById(R.id.dpd);
            Calendar calendar = Calendar.getInstance();
            int year   =  calendar.get(Calendar.YEAR);
            int month  =  calendar.get(Calendar.MONTH);
            int day  = calendar.get(Calendar.DAY_OF_MONTH);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String Hobbies = "";
                    t1.setText(t1.getText().toString() + name.getText().toString());
                    t2.setText(t2.getText().toString() + mob.getText().toString());
                    t3.setText(t3.getText().toString() + add.getText().toString());
                    int aa = rg.getCheckedRadioButtonId();
                    RadioButton rb = findViewById(aa);
                    t4.setText(t4.getText().toString() + rb.getText().toString());
                    t5.setText(t5.getText().toString() + d);
                    if(ch1.isChecked())
                        Hobbies = ch1.getText().toString();
                    if(ch2.isChecked())
                        Hobbies = Hobbies + " ," + ch2.getText().toString();
                    if(ch3.isChecked())
                        Hobbies = Hobbies + " ," + ch3.getText().toString();
                    if(ch4.isChecked())
                        Hobbies = Hobbies + " ," + ch4.getText().toString();
                    t6.setText(t6.getText().toString() + Hobbies);
                }

            });
            dpd.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    DatePickerDialog dp = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year1, int month1, int day1) {
                            d = day1 + "/" + (month1+1)  + "/" + year1;
                        }
                    },year,month,day);
                    dp.show();
                }
            });
            return insets;
        });
    }
}