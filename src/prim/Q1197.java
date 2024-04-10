package prim;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 최소 스패닝 트리 (프림)
 */
public class Q1197 {

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

        int v = scan.nextInt();
        int e = scan.nextInt();
        int answer = 0;

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            int c = scan.nextInt();
            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }
        boolean[] visit = new boolean[v + 1];

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(1, 0));
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();

            if (!visit[edge.v]) {
                visit[edge.v] = true;
                answer += edge.cost;

                for (Edge eg : graph.get(edge.v)) {
                    if (!visit[eg.v]) {
                        pq.offer(new Edge(eg.v, eg.cost));
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
