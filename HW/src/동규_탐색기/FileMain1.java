package ����_Ž����;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

class InputManagers{
	public static File fileInputManager(){
		File file;
		while(true){
			System.out.print("�ʱ� ���� ��� �Է� : ");
			String initPath = Util.sc.nextLine();
			file = new File(initPath);
			if(!file.exists()){
				System.out.println("������ �������� �ʽ��ϴ�.");
				continue;
			}
			if(!file.isDirectory()){ 
				System.out.println("���͸� ������ �ƴմϴ�.");
				continue;
			}
			break;
		}
		return file;
	}
}

class FileManagers{
	private File file;
	public FileManagers(File file){
		this.file = file;
	}
	public void printFileInfo(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm\t");
		System.out.println("=================================================");
		System.out.println("|\t������������¥\t����\tũ��\t�̸�\t|");
		System.out.println("=================================================");
		File[] files = file.listFiles();
		try{
			for(File f : files){
				System.out.print(sdf.format(new Date(f.lastModified())));
				if(f.isDirectory()) System.out.print("<DIR>\t");
				else System.out.print(f.getName().substring(f.getName().length()-4));
				System.out.printf("\t%-10d\t", f.length());
				System.out.printf("%-15s\n", f.getName());
			}
		}catch(NullPointerException e) {}
	}
}

public class FileMain1 {
	public static void main(String[] args){
		File file = InputManagers.fileInputManager();
		FileManager fm = new FileManager(file);
		fm.printFileInfo();
		
		
	}
}