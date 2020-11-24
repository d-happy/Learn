package com.kh.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.service.IStudentService;
import com.kh.service.StudentDeleteService;
import com.kh.service.StudentListService;
import com.kh.service.StudentModifyFormService;
import com.kh.service.StudentModifyRunService;
import com.kh.service.StudentRegistFormService;
import com.kh.service.StudentRegistRunService;

@WebServlet("*.exam")
public class StudentFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
//	private Map<String, IStudentService> commandMap = new HashMap<>();
	
    public StudentFrontController() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init");
	}
	
	private String getCommand(HttpServletRequest request) { // 주소에서 list 부분 찾기
		String uri = request.getRequestURI();
		System.out.println(uri);
		String projectName = request.getContextPath();
		int startIndex = projectName.length() + 1;
		int endIndex = uri.lastIndexOf(".");
		String command = uri.substring(startIndex, endIndex);
		return command;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String command = getCommand(request);
		System.out.println(command);
		IStudentService iStudentService = null;
		
		if (command.equals("list")) {
			iStudentService = new StudentListService();
		} else if (command.equals("student_regist_form")) {
			iStudentService = new StudentRegistFormService();
		} else if (command.equals("student_modify_form")) {
			iStudentService = new StudentModifyFormService();
		} else if (command.equals("student_mregist_run")) {
			iStudentService = new StudentRegistRunService();
		} else if (command.equals("student_mmodify_run")) {
			iStudentService = new StudentModifyRunService();
		} else if (command.equals("student_delete")) {
			iStudentService = new StudentDeleteService();
		} 
		
		
		String where = iStudentService.execute(request, response);
		System.out.println("="+where);
		
		String location = where + ".jsp";
		
		response.sendRedirect(location);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		doGet(request, response);
	}

}
