package dijkstra;

import java.util.*;

/**
 * 파티
 */
public class Q1238 {

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

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int m = scan.nextInt();
        int x = scan.nextInt(); // 도착지

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            int c = scan.nextInt();
            graph.get(a).add(new Edge(b, c));
        }

        int[] xToN = solution(n, x); // x에서 1 ~ n으로 가는 최단코스트

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int[] nToX = solution(n, i); // i에서 x로 가는 최단코스트를 구하기 위해
            answer = Math.max(answer, xToN[i] + nToX[x]);
        }
        System.out.println(answer);
    }

    public static int[] solution(int n, int start) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
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
        return dist;
    }
}
