<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="orderBean" class="com.ts.beans.OrderBean" scope="session" />
 <%@page import="com.ts.dao.ProductDAO" %>
    <%@page import="com.ts.beans.ProductBean" %>
    <jsp:useBean id="userBean" class="com.ts.beans.UserBean" scope="session" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>payment sucess</title>
</head>
<body>
<center>
<h1><font color = "green">Congrats <jsp:getProperty name="orderBean" property="customername" />.....! </font></h1><br>
<h4><font color = "blue">Your Order Placed Successfull........!!!!</font></h4>
      <font color = "gray">The product will be delivered within 5-6 workingdays</font>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>		
		
		
		<center><a href = "customer.jsp">go back</a></center>	
		<center><ul><li><a href="javascript:document.myForm2.submit();">pdfgenerate</a>
		<form name="myForm2" action="controller.do">
		<input type=hidden name="form_action" value="pdfCreate">
		  <input type=hidden name="product_name" value=<%=request.getParameter("productname")%>>
		    <input type=hidden name="username" value=<jsp:getProperty name="userBean" property="username" />>
		    <input type=hidden name="name" value=<jsp:getProperty name="userBean" property="customername" />>
		    <input type=hidden name="phoneno" value=<jsp:getProperty name="userBean" property="phoneno" />>
		    <input type=hidden name="address" value=<jsp:getProperty name="userBean" property="address" />>	
					
	</form></li></ul></center>
		
		
	
</center>
</body>
</html>