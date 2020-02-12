import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;

public class CC3{
    static Vector<Student> eliminateDuplicates(Vector<Student> V){
        Vector<Student> NoDuplicate = new Vector<Student>();    
        NoDuplicate.add(V.get(0));
        int dupPoss = 0;
        boolean isDuplicate = false;
        for(int index = 0; index < V.size(); index++){
            isDuplicate = false;
            for(int j = 1; j < NoDuplicate.size(); j++){
                if(V.get(index).UserId == NoDuplicate.get(j).UserId){
                    isDuplicate = true;
                    dupPoss = j;
                }
            }
            if(isDuplicate == false){
                 NoDuplicate.add(V.get(index));
            }
            if(isDuplicate == true && (V.get(index).Version > NoDuplicate.get(dupPoss).Version)) {
                NoDuplicate.remove(dupPoss);
                NoDuplicate.add(V.get(index));    
            }
        }
        return NoDuplicate;
    } 

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
                int midPoss = 0;
                boolean midFound = false;
                boolean nameDone = false;
                Student student = new Student();
                String data = inputStream.nextLine();
                String[] values = data.split(",");
                student.UserId = values[0];
                String Name = values[1];
                for(int i = 0; i < Name.length(); i++){
                    if(midFound){
                        student.FirstName += Name.charAt(i);
                        if(i == midPoss -1){
                            nameDone = true;
                            midFound = false;
                            i = midPoss+1;
                        }
                    }
                    if(nameDone){
                        student.LastName += Name.charAt(i);
                    }
                    if(Name.charAt(i) == ' '){
                        midPoss = i;
                        midFound = true;
                        i = 0;
                    }
                }
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
    String FirstName;
    String LastName;
    int Version;
    String CourseMajor;
}

class quickSort{
    int partition(Vector<Student> V, int low, int high){
        Student pivot = V.get(high);
        int i = low-1;
        for(int j = low; j < high; j++){
            if(V.get(j).LastName.charAt(0) < pivot.LastName.charAt(0)){
                i++;
                Collections.swap(V,i,j);
            }
        }
        Collections.swap(V,i+1,high);
        return i+1;
    }
    
    void sort(Vector<Student> V, int low, int high){
        if(low < high){
            int pi = partition(V, low, high);
            sort(V, low, pi -1);
            sort(V, pi+1,high);
        }
    }    
}
















