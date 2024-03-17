package simulation;

import java.util.ArrayList;
import java.util.List;

/**
 * 과일 가져가기
 */
public class SimulationQ6 {

    public static void main(String[] args) {
        SimulationQ6 q = new SimulationQ6();

        System.out.println(q.solution(new int[][]{{10, 20, 30}, {12, 15, 20}, {20, 12, 15}, {15, 20, 10}, {10, 15, 10}}));
        System.out.println(q.solution(new int[][]{{10, 9, 11}, {15, 20, 25}}));
        System.out.println(q.solution(new int[][]{{0, 3, 27}, {20, 5, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}}));
        System.out.println(q.solution(new int[][]{{3, 7, 20}, {10, 15, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}, {12, 12, 6}, {10, 20, 0}, {5, 10, 15}}));
    }

    public int solution(int[][] fruit){
        int answer = 0;
        boolean[] visit = new boolean[fruit.length];

        for (int i = 0; i < fruit.length; i++) {
            if (visit[i]) {
                continue;
            }
            if (!isMinUnique(fruit[i])) {
                continue;
            }
            for (int j = i + 1; j < fruit.length; j++) {
                if (visit[j]) {
                    continue;
                }
                if (!isMinUnique(fruit[j])) {
                    continue;
                }
                int a = getMinIndex(fruit[i]);
                int b = getMinIndex(fruit[j]);

                if (a != b && fruit[i][b] > 0 && fruit[j][a] > 0) {
                    if (fruit[i][a] + 1 <= fruit[i][b] - 1 && fruit[j][b] + 1 <= fruit[j][a] - 1) {
                        fruit[i][a]++;
                        fruit[i][b]--;
                        fruit[j][a]++;
                        fruit[j][b]--;
                        visit[i] = true;
                        visit[j] = true;
                        break;
                    }
                }
            }
        }
        for (int[] f : fruit) {
            answer += getMin(f);
        }
        return answer;
    }

    public boolean isMinUnique(int[] fruit) {
        int cnt = 0;
        int min = getMin(fruit);
        for (int f : fruit) {
            if (min == f) {
                cnt++;
            }
        }
        return cnt == 1;
    }

    public int getMin(int[] fruit) {
        int min = Integer.MAX_VALUE;
        for (int f : fruit) {
            min = Math.min(min, f);
        }
        return min;
    }

    public int getMinIndex(int[] fruit) {
        int min = getMin(fruit);
        for (int i = 0; i < fruit.length; i++) {
            if (fruit[i] == min) {
                return i;
            }
        }
        return 0;
    }
}
