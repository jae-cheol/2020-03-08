package kr.co.bit.board;
/*
 * MVC����
 * 
 * Date
 * Access
 * Object
 * ���� ����� �����ϰų� ó���� �� �ִ� Ŭ����.
 * 
 * Value
 * Object
 * DB�� �����ϴ� �⺻ ����. , ���̺��� �÷��� ����. , VO������ �̵��� ��.(= D. Terminal. O)
 * 
 * ���丮���� , �̱�������
 * ��ü �ϳ��� �����ϵ���.
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
