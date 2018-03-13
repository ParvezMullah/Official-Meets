package pack_Organiser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.annotation.Resource;
import javax.sql.DataSource;

public class OrganiserDbUtil {
	@Resource(name="jdbc/dbmeetUp")
	private  DataSource dataSource;
	
	OrganiserDbUtil(DataSource theDataSource){
		dataSource= theDataSource;
	}

	public  void addOrganiser(Organiser theOrganiser) throws Exception {
		
		Connection myConn=null;
		PreparedStatement myStmt=null;

		try{
			
			// step 1: get SQL connection
			myConn=dataSource.getConnection();
			// step 2: create SQL for insert
			String sql="insert into tbl_organiser"
						+ "(emailId,firstName,lastName,Password,organisationName,contactNumber,isLoginable,Designation,profileLink)"
						+ "values (?,?,?,?,?,?,?,?,?)";
			myStmt=myConn.prepareStatement(sql);
		
			//	step 3: set the parameters values for the student
			myStmt.setString(1,theOrganiser.getEmailId());
			myStmt.setString(2, theOrganiser.getFirstName());
			myStmt.setString(3, theOrganiser.getLastName() );
			myStmt.setString(4, theOrganiser.getPassword());
			myStmt.setString(5, theOrganiser.getOrganizationName());
			myStmt.setString(6, theOrganiser.getContactNumber());
			myStmt.setInt(7, theOrganiser.getIsLoginable());
			myStmt.setString(8, theOrganiser.getDesignation());
			myStmt.setBlob(9, theOrganiser.getProfilePicture());
			
			//	step 4:	execute SQL query
				myStmt.execute();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally {
//			step 5:	cleanup JDBC object
					close(myConn, myStmt, null);
		}
	}

	private static void close(Connection myConn, PreparedStatement myStmt, ResultSet myRs) {
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
