var btnButton = document.getElementById("btnButton");
if (btnButton) {
    btnButton.addEventListener("click", function (e) {
        window.location.href = "./addrecipe";
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
function getCommentList(recipeID) {
    var likedList = $('#liked-list');
    var graybox = $('#liked-list .gray-box');
    var content = $('#liked-list .content');
    graybox.click(()=>likedList.removeClass('d-flex'));
    $.ajax(
            {
                url: 'ajax/CommentedUserListAjax',
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


function showConfirmBoxHome(id, type, item) {
    var confirmBox = $('#delete_confirm');
    var graybox = $('#delete_confirm .gray-box');
    var content = $('#delete_confirm .content');
    var exitBtn = $('#delete_confirm .exit-btn');
    graybox.click(() => confirmBox.removeClass('d-flex'));
    exitBtn.click(() => confirmBox.removeClass('d-flex'));
    confirmBox.addClass('d-flex');
    var deleteBtn = $('#delete_confirm .delete');
    deleteBtn.click(e => {
        if (type == "comment") {
            deleteCMT(id, item,confirmBox);
        }
         if (type == "recipe") {
            deleteRecipe(id, item);
        }
    });

}

function deleteRecipe(recipeID, item) {
    var infomation = document.querySelector('#delete_confirm #thankReport');
    $(infomation).addClass('text-center font-weight-bold loading');
    $.ajax({
        url: "ajax/DeleteRecipeAjax",
        type: "get",
        data: {
            recipeID: recipeID
        },
        success: function (response) {
            //Do Something
            setTimeout(() => {
                console.log(response);
                $(infomation).removeClass('loading').html(response);
                location ="home";
            }, 500);

        },
        error: function (xhr) {
            console.log("that bai");
            //Do Something to handle error
        }
    });
}