package IO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BufferedReaderTest {

	public static void main(String[] args) throws Exception {
		// BufferedReader ( InputStreamReader())
		// Scanner에 비해 매우 빠른 성능 보장

		// 1 2 3 4 5
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String str = br.readLine();
			
			int[] input = new int[5];
			StringTokenizer st = new StringTokenizer(str);
			
			for (int i = 0; i < 5; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}
			System.out.println(Arrays.toString(input));
		}
		// 1 A 3 B 5
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String str = br.readLine();
			
			char[] input = new char[5];
			StringTokenizer st = new StringTokenizer(str);
			
			for (int i = 0; i < 5; i++) {
				input[i] = st.nextToken().charAt(0);
			}
			System.out.println(Arrays.toString(input));
			
		}
		// ABCDE
				{
					BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
					String str = br.readLine();
									
					char[] input =  str.toCharArray();
					System.out.println(Arrays.toString(input));
					
				}

		/*
		 * 5 1 2 3 4 5
		 */
				{
					BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
					int N = Integer.parseInt(br.readLine());
					int[] input = new int[N];
					
					String str = br.readLine();
					StringTokenizer st = new StringTokenizer(str);
					
			
					for (int i = 0; i < 5; i++) {
						input[i] = Integer.parseInt(st.nextToken());
					}
					System.out.println(Arrays.toString(input));
				}
		/*
		 * 5 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5
		 */
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int N = Integer.parseInt(br.readLine());

			int[][] input = new int[N][N];

			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				StringTokenizer st = new StringTokenizer(str);
				for (int j = 0; j < N; j++) {
					input[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			System.out.println(N);

			// 1개씩 확인
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(input[i][j] + " ");
				}
				System.out.println();
			}
			// 라인 단위 확인
			for (int i = 0; i < N; i++) {
				System.out.println(Arrays.toString(input[i]));
			}
		}
		/*
		3 5
		1 2 3 4 5
		6 7 8 9 0
		1 2 3 4 5
		 */
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			int[][] input = new int[R][C];

			for (int i = 0; i < R; i++) {
				String str1 = br.readLine();
				StringTokenizer st1 = new StringTokenizer(str1);
				for (int j = 0; j < C; j++) {
					input[i][j] = Integer.parseInt(st1.nextToken());
				}
			}
			System.out.println(R);
			System.out.println(C);
			
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					System.out.print(input[i][j] + " ");
				}
				System.out.println();
			}
			// 라인 단위 확인
			for (int i = 0; i < R; i++) {
				System.out.println(Arrays.toString(input[i]));
			}
		}
		
		// 출력에 대한 자료 구조
		// 입력 자료 >>>> 출력 자료
		// 출력 자료구조가 간단한 정수정도면 별도의 자료구조X
		// 출력이 문자열이고 크기가 계속 증가한다.
		// -BufferedWriter : 코드가 길다.
		// -StringBuilder : 코드가 짧다.
	}

}