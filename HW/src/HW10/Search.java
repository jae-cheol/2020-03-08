package HW10;

import java.io.File;

public class Search {
	
	void folderinfo() {
		File dirObj = new File("iotest");
		if(dirObj.exists())
			System.out.println("-------------------------------------");
			System.out.println("\t" + dirObj.getName() + "정보");
			System.out.println("-------------------------------------");
			System.out.println("이름\t\t종류\t크기\t마지막수정날짜");
			System.out.println("-------------------------------------");
			String[] list = dirObj.list();
			for(String name : list) {
				System.out.println(name);
			}
	}
}
