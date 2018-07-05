<%-- 
    Document   : QANDA
    Created on : 2018/7/2, 上午 10:46:51
    Author     : 林淑鈴
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>QandA</h1>
        <fmt:requestEncoding value="UTF-8"/>
        <h1>
            <form action="QANDAController">

                <select name="operation">
                    <option>A</option>
                    <option>B</option>
                    <option>C</option>
                    <option>D</option>
                </select>

                <p><input type="submit"/></p>


            </form>
        </h1>
        <ul>
            <c:forEach var="item" items="${list}">
                <li>
                    ${item}
                </li> 
            </c:forEach>

        </ul>

    </body>
</html>



