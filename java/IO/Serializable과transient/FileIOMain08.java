package Serializable��transient;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import kr.co.bit.util.FileClose;

public class FileIOMain08 {

	public static void write() {
		
		UserInfo user = new UserInfo("ȫ�浿", 25, "����� ���ʱ�");
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			fos = new FileOutputStream("iotest/object_transient.txt");
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(user);	// ��ü ����ȭ(������Ƽ�� Ÿ���� �ʿ����)
			
			System.out.println("object.txt�� ������ �Ϸ��Ͽ����ϴ�.");
			
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
			
			UserInfo user = (UserInfo)ois.readObject();	// ��ü ����ȭ(������Ƽ�� Ÿ���� �ʿ����)
			
			System.out.println("���Ͽ��� ��ü �б⸦ �Ϸ��Ͽ����ϴ�.");
			System.out.println("�̸� : " + user.getName());
			System.out.println("���� : " + user.getAge());
			System.out.println("�ּ� : " + user.getAddr());
			
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









