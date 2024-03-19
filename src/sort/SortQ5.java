package sort;

import java.util.*;

/**
 * 모임장소
 */
public class SortQ5 {

    public static void main(String[] args) {
        SortQ5 q = new SortQ5();
        System.out.println(q.solution(new int[][]{{1, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}}));
        System.out.println(q.solution(new int[][]{{1, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}}));
        System.out.println(q.solution(new int[][]{{1, 0, 0, 0, 1, 1}, {0, 1, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 1}, {1, 0, 0, 0, 1, 1}}));
    }

    public int solution(int[][] board){
        int answer = 0;

        List<Integer> row = new ArrayList<>();
        List<Integer> col = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 1) {
                    row.add(i);
                    col.add(j);
                }
            }
        }
//        Collections.sort(row); // row 는 애초에 순서대로 들어가서 정렬 필요 없음
        Collections.sort(col); // col 을 따로 하나의 수직선으로 보기 때문에 정렬해야함
        int x = row.get(row.size() / 2);
        int y = col.get(col.size() / 2);

        // row 상의 중간값 + col 상의 중간값 -> 중간 좌표
        for (int i : row) {
            answer += Math.abs(x - i);
        }
        for (int i : col) {
            answer += Math.abs(y - i);
        }
        return answer;
    }
}
