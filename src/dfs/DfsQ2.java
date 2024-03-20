package dfs;

import java.util.*;

/**
 * 줄다리기
 */
public class DfsQ2 {

    public static void main(String[] args) {
        DfsQ2 q = new DfsQ2();
        System.out.println(q.solution(new int[][]{{1, 3}, {5, 7}, {4, 2}}));
        System.out.println(q.solution(new int[][]{{3, 2}, {3, 5}, {5, 2}, {7, 3}}));
        System.out.println(q.solution(new int[][]{{1, 2}, {1, 5}, {1, 7}, {1, 3}}));
        System.out.println(q.solution(new int[][]{{1, 7}}));
        System.out.println(q.solution(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));
    }

    static int[][] graph;
    static Stack<Integer> s;
    static boolean[] visit;
    static int answer;
    static boolean flag;

    public int solution(int[][] fight){
        answer = 0;
        graph = new int[8][8];
        s = new Stack<>();
        visit = new boolean[8];
        flag = false;
        for (int i = 0; i < fight.length; i++) {
            int x = fight[i][0];
            int y = fight[i][1];
            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        dfs(0);
        return answer;
    }

    public void dfs(int l) {
        if (l == 7) {
            answer++;
        } else {
            for (int i = 1; i < 8; i++) {
                if (!s.isEmpty() && graph[s.peek()][i] == 1) {
                    continue;
                }
                if (!visit[i]) {
                    visit[i] = true;
                    s.push(i);
                    dfs(l + 1);
                    s.pop();
                    visit[i] = false;
                }
            }
        }
    }
}
