<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form name="myForm" method = "post" action="controller.do">
<input type=hidden name="form_action" value="pdfCreate">				
		    <input type=hidden name="product_name" value=<%=request.getParameter("productname")%>>
		    <input type=hidden name="username" value=<jsp:getProperty name="userBean" property="username" />>
		    <input type=hidden name="name" value=<jsp:getProperty name="userBean" property="customername" />>
		    <input type=hidden name="phoneno" value=<jsp:getProperty name="userBean" property="phoneno" />>
		    <input type=hidden name="address" value=<jsp:getProperty name="userBean" property="address" />>
		    
</form>
</body>
</html>


