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
					  <h2>Lancez votre recherche de vol</h2>
					  <ul class="nav nav-tabs">
					    <li class="active"><a data-toggle="tab" href="#home">Allée Simple</a></li>
					    <li><a data-toggle="tab" href="#menu1">Allée-Retour </a></li>
					  </ul>
					
					  <div class="tab-content">
					    <div id="home" class="tab-pane fade in active">
					      <form action="chercherSimple.htm" method="POST">
					      <br/>
					      		  <div class="form-group">
								    <label for="exampleInputEmail1">Aeroport Départ</label>
								    <select class="form-control" name="idAeroportDepart" required>
								    		<option value="" disabled selected>Aéroport de Départ</option>
										  <v:forEach items="${listeAeroport}" var="aD">
											<option value="${aD.id}">${aD.nom}</option>
									      </v:forEach>
									</select>
								  </div>
								  <div class="form-group">
								    <label for="exampleInputEmail1">Aeroport d'arrivée</label>
								    <select class="form-control" name="idAeroportArrivee" required>
								    		<option value="" disabled selected>Aéroport d'Arrivée</option>
										  <v:forEach items="${listeAeroport}" var="aA">
											<option value="${aA.id}">${aA.nom}</option>
									    </v:forEach>
									</select>
								  </div>
								  <div class="form-group">
								          <label >Escale</label>
										  <div class="radio">
										    <label>
										      <input type="radio" name="escale" value="Non" checked> Sans Escale
										    </label> &nbsp;
										    <label>
										      <input type="radio" name="escale" value="Oui"> Avec Escale
										    </label>
										  </div>
								 </div>
								 <div class="form-group">
								          <label for="exampleInputEmail1">Date Départ</label> &nbsp; &nbsp;
										  <v:set var="today" value="<%=new Date()%>"/>
										  <v:set var="tomorrow" value="<%=new Date(new Date().getTime() + 60*60*24*1000)%>"/>
										 <input type="date" class="btn btn-primary" name="dateDepart" min="<fmt:formatDate type="date" value="${today}" pattern="yyyy-MM-dd"/>" value="<fmt:formatDate type="date" value="${today}" pattern="yyyy-MM-dd"/>"/>
								 </div>
								 <div class="form-group">
								    <label for="exampleInputEmail1">Classe</label>
								    <select class="form-control" name="classe" required>
								      <option value="" disabled selected>Selectionnez la classe</option>
									  <option value="Economique">Economique</option>
									  <option value="Premium">Premium économique</option>
									  <option value="Affaire">Affaires</option>
									  <option value="Premiere">Première</option>
									</select>
								  </div>
								  <div class="form-group">
								    <label for="exampleInputEmail1">Compagnie aérienne</label>
								    <select class="form-control btn-sm" name="compagnie" required>
								    		<option value="" disabled selected>Selectionnez la Compgnie Aérienne</option>
								    	<v:forEach items="${listeCompagnie}" var="o">
											<option value="${o.id}">${o.nom}</option>
									    </v:forEach>
									</select>
								  </div>
								  <button type="submit" class="btn btn-default">Submit</button>
					      </form>
					    </div>
					    <div id="menu1" class="tab-pane fade">
					      <form action="chercherAlleeRetour.htm" method="POST">
					      <br/>
					      		  <div class="form-group">
								    <label for="exampleInputEmail1">Aeroport Départ</label>
								    <select class="form-control" name="idAeroportDepart" required>
								    		<option value="" disabled selected>Aéroport de Départ</option>
										  <v:forEach items="${listeAeroport}" var="aD">
											<option value="${aD.id}">${aD.nom}</option>
									    </v:forEach>
									</select>
								  </div>
								  <div class="form-group">
								    <label for="exampleInputEmail1">Aeroport d'arrivée</label>
								    <select class="form-control" name="idAeroportArrivee" required>
								    		<option value="" disabled selected>Aéroport d'Arrivée</option>
										  <v:forEach items="${listeAeroport}" var="aA">
											<option value="${aA.id}">${aA.nom}</option>
									    </v:forEach>
									</select>
								  </div>
								  <div class="form-group">
								          <label >Escale</label>
										  <div class="radio">
										    <label>
										      <input type="radio" name="escale" value="Non" checked> Sans Escale
										    </label> &nbsp;
										    <label>
										      <input type="radio" name="escale" value="Oui"> Avec Escale
										    </label>
										  </div>
								 </div>
								 <div class="form-group">
								          <label for="exampleInputEmail1">Date Départ</label> &nbsp; &nbsp;
										  <v:set var="today" value="<%=new Date()%>"/>
										  <v:set var="tomorrow" value="<%=new Date(new Date().getTime() + 60*60*24*1000)%>"/>
										 <input type="date" class="btn btn-primary" name="dateDepart" min="<fmt:formatDate type="date" value="${today}" pattern="yyyy-MM-dd"/>" value="<fmt:formatDate type="date" value="${today}" pattern="yyyy-MM-dd"/>"/>
								 </div>
								 <div class="form-group">
								          <label for="exampleInputEmail1">DateRetour</label> &nbsp; &nbsp;
										  <v:set var="today" value="<%=new Date()%>"/>
										  <v:set var="tomorrow" value="<%=new Date(new Date().getTime() + 60*60*24*1000)%>"/>
										 <input type="date" class="btn btn-primary" name="dateRetour" min="<fmt:formatDate type="date" value="${today}" pattern="yyyy-MM-dd"/>" value="<fmt:formatDate type="date" value="${today}" pattern="yyyy-MM-dd"/>"/>
								 </div>
								 <div class="form-group">
								    <label for="exampleInputEmail1">Classe</label>
								    <select class="form-control" name="classe" required>
								      <option value="" disabled selected>Selectionnez la classe</option>
									  <option value="Economique">Economique</option>
									  <option value="Premium">Premium économique</option>
									  <option value="Affaire">Affaires</option>
									  <option value="Premiere">Première</option>
									</select>
								  </div>
								  <div class="form-group">
								    <label for="exampleInputEmail1">Compagnie aérienne</label>
								    <select class="form-control btn-sm" name="compagnie" required>
								    		<option value="" disabled selected>Selectionnez la Compgnie Aérienne</option>
								    	<v:forEach items="${listeCompagnie}" var="o">
											<option value="${o.id}">${o.nom}</option>
									    </v:forEach>
									</select>
								  </div>
								  <button type="submit" class="btn btn-default">Submit</button>
					      </form>
					    </div>
					  </div>
				</div>
	         </div>
		</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    </layout:put>
</layout:extends>
