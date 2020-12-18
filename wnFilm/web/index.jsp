<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
</head>
<body>
    <div class="container-fluid" style="background: black;line-height: 60px;color:white;">
        <div class="row">
            <div class="col-md-3">用户名:<span>请先登录</span></div>
            <div class="col-md-9 text-right">
                <button type="button" data-toggle="modal" data-target="#loginModal" class="btn btn-success"><span class="glyphicon glyphicon-log-in"></span> 登录</button>
                <a href="/logoutServlet" class="btn btn-danger"><span class="glyphicon glyphicon-log-out"></span> 注销</a>
                <a href="main.jsp" class="btn btn-primary"><span class="glyphicon glyphicon-user"></span> 进入后台系统</a>
            </div>
        </div>
    </div>

    <div class="container">
        <h1>热门电影</h1>
        <div class="row text-center">
            <c:forEach var="film" items="${filmList}">
                <div class="col-md-3 table-bordered">
                    <img src="${film.imgSrc}" width="214px" height="300px" style="margin-top: 20px">
                    <p style="color: gray">${film.fName}</p>
                    <p style="color: orangered">价格：${film.fPrice}</p>
                </div>
            </c:forEach>



        </div>
        <div class="row">
            <div class="col-md-12 text-center">
                <ul class="pagination">
                    <li><a href="#">&laquo;</a></li>
                    <li><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">&raquo;</a></li>
                </ul>
            </div>
        </div>
    </div>

    <%--登录模太框设置--%>
    <div class="modal fade" id="loginModal" tabindex="-1" role="dialog"  aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" >用户登录</h4>
                </div>
                <div class="modal-body">
                    <form action="/loginServlet" class="form-inline text-center">
                        <p>
                            用户名:<input type="text" name="userName" placeholder="请输入用户名" class="form-control">
                        </p>
                        <p>
                            密　码:<input type="password" name="userPass" placeholder="请输入密码" class="form-control">
                        </p>
                        <p>
                            <input type="submit" value="登录" class="btn btn-primary">
                            <input type="button" value="返回" class="btn btn-primary"data-dismiss="modal">
                        </p>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <script type="text/javascript" src="js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
</body>
</html>