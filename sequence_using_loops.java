import java.util.*;
import java.io.*;

class Solution{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int k = 0;
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            for (int j=0;j<n;j++){
                if (j==0){
                    int s = (a + ((int)Math.pow(2,j)*b));
                    k = s;
                    System.out.print(k+" ");
                }
                else{
                    k = (k+((int)Math.pow(2,j)*b));
                  System.out.print(k +" ");              
                }
            }
            System.out.println();
        }
        in.close();
    }
}