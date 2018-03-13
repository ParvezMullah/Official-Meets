

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
 * Servlet implementation class UpdateTableServlet
 */
@WebServlet("/UpdateTableServlet")
public class UpdateTableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UpdateTableDBUtil updateTableDbUtil;
	@Resource(name="jdbc/dbmeetUp")
	private DataSource dataSource;
    /**
     * @see HttpServlet#HttpServlet()
     */
	@Override
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
    public UpdateTableServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//update going or interested in database table
		try {
		HttpSession session=request.getSession(false);  
        String uname=(String)session.getAttribute("userName");  
	    int eventid = Integer.parseInt(request.getParameter("eid"));
	    String name=request.getParameter("tableName");
	    String tableName="";
	    String tblColumn;
	    if(name.equals("Going"))
	    {
	    		tableName="tbl_eventgoing";
	    		tblColumn="goingCount";
	    }
	    else
	    {
	    		tableName="tbl_eventinterested";
	    		tblColumn="interestedCount";
	    }
	    
	    		int count=updateTableDbUtil.updateTable(eventid,uname,tableName);
	    		PrintWriter out = response.getWriter();
    			//out.println(eventid+" "+tableName+" "+count);
	    		System.out.println(tableName);
	    		if(count>=0)
	    		{
	    			int value=updateTableDbUtil.updateCount(eventid, tblColumn);
	    			if(value>0)
	    			{
	    				//PrintWriter out = response.getWriter();
	    				out.println("successfull");
	    			}
	    			else
	    			{
	    				//PrintWriter out = response.getWriter();
	    				out.println("failed"+value+" "+tblColumn);
	    			}
	    		}
	    		else
	    		{
	    			//PrintWriter out = response.getWriter();
	    			out.println("failed"+tableName+" "+count);
	    		}
	    }
	    catch (Exception e) {
			
	    	System.out.println(e.getMessage());
		}
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
