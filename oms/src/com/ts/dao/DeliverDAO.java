package com.ts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import com.ts.beans.DeliverBean;
import com.ts.beans.ShipBean;

public class DeliverDAO {

	public String insert(DeliverBean bean) {

		String result = null;
		PreparedStatement stmtInsert = null;

		// Create a Database Connection
		Connection con = DBConnectionManager.getSimpleConnection();
		try {
			//con.setAutoCommit(false);

			StringBuffer sbInsert = new StringBuffer();

			sbInsert.append("INSERT INTO ");
			// TABLE_NAME
			sbInsert.append("delivery");
			sbInsert.append(" VALUES (");
			sbInsert.append(" ?, curdate()+2, ?, ?, ?) ");

			stmtInsert = con.prepareStatement(sbInsert.toString());
			stmtInsert.setString(1, bean.getOrderid());
			stmtInsert.setString(2, bean.getDeliverby());
			stmtInsert.setString(3, bean.getReceivedby());
			stmtInsert.setString(4, bean.getPhoneno());
			
			int rows = stmtInsert.executeUpdate();

			if (rows != 1) {
				result = "FAILURE";
				throw new SQLException("executeUpdate return value: " + rows);
			}
			result = "SUCCESS";
		} catch (SQLException ex) {
			result = "FAILURE";
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
	
	public Collection<DeliverBean> selectDeliver() {
		Collection<DeliverBean> deliver = new ArrayList<DeliverBean>();

		// Create a Database Connection
		Connection con = DBConnectionManager.getSimpleConnection();
		Statement st = null;
		ResultSet rs = null;

		try {
		//	con.setAutoCommit(false);
			st = con.createStatement();

			rs = st.executeQuery("select * from delivery");

			while (rs.next()) {
				DeliverBean deliverBean = new DeliverBean();
				deliverBean.setOrderid(rs.getString("orderid"));
				deliverBean.setDatedelivered(rs.getString("datedelivered"));
				deliverBean.setDeliverby(rs.getString("deliveredby"));
				deliverBean.setReceivedby(rs.getString("receivedby"));
				deliverBean.setPhoneno(rs.getString("phoneno"));
				
				deliver.add(deliverBean);
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

		return deliver;

	}

}
