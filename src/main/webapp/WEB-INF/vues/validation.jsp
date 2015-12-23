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
	                				<td><v:out value="${sessionScope.prix_total}" /></td> 	
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
      	<h3>Paiement sur place ou après 15 jours... vous avez le choix!</h3>
      		<p style="background-color:Bisque;">Votre réservation a été bien enregistrée. Vous avez 15 jours pour payer votre billet.</p>
      			
					<form action="https://www.paypal.com/cgi-bin/webscr" method="post" target="_top">
						<input type="hidden" name="cmd" value="_s-xclick">
						<input type="hidden" name="hosted_button_id" value="VCKTTF969SMCA">
						<h4 style="color:brown"><i class="fa fa-credit-card" style="font-size:36px;">Payer Maintenant ?</i> </h4>
						<input type="image" src="https://www.paypalobjects.com/fr_XC/i/btn/btn_buynowCC_LG.gif" border="0" name="submit" alt="PayPal - la solution de paiement en ligne la plus simple et la plus sécurisée !">
						<img alt="" border="0" src="https://www.paypalobjects.com/fr_XC/i/scr/pixel.gif" width="1" height="1">
					</form>
					
					
					<hr>
					<h4 style="color:brown"><i class="	fa fa-external-link" style="font-size:36px;"><a style="color:brown" href="index.htm">Plus tard ?</a></i> </h4>
					<span style="color:brown">Dance cas, un vous sera envoyé avec votre identifiant, et vous poure vous connectez à tout moment durant les 14 prochains jours.</span>
      			</div>
      </article>
      
    </div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    </layout:put>
</layout:extends>
