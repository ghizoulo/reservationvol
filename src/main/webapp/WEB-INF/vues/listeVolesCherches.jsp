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
	                				<td>${depart}</td> 
	                			</tr> 
	                			<tr> 
	                				<td>A</td> 
	                				<td>${destination}</td> 
	                			</tr> 
	                			<tr> 
	                				<td>Départ</td> 
	                				<td>${dateDepart}</td> 
	                			</tr>
	                			<tr> 
	                				<td>Retour</td> 
	                				<td>${dateRetour}</td> 
	                			</tr>
	                			<tr> 
	                				<td>Classe</td> 
	                				<td>${classe}</td> 
	                			</tr>
	                			<tr> 
	                				<td>Escale?</td> 
	                				<td>${escale}</td> 
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
        <h3 class="pad_top1">Liste des vols disponibles</h3>
        <div class="bootstrap">
          <p>Choisissez le vol qui vous convient...</p>
          <form action="choisirVol" method="POST">
              <table class="table table-hover">
                    <thead> 
                      <tr> 
                         <th>Companie</th> 
                         <th>Prix</th> 
                         <th>Allée</th> 
                         <th>Retour</th> 
                         <th>Description</th> 
                      </tr> 
                    </thead> 
                    <tbody> 
                        <tr> 
                            <th scope="row">image</th>
                            <td>Mark</td>
                            <td>Otto</td> 
                            <td>@mdo</td> 
                            <td>bla bla bla bla bla bla bnla anla </td>
                            <td><input type="submit" class="button1" value="choisir"></td> 
                        </tr> 
                        <tr> 
                            <th scope="row">image</th>
                            <td>Jacob</td> 
                            <td>Thornton</td> 
                            <td>@fat</td> 
                            <td>bla bla bla bla bla bla bnla anla </td>
                            <td><input type="submit" class="button1" value="choisir"></td> 
                        </tr> 
                        <tr> 
                            <th scope="row">image</th>
                            <td>Larry</td> 
                            <td>the Bird</td> 
                            <td>@twitter</td> 
                            <td>bla bla bla bla bla bla bnla anla </td>
                            <td><input type="submit" class="button1" value="choisir"></td> 
                        </tr> 
                    </tbody> 
              </table>
          </form>
        </div>
      </article>
    </div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    </layout:put>
</layout:extends>
