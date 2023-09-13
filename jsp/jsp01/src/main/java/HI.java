


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hi")
public class HI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public HI() {
        super();
    
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset = UTF-8");
		String name = request.getParameter("name");
		int age =Integer.parseInt(request.getParameter("age"));  //숫자로 들어와도 문자로 받아야한다.
		PrintWriter out = response.getWriter();
		out.println(age);
		out.println(name);
		if(age<18) {
			out.println("당신의 이름은 "+name+" 입니다. 미성년자입니다.");
		} else {
			out.println("당신의 이름은 "+name+" 입니다.  안녕");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
