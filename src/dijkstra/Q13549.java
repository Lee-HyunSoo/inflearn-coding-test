package dijkstra;

import java.util.*;

/**
 * 숨바꼭질 3
 */
public class Q13549 {

    static class Edge {
        int v, cost;

        public Edge(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int answer = Integer.MAX_VALUE;

        boolean[] visit = new boolean[100001];
        Queue<Edge> q = new LinkedList<>();
        q.offer(new Edge(n, 0));
        while (!q.isEmpty()) {
            Edge e = q.poll();
            visit[e.v] = true;
            if (e.v == k) {
                answer = Math.min(answer, e.cost);
            }

            if (e.v + 1 < 100001 && !visit[e.v + 1]) {
                q.offer(new Edge(e.v + 1, e.cost + 1));
            }
            if (e.v - 1 >= 0 && !visit[e.v - 1]) {
                q.offer(new Edge(e.v - 1, e.cost + 1));
            }
            if (e.v * 2 < 100001 && !visit[e.v * 2]) {
                q.offer(new Edge(e.v * 2, e.cost));
            }
        }
        System.out.println(answer);
    }
}
