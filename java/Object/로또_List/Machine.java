package ·Î¶Ç_List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Machine {
	
	private List<Ball> balls = new ArrayList<>();
	private int cnt = 0;
	
	public Machine() {
		for(int i = 1; i <= 45; i++) {
			balls.add(new Ball(i));
		}
	}
	
	public void start() {
		Collections.shuffle(balls);
	}
	
//	void print() {
//		for(int i = 0; i < balls.size(); i++) {
//			System.out.print(getBall(i) + "  ");
//		}
//		System.out.println();
//	}
	
	public int getBall(int i) {
		return  balls.get(i).getNum();
	}
	
	public int getBall() {
		return  balls.get(cnt++).getNum();
	}
}







