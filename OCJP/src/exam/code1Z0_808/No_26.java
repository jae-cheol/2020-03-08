package exam.code1Z0_808;
/*
 * throws
 *  - �޼ҵ带 ������ �� throws ���� ����ϸ� �� �޼ҵ带 ȣ���ϴ� ������ ���� ó���� �ؾ� �Ѵ�.
 *  - Function throws SomeException.
 *    Function�� SomeException ���ܸ� ������.
 *    Function�� ����ϴ� ��(ȣ���ϴ� ��)�� try ������� �����ش�.
 *    
 * üũ���ܰ� �߻��� �� �ִ� �޼ҵ带 ����� ��� �ݵ�� ���ܸ� ó���ϴ� �ڵ带 �Բ� �ۼ��ؾ� �Ѵ�.
 *  ����� �޼ҵ尡 üũ ���ܸ� �����ٸ� �̸� catch������ �����, �ƴϸ� throws�� �����ؼ� �޼ҵ� ������ ������ �Ѵ�.
 *  �׷��� ������ ������ ������ �߻��Ѵ�.
 */
public class No_26 {
	void readCard(int cardNo) throws Exception {
		System.out.println("Reading Card");
	}
	void checkCard(int cardNo) throws RuntimeException {
		System.out.println("Checking Card");
	}
	public static void main(String[] args) {
		No_26 ex = new No_26();
		int cardNo = 12344;
		ex.checkCard(cardNo);
//		ex.readCard(cardNo);
	}

}
