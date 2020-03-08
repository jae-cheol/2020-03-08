package kr.co.bit.util;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class FileClose {
	
	// 다른 패키지에서 메소드 써야됨
	public static void close(Reader r) {
		
		try {
			if(r != null)
				r.close();
		} catch(Exception e) {
			e.printStackTrace();
		} 
	}
	
	public static void close(Writer w) {
		
		try {
			if(w != null)
				w.close();
		} catch(Exception e) {
			e.printStackTrace();
		} 
	}
	
	public static void close(Reader r, Writer w) {
		close(r);
		close(w);
	}
	
	public static void close(Reader br, Reader r) {
		close(br);
		close(r);
	}

	public static void close(Writer bw, Writer w) {
		close(bw);
		close(w);
	}
	
	public static void close(InputStream is) {
		try {
			if(is != null)
				is.close();
		} catch(Exception e) {
			e.printStackTrace();
		} 
	}
	
	public static void close(OutputStream os) {
		try {
			if(os != null)
				os.close();
		} catch(Exception e) {
			e.printStackTrace();
		} 
	}
	
	public static void close(InputStream is, InputStream bis) {
		FileClose.close(is);
		FileClose.close(bis);
	}
	
	public static void close(OutputStream os, OutputStream bos) {
		FileClose.close(os);
		FileClose.close(bos);
	}
	
}
