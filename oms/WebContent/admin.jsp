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
        <li><a href="#">Hi, Admin</a>
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


	<iframe src="#" seamless width="550px" height="550px" scrolling="yes" frameborder="0" name="work"></iframe>



		
	
	</div>
			<div>&nbsp;</div>
			
		</div>
		<!-- end content -->




    <div class="left"> 
    <ul id="nav">
        <li><a id='im1'><img src="images/insert.jpg" id="1" align='left'>ADD</a>
            <ul class='count'>
                <li><a href="addDepartment.jsp" target="work">add department</a></li>
                <li><a href="addEmployee.jsp" target="work">add employee</a></li>
                <li><a href="addProduct.jsp" target="work">add product</a></li>
               
            </ul>
        </li>
        
        <li><a id='im1'><img src="images/insert.jpg" id="1" align='left'>UPDATE</a>
            <ul class='count'>
                <li><a href="updateDepartment.jsp" target="work">update department</a></li>
                <li><a href="updateEmployee.jsp" target="work">update employee</a></li>
                <li><a href="updateProduct.jsp" target="work">update product</a></li>
                
            </ul>
        </li>
        
         <li><a id='im1'><img src="images/insert.jpg" id="1" align='left'>VIEW ALL</a>
            <ul class='count'>
                <li><a href="javascript:document.myForm1.submit();" >view all departments</a>
				<form name="myForm1" action="controller.do">
				<input type=hidden name="form_action" value="department">
				<input type=hidden name="action" value="viewAll"></form>
				</li>
                <li><a href="javascript:document.myForm2.submit();" >view all employees</a>
				<form name="myForm2" action="controller.do">
				<input type=hidden name="form_action" value="employee">
				<input type=hidden name="action" value="viewAll"></form>
				</li>
                
                <li><a href="javascript:document.myForm3.submit();" >view all users</a>
				<form name="myForm3" action="controller.do">
				<input type=hidden name="form_action" value="user">
				<input type=hidden name="action" value="viewAll"></form>
				</li>
                
                <li><a href="javascript:document.myForm4.submit();" >view all products</a>
				<form name="myForm4" action="controller.do">
				<input type=hidden name="form_action" value="product">
				<input type=hidden name="action" value="viewAll"></form>
				</li>
                
                
            </ul>
        </li>
        
        <li><a id='im1'><img src="images/insert.jpg" id="1" align='left'>VIEW STATUS</a>
            <ul class='count'>
                <li><a href="javascript:document.myForm5.submit();" >shipping</a>
				<form name="myForm5" action="controller.do">
				<input type=hidden name="form_action" value="ship">
				<input type=hidden name="action" value="viewall"></form>
				</li>
                
              <li><a href="javascript:document.myForm6.submit();" >Delivery</a>
				<form name="myForm6" action="controller.do">
				<input type=hidden name="form_action" value="delivery">
				<input type=hidden name="action" value="viewAll"></form>
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
