package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class UnionFind {
	
	static int v,e;
	static int[] parent; // 각 원소별 집합 관계를 표현
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		//그래프 정점(1~6)간 집합 표현
		parent = new int[v+1]; //0 dummy
		
		// 각 원소별 자기 자신이 대표원소가 되도록 초기화 (서로소 집합)
		makeSet();
		
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if (findSet(x) ==  findSet(y)) {
				System.out.println(x+", "+y+" cycle 발생");
				System.out.println(Arrays.toString(parent));
			}
			else {
				union(x,y);//findSet(x) == findSet(y)이 이미 union에 포함되어 비효율
				System.out.println(x+", "+y+" union");
				System.out.println(Arrays.toString(parent));
			}
			
		}
		
		
	}
	
	static void makeSet() {
		for (int i = 1; i <= v; i++) {
			parent[i] = i; //모두가 대표 원소
		}
	}
	
	// 전달된 x 원소의 대표원소 찾아서 return
	// Path compression
	static int findSet(int x) {
		if (parent[x] == x) {
			return x;
		}
		return parent[x] = findSet(parent[x]);
		
	}
	// 전달된 두 원소 x,y에 대해, x가 속한 집합과 y가 속한 집합을 하나의 집합으로 합친다.
	static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		// px == py이면 이미 같은 집합
		// 그렇지 않은 경우 규칙 부여할 수 있다.
		if (px < py) parent[py] = px;
		else parent[px] = py;
	}
}


