package greedy;

import java.util.*;

/**
 * 이동 횟수
 */
public class GreedyQ2 {

    public static void main(String[] args) {
        GreedyQ2 q = new GreedyQ2();
        System.out.println(q.solution(new int[]{2, 5, 3, 4, 2, 3}));
        System.out.println(q.solution(new int[]{2, 3, 4, 5}));
        System.out.println(q.solution(new int[]{3, 3, 3, 3, 3}));
    }

    public int solution(int[] nums){
        int answer = 0;
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            if (nums[left] + nums[right] <= 5) {
                left++;
                right--;
            } else {
                right--;
            }
            answer++;
        }
        return answer;
    }
}
