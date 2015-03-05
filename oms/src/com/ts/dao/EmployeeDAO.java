package com.ts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.log4j.Logger;

import com.ts.beans.EmployeeBean;

public class EmployeeDAO {

	static final String SUCCESS = "success";
	static final String FAILURE = "failure";
	
	static Logger log = Logger.getLogger("com.a");
	
	public String createEmployee(EmployeeBean newEmp){
		
		String result = null;
		PreparedStatement stmtInsert = null;
		
		//Create a Database Connection
		Connection con = DBConnectionManager.getJDBCConnection();
		try{
			//con.setAutoCommit(false);
					
			/*StringBuffer sbInsert = new StringBuffer();
											
			sbInsert.append("INSERT INTO ");
			//TABLE_NAME
			sbInsert.append("employee");
			sbInsert.append(" ( empname, emailid, address, deptno ) ");
			sbInsert.append(" VALUES (");
			sbInsert.append(" ?, ?, ?, ?) ");
			
			stmtInsert = con.prepareStatement(sbInsert.toString());*/
			stmtInsert = con.prepareStatement("INSERT INTO employee(empname,emailid,address,deptno) VALUES(?,?,?,?)");
			stmtInsert.setString(1, newEmp.getEmpname());
			stmtInsert.setString(2, newEmp.getEmailid());
			stmtInsert.setString(3, newEmp.getAddress());
			stmtInsert.setString(4, Integer.toString(newEmp.getDeptno()));
						
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
			System.err.println(ex);
		}
		finally
		{
			try {
				con.close();
				System.out.println("connection closed successfully");
			} catch (SQLException e) {
				e.printStackTrace();
				System.err.println("connection to database failed...");
			}
		}
		return result;	
		
	}
	
	public Collection<EmployeeBean> selectEmployees() {
		Collection<EmployeeBean> employees = new ArrayList<EmployeeBean>();
		
		//Create a Database Connection
		Connection con = DBConnectionManager.getJDBCConnection();		
		Statement st = null;
		ResultSet rs = null;

		
		try{
		//	con.setAutoCommit(false);
			st = con.createStatement();

			rs = st.executeQuery("select * from employee") ;
					
			while (rs.next()){
				EmployeeBean empBean = new EmployeeBean();
				
				empBean.setEmpname(rs.getString("empname"));
				empBean.setEmailid(rs.getString("emailid"));
				empBean.setAddress(rs.getString("address"));		
				empBean.setDeptno(Integer.parseInt(rs.getString("deptno")));	
				employees.add(empBean);					
			}
									
		}catch (SQLException ex){
			System.err.println(ex);
		}
		finally
		{
			try {
				con.close();
				System.out.println("DB Connection Closed successfully");
			} catch (SQLException e) {
				System.err.println("Connection to DB failed...");
				e.printStackTrace();
			}
		}
		
				
		return employees;
		
	}
	
	public String updateEmployee(EmployeeBean emp){
		
		String result = null;
		PreparedStatement stmtUpdate = null;
		
		//Create a Database Connection
		Connection con = DBConnectionManager.getJDBCConnection();
		try{
			//con.setAutoCommit(false);
					
			StringBuffer sbUpdate = new StringBuffer();
			
			sbUpdate.append("UPDATE employee SET ");
			
			
			sbUpdate.append(" emailid = '" + emp.getEmailid() + "' , ");
			sbUpdate.append(" address = '" + emp.getAddress() + "' , ");
			sbUpdate.append(" deptno = " + emp.getDeptno());
			sbUpdate.append(" WHERE empname = '" + emp.getEmpname()+"'");
						
			stmtUpdate = con.prepareStatement(sbUpdate.toString());
			
			int rows = stmtUpdate.executeUpdate();
			
			if (rows != 1){
				result = FAILURE;
				System.err.println("Execute update error for department "+ emp.getDeptno());
				throw new SQLException(
					"executeUpdate return value: "
					+ rows);
			}	
			
			result = SUCCESS;
			
		}catch (SQLException ex){
			result = FAILURE;
			System.err.println(ex);
		}
		finally{
			try {
				con.close();
				System.out.println("DB Connection Closed Successfully");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Closing DB Connection Failed");
			}
		}
		return result;	
	}
	
	public String deleteEmployee(String empname){
		
		String result = null;
		Statement st = null;
		
		//Create a Database Connection
		Connection con = DBConnectionManager.getJDBCConnection();
		try{
			//con.setAutoCommit(false);
			st = con.createStatement();
	
			int row = st.executeUpdate("delete from employee where empname = '"+ empname +"'") ;
			if(row != 0){
				System.out.println("Deleted Employee : " + empname );
				result = SUCCESS;
			}else{
				result = FAILURE;
			}
						
		}catch (SQLException ex){
			result = FAILURE;
			System.err.println(ex);
		}
		finally
		{
			try {
				con.close();
				System.out.println("connection closed successfully");
			} catch (SQLException e) {
				e.printStackTrace();
				System.err.println("connection to database failed...");
			}
		}
		return result;	
		
	}
}
