package HW10;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

interface Constants{
	public static final int MAKENEWDIR = 1;
	public static final int RENAME = 2;
	public static final int DELETE = 3;
	public static final int TOPARENT = 4;
	public static final int TOCHILD = 5;
	public static final int PRINTCURRENTDIR = 6;
	public static final int EXIT = 7;
}

class Util{
	public static Scanner sc = new Scanner(System.in);
	public static Random ran = new Random();
}

class InputManager{
	public static int userInputManager(String string, int min, int max){
		int value = 0;
		do{
			System.out.print(string);
			try{
				value = Integer.parseInt(Util.sc.nextLine());
			}catch(NumberFormatException e){}
		}while(value < min || value > max);
		return value;
	}
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
	public static String IinputString(String banner){
		System.out.print(banner);
		return Util.sc.nextLine();
	}
	
}

class FileManager{
	private File file;
	public FileManager(File file){
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
	public void mkdir(){
		String dirName = InputManager.IinputString("���� �� ���丮 �̸� �Է� : ");
		File file = new File(this.file.getAbsolutePath() + dirName);
		if(file.mkdir()) System.out.println(dirName + "���͸� ���� �Ϸ�");
		else System.out.println(dirName + "���͸� ���� ����(�̹� �����ϴ��� Ȯ�� �ϼ���)");
	}
	
	public void fileReName(){
		String dirName = InputManager.IinputString("��� ���� �Է� : ");
		File file = new File(this.file.getAbsolutePath() + dirName);
		if(!file.exists()){
			System.out.println("�������� �ʴ� �����Դϴ�.");
			return;
		}
		String newName = InputManager.IinputString("���� �� ���ϸ� �Է� : ");
		if(file.renameTo(new File(this.file.getAbsolutePath() + newName))) System.out.println("���ϸ� ���� ����");
		else System.out.println("���ϸ� ���� ����");
	}
	public void deleteFile(){
		String fileName = InputManager.IinputString("���� �� ���� �Է� : ");
		File file = new File(this.file.getAbsolutePath()+fileName);
		if(!file.exists()){
			System.out.println("�������� �ʴ� �����Դϴ�.");
			return;
		}
		if(file.delete()) System.out.println(fileName + " ���� ���� ����");
		else System.out.println("���� ���� ����");
	}
	
	public void toParent(){
		if(this.file.getParentFile() == null){
			System.out.println("���� ������ �ֻ��� ���� �Դϴ�.");
			return;
		}
		this.file = this.file.getParentFile();
		this.printFileInfo();
	}
	
	public void printCurrentDir(){ this.printFileInfo();}
	
	public void toChild(){
		String fileName = InputManager.IinputString("�̵� �� ���� ���� �Է� : ");
		File file = new File(this.file.getAbsolutePath()+fileName);
		if(!file.exists()){
			System.out.println("�������� �ʴ� �����Դϴ�.");
			return;
		}
		if(!file.isDirectory()) System.out.println(fileName + " ������ ���͸� ������ �ƴմϴ�.");
		this.file = file;
		this.printFileInfo();
	}
}

public class FileMain {
	public static void main(String[] args){
		File file = InputManager.fileInputManager();
		FileManager fm = new FileManager(file);
		fm.printFileInfo();
		while(true){
			switch(InputManager.userInputManager("1.�� ���� ���� 2.�̸����� 3.���� 4.���� ���� �̵� 5.���������̵� 6.������͸���� 7.����\n >> ", 1, 7)){
			case Constants.MAKENEWDIR :
				fm.mkdir();
				break;
			case Constants.RENAME :
				fm.fileReName();
				break;
			case Constants.DELETE :
				fm.deleteFile();
				break;
			case Constants.TOPARENT :
				fm.toParent();
				break;
			case Constants.TOCHILD :
				fm.toChild();
				break;
			case Constants.PRINTCURRENTDIR :
				fm.printCurrentDir();
				break;
			case Constants.EXIT :
				System.out.println("���α׷��� �����մϴ�. �������ϴ�.");
				System.exit(0);
				break;
			}
		}
		
	}
}