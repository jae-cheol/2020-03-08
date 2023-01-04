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
			System.out.print("초기 폴더 경로 입력 : ");
			String initPath = Util.sc.nextLine();
			file = new File(initPath);
			if(!file.exists()){
				System.out.println("폴더가 존재하지 않습니다.");
				continue;
			}
			if(!file.isDirectory()){ 
				System.out.println("디렉터리 파일이 아닙니다.");
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
		System.out.println("|\t마지막수정날짜\t형식\t크기\t이름\t|");
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
		String dirName = InputManager.IinputString("생성 할 디렉토리 이름 입력 : ");
		File file = new File(this.file.getAbsolutePath() + dirName);
		if(file.mkdir()) System.out.println(dirName + "디렉터리 생성 완료");
		else System.out.println(dirName + "디렉터리 생성 실패(이미 존재하는지 확인 하세요)");
	}
	
	public void fileReName(){
		String dirName = InputManager.IinputString("대상 파일 입력 : ");
		File file = new File(this.file.getAbsolutePath() + dirName);
		if(!file.exists()){
			System.out.println("존재하지 않는 파일입니다.");
			return;
		}
		String newName = InputManager.IinputString("변경 할 파일명 입력 : ");
		if(file.renameTo(new File(this.file.getAbsolutePath() + newName))) System.out.println("파일명 변경 성공");
		else System.out.println("파일명 변경 실패");
	}
	public void deleteFile(){
		String fileName = InputManager.IinputString("삭제 할 파일 입력 : ");
		File file = new File(this.file.getAbsolutePath()+fileName);
		if(!file.exists()){
			System.out.println("존재하지 않는 파일입니다.");
			return;
		}
		if(file.delete()) System.out.println(fileName + " 파일 삭제 성공");
		else System.out.println("파일 삭제 실패");
	}
	
	public void toParent(){
		if(this.file.getParentFile() == null){
			System.out.println("현재 폴더는 최상위 폴더 입니다.");
			return;
		}
		this.file = this.file.getParentFile();
		this.printFileInfo();
	}
	
	public void printCurrentDir(){ this.printFileInfo();}
	
	public void toChild(){
		String fileName = InputManager.IinputString("이동 할 하위 파일 입력 : ");
		File file = new File(this.file.getAbsolutePath()+fileName);
		if(!file.exists()){
			System.out.println("존재하지 않는 파일입니다.");
			return;
		}
		if(!file.isDirectory()) System.out.println(fileName + " 파일은 디렉터리 파일이 아닙니다.");
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
			switch(InputManager.userInputManager("1.새 폴더 생성 2.이름변경 3.삭제 4.상위 폴더 이동 5.하위폴더이동 6.현재디렉터리출력 7.종료\n >> ", 1, 7)){
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
				System.out.println("프로그램을 종료합니다. 감사힙니다.");
				System.exit(0);
				break;
			}
		}
		
	}
}
