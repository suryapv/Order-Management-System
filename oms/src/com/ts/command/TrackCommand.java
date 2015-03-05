package com.ts.command;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ts.beans.DepartmentBean;
import com.ts.dao.DBConnectionManager;

public class TrackCommand implements Command {
	
	static Logger log = Logger.getLogger("com.a");
	
	/**
	* Completes the request to insert, update, delete or view all user
	* as per the 'action' defined in the request parameter
	*/
			
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String orderid = request.getParameter("orderid");
		
		Connection con = DBConnectionManager.getJDBCConnection();		
		Statement st = null;
		ResultSet rs = null;
		int count = 0;

		
		try{
		//	con.setAutoCommit(false);
			st = con.createStatement();

			rs = st.executeQuery("select orderid  from shipping where orderid ="+ orderid) ;
					
			while (rs.next()){
			count++;
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
		PrintWriter out = response.getWriter();
		if(count == 0)
			out.println("<h1>Your order has been Delivered");
		else
			out.println("<h1>Your order is in shipping department. Will be delivered in 2 days");
		
	}

		
		
		

	

}


