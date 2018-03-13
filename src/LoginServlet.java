

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import myJavaClasses.User;
import myJavaClasses.UserDBUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDBUtil userdbutil;
	
	//define data source
	@Resource(name="jdbc/dbmeetUp")
	private DataSource dataSource;
	
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		//create our userdbutil pass in the conn pool / datasource
		try {
			userdbutil=new UserDBUtil(dataSource);
		}
		catch(Exception exc) {
			throw new ServletException(exc);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		addUser(request,response);
        
	}

	private void addUser(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
            String name = request.getParameter("name");
            String email=request.getParameter("email");
            String profileUrl=request.getParameter("profileUrl");
            User theUser=new User(name,email,profileUrl);
            
            try
            {
            	//step 3: add the user to the database
            	boolean exists=userdbutil.userExists(email);
            	if(!exists)
            	{
            		boolean act=userdbutil.addUser(theUser);
            		if(act==true)
            		{
   			 
   			// step 4:	success message
            			PrintWriter out=response.getWriter();
            			out.println("Login Successfull!");
            			HttpSession session = request.getSession(true);
            			session.setAttribute("userName", email);
            			RequestDispatcher rd = request.getRequestDispatcher("/Welcome.jsp");
            			rd.forward(request, response);
            			//request.getServletContext().getRequestDispatcher("/Welcome.jsp").forward(request, response);
            		}
            		else
            		{
            			PrintWriter out=response.getWriter();
            			out.println("Insert failed");
            		}
   			//response.sendRedirect("http://www.google.com");
            	}
            	else
            	{
        			HttpSession session = request.getSession(true);
        			session.setAttribute("userName", email);
        			//PrintWriter out=response.getWriter();
        			//out.println(session.getAttribute("userName"));
        			RequestDispatcher rd = request.getRequestDispatcher("/Welcome.jsp");
        			rd.forward(request, response);
        			//request.getServletContext().getRequestDispatcher("/Welcome.jsp").forward(request, response);
            	}
            }
            catch (Exception e) {
    			
    			e.getMessage();
            }
            //System.out.println("User name: " + name);
            //System.out.println("User email: " + email);

            //HttpSession session = request.getSession(true);
            //session.setAttribute("userName", name);
            //req.getServletContext()
              // .getRequestDispatcher("/welcome-page.jsp").forward(request, response);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
		
	}

}
