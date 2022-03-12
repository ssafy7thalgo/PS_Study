package BOJ_Gold;

/*
BOJ G5 2293 동전1
https://www.acmicpc.net/problem/2293
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2293_동전1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] dp = new int[k + 1];
        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        // coins = { 1, 2, 5 }, k = 10
        // 1 2 3 4 5 6 7 8 9 10
        // 1 1 1 1 1 1 1 1 1 1   -- coins[0]
        // 1 2 2 3 3 4 4 5 5 6   -- coins[0], coins[1]
        // 1 2 2 3 4 5 6 7 8 10  -- coins[0], coins[1], coins[2]
        // dp[k] = dp[k] + dp[k - coins[i]]

        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                if (j >= coins[i]) {
                    dp[j] = dp[j] + dp[j - coins[i]];
                }
            }
        }

        // k원을 만드는 경우의 수 출력
        System.out.println(dp[k]);
    }
}
