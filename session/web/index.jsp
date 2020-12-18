<%--
  Created by IntelliJ IDEA.
  User: lzp
  Date: 2020/12/17
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>主页面</title>
  </head>
  <body>
  <a href="/cartServlet">注销</a><a href="/shopPingServlet">购物车</a>
  <hr>
  <form action="/loginServlet">
    登录 <br>
    用户名<input type="text" placeholder="请输入用户名" name="userName">
    密码<input type="password" placeholder="请输入密码" name="userPass" >
    保存时间 <br>
    <input type="radio" value="7">7天<br>
    <input type="radio"value="30">30天<br>
    <input type="radio"value="0">从不<br>
    <input type="submit" value="登录">
  </form>

  </body>
</html>
