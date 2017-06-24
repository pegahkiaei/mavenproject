<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Pegah
  Date: 6/21/2017
  Time: 11:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fa" xmlns:style="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <title>کارنامه</title>

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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/transcript.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/studentList.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/transcript.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/studentList.js"></script>

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
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/assets/js/tablesort.js"></script>

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

    <style type="text/css">
        table:hover{ cursor: pointer; cursor: hand; }
        tr:hover{ cursor: pointer; cursor: hand; }
        a.style-item:hover{ cursor: pointer; cursor: hand; }
    </style>

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
                <a class="olive item" href="/student/login">صفحه اعلان ها</a>
                <a class="olive item" href="stuentInfoEdit.html">مشاهده و ويرايش پروفايل</a>
                <a class=" active olive item" href="#">مشاهده کارنامه</a>

                <a class="olive item" href="entekhabVahed.html">انتخاب واحد</a>

                <a class ="olive item" href="home.html"> خروج</a>
            </div>
        </div>

    </div>
</div>
<div class="container pusher style-container  " >
    <div id="sideM" class="ui simple right sidebar visible inverted vertical menu">
        <a class="olive item" href="/student/login">صفحه اعلان ها</a>
        <a class="olive item" href="studentInfoEdit.html">مشاهده و ويرايش پروفايل</a>
        <a class=" active olive item" href="#">مشاهده کارنامه</a>

        <a class="olive item" href="entekhabVahed.html">انتخاب واحد</a>

        <a class ="olive item" href="home.html"> خروج</a>

    </div>
    <div class="style-sideSupport"></div>


    <!--content---------------------------------------------------------------------->
    <div class=" style-content dimmable">
        <div class="ui two column divided internally celled hidden grid ">

            <div class=" row" style="height: 50%; width: 160% !important;" >
                <!--table1------------------------------------------------------------->
                <div class="ui container ten wide column">
                    <div class="ui scrollable container ">
                        <table class="ui complex celled  sorted  unstructured olive  small compact selectable  right highlight aligned unstackable table table-striped">
                            <thead>
                            <tr>
                                <th rowspan="2" class = "descending  sticky">ردیف</th>
                                <th rowspan="2">ترم</th>
                                <th rowspan="2">وضع و نوع ترم</th>
                                <th colspan="2">واحد اخذ شده</th>
                                <th colspan="3">واحد گذرانده شده</th>
                                <th rowspan="2">واحدهای اعلام نشده</th>
                                <th rowspan="2">واحدهای رد شده</th>
                                <th rowspan="2">معدل ترم</th>
                                <th rowspan="2">معدل کل</th>
                                <th rowspan="2">مشروط</th>

                            </tr>
                            <tr >
                                <th >ترم</th>
                                <th>متوالی</th>
                                <th>ترم</th>
                                <th>کل</th>
                                <th>متوالی</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${terms}" var="term">
                                <%! int i= 0; %>
                                    <tr class ="table_Row"  id="row${term.value.term}" class="term_row" onclick="rowClicked(${term.value.term})">
                                        <td><%=i %></td>
                                        <td>${term.value.term}</td>
                                        <td>${term.value.termState}</td>
                                        <td>${term.value.termTakenCredits}</td>
                                        <td>${term.value.consecutiveTakenCredits}</td>
                                        <td>${term.value.termPassedCredits}</td>
                                        <td>${term.value.totalPassedCredits}</td>
                                        <td>${term.value.consecutivePassedCredits}</td>
                                        <td>${term.value.unknownCredits}</td>
                                        <td>${term.value.failedCredits}</td>
                                        <td>${term.value.GPA}</td>
                                        <td>${term.value.totalGPA}</td>
                                        <td>${term.value.provided}</td>
                                    </tr>
                                <% i++; %>
                            </c:forEach>
                            </tbody>
                            <tfoot>
                            <tr>
                                <th>3 People</th>
                                <th>2 Approved</th>
                                <th>--</th>
                                <th>--</th>
                                <th>--</th>
                                <th>--</th>
                                <th>--</th>
                                <th>--</th>
                                <th>--</th>
                                <th>--</th>
                                <th>--</th>
                                <th>--</th>
                                <th>--</th>
                            </tr>
                            </tfoot>
                        </table>
                    </div>
                </div>
                <!--table-end1--------------------------------------------------------->

                <div class="ui container three wide column "></div>

                <!--menuye chap*******************************************************-->
                <div class="ui container two wide column ">
                    <div id="brief" class="ui vertical sticky floating top relaxed divided list sticky_score_div" >
                        <div class=""  id="course-brief-row">
                            <h1 id ="term_courses" items="" var="" class="ui header">دروس ترم</h1>
                            <a >

                            </a>
                        </div>
                    </div>
                </div>
                <!--menuye chap_end-****************************************************-->

                <div class="ui container one wide column "></div>
            </div>
            <!--nomre term--###########################################################-->
            <div class="row" style="height: 50%; width: 160% !important;" >
                <  id="course-detailed">
                    <table id="nomre_term" class="ui celled selectable inverted right aligned olive table">
                        <thead>
                        <th>شماره و گروه درس</th>
                        <th>نام درس</th>
                        <th>واحد کل</th>
                        <th>نمره</th>
                        <th>نتیجه قبولی</th>
                        <th>نوع درس</th>
                        <th>امکان اعتراض</th>
                        </thead>
                        <tbody id="nomre_term_body">

                        </tbody>
                    </table>
                    <tbody id="tbodydetail">

                    </tbody>
                </div>
            </div>
            <!--nomre term end##########################################################-->
            <div class="row" style="height: 50%; width: 160% !important;">
                <p><br>&nbsp;</p>
            </div>
        </div>
    </div>
</div>


<footer class="footer inverted segment style-footer"> Powered By Sbu</footer>
</body>
</html>