package IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
// Dog.png -> Dog3.png ����
public class ����_����Ʈ_���� {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			fis = new FileInputStream("iotest/dog.png"); // �ش� ����� ���Ϸκ��� ���̳ʸ� ���� �״�� �д� ����Ʈ ��Ʈ���� �����ϴ� �ڵ�.
			fos = new FileOutputStream("iotest/dog3.png");
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			long start = System.currentTimeMillis();
			while(true) {
				int c = bis.read(); // 1����Ʈ�� c�� �о� ����. ( --> ���� ���� ���...)
				if(c == -1) break; 
				bos.write(c); // �о���� ���� ���̳ʸ��� ����.
				bos.flush(); // ���ۿ� ����� ���� ���� �޼ҵ�.
			}
			long end = System.currentTimeMillis();
			System.out.println("����Ϸ�...");
			System.out.println("�ҿ�ð� : " + (end-start) /1000. + "��");
		} catch (Exception e) {e.printStackTrace();} 
		finally { // ������ ��Ʈ���� �� �̻� ���� ������ �ݴ� �ڵ�. �Է� ��Ʈ���� �ݰ� ���õ� �ý��� �ڿ� ����.
			try { if (bis != null) {fis.close();}
			} catch (Exception e) {e.printStackTrace();}
			try { if (bos != null) {fos.close();}
			} catch (Exception e) {e.printStackTrace();}
			try { if (fis != null) {fis.close();}
			} catch (Exception e) {e.printStackTrace();}
			try { if (fos != null) {fos.close();}
			} catch (Exception e) {e.printStackTrace();}
		}
	}
}