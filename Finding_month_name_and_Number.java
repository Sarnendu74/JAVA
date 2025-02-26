import java.util.Scanner;

class MyCalendar {
    // Initializing list of months
    public static String[] months = {
            "January", "February", "March", "April", "May", "June", "July",
            "August", "September", "October", "November", "December"
    };

    // Method to get month number
    public static int getMonthNumber(String monthName) {
        for (int i = 0; i < months.length; i++) {
            if (monthName.equalsIgnoreCase(months[i])) {
                return i + 1;  // Returns correct month number
            }
        }
        return -1;  // Month not found
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Creating Scanner object

        while (true) {
            // Asking user for input
            System.out.print("Enter a month name (or press Enter to exit): ");
            String monthName = sc.nextLine().trim();  // Trim removes extra spaces

            // Exit loop if user enters an empty string
            if (monthName.isEmpty()) {
                System.out.println("Exiting program...");
                break;
            }

            // Get the month number
            int monthNumber = getMonthNumber(monthName);

            // Check if month is valid
            if (monthNumber == -1) {
                System.out.println("Invalid month name. Please try again.");
            } else {
                System.out.printf("%s is month number %d%n", monthName, monthNumber);
            }
        }

        sc.close(); // Close Scanner object
    }
}
