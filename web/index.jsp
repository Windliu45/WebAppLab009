<%-- 
    Document   : 首頁
    Created on : 2018/7/2, 上午 11:06:51
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>這是首頁喔!</h1>
        
        <form action="GetAllCar">
            <p>點我看購物車的內容
                 <select name = "operation">
                    <option>car</option>
                    
                </select>
                
            <p><input type="submit"/></p>
        </form>
    </body>
</html>
