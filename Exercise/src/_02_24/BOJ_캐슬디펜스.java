package _02_24;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 조합 + 시뮬레이션
// 궁사의 위치 3개를 조합으로 뽑음
// 적들 중 D거리안에 해당하는 적만 대상으로 가까운 적 골라 제거 => 적 이동

// 자료구조
// 2차원 배열에 적을 두고 이동 X (Map을 사용하지 않음)
// 적을 ArrayList에 담고 제거
public class BOJ_캐슬디펜스 {
	static int N, M, D, max;
	static int[] archer = new int[3];
	static List<Enemy> enemyCopy = new ArrayList<>(); 
	static List<Enemy> enemy = new ArrayList<>(); //작업본
	static PriorityQueue<Enemy> pqueue = new PriorityQueue<>((e1, e2) -> e1.d == e2.d ? e1.x - e2.x : e1.d - e2.d);

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int n = Integer.parseInt(st.nextToken());
				if (n == 1)
					enemyCopy.add(new Enemy(i, j)); // 좌표만 이용
			}
		}

		comb(0, 0);
		System.out.println(max);
	}
	
	static void check() {
		enemy.clear();
		for (Enemy e : enemyCopy) {
			enemy.add(new Enemy(e.y, e.x));
		}
		
		// 현재 궁사의 조합에서 적을 최대로 죽여야 함
		int dead = 0;
		while(true) {
			//3명의 궁사가 한 번씩 D 거리안의 적에게 화살 쏨
			for (int i = 0; i < 3; i++) {
				pqueue.clear();
				int ac = archer[i]; //현재 궁사의 x좌표
				int size = enemy.size();
				
				//모든 적들 중에 현재 궁사와의 거리가 D이하인 적만 pq에 넣은다
				for (int j = 0; j < size; j++) {
					Enemy e = enemy.get(j);
					//맨하탄 거리
					e.d = Math.abs(ac-e.x)+Math.abs(N-e.y);
					
					if (e.d > D) continue;
					
					pqueue.offer(e);
				}
				
				//pqueue가 empty하지 않으면 적 1개를 꺼내고 죽었다 표시
				if (!pqueue.isEmpty()) {
					pqueue.poll().dead = true;
				}
			}
			
			// 죽은 적 정리 (ArrayList에서 삭제), 이동
			// collection에서의 삭제 시 뒤부터 처리, 또는 Iterator 사용
			for (int i = enemy.size()-1; i >= 0; i--) {
				Enemy e = enemy.get(i);
				if(e.dead) {
					enemy.remove(i);
					dead++;
				}else if (e.y == N - 1){ // 죽지 않았지만 마지막 행이면 삭제
					enemy.remove(i);
				}else {
					e.y++; // 이동
				}
			}
			if (enemy.size() == 0) break;
		}
		max = Math.max(max, dead);
	}

	static void comb(int srcIdx, int tgtIdx) {
		// 기저조건
		if (tgtIdx == 3) {
			check();// 시뮬 진행
			return;
		}

		if (srcIdx == M)
			return;

		archer[tgtIdx] = srcIdx; // 현재 tgtIdx에 srcIdx 선택

		comb(srcIdx + 1, tgtIdx + 1); // 선택
		comb(srcIdx + 1, tgtIdx); // 비선택

	}

	static class Enemy {
		int y, x, d; // d: 현재 따지는 궁수와의 거리 
		boolean dead;

		Enemy(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

}
