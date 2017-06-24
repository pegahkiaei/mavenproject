/**
 * Created by Pegah on 4/2/2017.
 */
function rowClicked(term){
    $('#course-brief-row').empty();
    $('#nomre_term_body').empty();
$.ajax({
    url: "/student/transcript_detail",
    data:{term:term},
    on:"/student/transcript_detail",
    method:"POST",
    success: function(responseJson) {
        // var a = document.createElement('a');
        $.each(responseJson, function(index,termDetail){
            $("#course-brief-row").append("<a class='style-item' onclick='courseClicked("+termDetail.coirseId+","+term+")' >" +termDetail.coursename+"<br>"+
                                            termDetail.grade+"<br>"+
                                            termDetail.stat+"<br>"+
                                            "<p><br>&nbsp;</p>"+
                "</a>");
        });
    },
    error: function (jqXHR, exception) {
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
    },

});
}

function courseClicked (coid,term) {

    alert("YEAS?!")
    $.ajax({
        url: "/student/course_detail",
        data:{cid:coid,term:term},
        on:"/student/course_detail",
        method:"POST",
        success: function(responseJson) {
            $('#nomre_term_body').empty();
            var $tbody = $("<tbody>").appendTo($("#nomre_term"));
            $.each(responseJson, function(index,courseDetail){
                // var color = courseDetail.protest==true ? "green":"red";
                alert("success"+responseJson.coname);

                $("<tr class = 'detail-Result' id='shabake'>").appendTo($tbody)
                // Integer coid, String coname, Integer cocredits, float grade, String stat, String courseType, boolean protest
                    .append($("<td>").text(courseDetail.coid))
                    .append($("<td>").text(courseDetail.coname))
                    .append($("<td>").text(courseDetail.cocredits))
                    .append($("<td>").text(courseDetail.grade))
                    .append($("<td>").text(courseDetail.stat))
                    .append($("<td>").text(courseDetail.courseType))
                    .append($("<td>").text("<i class='large green checkmark icon'></i>"));
            });
        },
        error: function () {
            alert("ERROR");
        }
    });
}


$(document).ready(function() {

        var
            $headers     = $('body > h3'),
            $header      = $headers.first(),
            ignoreScroll = false,
            timer
            ;
     //termDetailsubmission 

        
      
// Preserve example in viewport when resizing browser
        $(window)
            .on('resize', function() {
// ignore callbacks from scroll change
                clearTimeout(timer);
                $headers.visibility('disable callbacks');

// preserve position
                $(document).scrollTop( $header.offset().top );

// allow callbacks in 500ms
                timer = setTimeout(function() {
                    $headers.visibility('enable callbacks');
                }, 500);
            })
        ;
        $headers
            .visibility({
// fire once each time passed
                once: false,

// don't refresh position on resize
                checkOnRefresh: true,

// lock to this element on resize
                onTopPassed: function() {
                    $header = $(this);
                },
                onTopPassedReverse: function() {
                    $header = $(this);
                }
            })
        ;
    });
