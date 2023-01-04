package Deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class 덱_10866 {

	public static void main(String[] args) throws IOException {
		InputStream is = System.in;						// 바이트
		InputStreamReader isr = new InputStreamReader(is);// 캐릭터
		BufferedReader br = new BufferedReader(isr);	// 스트링
		int n = Integer.parseInt(br.readLine());	// 명령의 수
		
		Deque<String> d = new LinkedList<>();
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			if(s.contains("push_front")) {
				d.addFirst(s.substring(11));
			} else if(s.contains("push_back")) {
				d.addLast(s.substring(10));
			} else if(s.contains("pop_front")) {
				sb.append(d.isEmpty() ? "-1" : d.pollFirst()).append("\n");
			} else if(s.contains("pop_back")) {
				sb.append(d.isEmpty() ? "-1" : d.pollLast()).append("\n");
			} else if(s.contains("size")) {
				sb.append(d.size()).append("\n");
			} else if(s.contains("empty")) {
				sb.append(d.isEmpty() ? "1" : "0").append("\n");
			} else if(s.contains("front")) {
				sb.append(d.isEmpty() ? "-1" : d.getFirst()).append("\n");
			} else if(s.contains("back")) {
				sb.append(d.isEmpty() ? "-1" : d.getLast()).append("\n");
			}
		}

		System.out.println(sb.toString());
	}

}
