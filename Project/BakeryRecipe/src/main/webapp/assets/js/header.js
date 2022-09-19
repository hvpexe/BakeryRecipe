var id;
$(document).ready(function () {
    console.log('loaded Jquery');
    changeHeight(event);
});
$(window).resize(function () {
    changeHeight(event);

});
function changeHeight() {
    $('header').css('height', 'calc( ' + $('.header-logo').css('height') + ' + 5px');
    $("#test").html($('header').css('height'));
    $('.line-div').css('height', $('section-div', 'height'));
}
   