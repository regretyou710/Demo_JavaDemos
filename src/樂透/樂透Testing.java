package 樂透;

import java.util.Random;

public class 樂透Testing {

	public static void main(String[] args) {
		Ball[] box = new Ball[49];
		for (int i = 0; i < box.length; i++) {
			Ball ball = new Ball(i + 1);
			box[i] = ball;
		}

		Random random = new Random();
		for (int i = 0; i < 7; i++) {
			int r = random.nextInt(box.length);
			if (box[r].getNumber() != -1) {
				System.out.print(box[r].getNumber()+" ");
				Ball ball = new Ball(-1);
				box[r] = ball;				
			} else {
				i--;
			}
		}
	}

}
