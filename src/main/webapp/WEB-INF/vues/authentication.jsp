<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<style type="text/css">
			body{
				background-image: url("images/background.jpg");
				 -webkit-background-size: cover;
				  -moz-background-size: cover;
				  -o-background-size: cover;
				  background-size: cover;
			}
		</style>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link href="assets/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
		<title>Airlines</title>
	</head>
	<body onload='document.loginForm.username.focus();'>
		<!--login modal-->
		<div id="loginModal" class="modal show" tabindex="-1" role="dialog" aria-hidden="true">
		  <div class="modal-dialog">
		  <div class="modal-content">
		      <div class="modal-header">
		          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
		          <h1 class="text-center">Connexion</h1>
		      </div>
		      <div class="modal-body">
			      <form:form method="post" class="form col-md-12 center-block" name='loginForm' 
			      commandName="authentication">
			      		<div class="form-group"><form:errors path="error" cssClass="error" /></div>
				      <div class="form-group">
				      		<label id="auth-label" class="control-label" >Nom d'utilisateur: </label>
							<form:input class="form-control input-lg" path="login" placeholder="Login" id="login" />
							<form:errors path="login" cssClass="error" />
			            </div>
			            <div class="form-group">
			           		<label id="auth-label" class="control-label">Mot de passe: </label>
							<form:password class="form-control input-lg" path="password" placeholder="Password"
										id="password" />
							<form:errors path="password" cssClass="error" />
			            </div>
			            <div class="form-group">
<!-- 			            	<input type="submit" value="Connexion"> <input type="reset" value="Annulation"> -->
			              	<button class="btn btn-primary btn-lg btn-block" name="submit">Sign In</button>
			              	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			            </div>
				</form:form>
		      </div>
		      <div class="modal-footer">
		          <div class="col-md-12">
				  </div>	
		      </div>
		  </div>
		  </div>
		</div>
		<!-- jQuery -->
	    <script src="assets/bootstrap/js/jquery.min.js"></script>
	
	    <!-- Bootstrap Core JavaScript -->
	    <script src="assets/bootstrap/css/bootstrap.min.css"></script>
</body>
</html>