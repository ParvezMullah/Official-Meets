package pack_Organiser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

public class OrganiserLoginUtil {
	private DataSource dataSource;
	public OrganiserLoginUtil(DataSource thedataSource) {
		dataSource=thedataSource;
		
	}

	public boolean checkLogin(OrganiserLogin organiserLogin) {
		Connection myConn=null;
		PreparedStatement myStmt=null;
		ResultSet myRs=null;
		boolean status=false;

		try{
			
			// step 1: get SQL connection
			myConn=dataSource.getConnection();
			// step 2: create SQL for insert
			String sql="select * from tbl_organiser where emailId=? and Password=? ";
			myStmt=myConn.prepareStatement(sql);
		
			//	step 3: set the parameters values for the student
			myStmt.setString(1,organiserLogin.getEmailId());
			myStmt.setString(2, organiserLogin.getPassword());
			myRs=myStmt.executeQuery();
			status=myRs.next();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally {
//			step 5:	cleanup JDBC object
					close(myConn, myStmt, myRs);
		}
		return status;
	}

	private void close(Connection myConn, PreparedStatement myStmt, ResultSet myRs) {
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
