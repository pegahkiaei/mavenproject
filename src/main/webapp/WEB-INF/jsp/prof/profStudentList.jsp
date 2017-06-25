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
                <a class="active yellow item" href="profFirstPage.jsp">صفحه اعلان ها</a>
                <a class="yellow item" href="/prof/infoEdit">مشاهده و ویرایش پروفایل</a>
                <a class="yellow item" href="/prof/listPage">لیست دانشجویان</a>

                <a class ="yellow item"> خروج</a>
            </div>
        </div>

    </div>
</div>
<div class="container pusher style-container" >
    <div id="sideM" class="ui simple right sidebar visible inverted vertical menu">
        <a class="active yellow item">صفحه اعلان ها</a>
        <a class="yellow item" href="/prof/infoEdit">مشاهده و ویرایش پروفایل</a>
        <a class="yellow item" href="/prof/listPage">لیست دانشجویان</a>

        <a class ="yellow item"> خروج</a>

    </div>
    <div class="style-sideSupport"></div>

    <div class=" style-content dimmable">
        <!--^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^-->
        <form action="/prof/chooseTY" method="post">
            <label>انتخاب سال</label><input class="ui two wide input" name="year" type="text">
            <label>انتخاب ترم</label><input class="ui three wide input" name="term" type="text">
            <br />
            <button class="ui yellow button" type="submit">تایید</button>
        </form>
        <!--^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^-->
        <div class="ui two column divided internally celled hidden grid ">
            <div class=" row">
                <!-- ************************************************* table1-->
                <div class="ui container four wide column">
                    <div class="ui scrollable container ">
                        <table class="ui style-hidden-as-results complex celled  sorted  unstructured yellow  small compact selectable  right highlight aligned unstackable table table-striped">
                            <thead>
                            <tr>
                                <th>عنوان درس ها </th>
                            </tr>

                            </thead>
                            <tbody>

                            <c:set var="count" value="0" scope="page" />
                            <c:if test="${!isEmptyC}">
                                <div class="style-hidden-as-results"  id="course-brief-row1">
                                    <c:forEach items="${course}" var="cot">
                                        <c:set var="count" value="${count + 1}" scope="page"/>
                                       <tr onclick="" id="row+${count}">
                                           <td>
                                             ${cot.name}
                                           </td>
                                       </tr>
                                    </c:forEach>
                                    <button class="ui yellow button" type="submit">ثبت نمرات</button>
                                </div>

                            </c:if>

                            </tbody>

                        </table>
                    </div>
                </div>
                <!--table-end1***************************************************-->
                <div class="ui container twelve wide column  ">
                <c:if test="${!isEmpty}">
                    <div id="brief" class="ui vertical sticky floating top relaxed divided list sticky_score_div" >
                        <div class="style-hidden-as-results"  id="course-brief-row">
                            <form name="listOfStu" action="/prof/giveNomre" method="post">
                            <c:forEach items="${students}" var="stu">
                                <div class="inline fields">
                                    <div class="four wide field">
                                    <label>${stu.name}</label>
                                    </div>

                                <div class="two wide field">
                                    <div class="ui input">
                                    <input  class="two wide field" placeholder="نمره" type="text" name="score+${stu.id}">
                                    </div>
                                </div>

                                </div>
                            </c:forEach>
                                <button class="ui yellow button" type="button" >ثبت نمرات</button>
                            </form>
                        </div>

                    </div>
                </c:if>
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
