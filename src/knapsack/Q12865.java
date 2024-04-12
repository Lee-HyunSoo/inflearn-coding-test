package knapsack;

import java.util.*;

/**
 * 평범한 배낭
 */
public class Q12865 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int k = scan.nextInt();

        int[] dp = new int[k + 1]; // idx = 물품무게, dp[idx] = 물품가치
        for (int i = 0; i < n; i++) {
            int w = scan.nextInt();
            int v = scan.nextInt();

            for (int j = k; j > w; j--) {
                dp[j] = Math.max(dp[j], dp[j - w] + v);
            }
            if (k >= w) {
                dp[w] = Math.max(dp[w], v);
            }
        }
        System.out.println(dp[k]);
    }
}
