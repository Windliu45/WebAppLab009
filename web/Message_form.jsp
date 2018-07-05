<%-- 
    Document   : Message_from
    Created on : 2018/7/1, 下午 02:57:13
    Author     : 林淑鈴
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
          <c:choose>
            <c:when test="${user !=null}">
                <h1> ${user}
                  Please leave a Message ! </h1>
                  
                 <form action="JdbcServer">
                 <input type="hidden" name="operation" value="saveMessage" />
                <textarea name="Message" rows="30" cols="50">
                </textarea>
                <br><br>
                <input type="submit" value="送出"/>
                <input type="reset" value="重置"/>
                
            </form>
                            
            </c:when>
            <c:otherwise>
            <br>
            <br>
             <a href="index,jsp">回首頁</a>
             </c:otherwise>
              </c:choose>
            </body>
    </body>
</html>
