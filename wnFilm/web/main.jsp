<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
</head>
<body>
    <div class="container">
        <div class="row table-bordered" style="margin-top: 20px;line-height: 100px">
            <div class="col-md-2 navbar-right text-center">
                <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
                    <span class="glyphicon glyphicon-plus"></span>
                    添加</button>
            </div>

            <div class="col-md-5 navbar-right text-center">
                <form class="form-inline" action="#">
                    <input type="text" class="form-control" placeholder="请输入关键字" >
                    <button class="btn btn-primary " type="submit">
                        <span class="glyphicon glyphicon-search"></span>
                        搜索</button>
                </form>
            </div>
            <div class="col-md-5 navbar-right text-center">

                <form class="form-inline" action="#">
                    <select class="form-control">
                        <option>请选择商品类型</option>
                        <option>类型1</option>
                        <option>类型2</option>
                        <option>类型3</option>
                        <option>类型4</option>
                    </select>
                    <button class="btn btn-primary " type="submit">
                        <span class="glyphicon glyphicon-search"></span>
                        搜索</button>
                </form>
            </div>
        </div>
         <div class="row" style="margin-top: 20px">
             <table class="table-bordered col-md-12 text-center" >
                 <tr style="line-height: 50px">
                     <td>电影编号</td>
                     <td>电影名称</td>
                     <td>电影的评论</td>
                     <td>电影价格</td>
                     <td>电影图片</td>
                     <td>电影电影类型</td>
                     <td colspan="2">操作</td>
                 </tr>
                 <tr>
                     <td>1</td>
                     <td>三国演义</td>
                     <td>好看的不得了</td>
                     <td>49.88元</td>
                     <td>
                         <img src="images/1.jpg" width="200px" height="200px">
                     </td>
                     <td>名著</td>
                     <td>
                         <a href="deleteFilmServlet?id=1" class="btn btn-danger">
                             <span class="glyphicon glyphicon-remove"></span>
                             删除
                         </a>
                     </td>
                     <td>
                         <button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal1">
                             <span class="glyphicon glyphicon-heart"></span>
                             修改
                         </button>
                     </td>
                 </tr>
             </table>
         </div>
    </div>
    <!-- 添加电影的模态框（Modal） -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog"  aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">添 加</h4>
                </div>
                <div class="modal-body">
						<jsp:include page="addFilm.jsp"/>
                </div>
            </div>
        </div>
    </div>
    <!--修改的模态框-->
    <div class="modal fade" id="myModal1" tabindex="-1" role="dialog"  aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" >修改</h4>
                </div>
                <div class="modal-body">
                    <jsp:include page="updateFilm.jsp"/>
                </div>
            </div>
        </div>
    </div>

    <script type="text/javascript" src="js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
</body>
</html>