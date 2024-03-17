package simulation;

/**
 * 잃어버린 강아지
 */
public class SimulationQ3 {

    public static void main(String[] args) {
        SimulationQ3 q = new SimulationQ3();

        int[][] arr1 = {{0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0}};
        System.out.println(q.solution(arr1));
        int[][] arr2 = {{1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 2, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 3}};

        System.out.println(q.solution(arr2));
    }

    public int solution(int[][] board){
        int answer = 0;
        int[] dx = {-1, 0, 1, 0}; // 12시, 3시, 6시, 9시
        int[] dy = {0, 1, 0, -1};
        int d1 = 0, d2 = 0, cnt = 0;
        int x1 = 0, y1 = 0; // 사람 시작
        int x2 = 0, y2 = 0; // 개 시작

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 2) {
                    x1 = i;
                    y1 = j;
                }
                if (board[i][j] == 3) {
                    x2 = i;
                    y2 = j;
                }
            }
        }

        int l = board.length;
        while (cnt <= 10000) {
            cnt++;
            int nx1 = x1 + dx[d1]; // 사람
            int ny1 = y1 + dy[d1];
            int nx2 = x2 + dx[d2]; // 개
            int ny2 = y2 + dy[d2];

            boolean flag1 = true;
            if (nx1 < 0 || nx1 >= l || ny1 < 0 || ny1 >= l || board[nx1][ny1] == 1) {
                d1 = (d1 + 1) % 4;
                flag1 = false;
            }

            boolean flag2 = true;
            if (nx2 < 0 || nx2 >= l || ny2 < 0 || ny2 >= l || board[nx2][ny2] == 1) {
                d2 = (d2 + 1) % 4;
                flag2 = false;
            }

            if (flag1) {
                x1 = nx1;
                y1 = ny1;
            }
            if (flag2) {
                x2 = nx2;
                y2 = ny2;
            }
            if (x1 == x2 && y1 == y2) {
                answer = cnt;
                break;
            }
        }

        return answer;
    }
}
