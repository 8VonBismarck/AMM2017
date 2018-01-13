<%-- 
    Document   : Bacheca
    Created on : 8-nov-2017, 15.43.13
    Author     : admin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bacheca di ${owner.nome}</title>
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
                
                <div class="cl3">
                    <img title="profiloGeppi"
                         src="profilo.jpg" width="50" height="50">
                    <h2 class="nome">${owner.nome} : ${owner.motto}</h2>
                </div>
                
                <div class="cl3">
                    <form action="pagina.php" method="post">
                        <div>
                        <label class="profile" for="testo_nuovo"></label>
                        <input type="text" name="testo_nuovo" id="testo_nuovo" value="A cosa stai pensando?" />
                        </div>
                        <div>
                        <label class="url_alleg" for="url_allegato"></label>
                        <input type="text" name="url_allegato" id="url_allegato" value="URL allegato" />
                        </div>
                        <div class="radio_btn">
                        <label for="img">Immagine</label>
                        <input type="radio" name="tipo_allegato” "id="img" value="img">
                        </div>
                        <div class="radio_btn">
                        <label for="link">Link</label>
                        <input type="radio" name="tipo_allegato" id="link" value="link">
                        </div>
                        <div class="btn_conf">
                        <button type="submit">Crea post</button>
                        </div>
                    </form>
                </div>
                
                <div class="cl3">
                    <img title="profiloGeppi"
                         src="profilo.jpg" width="50" height="50"> 
                    <h2 class="nome">Geppi</h2>
                    <h3>Ecco il link:</h3>
                    <a href="google.it">www.google.it</a>
                </div>
                
                <div class="cl3">
                    <img title="profiloGiorgio"
                         src="profilo.jpg" width="50" height="50">
                    <h2 class="nome">Giorgio</h2>
                    <h3>Aggiorno immagine:</h3>
                    <img title="copertina" 
                    src="copertina.jpg" width="276" height="77">
                </div>
                
            </content>
            
            <clear></clear>
            <footer></footer>
            </c:if>

                    <c:if test="${sessionScope.loggedIn!=true}">
                        <div class="popup">
                        <p>Per favore, effettuare il <a href="login.html">login</a>.</p>
                        </div>
                    </c:if> 
        </page>
    </body>
</html>
