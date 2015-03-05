<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:useBean id="userBean" class="com.ts.beans.UserBean" scope="session" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>customer update</title>
</head>
<body>
<form name="myFormA" method="post" action="controller.do">
      <input type="hidden" name="form_action" value="user" /> 
      <input type="hidden" name="action" value="update" /> 
      
      <input type="hidden" name="username"	value="<jsp:getProperty name="userBean" property="username" />" />
      <table>
   			<tr>   
   				<td> User Name  </td>
				<td><input type=text name="username" value = "<jsp:getProperty name="userBean" property="username" />" readonly/></td>
   			</tr>
   			<tr>   
   				<td> Name  </td>
				<td><input type=text name="customername" value = "<jsp:getProperty name="userBean" property="customername" />" /></td>
   			</tr>
   			<tr>   
   				<td> Password  </td>
				<td><input type=text name="password" value = "<jsp:getProperty name="userBean" property="password" />" /></td>
   			</tr>
   			<tr>
   		   		<td> Age</td>
				<td><input type=text name="age" value = "<jsp:getProperty name="userBean" property="age" />"> </td>
  			</tr>
  			<tr>
   		   		<td> Phone Number</td>
				<td><input type=text name="phoneno" value = "<jsp:getProperty name="userBean" property="phoneno" />"> </td>
  			</tr>
      		<tr>
   		   		<td> Address:</td>
				<td><input type=text name="address" value = "<jsp:getProperty name="userBean" property="address" />"></td>
  			</tr>
      		
      		</table>
   			
   			<br>
   				<input type="submit" name="enter_button" value="Update" class="btn btn-primary btn-lg"/>
   				&nbsp;&nbsp;&nbsp;
   				<input type="button" name="enter_button" value="Cancel" onClick="loginForm()" class="btn btn-danger btn-lg"/>
   			
   </form>
</body>
</html>