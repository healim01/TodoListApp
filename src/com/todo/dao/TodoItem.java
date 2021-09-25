package com.todo.dao;

import java.util.Date;
import java.text.SimpleDateFormat;

public class TodoItem {
	private String cate;
    private String title;
    private String desc;
    private String deadline;
    private String date;


    public TodoItem(String cate, String title, String desc, String deadline){
    	this.cate=cate;
        this.title=title;
        this.desc=desc;
        this.deadline=deadline;
        Date d = new Date();
        SimpleDateFormat form = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        this.date=form.format(d);
    }
    
    public TodoItem(String cate, String title, String desc, String deadline, String date){
    	this.cate=cate;
        this.title=title;
        this.desc=desc;
        this.deadline=deadline;
        this.date=date;
    }
    
    public String getCate() {
    	return cate;
    }
    
    public void setCate(String cate) {
    	this.cate = cate;
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
    
    public String getDeadline() {
    	return deadline;
    }
    
    public void setDeadline(String deadline) {
    	this.deadline = deadline;
    }

    public String getCurrent_date() {
        return date;
    }

    public void setCurrent_date(String date) {
        this.date = date;
    }
    
    public String toString() {
    	return "[" + cate + "] " + title + " - " + desc +  " - " + deadline + " - " + date;
    }
    
    public String toSaveString() {
    	return cate + "##" + title + "##" + desc + "##" + deadline + "##" + date + "\n";
    }
}
