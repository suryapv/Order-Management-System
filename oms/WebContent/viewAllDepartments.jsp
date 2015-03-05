<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.ts.beans.DepartmentBean"%>
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
<h1>All Departments List</h1>
        <table border="1">
        <tr>
          
            <th>Department No</th>
             <th>Department Name</th>
            <th>Total members</th>
            <th>Update Departments</th>
        </tr>
          <%
                Collection col = (ArrayList)request.getAttribute("deptBeans");
          		Iterator i = col.iterator();
                
                while (i.hasNext()) {
                	DepartmentBean dept = (DepartmentBean)i.next();
                    %>
                     <tr>
                    
                      <td>
                        <center> <%=dept.getDeptno()%>   </center>                      
                     </td>
                      <td>
                       <center>  <%=dept.getDeptname()%>   </center>                     
                     </td>
                      <td>
                        <center> <%=dept.getTotalmembers()%>     </center>                   
                     </td>
                     <td>
                     <center>  <a href = "updateDepartment.jsp?deptno=<%=dept.getDeptno()%>&deptname=<%=dept.getDeptname()%>&totalmembers=<%=dept.getTotalmembers()%>">Update This Department</a></center>                   
                     </td>
                     </tr>
                     <%
                	}
					%>	
				 			
		</table>
		<br>
		<center>
		<a href = "deleteDepartment.jsp">Delete A Department</a>&nbsp;
		<a href = "addDepartment.jsp">Add New Department</a>&nbsp;
		<a href = "admin.jsp"><input type = "submit" value = "Go Back"></a>
		</center>
</center>
</body>
</html>