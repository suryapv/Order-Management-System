package com.ts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.log4j.Logger;

import com.ts.beans.OrderBean;
import com.ts.exception.OrderManagementException;

public class OrderDAO {
	static final String SUCCESS = "success";
	static final String FAILURE = "failure";
	
	static Logger log = Logger.getLogger("com.a");
	
	public OrderDAO(){
		
	}
	
	public String createOrder(OrderBean newOrder)throws OrderManagementException{
		
		String result = null;
		PreparedStatement stmtInsert = null;
		
		//Create a Database Connection
		Connection con = DBConnectionManager.getSimpleConnection();
		try{
			//con.setAutoCommit(false);
					
			StringBuffer sbInsert = new StringBuffer();
											
			sbInsert.append("INSERT INTO ");
			//TABLE_NAME
			sbInsert.append("orderDetails");
			sbInsert.append(" ( productname, orderdate, customername , shippingdate , phoneno) ");
			sbInsert.append(" VALUES (");
			sbInsert.append(" ?, NOW(), ?, (CURDATE()), ?) ");
			
			stmtInsert = con.prepareStatement(sbInsert.toString());
			
			
			stmtInsert.setString(1, newOrder.getProductname());
			stmtInsert.setString(2, newOrder.getCustomername());
			stmtInsert.setString(3, newOrder.getPhoneno());
			
			
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
	public String updateOrder(OrderBean order) {

		String result = null;
		PreparedStatement stmtUpdate = null;

		// Create a Database Connection
		Connection con = DBConnectionManager.getSimpleConnection();
		try {
//			con.setAutoCommit(false);

			StringBuffer sbUpdate = new StringBuffer();

			sbUpdate.append("UPDATE orderDetails SET ");
			sbUpdate.append(" productname = '" + order.getProductname() + "',");
			sbUpdate.append(" datee = '" + order.getOrderdate() + "',");
			sbUpdate.append(" customername = '" + order.getCustomername() + "',");
			sbUpdate.append(" shippingdate = '" + order.getShippingdate() + "'");
			sbUpdate.append(" WHERE orderno = '" + order.getOrderid() + "'");

			stmtUpdate = con.prepareStatement(sbUpdate.toString());

			int rows = stmtUpdate.executeUpdate();

			if (rows != 1) {
				result = FAILURE;
				System.err.println("Execute update error for department "
						+ order.getOrderid());
				throw new SQLException("executeUpdate return value: " + rows);
			}

			result = SUCCESS;

		} catch (SQLException ex) {
			result = FAILURE;
			System.err.println(ex);
		} finally {
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

	public Collection<OrderBean> selectOrder() {
		Collection<OrderBean> Orders = new ArrayList<OrderBean>();

		// Create a Database Connection
		Connection con = DBConnectionManager.getSimpleConnection();
		Statement st = null;
		ResultSet rs = null;

		try {
			//con.setAutoCommit(false);
			st = con.createStatement();

			rs = st.executeQuery("select * from orderDetails");

			while (rs.next()) {
				OrderBean orderBean = new OrderBean();
				orderBean.setOrderid(rs.getInt("orderid"));
				orderBean.setProductname(rs.getString("productname"));
				orderBean.setOrderdate(rs.getString("orderdate"));
				orderBean.setCustomername(rs.getString("Customername"));
				orderBean.setShippingdate(rs.getString("shippingdate"));
				orderBean.setPhoneno(rs.getString("phoneno"));
				Orders.add(orderBean);
			}

		} catch (SQLException ex) {
			System.err.println(ex);
		} finally {
			try {
				con.close();
				System.out.println("DB Connection Closed successfully");
			} catch (SQLException e) {
				System.err.println("Connection to DB failed...");
				e.printStackTrace();
			}
		}

		return Orders;

	}
	public Collection<OrderBean> selectOrder1() {
		Collection<OrderBean> Orders = new ArrayList<OrderBean>();

		// Create a Database Connection
		Connection con = DBConnectionManager.getSimpleConnection();
		Statement st = null;
		ResultSet rs = null;

		try {
			//con.setAutoCommit(false);
			st = con.createStatement();

			rs = st.executeQuery("SELECT * FROM orderdetails WHERE orderid NOT IN (SELECT orderid FROM shipping) ");

			while (rs.next()) {
				OrderBean orderBean = new OrderBean();
				orderBean.setOrderid(rs.getInt("orderid"));
				orderBean.setProductname(rs.getString("productname"));
				orderBean.setOrderdate(rs.getString("orderdate"));
				orderBean.setCustomername(rs.getString("Customername"));
				orderBean.setShippingdate(rs.getString("shippingdate"));
				orderBean.setPhoneno(rs.getString("phoneno"));
				Orders.add(orderBean);
			}

		} catch (SQLException ex) {
			System.err.println(ex);
		} finally {
			try {
				con.close();
				System.out.println("DB Connection Closed successfully");
			} catch (SQLException e) {
				System.err.println("Connection to DB failed...");
				e.printStackTrace();
			}
		}

		return Orders;

	}

	public String deleteOrder(String orderno){
		
		String result = null;
		Statement st = null;
		
		//Create a Database Connection
		Connection con = DBConnectionManager.getSimpleConnection();
		try{
	//		con.setAutoCommit(false);
			st = con.createStatement();
	
			int row = st.executeUpdate("delete from orderDetails where orderno = '"+ orderno +"'") ;
			if(row != 0){
				System.out.println("Deleted Department  " + orderno );
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
				log.info("connection to database failed...");
			}
		}
		return result;	
		
	}
}
