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
UPDATE DEPARTMENT
<br>
<br>
<form name="myFormA" method="post" action="controller.do">
      <input type="hidden" name="form_action" value="department" /> 
      <input type="hidden" name="action" value="update" /> 
<table border = 3>

<tr>
<td>Department No : </td>
<td><input type=text name="deptno" value=<%=request.getParameter("deptno")%>></td>
</tr>
<tr>
<td>Department Name : </td>
<td><input type=text name="deptname" value=<%=request.getParameter("deptname")%> readonly></td>
</tr>
<tr>
<td>Total Members : </td>
<td><input type=text name="totalmembers" value=<%=request.getParameter("totalmembers")%>></td>
</tr>
</table>
<br>
<br>
<input type = "submit" value = "Update Department" name = "submit"/>
<input type="button" value="Cancel" name="cancel" onClick="adminForm()" />
</form>
</center>
</body>
</html>