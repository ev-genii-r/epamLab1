package com.epam.lab1.parametres;

import validator.Validator;

public class entityParametres {
    double speed=1;
    double length=1;
    double time=0;
    String exceptionLength="";
    String exceptionSpeed="";
    String exceptionTime="";
    public entityParametres(String exceptionLength,String exceptionSpeed,String exceptionTime){
        this.exceptionLength=exceptionLength;
        this.exceptionSpeed=exceptionSpeed;
        this.exceptionTime=exceptionTime;
    }
   public entityParametres(double speed,double length){
        this.speed=speed;
        this.length=length;
    }
    public entityParametres(){
    }
    public double getInputSpeed(){
        return speed;
    }
    public double getInputLength(){
        return length;
    }
    public String getExceptionTime(){
        return exceptionTime;
    }
    public String getExceptionSpeed(){
        return exceptionSpeed;
    }
    public String getExceptionLength(){
        return exceptionLength;
    }
    public double  getSpeed(){
        time=length/speed;
        return time;
    }
//   public interface Calculation<T>{
//        double resultCalculation(T s, T l);
//    }
//   public interface Transformation<T>{
//        double resultTransformation(T t);
//    }

}
