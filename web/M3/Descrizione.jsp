<%-- 
    Document   : Descrizione
    Created on : 8-nov-2017, 15.42.51
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="M3/style.css" media="screen">
        <title>Nerdbook - Descrizione</title>
    </head>
    <body>
        <c:set var="page" value="descrizione" scope="request"/>
        <%--<jsp:include page="Header.jsp"/>--%>
        
        
        <header>
            <div class="cl1">
                <h1>NerdBook</h1>
            </div>

            <div class="cl2">
                <a href="profilo.html">
                    <h1>Profilo</h1>
                </a>

                <a href="bacheca.html">
                    <h1>Bacheca</h1>
                </a>
            </div>
        </header>
        <nav>
            <a href="login.html">
                <h4>Login!</h4>
            </a>
        </nav>
        <hr/> 
        <div>
            <h1>NerdBook</h1>
            <h2>Sommario</h2>
            <ol>
                <h3>
                    <li>
                        <a href="#1">A chi è rivolto?</a>
                    </li>
                </h3>
                <h3>
                    <li>
                        <a href="#2">Come iscriversi?</a>
                    </li>
                </h3>
                <h3>
                    <li>
                        <a href="#3">Devo pagare?</a>
                    </li>
                </h3>
            </ol>
            <a id="1">
                <h2>A chi è rivolto?</h2>
            </a>
            <p>"NerdBook" è rivolto a chiunque sia stanco delle classiche piattaforme ormai obsolete</p>
            <a id="2">
                <h2>Come iscriversi?</h2>
            </a>
            <p>Per iscriversi basta cliccare sul link che vedete in alto e compilare il form</p>
            <a id="3">
                <h2>Devo pagare?</h2>
            </a>
            <p>"NerdBook" è totalmente gratuito e lo sarà sempre. Sono comunque ben accette le donazioni.</p>
        </div>
    </body>
</html>
