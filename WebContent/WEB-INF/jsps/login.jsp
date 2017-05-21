
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   
    <title>
        Student Quiz
    </title>
 <!--   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
     <style type="text/css">
body {
	background: url("${pageContext.request.contextPath}/images/background.jpg");
}



</style> -->
</head>
<body>

<div id="wrapper">

	<form name="login-form" class="login-form" action="checkLogin" method="post">
	
		<div class="header">
		<h1>Welcome to Student Quiz </h1>
		<span></span>
		</div>
	
		<div class="content">
		<input name="username" type="text" class="input username" placeholder="Student Name" />
		<!-- <div class="user-icon"></div> -->
		<input name="userid" type="text" class="input userid" placeholder="Student ID" />
		<!-- <div class="pass-icon"></div> -->		
		</div>

		<div class="footer">
		<input type="submit" name="submit" value="Enter Quiz" class="button" />
		
		</div>
	
	</form>

</div>
<div class="gradient"></div>


</body>
</html>
