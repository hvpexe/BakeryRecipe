var btnButton = document.getElementById("btnButton");
if (btnButton) {
    btnButton.addEventListener("click", function (e) {
        window.location.href = "./addrecipe.jsp";
    });
}
function getLikedList(recipeID) {
    console.log("2");
    var likedList = $('#liked-list');
    var graybox = $('#liked-list .gray-box');
    var content = $('#liked-list .content');
    graybox.click(()=>likedList.removeClass('d-flex'));
    $.ajax(
            {
                url: 'ajax/LikedUserListAjax',
                data: {
                    recipeid: recipeID
                },
                success: function (data) {
                    likedList.addClass('d-flex');
                    content.html(data);
                    $('#liked-list .exit-btn').click(()=>likedList.removeClass('d-flex'));
                }
            }
    );
}           