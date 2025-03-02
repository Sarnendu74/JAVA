import java.util.*;
import java.text.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

        // Write your code here.
        NumberFormat us_format = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat india_format = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
        NumberFormat china_format = NumberFormat.getCurrencyInstance(Locale.CHINA);
        NumberFormat france_format = NumberFormat.getCurrencyInstance(Locale.FRANCE);

        String us = us_format.format(payment);
        String india = india_format.format(payment);
        String china = china_format.format(payment);
        String france = france_format.format(payment);


        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }
}