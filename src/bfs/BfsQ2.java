package bfs;

import java.util.*;

/**
 * 집으로 이동
 */
public class BfsQ2 {

    public static void main(String[] args) {
        BfsQ2 q = new BfsQ2();
        System.out.println(q.solution(new int[]{11, 7, 20}, 3, 2, 10));
        System.out.println(q.solution(new int[]{1, 15, 11}, 3, 2, 5));
        System.out.println(q.solution(new int[]{9, 15, 35, 30, 20}, 2, 1, 25));
        System.out.println(q.solution(new int[]{5, 12, 7, 19, 23}, 3, 5, 18));
        System.out.println(q.solution(new int[]{10, 15, 20}, 3, 2, 2));
    }

    static class Pair {
        int x, goBack;

        public Pair(int x, int goBack) {
            this.x = x;
            this.goBack = goBack;
        }
    }

    public int solution(int[] pool, int a, int b, int home){
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        for (int p : pool) {
            set.add(p);
        }

        Queue<Pair> q = new LinkedList<>();
        boolean[] visit = new boolean[10002];
        q.add(new Pair(0, 0)); // 0 : back 1 : go
        visit[0] = true;

        while (!q.isEmpty()) {
            for (int i = 0; i < q.size(); i++) {
                Pair p = q.poll();

                if (p.x == home) {
                    return answer + 1;
                }

                int nx = p.x + a;
                if (!set.contains(nx) && nx <= 10001 && !visit[nx]) {
                    visit[nx] = true;
                    q.offer(new Pair(nx, 1));
                }
                nx = p.x - b;
                if (nx >= 0 && p.goBack != 0 && !visit[nx]) {
                    visit[nx] = true;
                    q.offer(new Pair(p.x - b, 0));
                }
            }
            answer++;
        }
        return -1;
    }
}
