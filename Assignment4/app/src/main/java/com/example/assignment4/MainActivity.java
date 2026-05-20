package com.example.assignment4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RadioGroup rg;
    CheckBox ch1, ch2, ch3, ch4;
    Button btn;
    TextView sd, sf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        rg = findViewById(R.id.rg);
        ch1 = findViewById(R.id.notify);
        ch2 = findViewById(R.id.dm);
        ch3 = findViewById(R.id.loc);
        ch4 = findViewById(R.id.cb);
        btn = findViewById(R.id.btn);
        sd = findViewById(R.id.selected_device);
        sf = findViewById(R.id.selected_feature);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selectedId = rg.getCheckedRadioButtonId();
                RadioButton rb = findViewById(selectedId);

                sd.setText(sd.getText().toString()+" "+ rb.getText());
                String features = "";
                if(ch1.isChecked())
                    sf.setText(sf.getText().toString() + " "+ ch1.getText().toString());
                if(ch2.isChecked())
                    sf.setText(sf.getText().toString() + " ,"+ ch2.getText().toString());
                if(ch3.isChecked())
                    sf.setText(sf.getText().toString() + " ,"+ ch3.getText().toString());
                if(ch4.isChecked())
                    sf.setText(sf.getText().toString() + " ,"+ ch4.getText().toString());
            }
        });
    }
}