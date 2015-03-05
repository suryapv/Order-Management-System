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

<br>
ADD DEPARTMENT
<br>
<br>
<form name="myForm" action = "controller.do" method="post">
<input type="hidden" name="form_action" value="department" /> 
<input type="hidden" name="action" value="insert" /> 
<table border = 3>
<tr>
<td>Department NO : </td>
<td><input type = "text" name = "deptno" /></td>
</tr>
<tr>
<td>Department Name : </td>
<td><input type = "text" name = "deptname" /></td>
</tr>
<tr>
<td>Total Members : </td>
<td><input type = "text" name = "totalmembers" /></td>
</tr>
</table>
<br>
<br>
<input type = "submit" value = "Add Department" name = "submit"/>
</form>
</center>
</body>
</html>