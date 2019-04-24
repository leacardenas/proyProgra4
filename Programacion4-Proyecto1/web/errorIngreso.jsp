<%-- 
    Document   : pruebalogin
    Created on : Apr 19, 2019, 9:41:31 PM
    Author     : fiore
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
        <link href="css/paginaDeError.css" rel="stylesheet" type="text/css"/>
        <script src="scripts.js" type="text/javascript"></script>
        <link rel="shortcut icon" type="image/png" href="https://img.icons8.com/ultraviolet/100/000000/user-group-man-man.png" />
         <link rel="stylesheet" href="estilos/index.css" type="text/css">
         <jsp:directive.include file="fonts.jsp" />
        <title>Error de Ingreso</title>
    </head>
    <body>
        <div id = "wrapper">
            <div id ="contents"> 
            <h2>
                    <span>Error de ingreso</span>
                </h2>
                <p><strong>No ha iniciado la sesión.</strong><br />
                    Esto puede deberse a que la sesión ha expirado
                    o que los datos
                    de ingreso son incorrectos.</p>
                <p>
                    <span>
                        <%
                            int codError = 0;
                            String mensaje = "(Error sin determinar)";
                            try {
                                codError = Integer.parseInt(request.getParameter("error"));
                            } catch (Exception e) {
                            }
                            switch (codError) {
                                case 1:
                                    mensaje = "La sesión ha expirado.";
                                    break;
                                case 2:
                                    mensaje = "El nombre de usuario o la clave son incorrectos.";
                                    break;
                                default:
                                            ;
                            }
                            out.println(mensaje);
                        %>
                    </span>
                </p>
                <p>Haga clic <a href="index.jsp">aqu&iacute;</a>
                    para ingresar al sitio.<br />
                </p>
                
                <section>
                    <i style="color:red; font-size: 100px" class="far fa-frown"></i>
                </section>
            </div>
        </div>
    </body>
</html>
