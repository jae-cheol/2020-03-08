package Serializable��transient;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import kr.co.bit.util.FileClose;

public class FileIOMain09 {

	public static void write() {
		UserVO user = new UserVO("ȫ�浿", 25, "010-1111-2222", "����� ���ʱ�");
		UserVO user2 = new UserVO("��浿", 30, "010-3111-2262", "��⵵ ������");
		UserVO user3 = new UserVO("�ѱ浿", 23, "010-1411-2522", "����� ���۱�");

		List<UserVO> list = new ArrayList<>();
		list.add(user);
		list.add(user2);
		list.add(user3);

		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			fos = new FileOutputStream("iotest/userList.txt");
			oos = new ObjectOutputStream(fos);

			oos.writeObject(list); // list ��ü�� ����. list�� �̹� Serializable �ް� ����.

			System.out.println("userList.txt�� �����Ͽ����ϴ�.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			FileClose.close(fos, oos);
		}
	}

	public static void read() {
		// LinkedList�� �ٲ��� ������ ��ġ�� �ʱ����� List�� ��.
		/*Array*/List<UserVO> list = null;

		FileInputStream fis = null;
		ObjectInputStream ois = null;

		try {
			fis = new FileInputStream("iotest/userList.txt"); // �о����.
			ois = new ObjectInputStream(fis);
			list = (ArrayList<UserVO>) ois.readObject();

			System.out.println("��ü �б⸦ �Ϸ��Ͽ����ϴ�.");

			for (UserVO user : list) {
				System.out.println(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			FileClose.close(fis, ois);
		}
	}

	public static void readObject() {
		/*Array*/List<UserVO> list = null;
		try (
				// ��ü�� ����� �ڵ����� close() �޼ҵ带 ȣ���� �� �ִ� ��ü �����ϴ� ����...
				// v1.7 ���Ŀ��� try() ���·� ���� close()���� �ʿ䰡 ����.
				FileInputStream fis = new FileInputStream("iotest/userList.txt");
				ObjectInputStream ois = new ObjectInputStream(fis);) {
			list = (ArrayList<UserVO>) ois.readObject();

			System.out.println("userList.txt���� ��ü�бⰡ �Ϸ�Ǿ����ϴ�...");
			for (UserVO user : list) {
				System.out.println(user);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		readObject();	// v1.7 ���� try() ���� -- finally ������ ����.
		// read();
//		 write();
	}
}
