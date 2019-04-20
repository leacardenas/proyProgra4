<%--
// index.jsp
//
// EIF209 - Programación 4 – Proyecto #1
// Abril 2019
//
// Autores:
// - 000000000 Bryan Garro Eduarte
// - 000000000 Fiorella Salgado Rodriguez
// - 116870078 Lea Cárdenas Alpízar
// - 000000000 Moises Moraga Alfaro
//
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" >

    <head>
        <meta charset="UTF-8">
        <title>Login</title>
        <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
        <link rel="stylesheet" href="css/login.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"/>
    </head>

    <body>
        <div class="wrapper">
            <div class="login-intro">
                <button class="sliderButton"><i class="fas fa-plus fa-1x"></i></button>
                <div class="intro">
                    <h1>
                        Programación 4 
                        <br/>
                        Proyecto # 1 
                    </h1>
                    <h1 style="margin-top: 5%">
                        Integrantes: 
                    </h1>
                    <h2>
                        <span>Bryan Garro Eduarte</span>
                        <br/><br/>
                        <span>Fiorella Salgado Rodriguez</span>
                        <br/><br/>
                        <span>Lea Cárdenas Alpízar</span>
                        <br/><br/>
                        <span>Moises Moraga Alfaro</span>
                    </h2>
                </div>
            </div>
            <div class="login-form">

                <%
                    HttpSession sesionActual;
                    sesionActual = request.getSession(true);
                    sesionActual.invalidate();
                    sesionActual = request.getSession(true);
                %>

                <h1>Login</h1>
                <hr>
                <br>
                <form name = "Formlogin" action = "LoginServicio" method="POST">
                    <input type="text" placeholder="Username" name = "usuario" id = "usuario">
                    <br>
                    <input type="password" placeholder="Password" name = "clave" id = "clave">
                    <br>
                    <button class="login-btn"><i class="fas fa-sign-in-alt"></i> Login</button>
                </form>
            </div>
        </div>
        <script  src="js/index.js"></script>
    </body>
</html>

