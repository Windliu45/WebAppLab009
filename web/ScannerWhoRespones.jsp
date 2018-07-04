<%-- 
    Document   : 輸入收件人資料
    Created on : 2018/7/2, 上午 10:47:49
    Author     : user
--%>

<%@page contentType  ="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <fmt:requestEncoding value="UTF-8" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>請在這邊輸入收件人資料</title>
    </head>
    <body>
        <form method='post' action='SaveAndMove' >
            <h1>請在這邊輸入收件人資料</h1>
            收件人姓名 : <input type="text" name="MYGIFT" value="" />
            <hr>
            收件人電話 : <input type="text" name="MYGIFTPHONE" value="" />
            <hr>
            收件人地址 : <input type="text" name="MYGIFTADDRESS" value="" />
            <hr>

            
            <input type="submit" value="填好了" />
            <input type="reset" value="重新填寫" />
        </form>

        
    </body>
</html>
