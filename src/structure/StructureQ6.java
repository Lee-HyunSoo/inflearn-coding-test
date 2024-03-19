package structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 가장 많이 사용 된 회의실
 */
public class StructureQ6 {

    public static void main(String[] args) {
        StructureQ6 q = new StructureQ6();

        System.out.println(Arrays.toString(q.solution(new int[][]{{2, 3}, {1, 2}, {8, 2}, {3, 1}, {10, 2}})));
        System.out.println(Arrays.toString(q.solution(new int[][]{{5, 2}, {7, 3}, {1, 3}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(q.solution(new int[][]{{1, 2}, {2, 3}, {1, 3}, {3, 3}, {8, 2}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(q.solution(new int[][]{{999, 1000}, {996, 1000}, {998, 1000}, {999, 7}})));
    }

    public int[] solution(int[][] tasks){
        int[] answer = {};

        List<Integer> result = new ArrayList<>();


        return answer;
    }
}
