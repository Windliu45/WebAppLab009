<%-- 
    Document   : shipping_cart_view
    Created on : 2018/6/26, 上午 09:03:26
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="../Style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        
        <fmt:requestEncoding value="UTF-8"/>
        <h1> ${user}購物車內容</h1>
        <ul>
            <c:forEach var="item" items="${paramValues.fruit}" >
                <li>
                    ${item}
                </li>
            </c:forEach>           
        </ul>
        <a href="../index.html">回首頁- ../</a>
        <%@include file="/Welcome/footer.jspf" %>    
    </body>
</html>
