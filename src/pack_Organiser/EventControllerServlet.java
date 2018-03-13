package pack_Organiser;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.sql.DataSource;
/**
 * Servlet implementation class EventControllerServlet
 */
@WebServlet("/EventControllerServlet")
@MultipartConfig
public class EventControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private EventDbUtil eventDbUtil;
    private Event theEvent;
    @Resource(name="jdbc/dbmeetUp")
    private DataSource dataSource;
    
    
    
    @Override
	public void init() throws ServletException {
		super.init();
		
		// create our instance of the event class and pass the connection pool
		try{
			eventDbUtil=new EventDbUtil(dataSource);
		}
		catch(Exception exc) {
			throw new ServletException(exc);
		}
		
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public EventControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		try
		{
		String organiserEmailId=session.getAttribute("emailId").toString();
		if(organiserEmailId==null)
		{
			RequestDispatcher dispatcher=request.getRequestDispatcher("OrganiserLogin.jsp");
			dispatcher.forward(request, response);
		}
		try {
			// read the command parameter 
			String theCommand=request.getParameter("command");
			//HttpSession session = request.getSession();
			//String organiserEmailId=session.getAttribute("emailId").toString();
			// If the command is mission then default to listing commands
			if(theCommand==null) {
				//theCommand="LIST";
				theCommand="LIST";
			}
			//route to appropriate method
			switch(theCommand) {
			case "LIST":
				listEvents(request,response,organiserEmailId);
			case "ADD":
				addEvents(request,response,organiserEmailId);
				break;
			case "UPDATE":
				updateEvent(request,response,organiserEmailId);
				break;
			default:
				listEvents(request,response,organiserEmailId);
			}
			//list the students in MVC fashion
			
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
		//super.doPost(request, response);
	}
	catch(NullPointerException ex)
	{
		response.sendRedirect("OrganiserLogin.jsp");
	}
	}


@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
	HttpSession session = request.getSession();
	String organiserEmailId=session.getAttribute("emailId").toString();
	if(organiserEmailId==null)
	{
		RequestDispatcher dispatcher=request.getRequestDispatcher("OrganiserLogin.jsp");
		dispatcher.forward(request, response);
	}
		
		try {
			
			// read the command parameter 
			String theCommand=request.getParameter("command");
			// If the command is mission then default to listing commands
			if(theCommand==null) {
				//theCommand="LIST";
				theCommand="ADD";
			}
			//route to appropriate method
			switch(theCommand) {
			case "LIST":
				listEvents(request,response,organiserEmailId);
			case "LOAD":
				loadEvents(request,response,organiserEmailId);
				break;
			case "STATUS":
				getStatus(request,response,organiserEmailId);
				break;
			case "DELETE":
				deleteEvents(request,response,organiserEmailId);
				break;
			default:
				listEvents(request,response,organiserEmailId);
			}
			//list the students in MVC fashion
		} catch (Exception e) {
			throw new ServletException(e);
		}
		//doPost(request, response);
	}
	
private void getStatus(HttpServletRequest request, HttpServletResponse response, String organiserEmailId) throws Exception {
	// TODO Auto-generated method stub
	if(organiserEmailId==null)
	{
		response.sendRedirect("OrganiserLogin.jsp");
	}
		
	// read event id from form data
	 String theEventId=request.getParameter("eventId");
	//get event from database
	 Map<String,String> goingStatus=eventDbUtil.getEventGoingStatus(theEventId,organiserEmailId);
	 Map<String,String> interestedStatus=eventDbUtil.getEventInterestedStatus(theEventId,organiserEmailId);
	//place event in request attribute
	 if(goingStatus==null || interestedStatus==null)
	 {
		 System.out.println("status null");
	 }
		request.setAttribute("THE_GSTATUS", goingStatus);
		request.setAttribute("THE_ISTATUS", interestedStatus);
	RequestDispatcher dispatcher=request.getRequestDispatcher("/Display-Event-Status.jsp");
	dispatcher.forward(request, response);
}

private void deleteEvents(HttpServletRequest request, HttpServletResponse response,String organiserEmailId) throws Exception {
	
	String theEventId=request.getParameter("eventId");
	eventDbUtil.deleteEvents(theEventId);
	listEvents(request,response,organiserEmailId);
}

