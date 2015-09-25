<%-- 
    Document   : index
    Created on : Sep 24, 2015, 9:41:05 PM
    Author     : Vonk
--%>

<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%! String planet = "World! Yvon is hier!!!"; %>
        <%-- Java code in mijn HTML pagina (dit is een comment)--%>
        <h1><%= new Date() %></h1>
        <% String message = "Hello " + planet; %>
        <% String message2 = "wat doet dit hier? Laat ik dit even weghalen"; %>
        <h2><%= message %></h2>
        <h3><%= message2%></h3>
    </body>
</html>
