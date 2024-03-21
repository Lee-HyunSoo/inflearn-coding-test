package bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 송아지를 잡자
 */
public class BfsQ3 {

    public static void main(String[] args) {
        BfsQ3 q = new BfsQ3();
        System.out.println(q.solution(1, 11));
        System.out.println(q.solution(10, 3));
        System.out.println(q.solution(1, 34567));
        System.out.println(q.solution(5, 6));
        System.out.println(q.solution(2, 54321));
    }

    public int solution(int s, int e){
        int answer = 0;

        Queue<Integer> q = new LinkedList<>();
        boolean[][] visit = new boolean[2][200001]; // 0 : 짝수 레벨에 방문하는 지점 1 : 홀수 레벨에 방문하는 지점
        q.offer(s);
        visit[0][s] = true;

        while (!q.isEmpty()) {
            answer++;

            int len = q.size();
            for (int i = 0; i < len; i++) {
                int pos = q.poll();

                for (int j : new int[]{pos + 1, pos - 1, pos * 2}) {
                    if (j >= 0 && j <= 200000 && !visit[answer % 2][j]) {
                        visit[answer % 2][j] = true;
                        q.offer(j);
                    }
                }
            }

            e += answer;
            if (e > 200000) {
                return -1;
            }
            if (visit[answer % 2][e]) {
                return answer;
            }
        }
        return -1;
    }
}
