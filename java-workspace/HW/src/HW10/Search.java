package HW10;

import java.io.File;

public class Search {
	
	void folderinfo() {
		File dirObj = new File("iotest");
		if(dirObj.exists())
			System.out.println("-------------------------------------");
			System.out.println("\t" + dirObj.getName() + "����");
			System.out.println("-------------------------------------");
			System.out.println("�̸�\t\t����\tũ��\t������������¥");
			System.out.println("-------------------------------------");
			String[] list = dirObj.list();
			for(String name : list) {
				System.out.println(name);
			}
	}
}
