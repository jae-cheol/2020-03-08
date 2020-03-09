package IO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
/*
 * Data(In/Out)putStream		: ����Ʈ ��/��� ��Ʈ��.
 */
public class ����_����Ʈ_������ {
	static void write() {
		FileOutputStream fos = null;
		DataOutputStream dos = null; // �ڹ� �⺻ �ڷ��� �����͸� ��/��� �� �� ����.
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
			System.out.println("������ �Ϸ�Ǿ����ϴ�.");
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
		System.out.println("���� �б⸦ �Ϸ�...");
		System.out.println("1 : " + c);
		System.out.println("2 : " + c2);
		System.out.println("3 : " + num);
		System.out.println("4 : " + num2);
		// ���� �̷��� �Ⱦ� v1.7�� ���鼭 �޶���.
		dis.close();
		fis.close();
	}
	
	public static void main(String[] args) {
		try { read();
		} catch (Exception e) {e.printStackTrace();}
//		 write();
	}
}