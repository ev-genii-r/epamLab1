package com.epam.lab1.collection;
import com.epam.lab1.parametres.entityParametres;
import java.util.ArrayList;

public class CollectionWorker {
    public ArrayList list=new ArrayList();
    public void setElement(entityParametres parametres){
        list.add(parametres);
    }
    public ArrayList<entityParametres> getCOllection(){
        return list;
    }
}
