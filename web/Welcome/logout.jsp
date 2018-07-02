<%-- 
    Document   : logout
    Created on : 2018/6/25, 下午 04:05:01
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="Style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
            <h1>再見
            <br>
            <c:if test="${user != null}">
                ${user}
            </c:if>
        </h1>

              <%@include file="footer.jspf" %>  
        
    </body>
</html>
