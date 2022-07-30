package com.example.first;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class secondPage extends AppCompatActivity {
    TextView e1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);

        //creating reffrence function from another activity
        e1=(TextView) findViewById(R.id.tv2);
        e1.setText(getIntent().getStringExtra("message"));
    }
}