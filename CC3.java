import java.util.*;
import java.io.*;

public class CC3{
    public static void main(String[] args){   
        String fileName = "file.csv";
        File file = new File(fileName);
        try{
            Scanner inputStream = new Scanner(file);
            while (inputStream.hasNext()){
                String data = inputStream.next();
                System.out.println(data);
            }
            inputStream.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }     
    } 
}

class Student{
    String UserId;
    String F&LName;
    int Version;
    String CourseMajor;
}
