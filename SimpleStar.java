import java.util.Scanner;

class SimpleStar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your sequence: ");
        int n = sc.nextInt();

        // First line
        for (int i = 1; i <= n; i++) System.out.print(i);
        for (int j = (n - 1); j >= 1; j--) System.out.print(j);
        // Shifting Next Line
        System.out.println();

        for (int a = (n - 1); a >= 1; a--) {
            // Left Part
            for (int i = 1; i <= a; i++) System.out.print(i);

            // Spaces
            int spaceCount = (n % 10 == 0) ? (2 * (n - a)) : (2 * (n - a) - 1);
            for (int j = 1; j <= spaceCount; j++) System.out.print(" ");

            // Right part :)
            for (int b=a;b>=1;b--) System.out.print(b);
            System.out.println();
        }
    }
}