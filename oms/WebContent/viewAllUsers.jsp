<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.ts.beans.UserBean"%>
<%@page import="java.util.Collection"%>

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
<h1>All Customers List</h1>
        <table border="1">
        <tr>
          
       <th>Customer Id</th>
             <th>Customer Name</th>
            <th>Username</th>
            <th>age</th>
            <th>Phone no</th>
            <th>Address</th>
        </tr>
          <%
                Collection col = (ArrayList)request.getAttribute("userBeans");
          		Iterator i = col.iterator();
                
                while (i.hasNext()) {
                	UserBean user = (UserBean)i.next();
                    %>
                     <tr>
                    <td>
                       <center>  <%=user.getCustomerid()%>   </center>                     
                     </td>
                     
                      <td>
                       <center>  <%=user.getCustomername()%>   </center>                     
                     </td>
                      <td>
                        <center> <%=user.getUsername()%>     </center>                   
                     </td>
                     <td>
                        <center> <%=user.getAge()%>     </center>                   
                     </td>
                     <td>
                        <center> <%=user.getPhoneno()%>     </center>                   
                     </td>
                     <td>
                        <center> <%=user.getAddress()%>     </center>                   
                     </td>
                     
                     </tr>
                     <%
                	}
					%>	
				 			
		</table>
	
</center>
</body>
</html>