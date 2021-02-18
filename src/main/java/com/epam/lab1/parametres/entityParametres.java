package com.epam.lab1.parametres;

import validator.Validator;

public class entityParametres {
    double speed=1;
    double length=1;
    double time=0;
    public entityParametres(){

    }
   public entityParametres(double speed,double length){
    this.speed=speed;
    this.length=length;
    }
    public void setSpeed(int speed){
        this.speed=speed;
    }
    public void setLength(int length){
        this.length=length;
    }
    public double  getSpeed(){
        time=length/speed;
        return time;
    }

}
