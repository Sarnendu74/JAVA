import java.util.*;

class Leap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Your Year: ");
        int n = sc.nextInt();
        String Leap_year = (n%100 != 0) ? (n%4 == 0) ? "Leap Year" : "Not Leap_Year" : (n%400 == 0) ? ("Leap Year") : "Not Leap Year";
        System.out.print(Leap_year);
    }
}