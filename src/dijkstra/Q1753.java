package dijkstra;

import java.util.*;

/**
 * 최단경로
 */
public class Q1753 {

    static class Edge implements Comparable<Edge> {
        int v, cost;

        public Edge(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge e) {
            return this.cost - e.cost;
        }
    }

    static List<List<Edge>> graph = new ArrayList<>();
    static int[] dist;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int start = scan.nextInt();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i < m; i++) {
            int u = scan.nextInt();
            int v = scan.nextInt();
            int w = scan.nextInt();
            graph.get(u).add(new Edge(v, w));
        }

        solution(start);

        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }

    public static void solution(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        dist[start] = 0;

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
    }
}
