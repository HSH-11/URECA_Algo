package sort;

import java.util.Arrays;
import java.util.Collections;

public class ArraySortTest {

	public static void main(String[] args) {
		//int
//		int[] intArray = {3,5,2,7,9,4};
//		
//		System.out.println(Arrays.toString(intArray));
//		Arrays.sort(intArray); // 오름차순
//		System.out.println(Arrays.toString(intArray));
//		
//		//String
//		String[] strArray = {"Hello","ABC","World","UPlus"};
//		System.out.println(Arrays.toString(strArray));
//		Arrays.sort(strArray,Collections.reverseOrder()); // 오름차순
//		System.out.println(Arrays.toString(strArray));
		
		//사용자 정의 클래스
		Item[] itemArray = { new Item(2,"33"), new Item(3,"66"), new Item(2,"77"), new Item(5,"44"), new Item(8,"11")};
		Arrays.sort(itemArray);
		System.out.println(Arrays.toString(itemArray));
	}
	// 객체들을 정렬할 때 기준이 필요하다
	// #1 클래스에 정의
	static class Item implements Comparable<Item>{
		int itemId;
		String itemNm;
		
		Item(int itemId, String itemNm){
			this.itemId = itemId;
			this.itemNm = itemNm;
		}

		@Override
		public String toString() {
			return "Item [itemId=" + itemId + ", itemNm=" + itemNm + "]";
		}

		@Override
		public int compareTo(Item o) {// 정렬 기준 정의
//			return this.itemId - o.itemId; // natural ordering
//			return this.itemNm.compareTo(o.itemNm);//String클래스의 compareTo함수
			// itemId 우선 비교하는데 같은 값이면 itemNm 비교
			// itemId 기준으로 먼저 비교
		    if (this.itemId != o.itemId) {
		        return this.itemId - o.itemId; // 오름차순
		    }
		    // itemId가 같다면 itemNm을 비교
		    return this.itemNm.compareTo(o.itemNm); // 사전순 정렬
			
		}
		
		
	}

}
