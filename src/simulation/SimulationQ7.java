package simulation;

/**
 * 비밀번호
 */
public class SimulationQ7 {

    public static void main(String[] args) {
        SimulationQ7 q = new SimulationQ7();

        System.out.println(q.solution(new int[]{2, 5, 3, 7, 1, 6, 4, 9, 8}, "7596218"));
        System.out.println(q.solution(new int[]{1, 5, 7, 3, 2, 8, 9, 4, 6}, "63855526592"));
        System.out.println(q.solution(new int[]{2, 9, 3, 7, 8, 6, 4, 5, 1}, "323254677"));
        System.out.println(q.solution(new int[]{1, 6, 7, 3, 8, 9, 4, 5, 2}, "3337772122"));
    }

    public int solution(int[] keypad, String password){
        int answer = 0;

        int[] dx = {-1, 0, 1, 0, -1, 1, 1, -1};
        int[] dy = {0, 1, 0, -1, 1, 1, -1, -1};
        int[][] pad = initPad(keypad);
        int[][] dist = initDist();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 8; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (0 <= nx && nx < 3 && 0 <= ny && ny < 3) {
                        dist[pad[i][j]][pad[nx][ny]] = 1;
                    }
                }
            }
        }

        char[] ch = password.toCharArray();
        for (int i = 1; i < ch.length; i++) {
            int x = Character.getNumericValue(ch[i - 1]);
            int y = Character.getNumericValue(ch[i]);
            answer += dist[x][y];
        }

        return answer;
    }

    public int[][] initDist() {
        int[][] dist = new int[10][10];
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = 2;
                }
            }
        }
        return dist;
    }

    public int[][] initPad(int[] keypad) {
        int[][] pad = new int[3][3];
        int idx = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                pad[i][j] = keypad[idx];
                idx++;
            }
        }
        return pad;
    }
}
