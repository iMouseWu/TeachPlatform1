<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <title>主页</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
    <style type="text/css">
    <!--kiss-->
    #leftmenu
    {
    position:absolute;
    left:10px;
    top:50px;
    }
     #logo
    {
    position:absolute;
    left:450px;
    top:150px;
    }
    #search{
    position:absolute;
    left:450px;
    top:50px;
    }
    </style>
  </head>
  <body>
<!-- 左侧下拉菜单 -->
<div id="leftmenu">
  <div class="tabbable tabs-left"> 
  <!-- 学生登录时候显示的菜单 -->
  <c:if test="${sessionScope.user.limitauthority==1}">
  <ul class="nav nav-tabs">
    <li><a href="#tab1" data-toggle="tab" onclick="viewdowloads();" >下载专区</a></li>
    <li><a href="#tab2" data-toggle="tab">查询专区</a></li>
    <li><a href="#tab3" data-toggle="tab">在线测试专区</a></li>
    <li><a href="#tab4" data-toggle="tab">个人信息</a></li>
    <li><a href="Chat_User!checkChatLogin">聊天室</a></li>
    </ul>
  <div class="tab-content">
    <div class="tab-pane" id="tab1">
      <a href="#" onclick="viewdowloads();">课程资料</a><br>
      <a href="#">学生作业</a><br> 
    </div>
    <div class="tab-pane" id="tab2">
      <a href="#" >课程查询</a><br>
      <a href="#" onclick="get();">教师查询</a><br>
    </div>
    <div class="tab-pane" id="tab3">
      <a href="#">试卷查询</a><br>
      <a href="#">考试课程</a><br>
      <a href="#">现在测试</a><br>
    </div>
    <div class="tab-pane" id="tab4">
      <a href="#" onclick="getPerInfo();">个人信息查询</a><br>
    </div>
    </c:if>
    <!-- 教师登录时候显示的菜单 -->
    <c:if test="${sessionScope.user.limitauthority==2}">
    <ul class="nav nav-tabs">
    <li><a href="#tab1" data-toggle="tab" >个人信息修改</a></li>
    <li><a href="#tab2" data-toggle="tab">查询专区</a></li>
    <li><a href="#tab3" data-toggle="tab">考勤专区</a></li>
    <li><a href="Chat_User!checkChatLogin">聊天室</a></li>
    </ul>
  <div class="tab-content">
    <div class="tab-pane" id="tab1">
      <a href="#">个人信息查询</a><br>
    </div>
     <div class="tab-pane" id="tab2">
      <a href="#">查询学生信息</a><br>
      <a href="#">查询个人学期课程安排</a><br> 
      <a href="#">学生成绩登记</a><br>
      <a href="#">登记学生成绩</a><br>
      <a href="#" onclick="uploads();">上传课程资料</a><br>  
    </div>
    <div class="tab-pane" id="tab3">
      <a href="#">考勤管理</a>
    </div>
    </c:if>
   </div>
</div>

<div id="search">
</div>


<div id="logo">
<img src="img/logo.jpg">
</div>

<!-- 引入bootstrap相关文件 -->
<script src="http://code.jquery.com/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/xmlhttp.js"></script>
<script language="JavaScript" type="text/javascript">
/*学生功能ajax代码
 * 
 */
 
/*============================================显示教师信息========================================*/
   function get(){
	       createXMLHttpRequest();
	       xmlHttp.open("get","SearchTeacher!getAllTeaInfo",true);
		   xmlHttp.onreadystatechange=callback;
	       xmlHttp.send(null);
	   }
    function callback(){
	      if(xmlHttp.readyState==4){
	    	  
		    show();
			}
	   }
	  function show(){
	      var xmlDoc = xmlHttp.responseXML;
	      var yan = xmlDoc.getElementsByTagName("teacher"); 
	      var ta = "";
	      var ts = "";
	      ta = ta +"<table class=\"table table-bordered\">";
	      for(var i=0;i<yan.length;i++){
	    	  ta = ta + "<tr>";
	    	  ta = ta + "<td>"+yan[i].childNodes[0].firstChild.data + "</td>";
	    	  //ta = ta + "<td>"+yan[i].childNodes[1].firstChild.data + "</td>";
	    	  ta = ta + "<td>"+yan[i].childNodes[2].firstChild.data + "</td>";
	    	  ta = ta + "<td>"+yan[i].childNodes[3].firstChild.data + "</td>";
	    	  ta = ta + "<td>"+yan[i].childNodes[4].firstChild.data + "</td>";
	    	  ta = ta + "</tr>";
	    	  }
	          ta = ta + "</table>";
	          ts = ts + "教师姓名"+"<input type=\"text\" id=\"name\" maxlength=\"15\">"+"<input value=\"查询\" type=\"button\" onclick=\"search();\">";
	      document.getElementById("logo").innerHTML = ta;
	      document.getElementById("search").innerHTML = ts;
		   }
