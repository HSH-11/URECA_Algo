package recursive;

public class Test {
	
	public static void main(String[] args) {
//		m1();
//		m1_param(0);
//		m2();
//		m3();
		m4(5);
	}
	
	static int m1_i = 0;
	static void m1() {
		// local 변수 <- 재귀 호출마다 스택에 만들어짐
//		int i = 0;
//		System.out.println("m1() "+ i++);
		//static 변수 <= 재귀호출마다 공유하기 때문에 m1_i값 증가
		System.out.println("m1() "+ m1_i++);
		m1();//또다른 stack메모리 사용
	}
	static void m1_param(int i) {
		//파라미터 변수 <= 재귀호출마다 스택에 새로 만들어지고 이전 호출에서 전달된 값을 복사
		System.out.println("m1_param() "+ i++);
		m1_param(i);
	}
	//기저 조건
	static int m2_cnt = 5;
	static void m2() {
		System.out.println("앞 m2() " + m2_cnt);
		//기저 조건
		if (m2_cnt > 0) {
			m2_cnt--;
			m2();
		}
		System.out.println("뒤 m2() " + m2_cnt);

	}
	static int m3_cnt = 5;
	static void m3() {
		//기저 조건
		if (m3_cnt == 0) return;
			
		System.out.println("앞 m3() " + m3_cnt);
		
		m3_cnt--;
		m3();
		m3_cnt++; // 이 코드가 없으면 static 변수 m3_cnt가 0으로 감소한후 계속 유지, 원복 필요
		System.out.println("뒤 m3() " + m3_cnt);

	}
	static void m4(int m4_cnt) {
		//기저 조건
		if (m4_cnt == 0) return;
			
		System.out.println("앞 m4() " + m4_cnt);
		
//		m4(m4_cnt-1); //호출 시 전달받은 m4 cnt는 변화 x
		
//		m4(m4_cnt--); // 5가 계속 전달되면서 스택 오버 플로우
		m4(--m4_cnt); // 호출 시 전달 받은 m4_cnt가 1감소
		m4_cnt++; //원복 필요
		System.out.println("뒤 m4() " + m4_cnt);

	}
}
