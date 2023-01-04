package Insentive;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.TreeSet;

public class InsentiveViewApp {
	private static final String INSENTIVE_SER = "inserntive.ser";
	
	public static void main(String[] args) {
		conductDeserializing();
	}

	private static void conductDeserializing() {
		try {
			FileInputStream fis = new FileInputStream(INSENTIVE_SER);
			BufferedInputStream bis = new BufferedInputStream(fis);
			ObjectInputStream in = new ObjectInputStream(bis);

			TreeSet<InsentiveVO> set = new TreeSet<>();
			
			System.out.println("*** 직원별 인센티브 정보를 금액별로 출력합니다.***\n");
			
			for(int i=0; i<5; i++) {
				System.out.println(in.readObject());
			}
			
			in.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
