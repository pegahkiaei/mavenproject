<%--
  Created by IntelliJ IDEA.
  User: Nia
  Date: 6/24/2017
  Time: 7:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>صفحه اصلي</title>

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
    <script>
        function choosingTermYear(){
            $.ajax({
                url:"/prof/chooseTY",
                data:{year:$('#year').val(),term:$('#term').val()},//
                on:"/prof/chooseTY",
                method:"POST",
                success: function(responseJson) {
                    //language=JQuery-CSS
                    //                    $("#dynamicCourses").empty();
                    $("#mytable").removeClass("style-hidden-as-results");
                    $("#dynamicCourses").removeClass("style-hidden-as-results");
                    $.each(responseJson, function(index,Courses){
                        $("#dynamicCourses").append("<tr  id=row"+index+"><td onclick='choosingCourse("+Courses.coid+","+term+","+year+",)'>"+Courses.name+" </td></tr>");
                    });
                },
                error: function (jqXHR, exception) {
                    alert("NO");
                    var msg = '';
                    if (jqXHR.status === 0) {
                        msg = 'Not connect.\n Verify Network.';
                    } else if (jqXHR.status == 404) {
                        msg = 'Requested page not found. [404]';
                    } else if (jqXHR.status == 500) {
                        msg = 'Internal Server Error [500].';
                    } else if (exception === 'parsererror') {
                        msg = 'Requested JSON parse failed.';
                    } else if (exception === 'timeout') {
                        msg = 'Time out error.';
                    } else if (exception === 'abort') {
                        msg = 'Ajax request aborted.';
                    } else {
                        msg = 'Uncaught Error.\n' + jqXHR.responseText;
                    }
                    $('#post').html(msg);
                }

            });
        }


    </script>
    <script>
        function choosingCourse(coid,term,year){
            $.ajax({
                url:"/prof/chooseCO",
                data:{year:year,term:term,coid:coid},
                on:"/prof/chooseCO",
                method:"POST",
                success: function(responseJson) {
//                    $("#mytable").removeClass("style-hidden-as-results");
//                    $("#dynamicCourses").removeClass("style-hidden-as-results");
//                    $.each(responseJson, function(index,Courses){
//                        $("#dynamicCourses").append("<tr  id=row"+index+"><td onclick='choosingCourse("+Courses.coid+","+term+","+year+",)'>"+Courses.name+" </td></tr>");
//                    });
                },
                error: function (jqXHR, exception) {
                    alert("NO");
                    var msg = '';
                    if (jqXHR.status === 0) {
                        msg = 'Not connect.\n Verify Network.';
                    } else if (jqXHR.status == 404) {
                        msg = 'Requested page not found. [404]';
                    } else if (jqXHR.status == 500) {
                        msg = 'Internal Server Error [500].';
                    } else if (exception === 'parsererror') {
                        msg = 'Requested JSON parse failed.';
                    } else if (exception === 'timeout') {
                        msg = 'Time out error.';
                    } else if (exception === 'abort') {
                        msg = 'Ajax request aborted.';
                    } else {
                        msg = 'Uncaught Error.\n' + jqXHR.responseText;
                    }
                    $('#post').html(msg);
                }

            });
        }
    </script>

</head>
<body>
<div class=" ui right aligned header style-header">



    <div class="ui horizontal list style-header">

        <button class="ui secondary button">
            <i class="home icon"></i>
            &nbsp صفحه اصلی
        </button>



        <div id="topM" class="ui secondary floating dropdown  button">
            <i class="list layout icon"></i>
            &nbsp گزینه ها
            <div class="menu">
                <a class="yellow item" href="profFirstPage.jsp">صفحه اعلان ها</a>
                <a class="yellow item" href="/prof/infoEdit">مشاهده و ویرایش پروفایل</a>
                <a class="active yellow item" href="/prof/listPage">لیست دانشجویان</a>

                <a class ="yellow item"> خروج</a>
            </div>
        </div>

    </div>
</div>
<div class="container pusher style-container" >
    <div id="sideM" class="ui simple right sidebar visible inverted vertical menu">
        <a class="yellow item">صفحه اعلان ها</a>
        <a class="yellow item" href="/prof/infoEdit">مشاهده و ویرایش پروفایل</a>
        <a class="active yellow item" href="/prof/listPage">لیست دانشجویان</a>

        <a class ="yellow item"> خروج</a>

    </div>
    <div class="style-sideSupport"></div>

    <div class=" style-content dimmable">
        <!--^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^-->
        <form >
            <label>انتخاب سال</label><input class="ui two wide input" name="term" id ="term" type="text">
            <label>انتخاب ترم</label><input class="ui three wide input" name="year" id="year" type="text">
            <br />
            <button class="ui yellow button" type="button" onclick="choosingTermYear()">تایید</button>
        </form>
        <!--^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^-->
        <div class="ui two column divided internally celled hidden grid ">
            <div class=" row">
                <!-- ************************************************* table1-->
                <div class="ui container four wide column">
                    <div class="ui scrollable container ">
                        <table class="ui hidden complex celled  sorted  unstructured yellow  small compact selectable  right highlight aligned unstackable table table-striped" id="mytable">
                            <thead id="header_dorus">
                            <tr>
                                <th>عنوان درس ها </th>
                            </tr>

                            </thead>
                            <tbody id="dynamicCourses">

                                <div class="style-hidden-as-results"  id="course-brief-row1">
                                    <%--<c:forEach items="${course}" var="cot">--%>
                                        <%--<c:set var="count" value="${count + 1}" scope="page"/>--%>
                                       <%--<tr>--%>
                                           <%--<td>--%>
                                             <%--&lt;%&ndash;${cot.name}&ndash;%&gt;--%>
                                           <%--</td>--%>
                                       <%--</tr>--%>
                                    <%--</c:forEach>--%>

                                    <button class="ui yellow button" type="submit">ثبت نمرات</button>
                                </div>

                            </tbody>

                        </table>
                    </div>
                </div>
                <!--table-end1***************************************************-->
                <div class="ui container twelve wide column  ">
                    <div id="brief" class="ui vertical sticky floating top relaxed divided list sticky_score_div" >
                        <div class="style-hidden-as-results"  id="course-brief-row">
                            <form name="listOfStu">
                                <div class="inline fields">
                                    <div class="four wide field">
                                    <label></label>
                                    </div>

                                    <div class="two wide field">
                                        <div class="ui input">
                                        <input  class="two wide field" placeholder="نمره" type="text" name="score+">
                                        </div>
                                    </div>
                                </div>
                                <button class="ui yellow button" type="submit">ثبت نمرات</button>
                            </form>
                        </div>
                    </div>
                </div>
                <!--###############################################################-->
            </div>

            <!--nomre term-->
            <div class="row" style="height: 50%; width: 160% !important;">
                <p><br>&nbsp;</p>
            </div>
        </div>
    </div>
    <footer class="footer inverted segment style-footer"> Powered By Sbu</footer>
</div>
</body>
</html>
