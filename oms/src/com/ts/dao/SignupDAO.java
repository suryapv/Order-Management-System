package com.ts.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.Collection;

import com.ts.dao.DBConnectionManager;
import com.ts.exception.ProjectApplicationException;
import com.ts.beans.UserBean; 


import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.PropertyConfigurator;

public class SignupDAO {
	static final String SUCCESS = "success";
	static final String FAILURE = "failure";
	
	static Logger log = Logger.getLogger("com.a");
	
	public String createUser(UserBean newUser)throws ProjectApplicationException{
		
		String result = null;
		PreparedStatement stmtInsert = null;
		
		//Create a Database Connection
		Connection con = DBConnectionManager.getSimpleConnection();
		try{
//			con.setAutoCommit(false);
					
			StringBuffer sbInsert = new StringBuffer();
											
			sbInsert.append("INSERT INTO ");
			//TABLE_NAME
			sbInsert.append("signup");
			sbInsert.append(" (email, password) ");
			sbInsert.append(" VALUES (");
			sbInsert.append("?, ?) ");
			
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
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;	
		
	}
}
