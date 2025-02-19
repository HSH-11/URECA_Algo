package _02_18;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*<문제 분석>
 * -격자칸에 상어는 최대 1마리
 * -상어는 크기,속도(방향+속력)를 가짐
 * -낚시왕은 왼쪽에서 오른쪽으로 이동하며 상어를 잡음
 * -상어가 이동할 때 경계를 넘으면 방향을 반대로 바꿈
 * -한 칸에 여러 상어가 겹치면 크기가 큰 상어만 남음
 * <동작 순서>
 * 1.낚시왕을 (1,1)에서 시작하여 오른쪽으로 한 칸씩 이동
 * 2.현재 열에서 가장 가까운 상어를 잡고 크기를 합산
 * 3.모든 상어를 이동
 * 4.이동 후 같은 칸에 있는 상어 중 가장 큰 상어만 남김
 * 5.낚시왕이 오른쪽 끝에 도달하면 종료
*/

/*<의사코드>
 * 1. 맵 및 상어 정보 입력
 * 2. 낚시왕이 이동하면서 해당 작업을 반복
 * 	- 현재 열에서 가장 가까운 상어 찾기->크기 더한후,제거
 *  - 모든 상어 이동(경계처리,방향 변경)
 *  - 이동한 상어의 위치를 맵에 반영
 * 	- 같은 위치에 있는 상어 중 가장 큰 것만 남기기
 * 3. 최종적으로 잡은 상어의 크기의 합을 출력
 * */
// 계속해서 변하는 상어들의 위치를 어떤 자료구조에 저장? => 리스트 이용

public class BOJ_낚시왕 {

	static int R, C, M, sum;
	static Shark[][] map; // 상어 배치
	static List<Shark> list = new ArrayList<>(); // 존재하는 상어들의 정보

	// 상->하->우->좌
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };

	static class Shark {
		int r, c, s, d, z; // 위치,속력,방향,크기

		public Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// 맵 및 상어 정보 입력
		map = new Shark[R + 1][C + 1]; // 문제와 인덱스 맞추기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken()) - 1; // 이동방향을 0-based로 변경
			int z = Integer.parseInt(st.nextToken());

			Shark shark = new Shark(r, c, s, d, z);
			list.add(shark);
			map[r][c] = shark;
		}

		// 낚시왕이 상어 잡기 시작
		for (int i = 1; i <= C; i++) {
			catchShark(i); // i번째 열 상어 잡기
			moveShark();
			killShark();
		}
		
		System.out.println(sum);
	}

	// 땅과 가장 거리가 가까운 상어 잡기
	static void catchShark(int col) {
		// 밑으로 탐색하며 가장 거리가 가까운 상어를 만나면 sum에 추가
		// 상어 목록에서 제거
		for (int i = 1; i <= R; i++) {
			if (map[i][col] != null) { // 상어가 존재하는 칸이면
				sum += map[i][col].z; // sum에 추가
				list.remove(map[i][col]); // 상어 목록에서 제거
				break;
			}
		}
	}

	// 상어를 잡는 행위 이후 상어들의 이동
	static void moveShark() {
		for (Shark shark : list) { //존재하는 상어들의 좌표 갱신
			int r = shark.r;
			int c = shark.c;
			int s = shark.s;
			int d = shark.d;
			int z = shark.z;
			
			switch(d) {
			// 상하,좌우 따로 나누어서 계산
			
			// 상하(R 이용)
			case 0: // 1과 계산 방식 동일
			case 1:
				s = s % (R * 2 - 2); // 주기성을 이용해 이동 횟수를 줄임
				// 상어가 R만큼 이동하면 끝에 도달하고 다시 R만큼 이동하면 처음 위치로 돌아오는데
				// 맨 끝과 처음 위치는 중복되므로 -2
				for (int i = 0; i < s; i++) {
					if (r == 1) {
						d = 1; //꼭대기 : 상->하
					}
					else if (r == R) {
						d = 0; //바닥 : 하->상
					}
					r += dy[d];
				}
				shark.r = r;
				shark.d = d;
				break;
				
			// 우좌(C 이용)
			case 2:
			case 3:
				s = s % (C * 2 - 2);
				for (int i = 0; i < s; i++) {
					if (c == 1) {
						d = 2; //왼끝 : 좌->우
					}
					else if (c == C) {
						d = 3; //오른쪽 끝 : 우->좌
					}
					c += dx[d];
				}
				shark.c = c;
				shark.d = d;
				break;
			}
		}
	}
	
	// 같은 위치의 큰 상어가 작은 상어를 잡아 먹는다
	// 현존하는 상어를 담은 list를 이용해 map 초기화
	static void killShark() {
		//기존 map 정보 초기화
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				map[i][j] = null;
			}
		}
		
		// list로부터 shark를 하나씩 처리
		int size = list.size();
		for (int i = size - 1; i >= 0; i--) {
			Shark shark = list.get(i);
			
			
			if (map[shark.r][shark.c] == null) {//상어의 위치가 겹치지 않는 경우
				map[shark.r][shark.c] = shark; 
			}
			else if(shark.z > map[shark.r][shark.c].z) {
				//상어가 겹치는 경우 나중에 들어온 상어가 더 큰 경우
				//기존 상어 삭제 및 새 상어 map에 반영
				list.remove(map[shark.r][shark.c]); //기존 객체 삭제
				map[shark.r][shark.c] = shark;
			}else {
				// 이미 존재하던 상어를 냅두고 꺼낸 상어 삭제
				list.remove(shark);
			}
		}
	}

}
