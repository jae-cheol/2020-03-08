package IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import kr.co.bit.util.FileClose;

public class ����_����_����_����Ʈ {
	public static void main(String[] args) {
		FileReader fr = null;
		FileWriter fw = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		PrintWriter pw = null;
		// String�� ���ʹ� �ȵ�.
		try {
			fr = new FileReader("iotest/FileIOMain03.java");
			 // ���� ��ü�� ���ڿ��� ����Ű�� ���ϰ� ����� ���� ��Ʈ���� ����. (������ ���� ��� �� ������ ����.)
			fw = new FileWriter("iotest/FileIOMain03_1.java.txt");
			br = new BufferedReader(fr);
			bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw);
			while(true) {
				String str = br.readLine();
				if(str == null) break;
//				bw.write(str);
//				bw.newLine();
//				bw.flush();
				pw.println(str);
				pw.flush(); // ���۰� �� ä������ ���� ���¿��� ���ۿ� �ִ� �����͸� ��� ��½�Ű���� �Ҷ�.
			}
			System.out.println("���� ���縦 �Ϸ��Ͽ����ϴ�.");
		} catch(Exception e) {e.printStackTrace();
		} finally { // ��Ʈ���� �������� ������ �����ϰ� ����.
			FileClose.close(pw);
			FileClose.close(br, fr);
			FileClose.close(bw, fw);
		}
	}
}