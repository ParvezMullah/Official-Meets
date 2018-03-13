

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import myJavaClasses.Event;
import myJavaClasses.Organiser;
import myJavaClasses.PortfolioDBUtil;

/**
 * Servlet implementation class PortfolioDetailsServlet
 */
@WebServlet("/PortfolioDetailsServlet")
public class PortfolioDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private PortfolioDBUtil portfolioDbUtil;
	    
	    @Resource(name="jdbc/dbmeetUp")
	    private DataSource dataSource;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PortfolioDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		// create our instance of the portfolio class and pass the connection pool
				try{
					portfolioDbUtil=new PortfolioDBUtil(dataSource);
				}
				catch(Exception exc) {
					throw new ServletException(exc);
				}
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String eventId=request.getParameter("option");
		if(eventId==null){
			String category=getCategory(request,response);
			List<Event> events;
			try {
				events = portfolioDbUtil.getPortfolioEvents(category);
			//add student to the request object
				request.setAttribute("EVENTS_LIST", events);
				request.setAttribute("category", category);
			//send to the JSP page
				RequestDispatcher dispatcher=request.getRequestDispatcher("/PortfolioDetails.jsp");
				dispatcher.forward(request, response);
			} catch (SQLException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			//request.setAttribute("eventId", option);
			//RequestDispatcher dispatcher=request.getRequestDispatcher("/MeetingServlet");
			//dispatcher.forward(request, response);
			List<Event> eventDetail;
			Organiser organiserDetail;
			try {
				eventDetail=portfolioDbUtil.getEventDetails(eventId);
				String emailId=portfolioDbUtil.getEmailId();
				organiserDetail=portfolioDbUtil.getOrganiserDetails(emailId);
				
				//String email=event.getOrganiserEmailId();
				//request.setAttribute("title", eventId );
				request.setAttribute("eventDetails", eventDetail);
				request.setAttribute("organiserDetails", organiserDetail);
				request.setAttribute("organiserEmail", emailId);
				RequestDispatcher dispatcher=request.getRequestDispatcher("/Meeting.jsp");
				dispatcher.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}

	private String getCategory(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String pf=request.getParameter("param");
		String category=null;
		switch(pf)
		{
		case "ml":
			category="Machine Learning";
			break;
			
		case "bda":
			category="Big Data";
			break;
			
		case "cc":
			category="Cloud";
			break;
			
		case "sd":
			category="Software Development";
			break;
		}
		
		return category;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
	}

}
