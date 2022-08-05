package com.example.first.model;

import java.util.concurrent.atomic.AtomicInteger;

public class todoModel {

    private String title,descriptipn;
    private String time;
    private boolean status;

    public todoModel(String title, String descriptipn, String time, boolean status) {
        this.title = title;
        this.descriptipn = descriptipn;
        this.time = time;
        this.status = status;

    }
    public todoModel(String title, String descriptipn, String time) {
        this.title = title;
        this.descriptipn = descriptipn;
        this.time = time;


    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public todoModel(){

    }

    public String getTitle() {
        return title;
    }



    public String getDescriptipn() {
        return descriptipn;
    }

    public String getTime() {
        return time;
    }

    public boolean isStatus() {
        return status;
    }
    
}
