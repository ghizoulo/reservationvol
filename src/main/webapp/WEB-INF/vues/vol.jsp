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
							<h3 class="box-title">Vol</h3>
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
												un Vol</h4>
										</div>
										<div class="modal-body">
											<form method="POST" action="vol/add.htm">
												<div class="form-group">
													<label for="dateDepart" class="control-label">Date
														Départ:</label> <input type="date" class="form-control"
														name="dateDepart">
												</div>

												<div class="form-group">
													<label for="dateArrivee" class="control-label">Date
														Arrivée:</label> <input type="date" class="form-control"
														name="dateArrivee">
												</div>

												<div class="form-group">
													<label for="heureDepart" class="control-label">heureDepart:</label>
													<input type="text" class="form-control" name="heureDepart">
												</div>
												<div class="form-group">
													<label for="heureArrivee" class="control-label">heureArrivee:</label>
													<input type="text" class="form-control" name="heureArrivee">
												</div>

												<div class="form-group">
													<label class="control-label">Aeroport Départ:</label> 
													<select class="form-control" name="aeroportDepartid">
														<v:forEach items="${listeAeroport}" var="ae">
															<option value="${ae.id}">${ae.nom}</option>
														</v:forEach>
													</select>
												</div>
												<div class="form-group">
													<label class="control-label">Aeroort d'arrivée:</label> <select
														class="form-control" name="aeroportArriveeid">
														<v:forEach items="${listeAeroport}" var="aed">
															<option value="${aed.id}">${aed.nom}</option>
														</v:forEach>
													</select>
												</div>
												<div class="form-group">
													<label class="control-label">Compagnie:</label> <select
														class="form-control" name="compagnieid">
														<v:forEach items="${listeCompagnie}" var="c">
															<option value="${c.id}">${c.nom}</option>
														</v:forEach>
													</select>
												</div>
												<div class="form-group">
													<label class="control-label">Status Vol:</label> <select
														class="form-control" name="open">
														<option value="true">Open</option>
														<option value="false">Close</option>
													</select>
												</div>
												<div class="box box-info">
													<div class="box-header with-border">
														<h3 class="box-title">Info escale</h3>
													</div>
													<!-- /.box-header -->
													<div class="box-body">
														<div class="form-group">
															<label for="heureArrivee" class="control-label">heureArrivee:</label>
															<input type="text" class="form-control"
																name="heureArriveeEscale">
														</div>
														<div class="form-group">
															<label for="heureDepart" class="control-label">heureDepart:</label>
															<input type="text" class="form-control"
																name="heureDepartEscale">
														</div>
														<div class="form-group">
															<label class="control-label">Aeroport:</label> <select
																class="form-control" name="aeroportEscale">
																<v:forEach items="${listeAeroport}" var="Escale">
																	<option value="${Escale.id}">${Escale.nom}</option>
																</v:forEach>
															</select>
														</div>


													</div>
													<!-- /.box-body -->
												</div>
												<!-- /.box -->
												<div class="box box-info">
													<div class="box-header with-border">
														<h3 class="box-title">Info Classe</h3>
													</div>
													<!-- /.box-header -->
													<div class="box-body">
														
															<div class="form-group">
																<label> <input type="checkbox" class="flat-red"
																	name="economique" value="economique" tabindex="1" checked>Économique
																</label> </br> <label for="prixclasse1" class="control-label">Prix:</label>
																<input type="text" class="form-control"
																	name="prixclasse1">
															</div>
														
														
															<div class="form-group">
																<label> <input type="checkbox" class="flat-red"
																	name="premium" value="Premium" tabindex="2">Premium
																	economy</label></br> <label for="prixclasse2" class="control-label">Prix:</label>
																<input type="text" class="form-control"
																	name="prixclasse2">
															</div>
														
														
															<div class="form-group">
																<label> <input type="checkbox" class="flat-red"
																	name="affaires" value="Affaires" tabindex="3">Affaires
																</label></br> <label for="prixclasse3" class="control-label">Prix:</label>
																<input type="text" class="form-control" name="prixclasse3">
															</div>
															<div class="form-group">
																<label> <input type="checkbox" class="flat-red"
																	name="premiere" value="Première" tabindex="4">Première
																</label></br> <label for="prixclasse4" class="control-label">Prix:</label>
																<input type="text" class="form-control"
																	name="prixclasse4">
															</div>
														

													</div>
													<!-- /.box-body -->
												</div>
												<!-- /.box -->
												<input type="submit" class="btn btn-primary"
													value="Enregistrer">
											</form>
										</div>
									</div>
								</div>
							</div>

						</div>
						<!-- /.box-header -->
						<div class="box-body">
							<table id="example2" class="table table-bordered table-hover">
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
											<td>${o.dateDepart}</td>
											<td>${o.dateArrivee}</td>
											<td>${o.heureDepart}</td>
											<td>${o.heureArrivee}</td>
											<td>${o.open}</td>
											<td>${o.aeroportDepart.nom}</td>
											<td>${o.aeroportArrivee.nom}</td>
											<td><a href="vol/delete.htm?id=${o.id}">supprimer</a>
										</tr>
									</v:forEach>
								</tbody>
							</table>
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