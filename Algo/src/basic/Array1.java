package basic;

public class Array1 {

	public static void main(String[] args) {
		//#1 맨 앞부터 3개씩 묶어서 곱셈 결과가 맞으면 통과 틀리면 wrongCnt 증가
		{
			int wrongCnt = 0;
			int[] intArray = { 3, 2, 6, 3, 4, 4, 1, 4, 2, 2, 3, 6, 1, 3, 5, 1, 5, 1, 1, 1, 1, 2, 4, 2, 2, 2, 4 };
			int len = intArray.length;
			for (int i = 0; i < len - 2; i += 3) {
				if (intArray[i] * intArray[i + 1] != intArray[i + 2]) {
					wrongCnt++;
				}
			}
			System.out.println(wrongCnt);
		}
		
		{//#2 양 끝에서 출발해서 안쪽으로 이동하면서 각 대칭 항목이 다른 몇건?
			int wrongCnt2 = 0;
			char[] charArray = "XYZEBFFGQOVVPWGFFCEAYX".toCharArray();
			int len2 = charArray.length;
			for(int i = 0; i < len2/2; i++) {
				if(charArray[i] != charArray[len2-i-1]) {wrongCnt2++;}
			}
			System.out.println(wrongCnt2);
		}
		{//#3. 문자열에 포함된 알파벳의 빈도수 출력, 0인 항목도 출력(유니코드 코드 비교)
			String str = "abbcccddddeeeeeffffggghhiabbcccddddeeeeeffffggghhi";
			//3-1
			//모든 알파벳 소문자가 몇 번 반복되었는지 출력
			int[] freq =  new int[26];
			for (char c : str.toCharArray()) {//for-each문을 통한 문자 접근
				if (c >= 'a' && c <= 'z') {
					freq[c-'a']++;
				}
			}
			for (int i = 0; i < 26; i++) {
	            System.out.println((char) ('a' + i) + ":" + freq[i]);
	        }
			System.out.println();
			//3-2
			int[] alphaCnt = new int[26];
			int strlen = str.length();
			
			for (int i = 0; i < strlen; i++) {//charAt(index)를 활용한 문자 접근
				alphaCnt[str.charAt(i) - 'a']++;
			}
			for (int i = 0; i < 26; i++) {
				System.out.println( (char)(i+'a') + ":"+alphaCnt[i]);
			}
		}
	}

}
