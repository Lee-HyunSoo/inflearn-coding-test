package knapsack;

import java.util.*;

/**
 * 동전
 */
public class Q9084 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int t = scan.nextInt();
        while (t-- > 0) {
            int n = scan.nextInt();
            List<Integer> coins = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int coin = scan.nextInt();
                coins.add(coin);
            }
            int m = scan.nextInt();

            int[] dp = new int[m + 1];
            dp[0] = 1;
            for (int c : coins) {
                for (int i = c; i <= m; i++) {
                    dp[i] = dp[i] + dp[i - c];
                }
            }
            System.out.println(dp[m]);
        }
    }
}
