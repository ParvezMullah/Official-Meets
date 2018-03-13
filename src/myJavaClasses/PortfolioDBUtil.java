package myJavaClasses;


import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;


import javax.sql.DataSource;

public class PortfolioDBUtil {
	DataSource datasource;
	String emailId;
	
	public PortfolioDBUtil(DataSource datasource)
	{
		this.datasource=datasource;
	}
	
	public List<Event> getPortfolioEvents(String category) throws SQLException
	{
		List<Event> Events=new ArrayList<>(); 
		
		Connection myConn=null;
		Statement myStmt=null;
		ResultSet myRs=null;
		
		try{
			// get connection
			myConn=datasource.getConnection();
			
			//create statement
			String sql="Select * from tbl_Event where category='"+category+"' order by Date";
			myStmt=myConn.createStatement();
			//execute statement
			myRs=myStmt.executeQuery(sql);
			
			// process result set 
			while(myRs.next()) {
				// retrieve all the result set row
				int eventId=myRs.getInt("eventId");
				String organiserEmail=myRs.getString("organiserEmailId");
				String Title=myRs.getString("Title");
				String Description=myRs.getString("Description");
				String Date=myRs.getString("Date");
				String Time=myRs.getString("Time");
				String Category=myRs.getString("Category");
				String Fees=myRs.getString("Fees");
				String otherInfo=myRs.getString("otherInfo");
				String Venue=myRs.getString("Venue");
				int goingCount=myRs.getInt("goingCount");
				int interestedCount=myRs.getInt("interestedCount");
				byte[] Picture=null;
			//	InputStream Picture=myRs.getBlob("profilePicture");
				// create new event object
				Event tempEvent=new Event(eventId,organiserEmail,Title,Description,Date,Time,Category,Fees,otherInfo,Venue,goingCount,interestedCount,Picture);
				
				//add it to the list of event
				Events.add(tempEvent);
			}
			return Events;
		}
		finally {
			//close JDBC
			close(myConn, myStmt, myRs);
		}		
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		try{
				if(myRs!=null) {
					myRs.close();
				}
				if(myStmt!=null) {
					myStmt.close();
				}
				if(myConn!=null) {
					myConn.close();
				}
			}
		catch(Exception exc) {
			exc.getStackTrace();
		}
		
	}
	
	public List<Event> getEventDetails(String EventId) throws SQLException, UnsupportedEncodingException
	{
		List<Event> Event=new ArrayList<>(); 
		
		Connection myConn=null;
		Statement myStmt=null;
		ResultSet myRs=null;
		
		try{
			// get connection
			myConn=datasource.getConnection();
			
			//create statement
			String sql="Select * from tbl_Event where eventId='"+EventId+"'";
			myStmt=myConn.createStatement();
			//execute statement
			myRs=myStmt.executeQuery(sql);
			
			// process result set 
			while(myRs.next()) {
				// retrieve all the result set row
				int eventId=myRs.getInt("eventId");
				String organiserEmail=myRs.getString("organiserEmailId");
				String Title=myRs.getString("Title");
				String Description=myRs.getString("Description");
				String Date=myRs.getString("Date");
				String Time=myRs.getString("Time");
				String Category=myRs.getString("Category");
				String Fees=myRs.getString("Fees");
				String otherInfo=myRs.getString("otherInfo");
				String Venue=myRs.getString("Venue");
				int goingCount=myRs.getInt("goingCount");
				int interestedCount=myRs.getInt("interestedCount");
				byte[] Picture=null;
				
				Blob imageBlob = myRs.getBlob(13);
				//Picture = imageBlob.getBinaryStream(0, imageBlob.length());
				Picture = imageBlob.getBytes(1,(int) imageBlob.length());
				byte[] encodeBase64 = Base64.getEncoder().encode(Picture);
	            String base64Encoded = new String(encodeBase64, "UTF-8");
	            //event.setBase64image(base64Encoded);
				//Picture = myRs.getBinaryStream(13);
				//InputStream Picture=(InputStream) myRs.getBlob("Picture");
				// create new event object
				Event event=new Event(eventId,organiserEmail,Title,Description,Date,Time,Category,Fees,otherInfo,Venue,goingCount,interestedCount,Picture);
				//add it to the list of event
				event.setBase64Image(base64Encoded);
				emailId=event.getOrganiserEmailId();
				Event.add(event);
			}
			return Event;
		}
		finally {
			//close JDBC
			close(myConn, myStmt, myRs);
		}		
	}
	
	public String getEmailId()
	{
		return emailId;
	}
	
	public Organiser getOrganiserDetails(String emailId) throws SQLException
	{
		Organiser organiser = null;
		Connection myConn=null;
		Statement myStmt=null;
		ResultSet myRs=null;
		
		try{
			// get connection
			myConn=datasource.getConnection();
			
			//create statement
			String sql="Select * from tbl_Organiser where emailId='"+emailId+"'";
			myStmt=myConn.createStatement();
			//execute statement
			myRs=myStmt.executeQuery(sql);
			
			// process result set 
			while(myRs.next()) {
				// retrieve all the result set row
				String email=myRs.getString("emailId");
				String firstname=myRs.getString("firstname");
				String lastname=myRs.getString("lastname");
				String organisationname=myRs.getString("organisationName");
				String designation=myRs.getString("Designation");
				String contactnumber=myRs.getString("contactNumber");
				// create new event object
				organiser=new Organiser(email,firstname,lastname,null,organisationname,contactnumber,0,null,designation);
				
			}
			return organiser;
		}
		finally {
			//close JDBC
			close(myConn, myStmt, myRs);
		}		
		//return list;
	}

}
