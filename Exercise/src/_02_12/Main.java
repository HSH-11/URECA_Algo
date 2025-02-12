package _02_12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N, r, c, ans = 0;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2, N); // 2^N 크기의 정사각형
        z(size, 0, 0); // 시작 위치: (0,0)

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
	}
	
	static void z(int size,int y, int x) {
		if (size == 1) return;
		
		int half = size/2;
		
		if (r < y + half && c < x + half) { //1사분면
			z(half,y,x);
		}else if (r < y + half && c>= x + half) {
			ans += half*half;
			z(half,y,x+half);
		}else if(r >= y+half && c < x + half) {
			ans += half*half*2;
			z(half,y+half,x);
		}else {
			ans += half*half*3;
			z(half,y+half,x+half);
		}
	}

}
