<%@page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance"
	prefix="layout"%>
<%@ taglib prefix="v" uri="http://java.sun.com/jsp/jstl/core"%>
<layout:extends name="base">
	<layout:put block="contents">
		<section class="content-header">
			<h1 class="fa fa-road" style="font-size:48px">
				<b>Liste des aeroports</b>
			</h1>
			<ol class="breadcrumb">
				<li><a href="dashboard.jsp"><i class="fa fa-dashboard"></i> Home</a></li>
				<li><a href="#">Admin</a></li>
				<li class="active"><a href="#">Aeroport</a></li>
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
			                      <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" data-whatever="@getbootstrap" style="/* text-align: right; */">
			                        <span class="glyphicon glyphicon-plus-sign"></span>ADD</button>
			                  </div>
			              	</div>
							<div class="modal fade" id="exampleModal" tabindex="-1"
								role="dialog" aria-labelledby="exampleModalLabel">
								<div class="modal-dialog" role="document">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
											<h4 class="modal-title" id="exampleModalLabel">Ajouter un aeroport</h4>
										</div>
										<div class="modal-body">
											<form method="POST" action="aeroport/add.htm">
												<div class="form-group">
													<label for="recipient-name" class="control-label">Nom aeroport:</label> 
													<input type="text" class="form-control" name="nom">
												</div>
												<div class="form-group">
													<label for="message-text" class="control-label">Ville Aeroport:</label> 
													<input type="text" class="form-control" name="ville">
												</div>
												<input type="submit" class="btn btn-primary" value="Enregistrer">
											</form>
										</div>

									</div>
								</div>
							</div>

						</div>
						<!-- /.box-header -->
						<div class="box-body">
							<v:choose>
								<v:when test="${not empty listeAeroport}">
									<table id="mondatatable" class="table table-bordered table-hover">
										<thead>
											<tr>
												<th>Nom Aeroport</th>
												<th>Ville Aeroport</th>
												<th>Option</th>

											</tr>
										</thead>
										<tbody>
											<v:forEach items="${listeAeroport}" var="o">
												<tr>
													<td>${o.nom}</td>
													<td>${o.ville}</td>
													<td><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#${o.id}" data-whatever="@getbootstrap">
															<span class="glyphicon glyphicon-pencil"></span></button>
                            							<a href="aeroport/delete.htm?id=${o.id}" class="btn btn-primary">
                            								<span class="glyphicon glyphicon-trash"></span></a>
														<div class="modal fade" id="${o.id}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
															<div class="modal-dialog" role="document">
																<div class="modal-content">
																	<div class="modal-header">
																		<button type="button" class="close" data-dismiss="modal" aria-label="Close">
																			<span aria-hidden="true">&times;</span>
																		</button>
																		<h4 class="modal-title" id="exampleModalLabel">Modifier un aeroport</h4>
																	</div>
																	<div class="modal-body">
																		<form method="POST" action="aeroport/update.htm?id=${o.id}">
																			<div class="form-group">
																				<label for="recipient-name" class="control-label">Nom aeroport:</label> 
																				<input type="text" class="form-control"  name="nom" value="${o.nom}"/>
																			</div>
																			<div class="form-group">
																				<label for="message-text" class="control-label">Ville aeroport:</label> 
																				<input type="text" class="form-control" name="ville" value="${o.ville}"/>
																			</div>
																			<input type="submit" class="btn btn-primary" value="Enregistrer"/>
																		</form>
																	</div>
																</div>
															</div>
														</div></td>
												</tr>
											</v:forEach>
										</tbody>
									</table>
								</v:when>
								<v:otherwise>
									<div class="row">
										<div class="col-md-offset-2 col-md-8">
											<div style='text-align: center;'>
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
