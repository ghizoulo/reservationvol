<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout"%>
<!DOCTYPE html>
	<html lang="en">
		<head>
			<title>AirLines | Accueil</title>
			<meta charset="utf-8">
			<link rel="stylesheet" href="/ReservationVol/assets/userAssets/css/reset.css" type="text/css" media="all">
			<link rel="stylesheet" href="/ReservationVol/assets/userAssets/css/layout.css" type="text/css" media="all">
			<link rel="stylesheet" href="/ReservationVol/assets/userAssets/css/style.css" type="text/css" media="all">
			<link rel="stylesheet" href="/ReservationVol/assets/userAssets/css/myLogin.css" type="text/css" media="all">
			<link rel="stylesheet" href="/ReservationVol/assets/userAssets/css/bootstrap.min.css" type="text/css" >
			<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css">
			<script type="text/javascript" src="/ReservationVol/assets/userAssets/js/jquery-1.5.2.js" ></script>
			<script type="text/javascript" src="/ReservationVol/assets/userAssets/js/cufon-yui.js"></script>
			<script type="text/javascript" src="/ReservationVol/assets/userAssets/js/cufon-replace.js"></script>
			<script type="text/javascript" src="/ReservationVol/assets/userAssets/js/Cabin_400.font.js"></script>
			<script type="text/javascript" src="/ReservationVol/assets/userAssets/js/tabs.js"></script>
			<script type="text/javascript" src="/ReservationVol/assets/userAssets/js/jquery.jqtransform.js" ></script>
			<script type="text/javascript" src="/ReservationVol/assets/userAssets/js/jquery.nivo.slider.pack.js"></script>
			<script type="text/javascript" src="/ReservationVol/assets/userAssets/js/atooltip.jquery.js"></script>
			<script type="text/javascript" src="/ReservationVol/assets/userAssets/js/script.js"></script>
			<script type="text/javascript" src="/ReservationVol/assets/userAssets/js/bootstrap.js"></script>
			<!--[if lt IE 9]>
			<script type="text/javascript" src="/ReservationVol/assets/userAssets/js/html5.js"></script>
			<style type="text/css">.main, .tabs ul.nav a, .content, .button1, .box1, .top { behavior:url("../js/PIE.htc")}</style>
			<![endif]-->
		</head>
		<body id="page3">
			  <div class="main">
	 			  <!--header -->
					  <header>
					    <div class="wrapper">
					      <h1><a href="index.html" id="logo">AirLines</a></h1>
					      <span id="slogan">Fast, Frequent &amp; Safe Flights</span>
					      <nav id="top_nav">
					        <ul>
					          <li><a href="index.html" class="nav1">Home</a></li>
					          <li><a  class="nav2" data-toggle="modal" href="#myModal">Login</a></li>
					          <li><a href="contacts.html" class="nav3">Contact</a></li>
					        </ul>
					      </nav>
					    </div>
					    <nav>
					      <ul id="menu">
					        <li id="menu_active"><a href="index.html"><span><span>Recherche</span></span></a></li>
					        <li ><a href="book.html"><span><span>Meilleurs Prix</span></span></a></li>
					        <li><a href="safety.html"><span><span>Safety</span></span></a></li>
					        <li class="end"><a href="contacts.html"><span><span>Contacts</span></span></a></li>
					      </ul>
					    </nav>
					  </header>
	 			  <!-- / header -->
				  <!-- Content -->
						<section id="content">
					      	<layout:block name="contents">
						        
						    </layout:block>
					   </section>
				  <!-- end of content -->
				  <!--footer -->
						  <footer>
						    <div class="wrapper">
						      <ul id="icons">
						        <li><a href="#" class="normaltip"><img src="images/icon1.jpg" alt=""></a></li>
						        <li><a href="#" class="normaltip"><img src="images/icon2.jpg" alt=""></a></li>
						        <li><a href="#" class="normaltip"><img src="images/icon3.jpg" alt=""></a></li>
						        <li><a href="#" class="normaltip"><img src="images/icon4.jpg" alt=""></a></li>
						        <li><a href="#" class="normaltip"><img src="images/icon5.jpg" alt=""></a></li>
						        <li><a href="#" class="normaltip"><img src="images/icon6.jpg" alt=""></a></li>
						      </ul>
						      <div class="links">Copyright &copy; <a href="#">Domain Name</a> All Rights Reserved<br>
						        Design by <a target="_blank" href="http://www.templatemonster.com/">TemplateMonster.com</a></div>
						    </div>
						  </footer>
			  	  <!--footer end-->
		      </div>
			  <script type="text/javascript">Cufon.now();
			  </script>
			  <script type="text/javascript">
					jQuery(document).ready(function ($) {
					    $('.form_5').jqTransform({
					        imgPath: 'jqtransformplugin/img/'
					    });
					});
					$(document).ready(function () {
					    tabs2.init();
					});
					$(function() {
					
					    $('#login-form-link').click(function(e) {
					    $("#login-form").delay(100).fadeIn(100);
					    $("#register-form").fadeOut(100);
					    $('#register-form-link').removeClass('active');
					    $(this).addClass('active');
					    e.preventDefault();
					  });
					  $('#register-form-link').click(function(e) {
					    $("#register-form").delay(100).fadeIn(100);
					    $("#login-form").fadeOut(100);
					    $('#login-form-link').removeClass('active');
					    $(this).addClass('active');
					    e.preventDefault();
					  });
					
					});
			</script>
		</body>
	</html>
		