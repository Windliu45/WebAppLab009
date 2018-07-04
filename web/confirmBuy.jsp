<%-- 
    Document   : index
    Created on : 2018/7/2, 上午 10:44:35
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>確認訂購</h1>
        請確認以下選購內容,規格,數量......
        <fmt:requestEncoding value="UTF-8" />
        <h1>購物車內容</h1>
        <table style="background-color: yellow ; border : 1px">

            <tr>
                <td style="padding-right:10px">產品編號</td>
                <td style="padding-right:10px">產品名稱</td>
                <td style="padding-right:10px">產品單價</td>
                <td style="padding-right:10px">產品數量</td>
                <td style="padding-right:10px">產品總價</td>
                <td style="padding-right:10px">操作</td>
            </tr>

            <c:forEach var="item" items="${list}" >
                <tr>
                    <td>${item[0]}</td><td>${item[1]}</td><td> ${item[2]} </td><td>
                        
                        <form method='post' action='UpdateCarController'>
                            <input type="number" name="sulian" value="${item[3]}" style="width:30px "/>
                            <input type="hidden" name="pn" value=${item[0]} />
                            <input type="submit" value="儲存變更"/>
                        </form>
                    
                    </td><td>${item[2]}*${item[3]}</td><td>
                        <form action="DeleteCarItem"><input type="submit" value="delete"/></form></td>
                    </form>

                </tr>  

            </c:forEach>
        </div> 
    </table>
    <hr>
     

    <form method='post' action='ScannerWhoRespones.jsp' >
        <input type="submit" value="確認購買" />
    </form>

    <form method='post' action='index.jsp' >
        <input type="submit" value="不買了" />
    </form>

    <form method='post' action='ClearCarServlet' >
        <input type="submit" value="清空購物車" />
    </form>




</body>
</html>