/*============================================按姓名搜索教师信息========================================*/
	  function getinfo(name){
	       createXMLHttpRequest();
	       xmlHttp.open("get","SearchTeacher!getOneTeaInfo?name="+escape(name),true);
		   xmlHttp.onreadystatechange=callbackinfo;
	       xmlHttp.send(null);
	   }
     function callbackinfo(){
	      if(xmlHttp.readyState==4){
	    	  showinfo();
		  }
	 }
	  function showinfo(){
		  var xmlDoc = xmlHttp.responseXML;
	      var yan = xmlDoc.getElementsByTagName("teacher"); 
	      var ta = "";
	      ta = ta +"<table class=\"table table-bordered\">";
	      for(var i=0;i<yan.length;i++){
	    	  ta = ta + "<tr>";
	    	  ta = ta + "<td>"+yan[i].childNodes[0].firstChild.data + "</td>";
	    	  ta = ta + "<td>"+yan[i].childNodes[1].firstChild.data + "</td>";
	    	  ta = ta + "<td>"+yan[i].childNodes[2].firstChild.data + "</td>";
	    	  ta = ta + "<td>"+yan[i].childNodes[3].firstChild.data + "</td>";
	    	  ta = ta + "<td>"+yan[i].childNodes[4].firstChild.data + "</td>";
	    	  ta = ta + "</tr>";
	       }
	          ta = ta + "</table>";
	          document.getElementById("logo").innerHTML = ta;
	  }
	  function search(){
		  var name = document.getElementById("name").value;
		  getinfo(name);
	  }
/*============================================获取登陆者的信息========================================*/
    function getPerInfo(){
    	   createXMLHttpRequest();
	       xmlHttp.open("get","StudentSource!getLoginSession",true);
		   xmlHttp.onreadystatechange=callbackPerinfo;
	       xmlHttp.send(null);
	 }
    function callbackPerinfo(){
	      if(xmlHttp.readyState==4){
	    	  showPerinfo();
		  }
    }
	function showPerinfo(){
		 var xmlDoc = xmlHttp.responseXML;
		 var yan = xmlDoc.getElementsByTagName("student"); 
		 var ta = "";
		 ta = ta +"<table class=\"table table-bordered\" id=\"perstudent\">";
		 for(var i=0;i<yan.length;i++){
		   ta = ta + "<tr>";
		   ta = ta + "<td>"+yan[i].childNodes[0].firstChild.data + "</td>";
		   ta = ta + "<td>"+yan[i].childNodes[1].firstChild.data + "</td>";
		   ta = ta + "<td>"+yan[i].childNodes[2].firstChild.data + "</td>";
		   ta = ta + "<td>"+yan[i].childNodes[3].firstChild.data + "</td>";
		   ta = ta + "<td>"+yan[i].childNodes[4].firstChild.data + "</td>";
		   ta = ta + "</tr>";
		  }
		   ta = ta + "</table>";
		   var ts = "<input value=\"编辑\" type=\"button\" onclick=\"ModifyPerInfo();\">";
		   document.getElementById("logo").innerHTML = ta;
		   document.getElementById("search").innerHTML = ts;
		   xmlHttp = null;
	}
