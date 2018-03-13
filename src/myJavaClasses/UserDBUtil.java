package myJavaClasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.sql.DataSource;

public class UserDBUtil {
	
	@Resource(name="jdbc/dbmeetUp")
	private  DataSource dataSource;
	
	public UserDBUtil(DataSource theDataSource){
		dataSource= theDataSource;
	}

	public boolean addUser(User theUser) {
		// TODO Auto-generated method stub
		Connection myConn=null;
		PreparedStatement myStmt=null;

		try{
			
			// step 1: get SQL connection
			myConn=dataSource.getConnection();
			// step 2: create SQL for insert
			String sql="insert into Users(Name,Email) values (?,?)";
			myStmt=myConn.prepareStatement(sql);
		
			//	step 3: set the parameters values for the user
			myStmt.setString(1,theUser.getName());
			myStmt.setString(2, theUser.getEmail());
			//myStmt.setString(3, theUser.getProfileUrl() );
			//myStmt.setString(3, "abcd" );
			
			//	step 4:	execute SQL query
				int act=myStmt.executeUpdate();
				if(act>0)
				{
					return true;
				}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally {
//			step 5:	cleanup JDBC object
					close(myConn, myStmt, null);
		}
		return false;
		
	}
	
	public Boolean userExists(String email)
	{
		Connection myConn=null;
		PreparedStatement myStmt=null;
		ResultSet rs=null;

		try{
			
			// step 1: get SQL connection
			myConn=dataSource.getConnection();
			// step 2: create SQL for insert
			String sql="select Id from Users where Email=?";
			myStmt=myConn.prepareStatement(sql);
		
			//	step 3: set the parameters values for the user
			myStmt.setString(1,email);
			//myStmt.setString(2, theUser.getEmail());
			//myStmt.setString(3, theUser.getProfileUrl() );
			//myStmt.setString(3, "abcd" );
			
			//	step 4:	execute SQL query
			rs=myStmt.executeQuery();
			if (!rs.isBeforeFirst() ) {    
			    return false; 
			} 
				
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally {
//			step 5:	cleanup JDBC object
					close(myConn, myStmt, rs);
		}
		return true;
	}
	
	private void close(Connection myConn,Statement myStmt,ResultSet myRs)
	{
		try {
			if(myConn!=null) {
				myConn.close();
			}
			if(myStmt!=null) {
				myStmt.close();
			}
			if(myRs!=null) {
				myRs.close();
			}
		}
		catch(Exception exc) {
			exc.getMessage();
		}
	}

	private void close(Connection myConn, PreparedStatement myStmt, ResultSet myRs) {
		// TODO Auto-generated method stub
		try {
			if(myConn!=null) {
				myConn.close();
			}
			if(myStmt!=null) {
				myStmt.close();
			}
			if(myRs!=null) {
				myRs.close();
			}
		}
		catch(Exception exc) {
			exc.getMessage();
		}
		
	}

}
