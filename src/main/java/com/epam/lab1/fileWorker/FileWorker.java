package com.epam.lab1.fileWorker;

import java.io.*;

public class FileWorker {
    File file=new File("D://3)Учеба//КПП//lab1//externalFiles","database.txt");
    public void write(String inputLength, String inputSpeed, double time) {

        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(inputLength + '/' + inputSpeed + '=' + time+ '\n');
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
    public void write(String inputLength, String inputSpeed, String time) {
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(inputLength + '/' + inputSpeed + '-' + time+'\n');
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
    public String read(){
        String str="";
        try (FileReader reader =new FileReader(file)){
            BufferedReader br = new BufferedReader(reader);
           while (br.ready()){
               str=str+br.readLine()+". . . . . . ";
           }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
