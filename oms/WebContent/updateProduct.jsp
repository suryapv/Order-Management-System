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
UPDATE PRODUCT
<br>
<br>
<form name="myFormA" method="post" action="controller.do">
      <input type="hidden" name="form_action" value="product" /> 
      <input type="hidden" name="action" value="update" /> 
<table border = 3>
<tr>
<td>Product ID : </td>
<td><input type = "text" name = "productid" value=<%=request.getParameter("productid")%> readonly></td>
</tr>
<tr>
<td>Product Name : </td>
<td><input type = "text" name = "productname" value=<%=request.getParameter("productname")%> readonly></td>
</tr>
<tr>
<td>Unit Price : </td>
<td><input type = "text" name = "unitprice" value=<%=request.getParameter("unitprice")%>></td>
</tr>
<tr>
<td>In Stock : </td>
<td>
<select name = "instock" value=<%=request.getParameter("instock")%>>
<option>yes</option>
<option>No</option>
</select>
</td>
</tr>
<tr>
<td>Shipping Price : </td>
<td><input type = "text" name = "shippingprice" value=<%=request.getParameter("shippingprice")%>></td>
</tr>
<tr>
<td>Quantity : </td>
<td><input type = "text" name = "quantity" value=<%=request.getParameter("quantity")%>></td>
</tr>
<tr>
<td>Product Image : </td>
<td><input type = "text" name = "productimage" value=<%=request.getParameter("productimage")%>></td>
</tr>
</table>
<br>
<br>
<input type = "submit" value = "UPDATE PRODUCT" name = "submit">
<input type="button" value="Cancel" name="cancel" onClick="adminForm()">
</form>
</center>
</body>
</html>