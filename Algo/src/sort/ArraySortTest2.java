package sort;

import java.util.Arrays;

public class ArraySortTest2 {

	public static void main(String[] args) {
		Item[] itemArray = { new Item(5, "66"), new Item(5, "77"), new Item(2, "44"), new Item(8, "11") };
		Arrays.sort(itemArray, (o1, o2) -> o1.itemId == o2.itemId ? o1.itemNm.compareTo(o2.itemNm) : o1.itemId - o2.itemId);
		System.out.println(Arrays.toString(itemArray));
	}
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
