<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="initial-scale=1, width=device-width" />
    <title>Change Password</title>
    <link rel="stylesheet" type="text/css" href="./assets/css/web/bootstrap-4.3.1.min.css">
    <link rel="stylesheet" type="text/css" href="./assets/css/fontawesome-free-6.1.1-web/css/all.min.css">
    <link rel="stylesheet" type="text/css" href="./assets/css/header.css">
    <link rel="stylesheet" type="text/css" href="./assets/css/footer.css">
    <link rel="stylesheet" href="./assets/css/profileInfo.css">

</head>

<body>
    <jsp:include page="header.jsp" />
    <div class="section container row">
        <!-- SECTION LEFT -->
        <div class="col-md-12 col-lg-3 ">
            <div class="profile-img ">
                <img class="border border-dark rounded-circle"
                    src="https://khoinguonsangtao.vn/wp-content/uploads/2022/07/avatar-gau-cute.jpg" alt="User Avt">
            </div>
            <div class="profile-name">Trinh Thang Binh</div>
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
                <li onclick="window.location = './profileChangePassword.jsp'" class="function-select">
                    Change password
                </li>
                <li onclick="window.location = 'logout'" class="list-group-item list-group-item-action">
                    Logout
                </li>
            </ul>

        </div>
        <!-- SECTION RIGHT -->
        <div class="col-md-12 col-lg-9">
            <div id="profile-change-password">
                <div class="profile-header">
                    <h1 class="info-title">Change password: </h1>
                </div>
                <div class="card card-outline-secondary">
                    <div class="card-body">
                        <form action="ProfileChangePasswordController" class="form" role="form" autocomplete="off">
                            <div class="form-group">
                                <label for="inputPasswordOld">Current Password</label>
                                <input type="password" name="passwordOld" class="form-control" id="inputPasswordOld"
                                    required="">
                            </div>
                            <div class="form-group">
                                <label for="inputPasswordNew">New Password</label>
                                <input type="password" name="passwordNew" class="form-control" id="inputPasswordNew"
                                    required="">
                                <span class="form-text small text-muted">
                                    password must be at least 8 characters.
                                </span>
                            </div>
                            <div class="form-group">
                                <label for="inputPasswordNewVerify">Verify</label>
                                <input type="password" name="passwordNewVerify" class="form-control"
                                    id="inputPasswordNewVerify" required="">
                                <span class="form-text small text-muted">
                                    To confirm, type the new password again.
                                </span>
                            </div>
                            <div class="form-group">
                                <input type="hidden" name="userID" value="${sessionScope.LOGIN_USER.id}">
                                <button type="submit" class="btn btn-main-theme" id="frameButton">
                                    <b class="save-b2">Save</b>
                                </button>
                                <c:if test="${not empty requestScope.PASSWORD_ERROR}"><span
                                        class="pass-error">${requestScope.PASSWORD_ERROR}</span></c:if>
                                <c:if test="${not empty requestScope.PASSWORD_SUCCESS}"><span
                                        class="pass-success">${requestScope.PASSWORD_SUCCESS}</span></c:if>

                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>

    <jsp:include page="footer.jsp" />

    <script>
        var frameButton = document.getElementById("frameButton");
        if (frameButton)
        {
            frameButton.addEventListener("click", function (e) {
                window.location.href = "./profile.html";
            });
        }
    </script>
</body>

</html>
