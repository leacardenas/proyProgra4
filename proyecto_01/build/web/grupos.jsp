
<%@page import="modelo.gestores.gestorGrupos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="gruposScript.js" type="text/javascript"></script>
        <link href="grupos.css" rel="stylesheet" type="text/css"/>
        <title>Grupos</title>
    </head>
    <body id="mainElement">
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
                <button type="button" onclick="crearGrupo();">Crear Grupo </button>
            </td>
        </tr>
        </table>
        <table id="tablaGrupos" onload="init();">
        <%
            HttpSession sesion = request.getSession(true);
            sesion.setAttribute("usuario", "116570271");
           out.print( gestorGrupos.obtenerInstancia().listaGrupos());
        %>
<%-- 
lo primero e invocar al gestor de datos para que me actualice y me traiga todo lo que hay en la base de datos
lo segundo es alerar lo que hace la base de datos mediante fech, en el servidor recibo datos, actualizo la base de datos y genero una respuesta
    generar un tr con 3 o 4 td, cada td va a ser una tabla con formato
--%>

        </table>
    </body>
</html>
