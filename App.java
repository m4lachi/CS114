import java.util.Scanner;

public class App {

    public static int linearSearch(int[] arr ,int key){
        for(int i = 0; i<arr.length; i++){
            if(arr[i]== key){
                System.out.println( "Found Key at " + i);
            }
        }
        return key;
    }
    public static int binarySearch(int[] arr, int key){
        
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter Key Number: ");
        int key = scan.nextInt();

        int result= binarySearch(arr, key);
        



       
        int[] arr = {27,12,93,5,26,89,47,50,32,1};


        linearSearch(arr,3);

    }
}
