import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class test {

	public static void main(String[] args) {
		
		String s2 = "1234";
		List<String> l = new ArrayList<>();
		for(int j=0; j<s2.length(); j++) {
			l.add(s2.substring(j, j+1));
		}
		System.out.println(l);
		

		System.out.println(fibonacci(3));
		System.out.println(fibonacci(4));
		System.out.println(fibonacci(5));
		System.out.println(fibonacci(6));
		System.out.println(fibonacci(7));
		System.out.println(fibonacci(8));
		System.out.println(fibonacci(9));

		List<String> list = new ArrayList<>();
		
		list.subList(0, 0);
		
		
	}
	
	public static int fibonacci(int num) {
		if(num == 0) {
			return 0;
		} else if(num == 1) {
			return 1;
		} else {
			return fibonacci(num-1) + fibonacci(num-2);
		}
	}
	
	public static void splitFunc(ArrayList<Integer> dataList) {
		if(dataList.size() <= 1) {
			return;
		}
		int medium = dataList.size() / 2;

		ArrayList<Integer> leftArr = new ArrayList<>();
		ArrayList<Integer> rightArr = new ArrayList<>();
		
		leftArr = new ArrayList<Integer>(dataList.subList(0, medium));	// 0부터 medium-1 인덱스 번호까지 해당 배열 아이템을
		rightArr = new ArrayList<Integer>(dataList.subList(medium, dataList.size()));

		System.out.println(leftArr);
		System.out.println(rightArr);
	}
}
