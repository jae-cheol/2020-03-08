package Serializable과transient;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import kr.co.bit.util.FileClose;

public class FileIOMain09 {

	public static void write() {
		UserVO user = new UserVO("홍길동", 25, "010-1111-2222", "서울시 서초구");
		UserVO user2 = new UserVO("고길동", 30, "010-3111-2262", "경기도 성남시");
		UserVO user3 = new UserVO("한길동", 23, "010-1411-2522", "서울시 동작구");

		List<UserVO> list = new ArrayList<>();
		list.add(user);
		list.add(user2);
		list.add(user3);

		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			fos = new FileOutputStream("iotest/userList.txt");
			oos = new ObjectOutputStream(fos);

			oos.writeObject(list); // list 자체를 저장. list는 이미 Serializable 받고 있음.

			System.out.println("userList.txt에 저장하였습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			FileClose.close(fos, oos);
		}
	}

	public static void read() {
		// LinkedList로 바껴도 영향을 끼치지 않기위해 List를 씀.
		/*Array*/List<UserVO> list = null;

		FileInputStream fis = null;
		ObjectInputStream ois = null;

		try {
			fis = new FileInputStream("iotest/userList.txt"); // 읽어오기.
			ois = new ObjectInputStream(fis);
			list = (ArrayList<UserVO>) ois.readObject();

			System.out.println("객체 읽기를 완료하였습니다.");

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
				// 객체를 사용후 자동으로 close() 메소드를 호출할 수 있는 객체 생성하는 구문...
				// v1.7 이후에서 try() 형태로 쓰면 close()해줄 필요가 없음.
				FileInputStream fis = new FileInputStream("iotest/userList.txt");
				ObjectInputStream ois = new ObjectInputStream(fis);) {
			list = (ArrayList<UserVO>) ois.readObject();

			System.out.println("userList.txt에서 객체읽기가 완료되었습니다...");
			for (UserVO user : list) {
				System.out.println(user);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		readObject();	// v1.7 이후 try() 구문 -- finally 없어진 구문.
		// read();
//		 write();
	}
}
