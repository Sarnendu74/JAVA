import java.util.*;

public class String_Tokens {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String str2= str.trim();
        if(str2.length() == 0) {
            System.out.println(0);
            return;
        }
        // String str = "He is a very good boy, isn't he*~+:;^?";
//      regex = "[ A-Za-z!,?._@]+";
        String[] arr = str2.split("[ !,?._@'^]+");
        if(arr == null){
            System.out.print(0);
            return;
        }
        System.out.println(arr.length);
        for (String a: arr){
            if(a.length() != 0){
                System.out.print(a);
                System.out.println();
            }
            else{
                System.out.print(0);
            }
        }
    }
}
