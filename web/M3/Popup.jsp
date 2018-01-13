<%-- 
    Document   : Popup
    Created on : 11-nov-2017, 11.59.35
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true" %>

<c:choose>
    <c:when test="${sessionScope.loginError =='wrongPassword'}">
        <div class="popup">
            <p>Nome utente e/o Password errati, riprovare.</p>
        </div>
    </c:when>
    
    <c:when test="${notificationType == 'loginError' && notificationValue=='emptyField'}">
        <div class="popup">
            <p>Per favore, compilare tutti i campi.</p>
        </div>
    </c:when>
    
    <c:when test="${notificationType == 'loginError' && notificationValue=='sessionExpired'}">
        <div class="popup">
            <p>Sei stato disconnesso.</p>
        </div>
    </c:when>
    
    <%--<c:when test="${errorType == 'accessDenied' && errorValue=='accessDenied'}">
        <div class="popup">
            <p>Accesso negato. Per favore, effettuare il login.</p>
        </div>
     </c:when>--%>
    
    <c:when test="${errorType == 'userInfoIncompleteError' && errorValue=='userInfoIncompleteError'}">
        <div class="popup">
            <p>Per favore, compila i campi obbligatori.</p>
        </div>
    </c:when>
    
    
</c:choose> 