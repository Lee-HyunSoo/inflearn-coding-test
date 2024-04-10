package dp;

import java.util.Scanner;

/**
 * 사탕 가게 (백준 4781번)
 */
public class DpQ1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            int n = scan.nextInt();
            int m = (int) Math.round(scan.nextDouble() * 100);
            if (n == 0 && m == 0) {
                break;
            }

            int[] dp = new int[m + 1];
            for (int i = 0; i < n; i++) {
                int c = scan.nextInt();
                int p = (int) Math.round(scan.nextDouble() * 100);

                for (int j = p; j <= m; j++) {
                    dp[j] = Math.max(dp[j], dp[j - p] + c);
                }
            }
            System.out.println(dp[m]);
        }
    }
}
