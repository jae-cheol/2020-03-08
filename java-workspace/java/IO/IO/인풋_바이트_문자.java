package IO;

import java.io.InputStream;
import java.io.InputStreamReader;
/*
 * System.in			: Ű���� �Է�.
 * InputStream			: ����Ʈ ���·� �Է��� ����.
 * InputStreamReader	: ���ڷ� �Է��� ����.
 * 
 * read(byte[] b) �޼ҵ�� �Ѳ����� ���ϴ� ���� ����.
 */
public class ��ǲ_����Ʈ_���� {
	public static void main(String[] args) {
		System.out.println("�Է��� �Ͻÿ�. ����� ctrl+z�� �Է��Ͻÿ�");
		InputStream is = System.in;
		InputStreamReader isr = new InputStreamReader(is);
		try {
			char[] chars = new char[100]; // �迭�� ũ�⸸ŭ�� �о� ����.
			while(true) {
				int c = isr.read(chars); // �Էµ� Ű�� ���� ���� read()�� ����.
				// int c = is.read(); // �� ����Ʈ�� �о����. - 0~255���� ���.
				if(c == -1) break;
				System.out.println(chars);
				// System.out.print((char)c);
			}
		} catch (Exception e) {e.printStackTrace();}
	}
}