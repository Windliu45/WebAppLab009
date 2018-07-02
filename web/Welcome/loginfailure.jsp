<%-- 
    Document   : loginfailure
    Created on : 2018/6/26, 下午 03:17:46
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
        <h1>帳號密碼輸入錯誤!</h1>
        
        <h1>請註冊會員, 資料輸入</h1>
  
      <form name="Form1" action="ApplicationControl" method="POST">
          
          <p>會員編號  <input type="text" name="id" value="" size="30" />    </p>
          <p>電子郵件  <input type="text" name="email" value="" size="60" />    </p>        
          <p>密碼  <input type="text" name="pwd" value="" size="60" />    </p>   
          <p>名字  <input type="text" name="first_name" value="" size="10" />    </p>   
          <p>姓  <input type="text" name="last_name" value="" size="10" />    </p>  
          <p>生日  <input type="text" name="birthday" value="" size="30" />    </p>            
          <p>登錄日  <input type="text" name="registered_day" value="" size="10" />    </p>            
          <p>性別  <input type="text" name="sex" value="" size="10" />    </p>            
          <p>陣營  <input type="text" name="camp" value="" size="10" />    </p>  
          <p>電話  <input type="text" name="phone" value="" size="10" />    </p>  
          <p>城市  <input type="text" name="add_1" value="" size="10" />    </p>            
          <p>地區  <input type="text" name="add_2" value="" size="10" />    </p>  
          <p>地址  <input type="text" name="add_3" value="" size="60" />    </p>  
          <input type="hidden" name="Application" value="Member" />
      
          <br>
          
          <input type="submit" value="確認" /> &nbsp; &nbsp; &nbsp; <input type="reset" value="重設" />
      </form>
  
        
        
        
        <%@include file="footer.jspf" %>
    </body>
</html>
