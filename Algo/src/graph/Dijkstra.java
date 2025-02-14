package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//한 정점에서부터 그래프의 다른 정점으로 가는 최소 비용
//정점(Vertex) 중심 풀이
//한 정점으로부터 다른 모든 정점으로 가는 최소 비용을 관리하는 배열 int[] cost
//이 배열을 초기값으로 충분히 큰 값으로 설정, 이후 알고리즘을 진행하면서 시작 정점으로부터 비용을 갱신 진행
//알고리즘 처리가 종료되면 cost[] 의 값이 최소 비용 
//시작정점 0, 5 개의 정점이 있으면 cost : { 0, 4, 6, 2, 7 }
//0 -> 1 : 4, 0 -> 4 : 7
//

//정점(들)에서 다른 모든 연결된 정점 중 최소 비용의 정점 찾는 방법? <= PriorityQueue 활용
//PriorityQueue 에서 꺼낸 정점으로부터 갈 수 있는 다른 정점을 통해 cost 배열이 갱신될 수 있으면 갱신하고 갱신된 정점을 다시 PQ 에 넣는다.
//
public class Dijkstra {
	
	static int V,start,end;
	static int[][] matrix;
	static PriorityQueue<Vertex> pq = new PriorityQueue<>((v1,v2)->v1.c-v2.c);
	
	static int[] cost;
	static final int INF = Integer.MAX_VALUE;
	
	
	static class Vertex{        
        int v;
        int c;
        
        public Vertex(int v, int c) {
            this.v = v;
            this.c = c;
        }
    }
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		start = 0;
		end = V -1;
		matrix = new int[V][V];
		cost = new int[V];
		
		
		for (int i = 0; i < V; i++) {
			StringTokenizer st =  new StringTokenizer(br.readLine());
			for (int j = 0; j < V; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Arrays.fill(cost, INF);
		
		cost[start] = 0;
		pq.offer(new Vertex(start,0));
		
		
		while(!pq.isEmpty()) {
			
			Vertex vertex = pq.poll(); 
			
			//cost[] 갱신 여부 비용비교를 통해서 방문 체크도 같이
			//이미 방문했거나 비용이 더 높기 때문에 방문 하지 않음(큐에 같은 목적지를 가진 cost가 다른게 큐에 들어있기 때문)
			if ( cost[vertex.v] < vertex.c ) continue;
			
			for (int i = 0; i < V; i++) {
				//꺼낸 정점으로부터 갈 수 있는 정점 고려
				if (matrix[vertex.v][i] == 0) continue;
				
				// 갱신 
				if (cost[i] > vertex.c+matrix[vertex.v][i]) {
					cost[i] = vertex.c+matrix[vertex.v][i];
					pq.offer(new Vertex(i,cost[i]));
				}
			}
			
		}
		System.out.println(cost[end]);
		System.out.println(Arrays.toString(cost));
	}

}
