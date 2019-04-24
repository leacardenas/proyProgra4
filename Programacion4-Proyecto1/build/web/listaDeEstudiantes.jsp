<%--
// listaDeEstudiantes.jsp
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
        <link rel="shortcut icon" type="image/png" href="https://img.icons8.com/ultraviolet/100/000000/user-group-man-man.png" />
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
                <li class="dropdown">
                    <a href="javascript:void(0)" class="dropbtn" style="color:#00a3c2">ESTUDIANTES</a>
                    <div class="dropdown-content">
                        <a href="datosEstudiante.jsp">VER DATOS PERSONALES</a>
                        <a href="listaDeEstudiantes.jsp">VER USUARIOS</a>
                    </div>
                </li>
                <li id="logoutOption"><a href="index.jsp">SALIR <i class="fas fa-sign-out-alt"></i></a></li>
            </ul>
        </nav>

        <div id="info">
            <table id="listas">
                <td>
                    <h1>Usuarios</h1>
                    <table id="listaUsuarios">
                        <tr>
                            <th onclick="ordenarTabla(0,'listaUsuarios')">ID</th>
                            <th onclick="ordenarTabla(1,'listaUsuarios')">Nombre</th>
                            <th onclick="ordenarTabla(2,'listaUsuarios')">NCR</th>
                            <th onclick="ordenarTabla(3,'listaUsuarios')">Grupo</th>
                        </tr>
                        <%out.print(GestorEstudiante.obtenerInstancia().listarTodosLosUsuariosHTML());%>
                    </table>
                </td>
                <td>
                    <h1>Usuarios activos</h1>
                    
                    <table id="listaUsuariosActivos">
                        <tr>
                            <th onclick="ordenarTabla(0,'listaUsuariosActivos')">ID</th>
                            <th onclick="ordenarTabla(1,'listaUsuariosActivos')">Nombre</th>
                            <th onclick="ordenarTabla(2,'listaUsuariosActivos')">NCR</th>
                            <th onclick="ordenarTabla(3,'listaUsuariosActivos')">Ultimo acceso</th>
                        </tr>
                        <%out.print(GestorEstudiante.obtenerInstancia().imprimirTablaUsuarioHTML());%>
                    </table>
                </td>
            </table>
        </div>
    </body>
</html>
