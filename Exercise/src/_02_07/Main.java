package _02_07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//public class Main { 시간 초과
//	
//	public static void main(String[] args) throws Exception{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        int test_case = Integer.parseInt(br.readLine());
//        for (int i = 0; i < test_case; i++) {
//            String[] input = br.readLine().split(" ");
//            int n = Integer.parseInt(input[0]);
//            int m = Integer.parseInt(input[1]);
//
//            bw.write(comb(m, n) + "\n");
//        }
//			System.out.println(comb(29,13));
//	}
//	static int comb(int m, int n) {		
//		if(n == 0 || n == m) {
//			return 1;
//		}
//		return comb(m-1,n-1)+comb(m-1,n);
//	}
//
//}
public class Main {
    //nCm = n-1Cm-1+n-1Cm
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int test_case = Integer.parseInt(br.readLine());
        
        int[][] dp = new int[30][30]; 

        for (int i = 0; i < 30; i++) {
            dp[i][0] = 1;  // nC0
            dp[i][i] = 1;  // nCn
        }

        for (int i = 2; i < 30; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }
        for (int i = 0; i < test_case; i++) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);

            bw.write(dp[m][n] + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
