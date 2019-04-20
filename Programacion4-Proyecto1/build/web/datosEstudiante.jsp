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

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/menu.css" rel="stylesheet" type="text/css"/>
<<<<<<< HEAD
        <link href="css/datos.css" rel="stylesheet" type="text/css"/>
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"/>
        <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/datos.js" type="text/javascript"></script>
=======
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"/>
        <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
>>>>>>> origin/login
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
                <li id="logoutOption"><a href="#bye">SALIR <i class="fas fa-sign-out-alt"></i></a></li>
            </ul>
        </nav>
<<<<<<< HEAD

        <div id="wrapper">
            <div id="datosPersonales">
                <h2>Datos personales</h2>
                <table>
                    <tr>
                        <th>Identificacion:</th>
                        <td>%s</td>
                    </tr>
                    <tr>
                        <th>Nombre:</th>
                        <td>%s</td>
                    </tr>
                    <tr>
                        <th>
                            Clave:
                        </th>
                        <td>
                            <input type="password" value="%s" id="myPassword">
                            <input class="check" type="checkbox" onclick="showPassword()">Mostrar constraseña
                            <button class="save-btn">Guardar Cambios</button>                            
                        </td>
                    </tr>
                    <tr>
                        <th>Ultimo Acceso:</th>
                        <td>%s</td>
                    </tr>
                </table>
            </div> 
        </div>
=======
>>>>>>> origin/login
    </body>
</html>
