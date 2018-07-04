<%-- 
    Document   : index
    Created on : 2018/7/1, 上午 09:51:07
    Author     : vincent
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="MemberVerify" method="post" >
            <p>帳號:
        <input type="email" name="email" required  />
            </p>
            <input type="hidden" name="email" value="email"/>
            <p>密碼:
                <input type="password" name="pwd" required/>
            </p>
            <input type="hidden" name="pwd" value="pwd"/>
        <input type="submit"/>
        </form>
        <br>
        <a href ="index.html">回首頁</a>
    </body>
</html>
