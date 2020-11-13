import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ServletTest extends HttpServlet{

	// get post 중에 서블렛이 get 방식 ~~~ 하겠다고 오버라이딩??? 메소드 재정의???
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            
		response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        Calendar cal= Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);
        Date d = new Date(0,0,0,hour,minute,second); // 이제 안 씀
        System.out.println(hour+"시"+minute+"분"+second+"초");
        
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String strTime=sdf.format(d);
        PrintWriter out=response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>" + strTime + "<h1/>");
        out.println("</body>");
        out.println("</html>");
    }
    
} //ServletTest
