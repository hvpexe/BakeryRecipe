console.log($('#addrecipe'));
$('#addrecipe').click(()=>{
    console.log(this);
    window.location.href = 'addrecipe.jsp';
});


function getReportUser(userID) {
    console.log(userID);
    var report = $('#report_user');
    var graybox = $('#report_user .gray-box');
    //       var content = $('#report_list .content');
    graybox.click(() => report.removeClass('d-flex'));
    var exit_button = document.createElement("div").classList.add('exit-btn');
    //load content
    report.addClass('d-flex');
    //
    $('#report_user .exit-btn').click(() => report.removeClass('d-flex'));
}



function sendReport1(value){
        var selectReport = document.querySelector('#select_Rp').value;
   
    var txtReportUser=document.querySelector('#txtReportUser').value;
    console.log(txtReportUser);
    console.log(userReport);
    console.log(userReported);
    console.log(selectReport);
        $.ajax({
            url: "ReportUserAjax",
            type: "get", //send it through get method
            data: {
               detailUSerComment:txtReportUser,
               userID1:userReport,
               userID2:userReported,
               reportTypeUSer:selectReport
            },
            success: function (response) {
                //Do Something
                console.log("thanh cong roi kia");
                $('#thankReport2').html("Thank for your feedback");
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

function  followButton2(item, val1, val2, action) {
//                eventac.target.style.backgroundColor = 'white';
//                event.target.classList.toggle("button-Follower");
///
//                console.log(event.target.classList);

    var action = val1;
    $.ajax({
        url: "ajax/UpdateUserFollowAjax",
        type: "get", //send it through get method
        data: {
            follower: userReported,
            action: action,
            followed: userReport
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