package dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 등차수열 (백준 1994번)
 */
public class DpQ4 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = scan.nextInt();
        }
        int answer = solution(n, arr);
        System.out.println(answer);
    }

    public static int solution(int n, int[] arr) {
        int answer = 0;
        if (n == 1) {
            return 1;
        }
        int[][] dp = new int[n + 1][n + 1];
        Arrays.sort(arr);

        // dp[i][j] -> ..., arr[i], arr[j] 로 끝나는 등차수열
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                dp[i][j] = 2;

                /*
                공차 = arr[j] - arr[i]
                arr[i] - 공차 = i번째 항의 앞의 항 (arr[i]의 앞의 항)
                -> arr[i] - (arr[j] - arr[i]) = 앞의 항
                -> 2 * arr[i] - arr[j]
                 */
//                int pre = arr[i] * 2 - arr[j]; // i번째 항의 앞의 항
                int diff = arr[j] - arr[i]; // 공차
                int k;
                for (k = i - 1; k >= 1; k--) {
                    if (arr[k] == arr[i] - diff) break;
                }
                dp[i][j] = Math.max(dp[i][j], dp[k][i] + 1);
                answer = Math.max(answer, dp[i][j]);
            }
        }
        return answer;
    }
}
