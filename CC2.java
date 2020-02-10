import java.util.Scanner;

class CC2{
    static Scanner sc = new Scanner(System.in);
    static void fillArray(int[] arr){
        System.out.println("Enter the elements: ");
        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }
    }
    static int trappedWater(int[] arr){
        int startingPoss = 0;
        int startingSize = 0;
        int finishPoss, finishSize;
        int tWater = 0;
        int counter = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != 0 && counter == 0){
                startingPoss = i;
                startingSize = arr[i];
                counter++;
            }
            if(counter > 0 && arr[i] >= startingSize){
                finishPoss = i;
                finishSize = arr[i];
                tWater = (finishPoss-1) - startingPoss;
            } 
        }
        return tWater;
    }
    public static void main(String args[]){
        int arrSize;
        arrSize = sc.nextInt();
        int array[] = new int[arrSize];
        fillArray(array);
        System.out.println(trappedWater(array));
    }
}
