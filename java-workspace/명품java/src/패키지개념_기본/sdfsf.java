package ��Ű������_�⺻;

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
				int c = rd.read(); // ctrl-z �� �ԷµǸ� -1�� �����Ѵ�.
				if(c == -1) // c�� �Էµ� Ű ��
					break;
				if(cnt == 0) {
					sb = new StringBuffer((char)c); // ó���� ��Ʈ������ ���� �־���.
				}
				sb.append((char)c); // �����°��� �� �߰�����.
				cnt++;
			}
			String str = sb.toString(); // ���� ���°��� str���� �ٲ���.
			StringTokenizer st = new StringTokenizer(str, "' ,."); // delim�� �������� �߶���.
			int n = st.countTokens(); // ��� ��ū ����.
			for(int i=0; i<n; i++) {
				String token = st.nextToken(); // �����ڸ� �������� �ڸ����� String���� �ϳ��� ����.
				for(int j='a'; j<'z'; j++) {
					for(int k=0; k<token.length(); k++) {
						if(token.charAt(k) == j) {
							
						}
					}
				}
			}
		} catch(IOException e) {
			System.out.println("�Է� ���� �߻�");
		}
	}
}
