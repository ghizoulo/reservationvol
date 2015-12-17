<%@page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance"
	prefix="layout"%>
<%@ taglib prefix="v" uri="http://java.sun.com/jsp/jstl/core"%>
<layout:extends name="base">
	<layout:put block="contents">
		<section class="content-header">
			<h1>
				Data Tables <small>advanced tables</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
				<li><a href="#">Tables</a></li>
				<li class="active">Data tables</li>
			</ol>
		</section>

		<!-- Main content -->
		<section class="content">
			<div class="row">
				<div class="col-xs-12">
					<div class="box">
						<div class="box-header">
							<h3 class="box-title">Liste des Compagnies</h3>
							<button type="button" class="btn btn-primary" data-toggle="modal"
								data-target="#exampleModal" data-whatever="@getbootstrap">ADD</button>

							<div class="modal fade" id="exampleModal" tabindex="-1"
								role="dialog" aria-labelledby="exampleModalLabel">
								<div class="modal-dialog" role="document">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
											<h4 class="modal-title" id="exampleModalLabel">Ajouter
												une Compagnie</h4>
										</div>
										<div class="modal-body">
											<form method="POST" action="compagnie/add.htm"
												enctype="multipart/form-data">
												<div class="form-group">
													<label for="recipient-name" class="control-label">Nom
														Compagnie:</label> <input type="text" class="form-control"
														name="nom">
												</div>
												<div class="form-group">
													<label for="logo" class="control-label">Logo de la
														Compagnie:</label> <input type="file" name="logo"
														class="form-control" />
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
							<div class="row">
								<v:forEach items="${listeCompagnie}" var="elt">
									<div class="col-lg-6">
										<img alt="${elt.nom}" src="../images/images.jpg" height="60" width="60" />
										<div>
											<h3>${elt.nom}</h3>
										</div>
									</div>
								</v:forEach>
							</div>
							<v:choose>
								<v:when test="${not empty listeCompagnie}">
									<table id="example2" class="table table-bordered table-hover">
										<thead>
											<tr>
												<th>Logo de la compagnie</th>
												<th>Nom de la compagnie</th>
												<th>Option</th>
											</tr>
										</thead>
										<tbody>
											<v:forEach items="${listeCompagnie}" var="o">
												<tr>
													<td><img alt="${o.nom}" src="${o.photoName}"></td>
													<td>${o.nom}</td>
													<td><a href="compagnie/delete.htm?id=${o.id}">supprimer</a>
														<button type="button" class="btn btn-primary"
															data-toggle="modal" data-target="#exampleModal"
															data-whatever="@getbootstrap">Modifier</button>
														<div class="modal fade" id="exampleModal" tabindex="-1"
															role="dialog" aria-labelledby="exampleModalLabel">
															<div class="modal-dialog" role="document">
																<div class="modal-content">
																	<div class="modal-header">
																		<button type="button" class="close"
																			data-dismiss="modal" aria-label="Close">
																			<span aria-hidden="true">&times;</span>
																		</button>
																		<h4 class="modal-title" id="exampleModalLabel">Modifier
																			une Compagnie</h4>
																	</div>
																	<div class="modal-body">
																		<form method="POST" action="compagnie/update.htm">
																			<div class="form-group">
																				<label for="recipient-name" class="control-label">Nom
																					Compagnie:</label> <input type="email" class="form-control"
																					id="exampleInputEmail1" placeholder="Enter email">
																				<!--<input type="text" class="form-control" name="type" placeholder="hhhhh">-->
																			</div>
																			<input type="submit" class="btn btn-primary"
																				value="Enregistrer">

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