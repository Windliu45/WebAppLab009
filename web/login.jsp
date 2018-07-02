<%-- 
    Document   : login
    Created on : 2018/6/25, 下午 02:20:55
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="share/Style_1.css" rel="stylesheet" type="text/css">   
    </head>
    <body>

        <h1>請登入, 輸入你的USERNANE & PASSWORD!</h1>
        <div class="login">
            <form action="ApplicationControl">

                <table width="500px" border="1">
                    <tbody>
                        <tr>
                            <td width="150px">User Name&nbsp;</td>
                            <td width="350px"><input type="text" name="user" value="" size="30px" />&nbsp;</td>
                        </tr>
                        <tr>
                            <td>密碼 &nbsp;</td>
                            <td> <input type="password" name="password" value="" />&nbsp;</td>
                        </tr>
                        <tr>
                            <td>輸入 &nbsp;</td>
                            <td><input type="submit" value="輸入" /> &nbsp;</td>
                        </tr>
                    <input type="hidden" name="Application" value="Login" />
                    </tbody>
                </table>
            </form>
            <p>&nbsp;</p>
        </div>
    </body>
</html>
