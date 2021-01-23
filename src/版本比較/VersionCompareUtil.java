package 版本比較;

import java.util.Scanner;

public class VersionCompareUtil {
	private VersionCompareUtil() {
	};

	/*
	 * 比較版本大小
	 * 
	 * @param version1 版本1
	 * 
	 * @param version1 版本2
	 * 
	 * @return 0:相同
	 * 
	 * @return 1:version1大於version2
	 * 
	 * @return -1:version1小於version2
	 */
	public static int compareVersion(String version1, String version2) {
		// 情況一:新舊版本相同且長度相同
		if (version1.equals(version2)) {
			// 版本相同
			return 0;
		}

		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");
		int v1Len = v1.length;
		int v2Len = v2.length;
		int baseLen = 0;// 基礎版本號位數，取短的版本長度(取長的版本長度會超出索引邊界)
		if (v1Len > v2Len) {
			baseLen = v2Len;
		} else {
			baseLen = v1Len;
		}

		// 情況二:新舊版本不相同且長度相同
		for (int i = 0; i < baseLen; i++) {

			if (v1[i].equals(v2[i])) {
				// 新舊版本的基礎版本相同就跳過
				continue;
			} else {
				// 基礎版本號比較
				return Integer.parseInt(v1[i]) > Integer.parseInt(v2[i]) ? 1 : -1;
			}
		}

		// 情況三:因為情況二新舊版本的基礎版本都相同下觸發子版本判斷
		if (v1Len != v2Len) {
			// 基礎版本相同，再比較子版本號
			return v1Len > v2Len ? 1 : -1;
		} else {
			// 基礎版本相同，無子版本號
			return 0;
		}
	}
}
