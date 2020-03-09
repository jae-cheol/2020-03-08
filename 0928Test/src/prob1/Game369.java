package prob1;

public class Game369 {
	public static void main(String[] args) {
		for (int j = 1; j <= 999; j++) {
			String number = String.valueOf(j);
			int length = number.length();
			int cnt = 0;
			for (int i = 0; i < length; i++) {
				char c = number.charAt(i);
				if(c == '3' || c == '6' || c == '9') {
					cnt++;
				}
			}
			if(cnt == 1) {
				System.out.println(j + "¦");
			} else if(cnt == 2) {
				System.out.println(j + "¦¦");
			} else if(cnt == 3) {
				System.out.println(j + "¦¦¦");
			}
		}
	}
}
