package bj1916;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<Node>[] graph;
	static int INF = Integer.MAX_VALUE;
	static int[] dist;
	
	static class Node implements Comparable<Node>{
		int vertex;
		int weight;
			
		public Node(int vertex, int weight) {
		
			this.vertex = vertex;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			
			return this.weight - o.weight;
		}
					
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[N];
		dist = new int[N];
		
		StringTokenizer st;
		
		for (int i = 0; i < N; i++) {
			graph[i] = new ArrayList<Node>();
			dist[i] = INF;
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken())-1;
			int v = Integer.parseInt(st.nextToken())-1;
			int w = Integer.parseInt(st.nextToken());
			
			graph[u].add(new Node(v,w));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken())-1;
		int end = Integer.parseInt(st.nextToken())-1;
		
		dijkstra(start);
		System.out.println(dist[end]);
			
		
	}
	static void dijkstra(int s) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(s,0));
		dist[s] = 0;
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			int curr_vertex = curr.vertex;
			int curr_weight = curr.weight;
			
			if (curr_weight > dist[curr_vertex]) continue;
			
			for (Node next : graph[curr_vertex]) {
				int next_vertex = next.vertex;
				int next_weight = next.weight;
				
				if(dist[next_vertex] > dist[curr_vertex] + next_weight) {
					dist[next_vertex] = dist[curr_vertex] + next_weight;
					pq.add(new Node(next_vertex,dist[next_vertex]));
				}
			}
		}
	}

}
