package greedy;

import java.util.*;

/**
 * 스프링 쿨러
 */
public class GreedyQ3 {

    public static void main(String[] args) {
        GreedyQ3 q = new GreedyQ3();
        System.out.println(q.solution(8, new int[]{1, 1, 1, 2, 1, 1, 2, 1, 1}));
        System.out.println(q.solution(4, new int[]{1, 2, 2, 0, 0}));
        System.out.println(q.solution(5, new int[]{2, 0, 0, 0, 0, 2}));
        System.out.println(q.solution(11, new int[]{1, 2, 3, 1, 2, 1, 1, 2, 1, 1, 1, 1}));
    }

    public int solution(int n, int[] nums){
        int answer = 0;

        int start = 0, end = 0;
        int[][] list = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            int a = i - nums[i];
            int b = i + nums[i];
            if (a < 0) {
                a = 0;
            }
            if (b >= nums.length) {
                b = nums.length - 1;
            }
            list[i][0] = a;
            list[i][1] = b;
        }

        Arrays.sort(list, (a, b) -> a[0] - b[0]);
        for (int i = 0; i < list.length; i++) {
            if (end >= n) {
                break;
            }
            if (list[i][0] <= start) {
                end = list[i][1];
            } else {
                answer++;
                start = end;
            }
        }

        if (end != n) {
            answer = -1;
        }
        return answer;
    }
}
