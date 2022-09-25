$('.sign-up-button').on('click',
        changeForm);

function changeForm() {
    console.log('yes');
    if ($("header").width() <= 992) {
        let signupButton = $(this);
        let form = $('[class^=' + this.getAttribute('data-type') + '-form]');
        $('.header-button').removeClass('active');
        signupButton.addClass('active');
        $('.section-div form[class*=form]').removeClass('d-none');
        $('.header-button:not(.active)').on('click', changeForm);
        $(this).unbind();
        form.addClass('d-none');
        $(document).focus();
    }
}
