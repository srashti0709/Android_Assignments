package com.example.assignment8;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity {

    Button save, send, dial;
    EditText num1, num2, num3;

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // permissions
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CALL_PHONE}, 100);
        }

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.SEND_SMS}, 101);
        }

        // init views
        save = findViewById(R.id.btn1);
        send = findViewById(R.id.btn2);
        dial = findViewById(R.id.btn3);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        num3 = findViewById(R.id.num3);

        // shared prefs
        preferences = getSharedPreferences("contacts", MODE_PRIVATE);
        editor = preferences.edit();

        loadContacts();

        // SAVE
        save.setOnClickListener(v -> {
            editor.putString("num1", num1.getText().toString());
            editor.putString("num2", num2.getText().toString());
            editor.putString("num3", num3.getText().toString());
            editor.apply();

            Toast.makeText(this, "Contacts Saved", Toast.LENGTH_SHORT).show();
        });

        // SEND SMS (to all numbers)
        send.setOnClickListener(v -> {
            String message = "🚨 I am in trouble! Please help.";

            sendSMS(num1.getText().toString(), message);
            sendSMS(num2.getText().toString(), message);
            sendSMS(num3.getText().toString(), message);

            Toast.makeText(this, "SOS Sent", Toast.LENGTH_SHORT).show();
        });

        // CALL
        dial.setOnClickListener(v -> {
            String number = num1.getText().toString();

            if (!number.isEmpty()) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + number));
                startActivity(intent);
            } else {
                Toast.makeText(this, "Enter number first", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void sendSMS(String number, String msg) {
        if (number == null || number.isEmpty()) return;

        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(number, null, msg, null, null);
    }

    private void loadContacts() {
        num1.setText(preferences.getString("num1", ""));
        num2.setText(preferences.getString("num2", ""));
        num3.setText(preferences.getString("num3", ""));
    }
}