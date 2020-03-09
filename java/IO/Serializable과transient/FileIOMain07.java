package Serializable과transient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import kr.co.bit.util.FileClose;

public class FileIOMain07 {

	public static void write() {

		UserInfo user = new UserInfo("홍길동", 25, "서울시 서초구");

		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter("iotest/userInfo.txt");
			bw = new BufferedWriter(fw);
			
			String data = user.getName() + ":" + user.getAge() + ":" + user.getAddr();
			
			bw.write(data);
			bw.newLine();
			
			System.out.println("userInfo.txt에 저장을 완료하였습니다.");
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
			
			System.out.println("파일 로드를 완료하였습니다.");
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
