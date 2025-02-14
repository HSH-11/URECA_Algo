package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// MST
// 정점 중심 풀이
// 인접 행렬, 인접 리스트 등을 이용해서 한 정점
// 임의의 시작 정점을 정한다.
// 시작 정점 포함 최소 비용의 정점 중에서 갈 수 있는 다른 정점들 중에 최소 비용의 정점
// 시작 정점 포함 이후의 과정에서 선택된 정점들 모두가 새로운 최소 비용의 정점을 선택하는 후보
// 위 과정을 선택된 정점의 수가 전체 정점의 수가 될 때까지 계속 진행
public class Prim {
	
	static int V,sum;
	static int[][] matrix;
	static boolean[] visit;
	static PriorityQueue<Vertex> pqueue = new PriorityQueue<>((v1, v2) -> v1.c - v2.c);
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		matrix = new int[V][V];
		visit = new boolean[V];
		
		for (int i = 0; i < V; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < V; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		pqueue.offer(new Vertex(3,0));
		int cnt = 0;
		
		while(!pqueue.isEmpty()) {
			Vertex vertex = pqueue.poll();
			
			if(visit[vertex.v]) continue;
			
			visit[vertex.v] = true; //꺼낸 녀석으로부터 갈 수 있는
			sum += vertex.c;
			cnt++;
			
			
			if (cnt == V) break;
			
			//꺼낸 정점 vertex로 부터 갈 수 있는 다른 정점들을 pqueue에 넣는다
			for (int i = 0; i < V; i++) {
				if(matrix[vertex.v][i] == 0 || visit[i]) continue;
				pqueue.offer(new Vertex(i,matrix[vertex.v][i]));
				
			}
			
		}
		System.out.println(sum);
	}
	static class Vertex {
		int v, c; // 정점 객체가 생성되는 시점에 PQ 에서 꺼낸 정점으로부터 갈 수 있는 다른 정점과 그 비용
		Vertex(int v, int c){
			this.v = v;
			this.c = c;
		}
		
		@Override
		public String toString() {
			return "Vertex [v=" + v + ", c=" + c + "]";
		}
	}

}
