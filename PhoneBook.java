import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /* -------- read the phone-book -------- */
        int n = sc.nextInt();       // number of entries
        sc.nextLine();              // consume end-of-line
        Map<String, String> phoneBook = new HashMap<>(n * 2);

        for (int i = 0; i < n; i++) {
            String name  = sc.nextLine();
            String phone = sc.nextLine();
            phoneBook.put(name, phone);
        }

        /* -------- answer queries until EOF -------- */
        while (sc.hasNextLine()) {
            String query = sc.nextLine();
            String number = phoneBook.get(query);
            if (number != null) {
                System.out.println(query + "=" + number);
            } else {
                System.out.println("Not found");
            }
        }
        sc.close();
    }
}
