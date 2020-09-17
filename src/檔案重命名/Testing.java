package 檔案重命名;

import java.util.Scanner;

public class Testing {

	public static void main(String[] args) {
		do {
			System.out.println("                    ----------主    選    單----------");
			System.out.println("                    |         2.清 除  畫 面         |");
			System.out.println("                    |         1.開        始         |");
			System.out.println("                    |         0.離        開         |");
			System.out.println("                    ----------------------------------");
			System.out.println();

			String path = "";
			String fileName = "";
			outer: try {
				System.out.print("請選擇(0-2):");
				Scanner sc = new Scanner(System.in);
				String choice = sc.nextLine().trim();
				switch (choice) {
				case "2":
					final String os = System.getProperty("os.name");
					if (os.contains("Windows"))
						new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
					else
						Runtime.getRuntime().exec("clear");
					break;
				case "1":
					do {
						System.out.print("請輸入檔案路徑:");
						path = sc.nextLine().trim();
						if (path.equals("")) {
							System.out.println("檔案路徑不得為空");
						}
					} while (path.equals(""));

					do {
						System.out.print("請輸入重命名字串:");
						fileName = sc.nextLine().trim();
						if (fileName.equals("")) {
							System.out.println("重命名字串不得為空");
						}
					} while (fileName.equals(""));

					FileUtil.fileRename(path, fileName);
					Thread.sleep(1000);
					break;

				case "0":
					System.out.println("結束程式..");
					return;
				default:
					break;
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
				break outer;
			} finally {
				if (FileUtil.getFileList() != null) {
					FileUtil.getFileList().close();
				}
			}
		} while (true);
	}

}
