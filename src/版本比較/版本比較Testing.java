package 版本比較;

import java.util.Scanner;

public class 版本比較Testing {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("v1:");
		String v1 = sc.nextLine();

		System.out.print("v2:");
		String v2 = sc.nextLine();

		if (VersionCompareUtil.compareVersion(v1, v2) == 1) {
			System.out.println("目前是最新版本");
		} else if (VersionCompareUtil.compareVersion(v1, v2) == 0) {
			System.out.println("版本相同");
		} else if (VersionCompareUtil.compareVersion(v1, v2) == -1) {
			System.out.println("有最新版本");
		}
	}
}
