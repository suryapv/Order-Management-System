<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="userBean" class = "com.ts.beans.UserBean" scope = "session"></jsp:useBean>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>conform product</title>
</head>
<body>
<form name="myForm" method = "post" action="controller.do">
		<input type=hidden name="form_action" value="order">
		<input type=hidden name="action" value="insert">
		<input type = "hidden" name = "productname" value="<%=request.getParameter("productname")%>" >
		<input type = "hidden" name = "customername" value = "<jsp:getProperty name="userBean" property="customername"/>">
		<input type = "hidden" name = "phoneno" value = "<jsp:getProperty name="userBean" property="phoneno"/>">
		<center>
<h2>Confirm your Address</h2>
<br><br>
<pre>
Product Name:&nbsp;<%=request.getParameter("productname")%><br>
Name  	    :&nbsp;<jsp:getProperty name="userBean" property="customername" /><br>
User Name   : &nbsp;<jsp:getProperty name="userBean" property="username" /><br>
phone Num   : &nbsp;<jsp:getProperty name="userBean" property="phoneno" /><br>
Address     : &nbsp;<jsp:getProperty name="userBean" property="address" /><br>
<input type = "submit" value = "Confirm">
</pre>
</center>
</form>
</body>
</body>
</html>