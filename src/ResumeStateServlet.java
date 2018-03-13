

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import myJavaClasses.UpdateTableDBUtil;

/**
 * Servlet implementation class ResumeStateServlet
 */
@WebServlet("/ResumeStateServlet")
public class ResumeStateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UpdateTableDBUtil updateTableDbUtil;
	@Resource(name="jdbc/dbmeetUp")
	private DataSource dataSource;
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		//create our Organiserutil pass in the conn pool / datasource
		try {
			updateTableDbUtil=new UpdateTableDBUtil(dataSource);
		}
		catch(Exception exc) {
			throw new ServletException(exc);
		}
	}
    public ResumeStateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			HttpSession session=request.getSession(false);  
			String uname=(String)session.getAttribute("userName");
			if(uname==null)
			{
				out.println("nullSession");
			}
			else
			{
				int eid=Integer.parseInt(request.getParameter("eid"));
				String state=updateTableDbUtil.getState(eid,uname);
				out.println(state);
			}
	        
		}
		catch(Exception e)
		{
			System.out.print(e.getMessage());
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
