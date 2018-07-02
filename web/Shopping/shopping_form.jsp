<%-- 
    Document   : shopping_form
    Created on : 2018/6/25, 下午 04:27:04
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

        <c:choose>
            <c:when test="${user != null}">
                <h1>歡迎光臨 ${user},請選購物品!</h1>
                <form action="Shopping/shipping_cart_view.jsp" method="POST">
                    <input type="checkbox" name="fruit" value="Apple" />Apple
                    <input type="checkbox" name="fruit" value="Banana" />Banana
                    <input type="checkbox" name="fruit" value="Pear" />Pear
                    <input type="checkbox" name="fruit" value="Pineapple" />Pineapple
                    <br>
                    <br>
                    <input type="submit" value="Submit" />確認 &nbsp;
                    <input type="reset" value="Reset" />重置
                    
                    
                </form>
            </c:when>
            <c:otherwise>

                <h1>尚未登入</h1>

            </c:otherwise>   
        </c:choose>     

        <%@include file="/Welcome/footer.jspf" %>    
    </body>
</html>
