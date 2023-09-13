

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * Servlet implementation class Itemresult
 */
@WebServlet("/item-result")
public class Itemresult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Itemresult() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 String items[] =	request.getParameterValues("item");   //배열로 요청들어 파라벨류로
	 PrintWriter out = response.getWriter();
	 response.setContentType("text/html; charset=UTF-8");
	 if(items==null) {
		 out.println("<span>관심 사항이 없습니다</span>");
	 }
	 for(int i=0;i<items.length;i++) {
		 out.println("<span>"+items[i]+"</span>");
	 }
	 for (String item : items) {
		 out.println("<span>"+item+"</span>");
	}
	}

}
