package com.kh.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthSeparatorUI;

import com.kh.service.IService;
import com.kh.service.ListService;
import com.kh.service.WriteFormService;
import com.kh.service.WriteRunService;

@WebServlet("*.md2")
public class MyFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String PREFIX = "WEB-INF/views/";
	private final String SUFFIX = ".jsp";
	private Map<String, IService> commandMap = new HashMap<>();
       
    public MyFrontController() {
        super();
    }
    
    @Override
    public void init() throws ServletException {
    	super.init();
    	System.out.println("init");
    	loadCommand("/com.kh.properties/command");
    	System.out.println("ok");
    }
    
    private void loadCommand(String prop) {
    	ResourceBundle rb = ResourceBundle.getBundle(prop);
    	Enumeration<String> keys = rb.getKeys();
    	while (keys.hasMoreElements()) {
			String key = (String) keys.nextElement();
			String className = rb.getString(key);
//			System.out.println(key + "=" + className);
			try {
				Class<?> commandClass = Class.forName(className);
				Object obj = commandClass.newInstance();
				commandMap.put(key, (IService)obj);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
    }
    
    private String getCommand(HttpServletRequest request) {
    	String uri = request.getRequestURI();
    	String contextPath = request.getContextPath();
    	int startIndex = contextPath.length() + 1;
    	int endIndex = uri.lastIndexOf(".");
    	String command = uri.substring(startIndex, endIndex);
    	return command;
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		String command = getCommand(request);
//		System.out.println("command :"+ command);
		
		String path = "";
		IService service = commandMap.get(command);
//		System.out.println("service :" + service);
		
		try {
			path = service.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		boolean isRedirect = path.startsWith("redirect:");
		
		if (isRedirect) {
			response.sendRedirect(path.substring("redirect:".length()));
		} else {
			String url = PREFIX + path + SUFFIX;
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
} //MyFrontController
