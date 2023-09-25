

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class Hi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Hi() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//PrintWriter out = response.getWriter();
		//out.println("<h1>Hi Servlet</h1>");
		Person person = new Person();
		person.setName("김혁기");
		person.setNickName("와우");
		person.setAge(23);
		person.setGender("male");
		
		Person person02 = new Person("유재석","와아",30,"male");
		Person person03 = new Person("하하","꼬마",29,"male");
		Person person04 = new Person("미주","화외",22,"female");
		Person person05 = new Person("진주","화외",21,"female");
		Person person06 = new Person("이경","화외",26,"male");
		Person person07 = new Person("우재","화외",27,"female");
		
		List<Person> personList = new ArrayList<>();
		personList.add(person02);
		personList.add(person03);
		personList.add(person04);
		personList.add(person05);
		personList.add(person06);
		personList.add(person07);
	//	String name02 = request.getParameter("name02");
	//	request.setAttribute("name02", name02);
	//	request.setAttribute("name02", "khk10");
		request.setAttribute("me", person); //(키, 벨류)
		request.setAttribute("personList", personList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Hi.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
