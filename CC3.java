import java.util.*;
import java.io.*;

public class CC3{
    public static void main(String[] args){   
        String fileName = "file.csv";
        File file = new File(fileName);
        Vector<Student> students = new Vector<Student>();
        try{
            Scanner inputStream = new Scanner(file);
            inputStream.nextLine();
            while (inputStream.hasNextLine()){
                Student student = new Student();
                String data = inputStream.nextLine();
                String[] values = data.split(",");
                student.UserId = values[0];
                student.FirstAndLastName = values[1];
                String SVersion = values[2];
                student.Version = Integer.parseInt(SVersion);
                student.CourseMajor = values[3];
                students.add(student);
            }
            inputStream.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }     
        System.out.println(students.get(1).UserId);
    } 
}

class Student{
    String UserId;
    String FirstAndLastName;
    int Version;
    String CourseMajor;
}
