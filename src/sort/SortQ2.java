package sort;

import java.util.*;

/**
 * 수열 찾기
 */
public class SortQ2 {

    public static void main(String[] args) {
        SortQ2 q = new SortQ2();
        System.out.println(Arrays.toString(q.solution(new int[]{1, 10, 2, 3, 5, 6})));
        System.out.println(Arrays.toString(q.solution(new int[]{1, 1, 6, 2, 2, 7, 3, 14})));
        System.out.println(Arrays.toString(q.solution(new int[]{14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14})));
    }

    public int[] solution(int[] nums){
        int[] answer = new int[nums.length / 2];

        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0 && set.contains(nums[i] / 2)) {
                res.add(nums[i] / 2);
            }
        }
        Collections.sort(res);

        for (int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        }
        return answer;
    }
}
