package dijkstra;

import java.util.*;

/**
 * 특정한 최단 경로
 */
public class Q1504 {

    static class Edge implements Comparable<Edge> {
        int v, cost;
        public Edge (int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge e) {
            return this.cost - e.cost;
        }
    }

    static List<List<Edge>> graph = new ArrayList<>();
    static int n;
    static int INF = 200000001; // 200,000 * 1,000 + 1

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();
        int m = scan.nextInt();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            int z = scan.nextInt();

            graph.get(x).add(new Edge(y, z));
            graph.get(y).add(new Edge(x, z));
        }
        int v1 = scan.nextInt(); // 2
        int v2 = scan.nextInt(); // 3

        // 1 -> 2 -> 3 -> 4
        // 1 -> 3 -> 2 -> 4
        int d1 = solution(1, v1) + solution(v1, v2) + solution(v2, n);
        int d2 = solution(1, v2) + solution(v2, v1) + solution(v1, n);

        int answer = (d1 >= INF && d2 >= INF) ? -1 : Math.min(d1, d2);
        System.out.println(answer);
    }

    public static int solution(int start, int end) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge e = pq.poll();

            if (e.cost > dist[e.v]) {
                continue;
            }
            for (Edge eg : graph.get(e.v)) {
                int newCost = e.cost + eg.cost;
                if (dist[eg.v] > newCost) {
                    dist[eg.v] = newCost;
                    pq.offer(new Edge(eg.v, newCost));
                }
            }
        }
        return dist[end];
    }
}
