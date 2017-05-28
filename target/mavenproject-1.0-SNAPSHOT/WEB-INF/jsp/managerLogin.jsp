<%-- 
    Document   : managerLogin
    Created on : May 28, 2017, 3:37:55 PM
    Author     : lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fa">
<head>
    <meta charset="UTF-8">
    <title>کاربر مدیر گروه</title>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/assets/semantic/semantic.rtl.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/assets/css/site.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/assets/js/jquery-2.2.2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/assets/semantic/semantic.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/assets/js/site.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/common.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/login.css">
	
	
</head>
<body style=" background:silver;">
<header class="header">
<button class="ui icon button">
<i class="home icon"></i> Home
</button>
</header>
<div  style="margin:150px 0 150px 400px;" class="ui two column middle aligned very relaxed stackable grid">
  <div class="column">
    <div id="mydiv" class="ui form">
      <div class="field">
        <label>شناسه کاربري</label>
        <div class="ui left icon input">
          <input type="text" placeholder="شناسه کاربري">
          <i class="user icon"></i>
        </div>
      </div>
      <div class="field">
        <label>رمزعبور</label>
        <div class="ui left icon input">
          <input type= "password">
          <i class="lock icon"></i>
        </div>
      </div>
	   <a href="managerFirstPage.html">
      <div class="ui orange submit button" >ورود</div>
	  </a>
    </div>
  </div>
  
   
  </div>
 
<footer class="footer inverted segment style-footer" style="position:absolute;"> Powered By Sbu</footer>
</body>
<html>