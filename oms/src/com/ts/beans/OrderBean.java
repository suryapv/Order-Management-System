package com.ts.beans;

public class OrderBean {
	private int orderid;
	private String productname;
	private String orderdate;
	private String customername;
	private String shippingdate;
	private String phoneno;
	
	
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}
	
	public String getShippingdate() {
		return shippingdate;
	}
	public void setShippingdate(String shippingdate) {
		this.shippingdate = shippingdate;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	
	
	
}
