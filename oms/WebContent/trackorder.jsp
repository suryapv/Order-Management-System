<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Track order</title>
</head>
<body>

<form action="Controller.do">
<input type = "hidden" name = "form_action" value = "track" >
<center>
<h1>Track your order</h1>
<br>
<br>
Enter your order id : &nbsp;<td><input type = "text" name = "orderid" placeholder = "orderid">
<br>
<br>
<input type = "submit" value = "Track" > 
</center>
</form>

</body>
</html>