<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Order Management System</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap -->
<link href="./lib/css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="./css/oms.css" rel="stylesheet" media="screen">
<script src="./lib/js/jquery.js"></script>
<script src="./lib/js/bootstrap.min.js"></script>
</head>
<SCRIPT LANGUAGE="JavaScript">
	function getBack() {
		window.location.href = "pack.jsp"

	}
</SCRIPT>

<body class="background">
	
		<center>
			<h4>Data Sent Successfully to Shipping Department....</h4>

			<br> <br> <br> <br>
			<button class="btn btn-lg btn-primary button1" type="button" value
				onClick="getBack()">Go to Customer Orders..</button>
		</center>
		
		
			
</body>
</html>