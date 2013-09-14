<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
    <title>login.jsp</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
   <style type="text/css">
   #Login{
   position:absolute;
   left:500px;
   top:150px;
   z-index:3;
    }
   </style>
    </head>
    <body>
<!-- =================================================表单设置=============================================== -->
    <div id="Login">
    <form class="form-horizontal" action="Login">
    <div class="control-group">
    <label class="control-label" for="inputPassword">类型</label>
    <div class="controls">
     <select name="loginway" >
     <option selected>=请选择类型=</option>   
     <option>学生</option>
     <option>教师</option>
  </select>
    </div>
  </div>
   <div class="control-group">
     <label class="control-label" for="inputEmail">用户名</label>
    <div class="controls">
      <input type="text" name="username" placeholder="User">
    </div>
  </div>
  <div class="control-group">
    <label class="control-label" for="inputPassword">密码</label>
    <div class="controls">
      <input type="password" name="password" placeholder="Password">
    </div>
  </div>
  <div class="control-group">
    <div class="controls">
      <label class="checkbox">
        <input type="checkbox"> Remember me
      </label>
      <button type="submit" class="btn">登陆</button>
    </div>
  </div>
</form>
</div>
<!-- ================================页面图片水平滚动======================================================-->
    <div id="myCarousel" class="carousel slide" style="width:100%;height:100%">
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
  </ol>
  <!-- Carousel items -->
  <div class="carousel-inner" style="width:100%;height:100%">
    <div class="active item"><img src="img/banner01.png" style="width:100%;height:100%"></div>
    <div class="item"><img src="img/banner02.png" style="width:100%;height:100%"></div>
    <div class="item"><img src="img/banner03.png" style="width:100%;height:100%"></div>
  </div>
  <!-- Carousel nav -->
  <a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
  <a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
</div>
<script src="http://code.jquery.com/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script>
		
		window.onload = function()
		 {
		$('#myCarousel').carousel();
		}
	</script>
  </body>
</html>
