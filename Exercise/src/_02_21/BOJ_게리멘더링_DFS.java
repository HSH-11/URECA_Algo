package _02_21;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ_게리멘더링_DFS {

	static int N, min;
	static int[][] matrix;
	static boolean[] visit; // 모든 구역이 연결되어 있는 지 확인
	static boolean[] select; // 부분집합 처리용
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		matrix = new int[N + 1][N + 1];// 어차피 맨 앞자리가 더미이므로 그 자리에 인구수를 저장
		select = new boolean[N + 1];
		visit = new boolean[N + 1];

		// 인구
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			matrix[i][0] = Integer.parseInt(st.nextToken());
		}

		// 정점별 연결
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			for (int j = 1; j <= n; j++) {
				int v = Integer.parseInt(st.nextToken());
				matrix[i][j] = v;
			}
		}

		min = Integer.MAX_VALUE;

		subset(1);

		if (min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);
	}

	static void subset(int srcIdx) {
		//기저 조간
		if (srcIdx == N + 1) {
			//부분집합 경우의 수 1개 완성 <= select 배열에 true, false 기록
			check();
			return;
		}
		
		select[srcIdx] = true;
		subset(srcIdx+1);
		select[srcIdx] = false;
		subset(srcIdx+1);
	}
	
	// v정점에서 갈 수 있는 다른 정점 방문 visit에 기록
	static void dfs(int v, boolean sel) {
		visit[v] = true;
		for (int i = 1; i <= N; i++) {
			int adj = matrix[v][i];
			if (adj == 0 || visit[adj] || select[adj] != sel) continue;
			
			dfs(adj,sel);
		}
	}
	//나뉘어진 2개 선거구가 유효
	//유효하다면 두 선거구의 인구수를 계산, 차이 최소값 처리
	static void check() {
		//visit 배열을 이용해서 연결 여부 확인
		Arrays.fill(visit, false);
		
		
		//A 선거구 (select 배열 true인 구역)
		//선거구에 속한 구역 1개를 선택하고 완탐 진행 => 갈 수 있는 곳에 visit 기록
		int a = -1;
		for (int i = 1; i <= N; i++) {
			if(select[i]) {
				a = i;
				break;
			}
		}
		
		if (a == -1) return; // A 선거구의 구역이 O
		
		dfs(a,true); //true인 애들만 추가
		
		// B 선거구 ( select 배열 false 인 구역 )
        // 선거구에 속한 구역 1개를 선택 완탐 진행 => 갈 수 있는 곳에 visit 기록
		int b = -1;
        for (int i = 1; i <= N; i++) {
            if( ! select[i] ) {
            	b = i;
                break;
            }
        }
        
        if( b == -1 ) return; 
        
        dfs(b,false);       
        
        // 두 선거구 모두 연결 확인
        for (int i = 1; i <= N; i++) {
            if( ! visit[i] ) return; // 어떤 선거구의 구역이 연결 X
        }
        
        // A, B 선거구의 인구수를 계산, 최소값 갱신
        int sumA = 0;
        int sumB = 0;
        
        for (int i = 1; i <= N; i++) {
            if( select[i] ) sumA += matrix[i][0];
            else sumB += matrix[i][0];
        }
        
        min = Math.min(min, Math.abs(sumA - sumB));
    }
		
}
