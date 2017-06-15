var persian = {
    0: '۰',
    1: '۱',
    2: '۲',
    3: '۳',
    4: '۴',
    5: '۵',
    6: '۶',
    7: '۷',
    8: '۸',
    9: '۹'
};

function convertPersianDigits(el) {
    if (el.nodeType == 3) {
        var list = el.data.match(/[0-9]/g);
        if (list != null && list.length != 0) {
            for (var i = 0; i < list.length; i++)
                el.data = el.data.replace(list[i], persian[list[i]]);
        }
    }
    for (var i = 0; i < el.childNodes.length; i++) {
        convertPersianDigits(el.childNodes[i]);
    }
}
$(document).ready(function() {
    $('.ui.dropdown').dropdown();
    $('.message .close').on('click', function() {
        $(this)
            .closest('.message')
            .transition('fade');
    });
    $("#sidebar-toggler").click(function() {
        $("#sidebar").sidebar("setting", "transition", "push").sidebar("setting", "dimPage", true).sidebar("toggle");
    });
});
