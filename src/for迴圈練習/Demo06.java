package for迴圈練習;

public class Demo06 {

	public static void main(String[] args) {
		// 利用迴圈輸出下列圖形
		//  *
		// * *
		//* * *
		// * *
		//  *		

		String t1 = "*";
		String t2 = "";
		for (int r = 0; r < 5; r++) {
			if (r < 3) {
				for (int c = 3; c > r + 1; c--) {
					System.out.print(" ");
				}
				System.out.println(t1);
				t1 += " *";
			} else {
				System.out.print(t2);
				for (int c = 0; c < 5 - r; c++) {
					System.out.print(" *");
				}
				System.out.println();
				t2 += " ";
			}
		}
	}
}
