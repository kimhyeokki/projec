

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/gugudan")
public class gugudan extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public gugudan() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  PrintWriter out=response.getWriter();
	  // servlet은 자바코드안에 html 쓰기
	  // jsp는 html안에 자바코드 쓰기
	//  out.println("<!DOCTYPE html>");
//	  out.println("<html lang='en'>");
//	  out.println("<head>");
//	  out.println("<meta charset='UTF-8'>");
//	  out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
//	  out.println("<title>구구단</title>");
//	  out.println("</head>");
//	  out.println("<body>");
//	  out.println("<form action=''>");
//	  out.println("<input type='text' name='dan' />");
//	  out.println("<button>구구단 출력</button>");
//	  out.println("</form>");
//	  out.println("</body>");
//	  out.println("</html>");
	  response.setContentType("text/html; charset=UTF-8"); //action= @WebServlet("/내용") 
	  out.println("""
	  		<form action="gugudan-result" method="get">  
                  <!--<input type="text" name="dan">-->
                  <!--
	  			 <label><input type = "radio" name="dan" value="2"><span>2</span></label>
	  			 <label><input type = "radio" name="dan" value="3"><span>3</span></label>
	  			 <label><input type = "radio" name="dan" value="4"><span>4</span></label>
	  			 <label><input type = "radio" name="dan" value="5"><span>5</span></label>-->
	  			<!--
	  			  <select name="dan">
	  			 <option value="2">2</option>
	  			 <option value="3">3</option>
	  			 <option value="4">4</option>
	  			 </select>-->
	  			<button>구구단 출력</button>
	  			</form>
	  		""");
	  out.println("""
	  		<form action="item-result" method="get">
	  		<p>관심 항목을 체크해주세요</p>
	  			 <label><input type = "checkbox" name="item" value="정치"><span>정치</span></label>
	  			 <label><input type = "checkbox" name="item" value="영화"><span>영화</span></label>
	  			 <label><input type = "checkbox" name="item" value="스포츠"><span>스포츠</span></label>
	  			 <label><input type = "checkbox" name="item" value="jsp"><span>jsp</span></label>
	  			 <label><input type = "checkbox" name="item" value="spring"><span>spring</span></label>
	  			 <button>전송</button>
	  		</form>
	  		""");
	}
}
