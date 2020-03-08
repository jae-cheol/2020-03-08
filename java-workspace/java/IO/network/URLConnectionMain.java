package network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

import kr.co.bit.util.FileClose;

public class URLConnectionMain {

	// http://www.naver.com에 내용을 naver.html에 저장
	public static void main(String[] args) {
	
		try(
				FileOutputStream fos = new FileOutputStream("naver.html");
				OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
				BufferedWriter bw = new BufferedWriter(osw);
		) {
			URL urlObj = new URL("http://www.naver.com");
			URLConnection uc = urlObj.openConnection();
			
			InputStream is = uc.getInputStream();	// close가 없음.
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			BufferedReader br = new BufferedReader(isr);
			
			while(true) {
				String str = br.readLine();
				if(str == null) break;
				bw.write(str);
				bw.newLine();
			}
			bw.flush();
			
			
//			while(true) {
//				int c = isr.read();
//				if(c == -1) break;
//				osw.write(c);
//			}
			
			System.out.println("naver.html에 저장을 완료하였습니다.");
		
			FileClose.close(isr);
			FileClose.close(br);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}









