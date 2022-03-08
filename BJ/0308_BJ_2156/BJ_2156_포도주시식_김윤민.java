package study_mar;

import java.io.*;

public class BJ_2156_포도주시식 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] wine = new int[N+1];
		int[] dp = new int[N+1]; // i번째 잔까지 있는 경우 가장 많이 먹을 수 있는 포도주의 양
		for (int i = 1; i <= N; i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}
		dp[1] = wine[1];
		int max = dp[1];
		if (N > 1)	{
			dp[2] = wine[1] + wine[2];
			max = Math.max(dp[1], dp[2]);
		}
		for (int i = 3; i <= N; i++) {
			dp[i] = Math.max(dp[i-2]+wine[i], dp[i-3]+wine[i-1]+wine[i]);
			dp[i] = Math.max(dp[i], max);
			max = Math.max(dp[i], max);
		}
		System.out.println(max);
	}

}
