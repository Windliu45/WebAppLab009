<%-- 
    Document   : M_Reg
    Created on : 2018/7/1, 上午 11:32:47
    Author     : vincent
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registered</title>
        <link href="share/mystyple.css" rel="stylesheet" type="text/css">
        <sript type=""
    </head>
    <body>
        <%--DB:member part--%>
        <h2>已經是會員了嗎? </h2><br>
            <a href="FindPwd.jsp">忘記密碼</a>

        <h1>Registered</h1>
        <form class="member_all" name="member_all" action="Member_Registered" method='post'>
 
            <p>身分證字號:<input type="text" name="id" required/></p>
 
       
            <p>帳號<input type="email" id="emailText" name="email" 
                       placeholder="填入有效帳號，收取認證信" maxlength="40"/>
            </p>
   
            <p>密碼:<input type="password" name="pwd" required/></p>
 
            <p>FirstName:<input type="text" name="first_name" required/></p>

            <p>LastName:<input type="text" name="last_name" required/></p>

            <p>生日:<input type="date" name="birthday"/>
                
 
                    <p>性別:男性<input type="radio" name="sex" value="man"/>
                    女性<input type="radio" name="sex" value="woman" />
                    保密<input type="radio" name="sex" value="other"/>
 </p>
                    <p>陣營:正義<input type="checkbox" name="camp" value="ON" />
                         中立<input type="checkbox" name="camp" value="ON" />
                         邪惡<input type="checkbox" name="camp" value="ON" />
 </p>
                         <p>電話:<input type="tel" name="phone" placeholder="0987-888666" required=""/>
</p>
                         <p>地址:<select name="add_1">
                        <option>Taipei</option>
                        <option>New Taipei</option>
                    </select>
                        <select name="add_2">
                            <optio>aaa</option>
                        <option>bbb</option>
                    </select>
                    <input type="text" name="add_3" value="" /></p>

        <input type="hidden" name="Application" value="Member" />
        <br>
            <input type="submit" value="送出" />
            <input type="reset" value="重置" />
        </form>    
        <a href ="index.html">回首頁</a>
    </body>
</html>
