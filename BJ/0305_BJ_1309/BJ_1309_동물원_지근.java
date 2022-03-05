package BOJ_Silver;

/*
BOJ S1 1309 동물원 https://www.acmicpc.net/problem/1309
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1309_동물원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N][3];
        int divisor = 9901;

        /*
        dp[i][j] = i번째 줄에
        j == 0 : 왼쪽 우리에 사자를 넣는 경우
        j == 1 : 오른쪽 우리에 사자를 넣는 경우
        j == 2 : 양쪽 다 사자를 넣지 않는 경우
         */
        dp[0][0] = dp[0][1] = dp[0][2] = 1;

        for (int i = 1; i < dp.length; i++) {
            // 왼쪽 우리에 사자가 들어갈 경우
            dp[i][0] = (dp[i - 1][1] + dp[i - 1][2]) % divisor;
            // 오른쪽 우리에 사자가 들어갈 경우
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % divisor;
            // 둘 다 비어있을 경우
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % divisor;
        }

        int answer = (dp[N - 1][0] + dp[N - 1][1] + dp[N - 1][2]) % divisor;

        System.out.println(answer);
    }
}
