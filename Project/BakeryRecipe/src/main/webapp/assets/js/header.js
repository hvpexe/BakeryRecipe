let sm = 576;
let md = 768;
let lg = 992;
let xl = 1200;
var id;
$(document).ready(function () {
    console.log('loaded Jquery');
    changeHeight(event);
});
$(window).resize(function () {
    changeHeight(event);

});
function changeHeight() {
    $('header').css('height', 'calc( ' + $('.header-logo img').css('height') + ' + 5px');
    $("#test").html($('header').css('height'));
    $('.line-div').css('height', Math.max(toValue($('.header-left').css('height')),toValue($('.header-right').css('height'))));
}
function toValue(pixel){
    return pixel-'px';
}
   