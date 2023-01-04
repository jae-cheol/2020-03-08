package LinkedList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class 에디터_1406 {

	public static void main(String[] args) throws IOException {
		InputStream is = System.in; // 바이트
		InputStreamReader isr = new InputStreamReader(is);// 캐릭터
		BufferedReader br = new BufferedReader(isr); // 스트링
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 1. 초기에 편집기에 입력되어 있는 문자열(길이N , 영어 소문자 , 길이는 10만을 넘지 않는다.)
		String str = br.readLine();

		List<String> list = new LinkedList<>();
		for(int i=0; i<str.length(); i++) {
			list.add(String.valueOf(str.charAt(i)));
		}
		ListIterator<String> iter = list.listIterator();
		//처음 커서는 문장의 맨 뒤에 있어야하기 때문에 커서를 맨뒤로 이동시켜줌 (ex. abc|)
		while(iter.hasNext()) {
			iter.next();
		}

		// 2. 입력할 명령어의 개수 M(1<=M<=50만)
		int m = Integer.parseInt(br.readLine()); // 명령의 수

		// 3. M개의 줄에 걸쳐 입력할 명령어가 순서대로 주어진다.
		for (int i = 0; i < m; i++) {
			String s = br.readLine();

			// 3-1. 커서를 왼쪽으로 한 칸 옮김 (커서가 문장의 맨 앞이면 무시됨)
			if (s.startsWith("L")) {
				if(iter.hasPrevious()) {
					iter.previous();
				}
			}
			// 3-2. 커서를 오른쪽으로 한 칸 옮김 (커서가 문장의 맨 뒤이면 무시됨)
			else if (s.startsWith("D")) {
				if(iter.hasNext()) {
					iter.next();
				}
			}
			// 3-3. 커서 왼쪽에 있는 문자를 삭제함 (커서가 문장의 맨 앞이면 무시됨)
			// 삭제로 인해 커서는 한 칸 왼쪽으로 이동한 것처럼 나타나지만, 실제로 커서의 오른쪽에 있던 문자는 그대로임
			else if (s.startsWith("B")) {
				//remove()는 next()나 previous()에 의해 반환된 가장 마지막 요소를 리스트에서 제거함
				if(iter.hasPrevious()) {
					iter.previous();
					iter.remove();
				}
			}
			// 3-4. $라는 문자를 커서 왼쪽에 추가함
			else if (s.startsWith("P")) {
				String ss = s.substring(2);
				iter.add(ss);
			}
		}
		
		// iterator로 수정했는데 list에도 적용이 되고 있으므로 call by reference이다.
		for(String chr : list) {
			bw.write(chr);
		}
		
		bw.flush();
		bw.close(); 
	}
}