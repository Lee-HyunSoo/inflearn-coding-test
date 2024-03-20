package greedy;

import java.util.*;

/**
 * 침몰하는 타이타닉
 */
public class GreedyQ1 {

    public static void main(String[] args) {
        GreedyQ1 q = new GreedyQ1();
        System.out.println(q.solution(new int[]{90, 50, 70, 100, 60}, 140));
        System.out.println(q.solution(new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90}, 100));
        System.out.println(q.solution(new int[]{68, 72, 30, 105, 55, 115, 36, 67, 119, 111, 95, 24, 25, 80, 55, 85, 75, 83, 21, 81}, 120));
    }

    public int solution(int[] nums, int m){
        int answer = 0;
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) { // 홀수 인원인 경우 가운데에 혼자 남는 사람까지 체크해야하기 때문
            if (nums[left] + nums[right] <= m) {
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
