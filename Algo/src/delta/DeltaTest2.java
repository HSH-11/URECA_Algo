package delta;

import java.util.Arrays;

public class DeltaTest2 {

	static char[][] map = new char[5][5];

	public static void main(String[] args) {
		char ch = 'A';

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				map[i][j] = ch++;
			}
		}
		
		// 출력
        for (int i = 0; i < 5; i++) {
            System.out.println(Arrays.toString(map[i]));
        }

		// 4방탐색 상 하 좌 우
		int y = 2;
		int x = 2;
		
		System.out.println("현위치: " + map[y][x]);
		
		print4x(y,x);
	}
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	//이동 좌표(상,하,좌,우)좌표를 구하는 방식
	static void print4x(int y, int x) {
		for (int d = 0; d < 4; d++) {
			int ny = y;
			int nx = x;
			//계속 이동
			while(true) {
				ny = ny + dy[d];
			    nx = nx + dx[d];
			    
			    if(ny < 0 || nx < 0 || ny >= 5 || nx >= 5) break;
			    System.out.println(map[ny][nx]);
			}
		}
	}
	

}
