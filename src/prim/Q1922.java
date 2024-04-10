package prim;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 네트워크 연결 (프림)
 */
public class Q1922 {

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

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int m = scan.nextInt();
        int answer = 0;

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m ; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            int c = scan.nextInt();
            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
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
