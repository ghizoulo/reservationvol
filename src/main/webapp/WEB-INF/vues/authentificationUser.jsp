<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout"%>
<%@ taglib prefix="v" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.Date" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<layout:extends name="adminBase">
    <layout:put block="contents">
 		<div class="wrapper pad1">
	         <div class="bootstrap" style="width:50%; margin-left:25%;">
					<div class="container">
					<span> ${msg_erreur}</span>
				      <form class="form-signin" action="authentificationUser.htm" method="POSt">
				        <h2 class="form-signin-heading">Please sign in</h2>
				        <label for="inputEmail" class="sr-only">Email address</label>
				        <input type="email" id="inputEmail" name="username" class="form-control" placeholder="Email address" required autofocus> <br>
				        <label for="inputPassword" class="sr-only">Password</label>
				        <input type="password" id="inputPassword" name="psw" class="form-control" placeholder="Password is your id registration" required>
				        <div class="checkbox">
				        </div>
				        <button class="btn btn-lg btn-primary btn-block" style="width:150px;" type="submit">se connecter</button>
				      </form>

    </div>
	         </div>
		</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    </layout:put>
</layout:extends>
