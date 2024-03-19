package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 멀티태스킹
 */
public class SortQ6 {

    public static void main(String[] args) {
        SortQ6 q = new SortQ6();
        System.out.println(q.solution(new int[]{1, 2, 3}, 5));
        System.out.println(q.solution(new int[]{8, 5, 2, 9, 10, 7}, 30));
        System.out.println(q.solution(new int[]{8, 9, 12, 23, 45, 16, 25, 50}, 100));
    }

    public int solution(int[] tasks, long k) {
        int answer = 0;

        int sum = 0;
        for (int i : tasks) {
            sum += i;
        }
        answer = sum % tasks.length + 1;

        return answer;
    }
}
