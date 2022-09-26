$('.sign-up-button').on('click',
        changeForm);
$('.sign-in-button').on('click',
        changeForm1);
let loginform = $('#login');
let signupform = $('#register');
function changeForm() {
    let signupButton = $(this);
    loginform.addClass('d-none');
    signupform.removeClass('d-none');
    $(document).focus();
}
function changeForm1() {
    let signupButton = $(this);
    loginform.removeClass('d-none');
    signupform.addClass('d-none');
    $(document).focus();
}
