// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Main {
    public static void main(String[] args) {
        int n = 197;
        if(check(n)){
            System.out.print("It is a Keith Number.");
        }
        else{
            System.out.print("It is not a Keith Number.");
        }
    }
    
    public static boolean check(int num){
        int temp = num;
        int count = Integer.toString(num).length();
        int sum=0;
        int[] arr = new int[count];
        for(int i=0;i<count-1;i++){
        arr[i]=temp%10;
        temp/=10;
        }
        while(num>sum){
            for(int i=0;i<count-1;i++){
                sum += arr[i];
            }
            if(sum==num){
                return true;
            }
            // Shifting Series
            for(int i=0;i<count-1;i++){
                arr[i]=arr[i+1];
            }
            arr[count-1]=sum;
            sum=0;
        }
        return false;
        
    }
}