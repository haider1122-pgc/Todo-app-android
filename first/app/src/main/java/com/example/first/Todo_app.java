package com.example.first;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.first.adapter.todoAdapter;
import com.example.first.model.exampleDialoge;
import com.example.first.model.todoModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class Todo_app extends AppCompatActivity {

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
        todoModel t2 = new todoModel("reading","hoppies requirement","16 jul, 2018 10:12:11",true);
        todoModel t3 = new todoModel("cricket match","highly important ","15 jul, 2018 10:12:11",false);
        todoModel t4 = new todoModel("assignment2","need to complete in time","18 jul, 2018 10:12:11",false);
        taskLst.add(t1);
        taskLst.add(t2);
        taskLst.add(t3);
        taskLst.add(t4);
        taskadapter.setTask(taskLst);
    }
}