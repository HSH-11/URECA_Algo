package _02_17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// 이전 상태에 놓여진 Queen이 계속 이후 상태에 영향을 미친다
// bfs로? queue에 담을 때 담는 시점의 rowColumns를 가지고 있어야 함
// 또한 유망하지 않은 상태도 큐에 추가하고 검사해야 함=> 불필요한 탐색 진행
public class BOJ_NQueen_9663 {
	static int N,count;
	static int[] rowColumns; //rowColumns[2] = 4 <= 2번 row에 현재 놓은 Queen column 값이 4
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		rowColumns = new int[N];
		
		dfs(0); // 0번째 row 시작
		System.out.println(count);
	}
	
	static void dfs(int row) {
		// 기저조건
		// 이전 단계에서 마지막 행까지 다 놓았으면
		if (row == N) {
			count++;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			rowColumns[row] = i; // 한 행에는 한 개의 Queen만 놓고 있다.
			//유망 함수를 호출해서 가능하면 다음 row로 계속 이어간다.
			if (check(row)) {
				dfs(row+1);
			}
		}
	}
	static boolean check(int row) {
		// 시작 row부터 현재 row까지만 따져보자
		for (int i = 0; i < row; i++) {
			// 세로로 겹치는 지
			if(rowColumns[i] == rowColumns[row]) return false;
			// 대각선으로 겹치는 지
			// 행의 변화량 == 열의 변화량이 같으면
			if(Math.abs(row-i) == Math.abs(rowColumns[row]-rowColumns[i])) return false;
		}
		
		return true;
	}
}
