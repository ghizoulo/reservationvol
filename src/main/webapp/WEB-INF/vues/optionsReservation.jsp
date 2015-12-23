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
	                				<td><v:out value="${sessionScope.prixDepart+sessionScope.prixRetour}" /> DH</td> 	
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
      	<h5>Index > Liste des Voles > Informations personnelles > Options Vol</h5>
      	<div class="bootstrap">
      		<h3>Options Vol </h3>
      			<div class="panel panel-default">
					  <div class="panel-body">
					  	<form action="confirmation.htm" method="POST">
							    <h4 style="padding: 5px;"><i class="fa fa-briefcase" style="font-size:36px"></i> &nbsp; <B style="color: DodgerBlue;">Baggage</B></h4>
							    	<span style="color:SlateGray;">Vous avez droit à 15kg gratuites. Optez pour plus? </span><br>
							    	<input type="radio" name="baggage" value="" style="display:none;" checked>
							    	&nbsp; &nbsp;<label class="radio-inline">
									  <input type="radio" name="baggage" id="inlineRadio1" value="400"> 15Kg (400 Dh)
									</label>
									<label class="radio-inline">
									  <input type="radio" name="baggage" id="inlineRadio2" value="600"> 25Kg (600 Dh)
									</label>
									<label class="radio-inline">
									  <input type="radio" name="baggage" id="inlineRadio3" value="700"> 30Kg (700 Dh)
									</label>
								<hr>
							    <h4><i class="fa fa-heartbeat" style="font-size:36px;"></i> &nbsp;<B style="color: DodgerBlue;">Assurance</B></h4>
							    		&nbsp;&nbsp; &nbsp;<input type="radio" value="AssuranceMort" name="assurance" id="mort">De Mort &nbsp;
							    		<input type="radio" value="AssuranceAccident" name="assurance" id="accident"> Accident&nbsp;
							    		<input type="radio" value="AssuranceMalade" name="assurance" id="malade">Maladie &nbsp;
							    		&nbsp; &nbsp;
										<div style="width:170px; display: none" id="1">
											<select class="form-control " name="idAssuranceA" >
													<option value="0"  selected>Accident</option>
														<v:forEach items="${ListAssurancesAccident}" var="o">
															<option value="${o.id}" >Assurance à ${o.tarif}</option>
														</v:forEach>
											</select>
										</div>
										<div style="width:170px; display: none" id="2">
											<select class="form-control " name="idAssuranceMo" >
													<option value="0"  selected>Mort</option>
														<v:forEach items="${ListAssurancesMort}" var="o">
															<option value="${o.id}" >Assurance à ${o.tarif}</option>
														</v:forEach>
											</select>
										</div>
										<div style="width:170px; display: none" id="3">
											<select class="form-control " name="idAssuranceMa" >
													<option value="0"  selected> Maladie</option>
														<v:forEach items="${ListAssurancesMalade}" var="o">
															<option value="${o.id}" >Assurance à ${o.tarif} DH</option>
														</v:forEach>
											</select>
										</div>	 
								<hr>
								<h4 style="padding: 5px;"><i class="fa fa-street-view" style="font-size:36px;"></i> &nbsp;<B style="color: DodgerBlue;">Siège</B></h4>
								<table style="cellpadding:90">
									<tr>
										<td><i class="fa fa-eye" style="font-size:24px; margin-left:90px;"></i>&nbsp;Siège coté fenetre</td>
										<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" value="true" name="fenetre"> Oui&nbsp;&nbsp;&nbsp;</td>
										<td>&nbsp;&nbsp;&nbsp;<input type="radio" name="fenetre" value="false" checked>Non </td>
										<td></td>
									</tr>
									<tr>
										<td>&nbsp;<i class="fa fa-map-marker" style="font-size:24px; margin-left:90px;"></i>&nbsp;&nbsp;&nbsp;&nbsp;Position</td>
										<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" value="Droite" name="position"> Droite</td>
										<td>&nbsp;&nbsp;&nbsp;<input type="radio" name="position" value="Gauche" checked>Gauche </td>
										<td></td>
									</tr>
									<tr>
										<td><i class="fa fa-sitemap" style="font-size:24px; margin-left:90px;"></i>&nbsp;&nbsp;Rang</td>
										<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" value="Milieu" name="rang" checked> Milieu</td>
										<td>&nbsp;&nbsp;&nbsp;<input type="radio" name="rang" value="Avant" checked>Avant</td>
										<td>&nbsp;&nbsp;&nbsp;<input type="radio" value="Arriere" name="rang"> Arrière</td>
									</tr>
								</table>
								<hr>
								<button type="submit" class="btn btn-info">Valider</button>		
						</form>
					  </div>
				</div>
      		<hr>
      		<h3>Options Paiement </h3>
      	</div>
      </article>
      
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script>
$(document).ready(function(){
    $("#accident").click(function(){
        $("#1").show();
        $("#1").css("display", "inline-block");
        $("#2").hide();
        $("#3").hide();
    });
    $("#mort").click(function(){
        $("#2").show();
        $("#2").css("display", "inline-block");
        $("#1").hide();
        $("#3").hide();
    });
    $("#malade").click(function(){
    	$("#3").show();
    	$("#3").css("display", "inline-block");
        $("#2").hide();
        $("#1").hide();
    });
});
</script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    </layout:put>
</layout:extends>
