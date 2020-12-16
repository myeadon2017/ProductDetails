

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//This servlet will be used for searching the product Id
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	//This method will be used to respond a doPost method to the system in order to display
	//the products name and details
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		//This function takes in the Id entered by the user
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		
		//This function called the getProductById function from ProdDao
		Prod p= ProdDao.getProductById(id);
		
		//If the Id name is not null then it will display the product information
		//If the name is null then the user will be displayed an error message
		if(p.getName()!=null){
			out.println(p);
		}
		else{
			out.println("Sorry, this Id doesnt exists");
		}
		out.close();
	}

}
