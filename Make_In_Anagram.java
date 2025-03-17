// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder str = new StringBuilder();
        String st = scan.next();
        String st2 = scan.next();
        int count = 0;
        // for(int i=0;i<st.length();i++){
            // RHS
            for(int j =0;j<st.length();j++){
                String ch = String.valueOf(st.charAt(j));
                if(!st2.contains(ch)){
                    count++;
                    str.append(ch);
                }
            }
            System.out.println(str);
            str.setLength(0);
        // LHS
        for(int j =0;j<st.length();j++){
                String ch = String.valueOf(st2.charAt(j));
                if(!st.contains(ch)){
                    count++;
                    str.append(ch);
                }
            }
            System.out.println(str);
            System.out.println(count);
        // }
    }
}