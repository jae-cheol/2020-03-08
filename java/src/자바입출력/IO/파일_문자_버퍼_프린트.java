package 자바입출력.IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import kr.co.bit.util.FileClose;

public class 파일_문자_버퍼_프린트 {
	public static void main(String[] args) {
		FileReader fr = null;
		FileWriter fw = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		PrintWriter pw = null;
		// String에 엔터는 안들어감.
		try {
			fr = new FileReader("iotest/FileIOMain03.java");
			 // 파일 객체나 문자열이 가리키는 파일과 연결된 문자 스트림을 생성. (파일이 없는 경우 빈 파일을 생성.)
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
				pw.flush(); // 버퍼가 다 채워지지 않은 상태에서 버퍼에 있는 데이터를 모두 출력시키고자 할때.
			}
			System.out.println("파일 복사를 완료하였습니다.");
		} catch(Exception e) {e.printStackTrace();
		} finally { // 스트림을 닫을때는 파일을 저장하고 닫음.
			FileClose.close(pw);
			FileClose.close(br, fr);
			FileClose.close(bw, fw);
		}
	}
}
