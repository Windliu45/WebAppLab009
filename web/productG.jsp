<%-- 
    Document   : productG
    Created on : 2018/7/3, 下午 01:40:17
    Author     : user
--%>
<%@taglib  prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sosa 美食網</title>
        <meta name="keywords" content="美食,西點,送禮">
        <meta name="description" content="歡樂美味在 Sosa">
        <link href="productcss.css" rel="stylesheet" type="text/css">
        <link href="share/style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <fmt:requestEncoding value="UTF-8" />
        <div class="header">
            <h1><img src="share/logo.png" width="300" height="80" alt=""/></h1>
            <form action="ApplicationControl" method="POST">
                <p style="color:red; text-align:right"> 請選擇
                    <select name="Application" size="1">
                        <option>Login</option>
                        <option>Shopping</option>
                        <option>Logout</option>
                    </select>
                    <input type="submit" value="輸入" />
                </p>
            </form>
            <ul>
                <li><a href="index.html">首頁</a></li>
                <li><a href="#">登入</a></li>
                <li><a href="member.html">註冊 </a></li>
            </ul>
        </div>
        <div class="container">
            <div class="banner"><img src="share/banner.jpg" width="1200" height="400" alt=""/></div>
            <div class="nav">
                <ul>
                    <li><a href="about/about.html"><span>1</span>關於我們</a></li>
                    <li><a href="new/news.html"><span>2</span>最新消息</a></li>
                    <li><a href="order/order.html"><span>3</span>線上訂購</a></li>
                    <li><a href="product.html"><span>4</span>產品介紹</a></li>
                    <li><a href="contact/contact.html"><span>5</span>連絡我們</a></li>
                </ul>
            </div>
            <div class="content"><!-- InstanceBeginEditable name="EditRegion3" -->

                <h2>卡牌包產品介紹</h2>
                <C:forEach var="item" items="${list}" >
                    <div class="box1">

                        <h4><img src=${item[3]} width="265" height="180" alt=""/>${item[0]}-${item[1]}</h4>
                        <p>${item[4]}</p>
                        <p>   ${item[2]}</p>
                        <form action="UpdateCarController">
                            <input type="hidden" name="operation" value="insert" />
                            <input type="hidden" name="pn" value="${item[0]}" />
                            <input type="hidden" name="price" value="${item[2]}" />
                            <input type="hidden" name="pnname" value="${item[4]}" />
                        <p><input type="text" name="sulian" value="1" size="5" />  <input type="submit" value="加入購物車" /> </p>
                        </form>
                    </div>  
                </C:forEach>

                <!-- InstanceEndEditable --> </div>
            <div class="footer">
                <h1>Sosa 美食網</h1>
                <h4>版權宣告 &copy;All Copyright is reserved</h4>
            </div>
        </div>
    </body>
</html>
