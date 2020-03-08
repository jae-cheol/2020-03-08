package IO;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
/*
 * isFile()			: ����Ÿ������ �ƴ���..
 * isDirectory()	: ���丮���� �ƴ���...
 * getPath()		: �ش� ���..
 * list()			: ���丮�ϰ��) �ش� ���丮�� ������ϰ� ������丮��.
 * length()			: ������ ũ��(����Ʈ)
 * lastModified()	: ������ �����ð�.
 * exists()			: ������ �����ϴ���...
 * mkdir()			: �������� ������ ���丮 ����.
 * renameTo()		: ���� �̸� ����.
 * 
 * 
 * 
 * File sf = new File(f, filenames[i]);		: finenames[i] �̸��� File ��ü ����.
 */
public class ���ϸ޼ҵ� {
	public static void main(String[] args) {
		File dirObj = new File("iotest");
		
		System.out.println(dirObj.exists() ? "��ȿ�� ���丮����Դϴ�." : "��ȿ���� �ʴ� ���丮����Դϴ�");
		System.out.println(dirObj.isDirectory() ? "���丮�Դϴ�" : "���丮�� �ƴմϴ�");
		
		String[] list = dirObj.list();
		System.out.println("----------------------------------");
		System.out.println("\t" + dirObj.getName() + " ����");
		System.out.println("----------------------------------");
		for(String name : list) {
			System.out.println(name);
		}
		System.out.println("----------------------------------");
		
		File newDirObj = new File("iotest/������/���");
		if(!newDirObj.exists()) {
			boolean bool = newDirObj.mkdir();
			System.out.println(bool ? "���� ����" : "���� ����");
		}
		
		newDirObj = new File("iotest/��������/����");
		if(!newDirObj.exists()) {
			boolean bool = newDirObj.mkdirs();
			System.out.println(bool ? "���� ����" : "���� ����");
		}
		
		boolean bool = newDirObj.delete();
		System.out.println(bool ? "���� ����" : "���� ����");
		

//		File fileObj = new File("D:/Lecture/java-workspace/java/a.txt");
		File fileObj = new File("iotest/a.txt");

		String fileName = fileObj.getName();
		String parent = fileObj.getParent();
		String path = fileObj.getPath(); // ���...
		
		System.out.println("���ϸ� : " + fileName);
		System.out.println("�θ��̸� : " + parent);
		System.out.println("��� : " + path);
		
		bool = fileObj.isFile(); // ���� Ÿ������ �ƴ���..
		System.out.println(bool ? "�����Դϴ�" : "������ �ƴմϴ�");
		
		bool = fileObj.isDirectory();
		System.out.println(bool ? "���丮�Դϴ�" : "���丮�� �ƴմϴ�");
		
		System.out.println(fileName + "�� " + (fileObj.exists() ? "�����մϴ�" : "�������� �ʽ��ϴ�"));
		
		long length = fileObj.length();
		System.out.println("���� ũ�� : " + length + "byte(s)");
		
		long time =	fileObj.lastModified();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.println("������ ������¥ : " + sdf.format(new Date(time)));
		
		bool = fileObj.canRead();
		System.out.println(bool ? "�бⰡ��" : "�б�Ұ���");
		
		bool = fileObj.canWrite();
		System.out.println(bool ? "���Ⱑ��" : "����Ұ���");

	}
}