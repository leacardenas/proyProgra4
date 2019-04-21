<%--
// datosEstudiante.jsp
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

<%@page import="modelo.dao.GestorEstudiante"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/menu.css" rel="stylesheet" type="text/css"/>
        <link href="css/datos.css" rel="stylesheet" type="text/css"/>
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/datos.js" type="text/javascript"></script>
        <jsp:directive.include file="fonts.jsp" />
        <title>Datos</title>
    </head>
    <body>
        <nav>
            <ul>
                <li class="dropdown">
                    <a href="javascript:void(0)" class="dropbtn">GRUPOS</a>
                    <div class="dropdown-content">
                        <a href="verGrupos.jsp">VER GRUPOS</a>
                        <a href="manejarGrupos.jsp">MANEJAR GRUPOS</a>
                    </div>
                </li>
                <li><a style="color:#00a3c2" href="datosEstudiante.jsp">ESTUDIANTE</a></li>
                <li id="logoutOption"><a href="index.jsp">SALIR <i class="fas fa-sign-out-alt"></i></a></li>
            </ul>
        </nav>

        <div id="wrapper">
            <div id="datosPersonales">
                <h2>Datos personales</h2>
                <%
                    HttpSession sesionActual = request.getSession(true);
                    Object usuario = sesionActual.getAttribute("usuario");

                    out.print(GestorEstudiante.obtenerInstancia().imprimirUsuario(usuario.toString()));
                %>
            </div> 
        </div>
    </body>
</html>
