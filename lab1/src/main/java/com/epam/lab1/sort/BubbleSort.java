package com.epam.lab1.sort;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class BubbleSort {
    private static final Logger log = LogManager.getLogger();
   public String[] strArray;
   private String resString;
   // private static final int numLines = 10;
   public String sortString(String database){
       log.error(database);
       int numLines=0;
       for(int i=0;i<database.length();i++){
           if(database.charAt(i)=='\n'){
               numLines++;
           }
       }
       //numLines++;
       log.error(numLines);

       strArray=new String[numLines];
       int j=0;
       for(int i=0;i<database.length();i++){
           if(database.charAt(i)!='\n'){
               strArray[j]+=database.charAt(i);
           }else{
               j++;
           }
       }
       log.error(strArray[0]);
       for(int i=0;i<numLines;i++){
           for(j=0;j<numLines-1;j++){
               if(strArray[j].length()>strArray[j+1].length()){
                   String tempStr="";
                   tempStr=strArray[j];
                   strArray[j]="";
                   strArray[j]=strArray[j+1];
                   strArray[j+1]="";
                   strArray[j+1]=tempStr;
               }
           }
       }
       for(int i=0;i<numLines;i++){
           resString+=strArray[i]+'\n';
       }
       resString=resString.replace("null","");
       log.info(resString);
       return resString;
   }
}
