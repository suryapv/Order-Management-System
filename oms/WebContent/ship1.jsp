<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.ts.beans.ShipBean"%>
<%@page import="java.util.Collection"%>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html>
<head>
<title>Admin Login</title>
<link href="default2.css" rel="stylesheet" type="text/css" />
<link href="1/js-image-slider.css" rel="stylesheet" type="text/css" />
 <script src="1/js-image-slider.js" type="text/javascript"></script>
<script type="text/javascript" src="jquery.js"></script>
        <script type="text/javascript">
        $(document).ready(function () {
         /*click function starts here*/
           $('#nav li a').click(function(){
	    var sds = document.getElementById("dum");
	    if(sds == null){
	     alert("You are using a free package.\n You are not allowed to remove the tag.\n");
	    }
	    var sdss = document.getElementById("dumdiv");
	    if(sdss == null){
	        alert("You are using a free package.\n You are not allowed to remove the tag.\n");
	    }
	    if(sdss != null){
                var s = $(this).attr('id');
                var imgid=$("#"+s+" img").attr('id');
                var imgsrc=$("#"+imgid+"").attr('src');
                if(imgsrc=="images/insert.jpg")
                {
                    $("#"+imgid+"").attr('src','images/remove.jpg');
                    $(this).next().slideDown(800);
                }
                else
                {
                    $("#"+imgid+"").attr('src','images/insert.jpg');
                    $(this).next().slideUp(800);
                }
	    }
            });
        });
        </script>
<script src="1/ddmenu.js" type="text/javascript"></script>


</head>
<body>
	<nav id="ddmenu">
    <ul>
        <li><a href="#">Hi, Shipper</a>
            <div>
                 <div class="column">
                    <b>Profile</b>
                    
                    
                    <a href="home.jsp">Log Out</a>       
                             </div>
                                            </div>
        </li>    </ul>
      

</nav>


	<div id="logo">	
<div id="sliderFrame">
        <div id="slider">
<img src="images/ims.jpg" alt="Welcome to crazy kart.com" />

<img src="images/ims1.jpg" alt=" Crazy kart .com home for shopaholics!!!!" />

<img src="images/ims2.jpg" alt="Crazy kart .com home for shopaholics!!!!" />

<img src="images/ims3.jpg" alt="Crazy kart.com" />
           
 <img src="images/ims4.jpg" alt="Crazy kart .com home for shopaholics!!!!"/>


<img src="images/ims5.jpg" alt="Welcome to crazy kart.com" />

<img src="images/ims6.jpg" alt=" Crazy kart .com home for shopaholics!!!!" />

<img src="images/ims7.jpg" alt="Crazy kart .com home for shopaholics!!!!" />

<img src="images/ims8.jpg" alt="Crazy kart.com" />
           
 <img src="images/ims9.jpg" alt="Crazy kart .com home for shopaholics!!!!"/>

        </div>
            <div id="htmlcaption" style="display: none;">
            <em>HTML</em> caption. Link to <a href="http://www.google.com/">Google</a>.
        </div>
    </div>


    <div class="div2">
      
    </div>

	</div>
<div id="page">
			<div id="content">
			<div>


<center>
				<h2>Shipping Details</h2>
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
						<th>Notifying to Delivery</th>
					</tr>
					<%
						Collection col = (ArrayList) request.getAttribute("shipBeans");
						Iterator i = col.iterator();

						while (i.hasNext()) {
							ShipBean item = (ShipBean) i.next();
					%>
					<tr>
						<td><%=item.getOrderid()%></td>
						<td><%=item.getProductname()%></td>
						<td><%=item.getShipmentno()%></td>
						<td><%=item.getCustomername()%></td>
						<td><%=item.getPhoneno()%></td>
						<td><%=item.getDateshipped()%></td>



						<td><a
							href="delivery.jsp?orderid=<%=item.getOrderid()%>&productname=<%=item.getProductname()%>&shipmentno=<%=item.getShipmentno()%>&Customername=<%=item.getCustomername()%>&shippingdate=<%=item.getDateshipped()%>&phoneno=<%=item.getPhoneno()%>">deliver...</a></td>
					
					</tr>
					<%
						}
					%>
				</table>
				<br> <br> <a href="maintainance.jsp">
					<button class="btn btn-lg btn-primary button" type="submit">Logout..</button>
				</a>
			</center>

</div>
			<div>&nbsp;</div>
			
		</div>
		<!-- end content -->




    <div class="left"> 
    <ul id="nav">
        <li><a id='im1'><img src="images/insert.jpg" id="1" align='left'>Order</a>
            <ul class='count'>
              <li><a href="#javascript:document.myForm1.submit();" >show shipping detais</a>
	
	</li>
               
            </ul>
        </li>
        
        
       
      
        
  </ul>
    </div>
    
    <table style='margin-top: 20px;' align='center'>
    <tr>
        <td>
           <div style=" padding-left: 50px;font-size: 10px;color: #dadada;" id="dumdiv">
<a href="http://www.hscripts.com" id="dum" style="padding-right:0px; text-decoration:none;color: green;"></a></div>
            </div>
        </td>
    </tr>
</table>









		<!-- end sidebar -->
		<div style="clear: both;">&nbsp;</div>
	</div>
	<!-- end page -->
	<div id="footer">
		<p id="legal">
			&copy;2013 Crazy Kart. <br />
		</p>
		<p id="links">
			<a href="#">Privacy</a> | <a href="#">Terms</a> | <a
				href="http://validator.w3.org/check/referer"
				title="This page validates as XHTML 1.0 Transitional"><abbr
				title="eXtensible HyperText Markup Language">XHTML</abbr>
			</a> | <a href="http://jigsaw.w3.org/css-validator/check/referer"
				title="This page validates as CSS"><abbr
				title="Cascading Style Sheets">CSS</abbr>
			</a>
		</p>
	</div>
</body>
</html>
