package 자료구조;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 스택_10828 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int loop = sc.nextInt();
		int cnt = 0;
		List<Integer> stack = new ArrayList<Integer>();
		
		while(true) {
			switch(sc.next()) {
				case "push" :
					stack.add(sc.nextInt());
					break;
				case "pop" :
					try {
						System.out.println(stack.get(stack.size()-1));
						stack.remove(stack.size()-1);
					} catch(ArrayIndexOutOfBoundsException e) {
						System.out.println("-1");
					}
					break;
				case "size" :
					System.out.println(stack.size());
					break;
				case "empty" :
					if(stack.size() == 0) {
						System.out.println("1");
					} else {
						System.out.println("0");
					}
					break;
				case "top" :
					try {
						System.out.println(stack.get(stack.size()-1));
					} catch(ArrayIndexOutOfBoundsException e) {
						System.out.println("-1");
					}
					break;
				default :
					break;
			}
			cnt++;
			if(cnt == loop) {
				break;
			}
		}
	}
}
