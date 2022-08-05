package com.example.first;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
     Button btn;
     EditText e,email,pass;
     CheckBox c;
    TextView t,f;
    Button bt;
    EditText pss;
    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final  Intent i = new Intent(MainActivity.this,log_in_screen.class);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(i);
            }
        },1000);









    }
    private void openNewAvtivityOnTVClick() {
       // e =  (EditText) findViewById(R.id.tv1);
        //String te = e.getText().toString();
        Intent intent = new Intent(this, signup_screen.class);
       // intent.putExtra("message",te); //to access the widgets of second activity
        startActivity(intent);



    }
    private void openNewAvtivityOnbtnClick() {
        // e =  (EditText) findViewById(R.id.tv1);
        //String te = e.getText().toString();
        Intent intent = new Intent(this, Todo_app.class);
        // intent.putExtra("message",te); //to access the widgets of second activity
        startActivity(intent);



    }
    public void createNewDialougue(){
        dialogBuilder = new AlertDialog.Builder(this );
        final  View popup=getLayoutInflater().inflate(R.layout.popup,null);
        //get data from popup here
        dialogBuilder.setView(popup);
        dialog=dialogBuilder.create();
        dialog.show();


    }
}