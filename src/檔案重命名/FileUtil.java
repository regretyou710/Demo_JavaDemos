package 檔案重命名;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileUtil {
	private static Stream<Path> list = null;

	private FileUtil() {

	}

	// 重命名
	public static void fileRename(String path, String fileName, int num) throws IOException {
		// 檔案路徑
		Path pathStr = Paths.get(path);

		// 判斷檔案路徑是否存在
		if (Files.notExists(pathStr)) {
			throw new RuntimeException("路徑不存在");
		} else {
			// 使用Stream流將路徑底下的file進行轉換及排序
			list = Files.list(pathStr);
			List<File> fileList = list.map(p -> p.toFile())
					.sorted((p1, p2) -> Long.compare(p1.lastModified(), p2.lastModified()))
					.collect(Collectors.toList());

			if (fileList.size() != 0 && fileList != null) {
				for (int i = 0; i < fileList.size(); i++) {
					String fName = fileList.get(i).getName();
					boolean renameTo = false;

					if (fName.lastIndexOf(".") == -1) {
						// 對directory重命名
						renameTo = fileList.get(i)
								.renameTo(new File(path + "\\" + fileName + String.format("%03d", (num + i))));
					} else {
						// 對file重命名
						renameTo = fileList.get(i)
								.renameTo(new File(path + "\\" + fileName + String.format("%03d", (num + i))
										+ fName.substring(fName.lastIndexOf("."), fName.length())));
					}

					if (renameTo) {
						System.out.println(fName + "重命名成功");
					} else {
						System.out.println(fName + "重命名失敗");
					}
				}
			} else {
				throw new RuntimeException("資料夾中沒有檔案");
			}
		}
	}

	// 原名稱異動
	public static void fileNameModify(String path, int startIndex, String insertString) throws IOException {
		// 檔案路徑
		Path pathStr = Paths.get(path);

		// 判斷檔案路徑是否存在
		if (Files.notExists(pathStr)) {
			throw new RuntimeException("路徑不存在");
		} else {
			// 使用Stream流將路徑底下的file進行轉換及排序
			list = Files.list(pathStr);
			List<File> fileList = list.map(p -> p.toFile())
					.sorted((p1, p2) -> Long.compare(p1.lastModified(), p2.lastModified()))
					.collect(Collectors.toList());

			if (fileList.size() != 0 && fileList != null) {
				boolean renameTo = false;
				String originStr = "";

				for (int i = 0; i < fileList.size(); i++) {
					StringBuffer sb = null;
					String newStr = "";

					if (fileList.get(i).getName().lastIndexOf(".") == -1) {
						// 對directory名稱異動
						originStr = fileList.get(i).getName();
						sb = new StringBuffer(originStr);
						sb.insert(startIndex, insertString);
						newStr = sb.toString();
						renameTo = fileList.get(i).renameTo(new File(path + "\\" + newStr));

					} else {
						// 對file名稱異動
						originStr = fileList.get(i).getName().substring(0, fileList.get(i).getName().lastIndexOf("."));
						sb = new StringBuffer(originStr);
						sb.insert(startIndex, insertString);
						newStr = sb.toString();

						renameTo = fileList.get(i)
								.renameTo(new File(path + "\\" + newStr
										+ fileList.get(i).getName().substring(
												fileList.get(i).getName().lastIndexOf("."),
												fileList.get(i).getName().length())));
					}

					if (renameTo) {
						System.out.println(originStr + "重命名成功");
					} else {
						System.out.println(originStr + "重命名失敗");
					}
				}
			} else {
				throw new RuntimeException("資料夾中沒有檔案");
			}

		}

	}

	// 用來關閉Stream流
	public static Stream<Path> getFileList() {
		return list;
	}
}
