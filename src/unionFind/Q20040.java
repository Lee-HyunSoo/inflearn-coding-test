package unionFind;

import java.util.*;

public class Q20040 {

    static int[] unf;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        unf = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            unf[i] = i;
        }

        int answer = 0;
        for (int i = 1; i <= m; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();

            if (union(a, b)) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }

    public static boolean union(int a, int b) {
        int fa = find(a);
        int fb = find(b);

        if (fa != fb) {
            unf[fa] = fb;
            return false;
        }
        return true; // 같으면 사이클이 생겼다는 것, true return
    }

    public static int find(int v) {
        if (v == unf[v]) {
            return v;
        } else {
            return unf[v] = find(unf[v]);
        }
    }
}
