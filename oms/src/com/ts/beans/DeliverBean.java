package com.ts.beans;

public class DeliverBean {
String orderid;
String deliverby;
String datedelivered;
public String getDatedelivered() {
	return datedelivered;
}
public void setDatedelivered(String datedelivered) {
	this.datedelivered = datedelivered;
}
public String getOrderid() {
	return orderid;
}
public void setOrderid(String orderid) {
	this.orderid = orderid;
}
public String getDeliverby() {
	return deliverby;
}
@Override
public String toString() {
	return "DeliverBean [orderid=" + orderid + ", deliverby=" + deliverby
			+ ", receivedby=" + receivedby + ", phoneno=" + phoneno + "]";
}
public void setDeliverby(String deliverby) {
	this.deliverby = deliverby;
}
public String getReceivedby() {
	return receivedby;
}
public void setReceivedby(String receivedby) {
	this.receivedby = receivedby;
}
public String getPhoneno() {
	return phoneno;
}
public void setPhoneno(String phoneno) {
	this.phoneno = phoneno;
}
String receivedby;
String phoneno;
}