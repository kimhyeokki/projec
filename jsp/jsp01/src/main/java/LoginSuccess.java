

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login-success")
public class LoginSuccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginSuccess() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String userID = (String)session.getAttribute("userID");
		out.println("""
				<h1>로그인 성공</h1>
				""");
		out.println(userID);
	}

}
