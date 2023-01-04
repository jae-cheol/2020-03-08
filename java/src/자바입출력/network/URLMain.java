package 자바입출력.network;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class URLMain {

	public static void main(String[] args) {
		
		try {
			URL urlObj = new URL("http://www.naver.com");
//			URL urlObj = new URL("https://search.naver.com:80/search.naver?where=nexearch&query=JAVA&sm=top_hty&fbm=0&ie=utf8");
			
			System.out.println("프로토콜 : " + urlObj.getProtocol());
			System.out.println("호스트네임 : " + urlObj.getHost());
			System.out.println("포트 : " + urlObj.getPort());
			System.out.println("경로 : " + urlObj.getPath());
			System.out.println("쿼리 : " + urlObj.getQuery());
			
			System.out.println("--------------------------------------------");
			
			InputStream is = urlObj.openStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			
			while(true) {
				int c = isr.read();
				if(c == -1) break;
				System.out.print((char)c);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}










