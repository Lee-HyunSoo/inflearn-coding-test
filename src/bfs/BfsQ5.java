package bfs;

import java.util.*;

/**
 * 집을 짓자
 */
public class BfsQ5 {

    public static void main(String[] args) {
        BfsQ5 q = new BfsQ5();
        System.out.println(q.solution(new int[][]{{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 2, 1, 0, 0}, {2, 0, 0, 2, 2}, {0, 0, 0, 0, 0}}));
        System.out.println(q.solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 0}}));
        System.out.println(q.solution(new int[][]{{1, 2, 0, 0}, {0, 0, 1, 2}, {0, 2, 0, 0}, {0, 2, 1, 0}}));
        System.out.println(q.solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 1}}));
    }

    public int solution(int[][] board){
        int answer = 0;
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};
        int n = board.length;

        Queue<int[]> q = new LinkedList<>();
        int[][] dist = new int[n][n];
        int empty = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    answer = Integer.MAX_VALUE;
                    q.offer(new int[]{i, j});

                    int l = 0;
                    while (!q.isEmpty()) {
                        l++;
                        int len = q.size();
                        for (int k = 0; k < len; k++) {
                            int[] coo = q.poll();
                            for (int m = 0; m < 4; m++) {
                                int nx = coo[0] + dx[m];
                                int ny = coo[1] + dy[m];

                                if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == empty) {
                                    board[nx][ny]--;
                                    dist[nx][ny] += l;
                                    q.offer(new int[]{nx, ny});
                                    answer = Math.min(answer, dist[nx][ny]);
                                }
                            }
                        }
                    }
                    empty--;
                }
            }
        }
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}
