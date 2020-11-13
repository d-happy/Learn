package com.kh.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.service.IService;
import com.kh.service.ListService;
import com.kh.service.WriteFormService;
import com.kh.service.WriteRunService;

@WebServlet("*.kh")
public class MyFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String PREFIX = "/WEB-INF/views/";
	private final String SUFFIX = ".jsp";
	private Map<String, IService> commandMap = new HashMap<>();
       
    public MyFrontController() {
        super();
    }

    @Override
    public void init() throws ServletException {
    	// 해당 서블릿으로 최초 요청에 대해서 1번만 실행
    	System.out.println("init 실행됨");
    	loadProperties("/com.kh.properties/command"); // 마지막 command => command.properties
    	System.out.println("ok");
    }
    
    // if else 로 command 하는 거 대신
    // Map<String, IService> commandMap 이걸로 command.properties 넣어서?? 요청 # 되면 서비스 # 한다
    private void loadProperties(String prop) {
    	ResourceBundle rb = ResourceBundle.getBundle(prop); // /com.kh.properties/command.properties 사용하겠다??
    	Enumeration<String> keys = rb.getKeys(); // = 왼쪽에 자리한 거 가져오기??
    	while(keys.hasMoreElements()) { // 여러개인가??
    		String key = keys.nextElement(); // 다음 게 있으면 그게 key ??
    		String className = rb.getString(key); // key = ㅁㅁ이면 ㅁㅁ은 key한테 주어진  String
    		System.out.println(key + "=" + className); // 
    		try {
    			//문자열 형태의 클래스 정보를 가지고 객체 생성
    			Class<?> commandClass = Class.forName(className); // 이름으로 클래스 로딩해서 배열에 넣기?
    			Object obj = commandClass.newInstance(); // new Xxx()
    			commandMap.put(key, (IService)obj); 
    			// HashMap 에 // key로 command파일 "왼쪽=" 
    			// value로 command파일 "=오른쪽"
    			// Class.forName(className); 로 작동하는 클래스 객체 생성해서 넣어줌 -> 클래스 안에 있는 메소드 사용 가능
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}
    }
    
    private String getCommand(HttpServletRequest request) {
    	String uri = request.getRequestURI(); // /Model2/write_form.jsp
    	String contextPath = request.getContextPath(); // /Model2
    	int startIndex = contextPath.length() + 1; // w의 인덱스
    	int endIndex = uri.lastIndexOf("."); // .의 위치 (뒤에서부터 찾음)
    	String command = uri.substring(startIndex, endIndex); // write_form
    	return command;
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String command = getCommand(request);
//		System.out.println("command :" + command);
		
		String path = "";
//		IService service = null;
		IService service = commandMap.get(command);
//		if (command.equals("list")) { // list.jsp
//			service = new ListService(); // 인터페이스 1 - 실현 클래스 n :: 다형성 구현???
//			service = commandMap.get("list");
//		} else if (command.equals("write_form")) { // write_form.jsp
//			service = commandMap.get("write_form");
//		} else if (command.equals("write_run")) {
//			service = commandMap.get("write_run");
//		}
//		System.out.println("service :" + service); // com.kh.service.ListService@689eca74 객체로 생성됨
		
		try { // 인터페이스 IService 추상메소드 execute 에서 throws Exception 한 거 받으려고 try~catch
			path = service.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		boolean isRedirect = path.startsWith("redirect:"); // redirect:list.kh
		if (isRedirect) {
			response.sendRedirect(path.substring("redirect:".length())); // list.kh
		} else {
			// list.jsp 숨기고 -> http://localhost/Model2/list.kh 치면 리스트 나옴
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher(PREFIX + path + SUFFIX);
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response); 
		// 서블릿 생성할 때 기본으로 doGet, doPost 생기는데 이때
		// doPost 안에 기본으로 doGet(request, response); 메소드가 있음 
		// -> 그래서 결과적으로 post를 하든 get을 하든 모두 다 doGet 에서 처리됨 
	}

} //MyFrontController
