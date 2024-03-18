package structure;

import java.util.*;

/**
 * 피부과
 */
public class StructureQ4 {

    public static void main(String[] args) {
        StructureQ4 q = new StructureQ4();

        System.out.println(q.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "11:10 2"}));
        System.out.println(q.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "15:10 0", "15:20 3", "15:22 1", "15:23 0", "15:25 0"}));
        System.out.println(q.solution(new int[]{30, 20, 25, 15}, new String[]{"10:20 1", "10:40 1", "11:00 1", "11:20 1", "11:40 1"}));
    }

    static class Pair {
        int start, laser;

        Pair(int start, int laser) {
            this.start = start;
            this.laser = laser;
        }
    }

    public int solution(int[] laser, String[] enter){
        int answer = 0;
        return 0;
    }

}
