<%-- 
    Document   : Login
    Created on : 8-nov-2017, 15.43.04
    Author     : admin
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>NerdBook - Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="M3/style.css" media="screen">
    </head>
    <body>
        <div class="login_div">
            
            <div class="login_header">
                <img title="logo" src="immagine.jpg"
                     width="54" height="44">
                <h1>NerdBook</h1>
            </div>
            <div class="login_form_cont">
                
                <form action="login.html" method="post">
                    <div class="content">
                        <div class="label_cont">
                            <label for="email">Email</label>
                        </div>
                        <input  class="text_area" type="text" name="email" id="email" />
                            <div class="label_cont">
                                <label class="login_label" for="password">Password</label>
                            </div>
                        <input class="text_area" type="password" name="password" id="password" />
                        <div class="btn_cont">
                            <button class="login_btn" type="submit">Login</button>
                        </div>
                    </div>
                </form>
            </div> 
            
            <c:if test="${sessionScope.loginError =='none'}">
                
            </c:if>
            
            <c:set var="notificationType" value="loginError" scope="request" />
            <c:set var="notificationValue" value="${loginError}" scope="request" />
            <jsp:include page="Popup.jsp" />
        
        </div>    
    </body>
</html>
