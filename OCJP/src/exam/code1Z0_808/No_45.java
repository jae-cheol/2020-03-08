package exam.code1Z0_808;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No_45 {

	public static void main(String[] args) {
		String[] arr = {"Hi", "How", "Are", "You"};
		System.out.println(Arrays.asList(arr));
		List<String> arrList = new ArrayList<>(Arrays.asList(arr));
		System.out.println(arrList.size());
		for(int i=0; i<arrList.size(); i++) {
			System.out.println(i + "/" + arrList.size());
			if(arrList.removeIf(s -> s.length() <= 2)) {
	//			Predicate<String> u = (String t) -> (t.length() <= 2);
//				Predicate<String> u = s -> s.length() <= 2;
				System.out.println("lamda o");
	//			System.out.println(arrList.get(s));
			} else {
				System.out.println("lamda x");			
			}
		}
	}
}
