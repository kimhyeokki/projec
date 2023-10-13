

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Hello() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	     PrintWriter out =response.getWriter();
	     response.setContentType("text/html;charset=UTF-8");  //html으로 취급하려면 setContentType을 사용
	     out.println("<h1>hello servlet</h1>");
	     out.println("<h1>헬로 서블릿</h1>");
	     out.println("""
	     		<a href="hi?name=wff&age=22">hi</a>    
	     		""");  
	     //""" => 자바 17 이상 사용가능
	     //? 이후에 &로 벨류값을 받아온다.
	    //web.xml 에 servlet mapping 대신 @WebServlet("/ddd") 사용가능하다.
	}

}
