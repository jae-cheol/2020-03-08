package 수학;

import java.util.ArrayList;
import java.util.Scanner;

public class 서로소쌍_13412 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tot = sc.nextInt();
		int[] num = new int[tot];
		for(int i=0; i<tot; i++) {
			num[i] = sc.nextInt();
		}
		int[] cnt = new int[tot];
		ArrayList<Integer> al = new ArrayList<Integer>();
		boolean b = true;
		for(int k=0; k<tot; k++) {
			for(int i=1; i<=num[k]; i++) {
				for(int j=num[k]; j>=1; j--) {
					if(i*j == num[k]) {
						if(j >= i) {
							if(i != 1) {
								al.add(i);
							}
							for(int l=0; l<al.size(); l++) {
								if(i%al.get(l) == 0
								&& j%al.get(l) == 0) {
									b = false;
									break;
								}
							}
							if(b) {
								cnt[k]++;
							}
							b = true;
						}
					}
				}
			}
		}
		for(int k=0; k<tot; k++) {
			System.out.println(cnt[k]);
		}

	}

}
