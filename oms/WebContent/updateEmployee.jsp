<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Order Management System</title>
</head>
<SCRIPT LANGUAGE = "JavaScript">
function adminForm(){
   	window.location.href="admin.jsp";

}
</SCRIPT>
<body>
<center>
<br>
UPDATE EMPLOYEE
<br>
<br>
<form name="myFormA" method="post" action="controller.do">
      <input type="hidden" name="form_action" value="employee" /> 
      <input type="hidden" name="action" value="update" /> 
<table border = 3>

<tr>
<td>Employee Name : </td>
<td><input type = "text" name = "empname" value=<%=request.getParameter("empname")%> readonly></td>
</tr>
<tr>
<td>Email-Id : </td>
<td><input type = "text" name = "emailid" value=<%=request.getParameter("emailid")%>></td>
</tr>
<tr>
<td>Address : </td>
<td><input type = "text" name = "address" value=<%=request.getParameter("address")%>></td>
</tr>
<tr>
<td>Department No : </td>
<td><input type = "text" name = "deptno" value=<%=request.getParameter("deptno")%>></td>
</tr>
</table>
<br>
<br>
<input type = "submit" value = "Update Employee" name = "submit"/>
<input type="button" value="Cancel" name="cancel" onClick="adminForm()" />
</form>
</center>
</body>
</html>