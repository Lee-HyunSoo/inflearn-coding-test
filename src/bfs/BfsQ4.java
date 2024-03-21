package bfs;

import java.util.*;

/**
 * 미로의 최단거리 통로 (L 탐색)
 */
public class BfsQ4 {

    public static void main(String[] args) {
        BfsQ4 q = new BfsQ4();
        int[][] arr = {{0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {1, 1, 0, 1, 0, 1, 1},
                {1, 1, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 0, 0, 0}};

        int[][] arr1 = {{0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {1, 1, 0, 1, 1, 1, 1},
                {1, 1, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 0, 0}};

        System.out.println(q.solution(arr));
        System.out.println(q.solution(arr1));
    }

    public int solution(int[][] board) {
        int answer = 0;
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visit = new boolean[7][7];
        q.offer(new int[]{0, 0});
        visit[0][0] = true;

        while (!q.isEmpty()) {
            answer++;
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int[] p = q.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = p[0] + dx[j];
                    int ny = p[1] + dy[j];

                    if (nx >= 0 && nx < 7 && ny >= 0 && ny < 7) {
                        if (!visit[nx][ny] && board[nx][ny] != 1) {
                            visit[nx][ny] = true;
                            board[nx][ny] = answer;
                            q.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
            if (visit[6][6]) {
                return answer;
            }
        }
        return -1;
    }
}
