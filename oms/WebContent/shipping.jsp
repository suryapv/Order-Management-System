<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
		<h2>shipping details....</h2>
		<br> <br> UPDATE PRODUCT <br> <br>
		<form name="myFormA" method="post" action="controller.do">
			<input type="hidden" name="form_action" value="ship" />
			<input type="hidden" name="action" value="insert" />
				<input type="hidden" name="dateshipped" value=<%=request.getParameter("shippingdate")%> />
				<input type="hidden" name="customername" value=<%=request.getParameter("customername")%> />
				<input type="hidden" name="phoneno" value=<%=request.getParameter("phoneno")%> />
				<input type="hidden" name="shipmentno" value="0" />
				<input type="hidden" name="shippedby" value="sandeep" />
			<table class="table">
				<tr>
					<td>order no :</td>
					<td><input type="text" name="orderid"
						value=<%=request.getParameter("orderid")%> readonly></td>
				</tr>
				<tr>
					<td>Product Name :</td>
					<td><input type="text" name="productname"
						value=<%=request.getParameter("productname")%> readonly></td>
				</tr>
				
			</table>
			<br> <br> <input type="submit" value = "Shipping..">
		</form>
	</center>
</body>
</html>