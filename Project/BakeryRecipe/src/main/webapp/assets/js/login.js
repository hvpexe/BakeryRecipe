$('.change-form').click(
        e => changeForm(e));
function changeForm(e) {
    var formParent = document.querySelector('#form-object');
    var thisFormElem = e.target.parentElement;
    formParent.querySelectorAll('form').forEach(elem => {
        elem.classList.remove('d-none');
    });
    thisFormElem.classList.add('d-none');
}