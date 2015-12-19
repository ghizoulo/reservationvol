<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout"%>
<%@ taglib prefix="v" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix='form' uri='http://www.springframework.org/tags/form' %>

<%@ page import="java.util.Date" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<layout:extends name="adminBase">
    <layout:put block="contents">
 		<div class="wrapper pad1">
      <article class="col1">
        <div class="box1">
            <h2 class="top">Vous avez Choisi</h2>
            <div class="pad">
              <div class="wrapper pad_bot1">
                <div class="bootstrap">
                	<div class="bs-example" data-example-id="striped-table"> 
	                	<table class="table table-striped">
	                		<tbody> 
	                			<tr>  
	                				<td>De</td> 
	                				<td><v:out value="${sessionScope.depart}" /></td>  
	                			</tr> 
	                			<tr> 
	                				<td>A</td> 
	                				<td><v:out value="${sessionScope.destination}" /></td> 
	                			</tr> 
	                			<tr> 
	                				<td>Départ</td> 
	                				<td><v:out value="${sessionScope.dateDepart}" /></td>	
	                			</tr>
	                			<tr> 
	                				<td>Retour</td> 
	                				<td><v:out value="${sessionScope.dateRetour}" /></td> 
	                			</tr>
	                			<tr> 
	                				<td>Classe</td> 
	                				<td><v:out value="${sessionScope.classe}" /></td>
	                			</tr>
	                			<tr> 
	                				<td>Escale?</td> 	
	                				<td><v:out value="${sessionScope.escale}" /></td> 	
	                			</tr> 
	                			<tr> 
	                				<td>Prix Total</td> 	
	                				<td><v:out value="${sessionScope.prixDepart+sessionScope.prixRetour}" /></td> 	
	                			</tr> 
	                		</tbody> 
	                	</table> 
                    </div>
                </div>
              </div>
            </div>
        </div>
      </article>
      <article class="col2">
      	<h5>Index > Liste des Voles > Informations personnelles</h5>
      	<div class="bootstrap">
      		<h3>Coordonnées & Informations </h3>
      		<form:form  action="paiement.htm" method="POST" commandName="passagerClient">
				 <div class="panel panel-default" style="width:45%; display:inline-block">
					  <div class="panel-heading"><B style="color: DodgerBlue;">Client</B></div>
					  <div class="panel-body">
					   	  <div class="form-group">
						  	<input type="text" class="form-control" placeholder="Nom" name="nomC"required>
						  </div>
						  <div class="form-group">
						  	<input type="text" class="form-control" placeholder="Prénom" name="prenomC" required>
						  </div>
						  <div class="form-group">
							 <input type="text" class="form-control"  placeholder="Adresse" name="adresseC" required>
						  </div>
						  <div class="form-group">
							 <input type="text" class="form-control"  placeholder="Téléphone" name="telephoneC" required>
						  </div>
						  <div class="form-group">
							 <input type="email" class="form-control"  placeholder="Email" name="mailC" required>
						  </div>
					  </div>
				 </div> 
				 <div class="panel panel-default" style="width:45%; display:inline-block" >
					  <div class="panel-heading"><B style="color: DodgerBlue;">Passager</B></div>
					  <div class="panel-body">
						  <div class="form-group">
						  	<input type="text" class="form-control" placeholder="Nom" name="nomP" required>
						  </div>
						  <div class="form-group">
							<input type="text" class="form-control"  placeholder="Prénom" name="prenomP" required>
						  </div>
						  <div class="form-group">
							 <input type="text" class="form-control"  placeholder="Numero Passeport" name="num_passport" required>
						  </div>
						  <div class="form-group">
							 <input type="text" class="form-control"  placeholder="Date d'expiration Paseport" name="dateExpiration" required>
						  </div>
						  <div class="form-group">
							 <input type="text" class="form-control"  placeholder="Nationalité" name="nationalite" required>
						  </div>
					  </div>
				 </div> 
				  <button type="submit" class="btn btn-info" style="display:block"> Enregistrer</button>
			</form:form>
      	</div>
      </article>
      
    </div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    </layout:put>
</layout:extends>
