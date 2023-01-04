package LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class 키로거_5397 {

	public static void main(String[] args) throws IOException {
		InputStream is = System.in; // 바이트
		InputStreamReader isr = new InputStreamReader(is); // 캐릭터
		BufferedReader br = new BufferedReader(isr); // 스트링
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int s1 = Integer.parseInt(br.readLine());

//		long startTime = System.currentTimeMillis();
//		System.out.println("시작시간 : " + startTime);
		
		for (int i = 0; i < s1; i++) {
			String s2 = br.readLine();
			List<Character> l2 = new LinkedList<>();
			ListIterator<Character> li = l2.listIterator();

			for(int j=0; j<s2.length(); j++) {
				char s3 = s2.charAt(j);
				if (s3 == '<') {
					if (li.hasPrevious()) {
						li.previous();
					}
				} else if (s3 == '>') {
					if (li.hasNext()) {
						li.next();
					}
				} else if (s3 == '-') {
					if(li.hasPrevious()) {
						li.previous();
						li.remove();
					}
				} else {
					li.add(s3);
				}
			}
//			for(char s4 : l2) {
//				bw.write(s4);
//			}
//			bw.write("\n");

            StringBuilder sb = new StringBuilder();
            for(char s : l2) {
                sb.append(s);
            }
            System.out.println(sb.toString());
		}

//	    long endTime = System.currentTimeMillis();
//	    long durationTimeSec = endTime - startTime;
//		System.out.println("종료시간 : " + startTime);
//		System.out.println("소요시간 : " + durationTimeSec);

//		bw.flush();
//		bw.close();
	}
}