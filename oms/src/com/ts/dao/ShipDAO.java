package com.ts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.log4j.Logger;

import com.ts.beans.ShipBean;

public class ShipDAO {
	
	// Check log4j.properties in WEB-INF folder
	static Logger log = Logger.getLogger("com.a");
	
	static final String SUCCESS = "success";
	static final String FAILURE = "failure";

	public String addShip(ShipBean newShi) {

		String result = null;
		PreparedStatement stmtInsert = null;

		// Create a Database Connection
		Connection con = DBConnectionManager.getSimpleConnection();
		try {
			//con.setAutoCommit(false);

			StringBuffer sbInsert = new StringBuffer();

			sbInsert.append("INSERT INTO ");
			// TABLE_NAME
			sbInsert.append("shipping");
			sbInsert.append(" ( orderid, productname, shipmentno, dateshipped, shippedby, customername, phoneno ) ");
			sbInsert.append(" VALUES (");
			sbInsert.append(" ?, ?, ?, ?, ? ,?, ?) ");

			stmtInsert = con.prepareStatement(sbInsert.toString());
			System.out.println(newShi.getProductname());
			stmtInsert.setString(1, Integer.toString(newShi.getOrderid()));
			stmtInsert.setString(2, newShi.getProductname());
			stmtInsert.setString(3, Integer.toString(newShi.getShipmentno()));
			stmtInsert.setString(4, newShi.getDateshipped());
			stmtInsert.setString(5, newShi.getShippedby());
			stmtInsert.setString(6, newShi.getCustomername());
			stmtInsert.setString(7, newShi.getPhoneno());

			int rows = stmtInsert.executeUpdate();

			if (rows != 1) {
				result = FAILURE;
				throw new SQLException("executeUpdate return value: " + rows);
			}
			result = SUCCESS;
		} catch (SQLException ex) {
			result = FAILURE;
			System.err.println(ex);
		} finally {
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

	public String updateShip(ShipBean Shi) {

		String result = null;
		PreparedStatement stmtUpdate = null;

		// Create a Database Connection
		Connection con = DBConnectionManager.getSimpleConnection();
		try {
	//		con.setAutoCommit(false);

			StringBuffer sbUpdate = new StringBuffer();

			sbUpdate.append("UPDATE shipping SET ");
		
			sbUpdate.append(" shipmentno = '" + Shi.getShipmentno() + "',");
			sbUpdate.append(" dateshipped = '" + Shi.getDateshipped() + "',");
			sbUpdate.append(" shippedby = '" + Shi.getShippedby() + "',");
			sbUpdate.append(" customername = '" + Shi.getCustomername() + "',");
			sbUpdate.append(" phoneno = '" + Shi.getPhoneno() + "'");
			sbUpdate.append(" WHERE orderid = '" + Shi.getOrderid() + "'");
			sbUpdate.append("AND productname = '" + Shi.getProductname() + "'");
			stmtUpdate = con.prepareStatement(sbUpdate.toString());

			int rows = stmtUpdate.executeUpdate();

			if (rows != 1) {
				result = FAILURE;
				System.err.println("Execute update error for shipping "
						+ Shi.getOrderid());
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

	public Collection<ShipBean> selectShip() {
		Collection<ShipBean> ship = new ArrayList<ShipBean>();

		// Create a Database Connection
		Connection con = DBConnectionManager.getSimpleConnection();
		Statement st = null;
		ResultSet rs = null;

		try {
		//	con.setAutoCommit(false);
			st = con.createStatement();

			rs = st.executeQuery("select * from shipping where orderid not in(SELECT orderid FROM delivery)");

			while (rs.next()) {
				ShipBean shipBean = new ShipBean();
				shipBean.setOrderid(Integer.parseInt(rs.getString("orderid")));
				shipBean.setProductname(rs.getString("productname"));
				shipBean.setShipmentno(Integer.parseInt(rs.getString("shipmentno")));
				shipBean.setDateshipped(rs.getString("dateshipped"));
				shipBean.setShippedby(rs.getString("shippedby"));
				shipBean.setCustomername(rs.getString("customername"));
				shipBean.setPhoneno(rs.getString("phoneno"));
				
				ship.add(shipBean);
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

		return ship;

	}
	
public String deleteShip(String orderid){
		
		String result = null;
		Statement st = null;
		
		//Create a Database Connection
		Connection con = DBConnectionManager.getJDBCConnection();
		try{
			//con.setAutoCommit(false);
			st = con.createStatement();
	
			int row = st.executeUpdate("delete from shipping where orderid = '"+ orderid +"'") ;
			if(row != 0){
				System.out.println("Deleted order  " + orderid );
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
