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
      	<h5>Index > Liste des Voles > Informations personnelles > Options Vol > Paiement</h5>
      	<div class="bootstrap">
      		<p>Votre réservation a été bien enregistrée. Vous avez 15 jours pour payer votre billet.</p>
      			<h4>Payer Maintenant ?</h4>
      				<form name="_xclick" action="https://www.paypal.com/fr/cgi-bin/webscr" method="post">
						<input type="hidden" name="cmd" value="_xclick">
						<input type="hidden" name="business" value="miryame1992@gmail.com">
						<input type="hidden" name="currency_code" value="EUR">
						<input type="hidden" name="item_name" value="prix_vol">
						<input type="hidden" name="amount" value="150">
						<input type="image" src="https://www.paypalobjects.com/fr_XC/i/btn/btn_buynowCC_LG.gif" border="0" name="submit" alt="PayPal - la solution de paiement en ligne la plus simple et la plus sécurisée !">
						<img alt="" border="0" src="https://www.paypalobjects.com/fr_XC/i/scr/pixel.gif" width="1" height="1">
					</form>
      			<h4>Ou bien payer ultérieurement dans un délais de 15 jours</h4>
      			
      		
      	</div>
      </article>
      
    </div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    </layout:put>
</layout:extends>
