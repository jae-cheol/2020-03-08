package HW10;

import java.io.File;

public class FileSearch {
	
	void folderinfo() {
		File dirObj = new File("iotest");
		if(dirObj.exists())
			System.out.println("-------------------------------------");
			System.out.println("\t" + dirObj.getName() + "����");
			System.out.println("-------------------------------------");
			System.out.println("�̸�\t\t����\tũ��\t������������¥");
			System.out.println("-------------------------------------");
			
	}
}
