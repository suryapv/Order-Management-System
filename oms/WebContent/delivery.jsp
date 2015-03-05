<html>
<body>
<br>
</body>
<center>
<h1> Delivery status</h1>
<br>
<br>

<form action = "controller.do">
<input type = "hidden" name = "form_action" value = "delivery" >
<table>
<tr>
<td> order id</td><td><%= request.getParameter("orderid") %><input type = "hidden" name = "orderid" value = "<%= request.getParameter("orderid") %>"></td>
</tr>
<tr>
<td> Delivered By</td><td>Laxman <input type = "hidden" name = "deliverby" value = "Laxman"></td>
</tr>
<tr>
<td> Received By</td><td><%= request.getParameter("Customername") %> <input type = "hidden" name = "customername" value = "<%= request.getParameter("Customername") %>"></td>
</tr>
<tr>
<td> Phone no.</td><td><%= request.getParameter("phoneno") %><input type = "hidden" name = "phoneno" value = "<%= request.getParameter("phoneno") %>"></td>
</tr>

</table>

<input type = "submit" value = "submit" >
</form>

</center>
</html>