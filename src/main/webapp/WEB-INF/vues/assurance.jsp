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
							<h3 class="box-title">Liste des assurances</h3>
							<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" data-whatever="@getbootstrap">ADD</button>
							<div class="modal fade" id="exampleModal" tabindex="-1"
								role="dialog" aria-labelledby="exampleModalLabel">
								<div class="modal-dialog" role="document">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal" aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
											<h4 class="modal-title" id="exampleModalLabel">Ajouter une assurance</h4>
										</div>
										<div class="modal-body">
											<form method="POST" action="assurance/add.htm">
												<div class="form-group">
													<label for="recipient-name" class="control-label">Type Assurance:</label> <input type="text" class="form-control" name="type">
												</div>
												<div class="form-group">
													<label for="message-text" class="control-label">Tarif:</label>
													<input type="text" class="form-control" name="tarif">
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
								<v:when test="${not empty listeAssurance}">
									<table id="example2" class="table table-bordered table-hover">
										<thead>
											<tr>
												<th>Type Assurance</th>
												<th>Tarif</th>
												<th>Option</th>
											</tr>
										</thead>
										<tbody>
											<v:forEach items="${listeAssurance}" var="o">
												<tr>
													<td>${o.type}</td>
													<td>${o.tarif}</td>
													<td><a href="assurance/delete.htm?id=${o.id}">supprimer</a>
														<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#${o.id}" data-whatever="@getbootstrap">Modifier</button>
														<div class="modal fade" id="${o.id}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
															<div class="modal-dialog" role="document">
																<div class="modal-content">
																	<div class="modal-header">
																		<button type="button" class="close" data-dismiss="modal" aria-label="Close">
																			<span aria-hidden="true">&times;</span>
																		</button>
																		<h4 class="modal-title" id="exampleModalLabel">Modifier une assurance</h4>
																	</div>
																	<div class="modal-body">
																		<form method="POST" action="assurance/update.htm?id=${o.id}">
																			<div class="form-group">
																				<label for="recipient-name" class="control-label">Type Assurance:</label> <input type="text" class="form-control" id="exampleInputEmail1" name="type" value="${o.type}">
																				<!--<input type="text" class="form-control" name="type" placeholder="hhhhh">-->
																			</div>
																			<div class="form-group">
																				<label for="message-text" class="control-label">Tarif:</label>
																				<input type="text" class="form-control" name="tarif" value="${o.tarif}">
																			</div>
																			<input type="submit" class="btn btn-primary" value="Enregistrer">
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
