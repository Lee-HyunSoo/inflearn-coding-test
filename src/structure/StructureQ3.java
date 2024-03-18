package structure;

import java.util.*;

/**
 * 현관문 출입 순서
 */
public class StructureQ3 {

    public static void main(String[] args) {
        StructureQ3 q = new StructureQ3();
        System.out.println(Arrays.toString(q.solution(new int[]{0, 1, 1, 1, 2, 3, 8, 8}, new int[]{1, 0, 0, 1, 0, 0, 1, 0})));
        System.out.println(Arrays.toString(q.solution(new int[]{3, 3, 4, 5, 5, 5}, new int[]{1, 0, 1, 0, 1, 0})));
        System.out.println(Arrays.toString(q.solution(new int[]{2, 2, 2, 3, 4, 8, 8, 9, 10, 10}, new int[]{1, 0, 0, 0, 1, 1, 0, 1, 1, 0})));
    }

    public int[] solution(int[] arrival, int[] state){
        int[] answer = new int[arrival.length];
        Queue<Integer> enter = new LinkedList<>();
        Queue<Integer> exit = new LinkedList<>();

        int n = arrival.length, flag = 1; // 0 : 들어옴 1 : 나감, 조건1 : 나가는게 우선이다
        // t : 시간, i : 사원번호, cnt : 현관문을 사용한 사람 수
        for (int t = 0, i = 0, cnt = 0; ; t++) {
            if (enter.isEmpty() && exit.isEmpty() && i < n) {
                // 건너뛰기
                if (t < arrival[i]) {
                    t = arrival[i];
                    flag = 1;
                }
            }

            while (i < n && arrival[i] <= t) {
                if (state[i] == 0) {
                    enter.offer(i++);
                } else {
                    exit.offer(i++);
                }
            }

            if (flag == 1) {
                if (!exit.isEmpty()) {
                    answer[exit.poll()] = t;
                    flag = 1;
                } else {
                    answer[enter.poll()] = t;
                    flag = 0;
                }
            } else if (flag == 0) {
                if (!enter.isEmpty()) {
                    answer[enter.poll()] = t;
                    flag = 0;
                } else {
                    answer[exit.poll()] = t;
                    flag = 1;
                }
            }
            cnt++;
            if (cnt == n) {
                break;
            }
        }
        return answer;
    }
}
