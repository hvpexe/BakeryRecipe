
function ajaxLoad(url) {
    if(event.target.classList.contains('function-select'))return;
    event.target.parentElement.querySelector('.function-select').classList.remove('function-select');
    event.target.classList.add('function-select');
    var main = document.getElementById('profile-information');
    $(main).html('<div class="loading"></div>');
    $.ajax(
            {url: url,
                success: function (data, textStatus, jqXHR) {
                    $(main).html(data);
                },
                error: function () {

                    $(main).html("Error Loading Page");

                }
            });
}
