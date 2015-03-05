package com.ts.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.log4j.Logger;

import com.ts.beans.UserBean;
import com.ts.exception.OrderManagementException;

public class UserDAO {
	
	static final String SUCCESS = "success";
	static final String FAILURE = "failure";
	
	static Logger log = Logger.getLogger("com.a");
	
	public UserDAO(){
		
	}
	
	/**
	 * Checks whether user exists in the database as per Username and Password
	 * @param user of type UserBean
	 * @return - Success or Failure
	 */
	public String checkUser(UserBean user)throws OrderManagementException{
	
		String result = null;
	
	//Create a Database Connection
	Connection con = DBConnectionManager.getSimpleConnection();

	Statement st = null;
	ResultSet rs = null;

	
	try{
				st = con.createStatement();
		rs = st.executeQuery("select * from customer where username = '"+ user.getUsername() +
				"' and password = '"+ user.getPassword() + "'");
				
		while (rs.next()){	
			user.setCustomerid(Integer.parseInt(rs.getString("customerid")));
			user.setCustomername(rs.getString("customername"));
			user.setAddress(rs.getString("address"));
			user.setAge(Integer.parseInt(rs.getString("age")));
			user.setPassword(rs.getString("password"));			
			user.setUsername(rs.getString("username"));
			user.setPhoneno(rs.getString("phoneno"));
			user.setRole(rs.getInt("role"));
			result = SUCCESS;
		}
	}catch (SQLException ex){
		result = FAILURE;
		log.error(ex);
	}
	catch (Exception e){
		result = FAILURE;
		e.printStackTrace();
	}
	finally{
		try {
			con.close();
			log.info("Connection closed Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("Closing Connection failed");
		}
	}
	return result;	
	}
	
	/**
	 * Insert a user in the database
	 * @param newUser of type UserBean
	 * @return Success/ Failure
	 */
	public String createUser(UserBean newUser)throws OrderManagementException{
		
		String result = null;
		PreparedStatement stmtInsert = null;
		
		//Create a Database Connection
		Connection con = DBConnectionManager.getSimpleConnection();
		try{
			//con.setAutoCommit(false);
					
			StringBuffer sbInsert = new StringBuffer();
											
			sbInsert.append("INSERT INTO ");
			//TABLE_NAME
			sbInsert.append("customer");
			sbInsert.append(" ( username, password ) ");
			sbInsert.append(" VALUES (");
			sbInsert.append(" ?, ?) ");
			
			stmtInsert = con.prepareStatement(sbInsert.toString());
			
			stmtInsert.setString(1, newUser.getUsername());
			stmtInsert.setString(2, newUser.getPassword());
			
			
			
			int rows = stmtInsert.executeUpdate();
			
			if (rows != 1){
				result = FAILURE;
				throw new SQLException(
					"executeUpdate return value: "
					+ rows);
			}	
			result = SUCCESS;				
		}catch (SQLException ex){
			result = FAILURE;
			log.error(ex);
		}
		finally
		{
			try {
				con.close();
				log.info("connection closed successfully");
			} catch (SQLException e) {
				e.printStackTrace();
				log.error("connection to database failed...");
			}
		}
		return result;	
		
	}

	/**
	 *Returns a collection of Users from the database
	 * @return collection of UserBean
	 */
	public Collection<UserBean> selectUsers() throws OrderManagementException{
		Collection<UserBean> users = new ArrayList<UserBean> ();
		
		//Create a Database Connection
		Connection con = DBConnectionManager.getSimpleConnection();		
		Statement st = null;
		ResultSet rs = null;
	
		
		try{
			//con.setAutoCommit(false);
			st = con.createStatement();
	
			rs = st.executeQuery("select * from customer") ;
					
			while (rs.next()){
				UserBean userBean = new UserBean();
				userBean.setCustomername(rs.getString("customername"));
				userBean.setAddress(rs.getString("address"));
				userBean.setAge(Integer.parseInt(rs.getString("age")));
				userBean.setPassword(rs.getString("password"));			
				userBean.setUsername(rs.getString("username"));
				userBean.setPhoneno(rs.getString("phoneno"));
				userBean.setCustomerid(Integer.parseInt(rs.getString("customerid")));
				users.add(userBean);					
			}
									
		}catch (SQLException ex){
			log.error(ex);
		}
		finally
		{
			try {
				con.close();
				log.info("DB Connection Closed successfully");
			} catch (SQLException e) {
				log.error("Connection to DB failed...");
				e.printStackTrace();
			}
		}
		
				
		return users;
		
	}
	
	/**
	 * Updates user information in the database 
	 * @param user of type UserBean
	 * @return - Success or Failure
 */
	public String updateUser(UserBean user)throws OrderManagementException{
		
		String result = null;
		PreparedStatement stmtUpdate = null;
		
		//Create a Database Connection
		Connection con = DBConnectionManager.getSimpleConnection();
		try{
			//con.setAutoCommit(false);
					
			StringBuffer sbUpdate = new StringBuffer();
			
			sbUpdate.append("UPDATE customer SET ");
			
			
			sbUpdate.append(" customername = '" + user.getCustomername() + "', ");
			sbUpdate.append(" password = '" + user.getPassword() + "', ");
			sbUpdate.append(" age = '" + user.getAge() + "', ");
			sbUpdate.append(" phoneno = '" + user.getPhoneno() + "', ");
			sbUpdate.append(" address = '" + user.getAddress() + "' ");
			sbUpdate.append(" WHERE username = '" + user.getUsername() + "'");
			
			stmtUpdate = con.prepareStatement(sbUpdate.toString());
			
			int rows = stmtUpdate.executeUpdate();
			
			if (rows != 1){
				result = FAILURE;
				log.error("Execute update error for user "+ user.getCustomername());
				throw new SQLException(
					"executeUpdate return value: "
					+ rows);
			}	
			log.info("Updating UserInfo  " + user.getUsername());
			result = SUCCESS;
			
		}catch (SQLException ex){
			result = FAILURE;
			log.error(ex);
		}
		finally{
			try {
				con.close();
				log.info("DB Connection Closed Successfully");
			} catch (SQLException e) {
				e.printStackTrace();
				log.error("Closing DB Connection Failed");
			}
		}
		return result;	
	}
}
