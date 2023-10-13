

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login-pro")
public class LoginPro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginPro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String userID = request.getParameter("userID");
		String userPW = request.getParameter("userPW");
		PrintWriter out = response.getWriter();
		if(userID.equals("kkk") && userPW.equals("1234")){
//			out.println("""
//					<script>
//					alert('로그인 성공'); 
//					location.href="http://www.daum.net";
//				    </script>
//				""");
			// servlet에는 4개의 영역있음 application, session(연결이 끊기기전까지), request(하나만 다음으로), pageContext
			HttpSession session = request.getSession();
			session.setAttribute("userID", userID);
			response.sendRedirect("login-success");  // 변경
		} else {
			out.println("""
					<script>
					alert('로그인 실패'); 
					history.back();  
				    </script>
				""");	
		}//history.back() 전단계로
	}

}
