<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.ts.beans.DeliverBean"%>
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
<h1>Delivery List</h1>
        <table border="1">
        <tr>
           
            <th>Order Id</th>
            <th>Delivered by</th>
              <th>Date Delivered</th>
            <th>Received by</th>
            <th>Phone no</th>
        </tr>
          <%
                Collection col = (ArrayList)request.getAttribute("deliverBeans");
          		Iterator i = col.iterator();
                
                while (i.hasNext()) {
                	DeliverBean deliver = (DeliverBean)i.next();
                    %>
                     <tr>
                    
                      <td>  
                      <center> <%= deliver.getOrderid()%>   </center>                      
                     </td>
                      <td>
                       <center>  <%=deliver.getDeliverby()%>   </center>                     
                     </td>
                     <td>
                       <center>  <%=deliver.getDatedelivered()%>   </center>                     
                     </td>
                      
                      <td>
                        <center> <%=deliver.getReceivedby()%>     </center>                   
                     </td>
                     <td>
                        <center> <%=deliver.getPhoneno()%>     </center>                   
                     </td>
                     </tr>
                     <%
                	}
					%>	
				 			
		</table>
		</center>
</body>
</html>