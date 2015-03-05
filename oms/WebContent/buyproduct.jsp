<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.ts.dao.ProductDAO" %>
    <%@page import="com.ts.beans.ProductBean" %>
    <jsp:useBean id="userBean" class="com.ts.beans.UserBean" scope="session" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>buy product</title>
</head>
<body>
<form>
<center>
<jsp:getProperty name="userBean" property="username" />
         <jsp:getProperty name="userBean" property="phoneno" />
<h2><font color = "red">Order Form</font></h2><br><br>
Dear Customer! Thank you for the Order....<br><br>
<font color = "green">You ordered</font><br><br>

<%
ProductDAO pd = new ProductDAO(); 
String pro = pd.getProductDetails(request.getParameter("flag"));
String a[] = pro.split(",");
%>
    <jsp:useBean id="productBean" class="com.ts.beans.ProductBean" scope="session" />
<img src =<%=a[1]%>></img>
<br><br>
Amount To be Payable : <br><br>
<table border = 2>
<tr>
<td>
Product Name </td><td><%= a[0]%>
</td>
</tr>
<tr>
<td>
Product Price </td><td>RS <%= a[2]%>
</td>
</tr>
<tr>
<td>
Shipping Charges </td><td> RS <%= a[3]%>
</td>
</tr>
<tr>
<td>
Total Amount to be Paid </td><td> RS <%=(Integer.parseInt(a[2])+Integer.parseInt(a[3]))%>
</td>
</tr>
</table>
<br><br>
<input type = "button" value = "Order" onClick="location.href='confirmorder.jsp?&productname=<%=a[0]%>'">
<input type = "button" value = "cancel order" onClick = "adminForm()">
</center>
</form>
</body>
</html>
