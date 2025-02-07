package comb;

import java.util.Arrays;

public class BasicComb {

	static int[] src = {1,2,3,4,5};
	static int[] tgt = new int[3]; //현재 자리를 채우기 위해, src의 맨 앞에서부터 수를 선택/비선택 해가면서 tgt 개수를 채운다
	
	public static void main(String[] args) {
		comb(0,0);
	}
	// 조합
	// src의 srcIdx 자리의 수를 tgtIdx 자리에 선택? 비선택?
	static void comb(int srcIdx, int tgtIdx) {
		// 기저 조건
		if (tgtIdx == tgt.length) {
			System.out.println(Arrays.toString(tgt));
			return ;
		}
		if (srcIdx == src.length) return;
		
		tgt[tgtIdx] = src[srcIdx]; //선택
		comb(srcIdx + 1, tgtIdx +1); // 현재 자리 선택을 받아들이고 다음 자리로 재귀 호출
		comb(srcIdx + 1, tgtIdx); // 이전 선택을 srcIdx 다음 수로 덮어 쓰는 경우
	}

}
