<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.ts.beans.EmployeeBean"%>
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
<h1>All Employees List</h1>
        <table border="1">
        <tr>
           
            <th>Employee Name</th>
            <th>Email ID</th>
            <th>Address</th>
            <th>Dept no</th>
            <th>Update Employees</th>
        </tr>
          <%
                Collection col = (ArrayList)request.getAttribute("empBeans");
          		Iterator i = col.iterator();
                
                while (i.hasNext()) {
                	EmployeeBean emp = (EmployeeBean)i.next();
                    %>
                     <tr>
                    
                      <td>  
                      <center> <%=emp.getEmpname()%>   </center>                      
                     </td>
                      <td>
                       <center>  <%=emp.getEmailid()%>   </center>                     
                     </td>
                      <td>
                        <center> <%=emp.getAddress()%>     </center>                   
                     </td>
                     <td>
                        <center> <%=emp.getDeptno()%>     </center>                   
                     </td>
                     <td>
                     <center>  <a href = "updateEmployee.jsp?empname=<%=emp.getEmpname()%>&emailid=<%=emp.getEmailid()%>&address=<%=emp.getAddress()%>&deptno=<%=emp.getDeptno()%>">Update This Employee</a></center>                   
                     </td>
                     </tr>
                     <%
                	}
					%>	
				 			
		</table>
		<br>
		<center>
		<a href = "deleteEmployee.jsp">Delete An Employee</a>&nbsp;
		<a href = "addEmployee.jsp">Add New Employee</a>&nbsp;
		<a href = "admin.jsp"><input type = "submit" value = "Go Back"></a>
		</center>
</center>
</body>
</html>