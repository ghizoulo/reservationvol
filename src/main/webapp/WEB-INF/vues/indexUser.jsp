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
	            <h2 class="top">Hot Offers of the Week</h2>
	            <div class="pad"> <strong>Birmingham</strong><br>
	              <ul class="pad_bot1 list1">
	                <li><span class="right color1">from GBP 143.-</span><a href="book2.html">Zurich</a></li>
	              </ul>
	              <strong>London (LCY)</strong><br>
	              <ul class="pad_bot1 list1">
	                <li><span class="right color1">from GBP 176.-</span><a href="book2.html">Geneva</a></li>
	                <li><span class="right color1">from GBP 109.-</span><a href="book2.html">Zurich</a></li>
	              </ul>
	              <strong>London (LHR)</strong><br>
	              <ul class="pad_bot2 list1">
	                <li><span class="right color1">from GBP 100.-</span><a href="book2.html">Geneva</a></li>
	                <li><span class="right color1">from GBP 112.-</span><a href="book2.html">Zurich</a></li>
	                <li><span class="right color1">from GBP 88.-</span><a href="book2.html">Basel</a></li>
	              </ul>
	              <strong>Manchester</strong><br>
	              <ul class="pad_bot2 list1">
	                <li><span class="right color1">from GBP 97.-</span><a href="book2.html">Basel</a></li>
	                <li><span class="right color1">from GBP 103.-</span><a href="book2.html">Zurich</a></li>
	              </ul>
	              <strong>Edinburgh</strong><br>
	              <ul class="pad_bot2 list1">
	                <li><span class="right color1">from GBP 165.-</span><a href="book2.html">Zurich</a></li>
	              </ul>
	              <strong>Birmingham</strong><br>
	              <ul class="pad_bot1 list1">
	                <li><span class="right color1">from GBP 143.-</span><a href="book2.html">Zurich</a></li>
	              </ul>
	              <strong>London (LCY)</strong><br>
	              <ul class="pad_bot1 list1">
	                <li><span class="right color1">from GBP 176.-</span><a href="book2.html">Geneva</a></li>
	                <li><span class="right color1">from GBP 109.-</span><a href="book2.html">Zurich</a></li>
	              </ul>
	              <strong>London (LHR)</strong><br>
	              <ul class="pad_bot2 list1">
	                <li><span class="right color1">from GBP 100.-</span><a href="book2.html">Geneva</a></li>
	                <li><span class="right color1">from GBP 112.-</span><a href="book2.html">Zurich</a></li>
	                <li><span class="right color1">from GBP 88.-</span><a href="book2.html">Basel</a></li>
	              </ul>
	            </div>
	        </div> <!--end of div box1 -->
	      </article> <!-- end of article -->
	      <article class="col2">
	         <div class="bootstrap">
				<div class="container">
					  <h2>Dynamic Tabs</h2>
					  <ul class="nav nav-tabs">
					    <li class="active"><a data-toggle="tab" href="#home">Home</a></li>
					    <li><a data-toggle="tab" href="#menu1">Menu 1</a></li>
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
	      </article>
		</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    </layout:put>
</layout:extends>
