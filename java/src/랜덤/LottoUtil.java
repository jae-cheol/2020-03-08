package 랜덤;

import java.util.Random;

/**
 * 로또와 관련된 편리한 기능을 제공합니다.
 * @author 홍길동
 *
 */

public class LottoUtil {

	/**
	 * 오늘의 로또확률을 제공합니다.
	 * @return 로또확률
	 */
	public static int todayProbalility() {
		return new Random().nextInt(100) + 1;
	}
}
