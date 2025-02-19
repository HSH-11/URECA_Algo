package DP;

import java.util.Arrays;

// 현재 길이를 만들기 위해서 사용할 수 있는 막대는 3가지
public class 막대연결하기 {
	
	static int[] dp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dp = new int[7];
		
		dp[1] = 2;
		dp[2] = 5;
		for (int i = 3; i<=6; i++) {
			dp[i] = 2* dp[i-1] + dp[i-2];
		}
		
		System.out.println(Arrays.toString(dp));
	}

}
