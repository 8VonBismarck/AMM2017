<%--
    Document   : Profilo
    Created on : 8-nov-2017, 15.43.37
    Author     : admin
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>NerdBook - Profilo</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="M3/style.css" media="screen">
    </head>
    <body>
        <page>
            <c:if test="${sessionScope.loggedIn==true}"> 
                <c:set var="page" value="profilo" scope="request"/>
                <jsp:include page="Header.jsp"/>
                <jsp:include page="Sidebar.jsp"/>

                    <content>

                       <div class="col_img">
                           <img id="immagine_profilo" src="immagine.jpg" title="profilo">
                       </div>

                       <div class="cl4">
                            <form id="datiProfilo" action="profilo.html" method="post">
                                <div>
                                    <div class="info_labels"> 
                                    <p>Nome</p>
                                    </div>
                                    <label class="infos" for="nome"></label>
                                    <input type="text" name="nome" id="nome" value="${nome}" />
                                </div>
                                <div>
                                    <div class="info_labels"> 
                                    <p>Cognome</p>
                                    </div>
                                    <label class="infos" for="cognome"></label>
                                    <input type="text" name="cognome" id="cognome" value="${cognome}" />
                                </div>
                                <div>
                                    <div class="info_labels"> 
                                    <p>Email</p>
                                    </div>
                                    <label class="infos" for="email"></label>
                                    <input type="text" name="email" id="email" value="${email}" />
                                </div>
                                <div>
                                    <div class="info_labels"> 
                                    <p>Nato il</p>
                                    </div>
                                    <label class="infos" for="data_n"></label>
                                    <input type="date" name="data_n" id="data_n" value="${data_n}" />
                                </div>
                                <div>
                                    <div class="info_labels"> 
                                    <p>Frase di presentazione</p>
                                    </div>
                                    <label class="infos" for="motto"></label>
                                    <input type="text" name="motto" id="motto" value="${motto}" />
                                </div>
                                <div>
                                    <div class="info_labels"> 
                                    <p>Url immagine profilo</p>
                                    </div>
                                    <label class="infos" for="UrlImgProfilo"></label>
                                    <input type="text" name="UrlImgProfilo" id="UrlImgProfilo" value="${UrlImgProfilo}" />
                                </div>
                                <div>
                                    <div class="info_labels"> 
                                    <p>Password</p>
                                    </div>
                                    <label class="infos" for="password"></label>
                                    <input type="password" name="password" id="password" value="${password}" />
                                </div>
                                <div>
                                    <div class="info_labels"> 
                                    <p>Conferma Password</p>
                                    </div>
                                    <label class="infos" for="conferma_password"></label>
                                    <input type="conferma_password" name="conferma_password" id="conferma_password" value="" />
                                </div>
                                <div>
                                    <button  class="aggiorna_prof" type="submit" form="datiProfilo">Aggiorna</button>
                                </div>
                            </form>
                    </c:if>

                    <c:if test="${sessionScope.loggedIn!=true}">
                        <div class="popup">
                        <p>Per favore, effettuare il <a href="login.html">login</a>.</p>
                        </div>
                    </c:if> 
                </div>
            </content>
        </page>
    </body>
</html>
