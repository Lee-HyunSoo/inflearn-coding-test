package dp;

import java.util.*;

/**
 * 팰린드롬 만들기 (백준 1695번)
 */
public class DpQ5 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] seq = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            seq[i] = scan.nextInt();
        }
        int answer = solution(n, seq);
        System.out.println(answer);
    }

    public static int solution(int n, int[] seq) {
        int answer = 0;

        // dp[i][j] = i번째부터 j번째까지의 부분수열을 팰린드롬을 만들기 위해 끼워넣어야 할 수의 최소 개수
        int[][] dp = new int[n + 1][n + 1];
        return answer;
    }
}
