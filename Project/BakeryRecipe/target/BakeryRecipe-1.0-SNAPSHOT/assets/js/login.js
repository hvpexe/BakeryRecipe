$('.header-button:not(.active)').on('click',
        changeForm);

function changeForm() {
    if ($("header").width() <= 992) {
        let headerButton = $(this);
        let form = $('[class^=' + this.getAttribute('data-type') + '-form]');
        $('.header-button').removeClass('active');
        headerButton.addClass('active');
        $('.section-div form[class*=form]').removeClass('d-none');
        $('.header-button:not(.active)').on('click', changeForm);
        $(this).unbind();
        form.addClass('d-none');
        $(document).focus();
    }
}