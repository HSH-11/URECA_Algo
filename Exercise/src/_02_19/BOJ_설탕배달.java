package _02_19;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_설탕배달 {

	static int[] dp;
	static int N;
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		dp = new int[N + 1];

		Arrays.fill(dp, INF);

		if (N >= 3) dp[3] = 1;
		if (N >= 5) dp[5] = 1;
		
	
		for (int i = 6; i <= N; i++) {

			if (dp[i - 3] != INF) {
				dp[i] = Math.min(dp[i], dp[i - 3] + 1);
			}
			if (dp[i - 5] != INF) {
				dp[i] = Math.min(dp[i], dp[i - 5] + 1);
			}
		}

		if (dp[N] != INF) {
			System.out.println(dp[N]);
		} else {
			System.out.println("-1");
		}
	}

}
