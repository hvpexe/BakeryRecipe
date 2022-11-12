/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function  followButton(item, val1, val2, action) {
//                eventac.target.style.backgroundColor = 'white';
//                event.target.classList.toggle("button-Follower");
///
//                console.log(event.target.classList);

    var action = val1;
    $.ajax({
        url: "ajax/UpdateUserFollowAjax",
        type: "get", //send it through get method
        data: {
            follower: userID,
            action: action,
            followed: loginID
        },
        success: function () {
            console.log(item);
            item.classList.toggle("button-Follower");
            let txtFollow = item.querySelector("span");
            if (txtFollow.innerText !== val2)
                txtFollow.innerText = val2;
            else
                txtFollow.innerText = val1;
            // console.log(action);

            //    action = unFollow;
            console.log(action);
            //Do Something
        },
        error: function () {
            //Do Something to handle error
            console.log("thanh cong roi kia");
        }
    });
}


function  saveButton(item, val1, val2, action) {
//                eventac.target.style.backgroundColor = 'white';
//                event.target.classList.toggle("button-Follower");
///
//                console.log(event.target.classList);

    var action = val1;
    $.ajax({
        url: "ajax/updatesaverecipe",
        type: "get", //send it through get method
        data: {
            recipe: recipeID,
            action: action,
            user: loginID
        },
        success: function () {
            console.log(item);
            item.classList.toggle("button-Follower");
            let txtFollow = item.querySelector("span");
            if (txtFollow.innerText !== val2)
                txtFollow.innerText = val2;
            else
                txtFollow.innerText = val1;
            // console.log(action);

            //    action = unFollow;
            console.log(action);
            //Do Something
        },
        error: function () {
            //Do Something to handle error
            console.log("thanh cong roi kia");
        }
    });
}

function  likeButton(item, val1, val2, action) {
//                eventac.target.style.backgroundColor = 'white';
//                event.target.classList.toggle("button-Follower");
///
//                console.log(event.target.classList);

    var action = val1;
    console.log(item);
    if (val1 === 'UnLike') {
        likeNum -= 1;
    } else {
        likeNum += 1;
    }
    console.log(likeNum + "1111");
    $.ajax({
        url: "ajax/likerecipe",
        type: "get", //send it through get method
        data: {
            recipe: recipeID,
            action: action,
            user: loginID
        },
        success: function () {
            console.log(item);
            item.classList.toggle("button-Follower");
            let txtFollow = item.querySelector("span");
            if (txtFollow.innerText !== val2)
                txtFollow.innerText = val2;
            else
                txtFollow.innerText = val1;
            // console.log(action);

            //    action = unFollow;
            console.log(action);
            //Do Something
        },
        error: function () {
            //Do Something to handle error
            console.log("thanh cong roi kia");
        }
    });
}



function Comment(item, event) {
    var textCmt = item.value;
    if (event.key === "Enter" && !event.shiftKey) {
        event.preventDefault(); //bth tui xai bien e chu ko xai event
        $.ajax({
            url: "ajax/CommnetRecipeAjax",
            type: "get", //send it through get method
            data: {
                txtCmt: textCmt,
                bakerID: loginID,
                RecipeID: recipeID
            },
            success: function (response) {
                //Do Something
                console.log(response);
                var cmtShow = document.getElementById("show-comment");
                $(cmtShow).prepend(response);
                item.value = "";
            },
            error: function (xhr) {
                console.log("that bai");
                //Do Something to handle error
            }
        });
    }
}

function getReportRecipe(recipeID) {
    console.log(recipeID);
    var report = $('#report_recipe');
    var graybox = $('#report_recipe .gray-box');
    //       var content = $('#report_list .content');
    graybox.click(() => report.removeClass('d-flex'));
    var exit_button = document.createElement("div").classList.add('exit-btn');
    //load content
    report.addClass('d-flex');
    //
    $('#report_recipe .exit-btn').click(() => report.removeClass('d-flex'));
}
function getReportComment(recipeID) {
    console.log(recipeID);
    var report = $('#report_comment');
    var graybox = $('#report_comment .gray-box');
    //       var content = $('#report_list .content');
    graybox.click(() => report.removeClass('d-flex'));
    var exit_button = document.createElement("div").classList.add('exit-btn');
    //load content
    report.addClass('d-flex');
    //
    $('#report_comment .exit-btn').click(() => report.removeClass('d-flex'));
}



const swiper = new Swiper('.swiper', {
    pagination: {
        el: '.swiper-pagination',
        clickable: true
    },
    navigation: {
        nextEl: '.swiper-button-next',
        prevEl: '.swiper-button-prev',
    },
});
function sendReport(value) {
    var selectReport = document.querySelector('#select_Rp').value;
    var txtReport = document.querySelector('#txtReport').value;
    var txtReportComment = document.querySelector('#txtReportComment').value;
    if (value === 'Recipe') {
        $.ajax({
            url: "ReportRecipeAjax",
            type: "get", //send it through get method
            data: {
                typeReport: selectReport,
                txtReport: txtReport,
                bakerID: loginID,
                recipeID: recipeID
            },
            success: function (response) {
                //Do Something
                console.log("thanh cong roi kia");
                $('#thankReport').html("Thank for your feedback");
//                var cmtShow = document.getElementById("show-comment");
//                cmtShow.innerHTML += response;
//                item.value = "";

            },
            error: function (xhr) {
                console.log("that bai");
                console.log(xhr);
                //Do Something to handle error
            }
        });
    } else if (value === 'Comment') {
        $.ajax({
            url: "ReportCommentAjax",
            type: "get", //send it through get method
            data: {
                reportTypeComment: selectReport,
                commentID: commentID,
                detailComment: txtReportComment,
                userID: loginID

            },
            success: function (response) {
                //Do Something
                console.log("thanh cong roi kia");
                $('#thankReport1').html("Thank for your feedback");
//                var cmtShow = document.getElementById("show-comment");
//                cmtShow.innerHTML += response;
//                item.value = "";

            },
            error: function (xhr) {
                console.log("that bai");
                console.log(xhr);
                //Do Something to handle error
            }
        });
    }
    console.log(loginID);
    console.log(selectReport);
    console.log(txtReport);
    console.log(txtReportComment);
}
function showConfirmBox(id, type, item) {
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
function deleteCMT(commentID, item,confirmBox) {
    var infomation = document.querySelector('#delete_confirm #thankReport');
    $(infomation).addClass('text-center font-weight-bold loading');
    $.ajax({
        url: "ajax/DeleteCommentAjax",
        type: "get",
        data: {
            commentId: commentID
        },
        success: function (response) {
            //Do Something
            setTimeout(() => {
                console.log(response);
                $(infomation).removeClass('loading').html(response);
                $(item).remove();
            }, 500);
setTimeout(() => {
                confirmBox.removeClass('d-flex');
            }, 1000);
        },
        error: function (xhr) {
            console.log("that bai");
            //Do Something to handle error
        }
    });
}
$('.instruction img').click((e) => {
    var item = e.target;
    $(item).css(
            {height: $(item).height() >= 250 ? '200' : 'unset'
                , transition: 500,
            });
    if (item.style.cursor !== "auto")
        if (item.style.cursor !== "zoom-out") {
            item.style.cursor = "zoom-out";
        } else {
            item.style.cursor = "zoom-in";
        }
}
);
var item = $('.instruction img');
for (i = 0; i < item.length; i++) {
    console.log($(item[i]).height());
    if ($(item[i]).height() < 250) {
        $(item[i]).css('cursor', 'auto');
    } else {
        $(item[i]).height(200);
    }
}
