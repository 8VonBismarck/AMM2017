<%-- 
    Document   : Sidebar
    Created on : 10-nov-2017, 15.42.47
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<sidebar>
    <br/>
    <c:if test="${sessionScope.loggedIn == true}">
        <div id="searchBar">
            <input type="text" id="searchUsersText" value="">
            <input type="button" id="searchUsersButton" value="Cerca">
        </div>

        <c:if test="${users != null}">

            <div id="elencoPersone">
                <h4>Persone:</h4>
                <ul>
                    <c:forEach var="userTmp" items="${users}">
                        <li>
                            <a href="bacheca.html?action=view&owner=${userTmp.id}&ownerType=user">
                                ${userTmp.nome} ${userTmp.cognome}
                            </a>
                        </li>
                    </c:forEach>
                </ul>
            </div>

        </c:if>

    <h2 class="gruppi">Gruppi</h2>
    <ul>
        <li class="gruppo1">Mongolfieristi</li>
        <li class="gruppo2">Ritardatari</li>
    </ul>
    <div class="separa"></div>
    </c:if>
</sidebar>