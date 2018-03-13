package myJavaClasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class UpdateTableDBUtil {
	DataSource datasource;
	
	public UpdateTableDBUtil(DataSource datasource)
	{
		this.datasource=datasource;
	}
	
	public int updateCount(int eventId, String tblColumn) throws SQLException
	{
		Connection myConn=null;
		PreparedStatement myStmt=null;
		//PreparedStatement myStmt2=null;
		//boolean count=false;
		try{
			
			// step 1: get SQL connection
			myConn=datasource.getConnection();
			//update value in table
			String sql="update tbl_event set "+tblColumn+"="+tblColumn+"+1 where eventId=?;";
			myStmt=myConn.prepareStatement(sql);
			myStmt.setInt(1, eventId);
			//myStmt2.setInt(2, eventId);
			if(myStmt.execute()) {
				//myStmt2.close();
				return 5;
				}
				else
				{
					return 0;
				}
			//}
			
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		finally
		{
			close(myConn, myStmt);
		}
		return -2;
	}

	public int updateTable(int eventid, String uname, String tableName) throws SQLException {
		// TODO Auto-generated method stub
		
		Connection myConn=null;
		PreparedStatement myStmt=null;
		try{
		int count=0;
		
			
			// step 1: get SQL connection
			myConn=datasource.getConnection();
			// step 2: create SQL for insert
			String sql="insert into "+tableName+" values(?,?);";
			System.out.print("stmt");
			myStmt=myConn.prepareStatement(sql);
			System.out.print("stmt prepared");
			//myStmt.setString(1, tableName);
			myStmt.setInt(1,eventid);
			myStmt.setString(2, uname);
			System.out.print("stmt set");
			count=myStmt.executeUpdate();
				//count=myStmt.getUpdateCount();
				System.out.print("stmt executed");
				return count;
		}
		catch(Exception e)
		{
			System.out.print(e.getMessage());
		}
		finally
		{
			close(myConn, myStmt);
		}
		return -2;
	}

	

	public String getState(int eid, String uname) {
		// TODO Auto-generated method stub
		Connection myConn=null;
		PreparedStatement myStmt=null;
		//PreparedStatement myStmt2=null;
		//boolean count=false;
		try{
			
			// step 1: get SQL connection
			myConn=datasource.getConnection();
			// step 2: create SQL for insert
			//get value from table
			//int value=0;
			String sqlGet="select userEmail from tbl_eventgoing where eventId=? and userEmail=?;";
			myStmt=myConn.prepareStatement(sqlGet);
			myStmt.setInt(1, eid);
			myStmt.setString(2, uname);
			ResultSet rs=myStmt.executeQuery();
			if(rs.next())
			{
				return "Going";
			}
			else
			{
				myStmt.close();
				rs.close();
				sqlGet="select eventId from tbl_eventinterested where eventId=? and userEmail=?;";
				myStmt=myConn.prepareStatement(sqlGet);
				myStmt.setInt(1, eid);
				myStmt.setString(2, uname);
				rs=myStmt.executeQuery();
				if(rs.next())
				{
					return "Interested";
				}
			}
		}
		catch(Exception e)
		{
			System.out.print(e.getMessage());
		}
		return "none";
	}
	private void close(Connection myConn, PreparedStatement myStmt) throws SQLException {
		// TODO Auto-generated method stub
		myConn.close();
		myStmt.close();
	}

}
