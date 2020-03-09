package prob5;

public class Sort {
	public static void main(String[] arg) {
		int array[] = { 5, 9, 3, 8, 60, 20, 1 };
		int temp = 0;
		int count = array.length;
		System.out.println("Before sort.");

		for (int i = 0; i < count; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
		for (int j = 6; j > 0; j--) {
			for (int i = 0; i < count - 1; i++) {
				if (array[i + 1] < array[i]) {
					temp = array[i];
					array[i] = array[i + 1];
//					System.out.print(array[i] + " ");
					array[i + 1] = temp;
				} else {
//					System.out.print(array[i] + " ");
				}
			}
//			System.out.println();
		}
		// for (int j = 0; j < count--; j++) {
		// if (array[i] > array[i + 1]) {
		// temp = array[i];
		// array[i] = array[i + 1];
		// array[i + 1] = temp;
		// }
		// }

		//
		// 버블정렬 (내림차순)이 적용된 코드를 여기에 작성합니다.
		// 메소드로 정의해도 괜찮습니다.
		//
		//

		System.out.println("\nAfter Sort.");

		for (int i = 0; i < count; i++) {
			System.out.print(array[i] + " ");
		}
	}
}
