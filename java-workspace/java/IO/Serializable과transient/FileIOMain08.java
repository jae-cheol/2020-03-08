package Serializable과transient;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import kr.co.bit.util.FileClose;

public class FileIOMain08 {

	public static void write() {
		
		UserInfo user = new UserInfo("홍길동", 25, "서울시 서초구");
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			fos = new FileOutputStream("iotest/object_transient.txt");
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(user);	// 객체 직렬화(프리미티브 타입은 필요없음)
			
			System.out.println("object.txt에 저장을 완료하였습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			FileClose.close(fos, oos);
		}
	}
	
	public static void read() {
		
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream("iotest/object_transient.txt");
//			fis = new FileInputStream("iotest/object.txt");
			ois = new ObjectInputStream(fis);
			
			UserInfo user = (UserInfo)ois.readObject();	// 객체 직렬화(프리미티브 타입은 필요없음)
			
			System.out.println("파일에서 객체 읽기를 완료하였습니다.");
			System.out.println("이름 : " + user.getName());
			System.out.println("나이 : " + user.getAge());
			System.out.println("주소 : " + user.getAddr());
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			FileClose.close(fis, ois);
		}
	}
	
	public static void main(String[] args) {
		
		read();
//		write();
	}
}









