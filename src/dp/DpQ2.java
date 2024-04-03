package dp;

import java.util.Scanner;

/**
 * 수도배관공사 (백준 2073번)
 */
public class DpQ2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int d = scan.nextInt();
        int p = scan.nextInt();
        int[] dp = new int[d + 1];
        for (int i = 0; i < p; i++) {
            int l = scan.nextInt();
            int c = scan.nextInt();

            for (int j = d; j > l; j--) {
                dp[j] = Math.max(dp[j], Math.min(dp[j - l], c));
            }
            dp[l] = Math.max(dp[l], c); // 0 나오는 것 방지
        }
        System.out.println(dp[d]);
    }
}
