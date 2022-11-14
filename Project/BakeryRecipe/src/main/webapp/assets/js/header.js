
function myJQueryCode() {
    console.log("Jquery");
}
let sm = 576;
let md = 768;
let lg = 992;
let xl = 1200;
var id;
var notify = $('.header-notification')

//$(document).ready(function () {
//    console.log('loaded Jquery');
//    test(event);
//});
//$('.header').mouseover(function () {
//    test(event);
//    
//    
//});
//function test() {
//    $("#test").html($('.header-user_content').attr('class'));
//}
//$('.header-user').mouseover(() => {
//    test(event);
//})
//$('.header-user').mouseout(() => {
//    test(event);
//})
console.log(window.location.href);
if (window.location.href.indexOf('/community') !== -1) {
    document.getElementById("community").className += ' active';
}
if (window.location.href.indexOf('/home') !== -1) {
    document.getElementById("home").className += ' active';
}
if (window.location.href.indexOf('/savedrecipe') !== -1) {
    document.getElementById("saved").className += ' active';
}
$(".notify").animate({
    height: "toggle"
}, 0);
$.ajax({
    url: "./notification",
    type: "POST"
    ,data: {receiverID: loginId},
    success: function (data) {
        $(".notify").html(data);
    }
})
if (notify.length) {

    console.log("toggle");
    notify.click(() =>
    {
        notify.blur();
        if ($('header').width() > 992) {

            $(".notify").toggleClass("pe-none");
            $(".notify.pe-none").stop().animate({
                opacity: 0.25,
                height: "toggle"
            }, 200, function () {
            });
            $(".notify:not(.pe-none)").stop().animate({
                opacity: 1,
                height: "toggle"
            }, 200, function () {
            });
        }else{
            window.location = "notification";
        }
    });
}