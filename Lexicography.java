import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        int sum = (A.length() + B.length());
        int result = A.compareTo(B);
        System.out.println(sum);
        if (0<result){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
        String capa = A.substring(0,1).toUpperCase() + A.substring(1);
        String capb = B.substring(0,1).toUpperCase() + B.substring(1);
        System.out.println(capa + " " + capb);

    }
}



