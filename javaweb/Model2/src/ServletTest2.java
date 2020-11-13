

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test2") // web.wml 에서 설정 안 해도 알아서 찾아옴? 셀프 제작 클래스는 가능 외부 제작 클래스는 소스 못 보니까? web.wml 에서만 설정 가능
public class ServletTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletTest2() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GET 요청 들어옴");
		// <form action="test2" method="post"> 메소드 없으면 자동으로 get
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("POST 요청 들어옴");
		/*request.setCharacterEncoding("utf-8"); //요청
		String m_name = request.getParameter("m_name");
		response.setContentType("text/plain"); //응답 따로라서 인코딩 따로 해야 함
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.println(m_name + "님 반가반가");*/
		
		// 리다이렉트
//		response.sendRedirect("test");
		
		// 주소 : <form action="test2" method="post"> ServletTest2 // 화면 : servlet_form.jsp
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("servlet_form.jsp");
		dispatcher.forward(request, response);
	}

}//ServletTest2
