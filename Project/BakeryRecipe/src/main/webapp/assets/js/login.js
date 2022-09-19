$('.header-button').on('click',changeForm);
function changeForm() {
    let select = $('.select');
    let unselect = $('.unselect');
    let headerButton1 = $('.header-button1');
    let headerButton = $('.header-button');
    select.addClass('unselect').removeClass('select');
    unselect.addClass('select').removeClass('unselect');
    headerButton1.addClass('header-button').removeClass('header-button1').on('click',changeForm);
    headerButton.addClass('header-button1').removeClass('header-button').unbind();
    
    console.log('running');
    console.log(select);
    console.log(unselect);
}