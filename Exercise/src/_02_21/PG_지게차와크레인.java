package _02_21;

import java.util.ArrayDeque;
import java.util.Queue;

//길이가 2 이상이면 지게차로 모두 뽑기 가능

// 길이가 2이다 배열 내 문자 모두 제거
// 길이가 1이다.... 제거 방법은?=>가장자리의 특정 알파벳 및 빈 칸에서 bfs를 돌려서 제거

public class PG_지게차와크레인 {

	static int n, m;
	static char[][] container;
	static boolean[][] visited;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	static int solution(String[] storage, String[] requests) {

		n = storage.length;
		m = storage[0].length();

		container = new char[n][m];
		// 맵을 만든다
		for (int i = 0; i < n; i++) {
			container[i] = storage[i].toCharArray();
		}

		// 요청을 처리한다

		for (String str : requests) {
			char type = str.charAt(0);
			if (str.length() == 1) { // 지게차
				forklift(type);
			} else {
				crane(type);
			}

		}

		return counts();

	}

	static void crane(char type) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (container[i][j] == type) {
					container[i][j] = ' '; // 해당 타입의 컨테이너를 빈 공간으로 변경
				}
			}
		}
	}

	// 외부에서 접근 가능한 컨테이너만 제거
	static void forklift(char type) {
		Queue<int[]> queue = new ArrayDeque<int[]>(); // bfs위한 큐
		visited = new boolean[n][m];

		// 일단 가장자리 제거 가능한 공간 큐에 추가
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
					// 타겟 컨테이너이거나 빈 공간인 경우
					if (container[i][j] == type || container[i][j] == ' ') {
						queue.offer(new int[] { i, j, container[i][j] });// 해당 위치의 값 저장
						visited[i][j] = true;
						container[i][j] = ' '; // 빈 공간으로 변경
					}
				}
			}
		}

		// BFS로 접근 가능한 모든 공간 탐색
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			if (cur[2] != type) { // 빈 공간인 경우
				// 상하좌우
				for (int i = 0; i < 4; i++) {
					int nr = cur[0] + dy[i];
					int nc = cur[1] + dx[i];
					
					if (nr >= 0 && nr < n && nc >= 0 && nc < m
							&& (container[nr][nc] == type || container[nr][nc] == ' ') && !visited[nr][nc]) {
					
						queue.offer(new int[] {nr,nc,container[nr][nc]});
						container[nr][nc] = ' ';
						visited[nr][nc] = true;
					
					}
				}
			}
		}
	}

	static int counts() {
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (container[i][j] != ' ')
					count++;

			}
		}
		return count;
	}

	public static void main(String[] args) {

//		String[] storage = { "AZWQY", "CAABX", "BBDDA", "ACACA" };
//
//		String[] requests = { "A", "BB", "A" };

		String[] storage = { "HAH", "HBH", "HHH", "HAH", "HBH" };

		String[] requests = { "C", "B", "B", "B", "B", "H" };

		System.out.println(solution(storage, requests));

	}
}
