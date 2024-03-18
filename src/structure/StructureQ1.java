package structure;

import java.util.HashSet;
import java.util.Set;

/**
 * 최대 길이 연속수열
 */
public class StructureQ1 {

    public static void main(String[] args) {
        StructureQ1 q = new StructureQ1();

        System.out.println(q.solution(new int[]{8, 1, 9, 3, 10, 2, 4, 0, 2, 3}));
        System.out.println(q.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0}));
        System.out.println(q.solution(new int[]{3, 3, 3, 3, 3, 3, 3, 3}));
        System.out.println(q.solution(new int[]{-3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1}));
        System.out.println(q.solution(new int[]{-5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7}));
    }

    public int solution(int[] nums){
        int answer = 0;

        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }

        for (int i : set) {
            // 자기보다 1 작은 수가 있다면 자기 자신이 수열의 일부가 되기 때문에 계산할 필요 없음, 최소인 값만 찾으면 됨
            if (!set.contains(i - 1)) {
                int cnt = 0;
                while (set.contains(i++)) {
                    cnt++;
                }
                answer = Math.max(answer, cnt);
            }
        }

        return answer;
    }
}
