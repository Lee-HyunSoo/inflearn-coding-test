package hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 음수가 있는 부분수열
 */
public class HashQ4 {

    public static void main(String[] args) {
        HashQ4 q = new HashQ4();
        System.out.println(q.solution(new int[]{2, 2, 3, -1, -1, -1, 3, 1, 1}, 5));
        System.out.println(q.solution(new int[]{1, 2, 3, -3, 1, 2, 2, -3}, 5));
        System.out.println(q.solution(new int[]{1, 2, 3, -3, 1, 2}, 3));
        System.out.println(q.solution(new int[]{-1, 0, 1}, 0));
        System.out.println(q.solution(new int[]{-1, -1, -1, 1}, 0));
    }

    public int solution(int[] nums, int m){
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // sum - m 이 0일 때를 대비

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - m)) {
                answer += map.get(sum - m);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return answer;
    }
}
