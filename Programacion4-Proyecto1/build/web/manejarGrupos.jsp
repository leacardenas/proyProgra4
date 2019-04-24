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

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/menu.css" rel="stylesheet" type="text/css"/>
        <link href="css/grupos.css" rel="stylesheet" type="text/css"/>
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
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
                    Object usuario = sesionActual.getAttribute("usuario");
                    long transcurrido = System.currentTimeMillis() - sesionActual.getLastAccessedTime();
                    
                    if (request.getSession(true).getAttribute("usuario") == null) {
                    request.getRequestDispatcher("errorIngreso.jsp").forward(request, response);
                    }
                    if (transcurrido > (1000 * 60 * 5)) {
                        request.getRequestDispatcher("errorIngreso.jsp?error=1").forward(request, response);
                    }
                    
                %>
            <table class="tablaIngreso">
                <tbody>
                    <tr>
                        <td align="right">
                            Nombre de Grupo:&nbsp;
                        </td>
                        <td>
                            <input type="text" size="30" id="nombreGrupo" name="usuario" autocomplete="off">
                        </td>
                    </tr>
                    <tr>
                        <td align="center" colspan="2">
                            <button type="button" onclick="crearGrupo();">Crear Grupo </button>
                        </td>
                    </tr>
                </tbody>
            </table>
            <table id="tablaGrupos" onload="init();">
                <tbody>
                    <tr>
                        <td>
                            <table class="tablaInfoGrupo" onclick="crearGrupo();">
                                <tbody>
                                    <tr class="numeroGrupo">
                                        <td colspan="2">Grupo 1</td>
                                    </tr>
                                    <tr class="nombreGrupo">
                                        <td colspan="2">holis</td>
                                    </tr>
                                    <tr class="integrantes">
                                        <td>Cambronero Murillo</td>
                                        <td>Mariela</td>
                                    </tr>
                                    <tr class="integrantes">
                                        <td>Siles Madrigal</td>
                                        <td>Alejandra</td>
                                    </tr>
                                    <tr class="integrantes">
                                        <td>Sánchez Loaiza</td>
                                        <td>Adriana Daniela</td>
                                    </tr>
                                    <tr class="integrantes">
                                        <td>Garro Eduarte</td>
                                        <td>Bryan</td>
                                    </tr>
                                </tbody>
                            </table>
                        </td>
                        <td>
                            <table class="tablaInfoGrupo" onclick="crearGrupo();">
                                <tbody>
                                    <tr class="numeroGrupo">
                                        <td colspan="2">Grupo 2</td>
                                    </tr>
                                    <tr class="nombreGrupo">
                                        <td colspan="2">putos</td>
                                    </tr>
                                    <tr class="integrantes">
                                        <td>Vargas Jiménez</td>
                                        <td>Luis</td>
                                    </tr>
                                    <tr class="integrantes">
                                        <td>Cruz Rojas</td>
                                        <td>Andrea</td>
                                    </tr>
                                    <tr class="integrantes">
                                        <td>Solís Quesada</td>
                                        <td>Christian</td>
                                    </tr>
                                    <tr class="integrantes">
                                        <td>Aguilar Vidaurre</td>
                                        <td>Luis</td>
                                    </tr>
                                </tbody>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <table class="tablaInfoGrupo" onclick="crearGrupo();">
                                <tbody>
                                    <tr class="numeroGrupo">
                                        <td colspan="2">Grupo 3</td>
                                    </tr>
                                    <tr class="nombreGrupo">
                                        <td colspan="2">hols</td>
                                    </tr>
                                    <tr class="integrantes">
                                        <td>Cordero Rodríguez</td>
                                        <td>Daniel</td>
                                    </tr>
                                    <tr class="integrantes">
                                        <td>Solano Arias</td>
                                        <td>Stephany</td>
                                    </tr>
                                    <tr class="integrantes">
                                        <td>Álvarez Carranza</td>
                                        <td>David</td>
                                    </tr>
                                    <tr class="integrantes">
                                        <td>Artavia Donaire</td>
                                        <td>Joséph</td>
                                    </tr>
                                    <tr class="integrantes">
                                        <td>Madrigal Vásquez</td>
                                        <td>Juan</td>
                                    </tr>
                                </tbody>
                            </table>
                        </td>
                        <td>
                            <table class="tablaInfoGrupo" onclick="crearGrupo();">
                                <tbody>
                                    <tr class="numeroGrupo">
                                        <td colspan="2">Grupo 4</td>
                                    </tr>
                                    <tr class="nombreGrupo">
                                        <td colspan="2">hell</td>
                                    </tr>
                                    <tr class="integrantes">
                                        <td>Bonilla Valerio</td>
                                        <td>Alicia</td>
                                    </tr>
                                    <tr class="integrantes">
                                        <td>Rodríguez Chavarría</td>
                                        <td>Julio</td>
                                    </tr>
                                    <tr class="integrantes">
                                        <td>Alvarado Solórzano</td>
                                        <td>Cristobal</td>
                                    </tr>
                                    <tr class="integrantes">
                                        <td>Montenegro Brenes</td>
                                        <td>Elmer</td>
                                    </tr>
                                    <tr class="integrantes">
                                        <td>Monterrey Benavides</td>
                                        <td>Diego</td>
                                    </tr>
                                    <tr class="integrantes">
                                        <td>Pico García</td>
                                        <td>Javier</td>
                                    </tr>
                                    <tr class="integrantes">
                                        <td>Moraga Alfaro</td>
                                        <td>Moisés</td>
                                    </tr>
                                </tbody>
                            </table>
                        </td>
                    </tr>

                </tbody>
            </table>

        </div>
    </body>
</html>
