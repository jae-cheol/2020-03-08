package ����ó��;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ExceptionMain04 {
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("a.txt");		// �����Ͻ����� ����ó��(checked Exception)
		} catch(FileNotFoundException fnfe) {
			try {
				FileWriter fw = new FileWriter("error.log");
			} catch(IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}
}