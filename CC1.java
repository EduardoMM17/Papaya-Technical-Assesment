import java.util.Scanner;

class CC1{
    static boolean isOk(String in){
        int countL = 0;
        int countR = 0;
        boolean notDoneYet = false;
        for(int i = 0; i < in.length(); i++){
            if(in.charAt(0) != '('){
                countR++;
                break;
            }
            if(in.charAt(i) == '('){
                countL++;
            }
            else if(in.charAt(i) == ')'){
                countR++;
            }
            if(countL == countR && i < in.length()-1){
                notDoneYet = true;
                countL++;
                break;
            }
        }
        if(countL == countR && notDoneYet){
            return false;
        }
        if(countL == countR){
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String args[]){
        String in;
        Scanner sc = new Scanner(System.in);
        in = sc.nextLine();
        if(isOk(in) == true){
            System.out.println("Parentheses are properly closed and nested");
        }
        else{
            System.out.println("Not properly closed and nested");
        }
    }
}
