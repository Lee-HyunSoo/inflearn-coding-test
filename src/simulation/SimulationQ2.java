package simulation;

import java.util.Arrays;

/**
 * 청소
 */
public class SimulationQ2 {

    public static void main(String[] args) {
        SimulationQ2 q = new SimulationQ2();

        int[][] arr1 = {{0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(q.solution(arr1, 10)));
        int[][] arr2 = {{0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(q.solution(arr2, 20)));
        int[][] arr3 = {{0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(q.solution(arr3, 25)));
    }

    public int[] solution(int[][] board, int k) {
        int[] answer = new int[2];
        int[] dx = {-1, 0, 1, 0}; // 12시, 3시, 6시, 9시
        int[] dy = {0, 1, 0, -1};
        int idx = 1, cnt = 0;

        while (cnt < k) {
            cnt++;
            int nx = answer[0] + dx[idx];
            int ny = answer[1] + dy[idx];

            if (nx < 0 || nx >= board.length || ny < 0 || ny >= board.length || board[nx][ny] == 1) {
                idx = (idx + 1) % 4;
                continue;
            }

            answer[0] = nx;
            answer[1] = ny;
        }

        return answer;
    }
}