private void updateEvent(HttpServletRequest request, HttpServletResponse response,String organiserEmailId) throws Exception {
	
	// read the event info
	int eventId=Integer.parseInt(request.getParameter("eventId"));
	//String organiserEmailId="rocksparvezmulla1@gmail.com";
	String organiserEmail=organiserEmailId;
	String Title=request.getParameter("Title");
	String Description=request.getParameter("Description");
	String Date=request.getParameter("Date");
	String Time=(request.getParameter("Time")).toString();
	String Category=request.getParameter("Category");
	String Fees=request.getParameter("Fees");
	String otherInfo=request.getParameter("otherInfo");
	String Venue=request.getParameter("Venue");
	InputStream Picture =null; // input stream of the upload file
	Part filePart = request.getPart("Picture");
	 if (filePart != null && filePart.getSize() > 0) {
            // prints out some information for debugging
           // System.out.println(filePart.getName());
           // System.out.println(filePart.getSize());
           // System.out.println(filePart.getContentType());
             
            // obtains input stream of the upload file
		 Picture = filePart.getInputStream();
        }
	 int goingCount=Integer.parseInt(request.getParameter("goingCount"));
	 int interestedCount=Integer.parseInt(request.getParameter("interestedCount"));;
	 
	// create new event object
	Event theEvent=new Event(eventId,organiserEmailId,  Title, Description, Date, Time, Category,
			Fees, otherInfo, Venue, goingCount, interestedCount,Picture);
	
	// add the student to the database
	eventDbUtil.updateEvent(theEvent);
	// send back to the event page
	listEvents(request,response,organiserEmail);
	// create the event object
	
	// perform the update
	
	//send to the list
}

private void loadEvents(HttpServletRequest request, HttpServletResponse response,String organiserEmailId) throws Exception{
	
	if(organiserEmailId==null)
	{
		response.sendRedirect("OrganiserLogin.jsp");
	}
		
	// read event id from form data
	 String theEventId=request.getParameter("eventId");
	//get event from database
	Event theEvent=eventDbUtil.getEvents(theEventId);
	//place event in request attribute
	request.setAttribute("THE_EVENT", theEvent);
	// send to jsp page : update-event-from.jsp
		RequestDispatcher dispatcher=request.getRequestDispatcher("/Update-Event-Form.jsp");
		dispatcher.forward(request, response);
	}

private void addEvents(HttpServletRequest request, HttpServletResponse response, String organiserEmailId) throws Exception {
	
		//read event data from the form data
		
		//String organiserEmailId=request.getParameter(arg0)
		//String organiserEmailId="rocksparvezmulla1@gmail.com";
		String organiserEmail=organiserEmailId;
		String Title=request.getParameter("Title");
		String Description=request.getParameter("Description");
		String Date=request.getParameter("Date");
		String Time=request.getParameter("Time");
		String Category=request.getParameter("Category");
		String Fees=request.getParameter("Fees");
		String otherInfo=request.getParameter("otherInfo");
		String Venue=request.getParameter("Venue");
		InputStream Picture = null; // input stream of the upload file
		Part filePart = request.getPart("Picture");
		 if (filePart != null) {
	            // prints out some information for debugging
	          //  System.out.println(filePart.getName());
	           // System.out.println(filePart.getSize());
	           // System.out.println(filePart.getContentType());
	             
	            // obtains input stream of the upload file
			 Picture = filePart.getInputStream();
	        }
		 int goingCount=0,interestedCount=0;
		 
		// create new event object
		Event theEvent=new Event(organiserEmailId,  Title, Description, Date, Time, Category,
				Fees, otherInfo, Venue, goingCount, interestedCount,Picture);
		
		// add the student to the database
		eventDbUtil.addEvent(theEvent);
		// send back to the event page
		listEvents(request,response,organiserEmail);
	}

	private void listEvents(HttpServletRequest request, HttpServletResponse response, String organiserEmailId) throws Exception {
		if(organiserEmailId==null)
		{
			response.sendRedirect("OrganiserLogin.jsp");
		}
		//get student from DBUtil
		List<Event> events=eventDbUtil.getOrganiserEvents(organiserEmailId);
		//add student to the request object
		request.setAttribute("EVENTS_LIST", events);
		//send to the JSP page
		RequestDispatcher dispatcher=request.getRequestDispatcher("/list-events.jsp");
		dispatcher.forward(request, response);
	}
}
