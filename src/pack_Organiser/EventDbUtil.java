package pack_Organiser;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.MultipartConfig;
import javax.sql.DataSource;
@MultipartConfig
public class EventDbUtil {
	private DataSource dataSource;
	public EventDbUtil(DataSource theDataSource) {
		dataSource=theDataSource;
	}
	
	public List<Event> getOrganiserEvents(String emailId) throws Exception{
		List<Event> Events=new ArrayList<>(); 
		
		Connection myConn=null;
		PreparedStatement myStmt=null;
		ResultSet myRs=null;
		
		try{
			// get connection
			myConn=dataSource.getConnection();
			
			//create statement
			String sql="Select * from tbl_Event where organiserEmailId=? order by EventId desc";
			myStmt=myConn.prepareStatement(sql);
			myStmt.setString(1, emailId);
			
			//execute statement
			myRs=myStmt.executeQuery();
			
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
				InputStream Picture=null;
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

	public void addEvent(Event theEvent) throws Exception {
		
		Connection myConn=null;
		PreparedStatement myStmt=null;
		
		try{
			//get DB connection
			myConn=dataSource.getConnection();
			
			//create sql for insert
			String sql="INSERT INTO tbl_event"
						+ "(organiserEmailId, Title, Description, Date, Time, Category, Fees, otherInfo, Venue, goingCount, interestedCount, Picture)"
						+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
			myStmt=myConn.prepareStatement(sql);
			
			//set the param values for the student
			myStmt.setString(1,theEvent.getOrganiserEmailId());
			myStmt.setString(2,theEvent.getTitle());
			myStmt.setString(3,theEvent.getDescription());
			myStmt.setString(4,theEvent.getDate());
			myStmt.setString(5,theEvent.getTime());
			myStmt.setString(6,theEvent.getCategory());
			myStmt.setString(7,theEvent.getFees());
			myStmt.setString(8,theEvent.getOtherInfo());
			myStmt.setString(9,theEvent.getVenue());
			myStmt.setInt(10,theEvent.getGoingCount());
			myStmt.setInt(11,theEvent.getInterestedCount());
			myStmt.setBlob(12,theEvent.getPicture());
			
			//execute SQL insert
			myStmt.execute();
		}
		finally {
			// clean up JDBC
			close(myConn,myStmt,null);
		}
		
		
	}

	public Event getEvents(String theEventId) throws Exception{
		Event theEvent=null;
		
		Connection myConn=null;
		PreparedStatement myStmt =null;
		ResultSet myRs=null;
		int eventId;
		
		try {
			//convert event id into int
			eventId=Integer.parseInt(theEventId);			
			//get connection to database
			myConn=dataSource.getConnection();
			//create prepared statement
			String sql="Select * from tbl_event where eventId=?";
			myStmt=myConn.prepareStatement(sql);
			//set params
			myStmt.setInt(1, eventId);
			//execute statement
			myRs=myStmt.executeQuery();
			// retrive data from result set row
			if(myRs.next()) {
				String organiserEmailId=myRs.getString("organiserEmailId");
				int goingCount=myRs.getInt("goingCount");
				int interestedCount=myRs.getInt("interestedCount");
				String Title=myRs.getString("Title");
				String Description=myRs.getString("Description");
				String Date=myRs.getString("Date");
				String Time=myRs.getString("Time");
				String Category=myRs.getString("Category");
				String fees=myRs.getString("Fees");
				String otherInfo=myRs.getString("otherInfo");
				String Venue=myRs.getString("Venue");
				Blob Picture= myRs.getBlob("Picture");
				// use eventId during construction
				theEvent=new Event(eventId,organiserEmailId,Title,Description,Date,Time,Category,fees,otherInfo, Venue, goingCount, interestedCount, Picture);
			}
		}
		finally {
			close(myConn,myStmt,myRs);
		}
		
		return theEvent;
	}


	public void updateEvent(Event theEvent) throws Exception {

		Connection myConn=null;
		PreparedStatement myStmt =null;
		
		try {	
			//get connection to database
			myConn=dataSource.getConnection();
			//create prepared statement
			String sql="update tbl_event "
					+ "set organiserEmailId=?, Title=?, Description=?, Date=?, Time=?, Category=?, "
					+ "Fees=?, otherInfo=?, Venue=?, goingCount=?, interestedCount=?, Picture=? "
					+ "where eventId=?";
			
			String sql1="update tbl_event "
					+ "set organiserEmailId=?, Title=?, Description=?, Date=?, Time=?, Category=?, "
					+ "Fees=?, otherInfo=?, Venue=?, goingCount=?, interestedCount=? "
					+ "where eventId=?";
			
		if(theEvent.getPicture()!=null) {
			myStmt=myConn.prepareStatement(sql);
			//set params
			myStmt.setString(1,theEvent.getOrganiserEmailId());
			myStmt.setString(2,theEvent.getTitle());
			myStmt.setString(3,theEvent.getDescription());
			myStmt.setString(4,theEvent.getDate());
			myStmt.setString(5,theEvent.getTime());
			myStmt.setString(6,theEvent.getCategory());
			myStmt.setString(7,theEvent.getFees());
			myStmt.setString(8,theEvent.getOtherInfo());
			myStmt.setString(9,theEvent.getVenue());
			myStmt.setInt(10,theEvent.getGoingCount());
			myStmt.setInt(11,theEvent.getInterestedCount());
			myStmt.setBlob(12,theEvent.getPicture());
			myStmt.setInt(13, theEvent.getEventId());
			System.out.println(theEvent.getPicture());
			myStmt.execute();
		}
		else {
			myStmt=myConn.prepareStatement(sql1);
			//set params
			myStmt.setString(1,theEvent.getOrganiserEmailId());
			myStmt.setString(2,theEvent.getTitle());
			myStmt.setString(3,theEvent.getDescription());
			myStmt.setString(4,theEvent.getDate());
			myStmt.setString(5,theEvent.getTime());
			myStmt.setString(6,theEvent.getCategory());
			myStmt.setString(7,theEvent.getFees());
			myStmt.setString(8,theEvent.getOtherInfo());
			myStmt.setString(9,theEvent.getVenue());
			myStmt.setInt(10,theEvent.getGoingCount());
			myStmt.setInt(11,theEvent.getInterestedCount());
			myStmt.setInt(12, theEvent.getEventId());
			myStmt.execute();
		}
			
		}
		finally {
			close(myConn,myStmt,null);
		}
	}

	public void deleteEvents(String theEventId) throws Exception {
		Connection myConn=null;
		PreparedStatement myStmt =null;
		
		try {	
			int eventId=Integer.parseInt(theEventId);
			myConn=dataSource.getConnection();
			String sql="delete from tbl_event where eventId=?";
			myStmt=myConn.prepareStatement(sql);
			myStmt.setInt(1, eventId);
			myStmt.execute();
		}
		finally {
			close(myConn,myStmt,null);
		}
		
	}

	public Map<String,String> getEventGoingStatus(String theEventId, String organiserEmailId) {
		// TODO Auto-generated method stub
		Connection myConn=null;
		PreparedStatement myStmt =null;
		ResultSet myRs=null;
		Map<String,String> status = null;
		int eventId;
		try {
			//convert event id into int
			eventId=Integer.parseInt(theEventId);			
			//get connection to database
			myConn=dataSource.getConnection();
			//create prepared statement
			String sql="select Users.Name,Users.Email from Users,tbl_eventgoing,tbl_event where tbl_eventgoing.eventId=tbl_event.eventId and tbl_eventgoing.userEmail=Users.Email and tbl_event.organiserEmailId=? and tbl_event.eventId=?;";
			myStmt=myConn.prepareStatement(sql);
			myStmt.setString(1, organiserEmailId);
			myStmt.setInt(2, eventId);
			//execute statement
			myRs=myStmt.executeQuery();
			status=new HashMap<String,String>();
			// retrive data from result set row
			while(myRs.next()) {
				System.out.println(myRs.getString(2));
				status.put(myRs.getString(1), myRs.getString(2));
			}
			return status;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally {
			close(myConn,myStmt,null);
		}
		return null;
	}

	public Map<String, String> getEventInterestedStatus(String theEventId, String organiserEmailId) {
		// TODO Auto-generated method stub
		Connection myConn=null;
		PreparedStatement myStmt =null;
		ResultSet myRs=null;
		Map<String,String> status = null;
		int eventId;
		try {
			//convert event id into int
			eventId=Integer.parseInt(theEventId);			
			//get connection to database
			myConn=dataSource.getConnection();
			//create prepared statement
			String sql="select Users.Name,Users.Email from Users,tbl_eventinterested,tbl_event where tbl_eventinterested.eventId=tbl_event.eventId and tbl_eventinterested.userEmail=Users.Email and tbl_event.organiserEmailId=? and tbl_event.eventId=?;";
			myStmt=myConn.prepareStatement(sql);
			myStmt.setString(1, organiserEmailId);
			myStmt.setInt(2, eventId);
			//execute statement
			myRs=myStmt.executeQuery();
			status=new HashMap<String,String>();
			// retrive data from result set row
			while(myRs.next()) {
				System.out.println(myRs.getString(2));
				status.put(myRs.getString(1), myRs.getString(2));
			}
			return status;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally {
			close(myConn,myStmt,null);
		}
		return null;
	}
}
























