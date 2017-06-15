<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="fa">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>صفحه اصلي </title>

    <link rel= "stylesheet" type="text/css" href="../../resources/assets/semantic/semantic.rtl.min.css">
    <link rel="stylesheet" type="text/css" href="../../resources/assets/css/site.css">
    <link rel="stylesheet" type="text/css" href="../../resources/css/home.css">
    <link rel="stylesheet" type="text/css" href="../../resources/css/common.css">

    <script type="text/javascript" src="../../resources/assets/js/jquery-2.2.2.min.js"></script>
    <script type="text/javascript" src="../../resources/assets/semantic/semantic.min.js"></script>
    <script type="text/javascript" src="../../resources/assets/js/site.js"></script>	
</head>
<body >
<header class="header">
<a>
    <button class="ui secondary button">
        <i class="home icon"></i>
    &nbsp صفحه اصلی 
  </button></a>
</header>

<div class="content">
	<div class="ui vertically divided  stackable center aligned relaxed grid  style-mainItems">

		<div class="three column row" >
                    <div class="four wide orange column style-mainMenuL ">
                           <img src="${pageContext.request.contextPath}/resources/img/manager-ico.png" />
                            <p>مدیرگروه</p>
				<div>
                                    <form method="post" action="managerLogin">    
                                        <button  class="ui button" type="submit">
					ورود
                                         </button>
                                    </form>
                        </div>
			</div>
			
			<div class="four wide  yellow column style-mainMenuR" >
			<img src="../../resources/img/prof-ico.png"/>
			   <p>استاد</p>
			   <div>
                               <form method="post" action="profLogin">    
                                        <button  class="ui button" type="submit">
					ورود
                                         </button>
                                </form>
                            </div>
			</div>
			
			<div class="four wide olive column style-mainMenuR" >
                            <img src="../../resources/img/stu-ico.png"/>
                            <p>دانشجو</p>
                                <div>
                                    <form method="post" action="studentLogin">    
                                        <button  class="ui button" type="submit">
					ورود
                                         </button>
                                    </form>
				</div> 
			</div>
		</div>

	 </div>
        </div>
        <footer class="footer inverted segment style-footer"> Powered By Sbu </footer>
 </body>
</html>

>>>>>>> master
