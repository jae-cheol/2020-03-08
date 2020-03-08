package Insentive;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class InsentiveCreateApp {
	private static final String INSENTIVE_SER = "inserntive.ser";
	
	public static void main(String[] args) {
		conductSerializing();
	}
	
	public static void conductSerializing() {
		try {
			FileOutputStream fos = new FileOutputStream(INSENTIVE_SER);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream out = new ObjectOutputStream(bos);
			
			String[] arr = new String[5];
			int num = 0;
			
			InsentiveVO[] in = new InsentiveVO[5];
			
			// 파일 객체 생성
			File file = new File("D:\\eclipse-workspace\\OCJP\\inputdata.txt");
			Scanner sc = new Scanner(file);
			
			while(sc.hasNextLine()) {
				arr[num] = sc.nextLine();
				in[num] = new InsentiveVO(arr[num].split(",")[0], Integer.parseInt(arr[num].split(",")[1]));
				num++;
			}

			ArrayList list = new ArrayList<>();
			for(int i=0; i<5; i++) {
				list.add(in[i]);
			}
			for(int i=0; i<list.size(); i++) {
				out.writeObject(in[i]);
			}
			out.writeObject(list);
			out.close();
						
			System.out.println("직원들의 인센티브 정보 5건을 등록 완료하였습니다.");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
