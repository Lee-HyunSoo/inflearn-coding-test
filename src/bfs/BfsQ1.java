package bfs;

import java.util.*;

/**
 * 타일 점프
 */
public class BfsQ1 {

    public static void main(String[] args) {
        BfsQ1 q = new BfsQ1();
        System.out.println(q.solution(new int[]{2, 2, 1, 2, 1, 1}));
        System.out.println(q.solution(new int[]{1, 0, 1, 1, 3, 1, 2, 1}));
        System.out.println(q.solution(new int[]{2, 3, 1, 0, 1, 1, 2, 3, 1, 5, 1, 3, 1}));
        System.out.println(q.solution(new int[]{1, 2, 1, 2, 1, 2, 1, 1, 3, 1, 2, 1}));
        System.out.println(q.solution(new int[]{1, 3, 2, 1, 1, 2, 3, 1, 3, 1, 2, 3, 5, 1, 5, 1, 2, 1, 1}));
    }

    public int solution(int[] nums){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[nums.length];
        q.offer(0);
        visit[0] = true;

        int l = 0;
        while (!q.isEmpty()) {
            for (int i = 0; i < q.size(); i++) {
                int x = q.poll();
                for (int j = 1; j <= nums[x]; j++) {
                    int nx = x + j;
                    if (nx == nums.length - 1) {
                        return l + 1;
                    }
                    if (nx < nums.length && !visit[nx]) {
                        visit[nx] = true;
                        q.offer(nx);
                    }
                }
            }
            l++;
        }
        return -1;
    }
}
