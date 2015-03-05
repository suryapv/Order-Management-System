package com.ts.beans;

public class ProductBean {
	private int productid;
	private String productname;
	private int unitprice;
	@Override
	public String toString() {
		return "ProductBean [productid=" + productid + ", productname="
				+ productname + ", unitprice=" + unitprice + ", instock="
				+ instock + ", shippingprice=" + shippingprice + ", quantity="
				+ quantity + ", productimage=" + productimage + "]";
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public int getUnitprice() {
		return unitprice;
	}
	public void setUnitprice(int unitprice) {
		this.unitprice = unitprice;
	}
	public String getInstock() {
		return instock;
	}
	public void setInstock(String instock) {
		this.instock = instock;
	}
	public int getShippingprice() {
		return shippingprice;
	}
	public void setShippingprice(int shippingprice) {
		this.shippingprice = shippingprice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getProductimage() {
		return productimage;
	}
	public void setProductimage(String productimage) {
		this.productimage = productimage;
	}
	private String instock;
	private int shippingprice;
	private int quantity;
	private String productimage;

}
