package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// MST
// 간선 중심 풀이
// 간선 리스트를 최소비용 순으로 정렬
// 만약 간선이 많은 문제는 불리
// 정렬 후 최소비용 간선을 계속 선택해서 간선이 연결하는 정점 선택
//  Cycle이 발생하는 간선 skip
//  선택한 간선의 수가 정점의 수-1개 될 때 까지 진행
public class Kruskal {
	
	static int V,E,sum; //sum: MST 비용
	static Edge[] edges; // 간선 리스트
	static int[] parent; // 각 원소별 집합 관계를 표현
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		parent = new int[V];
		edges = new Edge[E]; //간선의 수가 주어졌으므로 배열 사용, 간선의 수가 주어지지 않았다? List, ArrayList 이용
		
		//간선 리스트 입력 처리
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			edges[i] = new Edge(v1,v2,c);
			
		}
		makeSet();
		
		// 간선을 비용(c)기준으로 정렬
		Arrays.sort(edges,(e1,e2)->e1.c-e2.c);
		
		System.out.println(Arrays.toString(edges));
		
		// 크루스칼 
		int cnt = 0; // 선택된 간선의 수의 합
		int edgesLen = edges.length;
		for (int i = 0; i< edgesLen; i++) {
			Edge edge = edges[i];
			//cycle 체크하고 없으면 선택
			if (union(edge.v1,edge.v2)) {
				//Cycle이 안생기고 간선이 하나 선택됨
				System.out.println(edge.v1+"->"+edge.v2+" : "+edge.c);
				sum += edge.c;
				cnt++;
				if(cnt == V -1) break;
			}
			
		}
		System.out.println(sum);
		
	}
	//간선 클래스 <= int[] 대체 가능
	static class Edge {
		int v1, v2, c;

		public Edge(int v1, int v2, int c) {
			this.v1 = v1;
			this.v2 = v2;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Edge [v1=" + v1 + ", v2=" + v2 + ", c=" + c + "]";
		}
		
		
		
	}
	
	static void makeSet() {
		for (int i = 0; i < V; i++) {
			parent[i] = i; // 모두가 대표 원소
		}
	}
	static int findSet(int x) { 
		if (parent[x] == x)
			return x; // 대표원소이면 x 리턴
		return parent[x] = findSet(parent[x]); // 맨 꼭대기 대표원소의 index 값이 리턴되어 돌아오는데 이 중간 과정의 x 의 부모 parent[x] 에 넣는다.
	}

	// 전달된 두 원소 x, y 에 대해, x가 속한 집합과 y가 속한 집합을 하나의 집합으로 합친다.
	// 기존 union
//	static void union(int x, int y) {
//		int px = findSet(x);
//		int py = findSet(y);
//		// px == py 이면 이미 같은 집합
//		// 그렇지 않은 경우 규칙부여할 수 있다. 아래 코드는 작은 값을 부모로.
//		if (px < py)
//			parent[py] = px;
//		else
//			parent[px] = py;
//	}
	// 크루스칼은 findSet(v1) findSet(v2)를 이용해서 cycle 체크하고 cycle이 안생기면 union()
	// findSet(v1), findSet(v2) 중복 실행이 되므로 크루스칼에 맞게 변형
	static boolean union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		
		if (px == py) return false; //간선을 추가하려는데 두 부모가 같다? 두 정점은 같은 집합 상태
		if (px < py) parent[py] = px;
		else parent[px] = py;
			
		return true;
	}
}
/*
정점수 간선수
v1 v2 가중치
5 10
0 1 5
0 2 10
0 3 8
0 4 7
1 2 5
1 3 3
1 4 6
2 3 1
2 4 3
3 4 1
*/
