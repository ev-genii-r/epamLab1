package com.epam.lab1.fileWorker;

import com.epam.lab1.parametres.entityParametres;
import com.epam.lab1.sort.BubbleSort;

import java.io.*;
import java.util.ArrayList;

public class FileWorker {
    File file=new File("D://3)Учеба//КПП//lab1//externalFiles","database.txt");
    public void write(ArrayList<entityParametres> parametres) throws IOException {
        FileWriter initialisatoin=new FileWriter(file);
        for(int i=0;i<parametres.size();i++) {
            if(parametres.get(i).getExceptionTime()=="") {
                try (FileWriter writer = new FileWriter(file, true)) {
                    String str = parametres.get(i).getInputLength() + "/" + parametres.get(i).getInputSpeed() + "="+ parametres.get(i).getSpeed();
                    writer.write(str+'\n');
                } catch (
                        IOException e) {
                    e.printStackTrace();
                }
            }else{
                try (FileWriter writer = new FileWriter(file, true)) {
                    String str = parametres.get(i).getExceptionLength() + "/" + parametres.get(i).getExceptionSpeed() + "="+ parametres.get(i).getExceptionTime();
                    writer.write(str+'\n');
                } catch (
                        IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public String read(){
        String str="";
        try (FileReader reader =new FileReader(file)){
            BufferedReader br = new BufferedReader(reader);
           while (br.ready()){
               str=str+br.readLine()+"\n";
           }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
