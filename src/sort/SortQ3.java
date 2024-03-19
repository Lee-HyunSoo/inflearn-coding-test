package sort;

import java.util.*;

/**
 * 카드 가져가기
 */
public class SortQ3 {

    public static void main(String[] args) {
        SortQ3 q = new SortQ3();
        System.out.println(q.solution(new int[]{7, 8, 5, 12, 3, 1, 3, 1, 1, 12}, 2));
        System.out.println(q.solution(new int[]{8, 2, 12, 12, 12, 12, 2, 2}, 2));
        System.out.println(q.solution(new int[]{3, 7, 12, 3, 3, 5, 7, 8, 9, 11, 23, 4, 6, 7}, 3));
        System.out.println(q.solution(new int[]{12, 34, 56, 23, 22, 34, 55, 45, 24, 23, 45, 55, 55, 23, 11, 12, 23, 12}, 3));
        System.out.println(q.solution(new int[]{14, 15, 20, 11, 10, 20, 20, 12, 9, 22, 27, 25, 30, 19}, 3));
    }

    public int solution(int[] nums, int k){
        int answer = 0;

        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            list.add(i);
        }
        list.sort((a, b) -> b - a);

        List<Integer> diff = new ArrayList<>();
        for (int i = 0; i < list.size() / 2; i++) {
            answer += list.get(i * 2 + 1); // 홀수만 추가
            diff.add(list.get(i * 2) - list.get(i * 2 + 1));
        }
        diff.sort((a, b) -> b - a);

        // 뽑은 것 중 작은 것만 더한 것 + 차이를 내림차순 정렬한 것을 더하기
        // 5 3 -> diff = 2 -> 3 + 2 가 5기 때문에 바꿔서 뽑은 것과 마찬가지 효과
        for (int i = 0; i < k; i++) {
            answer += diff.get(i);
        }
        return answer;
    }
}
