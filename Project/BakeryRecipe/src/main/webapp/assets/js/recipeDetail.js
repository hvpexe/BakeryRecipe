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
            recipe:recipeID,
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
    $.ajax({
        url: "ajax/likerecipe",
        type: "get", //send it through get method
        data: {
            recipe:recipeID,
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
    if (event.key === "Enter") {


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
                cmtShow.innerHTML += response;
                item.value = "";

            },
            error: function (xhr) {
                console.log("that bai");
                //Do Something to handle error
            }
        });
    }
}

function getReport(recipeID) {
    console.log(recipeID);
    var report = $('#report_list');
    var graybox = $('#report_list .gray-box');
    //       var content = $('#report_list .content');
    graybox.click(() => report.removeClass('d-flex'));
    var exit_button = document.createElement("div").classList.add('exit-btn');
    //load content
    report.addClass('d-flex');
    //
    $('#report_list .exit-btn').click(() => report.removeClass('d-flex'));
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


function sendReport(){
    var selectReport = document.querySelector('#select_Rp').value;
    var txtReport =document.querySelector('#txtReport').value;
  
    console.log(loginID);
   console.log(selectReport);
   console.log(txtReport);
     $.ajax({
            url: "ReportRecipeAjax",
            type: "get", //send it through get method
            data: {
                typeReport: selectReport,
                txtReport: txtReport,
                bakerID: loginID,
                recipeID:recipeID
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
}