<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'Chat.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
    #htmlinfo{
    position:absolute;
    left:600px;
    top:200px;
    }
    #content-view{
    position:absolute;
    left:600px;
    top:500px;
    }
    #chat_user{
    position:absolute;
    left:1200px;
    top:100px;
    }
</style>
  </head>
  
  <body>
  <div id="chat_user"></div>
  <div id="htmlinfo"></div>
  <div id="content-view">
    <input type="text" id="content" name="content" >
    <input type="button" id="send" value="发送">
    </div>
    <script src="js/jquery-2.0.3.min.js"></script>
    <script language="JavaScript" type="text/javascript">
    $("#send").click(function(){
    $.get("Chat",{content:$("#content").val()},
    function(data,textStatus){
    	var html="";
    	$.each(data['list'],function(commentIndex,comment){
    	html += comment['mes_Name'] + "在" + comment['mes_date'] +"说：" + "<br>" + comment['message']+"<br>";
    	});
     $("#htmlinfo").html(html);
    },"json");
      $("#content").val("");
    });
    /*定义显示对话内容函数*/
     function viewmes(){
    $.get("Chat!reMessage",function(data,textStatus){
    	var html="";
    	$.each(data['list'],function(commentIndex,comment){
    	html += comment['mes_Name'] + "在" + comment['mes_date'] +"说：" + "<br>" + comment['message']+"<br>";
    	});
     $("#htmlinfo").html(html);
    },"json");
    setTimeout("viewmes()",3000);
    }
    function viewusername(){
    $.get("Chat!reChat_User",function(data,textStatus){
    	var html="";
    	$.each(data['list'],function(commentIndex,comment){
    	html += comment['username']+"在线"+"<br>";
    	});
     $("#chat_user").html(html);
    },"json");
    setTimeout("viewusername();",10000);
    }
    $(function(){
    viewusername();
    viewmes();
    });
    </script>
  </body>
</html>
