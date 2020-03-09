package jspbook.ch13;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * File : AdminFilter.java
 * Desc : 필터 응용을 위한 관리자 필터 예제
 * @author 황희정(dinfree@dinfree.com)
 */
@WebFilter("/ch13/admin/*")
public class AdminFilter implements Filter {
	Properties p;
    public AdminFilter() {
    }

	public void destroy() {

	}

	// 필터 처리 메서드
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 초기화 파라미터에서 prop 로 지정된 프로퍼티 객체에 adminId 로 "SuperUser" 추가
		p = (Properties) request.getServletContext().getAttribute("prop");
		p.put("adminId", "SuperUser");
		
		// request 에 tel 정보 추가
		request.setAttribute("tel", "010-1234-1234");
		
		// 필터처리 종료, 다음 필터 실행
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}
}