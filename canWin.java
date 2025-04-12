import java.util.Scanner;

public class canWin {

    public static boolean canWin(int leap, int[] game) {
        int n = game.length;
        boolean[] visited = new boolean[n];

        return canWinHelper(leap, game, 0, visited);
    }

    public static boolean canWinHelper(int leap, int[] game, int i, boolean[] visited) {
        int n = game.length;

        if (i < 0 || i >= n || visited[i] || game[i] == 1) {
            return false;
        }

        if (i + leap >= n || i + 1 >= n) {
            return true;
        }

        visited[i] = true;

        return canWinHelper(leap, game, i + 1, visited) ||
                canWinHelper(leap, game, i + leap, visited) ||
                canWinHelper(leap, game, i - 1, visited);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();

        for (int t = 0; t < q; t++) {
            int n = sc.nextInt();
            int leap = sc.nextInt();
            int[] game = new int[n];

            for (int i = 0; i < n; i++) {
                game[i] = sc.nextInt();
            }

            if (canWin(leap, game)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        sc.close();
    }
}
