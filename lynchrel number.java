import java.util.*;

class LynchrelNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your number: ");
        int number = scan.nextInt();
        scan.close();

        int count = 0;
        int lynchrel_n = 0;

        for (int i = 0; i < 10; i++) {
            number = add(number);

            if (is_Palindrome(number)) {
                System.out.println("Palindrome found after " + (i + 1) + " iterations: " + number);
                return;
            } else {
                count++;
            }

            if (count == 5) {
                lynchrel_n = number;
            }
        }

        System.out.println(lynchrel_n + " It's a Lynchrel number .");
    }

    // Adding function
    public static int add(int num) {
        return num + is_Reverse(num);
    }

    // Reverse Function
    public static int is_Reverse(int num) {
        int rem = 0;
        while (num > 0) {
            rem = (rem * 10) + (num % 10);
            num /= 10;
        }
        return rem;
    }

    // Palindrome Function
    public static boolean is_Palindrome(int num) {
        return num == is_Reverse(num);
    }
}
