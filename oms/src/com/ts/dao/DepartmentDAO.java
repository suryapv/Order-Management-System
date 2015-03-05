package com.ts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.log4j.Logger;

import com.ts.beans.DepartmentBean;


public class DepartmentDAO {

	static final String SUCCESS = "success";
	static final String FAILURE = "failure";
	
	static Logger log = Logger.getLogger("com.a");
	
	
	public DepartmentDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String createDepartment(DepartmentBean newDept){
		
		String result = null;
		PreparedStatement stmtInsert = null;
		
		//Create a Database Connection
		Connection con = DBConnectionManager.getJDBCConnection();
		try{
			System.out.println("insert dao1");
			//con.setAutoCommit(false);
				System.out.println("database");	
			/*StringBuffer sbInsert = new StringBuffer();
			//String s = "INSERT INTO department(deptno,deptname,totalmembers) VALUES(?,?,?)";								
			sbInsert.append("INSERT INTO ");
			//TABLE_NAME
			sbInsert.append("department");
			sbInsert.append(" ( deptno, deptname, totalmembers ) ");
			sbInsert.append(" VALUES (");
			sbInsert.append(" ?, ?, ?) ");
			
			stmtInsert = con.prepareStatement(sbInsert.toString());*/
				 stmtInsert = con.prepareStatement("INSERT INTO department(deptno,deptname,totalmembers) VALUES(?,?,?)");
			System.out.print(newDept.getDeptno()+","+newDept.getDeptname()+","+newDept.getTotalmembers());
			stmtInsert.setInt(1, newDept.getDeptno());
			stmtInsert.setString(2, newDept.getDeptname());
			stmtInsert.setInt(3, newDept.getTotalmembers());
						
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
		return result;	
		
	}
	
	public Collection<DepartmentBean> selectDepartments() {
		Collection<DepartmentBean> departments = new ArrayList<DepartmentBean>();
		
		//Create a Database Connection
		Connection con = DBConnectionManager.getJDBCConnection();		
		Statement st = null;
		ResultSet rs = null;

		
		try{
		//	con.setAutoCommit(false);
			st = con.createStatement();

			rs = st.executeQuery("select * from department") ;
					
			while (rs.next()){
				DepartmentBean deptBean = new DepartmentBean();
				deptBean.setDeptno(Integer.parseInt(rs.getString("deptno")));
				deptBean.setDeptname(rs.getString("deptname"));
				deptBean.setTotalmembers(Integer.parseInt(rs.getString("totalmembers")));			
				departments.add(deptBean);					
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
		
				
		return departments;
		
	}
	
	
	public String updateDepartment(DepartmentBean dept){
		
		String result = null;
		PreparedStatement stmtUpdate = null;
		
		//Create a Database Connection
		Connection con = DBConnectionManager.getJDBCConnection();
		try{
			//con.setAutoCommit(false);
					
			StringBuffer sbUpdate = new StringBuffer();
			System.out.print("arg0");
			sbUpdate.append("UPDATE department SET ");
			
			sbUpdate.append(" deptno = " + dept.getDeptno() + ",");
			sbUpdate.append(" totalmembers = " + dept.getTotalmembers());
			sbUpdate.append(" WHERE deptname = '" + dept.getDeptname()+"'");
						
			stmtUpdate = con.prepareStatement(sbUpdate.toString());
			
			int rows = stmtUpdate.executeUpdate();
			
			if (rows != 1){
				result = FAILURE;
				System.err.println("Execute update error for department "+ dept.getDeptno());
				throw new SQLException(
					"executeUpdate return value: "
					+ rows);
			}	
			
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
	
	public String deleteDepartment(String deptno){
		
		String result = null;
		Statement st = null;
		
		//Create a Database Connection
		Connection con = DBConnectionManager.getJDBCConnection();
		try{
			//con.setAutoCommit(false);
			st = con.createStatement();
	
			int row = st.executeUpdate("delete from department where deptno = '"+ deptno +"'") ;
			if(row != 0){
				System.out.println("Deleted Department  " + deptno );
				result = SUCCESS;
			}else{
				result = FAILURE;
			}
						
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
}
