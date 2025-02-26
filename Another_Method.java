class Scratch {
    public static void main(String[] args) {
        int n = 8;
        int l = n;

        // Outer loop for rows
        for (int i = 1; i <= n; i++) {
            // Loop for the first half of the pattern
            for (int j = 1; j <= n; j++) {
                if (j <= l) {
                    System.out.print(j);  // Use print to stay on the same line
                } else {
                    System.out.print(" ");  // Two spaces for alignment
                }
            }

            // Loop for the second half of the pattern
            for (int k = (n-1); k >=1 ; k--) {
                if (k <= l) {
                    System.out.print(k);
                } else {
                    System.out.print(" ");
                }
            }

            // Move to the next line after printing a row
            System.out.println();
            l--;  // Decrease the limit for the next row
        }
    }
}
