package kr.co.bit.board;
/*
 * MVC패턴
 * 
 * Date
 * Access
 * Object
 * 실제 기능을 저장하거나 처리할 수 있는 클래스.
 * 
 * Value
 * Object
 * DB에 저장하는 기본 단위. , 테이블의 컬럼과 매핑. , VO단위로 이동을 함.(= D. Terminal. O)
 * 
 * 팩토리패턴 , 싱글톤패턴
 * 객체 하나를 공유하도록.
 * 
 */
import kr.co.bit.board.ui.BoardUI;

public class BoardMain {

    public static void main(String[] args){
    	
    	try {
    		new BoardUI().execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

}
