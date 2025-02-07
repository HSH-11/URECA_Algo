//package IO;
//
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class ScannerTest {
//
//	public static void main(String[] args) {
//		// Scanner
//		// 편리하나 상대적(java.io)으로 무거움
//		// 매우 간단한 입력 처리에만 사용
//		
//		// 17 2 3 4 5
//		{
//			Scanner sc = new Scanner(System.in);
//			int[] input = new int[5];
//			
//			for (int i = 0; i < 5; i++) {
//				input[i] = sc.nextInt();	
//			}
//			sc.close();
//			System.out.println(Arrays.toString(input));
//		}
//		// 1 A 2 B C <= 문자
//		{
//			Scanner sc = new Scanner(System.in);
//			char[] input = new char[5];
//			
//			for (int i = 0; i < 5; i++) {
//				input[i] = sc.next().charAt(0); // "1" -> '1' next():공백 기준으로 하나의 단어를 입력받음
//			}
//			System.out.println(Arrays.toString(input));
//		}
//		// ABCDE <= 연속된 문자
//		{
//			Scanner sc = new Scanner(System.in);
//			char[] input = new char[5]; //기존에 만들어진 이 배열은 쓸모가 없음(garbage)
//			//한줄 전체 읽기 읽은 문자열을 char 배열로 전환
//			char[] input = sc.nextLine().toCharArray(); //배열을 새로 생성해서 리턴하므로 추가적인 메모리 발생
//			
//			System.out.println(Arrays.toString(input));
//			
//		}
//		/*
//		 5
//		 1 2 3 4 5
//		 */
//		{
//			Scanner sc = new Scanner(System.in);
//			int N = sc.nextInt();
//			int[] input = new int[N]; //위에서 읽은 수만큼 배열 생성
//			
//			for (int i = 0; i < 5; i++) {
//				input[i] = sc.nextInt();	
//			}
//			sc.close();
//			System.out.println(N);
//			System.out.println(Arrays.toString(input));
//		}
//		/*
//		 5[개행]
//		 ABCDE
//		 */
//		// next(),nextInt()는 개행문자를 포함하지 않는다.
//		// nextLine()은 개행문자를 만나면 읽는 처리가 종료
//		{
//			Scanner sc = new Scanner(System.in);
//			int N = sc.nextInt();
//			
//			sc.nextLine(); //5 뒤의 개행 처리
//			
//			char[] input = sc.nextLine().toCharArray();
//			
//			System.out.println(N);
//			System.out.println(Arrays.toString(input));
//		}
//	}
//
//}
