package prim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 전력난 (프림)
 */
public class Q6497 {

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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());//집의수
            int n = Integer.parseInt(st.nextToken());//길의수
            if (m == 0 && n == 0) {
                break;
            }

            List<List<Edge>> graph = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                graph.add(new ArrayList<>());
            }

            int total = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());
                graph.get(x).add(new Edge(y, z));
                graph.get(y).add(new Edge(x, z));
                total += z;
            }

            boolean[] visit = new boolean[m];
            PriorityQueue<Edge> pq = new PriorityQueue<>();
            pq.offer(new Edge(0, 0));

            int sum = 0;
            while (!pq.isEmpty()) {
                Edge e = pq.poll();
                if (!visit[e.v]) {
                    visit[e.v] = true;
                    sum += e.cost;

                    for (Edge eg : graph.get(e.v)) {
                        if (!visit[eg.v]) {
                            pq.offer(new Edge(eg.v, eg.cost));
                        }
                    }
                }
            }

            System.out.println(total - sum);
        }
    }
}
