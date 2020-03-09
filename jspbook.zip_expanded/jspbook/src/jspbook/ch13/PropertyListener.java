package jspbook.ch13;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * File : PropertyListener.java
 * Desc : 리스너 테스트를 위한 속성 파일 처리 리스너
 * @author 황희정(dinfree@dinfree.com)
 */
@WebListener
public class PropertyListener implements ServletContextListener {


    public PropertyListener() {
    }

    // 리스너 실행 메서드
    public void contextInitialized(ServletContextEvent arg0) {
    	 ServletContext ctx = arg0.getServletContext(); 
    	 // 초기화 파라미터로 경로 정보를 가져옴
    	 String file = ctx.getInitParameter("propfile");
    	 
    	 // 지정된 경로의 파일로 프로퍼티 객체를 생성
    	 Properties p = new Properties();
    	 try {
			p.load(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	 // application scope 에 prop 라는 이름으로 프로퍼티 객체 저장
    	 ctx.setAttribute("prop", p);
    }

    public void contextDestroyed(ServletContextEvent arg0) {
    }
	
}
