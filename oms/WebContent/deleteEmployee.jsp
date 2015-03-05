<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Order Management System</title>
</head>
<body>
<center>
<h2><font color = "red">Hi, Admin</font></h2>
<br>
<br>
DELETE EMPLOYEE
<br>
<br>
<form name="myForm" action = "controller.do" method="post">
<input type="hidden" name="form_action" value="employee" /> 
<input type="hidden" name="action" value="delete" />
<table border = 3>
<tr>
<td>Employee Name : </td>
<td><input type = "text" name = "empname" /></td>
</tr>
</table>
<br>
<br>
<input type = "submit" value = "Delete" name = "submit"/>
</form>
</center>
</body>
</html>