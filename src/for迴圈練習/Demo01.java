package for迴圈練習;

public class Demo01 {

	public static void main(String[] args) {
		// 利用迴圈輸出下列圖形
		// *****
		// ****
		// ***
		// **
		// *

		for (int r = 5; r > 0; r--) {
			for (int c = 0; c < r; c++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
