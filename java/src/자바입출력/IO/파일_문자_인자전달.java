package 자바입출력.IO;

import java.io.FileReader;
import java.io.FileWriter;

import kr.co.bit.util.FileClose;

// FileIOMain03.java ---> FileIOMain03.java.txt 복사
// 콘솔실행시 : java FileIOMain05_1   FileIOMain03.java   FileIOMain03.java.txt
public class 파일_문자_인자전달 {
	public static void main(String[] args) {
		if(args.length < 2) {
			System.out.println("사용법이 잘못되었습니다.");
			System.out.println("사용법 : java FileIOMain05_1  원본파일명  복사할파일명");
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
			System.out.println("파일 복사를 완료하였습니다.");
		} catch(Exception e) {e.printStackTrace();
		} finally {FileClose.close(fr, fw);}
	}
}
