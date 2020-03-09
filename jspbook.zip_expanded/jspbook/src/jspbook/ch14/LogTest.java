package jspbook.ch14;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * File : LogTest.java
 * Desc : 로그 테스트를 위한 간단 예제
 * @author 황희정(dinfree@dinfree.com)
 */
public class LogTest {

	// main 메서드에서 간단한 로그 메시지 처리 확인 
	public static void main(String[] args) {
		String msg = "Hello Log!!";
		Logger logger = LoggerFactory.getLogger(LogTest.class);
		logger.info("test log");
		logger.warn("test log :  {}",msg);
	}
}
