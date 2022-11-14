<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="initial-scale=1, width=device-width" />
    <title>Change Password</title>
    <link rel="stylesheet" type="text/css" href="./assets/css/web/bootstrap-4.3.1.min.css">
    <link rel="stylesheet" type="text/css" href="./assets/css/fontawesome-free-6.1.1-web/css/all.min.css">
    <link rel="stylesheet" href="./assets/css/profileInfo.css">

</head>

<body>
<%--<jsp:include page="header.jsp" />--%>
<div class="section container row">
     SECTION LEFT 
    <div class="col-md-12 col-lg-3 ">
        <div class="profile-img ">
            <img class="border border-dark rounded-circle"
                src="https://khoinguonsangtao.vn/wp-content/uploads/2022/07/avatar-gau-cute.jpg" alt="User Avt">
        </div>
        <div class="profile-name">${sessionScope.login.name}</div>
        <ul id="profile-function" class="list-group">
            <li onclick="window.location = './profileInformation.jsp'">
                Change information
            </li>
            <li onclick="window.location = '${download}'">
                Your comment
            </li>
            <li onclick="window.location = '${rating}'">
                Liked recipe
            </li>
            <li onclick="window.location = './profileChangePass.jsp'" class="function-select">
                Change password
            </li>
            <li onclick="window.location = 'logout'" class="list-group-item list-group-item-action">
                Logout
            </li>
        </ul>

    </div>
     SECTION RIGHT 
    <div class="col-md-12 col-lg-9">-->
<!--<div id="profile-change-password">-->
<div class="profile-header">
    <h1 class="info-title">Change password: </h1>
</div>
<div class="card card-outline-secondary">
    <div class="card-body">
        <!--<form action="ChangePasswordController" class="form" role="form" autocomplete="off">-->
        <c:if test="${ not empty sessionScope.login.password }"> 
            <div class="form-group">
                <label for="inputPasswordOld">Current Password</label>
                <input type="password" name="oldPassword" class="form-control" style="max-width: 400px" id="inputPasswordOld"
                       required="">
            </div>
        </c:if> 
        <div class="form-group">
            <label for="inputPasswordNew">New Password</label>
            <input type="password" name="newPassword" class="form-control" style="max-width: 400px" id="inputPasswordNew"
                   required="">
            <span class="form-text small text-muted">
                password must be at least 8 characters.
            </span>
        </div>
        <div class="form-group">
            <label for="inputPasswordNewVerify">Verify</label>
            <input type="password" name="confirmNewPassword" class="form-control " style="max-width: 400px"
                   id="inputPasswordNewVerify" required="">
            <span class="form-text small text-muted">
                To confirm, type the new password again.
            </span>
        </div>
        <div class="form-group">
            <input type="hidden" name="userID" value="${sessionScope.login.id}">
            <button type="submit" class="btn save-pass" id="frameButton" onclick="ajaxChangePass()">
                Save
            </button>
            <div id="pass-success"></div>
            <div id="pass-error"></div>
        </div>
        <!--</form>-->
    </div>
</div>
<!--test pass-->

<!--</div>-->
<!--        </div>
    </div>
    </div>

<%--<jsp:include page="footer.jsp" />--%>


</body>

</html>-->
<script>
    function ajaxChangePass() {
        var verifyPass = document.querySelector('#inputPasswordNewVerify');
        var newpass = document.getElementById('inputPasswordNew');
        var oldpass = document.getElementById('inputPasswordOld') || '';


        $.ajax({
            url: "ChangePasswordAjax",
            type: "get", //send it through get method
            data: {
                oldPassword: oldpass.value,
                newPassword: newpass.value,
                confirmNewPassword: verifyPass.value,
                userID: '${sessionScope.login.id}'
            },
            success: function (refe) {
                $('#pass-success').html(refe);

            },
            error: function () {
                $('#pass-error').html('Change password Fail');
            }
        });

    }
</script>