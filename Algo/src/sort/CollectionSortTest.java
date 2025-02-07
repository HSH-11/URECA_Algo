package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class CollectionSortTest {

	public static void main(String[] args) {
		//ArrayList를 이용한 정렬
		List<Item> list = new ArrayList<>();
		list.add(new Item(2,"33"));
		list.add(new Item(3,"66"));
		list.add(new Item(2,"55"));
		list.add(new Item(8,"11"));
		list.add(new Item(5,"44"));
		
		
		System.out.println(list);
		
		// #1. Comparable
//		Collections.sort(list); // comparable 한 객체가 아닌 경우 컴파일 에러 발생
		
		// #2. Comparator 인터페이스 구현 - lambda
		//Collections.sort(list,(o1,o2) ->o1.itemId - o2.itemId);
		
		// #3. 1차 비교 기준이 동일할 경우 추가 기준 설정
		Collections.sort(list, (o1, o2) -> {
		    int result = o1.itemId - o2.itemId; // itemId 기준 정렬
		    return result != 0 ? result : o1.itemNm.compareTo(o2.itemNm); // itemId가 같으면 itemNm 정렬
		});
		Collections.sort(list, Comparator.comparingInt((Item o) -> o.itemId)
                .thenComparing(o -> o.itemNm)); 
		System.out.println(list);

	}
	// #1. Comparable
//	static class Item implements Comparable<Item>{
//		int itemId;
//		String itemNm;
//		
//		Item(int itemId, String itemNm){
//			this.itemId = itemId;
//			this.itemNm = itemNm;
//		}
//
//		@Override
//		public String toString() {
//			return "Item [itemId=" + itemId + ", itemNm=" + itemNm + "]";
//		}
//
//		@Override
//		public int compareTo(Item o) {// 정렬 기준 정의
////			return this.itemId - o.itemId; // natural ordering
////			return this.itemNm.compareTo(o.itemNm);//String클래스의 compareTo함수
//			// itemId 우선 비교하는데 같은 값이면 itemNm 비교
//			// itemId 기준으로 먼저 비교
//		    if (this.itemId != o.itemId) {
//		        return this.itemId - o.itemId; // 오름차순
//		    }
//		    // itemId가 같다면 itemNm을 비교
//		    return this.itemNm.compareTo(o.itemNm); // 사전순 정렬
//			
//		}
	
	static class Item{
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
	}
		
	
}
