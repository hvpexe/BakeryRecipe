
function ajaxLoad(url) {
    event.target.parentElement.querySelector('.function-select').classList.remove('function-select');
    event.target.classList.add('function-select');
    $.ajax(
            {url: url,
                success: function (data, textStatus, jqXHR) {
                    var main =document.getElementById('profile-information');
                    $(main).html(data);
                }
            });
}
