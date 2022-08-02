package com.example.first;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.first.adapter.todoAdapter;
import com.example.first.model.exampleDialoge;
import com.example.first.model.todoModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Todo_app extends AppCompatActivity implements exampleDialoge.exampleDialogeListner {

    //this function of interface helps us to get input from dialougue window and add into list
    @Override
    public void applyTexts(String titl, String dis) {
        if(titl.equals("") || dis.equals("")|| titl.equals("Title")||dis.equals("Description"))
        {
            Toast.makeText(getApplicationContext(), "Invalid Input", Toast.LENGTH_LONG).show();
        }
        else {
            @SuppressLint("SimpleDateFormat") SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date();

            todoModel t = new todoModel(titl, dis, formatter.format(date).toString(), false);

            taskLst.add(t);
            taskadapter.setTask(taskLst);
        }

    }
    CheckBox chk;
    TextView textView;
    private RecyclerView recycler;
    private todoAdapter taskadapter;
    private List<todoModel> taskLst;
    FloatingActionButton btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_app);
        taskLst=new ArrayList<>();
        recycler= findViewById(R.id.tasksRecyclerView);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        taskadapter=new todoAdapter(this);
        recycler.setAdapter(taskadapter);
        ItemTouchHelper itemTouchHelper = new
                ItemTouchHelper(new RecyclerItemTouchHelper(taskadapter));
        itemTouchHelper.attachToRecyclerView(recycler);



        //creating on click listner for floating button
        btn = (FloatingActionButton)findViewById(R.id.add_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  Toast.makeText(getApplicationContext(), te, Toast.LENGTH_LONG).show();
               exampleDialoge e = new exampleDialoge();

               e.show(getSupportFragmentManager(),"Example dialoge");


            }


        });

        //dummy data
        todoModel t1 = new todoModel("assignment1","need to complete in time","15 jul, 2018 10:12:11",false);
        todoModel t2 = new todoModel("reading","hobbies requirement","16 jul, 2018 10:12:11",true);
        todoModel t3 = new todoModel("cricket match","highly important ","15 jul, 2018 10:12:11",false);
        todoModel t4 = new todoModel("assignment2","need to complete in time","18 jul, 2018 10:12:11",false);
        taskLst.add(t1);
        taskLst.add(t2);
        taskLst.add(t3);
        taskLst.add(t4);
        taskadapter.setTask(taskLst);
    }
}