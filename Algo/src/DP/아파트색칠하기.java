package DP;

import java.util.Arrays;

//이전 단계보다 더 늘어난 수는 이전 단계의 노란색 수와 같다
//노란색은 노란색, 파란색 2가지로 늘어난다.

public class 아파트색칠하기 {
	static int[] dp = new int[9];
	public static void main(String[] args) {
			
		dp[1] = 2;
		dp[2] = 3;
		for (int i = 3; i <= 8; i++) {
			dp[i] = dp[i-2]+dp[i-1];
		}
		
		System.out.println(Arrays.toString(dp));
	}

}
