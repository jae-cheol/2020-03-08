package 자바입출력.IO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
/*
 * Data(In/Out)putStream		: 바이트 입/출력 스트림.
 */
public class 파일_바이트_데이터 {
	static void write() {
		FileOutputStream fos = null;
		DataOutputStream dos = null; // 자바 기본 자료형 데이터를 입/출력 할 수 있음.
		try {
			fos = new FileOutputStream("iotest/writer.txt");
			dos = new DataOutputStream(fos);
			char c = 'A';
			int num = 215;
			// fis.write(c);
			dos.writeChar(c);
			dos.writeChar('B');
			dos.writeInt(num);
			dos.writeDouble(12.34);
			System.out.println("저장이 완료되었습니다.");
		} catch (Exception e) {e.printStackTrace();
		} finally {
			try { if (dos != null) {dos.close();}
			} catch (Exception e) {e.printStackTrace();}
			try { if (fos != null) {fos.close();}
			} catch (Exception e) {e.printStackTrace();}
		}
	}

	static void read() throws Exception {
		FileInputStream fis = new FileInputStream("iotest/writer.txt");
		DataInputStream dis = new DataInputStream(fis);
	
		char c = dis.readChar();
		char c2 = dis.readChar();
		int num = dis.readInt();
		double num2 = dis.readDouble();
		System.out.println("파일 읽기를 완료...");
		System.out.println("1 : " + c);
		System.out.println("2 : " + c2);
		System.out.println("3 : " + num);
		System.out.println("4 : " + num2);
		// 원래 이렇게 안씀 v1.7로 가면서 달라짐.
		dis.close();
		fis.close();
	}
	
	public static void main(String[] args) {
		try { read();
		} catch (Exception e) {e.printStackTrace();}
//		 write();
	}
}
