/**
 * Created by Pegah on 4/2/2017.
 */
function rowClicked( id){
    var i,rowElement, relatedResult,resultArrays;
    relatedResult = "course-brief-"+id;
    rowElement = document.getElementById(relatedResult);
    resultArrays = document.getElementsByClassName("style-hidden-as-results");
    for(i =0;i<resultArrays.length;i++)
    {
        resultArrays[i].style.display = "none";
    }
    rowElement.style.display = "inline";
}
function courseClicked(courseName){
    var courseid;
    courseid = document.getElementById(courseName);
    if(courseid.style.display =="none")
        courseid.style.display = "table-row";
}
function protest(courseid){



}

  $(document).ready(function() {

        var
            $headers     = $('body > h3'),
            $header      = $headers.first(),
            ignoreScroll = false,
            timer
            ;

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