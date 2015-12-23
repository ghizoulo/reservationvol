<%@page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance"
	prefix="layout"%>
<%@ taglib prefix="v" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<layout:extends name="base">
	<layout:put block="contents">
		<section class="content-header">
			<h1>
				<b>Liste des utilisateurs</b>
			</h1>
			<ol class="breadcrumb">
				<li><a href="login.jsp"><i class="fa fa-dashboard"></i> Home</a></li>
				<li><a href="#">Admin</a></li>
				<li class="active"><a href="#">Utilisateur</a></li>
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
											<h4 class="modal-title" id="exampleModalLabel">Ajouter un utilisateur</h4>
										</div>
										<div class="modal-body">
											<form:form method="post" action="user/add.htm" commandName="useradd" >
											    <div class="form-group"> 
											        <form:label path="firstName" class="control-label">Prénom : </form:label>
											        <form:input path="firstName" class="form-control"/> 
											        <form:errors path="firstName"/>
											    </div>
											    <div class="form-group"> 
											        <form:label path="lastName" class="control-label">Nom : </form:label>
											        <form:input path="lastName" class="form-control"/> 
											         <form:errors path="lastName"/>
											    </div>
											    <div class="form-group"> 
											        <form:label path="email" class="control-label">Email : </form:label>
											        <form:input path="email" class="form-control"/>
											        <form:errors path="email"/> 
											    </div>
											    <div class="form-group"> 
											        <form:label path="telephone" class="control-label">Téléphone : </form:label>
											        <form:input path="telephone" class="form-control"/> 
											        <form:errors path="telephone"/>
											    </div>
											    <div class="form-group"> 
											        <form:label path="address" class="control-label">Adresse : </form:label>
											        <form:input path="address" class="form-control"/>
											        <form:errors path="address"/>
											    </div>
											    <div class="form-group"> 
											        <form:label path="login" class="control-label">Login : </form:label>
											        <form:input path="login" class="form-control"/> 
											        <form:errors path="login"/>
											    </div>
											    <div class="form-group"> 
											        <form:label path="password" class="control-label">Password : </form:label>
											        <form:password path="password" class="form-control"/>
											        <form:errors path="password"/>
											    </div>
											    <div class="form-group"> 
											        <form:label path="role" class="control-label">Role : </form:label>
											        <form:select path="role" items="${userRoles}" class="form-control"/>
											        <form:errors path="role"/>
											    </div>
											    <input type="submit" class="btn btn-primary" value="Enregistrer">
											</form:form>
										</div>

									</div>
								</div>
							</div>

						</div>
						<!-- /.box-header -->
						<div class="box-body">
							<v:choose>
								<v:when test="${not empty users}">
									<table id="mondatatable" class="table table-bordered table-hover">
										<thead>
											<tr>
												<th>Nom</th>
												<th>Prénom</th>
												<th>Email</th>
												<th>Téléphone</th>
												<th>Adresse</th>
												<th>Role</th>
												<th>Option</th>

											</tr>
										</thead>
										<tbody>
											<v:forEach items="${users}" var="o">
												<tr>
													<td>${o.lastName}</td>
													<td>${o.firstName}</td>
													<td>${o.email}</td>
													<td>${o.telephone}</td>
													<td>${o.address}</td>
													<td>${o.role}</td>
													<td><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#${o.id}" data-whatever="@getbootstrap">
															<span class="glyphicon glyphicon-pencil"></span></button>
                            							<a href="aeroport/delete.htm?id=${o.id}" class="btn btn-primary">
                            								<span class="glyphicon glyphicon-trash"></span></a>
															<div class="modal fade" id="${o.id}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
																<div class="modal-dialog" role="document">
																	<div class="modal-content">
																		<div class="modal-header">
																			<button type="button" class="close" data-dismiss="modal"
																				aria-label="Close">
																				<span aria-hidden="true">&times;</span>
																			</button>
																			<h4 class="modal-title" id="exampleModalLabel">Modifier un utilisateur</h4>
																		</div>
																		<div class="modal-body">
																			<form:form method="post" action="user/add.htm" commandName="useradd" >
																			    <div class="form-group"> 
																			        <form:label path="firstName" class="control-label">Prénom : </form:label>
																			        <form:input path="firstName" class="form-control"/> 
																			        <form:errors path="firstName"/>
																			    </div>
																			    <div class="form-group"> 
																			        <form:label path="lastName" class="control-label">Nom : </form:label>
																			        <form:input path="lastName" class="form-control"/> 
																			         <form:errors path="lastName"/>
																			    </div>
																			    <div class="form-group"> 
																			        <form:label path="email" class="control-label">Email : </form:label>
																			        <form:input path="email" class="form-control"/>
																			        <form:errors path="email"/> 
																			    </div>
																			    <div class="form-group"> 
																			        <form:label path="telephone" class="control-label">Téléphone : </form:label>
																			        <form:input path="telephone" class="form-control"/> 
																			        <form:errors path="telephone"/>
																			    </div>
																			    <div class="form-group"> 
																			        <form:label path="address" class="control-label">Adresse : </form:label>
																			        <form:input path="address" class="form-control"/>
																			        <form:errors path="address"/>
																			    </div>
																			    <div class="form-group"> 
																			        <form:label path="login" class="control-label">Login : </form:label>
																			        <form:input path="login" class="form-control"/> 
																			        <form:errors path="login"/>
																			    </div>
																			    <div class="form-group"> 
																			        <form:label path="password" class="control-label">Password : </form:label>
																			        <form:password path="password" class="form-control"/>
																			        <form:errors path="password"/>
																			    </div>
																			    <div class="form-group"> 
																			        <form:label path="role" class="control-label">Role : </form:label>
																			        <form:select path="role" items="${userRoles}" class="form-control"/>
																			        <form:errors path="role"/>
																			    </div>
																			    <input type="submit" class="btn btn-primary" value="Enregistrer">
																			</form:form>
																		</div>
																	</div>
																</div>
															</div>
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
