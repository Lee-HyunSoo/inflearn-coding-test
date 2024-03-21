package bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 숲속의 기사
 */
public class BfsQ6 {

    public static void main(String[] args) {
        BfsQ6 q = new BfsQ6();
        System.out.println(q.solution(new int[][]{{4, 1, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 1, 0, 1, 0, 0},
                {0, 2, 1, 1, 3, 0, 4, 0},
                {0, 0, 0, 4, 1, 1, 1, 0}}));
        System.out.println(q.solution(new int[][]{{3, 0, 0, 0, 1, 4, 4, 4},
                {0, 1, 1, 0, 0, 0, 1, 0},
                {0, 1, 4, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0},
                {1, 0, 1, 0, 0, 1, 1, 0},
                {4, 0, 0, 0, 1, 0, 0, 0},
                {4, 1, 0, 0, 1, 0, 0, 0},
                {4, 0, 0, 0, 0, 0, 1, 2}}));
        System.out.println(q.solution(new int[][]{{4, 1, 0, 1, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 2, 3, 4},
                {0, 1, 0, 1, 0}}));
    }

    public int solution(int[][] board){
        int answer = 0;
        int n = board.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {

                }
            }
        }


        return answer;
    }

    public int[] bfs(int[][] board, int x, int y, int dest) {
        int n = board.length;
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visit = new boolean[n][n];
        q.offer(new int[]{x, y});
        visit[x][y] = true;

        int answer = 0;
        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                int[] coo = q.poll();

                if (board[coo[0]][coo[1]] == dest) {
                    return coo;
                }

                for (int j = 0; j < 4; j++) {
                    int nx = coo[0] + dx[j];
                    int ny = coo[0] + dy[j];

                    if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                        if (!visit[nx][ny] && board[nx][ny] != 1) {
                            visit[nx][ny] = true;
                            q.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
        return new int[]{-1, -1};
    }
}
