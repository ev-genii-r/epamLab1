package com.epam.lab1.sort;

import com.epam.lab1.parametres.entityParametres;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;

public class Comparator {
    private static final Logger log = LogManager.getLogger();
    public ArrayList<entityParametres> sortCollection(ArrayList<entityParametres> list){
        int collectionLength=list.size();
        int[] array=new int[collectionLength];
        ArrayList<entityParametres> newList=new ArrayList<>();
        for(int i=0;i<collectionLength;i++){
            array[i]=i;
        }
        int temp;
        for(int j=0;j<collectionLength;j++) {
            for (int i = 0; i < collectionLength - 1; i++) {
                if ((list.get(i).getInputLength() + list.get(i).getInputSpeed()) > (list.get(i + 1).getInputLength() + list.get(i + 1).getInputSpeed())) {
                        log.error("yes");
                       temp=array[i];
                       array[i]=array[i+1];
                       array[i+1]=temp;
                }
            }
        }
        for(int i=0;i<collectionLength;i++) {
            newList.add(i, list.get(array[i]));
        }
        return newList;
    }
}
