<%--
// verGrupos.jsp
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
<html>
    <head>
        <link href="css/menu.css" rel="stylesheet" type="text/css"/>
        <link href="css/grupos.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"/>
        <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ver Grupos</title>
    </head>
    <body>
        <nav>
            <ul>
                <li class="dropdown">
                    <a href="javascript:void(0)" class="dropbtn" style="color:#00a3c2">GRUPOS</a>
                    <div class="dropdown-content">
                        <a href="verGrupos.jsp">VER GRUPOS</a>
                        <a href="manejarGrupos.jsp">MANEJAR GRUPOS</a>
                    </div>
                </li>
                <li><a href="datosEstudiante.jsp">ESTUDIANTE</a></li>
                <li id="logoutOption"><a href="#bye">SALIR <i class="fas fa-sign-out-alt"></i></a></li>
            </ul>
        </nav>
    </body>
</html>
