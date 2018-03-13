package pack_Organiser;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 *  implementation class OrganiserLoginServlet
 */
@WebServlet("/OrganiserLoginServlet")
public class OrganiserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       OrganiserLoginUtil organiserLoginUtil;
       @Resource(name="jdbc/dbmeetUp")
       private DataSource dataSource;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrganiserLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		try {
			organiserLoginUtil=new OrganiserLoginUtil(dataSource);
		}
		catch(Exception exc) {
			throw new ServletException(exc);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("Text/Plain");
		HttpSession session=request.getSession(false);
		if(session==null)
		{
			response.sendRedirect("OrganiserLogin.jsp");
		}
		organiserLogin(request,response);
	}

	private void organiserLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out=response.getWriter();
		boolean isSuccess=false;
		String emailId= request.getParameter("emailId");
		String Password= request.getParameter("Password");
		OrganiserLogin organiserLogin=new OrganiserLogin(emailId,Password);
		try {
			isSuccess =	organiserLoginUtil.checkLogin(organiserLogin);
		if(isSuccess) {
			  HttpSession session=request.getSession();
			  session.setAttribute("emailId", emailId);
			//response.sendRedirect("https://www.google.com");
			  RequestDispatcher dispatcher=request.getRequestDispatcher("/EventControllerServlet?email="+emailId);
				dispatcher.forward(request, response);
		}
		else {
			response.setContentType("text/html;charset=UTF-8");
			 //PrintWriter out=response.getWriter();
			// step 4:	success message
			 //PrintWriter out=response.getWriter();
			 //out.println("Data Inserted Successfully!");
			 out.println("<script type=\"text/javascript\">");
			   out.println("alert('Invalid Username or Password');");
			   out.println("location='OrganiserLogin.jsp';");
			   out.println("</script>");
			//response.sendRedirect("OrganiserLogin.jsp");
		}
		}
		catch(Exception exc) {
			exc.getMessage();
		}
		
	}

}
