package dfs;

import java.util.*;

/**
 * 가장 가까운 큰수
 */
public class DfsQ1 {

    public static void main(String[] args) {
        DfsQ1 q = new DfsQ1();
        System.out.println(q.solution(123));
        System.out.println(q.solution(321));
        System.out.println(q.solution(20573));
        System.out.println(q.solution(27711));
        System.out.println(q.solution(54312));
    }

    static char[] cNum;
    static boolean[] visit;
    static boolean flag;
    static int answer;

    public int solution(int n){
        answer = -1;
        char[] str = String.valueOf(n).toCharArray(); // 숫자를 한자리씩 떨어트려 저장
        cNum = new char[str.length]; // 순열 저장
        visit = new boolean[str.length];
        flag = false;

        Arrays.sort(str);
        dfs(str, 0, n);

        return answer;
    }

    public void dfs(char[] str, int level, int n) {
        if (flag) {
            return;
        }

        if (level == str.length) {
            int res = Integer.parseInt(String.valueOf(cNum));
            if (res > n) {
                answer = res;
                flag = true;
            }
            return;
        }
        for (int i = 0; i < str.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                cNum[level] = str[i];
                dfs(str, level + 1, n);
                visit[i] = false;
            }
        }
    }
}
