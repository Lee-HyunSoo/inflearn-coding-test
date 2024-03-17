package simulation;

import java.util.Arrays;

/**
 * 좌석 번호
 */
public class SimulationQ4 {

    public static void main(String[] args) {
        SimulationQ4 q = new SimulationQ4();

        System.out.println(Arrays.toString(q.solution(6, 5, 12)));
        System.out.println(Arrays.toString(q.solution(6, 5, 20)));
        System.out.println(Arrays.toString(q.solution(6, 5, 30)));
        System.out.println(Arrays.toString(q.solution(6, 5, 31)));
    }

    public int[] solution(int c, int r, int k){
        if (c * r < k) {
            return new int[]{0, 0};
        }

        int[] answer = new int[2];

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int[][] graph = new int[c][r];
        int x = 0, y = 0, d = 1, cnt = 1;

        while (cnt < k) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (0 > nx || nx >= c || 0 > ny || ny >= r || graph[nx][ny] > 0) {
                d = (d + 1) % 4;
                continue;
            }

            graph[x][y] = cnt;
            cnt++;
            x = nx;
            y = ny;
        }
        answer[0] = x + 1;
        answer[1] = y + 1;

        return answer;
    }
}
