package basic;

public class Star2 {

	public static void main(String[] args) {
		int N = 7;
		
		for (int i = 0; i < N / 2 + 1; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < N - 2 * i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = N / 2 - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < N - 2 * i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
	}

}
/*
*******
 *****
  ***
   *
  ***
 *****
*******
 */

