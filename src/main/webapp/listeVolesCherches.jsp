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
                <p class="cols pad_bot2"><strong>De:<br>
                  A:<br>
                  départ:<br>
                  Retour:<br>
                  Escale:<br>
                  Classe:</strong></p>
                <p class="color1 pad_bot2">USA<br>
                  San Diego<br>
                  Beach st. 54<br>
                  Beach st. 54<br>
                  Beach st. 54<br>
                  Beach st. 54<br></p>
              </div>
            </div>
            <div class="box1">
              <h2 class="top">Modifier la sélection</h2>
              <form id="form_4" action="modifierRecherche" method="post">
                <div>
                    <div class="row"> <span class="left">De</span>
                      <input type="text" class="input">
                    </div>
                    <div class="row"> <span class="left">A</span>
                      <input type="text" class="input">
                    </div>
                     <div class="row"> <span class="left">Depart </span>
                      <input type="date" class="input">
                    </div>
                    <div class="row"> <span class="left">Retour </span>
                      <input type="date" class="input">
                    </div>
                     <div class="row"> <span class="left">Escale ?</span>
                      <input type="radio" name="escale" value="oui">Oui &nbsp;
                      <input type="radio" name="escale" value="Nom">Non
                    </div>
                    <div class="row"> <span class="left">Classe</span>
                                    <select>
                                      <option>Economy1</option>
                                      <option>Economy2</option>
                                      <option>Economy3</option>
                                      <option>Economy4</option>
                                    </select>
                    </div>
                    <br>
                    <div class="row"> 
                       &nbsp; &nbsp; &nbsp; <input type="submit" class="button1" value="valider">
                    </div>
                </div>
              </form>
            </div>
        </div>
      </article>
      <article class="col2">
        <h3 class="pad_top1">Liste des vols disponibles</h3>
        <div class="bootstrap">
          <p>Vous pouvez modifier à tout moment votre sélection dans le menu gauche</p>
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
