package ����;

import java.util.Random;

/**
 * �ζǿ� ���õ� ���� ����� �����մϴ�.
 * @author ȫ�浿
 *
 */

public class LottoUtil {

	/**
	 * ������ �ζ�Ȯ���� �����մϴ�.
	 * @return �ζ�Ȯ��
	 */
	public static int todayProbalility() {
		return new Random().nextInt(100) + 1;
	}
}
