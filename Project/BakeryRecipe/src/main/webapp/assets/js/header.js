if (typeof jQuery === 'undefined') {
    var headTag = document.getElementsByTagName("head")[0];
    var jqTag = document.createElement('script');
    jqTag.type = 'text/javascript';
    jqTag.src = 'assets/js/Jquery/jquery-core.js';
    jqTag.onload = myJQueryCode;
    headTag.appendChild(jqTag);
}
let sm = 576;
let md = 768;
let lg = 992;
let xl = 1200;
var id;
$(document).ready(function () {
    console.log('loaded Jquery');
    test(event);
});
$('.header').mouseover(function () {
    test(event);
});
function test() {
    $("#test").html($('.header-user_content').attr('class'));
}
$('.header-user').mouseover(() => {
    test(event);
})
$('.header-user').mouseout(() => {
    test(event);
})