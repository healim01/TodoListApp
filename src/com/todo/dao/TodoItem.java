package com.todo.dao;

import java.util.Date;
import java.text.SimpleDateFormat;

public class TodoItem {
    private String title;
    private String desc;
    private String date;


    public TodoItem(String title, String desc){
        this.title=title;
        this.desc=desc;
        Date d = new Date();
        SimpleDateFormat form = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        this.date=form.format(d);
    }
    
    public TodoItem(String title, String desc, String date){
        this.title=title;
        this.desc=desc;
        this.date=date;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCurrent_date() {
        return date;
    }

    public void setCurrent_date(String date) {
        this.date = date;
    }
    
    public String toString() {
    	return "[" + title + "] " + desc +  " - " + date;
    }
    
    public String toSaveString() {
    	return title + "##" + desc + "##" + date + "\n";
    }
}
