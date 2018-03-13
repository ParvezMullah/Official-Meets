package pack_Organiser;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.DataSource;

@WebServlet("/OrganiserControllerServlet")
@MultipartConfig(maxFileSize = 16177215)
public class OrganiserControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	OrganiserDbUtil organiserDbUtil;
	@Resource(name="jdbc/dbmeetUp")
	private DataSource dataSource;
    public OrganiserControllerServlet() {
        super();
    }

    @Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		//create our Organiserutil pass in the conn pool / datasource
		try {
			organiserDbUtil=new OrganiserDbUtil(dataSource);
		}
		catch(Exception exc) {
			throw new ServletException(exc);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("Text/Plain");
		addOrganiser(request,response);
		
	}
	

	private void addOrganiser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		// step 1: read organizer info from the form
		 String emailId= request.getParameter("emailId");
		 String firstName= request.getParameter("firstName");
		 String lastName= request.getParameter("lastName");
		 String Password= request.getParameter("Password");
		// String confirmPassword= request.getParameter("confirmPassword");
		 String organizationName= request.getParameter("organizationName");
		 String contactNumber= request.getParameter("contactNumber");
		 int isLoginable=0;
		 
		 InputStream profilePicture = null; // input stream of the upload file
		 Part filePart = request.getPart("profilePicture");
		 if (filePart != null) {
	            // prints out some information for debugging
	          //  System.out.println(filePart.getName());
	           // System.out.println(filePart.getSize());
	           // System.out.println(filePart.getContentType());
	             
	            // obtains input stream of the upload file
			 profilePicture = filePart.getInputStream();
	        }
		 
		// String profilePicture=request.getParameter("profilePicture");
		 String Designation= request.getParameter("Designation");
	
		// step 2: create a new Organizer object
		 Organiser theOrganiser=new Organiser(emailId,firstName,lastName,Password,organizationName,contactNumber,isLoginable,profilePicture,Designation);
				
		 try {
			//step 3: add the student to the database
			 organiserDbUtil.addOrganiser(theOrganiser);
			 response.setContentType("text/html;charset=UTF-8");
			 PrintWriter out=response.getWriter();
			// step 4:	success message
			 //PrintWriter out=response.getWriter();
			 //out.println("Data Inserted Successfully!");
			 out.println("<script type=\"text/javascript\">");
			   out.println("alert('Successfully Registered');");
			   out.println("location='OrganiserLogin.jsp';");
			   out.println("</script>");
			 //response.sendRedirect("index.jsp");
			//response.sendRedirect("http://www.google.com");
		} catch (Exception e) {
			
			e.getMessage();
		}
		
	}

}
