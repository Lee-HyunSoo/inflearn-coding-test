package prim;

import java.util.*;

/**
 * 행성 연결 (프림)
 */
public class Q16398 {

    static class Edge implements Comparable<Edge> {
        int v;
        long cost;

        public Edge (int v, long cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge e) {
            return (int) (this.cost - e.cost);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long answer = 0;

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                long cost = scan.nextInt();
                graph.get(i).add(new Edge(j, cost));
            }
        }

        boolean[] visit = new boolean[n + 1];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(1, 0));

        while (!pq.isEmpty()) {
            Edge e = pq.poll();

            if (!visit[e.v]) {
                visit[e.v] = true;
                answer += e.cost;

                for (Edge eg : graph.get(e.v)) {
                    if (!visit[eg.v]) {
                        pq.offer(new Edge(eg.v, eg.cost));
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
