<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.ts.beans.ProductBean"%>
<%@page import="java.util.Collection"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html/image; charset=UTF-8">
<title>Order Management System</title>
</head>
<body>

<center>
<h1>All Products List</h1>
        <table border="1">
        <tr>
            <th>Product ID</th>
            <th>Product Name</th>
            <th>Unit Price</th>
            <th>Available in Stock</th>
            <th>Shipping Price</th>
            <th>Quantity</th>
            <th>Product Image</th>
            <th>Update Products</th>
            
          </tr>
          <%
                Collection col = (ArrayList)request.getAttribute("productBeans");
          		Iterator i = col.iterator();
                
                while (i.hasNext()) {
                	ProductBean item = (ProductBean)i.next();
                    %>
                     <tr>
                     <td>
                        <center> <%=item.getProductid()%>  </center>                    
                     </td>
                      <td>
                        <center> <%=item.getProductname()%>   </center>                      
                     </td>
                      <td>
                       <center>  <%=item.getUnitprice()%>   </center>                     
                     </td>
                      <td>
                        <center> <%=item.getInstock()%>     </center>                   
                     </td>
                     <td>
                       <center>  <%=item.getShippingprice()%>       </center>                 
                     </td>
                     <td>
                        <center> <%=item.getQuantity()%>     </center>                 
                     </td>
                     <td>
                        <center><img src = "<%=item.getProductimage()%>" ></img></center>                
                     </td>
                     <td>
                       <center>  <a href = "updateProduct.jsp?productid=<%=item.getProductid()%>&productname=<%=item.getProductname()%>&unitprice=<%=item.getUnitprice()%>&instock=<%=item.getInstock()%>&shippingprice=<%=item.getShippingprice()%>&quantity=<%=item.getQuantity()%>&productimage=<%=item.getProductimage()%>">Update This Product</a>   </center>                   
                     </td>
                     </tr>
                     <%
                	}
					%>	
				 			
		</table>
		<br>
		<center>
		<a href = "deleteProduct.jsp">Delete A Product</a>&nbsp;
		<a href = "addProduct.jsp">Add New Product</a><a href = "admin.jsp">&nbsp;
		<input type = "submit" value = "Go Back"></a>
		</center>
</center>
</body>
</html>