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
			String number = "";
			String startIndex = "";
			String insertString = "";
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
						try {
							System.out.println("                    ----------子    選    單----------");
							System.out.println("                    |         2.插 入  字 串         |");
							System.out.println("                    |         1.重 新  命 名         |");
							System.out.println("                    |         0.回 主  選 單         |");
							System.out.println("                    ----------------------------------");
							System.out.print("請選擇(0-2):");
							choice = sc.nextLine().trim();

							if (choice.equals("0")) {
								break;
							}

							do {
								System.out.print("請輸入檔案路徑:");
								path = sc.nextLine().trim();
								if (path.equals("")) {
									System.out.println("檔案路徑不得為空");
								}
							} while (path.equals(""));

							if (choice.equals("1")) {
								do {
									System.out.print("請輸入重命名字串:");
									fileName = sc.nextLine().trim();
									if (fileName.equals("")) {
										System.out.println("重命名字串不得為空");
									}
								} while (fileName.equals(""));

								do {
									System.out.print("請輸入序列號:");
									number = sc.nextLine().trim();
									if (number.equals("")) {
										System.out.println("序列號不得為空");
									}
								} while (number.equals(""));

								FileUtil.fileRename(path, fileName, Integer.parseInt(number));
								Thread.sleep(1000);
							} else if (choice.equals("2")) {
								System.out.print("請輸入插入字串位置索引:");
								startIndex = sc.nextLine().trim();
								System.out.print("請輸入插入字串:");
								insertString = sc.nextLine().trim();
								FileUtil.fileNameModify(path, Integer.parseInt(startIndex), insertString);
								Thread.sleep(1000);
							}
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
					} while (true);
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
