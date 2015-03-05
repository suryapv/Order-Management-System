<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.ts.beans.OrderBean"%>
<%@page import="java.util.Collection"%>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>packing</title>
</head>
<body>
<center>
				<h2>Packing List</h2>
				<br>
				<br>
				<table class="table">
					<tr>
						<th>orderid</th>
						<th>Product Name</th>
						<th>date</th>
						<th>Customer</th>
						<th>Phone</th>
						<th>Shipping Date</th>
						<th>Notifying to Shipping</th>
					</tr>
					<%
						Collection col = (ArrayList) request.getAttribute("orderBeans");
						Iterator i = col.iterator();

						while (i.hasNext()) {
							OrderBean item = (OrderBean) i.next();
					%>
					<tr>
						<td><%=item.getOrderid()%></td>
						<td><%=item.getProductname()%></td>
						<td><%=item.getOrderdate()%></td>
						<td><%=item.getCustomername()%></td>
						<td><%=item.getPhoneno()%></td>
						<td><%=item.getShippingdate()%></td>



						<td><a
							href="shipping.jsp?orderid=<%=item.getOrderid()%>&productname=<%=item.getProductname()%>&orderdate=<%=item.getOrderdate()%>&Customername=<%=item.getCustomername()%>&shippingdate=<%=item.getShippingdate()%>&customername=<%=item.getCustomername()%>&phoneno=<%=item.getPhoneno()%>">notify..</a></td>
					
					</tr>
					<%
						}
					%>
				</table>
				<br> <br> <a href="maintainance.jsp">
					<button class="btn btn-lg btn-primary button" type="submit">Logout..</button>
				</a>
			</center>

</body>
</html>