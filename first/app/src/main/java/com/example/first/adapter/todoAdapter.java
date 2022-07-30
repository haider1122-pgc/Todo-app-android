package com.example.first.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextClock;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.first.R;
import com.example.first.Todo_app;
import com.example.first.model.todoModel;

import java.util.List;

public class todoAdapter extends RecyclerView.Adapter<todoAdapter.ViewHolder> {
    private List<todoModel> lst;
    private Todo_app todo;

    public todoAdapter(Todo_app todo){
        this.todo=todo;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent , int viewType ){
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent ,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        todoModel item = lst.get(position);
        holder.title.setText(item.getTitle());
        holder.task.setChecked(item.isStatus());

        holder.time.setText(item.getTime());


    }

    @Override
    public int getItemCount() {
        return lst.size();
    }
    public void setTask(List<todoModel> tasklst){
        this.lst=tasklst;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
         CheckBox task;
         TextView time,title;
         TextView description;
         View v;

         ViewHolder(View  view ) {
            super(view);
            task = view.findViewById(R.id.todo_checkbox);
            title=view.findViewById(R.id.title);
            time=view.findViewById(R.id.txt_start_time);


            // description=view.findViewById(R.id.description);
        }
    }

}

