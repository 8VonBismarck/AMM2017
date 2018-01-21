<%-- 
    Document   : UtentiTrovati
    Created on : 21-gen-2018, 19.02.32
    Author     : admin
--%>

<%@page contentType="application/json" pageEncoding="UTF-8"%>
<%@taglib prefix="json" uri="http://www.atg.com/taglibs/json"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<json:array>
    <c:forEach var="utente" items="${listaUtentiTrovati}">
        <c:if test="${sessionScope.user != utente.id}">
            <json:object>
                <json:property name="nome" value="${utente.nome}"/>
                <json:property name="cognome" value="${utente.cognome}"/>
                <json:property name="id" value="${utente.id}"/>
            </json:object>
        </c:if>
    </c:forEach>
</json:array>