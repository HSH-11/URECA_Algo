package _02_13;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class DFS_BFS_Graph {

	static List<List<Integer>> adjList = new ArrayList<>();
	static boolean[] visit;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 5; i++) {
			adjList.add(new ArrayList<Integer>());
		}
		
		
		// 간선
		// 1 -> 2,4
		// 2 -> 3,4
		// 3 -> 2
		// 4 -> 2
		
		adjList.get(1).add(2);
		adjList.get(1).add(4);
		adjList.get(2).add(3);
		adjList.get(2).add(4);
		adjList.get(3).add(2);
		adjList.get(4).add(2);
		
		visit = new boolean[5];
		
//		dfs(1);
		bfs(1);
	}
	
	static void dfs(int v) {
		visit[v] = true;
		System.out.print(v+" -> ");
		List<Integer> list = adjList.get(v);
		
		for (Integer i : list) {
			if (visit[i]) continue; // 갈 수 없거나, 이미 방문한 정점 정리
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
			
			List<Integer> list = adjList.get(v);
			for (Integer i : list) {
				if (visit[i] ) continue;
				queue.offer(i);
				visit[i] = true;
			}
		}
	}

}
