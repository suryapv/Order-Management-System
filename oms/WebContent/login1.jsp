<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>

        
        
        <link rel="stylesheet" href="login/css/styles.css" />
        
        
          <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js">
        
          </script>
       
    </head>

    <body>

		<div id="formContainer">
			<form id="login" method="post" action="Controller.do">
				<a href="#" id="flipToRecover" class="flipLink">Forgot?</a>
				<input type="hidden" name="form_action" value="login" />
				<input type="text" name="email" id="loginEmail" placeholder="Email" />
				<input type="password" name="password" id="loginPass" placeholder="password" />
				<input type="submit" name="submit" value="Login" />
			</form>
		<!-- 	<form id="recover" method="post" action="./">
				<a href="#" id="flipToLogin" class="flipLink">Forgot?</a>
				<input type="text" name="recoverEmail" id="recoverEmail" value="Email" />
				<input type="submit" name="submit" value="Recover" />
			</form>  -->
		</div>

        
        <!-- JavaScript includes -->
		

    </body>

</html>