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
        <script src="scripts.js" type="text/javascript"></script>
         <link rel="stylesheet" href="estilos/index.css" type="text/css">
        <title>Error de Ingreso</title>
    </head>
    <body>
        <div id = "wrapper">
            <div id ="contents"> 
            <h2>
                    <span style="color: red; font-weight: bold;">Error de ingreso</span>
                </h2>
                <p><strong>No ha iniciado la sesión.</strong><br />
                    Esto puede deberse a que la sesión ha expirado
                    o que los datos
                    de ingreso son incorrectos.</p>
                <p>
                    <span style="color:red">
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
            </div>
                <section>
                    
                </section>
        </div>
    </body>
</html>
