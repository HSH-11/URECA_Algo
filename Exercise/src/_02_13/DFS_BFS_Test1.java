package _02_13;

import java.util.ArrayDeque;
import java.util.Queue;

public class DFS_BFS_Test1 {

	static boolean[][] matrix;
	static boolean[] visit;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		matrix = new boolean[5][5];
		// 간선
		// 1 -> 2,4
		// 2 -> 3,4
		// 3 -> 2
		// 4 -> 2
		matrix[1][2] = true;
		matrix[1][4] = true;
		matrix[2][3] = true;
		matrix[2][4] = true;
		matrix[3][2] = true;
		matrix[4][3] = true;
		
		// visit 초기화
		visit = new boolean[5];
		
		visit = new boolean[5];
		
//		dfs(2);
		bfs(1);
	}
	static void dfs(int v) {
		visit[v] = true;
		System.out.print(v+" -> ");
		
		for (int i = 1; i <= 4; i++) {
			if (!matrix[v][i] || visit[i]) continue; // 갈 수 없거나, 이미 방문한 정점 정리
			dfs(i);
		}
	}
	
	static void bfs(int sv) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(sv);
		visit[sv] = true;
		
		while(!queue.isEmpty()) {
			int v = queue.poll();
			System.out.print(v + " -> ");
			
			for (int i = 1; i <= 4; i++) {
				if (!matrix[v][i] || visit[i] ) continue;
				queue.offer(i);
				visit[i] = true;
			}
		}
	}

}
