<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Forget Password</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.7 -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bower_components/bootstrap/dist/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bower_components/font-awesome/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bower_components/Ionicons/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/dist/css/AdminLTE.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/plugins/iCheck/square/blue.css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->

  <!-- Google Font -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
<body class="hold-transition login-page">
<div class="login-box">
  <div class="login-logo">
    <b> Bike Showroom Management System</b>
  </div>
  <!-- /.login-logo -->
  <div class="login-box-body">
	<div class="text-danger">
 
</div>
    <form action="updatePasswordforStaff" method="post">
    <div class="form-group">
      <input type="hidden" name="id" value="${staff.id}"/>
      <input type="hidden" name="address" value="${staff.address}"/>
      <input type="hidden" name="birthDate" value="${staff.birthDate}"/>
      <input type="hidden" name="email" value="${staff.email}"/>
      <input type="hidden" name="firstName" value="${staff.firstName}"/>
      <input type="hidden" name="gender" value="${staff.gender}"/>
      <input type="hidden" name="lastName" value="${staff.lastName}"/>
      <input type="hidden" name="imageName" value="${staff.imageName}"/>
      <input type="hidden" name="phone" value="${staff.phone}"/>
      <input type="hidden" name="salary" value="${staff.salary}"/>
      
      
         <label>Enter  Your New Password</label>         
    <div class="form-group has-feedback">
        <input type="password" name="password"  id="password1" class="form-control" placeholder="Password" required>
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
        <div class="text-danger" id="errorlength"></div>
      </div>
      
       <label>Re-Enter  Your Password</label>         
     <div class="form-group has-feedback">
        <input type="password" id="password2"   class="form-control" placeholder=" Re-Enter Password" required>
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
      <div class="text-danger" id="error"></div>
      
      <div class="row">
        <div class="col-xs-8">
          
        <!-- /.col -->
        <div class="col-xs-4">
          <button  class="btn btn-primary">Submit</button>
         
        </div>
        <!-- /.col -->
      </div>
    </form>
    

   
  <!-- /.login-box-body -->
</div>
<!-- /.login-box -->

<!-- jQuery 3 -->
<script src="${pageContext.request.contextPath}/resources/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="${pageContext.request.contextPath}/resources/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="${pageContext.request.contextPath}/resources/plugins/iCheck/icheck.min.js"></script>
<script>
  $(function () {
    $('input').iCheck({
      checkboxClass: 'icheckbox_square-blue',
      radioClass: 'iradio_square-blue',
      increaseArea: '20%' /* optional */
    });
  });
  
   

  window.onload = function () {
		document.getElementById("password1").onchange = validatePassword;
		document.getElementById("password2").onchange = validatePassword;
	}

	function validatePassword() {
		var pass2 = document.getElementById("password2").value;
		var pass1 = document.getElementById("password1").value;
		if (pass1 != pass2)
			document.getElementById("password2").setCustomValidity("Passwords Don't Match");
		else
			document.getElementById("password2").setCustomValidity('');
		
	}
	  
  
 
 
  
</script>



</body>
</html>
