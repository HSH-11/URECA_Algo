package _02_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


// 별을 다 채우고 공백을 삽입

public class BJ_별찍기10_2447 {
	
	static char[][] board;
	static void makeBlank(int xStart, int yStart, int totalSize) {
		if (totalSize == 1) {
			return;
		}
		
		int size = totalSize / 3;
		
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				if (x == 1 && y == 1) continue;
					makeBlank(xStart + x * size, yStart + y * size, size);
			}
		}
		
		for (int x = xStart + size; x < xStart + size * 2; x++) {
			for (int y = yStart + size; y < yStart + size * 2; y++ ) {
				board[x][y] = ' ';
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		//Devide-Conquer
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		board = new char[N][N];
		
		for (int i = 0; i<N; i++) {
			Arrays.fill(board[i], '*');
		}
		
		makeBlank(0,0,N);
		
		for (int i = 0; i < N; i++ ) {
			System.out.println(board[i]);
		}
		br.close();
		
	}

}
