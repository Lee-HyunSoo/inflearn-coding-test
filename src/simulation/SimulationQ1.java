package simulation;

import java.util.*;

/**
 * 사다리 타기
 */
public class SimulationQ1 {

    public static void main(String[] args) {
        SimulationQ1 q = new SimulationQ1();

        System.out.println(Arrays.toString(q.solution(5, new int[][]{{1, 3}, {2, 4}, {1, 4}})));
        System.out.println(Arrays.toString(q.solution(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}})));
        System.out.println(Arrays.toString(q.solution(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
        System.out.println(Arrays.toString(q.solution(12, new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}})));
    }

    public char[] solution(int n, int[][] ladder) {
        char[] answer = new char[n];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = (char) ('a' + i);
        }

        for (int[] arr : ladder) {
            for (int i : arr) {
                char c = answer[i - 1];
                answer[i - 1] = answer[i];
                answer[i] = c;
            }
        }
        return answer;
    }
}
