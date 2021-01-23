package 多人寄信;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmailUtil {
	private SendEmailUtil() {

	};

	public static void simpleEmail() {
		String host = "smtp.gmail.com";
		int port = 587;
		final String username = "onlinegame710@gmail.com";
		/*
		 * 使用gmail smtp寄信: 在google帳戶中安全性設定 1. 兩步驟驗證 2. 產生應用程式密碼
		 */
		final String password = "cawqbnyewzbgmwus";

		Properties props = new Properties();
		// 發送伺服器需要身份驗證
		props.setProperty("mail.smtp.auth", "true");
		// 發送郵件協議名稱
		props.setProperty("mail.transport.protocol", "smtp");
		// 設置郵件伺服器主機名
		props.setProperty("mail.smtp.host", host);
		// 需要時使用SSL登入方式
		props.setProperty("mail.smtp.starttls.enable", "true");
		// 開啟debug調試
		props.setProperty("mail.debug", "true");

		try {
			Session session = Session.getInstance(props, new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			});

			Message msg = new MimeMessage(session);
			// 發件人
			msg.setFrom(new InternetAddress(username));
			// 主旨
			msg.setSubject("我是主題");
			// 內容
			msg.setContent("<span style='color:red'>我的文字是紅色的,想複雜自己加</span>", "text/html;charset=utf-8");
			// 多個收件人，RecipientType.TO平常發送，CC抄送，BCC是暗送（就是別的收件人看不到)
			msg.setRecipients(RecipientType.TO, InternetAddress.parse("regretyou710@gmail.com"));
			// msg.setRecipients(RecipientType.CC, InternetAddress.parse("[email
			// protected],[email protected]"));

			Transport transport = session.getTransport("smtp");
			transport.connect(host, port, username, password);
			Transport.send(msg);
			System.out.println("寄信完成");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
