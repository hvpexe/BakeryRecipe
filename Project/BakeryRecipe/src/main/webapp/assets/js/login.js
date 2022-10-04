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

//document.querySelector('[name=email]').onblur = (e) => {
//    let call = undefined;
//    clearTimeout(call);
//    reg = new RegExp('^[a-zA-Z0-9]+(?:\.[a-zA-Z0-9]+)*@[a-zA-Z0-9]+(?:\.[a-zA-Z0-9]+)*$')
//    calls = [
//        isRequired(e),
//        checkValid(e, reg, "Invalid Email Format")
//    ];
//    try {
//        for (var i = 0; i < calls.length; i++) {
//            call = calls[i];
//            if(!call) break;
//        }
//        
//    } catch {
//
//    }
//
//}
//document.querySelector('[name=password]').onblur = (e) => {
//    isRequired(e);
//    reg = /^.{8,40}$/;
//    checkValid(e, reg, "Password must be between 8-40 character");
//}
function isRequired(e) {
    let input = $(e.target);
    if (input.val() === "") {
        return false;
    }
    return true;
}
function checkValid(e, reg, msg) {
    let input = $(e.target);
    if (reg.test(input.val())) {
        console.log(input);
        return true;
    }
    return false;
}