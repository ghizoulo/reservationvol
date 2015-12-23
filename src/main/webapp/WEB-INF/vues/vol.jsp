<%@page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance"
	prefix="layout"%>
<%@ taglib prefix="v" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<layout:extends name="base">
	<layout:put block="contents">
		<section class="content-header">
			 <h1 class="fa fa-plane" style="font-size:48px">
				<b>La liste des vols</b>
			</h1>
			<ol class="breadcrumb">
				<li><a href="login.jsp"><i class="fa fa-dashboard"></i>Admin</a></li>
				<li class="active"><a href="#">Vol</a></li>
			</ol>
		</section>

		<!-- Main content -->
		<section class="content">
			<div class="row">
				<div class="col-xs-12">
					<div class="box">
						<div class="box-header">
							<div class="row">
	                            <div class="col-md-1 col-md-offset-11">
		                           	<form method="POST" action="vol/ListForm.htm"> 
		                           		<input type="submit" class="btn btn-primary" value="Add" >
		                           	</form>
	                           </div>
                           </div>
						</div>
						<!-- /.box-header -->
						<div class="box-body">
							<v:choose>
								<v:when test="${not empty listeVol}">
								<table id="mondatatable" class="table table-bordered table-hover">
                                                    <thead>
                                                        <tr>
                                                            <th>Date de départ</th>
                                                            <th>Date d'arrivée</th>
                                                            <th>Heure Depart</th>
                                                            <th>Heure d'arrivée</th>
                                                            <th>Status Vol</th>
                                                            <th>Aeroport Départ</th>
                                                            <th>Aerorport d'arrivée</th>
                                                            <th>Option</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <v:forEach items="${listeVol}" var="o">
                                                            <tr>
                                                                <td><fmt:formatDate pattern="yyyy-MM-dd" value="${o.dateDepart}"/></td> 
                                                                <td><fmt:formatDate pattern="yyyy-MM-dd" value="${o.dateArrivee}"/></td>
                                                                <td><fmt:formatDate type="time" value="${o.heureDepart}"/></td>
                                                                <td><fmt:formatDate type="time" value="${o.heureArrivee}"/></td>
                                                                <v:choose>
                                                                    <v:when test="${o.open == 'true'}">
                                                                        <td>Open</td>
                                                                    </v:when>
                                                                    <v:otherwise>
                                                                        <td>Close</td>
                                                                    </v:otherwise>
                                                                </v:choose>
                                                                <td>${o.aeroportDepart.nom}</td>
                                                                <td>${o.aeroportArrivee.nom}</td>
                                                                <td><a href="vol/delete.htm?id=${o.id}" class="btn btn-primary"><span class="glyphicon glyphicon-trash"></span></a>
                                                                    <a href="vol/updatUp.htm?id=${o.id}" class="btn btn-primary"><span class="glyphicon glyphicon-hand-up"></span></a>
                                                                    <a href="vol/updatDown.htm?id=${o.id}" class="btn btn-primary"><span class="glyphicon glyphicon-hand-down"></span></a>
                                                                     <a href="vol/updateForm.htm?id=${o.id}" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></a>

                                                                 
                                                                    </div>
                                                                </td>
                                                            </tr>
                                                        </v:forEach>
                                                    </tbody>
                                                </table>
								</v:when>
								<v:otherwise>
								<div class="row">
									<div class="col-md-offset-2 col-md-8">
										<div style='text-align:center;'>
											<h3>No data in the database!</h3>
										</div>
									</div>
								</div>
								</v:otherwise>
							</v:choose>
						</div>
						<!-- /.box-body -->
					</div>
					<!-- /.box -->
				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->
		</section>
		<!-- /.content -->
	</layout:put>
</layout:extends>