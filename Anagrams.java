import java.util.Scanner;
import java.util.Arrays;

public class Solution {

    static boolean isAnagram(String a, String b) {
        // Complete the function
         char[] chars = a.toLowerCase().toCharArray();
         char[] chars2 = b.toLowerCase().toCharArray();
         
         if (chars.length != chars2.length)
         {
          return false;
         }   
         
         Arrays.sort(chars);
         Arrays.sort(chars2);
         
        return (Arrays.equals(chars, chars2));
        
         
    }

    public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}