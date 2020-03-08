package exam.code1Z0_808;
/*
 * throws
 *  - 메소드를 정의할 때 throws 예약어를 사용하면 그 메소드를 호출하는 곳에서 예외 처리를 해야 한다.
 *  - Function throws SomeException.
 *    Function이 SomeException 예외를 던진다.
 *    Function을 사용하는 곳(호출하는 곳)을 try 블록으로 감싸준다.
 *    
 * 체크예외가 발생할 수 있는 메소드를 사용할 경우 반드시 예외를 처리하는 코드를 함께 작성해야 한다.
 *  사용할 메소드가 체크 예외를 던진다면 이를 catch문으로 잡든지, 아니면 throws를 정의해서 메소드 밖으로 던져야 한다.
 *  그렇지 않으면 컴파일 에러가 발생한다.
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
