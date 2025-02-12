package _02_11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Deque<Integer> deque = new ArrayDeque<Integer>();
		
		for (int i = 1; i <= N; i++) {
			deque.offerLast(i);
		}
		
		sb.append("<");
		while(deque.size()>1) {
			for(int i = 1; i <= K-1; i++) {
				int num = deque.pollFirst();
				deque.offerLast(num);
			}
			sb.append(deque.pollFirst()).append(", ");
		}
		sb.append(deque.pollFirst()).append(">");
		
		System.out.println(sb.toString());

	}

}
