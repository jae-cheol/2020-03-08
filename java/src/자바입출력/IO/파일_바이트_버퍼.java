package 자바입출력.IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
// Dog.png -> Dog3.png 저장
public class 파일_바이트_버퍼 {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			fis = new FileInputStream("iotest/dog.png"); // 해당 경로의 파일로부터 바이너리 값을 그대로 읽는 바이트 스트림을 생성하는 코드.
			fos = new FileOutputStream("iotest/dog3.png");
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			long start = System.currentTimeMillis();
			while(true) {
				int c = bis.read(); // 1바이트씩 c에 읽어 들임. ( --> 읽은 다음 출력...)
				if(c == -1) break; 
				bos.write(c); // 읽어들인 값을 바이너리로 저장.
				bos.flush(); // 버퍼에 저장된 것을 쓰는 메소드.
			}
			long end = System.currentTimeMillis();
			System.out.println("복사완료...");
			System.out.println("소요시간 : " + (end-start) /1000. + "초");
		} catch (Exception e) {e.printStackTrace();} 
		finally { // 생성된 스트림을 더 이상 쓰지 않을때 닫는 코드. 입력 스트림을 닫고 관련된 시스템 자원 해제.
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
