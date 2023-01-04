package 스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class 스택_10828 {

	public static void main(String[] args) throws IOException {
		InputStream is = System.in;						// 바이트
		InputStreamReader isr = new InputStreamReader(is);// 캐릭터
		BufferedReader br = new BufferedReader(isr);	// 스트링
		int n = Integer.parseInt(br.readLine());	// 명령의 수
		Stack<Integer> stack = new Stack<Integer>();
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			int b = 0;
			if(s.contains("push")) {
				stack.push(Integer.parseInt(s.substring(5)));
			} else if(s.contains("pop")) {
				b = stack.size() > 0 ? stack.pop() : -1;
				sb.append(b).append("\n");
			} else if(s.contains("size")) {
				b = stack.size();
				sb.append(b).append("\n");
			} else if(s.contains("empty")) {
				b = stack.isEmpty() ? 1 : 0;
				sb.append(b).append("\n");
			} else if(s.contains("top")) {
				b = stack.size() > 0 ? stack.peek() : -1;
				sb.append(b).append("\n");
			}
		}
		
		System.out.println(sb);
	}

}
