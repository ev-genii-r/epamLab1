package com.epam.lab1.animation;

public class ErrorPageAnimation extends Thread{
    int number;
    @Override
    public void run(){
        for(int i=0;i<10000; i++){
            number=i;
        }

    }
    public int getNumber(){
        return number;
    }
}
