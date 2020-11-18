package com.kh.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sun.security.timestamp.HttpTimestamper;

@WebFilter("*.kh")
public class MemberFilter implements Filter {

    public MemberFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("doFilter() 실행됨");
		
		// 로그인 -> session에 "memberVo" 설정
//		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = ((HttpServletRequest)request).getSession();
		Object obj = session.getAttribute("memberVo");
		if (obj == null) {
			((HttpServletResponse)response).sendRedirect("login_form.do");
			return; // chain.doFilter() 못 하게
		}
		
		chain.doFilter(request, response); // 넘겨준다?? // Controller 실행을 계속
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

} // MemberFilter
