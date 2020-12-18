<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
 <style type="text/css">
 	p{
 		line-height:40px;
 		font-size: 20px;
 		font-family:"楷体"
 	}
 </style>
 <script type="text/javascript">
 //	前段的图片预览
 	function getImg(){
 		var file=new FileReader();
 		//将读取进来的文件对象保存到 file对象的result属性中 
 		file.readAsDataURL(document.getElementById("fid").files[0]);
 		
 		file.onload=function(){//改变文件此方法就会执行一次
 			document.getElementById("imgId").src=this.result;
 		}
 	}
 </script>
 
</head>
<body>
	<div class="conatiner">
		
		<div class="row">
			<form action="updateFilmServlet" class="col-md-12 table-bordered text-center form-inline" method="get" enctype="multipart/form-data">
				<p>
					<img src="" height="200px" width="200px" id="imgId">
				</p>
				<p>
					电影编号:<input readonly value="" type="text" name="id" class="form-control" style="width:400px" placeholder="请输入电影名称">
				</p>
				<p>
					电影名称:<input value="" type="text" name="fName" class="form-control" style="width:400px" placeholder="请输入电影名称">
				</p>
				<p>
					电影价格:<input value="" type="text" name="fPrice" class="form-control" style="width:400px" placeholder="请输入电影价格">
				</p>
				<p>
					电影评论:<input value="" type="text" name="comments" class="form-control" style="width:400px" placeholder="请输入电影的评论">
				</p>
				<p>
					电影类型:<input value="" type="text" name="type" class="form-control" style="width:400px" placeholder="请输入电影类型">
				</p>
				<!-- <p>
					电影图片:<input type="file"  onchange="getImg()" name="imgFile" class="form-control" style="width:400px" id="fid" placeholder="请选择宣传图片">
				</p> -->
				<p>
					<button type="submit" class="btn btn-info">确认修改</button>
					<button type="reset" class="btn btn-info">重新填写</button>
				</p>
			</form>
		</div>
	</div>
	<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
</body>
</html>