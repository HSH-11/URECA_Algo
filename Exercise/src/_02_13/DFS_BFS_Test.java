package _02_13;

import java.util.ArrayDeque;
import java.util.Queue;

// 2차원 배열 상하좌우 탐색을 통한 dfs,bfs
// 한 번 방문한 좌표는 다시 방문 X
public class DFS_BFS_Test {
	
	static int[][] map = {
            {0,  0,  0,  0,  0,  0,  0},
            {0, 11, 12, 13, 14, 15, 16},
            {0, 21, 22, 23, 24, 25, 26},
            {0, 31, 32, 33, 34, 35, 36},
            {0, 41, 42, 43, 44, 45, 46},
            {0, 51, 52, 53, 54, 55, 56},
            {0, 61, 62, 63, 64, 65, 66},
    };
    
    // 상 - 하 - 좌 - 우 순서
    static int[] dy = { -1, 1,  0, 0 };
    static int[] dx = {  0, 0, -1, 1 };
    
    static boolean[][] visited;
    
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		visited = new boolean[7][7];
//		dfs(3,3);
		bfs(3,3);
	}
	
	static void dfs(int y, int x) {
		// 해당 좌표에서 할 일 진행
		visited[y][x] = true;
		System.out.println(map[y][x]);
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if (ny < 1 || nx < 1 || ny >= 7 || nx >= 7 || visited[ny][nx]) continue;
			
			dfs(ny,nx);
		}
	}
	
	static void bfs(int y, int x) {
		Queue<Node> queue = new ArrayDeque<>();
		queue.offer(new Node(y,x));
		visited[y][x] = true;
		
		while(!queue.isEmpty()) {
			Node curr = queue.poll();
			int curr_y = curr.y;
			int curr_x = curr.x;
			System.out.println(map[curr_y][curr_x]);
			for (int i = 0; i < 4; i++) {
				int ny = curr_y + dy[i];
				int nx = curr_x + dx[i];
				
				if (ny < 1 || nx < 1 || ny >= 7 || nx >= 7 || visited[ny][nx]) continue;
				
				queue.offer(new Node(ny,nx));
				visited[ny][nx] = true; 
				
			}
			
		}
		
	}
	static class Node {
		int y,x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
		
	}

}
