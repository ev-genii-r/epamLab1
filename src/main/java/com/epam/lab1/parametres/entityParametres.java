package com.epam.lab1.parametres;

public class entityParametres {
    int speed=1;
    int length=1;
    int time;
    public entityParametres(){

    }
   public entityParametres(int speed,int length){
    this.speed=speed;
    this.length=length;
    }
    public void setSpeed(int speed){
        this.speed=speed;
    }
    public void setLength(int length){
        this.length=length;
    }
    public int  getSpeed(){
       time=length/speed;
        return time;
    }

}
