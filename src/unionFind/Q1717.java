package unionFind;

import java.util.*;

/**
 * 집합의 표현
 */
public class Q1717 {

    static int[] unf;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int m = scan.nextInt();

        unf = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            unf[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int c = scan.nextInt();
            int a = scan.nextInt();
            int b = scan.nextInt();

            if (c == 0) {
                union(a, b);
            } else if (c == 1) {
                String answer = find(a) == find(b) ? "YES" : "NO";
                System.out.println(answer);
            }
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
