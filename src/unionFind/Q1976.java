package unionFind;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 여행 가자
 */
public class Q1976 {

    static int[] unf;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int m = scan.nextInt();

        unf = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            unf[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int input = scan.nextInt();
                if (input == 1) {
                    union(i, j);
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            int input = scan.nextInt();
            set.add(find(input));
        }

        if (set.size() == 1) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);

        if (fa != fb) {
            unf[fa] = fb;
        }
    }

    public static int find(int v) {
        if (v == unf[v]) {
            return v;
        } else {
            return unf[v] = find(unf[v]);
        }
    }
}
