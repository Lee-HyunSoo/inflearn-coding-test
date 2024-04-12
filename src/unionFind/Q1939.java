package unionFind;

import java.util.*;

public class Q1939 {

    static class Edge implements Comparable<Edge> {
        int v1, v2, cost;

        public Edge (int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge e) {
            return e.cost - this.cost;
        }
    }

    static int[] unf;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int m = scan.nextInt();
        unf = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            unf[i] = i;
        }

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            int c = scan.nextInt();
            edges.add(new Edge(a, b, c));
        }
        Collections.sort(edges);

        int start = scan.nextInt();
        int end = scan.nextInt();
        int answer = 0;
        for (Edge e : edges) {
            union(e.v1, e.v2);
            if (find(start) == find(end)) {
                answer = e.cost;
                break;
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
