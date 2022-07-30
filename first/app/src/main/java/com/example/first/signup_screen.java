package com.example.first;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class signup_screen extends AppCompatActivity {
    TextView t,t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_screen);
        t= (TextView)findViewById(R.id.already);
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  Toast.makeText(getApplicationContext(), te, Toast.LENGTH_LONG).show();


                openNewAvtivityOnTVClick();
            }


        });
        t1= (TextView)findViewById(R.id.bck);
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  Toast.makeText(getApplicationContext(), te, Toast.LENGTH_LONG).show();


                openNewAvtivityOnTVClick();
            }


        });
    }
    private void openNewAvtivityOnTVClick() {
        // e =  (EditText) findViewById(R.id.tv1);
        //String te = e.getText().toString();
        Intent intent = new Intent(this, MainActivity.class);
        // intent.putExtra("message",te); //to access the widgets of second activity
        startActivity(intent);



    }
}