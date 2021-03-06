<%-- 
    Document   : managerFirstPage
    Created on : May 29, 2017, 4:26:20 PM
    Author     : Nia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fa">
<head>
    <meta charset="UTF-8">
    <title>صفحه اصلي</title>

    <link rel="stylesheet" type="text/css" href="../assets/semantic/semantic.rtl.min.css">
    <link rel="stylesheet" type="text/css" href="../assets/css/site.css">
	<link rel="stylesheet" type="text/css" href="../assets/css/semantic.css">
	<link rel="stylesheet" type="text/css" href="../assets/css/dropdown.css">
	<link rel="stylesheet" type="text/css" href="../assets/css/dropdown.min.css">
	<link rel="stylesheet" type="text/css" href="../assets/css/sidebar.css">
	<link rel="stylesheet" type="text/css" href="../assets/css/sidebar.min.css">
	<link rel="stylesheet" type="text/css" href="../assets/css/transition.css">
	<link rel="stylesheet" type="text/css" href="../assets/css/transition.min.css">
	

	
	<link rel="stylesheet" type="text/css" href="../css/firstPage.css">
	<link rel="stylesheet" type="text/css" href="../css/common.css">
	
    <script type="text/javascript" src="../assets/js/jquery-2.2.2.min.js"></script>
    <script type="text/javascript" src="../assets/semantic/semantic.min.js"></script>
	<script type="text/javascript" src="../assets/js/semantic.js"></script>
    <script type="text/javascript" src="../assets/js/site.js"></script>
	<script language="javascript" src="http://code.jquery.com/jquery.min.js"></script>
	<script type="text/javascript" src="../assets/js/dropdown.js"></script>
	<script type="text/javascript" src="../assets/js/dropdown.min.js"></script>
	<script type="text/javascript" src="../assets/js/sidebar.js"></script>
	<script type="text/javascript" src="../assets/js/sidebar.min.js"></script>
	<script type="text/javascript" src="../assets/js/transition.js"></script>
	<script type="text/javascript" src="../assets/js/transition.min.js"></script>
	<script type="text/javascript" src="../assets/js/visibility.js"></script>
	<script type="text/javascript" src="../assets/js/visibility.min.js"></script>

	<script>

		$(document)
				.ready(function() {

					//sorting table
					$('.sortable.table').tablesort();
					// show dropdown on hover
					$('.main.menu  .ui.dropdown').dropdown({
						on: 'hover'
					});
				})
		;
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
	&nbsp گزینه ها
    <div class="menu">
      <a class="active orange item" href="#">صفحه اعلان ها</a>
	  <a class="orange item" href="managerInfoEdit.html">مشاهده و ویرایش پروفایل</a>
	  
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
		  <a class="active orange item" href="#">صفحه اعلان ها</a>
		  <a class="orange item" href="managerInfoEdit.html">مشاهده و ویرایش پروفایل</a>
		  
		  <a class="orange item" href="managerEditCourse.html">مدیریت درس ها</a>
		  <a class="orange item" href="managerNewTerm.html">مدیریت ترم ها</a>	
		  <a class="orange item" href="studentListOfManager.html">لیست دانشجویان</a>
		  <a class ="orange item" href="home.html"> خروج</a>
			  
		</div>
	  <div class="style-sideSupport"></div>
	  <div class=" style-content">

		<div class="ui success massive message">
			  دکتر ${name}، خوش آمدید.
		</div>
		
		<div class="ui visible message">
		  <p>این اولین ورود شماست. لطفا رمز عبور خود را عوض کنید.</p>
		  
		</div>
	   </div>
	    <footer class="footer inverted segment style-footer"> Powered By Sbu</footer>
	</div>
</body>
