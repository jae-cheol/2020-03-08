package IO;

import java.io.FileReader;
import java.io.FileWriter;

import kr.co.bit.util.FileClose;

// FileIOMain03.java ---> FileIOMain03.java.txt ����
// �ֽܼ���� : java FileIOMain05_1   FileIOMain03.java   FileIOMain03.java.txt
public class ����_����_�������� {
	public static void main(String[] args) {
		if(args.length < 2) {
			System.out.println("������ �߸��Ǿ����ϴ�.");
			System.out.println("���� : java FileIOMain05_1  �������ϸ�  ���������ϸ�");
			System.exit(0);
		}
		FileReader fr = null;
		FileWriter fw = null;
		try {
			fr = new FileReader("iotest/" + args[0]);
			fw = new FileWriter("iotest/" + args[1]);
			while(true) {
				int c = fr.read();
				if(c==-1) break;
				fw.write(c);
				fw.flush();
			}
			System.out.println("���� ���縦 �Ϸ��Ͽ����ϴ�.");
		} catch(Exception e) {e.printStackTrace();
		} finally {FileClose.close(fr, fw);}
	}
}
