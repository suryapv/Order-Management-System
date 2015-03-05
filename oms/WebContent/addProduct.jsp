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

<br>
<br>
ADD PRODUCT
<br>
<br>
<form name="myForm" action = "controller.do" method="post">
<input type="hidden" name="form_action" value="product" /> 
<input type="hidden" name="action" value="insert" /> 
<table border = 3>
<tr>
<td>Product Name : </td>
<td><input type = "text" name = "productname" /></td>
</tr>
<tr>
<td>Unit Price : </td>
<td><input type = "text" name = "unitprice" /></td>
</tr>
<tr>
<td>In Stock : </td>
<td>
<select name = "instock">
<option>yes</option>
<option>No</option>
</select>
</td>
</tr>
<tr>
<td>Shipping Price : </td>
<td><input type = "text" name = "shippingprice" /></td>
</tr>
<tr>
<td>Quantity : </td>
<td><input type = "text" name = "quantity" /></td>
</tr>
<tr>
<td>Product Image : </td>
<td><input type = "text" name = "productimage" placeholder = "url:images/filename.jpeg"/></td>
</tr>
</table>
<br>
<br>
<input type = "submit" value = "Add" name = "submit"/>
</form>
</center>
</body>
</html>