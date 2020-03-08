package 배열;

public class 이차원배열 {

	public static void main(String[] args) {
		
		int[][] ar = new int[3][4];
		
		System.out.println("-----주소값과 길이-----");
		System.out.println("ar : " + ar); // 레퍼런스 변수가 가리키는 주소값.
		System.out.println("ar.length : " + ar.length);
		
		for(int i = 0; i < ar.length; i++) {
			System.out.print("ar[" + i + "] : " + ar[i] + " // ");
			System.out.println("ar[" + i + "].length : " + ar[i].length);
		} // 2차원배열의 각 행이 가리키는 주소값.
		
		System.out.println("\n-----2차원 배열의 초기화 값-----");
		
		for(int i = 0; i < ar.length; i++) {
			for(int j = 0; j < ar[i].length; j++) {
				System.out.println("ar[" + i + "][" + j + "] : " + ar[i][j]);
			}
			System.out.println();
		} // 2차원배열의 각 값은 0으로 초기화.
		
		System.out.println("-----비정방형 배열-----");

//		int[][] ar2 = new int[3][];
//		ar2[0] = new int[6];
//		ar2[1] = new int[3];
//		ar2[2] = new int[4];
//		int[][] ar2 = {{1,2,3,4,5,6}, {10, 20, 30}, {100, 200, 300, 400}};
		
		int[][] ar2 = new int[3][];
		ar2[0] = new int[]{1,2,3,4,5,6};
		ar2[1] = new int[]{10, 20, 30};
		ar2[2] = new int[]{100, 200, 300, 400};
		
		for(int i = 0; i < ar2.length; i++) {
			for(int j = 0; j < ar2[i].length; j++) {
			//	System.out.printf("ar2[%d][%d] : %d\n", i, j, ar2[i][j]);
				System.out.print(ar2[i][j] + "\t");
			}
			System.out.println();
		}
		
		System.out.println("-----------------------------------------------");
	
		for(int i = 0; i < ar2.length; i++) {
			for(int num : ar2[i]) {
				System.out.print(num + "\t");
			}
			System.out.println();
		}
		
		System.out.println("-----------------------------------------------");
		for(int[] arr : ar2) {
			for(int num : arr) {
				System.out.print(num + "\t");
			}
			System.out.println();
		}
	}
}