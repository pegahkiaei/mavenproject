<%-- 
    Document   : managerInfoEdit
    Created on : May 28, 2017, 6:30:23 PM
    Author     : Nia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fa">
<head>
    <meta charset="UTF-8">
    <title>ویرایش اطلاعات</title>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/assets/semantic/semantic.rtl.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/assets/css/site.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/assets/css/semantic.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/assets/css/dropdown.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/assets/css/dropdown.min.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/assets/css/sidebar.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/assets/css/sidebar.min.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/assets/css/transition.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/assets/css/transition.min.css">
	

	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/firstPage.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/common.css">
	
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/assets/js/jquery-2.2.2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/assets/semantic/semantic.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/assets/js/semantic.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/assets/js/site.js"></script>
	<script language="javascript" src="http://code.jquery.com/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/assets/js/dropdown.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/assets/js/dropdown.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/assets/js/sidebar.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/assets/js/sidebar.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/assets/js/transition.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/assets/js/transition.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/assets/js/visibility.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/assets/js/visibility.min.js"></script>
	
	<script>
  
      // show dropdown on hover
      $('.mia  .ui.dropdown').dropdown({
        on: 'hover'
      });
    });
  </script>
	
</head>
<body>

<div class=" ui right aligned header style-header">



<div class="ui horizontal list style-header">
 <a href="home.html">
<button class="ui secondary button">
   <i class="home icon"></i>
    &nbsp صفحه اصلی 
  </button></a>


  
  <div id="topM" class="ui secondary floating dropdown  button">
    <i class="list layout icon"></i>
	&nbsp گزينه ها
    <div class="menu">
      <a class="orange item" href="managerFirstPage.html">صفحه اعلان ها</a>
	  <a class="active orange item" href="#">مشاهده و ویرایش پروفایل</a>
	  
	  <a class="orange item" href="managerEditCourse.html">مدیریت درس ها</a>
	  <a class="orange item" href="managerNewTerm.html">مدیریت ترم ها</a>	
	  <a class="orange item" href="studentListOfManager.html">لیست دانشجویان</a>
	  <a class ="orange item" href="home.html"> خروج</a>
    </div>
  </div>

</div>
</div>
	<div class="container pusher style-container" >
	  <div id="sideM" class="ui simple right sidebar visible inverted vertical menu">
		  <a class="orange item" href="managerFirstPage.html">صفحه اعلان ها</a>
		  <a class="active orange item" href="#">مشاهده و ویرایش پروفایل</a>
		  
		  <a class="orange item" href="managerEditCourse.html">مدیریت درس ها</a>
		  <a class="orange item" href="managerNewTerm.html">مدیریت ترم ها</a>	
		  <a class="orange item" href="studentListOfManager.html">لیست دانشجویان</a>
		  <a class ="orange item" href="home.html"> خروج</a>
		</div>
	  <div class="style-sideSupport"></div>
	  <div class=" style-content">

		   <div class="eight wide centered column">
            <form class="ui small form">
                <h2 class="ui centered header">ويرايش اطلاعات</h2>
				<hr>
                <div class="two fields">
                    <div class="required field">
                        <label>شناسه کاربري</label>
                        <input placeholder="شناسه کاربري" type="text" name="username">
                    </div>

				 
				 
                    <div class="required field">
                        <label>رمزعبور</label>
                        <input placeholder="شناسه کاربري" type="password" name="password">
                    </div>

				
        </div>
		<div class="field">
		 <div class="required field">
                        <label>آدرس</label>
                        <input placeholder="آدرس" type="text" name="address">
         </div>

		</div>
		 <div class="field">
                        <label>عکس کاربر</label>
                         <input type="file" name="pic" accept="image/*" name="image">
                        <br/>
                       
                    </div>
			<button class="ui orange button" type="submit">تایید</button>

		</form>
		</div>
	   </div>
	    <footer class="footer inverted segment style-footer"> Powered By Sbu</footer>
	</div>
</body>
</html>
