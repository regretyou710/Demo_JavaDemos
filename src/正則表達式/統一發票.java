package 正則表達式;

import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 統一發票 {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://invoice.etax.nat.gov.tw/");

			StringBuilder sb = new StringBuilder();
			Scanner sc = new Scanner(url.openStream());
			String data = "";
			while (sc.hasNext()) {
				sb.append(sc.next());
			}

			// 第一次正則
			Pattern p1 = Pattern.compile("獎別.*?領獎期間", Pattern.DOTALL);
			Matcher m1 = p1.matcher(sb);
			if (m1.find()) {
				data = m1.group(0);
			}

			// 第二次正則
			// p1 = Pattern.compile("class=\"t18Red\">[0-9]{8}</span>|class=\"t18Red\">.*?</span>");
			p1 = Pattern.compile("class=\"t18Red\">[0-9]{3}.*?</span>");
			m1 = p1.matcher(data);
			String number = "";
			while (m1.find()) {
				// System.out.println(m1.group(0));
				number += m1.group(0).replaceAll("class=\"t18Red\">|</span>", "");
				number += "、";
			}

			String[] nums = number.split("、");
			for (String s : nums) {
				System.out.println(s);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
