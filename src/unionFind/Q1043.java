package unionFind;

import java.util.*;

public class Q1043 {

    static int[] unf;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        unf = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            unf[i] = i;
        }

        int r = scan.nextInt();
        for (int i = 0; i < r; i++) {
            int real = scan.nextInt();
            union(0, real);
        }

        List<List<Integer>> parties = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int p = scan.nextInt();
            List<Integer> party = new ArrayList<>();
            for (int j = 0; j < p; j++) {
                party.add(scan.nextInt());
            }
            parties.add(party);

            for (int j = 0; j < party.size() - 1; j++) {
                union(party.get(j), party.get(j + 1));
            }
        }

        int answer = 0;
        for (List<Integer> p : parties) {
            boolean flag = false;
            for (int i : p) {
                if (find(0) == find(i)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                answer++;
            }
        }
        System.out.println(answer);
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
