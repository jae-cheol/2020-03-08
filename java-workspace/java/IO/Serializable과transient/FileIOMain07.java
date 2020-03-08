package Serializable��transient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import kr.co.bit.util.FileClose;

public class FileIOMain07 {

	public static void write() {

		UserInfo user = new UserInfo("ȫ�浿", 25, "����� ���ʱ�");

		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter("iotest/userInfo.txt");
			bw = new BufferedWriter(fw);
			
			String data = user.getName() + ":" + user.getAge() + ":" + user.getAddr();
			
			bw.write(data);
			bw.newLine();
			
			System.out.println("userInfo.txt�� ������ �Ϸ��Ͽ����ϴ�.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			FileClose.close(fw, bw);
		}
	}
	
	public static void read() {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader("iotest/userInfo.txt");
			br = new BufferedReader(fr);

			String data = br.readLine();
			String[] arr = data.split(":");
			
			UserInfo user = new UserInfo();
			user.setName(arr[0]);
			user.setAge(Integer.parseInt(arr[1]));
			user.setAddr(arr[2]);
			
			System.out.println("���� �ε带 �Ϸ��Ͽ����ϴ�.");
			System.out.println("user : " + user);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			FileClose.close(fr, br);
		}
	}

	public static void main(String[] args) {
//		write();
		read();
	}
}