/*=========================================显示编辑个人信息界面=======================================================*/
	    var stu_Id;
	    var stu_Password;
	    var stu_Name;
	    var stu_Phone;
	    var stu_QQ;
	function ModifyPerInfo(){
		var rows = document.getElementById("perstudent").rows;
		stu_Id  = rows[0].cells[0].innerText;
		stu_Password  = rows[0].cells[1].innerText;
		stu_Name = rows[0].cells[2].innerText;
		stu_Phone = rows[0].cells[3].innerText;
		stu_QQ = rows[0].cells[4].innerText;
		var ts0 = "<input type=\"text\" size=\"5\" id=\"stu_Id\" value="+stu_Id+" readonly>";
		var ts1 = "<input type=\"text\" size=\"5\" id=\"stu_Password\" value="+stu_Password+" readonly>";
		var ts2 = "<input type=\"text\" size=\"5\" id=\"stu_Name\" value="+stu_Name+">";
		var ts3 = "<input type=\"text\" size=\"5\" id=\"stu_Phone\" value="+stu_Phone+">";
		var ts4 = "<input type=\"text\" size=\"5\" id=\"stu_QQ\" value="+stu_QQ+">";
		rows[0].cells[0].innerHTML = ts0;
		rows[0].cells[1].innerHTML = ts1;
		rows[0].cells[2].innerHTML = ts2;
		rows[0].cells[3].innerHTML = ts3;
		rows[0].cells[4].innerHTML = ts4;
		var ts = "<input value=\"确认\" type=\"button\" onclick=\"responseOnclick();\">";
		document.getElementById("search").innerHTML = ts;
		}
	 function responseOnclick(){
		var mstu_Id = document.getElementById("stu_Id").value;
		var mstu_Password = document.getElementById("stu_Password").value;
		var mstu_Name = document.getElementById("stu_Name").value;
		var mstu_Phone = document.getElementById("stu_Phone").value;
		var mstu_QQ = document.getElementById("stu_QQ").value;
		modifyPerinfo(mstu_Id,mstu_Password,mstu_Name,mstu_Phone,mstu_QQ);
	}
	
	/*========================================修改个人信息==============================================*/
    function modifyPerinfo(mstu_Id,mstu_Password,mstu_Name,mstu_Phone,mstu_QQ){
	       createXMLHttpRequest();
	       xmlHttp.open("get","StudentSource!modifyStudentInfo?"+"stu_Id="+escape(mstu_Id)+"&stu_Password="+escape(mstu_Password)+"&stu_Name="+escape(mstu_Name)+"&stu_Phone="+escape(mstu_Phone)+"&stu_QQ="+escape(mstu_QQ),true);
	       xmlHttp.onreadystatechange = callbackmodifyinfo;
	       xmlHttp.send(null);
	   }
    function callbackmodifyinfo(){
	   var xmlDoc = xmlHttp.responseText;
	      if(xmlHttp.readyState==4){  
	    	  getPerInfo();
		  }
	 }
    /*===============显示下载列表===================*/
    function viewdowloads(){
    	createXMLHttpRequest();
    	xmlHttp.open("get","StudentSource!viewDownloads",true);
    	xmlHttp.onreadystatechange = callbackviewdowloads;
    	xmlHttp.send(null);
    }
    function callbackviewdowloads(){
    	if(xmlHttp.readyState==4){  
    		var xmlDoc = xmlHttp.responseXML;
    		var p=xmlDoc.getElementsByTagName("p");
    		var innerhtml = "";
    		for(var i=0;i<p.length;i++){
    		    var tag=p[i].firstChild.data;
    		    innerhtml += "<a href=http://localhost:8080/TeachPlatform/Resources/"+tag+">"+tag+"<a><br>";
    		}
    		 document.getElementById("logo").innerHTML = innerhtml;
    		 document.getElementById("search").innerHTML = "";
    	}
    }
 /*学生功能ajax代码结束*/
  
 /*教师功能ajax代码
 * 
 */
 /*=============================上传功能=======================*/
 function uploads(){
	 var ts = " <form action=\"uploads\" enctype=\"multipart/form-data\" method=\"post\">你乣上传的文件:<input name=\"upload\" type=\"file\"><br><input type=\"submit\" value = \"提交\"  ></form>";
	 document.getElementById("logo").innerHTML = ts;
     document.getElementById("search").innerHTML = "";
 }
</script>
  </body>
</html>