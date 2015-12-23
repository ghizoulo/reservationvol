<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Airlines</title>
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
	    <!-- Bootstrap 3.3.5 -->
	    <link rel="stylesheet" href="/ReservationVol/assets/bootstrap/css/bootstrap.min.css">
	    <!-- Font Awesome -->
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	    <!-- Ionicons -->
	    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
	    <!-- Theme style -->
	    <link rel="stylesheet" href="/ReservationVol/assets/dist/css/AdminLTE.min.css">
	    <!-- AdminLTE Skins. Choose a skin from the css/skins
	         folder instead of downloading all of them to reduce the load. -->
	    <link rel="stylesheet" href="/ReservationVol/assets/dist/css/skins/_all-skins.min.css">
	    <!-- iCheck -->
	    <link rel="stylesheet" href="/ReservationVol/assets/plugins/iCheck/flat/blue.css">
	    <!-- Morris chart -->
	    <link rel="stylesheet" href="/ReservationVol/assets/plugins/morris/morris.css">
	    <!-- jvectormap -->
	    <link rel="stylesheet" href="/ReservationVol/assets/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
	    <!-- Date Picker -->
	    <link rel="stylesheet" href="/ReservationVol/assets/plugins/datepicker/datepicker3.css">
      <link rel="stylesheet" href="/ReservationVol/assets/plugins/datatables/dataTables.bootstrap.css">
	    <!-- Daterange picker -->
	    <link rel="stylesheet" href="/ReservationVol/assets/plugins/daterangepicker/daterangepicker-bs3.css">
	    <!-- bootstrap wysihtml5 - text editor -->
	    <link rel="stylesheet" href="/ReservationVol/assets/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
	
	    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
	    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	    <!--[if lt IE 9]>
	        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
	        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	    <![endif]-->
    </head>
    <body class="hold-transition skin-blue sidebar-mini">
		<div class="wrapper">
			 <header class="main-header">
        <!-- Logo -->
        <a href="index2.html" class="logo">
          <!-- mini logo for sidebar mini 50x50 pixels -->
          <span class="logo-mini"><b>A</b>LT</span>
          <!-- logo for regular state and mobile devices -->
          <span class="logo-lg"><b>Admin</b>Vol</span>
        </a>
        <!-- Header Navbar: style can be found in header.less -->
        <nav class="navbar navbar-static-top" role="navigation">
          <!-- Sidebar toggle button-->
          <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
            <span class="sr-only">Toggle navigation</span>
          </a>
          <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
              <!-- User Account: style can be found in dropdown.less -->
              <li class="dropdown user user-menu">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                  <img src="assets/dist/img/khadija.jpg" class="user-image" alt="User Image">
                  <span class="hidden-xs">khadija Machhoud</span>
                </a>
                <ul class="dropdown-menu">
                  <!-- User image -->
                  <li class="user-header">
                   <!-- <img src="dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">-->
                    <p>
                      khadija Machhoud - Web Developer
                      <small>Member since ?????</small>
                    </p>
                  </li>
                  <!-- Menu Footer-->
                  <li class="user-footer">
                    <div class="pull-left">
                      <a href="#" class="btn btn-default btn-flat">Profile</a>
                    </div>
                    <div class="pull-right">
                      <a href="/profile/logout.htm" class="btn btn-default btn-flat">Sign out</a>
                    </div>
                  </li>
                </ul>
              </li>
              <!-- Control Sidebar Toggle Button -->
              <li>
                <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
              </li>
            </ul>
          </div>
        </nav>
      </header>
      <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
          <!-- Sidebar user panel -->
          <div class="user-panel">
            <div class="pull-left image">
             <img src="assets/dist/img/khadija.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
              <p>khadija Machhoud</p>
              <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
          </div>
          <!-- search form -->
          <form action="#" method="get" class="sidebar-form">
            <div class="input-group">
              <input type="text" name="q" class="form-control" placeholder="Search...">
              <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i></button>
              </span>
            </div>
          </form>
          <!-- /.search form -->
          <!-- sidebar menu: : style can be found in sidebar.less -->
          <ul class="sidebar-menu">
            <li class="header">MAIN NAVIGATION</li>
             <li class="treeview">
              <a href="compagnie.htm">
                <i class="fa fa-pie-chart"></i>
                <span>Compagnie</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
            </li>
              <li class="treeview">
              <a href="vol.htm">
                <i class="fa fa-pie-chart"></i>
                <span>Vol</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
            </li>
            <li class="treeview">
              <a href="aeroport.htm">
                <i class="fa fa-pie-chart"></i>
                <span>Aeroport</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
            </li>
            <li class="treeview">
              <a href="assurance.htm">
                <i class="fa fa-pie-chart"></i>
                <span>Assurance</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
            </li>
            <li class="treeview">
              <a href="user.htm">
                <i class="fa fa-pie-chart"></i>
                <span>Utilisateur</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
            </li>
          </ul>
        </section>
        <!-- /.sidebar -->
      </aside>
      <div class="content-wrapper">
      	<layout:block name="contents">
	        
	    </layout:block>
      </div>
      <footer class="main-footer">
        <div class="pull-right hidden-xs">
          <b>Version</b> 2.3.0
        </div>
        <strong>Copyright &copy; 2014-2015 <a href="http://almsaeedstudio.com">Almsaeed Studio</a>.</strong> All rights reserved.
      </footer>
		
			
			
		</div>
		<script src="/ReservationVol/assets/plugins/jQuery/jQuery-2.1.4.min.js"></script>
		<!-- jQuery UI 1.11.4 -->
		<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
		<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
		<script>
		  $.widget.bridge('uibutton', $.ui.button);
		</script>
		<!-- Bootstrap 3.3.5 -->
		<script src="/ReservationVol/assets/bootstrap/js/bootstrap.min.js"></script>
		<!-- Morris.js charts -->
		<script src="https://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
		<script src="/ReservationVol/assets/plugins/morris/morris.min.js"></script>
		<!-- Sparkline -->
		<script src="/ReservationVol/assets/plugins/sparkline/jquery.sparkline.min.js"></script>
		<!-- jvectormap -->
		<script src="/ReservationVol/assets/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
		<script src="/ReservationVol/assets/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
		<!-- jQuery Knob Chart -->
		<script src="/ReservationVol/assets/plugins/knob/jquery.knob.js"></script>
		<!-- daterangepicker -->
		<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.2/moment.min.js"></script>
		<script src="/ReservationVol/assets/plugins/daterangepicker/daterangepicker.js"></script>
		<!-- datepicker -->  
		<script src="/ReservationVol/assets/plugins/datepicker/bootstrap-datepicker.js"></script>
		<!-- Bootstrap WYSIHTML5 -->
		<script src="/ReservationVol/assets/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
		<!-- Slimscroll -->
		<script src="/ReservationVol/assets/plugins/slimScroll/jquery.slimscroll.min.js"></script>
		<!-- FastClick -->
		<script src="/ReservationVol/assets/plugins/fastclick/fastclick.min.js"></script>
		<!-- DataTables -->
    	<script src="/ReservationVol/assets/plugins/datatables/jquery.dataTables.min.js"></script>
    	<script src="/ReservationVol/assets/plugins/datatables/dataTables.bootstrap.min.js"></script>
		<!-- AdminLTE App -->
		<script src="/ReservationVol/assets/dist/js/app.min.js"></script>
		<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
		<script src="/ReservationVol/assets/dist/js/pages/dashboard.js"></script>
		<!-- AdminLTE for demo purposes -->
		<script src="/ReservationVol/assets/dist/js/demo.js"></script>
		<!-- my script -->
		<script src="/ReservationVol/assets/script.js"></script>

		</body>
</html>