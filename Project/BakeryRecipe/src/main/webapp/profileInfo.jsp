<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Your information</title>
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
                    <img class="border border-dark rounded-circle" src="https://khoinguonsangtao.vn/wp-content/uploads/2022/07/avatar-gau-cute.jpg" alt="User Avt">
                </div>
                <div class="profile-name">Trinh Thang Binh</div>
                <ul id="profile-function" class="list-group">
                    <li onclick="window.location = './profileInformation.jsp'" class="function-select">
                        Change information
                    </li>
                    <li onclick="window.location = '${download}'">
                        Your comment
                    </li>
                    <li onclick="window.location = '${rating}'">
                        Liked recipe
                    </li>
                    <li onclick="window.location = './profileChangePass.jsp'">
                        Change password
                    </li>
                    <li onclick="window.location = 'logout'">
                        Logout
                    </li>
                </ul>

            </div>
            <!-- SECTION RIGHT -->
            <div class="col-md-12 col-lg-9">
                <!-- Your information -->
                <div id="profile-information">
                    <div class="profile-header">
                        <h1 class="info-title">Change information: </h1>
                    </div>
                    <form action="EditInformationController" method="post" enctype="multipart/form-data">
                        <div class="infor-detail">
                            <div class="row">
                                <div class="col-md-3">Firstname</div>
                                <div class="col-md-9">
                                    <input type="text" name="firstname" value="Trinh">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-3">Lastname</div>
                                <div class="col-md-9">
                                    <input type="text" name="lastname" value="Thang Binh">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-3">Birthday</div>
                                <div class="col-md-9">
                                    <input type="date" name="birthday" value="2022-8-1">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-3">Gender</div>
                                <div class="col-md-9">
                                    <select name="gender">
                                        <option value="Male">Male</option>
                                        <option value="Female">Female</option>
                                        <option value="Other">Other</option>
                                    </select>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-3">Avatar</div>
                                <div class="col-md-9">
                                    <input type="file" name='avatar' value="">
                                </div>
                            </div>
                        </div>
                        <input type="hidden" name="memberID" value="">
                        <input class="info-submit" type="submit" value="Submit">

                    </form>
                </div>
            </div>
        </div>

        <jsp:include page="footer.jsp"/>
    </body>
</html>



