<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout"%>
<%@ taglib prefix="v" uri="http://java.sun.com/jsp/jstl/core" %>

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
	                				<td>${depart}</td>   <v:set var="depart" value="${depart}" scope="session" />
	                			</tr> 
	                			<tr> 
	                				<td>A</td> 
	                				<td>${destination}</td> 	<v:set var="destination" value="${destination}" scope="session" />
	                			</tr> 
	                			<tr> 
	                				<td>Départ</td> 
	                				<td>${dateDepart}</td>	 <v:set var="dateDepart" value="${dateDepart}" scope="session" />
	                			</tr>
	                			<tr> 
	                				<td>Retour</td> 
	                				<td>${dateRetour}</td> 	<v:set var="dateRetour" value="${dateRetour}" scope="session" />
	                			</tr>
	                			<tr> 
	                				<td>Classe</td> 
	                				<td>${classe}</td> 	<v:set var="classe" value="${classe}" scope="session" />
	                			</tr>
	                			<tr> 
	                				<td>Escale?</td> 	
	                				<td>${escale}</td> 	<v:set var="escale" value="${escale}" scope="session" />
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
      	<h5>Index > Liste des Voles</h5>
        <h3 class="pad_top1">Voles disponibles de ${depart} à ${destination}</h3>
        <div class="bootstrap">
          <v:if test="${not empty listeClassesDepart}">
          <p>Choisissez les voles qui vous conviennent...</p>
          <form action="listeVolesCherchers.htm" method="POST">
          	<h4>Voles du Départ</h4>
              <table class="table table-striped">
                    <thead> 
                      <tr class="info"> 
                         <th>Companie</th> 
                         <th>Prix</th> 
                         <th>Départ</th> 
                         <th>Arrivée</th> 
                         <th>Classe</th>
                         <th>Choix</th> 
                      </tr> 
                    </thead> 
                    <tbody> 
	                    <v:forEach  items="${listeClassesDepart}" var="classes" varStatus="status" >
							<tr> 
		                            <th scope="row">image de compagnie vc id </th>
		                            <td><B>${classes.prix}</B></td>  <!-- Prix -->  
		                            <td>${depart}</td> 				 <!-- aéro depart -->
		                            <td>${destination}</td> 		 <!-- aéro destination -->
		                            <td>${classes.nomClasse} </td>	<!-- classe -->
		                            <td>
		                            	<input type="radio" name="idVolDepart" value="0" style="display:none" checked>
		                            	<input type="radio" name="idVolRetour" value="0" style="display:none" checked>
		                            	<input type="radio" name="idVolDepart" value="${listeVolesDepart[status.index].id}" required>
		                            </td> 
	                        </tr> 
						</v:forEach> 
                    </tbody> 
              </table>
              <v:if test="${not empty listeClassesRetour}" >
              	<h4>Voles du Retour</h4>
	           	 <table class="table table-striped">
                    <thead> 
                      <tr class="info"> 
                         <th>Companie</th> 
                         <th>Prix</th> 
                         <th>Départ</th> 
                         <th>Arrivée</th> 
                         <th>Classe</th>
                         <th>Choix</th> 
                      </tr> 
                    </thead> 
                    <tbody> 
	                    <v:forEach  items="${listeClassesRetour}" var="classes" varStatus="status" >
							<tr> 
	                            <th scope="row">${listeVolesRetour[status.index].id } </th> 
	                            <td><B>${classes.prix}</B></td>  <!-- Prix -->
	                            <td>${destination}</td> 										<!-- aéro depart -->
	                            <td>${depart}</td> 								<!-- aéro destination -->
	                            <td>${classes.nomClasse} </td>	<!-- classe -->
	                            <td>
	                            	<input type="radio" name="idVolRetour" value="${listeVolesRetour[status.index].id}" required>
	                            	
	                            </td> 
	                        </tr> 
						</v:forEach> 
                    </tbody> 
             	 </table>
		 	  </v:if>
              <input type="submit" class="button1" value="Choisir et continuer">
          </form>
          </v:if>
          <v:if test="${empty listeClassesDepart}" >
	           <h4> Sorry, pas de vol correspondants à votre selection, relancez une autre recherche</h4>
		  </v:if>
        </div>
      </article>
    </div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    </layout:put>
</layout:extends>
