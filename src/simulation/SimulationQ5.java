package simulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 최대 길이 바이토닉 수열
 */
public class SimulationQ5 {

    public static void main(String[] args) {
        SimulationQ5 q = new SimulationQ5();

//        System.out.println(q.solution(new int[]{1, 2, 1, 2, 3, 2, 1}));
        System.out.println(q.solution(new int[]{1, 3, 2, 5, 7, 4, 2, 5, 1}));
        System.out.println(q.solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2}));
        System.out.println(q.solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1}));
        System.out.println(q.solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1}));
    }

    public int solution(int[] nums){
        int answer = 0;

        List<Integer> peeks = new ArrayList<>(); // 봉우리 배열
        for (int i = 0; i < nums.length; i++) {
            int prev = i - 1;
            int next = i + 1;

            if (prev >= 0 && next < nums.length) {
                if (nums[prev] < nums[i] && nums[next] < nums[i]) {
                    peeks.add(i);
                }
            }
        }

        for (int p : peeks) {
            int left = p;
            int right = p;
            int cnt = 1;

            while (left - 1 >= 0 && nums[left - 1] < nums[left]) {
                left--;
                cnt++;
            }
            while (right + 1 < nums.length && nums[right] > nums[right + 1]) {
                right++;
                cnt++;
            }

            answer = Math.max(answer, cnt);
        }
        return answer;
    }
}
