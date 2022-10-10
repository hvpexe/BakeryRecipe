if (typeof jQuery === 'undefined') {
    var headTag = document.getElementsByTagName("head")[0];
    var jqTag = document.createElement('script');
    jqTag.type = 'text/javascript';
    jqTag.src = 'assets/js/Jquery/jquery-core.js';
    jqTag.onload = myJQueryCode;
    jqTag.async = "";
    jqTag.defer = "";
    headTag.appendChild(jqTag);
}
function myJQueryCode(){
    console.log("Jquery");
}
let sm = 576;
let md = 768;
let lg = 992;
let xl = 1200;
var id;
//$(document).ready(function () {
//    console.log('loaded Jquery');
//    test(event);
//});
//$('.header').mouseover(function () {
//    test(event);
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