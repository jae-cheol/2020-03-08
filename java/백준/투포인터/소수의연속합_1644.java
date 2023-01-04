package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 소수의연속합_1644 {

	public static void main(String[] args) throws IOException {
		// 입력
		InputStream is = System.in;						// byte
		InputStreamReader isr = new InputStreamReader(is);// character
		BufferedReader br = new BufferedReader(isr);	// String

		// 출력
		StringBuffer sb = new StringBuffer();
		
		int n = Integer.parseInt(br.readLine());	// 자연수
		int sqrt = (int)Math.sqrt(n);
		
		List<Boolean> l = new ArrayList<Boolean>();
		l.add(false);
		l.add(false);
		for(int i=2; i<=n; i++) {
			l.add(true);
		}
		for(int i=2; i<=sqrt; i++) {
			if(l.get(i)) {
				for(int j=i*i; j<=n; j+=i) {
					l.set(j, false);
				}
			}
		}
		
		List<Integer> lPrime = new ArrayList<Integer>();
		for(int i=2; i<=n; i++) {
			if(l.get(i)) {
				lPrime.add(i);
			}
		}
		int size = lPrime.size();

		int sum = 0;
		int cnt = 0;
		int pointer1 = 0;
		int pointer2 = 0;
		while(true) {
			if(n == sum) {
				cnt++;
				sum -= lPrime.get(pointer1++);
			} else if(n > sum) {
				if(pointer2 == size) break;
				sum += lPrime.get(pointer2++);
			} else if(n < sum) {
				sum -= lPrime.get(pointer1++);
			}
		}
		System.out.println(cnt);
	}
}
