<%--
// manejarGrupos.jsp
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

<%@page import="modelo.dao.GestorGrupo"%>
<%@page import="modelo.BeanEstudiante"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/menu.css" rel="stylesheet" type="text/css"/>
        <link href="css/grupos.css" rel="stylesheet" type="text/css"/>
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
        <script src="js/gruposScript.js" type="text/javascript"></script>
        <link rel="shortcut icon" type="image/png" href="https://img.icons8.com/ultraviolet/100/000000/user-group-man-man.png" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:directive.include file="fonts.jsp" />
        <title>Manejar Grupos</title>
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
                <li class="dropdown">
                    <a href="javascript:void(0)" class="dropbtn">ESTUDIANTES</a>
                    <div class="dropdown-content">
                        <a href="datosEstudiante.jsp">VER DATOS PERSONALES</a>
                        <a href="listaDeEstudiantes.jsp">VER USUARIOS</a>
                    </div>
                </li>
                <li id="logoutOption"><a href="index.jsp">SALIR <i class="fas fa-sign-out-alt"></i></a></li>
            </ul>
        </nav>

        <div id="wrapper">
            <%
                HttpSession sesionActual = request.getSession(true);
                BeanEstudiante usuario = null;
                if (sesionActual.getAttribute("usuario") != null) {
                    usuario = new BeanEstudiante(sesionActual.getAttribute("usuario").toString());
                }
                long transcurrido = System.currentTimeMillis() - sesionActual.getLastAccessedTime();

                if (usuario == null) {
                    request.getRequestDispatcher("errorIngreso.jsp").forward(request, response);
                }
                if (transcurrido > (1000 * 60 * 5)) {
                    request.getRequestDispatcher("errorIngreso.jsp?error=1").forward(request, response);
                }
            %>
            
            <table class ="tablaIngreso">
                <tr>
                    <td align="right">
                        Nombre de Grupo:&nbsp;
                    </td>
                    <td>
                        <input type="text" size="30"
                               id="nombreGrupo" name="usuario" autocomplete="off" />
                    </td>
                </tr><tr>
                    <td align="center" colspan="2">
                        <button type="button" onclick="procesoCrearGrupo();">Crear Grupo </button>
                    </td>
                </tr>
            </table>
            <table id="tablaGrupos" onload="init();">
                <tbody id="tbodytablaGrupos">
                    <%
                        out.print(GestorGrupo.obtenerInstancia().listaGrupos());
                    %>
                    <%-- 
                    lo primero e invocar al gestor de datos para que me actualice y me traiga todo lo que hay en la base de datos
                    lo segundo es alerar lo que hace la base de datos mediante fech, en el servidor recibo datos, actualizo la base de datos y genero una respuesta
                        generar un tr con 3 o 4 td, cada td va a ser una tabla con formato
                    --%>
                </tbody>
            </table>
        </div>
    </body>
</html>
