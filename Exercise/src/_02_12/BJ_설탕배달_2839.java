package _02_12;

import java.io.*;

public class BJ_설탕배달_2839 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = 0;

		while (true) {
			if (N < 0) {
				System.out.println(-1);
				break;
			}
			if (N % 5 == 0) {
				System.out.println(answer + (N / 5));
				break;
			}
			N -= 3;
			answer++;
		}
	}

}
