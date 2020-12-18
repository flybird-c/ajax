<%--
  Created by IntelliJ IDEA.
  User: lzp
  Date: 2020/12/14
  Time: 19:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
<%--
wwwwwwwww
--%>
<form action="/loginServlet">
  <p>
    <input type="text" name="userName" placeholder="请输入用户名">
  </p>
  <p>
    密　码:<input type="password" name="userPassWord" placeholder="请输入密码">
  </p>
  <p>
    手机号:<input type="text" name="userPhone" placeholder="请输入手机号">
  </p>
  <p>
    <input type="submit" value="登录">
  </p>
</form>
  </body>
</html>
