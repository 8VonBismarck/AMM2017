<%-- 
    Document   : Sidebar
    Created on : 10-nov-2017, 15.42.47
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<sidebar>
    <br/>
    <form action="pagina.php" method="post">
        <label for="username"></label>
        <input type="text" name="username" id="username" value="Cerca contatto" />
    </form>
    <h2>Persone</h2>
    <ul>
         <c:forEach var="friendTmp" items="${friends}">
                <li>
                    <a href="bacheca.html?action=view&owner=${friendTmp.id}&ownerType=user">
                    ${friendTmp.nome} ${friendTmp.cognome}
                    </a>
                </li>
            </c:forEach>
    </ul>
    <h2 class="gruppi">Gruppi</h2>
    <ul>
        <li class="gruppo1">Mongolfieristi</li>
        <li class="gruppo2">Ritardatari</li>
    </ul>
    <div class="separa"></div>
</sidebar>