package com.epam.lab1.SQL;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String speed, length, time;

    public Post(){}

    public Post(String speed, String length, Double time){
        this.speed=speed;
        this.length=length;
        this.time=time.toString();
    }

    public Post(String speed, String length, String time){
        this.speed=speed;
        this.length=length;
        this.time=time;
    }

    public void setGlobal(String speed, String length, String time){
        this.length = length;
        this.speed = speed;
        this.time = time;
    }

    public String getTime(){
        return this.time;
    }
    public String getSpeed(){
        return this.speed;
    }
    public String getLength(){
        return this.length;
    }
}
