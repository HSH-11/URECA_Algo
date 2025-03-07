package _02_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj1654 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[K]; 
		
		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		long left = 1;
		long right = arr[K-1];
		long mid;
		
		while (left<=right) {
			mid = (left+right) / 2;
			long total = 0;
	
			for (int num : arr) {
				total += num / mid;
			}
			if (total >= N) {
				left = mid + 1;
			}
			else {
				right = mid -1;
			}
		}
		System.out.println(right);
		
	}

}
