package dp;

import java.util.Scanner;

/**
 * 계단 오르기 (백준 2579번)
 */
public class DpQ3 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[] score = new int[n + 1];
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            score[i] = scan.nextInt();
        }

        dp[1] = score[1];
        if (n > 1) {
            dp[2] = score[1] + score[2];
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2] + score[i], dp[i - 3] + score[i - 1] + score[i]);
        }
        System.out.println(dp[n]);
    }
}
