package IO;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
/*
 * isFile()			: 파일타입인지 아닌지..
 * isDirectory()	: 디렉토리인지 아닌지...
 * getPath()		: 해당 경로..
 * list()			: 디렉토리일경우) 해당 디렉토리의 모든파일과 서브디렉토리들.
 * length()			: 파일의 크기(바이트)
 * lastModified()	: 마지막 수정시간.
 * exists()			: 파일이 존재하는지...
 * mkdir()			: 존재하지 않으면 디렉토리 생성.
 * renameTo()		: 파일 이름 변경.
 * 
 * 
 * 
 * File sf = new File(f, filenames[i]);		: finenames[i] 이름의 File 객체 생성.
 */
public class 파일메소드 {
	public static void main(String[] args) {
		File dirObj = new File("iotest");
		
		System.out.println(dirObj.exists() ? "유효한 디렉토리경로입니다." : "유효하지 않는 디렉토리경로입니다");
		System.out.println(dirObj.isDirectory() ? "디렉토리입니다" : "디렉토리가 아닙니다");
		
		String[] list = dirObj.list();
		System.out.println("----------------------------------");
		System.out.println("\t" + dirObj.getName() + " 정보");
		System.out.println("----------------------------------");
		for(String name : list) {
			System.out.println(name);
		}
		System.out.println("----------------------------------");
		
		File newDirObj = new File("iotest/새폴더/고니");
		if(!newDirObj.exists()) {
			boolean bool = newDirObj.mkdir();
			System.out.println(bool ? "생성 성공" : "생성 실패");
		}
		
		newDirObj = new File("iotest/새새폴더/오리");
		if(!newDirObj.exists()) {
			boolean bool = newDirObj.mkdirs();
			System.out.println(bool ? "생성 성공" : "생성 실패");
		}
		
		boolean bool = newDirObj.delete();
		System.out.println(bool ? "삭제 성공" : "삭제 실패");
		

//		File fileObj = new File("D:/Lecture/java-workspace/java/a.txt");
		File fileObj = new File("iotest/a.txt");

		String fileName = fileObj.getName();
		String parent = fileObj.getParent();
		String path = fileObj.getPath(); // 경로...
		
		System.out.println("파일명 : " + fileName);
		System.out.println("부모이름 : " + parent);
		System.out.println("경로 : " + path);
		
		bool = fileObj.isFile(); // 파일 타입인지 아닌지..
		System.out.println(bool ? "파일입니다" : "파일이 아닙니다");
		
		bool = fileObj.isDirectory();
		System.out.println(bool ? "디렉토리입니다" : "디렉토리가 아닙니다");
		
		System.out.println(fileName + "은 " + (fileObj.exists() ? "존재합니다" : "존재하지 않습니다"));
		
		long length = fileObj.length();
		System.out.println("파일 크기 : " + length + "byte(s)");
		
		long time =	fileObj.lastModified();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.println("마지막 수정날짜 : " + sdf.format(new Date(time)));
		
		bool = fileObj.canRead();
		System.out.println(bool ? "읽기가능" : "읽기불가능");
		
		bool = fileObj.canWrite();
		System.out.println(bool ? "쓰기가능" : "쓰기불가능");

	}
}