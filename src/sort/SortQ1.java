package sort;

import java.util.*;

/**
 * 이진수 정렬
 */
public class SortQ1 {

    public static void main(String[] args) {
        SortQ1 q = new SortQ1();
        System.out.println(Arrays.toString(q.solution(new int[]{5, 6, 7, 8, 9})));
        System.out.println(Arrays.toString(q.solution(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(q.solution(new int[]{12, 5, 7, 23, 45, 21, 17})));
    }

    public int[] solution(int[] nums){
        int[] answer = new int[nums.length];

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(new int[]{nums[i], count(nums[i])});
        }
        list.sort((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i)[0];
        }
        return answer;
    }

    public int count(int n) {
        int cnt = 0;
        while (n > 0) {
            if (n % 2 != 0) {
                cnt++;
            }
            n /= 2;
        }
        return cnt;
    }
}
