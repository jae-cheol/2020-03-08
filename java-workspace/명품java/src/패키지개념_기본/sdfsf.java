package 패키지개념_기본;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sdfsf {
	
	public void histogram(char c) {
		
	}
	
	public static void main(String[] args) {
		InputStreamReader rd = new InputStreamReader(System.in);
		int cnt=0;
		StringBuffer sb = null;
		
		try {
			while(true) {
				int c = rd.read(); // ctrl-z 가 입력되면 -1을 리턴한다.
				if(c == -1) // c는 입력된 키 값
					break;
				if(cnt == 0) {
					sb = new StringBuffer((char)c); // 처음에 스트링버퍼 만들어서 넣어줌.
				}
				sb.append((char)c); // 들어오는것을 다 추가해줌.
				cnt++;
			}
			String str = sb.toString(); // 전부 들어온것을 str으로 바꿔줌.
			StringTokenizer st = new StringTokenizer(str, "' ,."); // delim을 기준으로 잘라줌.
			int n = st.countTokens(); // 모든 토큰 리턴.
			for(int i=0; i<n; i++) {
				String token = st.nextToken(); // 구분자를 기준으로 자른것을 String으로 하나씩 받음.
				for(int j='a'; j<'z'; j++) {
					for(int k=0; k<token.length(); k++) {
						if(token.charAt(k) == j) {
							
						}
					}
				}
			}
		} catch(IOException e) {
			System.out.println("입력 오류 발생");
		}
	}
}
