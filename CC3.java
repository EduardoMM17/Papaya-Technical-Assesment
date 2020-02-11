import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;

public class CC3{
    public static void main(String[] args){   
        String fileName = "file.csv";
        File file = new File(fileName);
        Vector<Student> students = new Vector<Student>();
        Set<String> courses = new HashSet<String>();
        Map<String, Vector<Student>> toFile = new HashMap<String, Vector<Student>>();
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
        for(int index = 0; index < students.size(); index++){
            courses.add(students.get(index).CourseMajor);
        }
        for(String course : courses){
            Vector<Student> stuForEachC = new Vector<Student>();
            for(int i = 0; i < students.size(); i++){
                if(course == students.get(i).CourseMajor){
                    stuForEachC.add(students.get(i));                    
                }
            }
            toFile.put(course, stuForEachC);
        }
        for(String course : courses){
            String path = course+".csv";
            try{
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(path)); 
            writer.write("USERID,F&LName,Version,CM");
            writer.newLine();
            writer.close();
            }catch(IOException ex){
                ex.printStackTrace();
            }
        }
    }
}

class Student{
    String UserId;
    String FirstAndLastName;
    int Version;
    String CourseMajor;
}
