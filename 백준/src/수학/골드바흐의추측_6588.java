package ¼öÇĞ;

import java.util.ArrayList;
import java.util.Scanner;

public class °ñµå¹ÙÈåÀÇÃßÃø_6588 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> n = new ArrayList<Integer>();
		int num = 0;
		while(true) {
			num = sc.nextInt();
			if(num == 0) {
				break;
			}
			n.add(num);
		}
		
		int[][] result = new int[n.size()][2];
		for(int k=0; k<n.size(); k++) {
			if(n.get(k)%2 != 0
			|| n.get(k) < 6
			|| n.get(k) > 100000) {
				return;
			}
			
			ArrayList<Boolean> primeList = new ArrayList<Boolean>(n.get(k)+1);
			primeList.add(false);
			primeList.add(false);
			for(int i=2; i<=n.get(k); i++) {
				primeList.add(i, true);
			}
			
			for(int i=2; i<=Math.sqrt(n.get(k)); i++) {
				if(primeList.get(i)) {
					for(int j=i*i; j<=n.get(k); j+=i) {
						primeList.set(j, false);
					}
				}
			}
			
			ArrayList<Integer> p = new ArrayList<Integer>();
			for(int i=0; i<primeList.size(); i++) {
				if(primeList.get(i)) {
					p.add(i);
				}
			}
			
			for(int i=0; i<p.size(); i++) {
				for(int j=1; j<p.size(); j++) {
					if(p.get(i) + p.get(j) == n.get(k)) {
						result[k][0] = p.get(j);
						result[k][1] = p.get(i);
					}
				}
			}
		}
		
		for(int k=0; k<n.size(); k++) {
			if(result[k][0] + result[k][1] == n.get(k)) {
				System.out.println(n.get(k)+" = "+result[k][0]+" + "+result[k][1]);
			} else {
				System.out.println("Goldbach's conjecture is wrong");
			}
		}

	}

}
