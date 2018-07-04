<%-- 
    Document   : M_list
    Created on : 2018/7/1, 下午 05:01:46
    Author     : vincent
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <fmt:requestEncoding value="UTF-8" />
        
        <h1>Member List DB</h1>
        <ul>
            <c:forEach var="item" items="${list}">
                <li>
                    ${item}
                </li>
            </c:forEach>
        </ul>
    </body>
</html>
