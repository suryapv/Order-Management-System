package com.ts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;



import com.ts.beans.ProductBean;


public class ProductDAO {

	static final String SUCCESS = "success";
	static final String FAILURE = "failure";
	
public String createProduct(ProductBean newProduct){
		
		String result = null;
		PreparedStatement stmtInsert = null;
		
		//Create a Database Connection
		Connection con = DBConnectionManager.getJDBCConnection();
		try{
			//con.setAutoCommit(false);
					
			StringBuffer sbInsert = new StringBuffer();
											
			sbInsert.append("INSERT INTO ");
			//TABLE_NAME
			sbInsert.append("product");
			sbInsert.append(" ( productname, unitprice, instock, shippingprice, quantity, productimage ) ");
			sbInsert.append(" VALUES (");
			sbInsert.append(" ?, ?, ?, ?, ?, ?) ");
			
			stmtInsert = con.prepareStatement(sbInsert.toString());
			
			stmtInsert.setString(1, newProduct.getProductname());
			stmtInsert.setString(2, Integer.toString(newProduct.getUnitprice()));
			stmtInsert.setString(3, newProduct.getInstock());
			stmtInsert.setString(4, Integer.toString(newProduct.getShippingprice()));
			stmtInsert.setString(5, Integer.toString(newProduct.getQuantity()));
			stmtInsert.setString(6, newProduct.getProductimage());
						
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

public Collection<ProductBean> selectProducts() {
	Collection<ProductBean> products = new ArrayList<ProductBean> ();
	
	//Create a Database Connection
	Connection con = DBConnectionManager.getJDBCConnection();		
	Statement st = null;
	ResultSet rs = null;

	
	try{
		//con.setAutoCommit(false);
		st = con.createStatement();

		rs = st.executeQuery("select * from product") ;
				
		while (rs.next()){
			ProductBean productBean = new ProductBean();
			productBean.setProductid(Integer.parseInt(rs.getString("productid")));
			productBean.setProductname(rs.getString("productname"));
			productBean.setUnitprice(Integer.parseInt(rs.getString("unitprice")));
			productBean.setInstock(rs.getString("instock"));			
			productBean.setShippingprice(Integer.parseInt(rs.getString("shippingprice")));
			productBean.setQuantity(Integer.parseInt(rs.getString("quantity")));
			productBean.setProductimage(rs.getString("productimage"));
			products.add(productBean);					
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
	
			
	return products;
	
}
	


	public String updateProduct(ProductBean product){
	
	String result = null;
	PreparedStatement stmtUpdate = null;
	
	//Create a Database Connection
	Connection con = DBConnectionManager.getJDBCConnection();
	try{
		//con.setAutoCommit(false);
				
		StringBuffer sbUpdate = new StringBuffer();
		
		sbUpdate.append("UPDATE product SET ");
		
		sbUpdate.append(" unitprice = " + product.getUnitprice() + ", ");
		sbUpdate.append(" instock = '" + product.getInstock() + "', ");
		sbUpdate.append(" shippingprice = " + product.getShippingprice() + ",");
		sbUpdate.append(" quantity = " + product.getQuantity());
		sbUpdate.append(" WHERE productname = '" + product.getProductname() + "'");
					
		stmtUpdate = con.prepareStatement(sbUpdate.toString());
		
		int rows = stmtUpdate.executeUpdate();
		
		if (rows != 1){
			result = FAILURE;
			System.err.println("Execute update error for product "+ product.getProductid());
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
	
	
	public String deleteProduct(String productname){
		
		String result = null;
		Statement st = null;
		
		//Create a Database Connection
		Connection con = DBConnectionManager.getJDBCConnection();
		try{
			//con.setAutoCommit(false);
			st = con.createStatement();
	
			int row = st.executeUpdate("delete from product where productname = '"+ productname +"'") ;
			if(row != 0){
				System.out.println("Deleted Product with product name : " + productname );
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
	
	public Collection<ProductBean> shopProducts() {
		Collection<ProductBean> products = new ArrayList<ProductBean> ();
		
		//Create a Database Connection
		Connection con = DBConnectionManager.getJDBCConnection();		
		Statement st = null;
		ResultSet rs = null;

		
		try{
			//con.setAutoCommit(false);
			st = con.createStatement();

			rs = st.executeQuery("select productname,productimage,unitprice,shippingprice from product") ;
					
			while (rs.next()){
				ProductBean productBean = new ProductBean();
				productBean.setProductname(rs.getString("productname"));
				productBean.setProductimage(rs.getString("productimage"));
				productBean.setUnitprice(Integer.parseInt(rs.getString("unitprice")));
				productBean.setShippingprice(Integer.parseInt(rs.getString("shippingprice")));
				products.add(productBean);					
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
		
				
		return products;
		
	}
	
	
	
	public String getProductDetails(String pname) 
	{
		//Collection<ProductBean> products = new ArrayList<ProductBean> ();
		Connection con = DBConnectionManager.getJDBCConnection();		
		Statement st = null;
		ResultSet rs = null;

		
		try{
			//con.setAutoCommit(false);
			st = con.createStatement();

			rs = st.executeQuery("select * from product where productname='"+pname+"'") ;
			ProductBean productBean = new ProductBean();	
			while (rs.next()){
				System.out.println(rs.getString("productimage"));
				System.out.println(rs.getInt("unitprice"));
				productBean.setProductname(rs.getString("productname"));
				productBean.setProductimage(rs.getString("productimage"));
				productBean.setUnitprice(rs.getInt("unitprice"));
				productBean.setShippingprice(rs.getInt("shippingprice"));
			//	products.add(productBean);
					return productBean.getProductname()+","+productBean.getProductimage()+","+productBean.getUnitprice()+","+productBean.getShippingprice();		
			}
									
		}catch (SQLException ex){
			System.err.println(ex);
		}
		
		return null;
				
		
		
	}
}