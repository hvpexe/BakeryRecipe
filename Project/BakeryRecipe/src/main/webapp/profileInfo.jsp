<%@page import="dao.UserDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Your information</title>
        <c:import url="universal.jsp"/> 
        <link rel="stylesheet" href="./assets/css/profileInfo.css">

    </head>

    <body>
        <jsp:include page="header.jsp" />
        <div class="section container row my-0">
            <!-- SECTION LEFT -->
            <div class="col-md-6 col-lg-3">
                <div class="profile-img ">
                    <img class="col-3 col-lg-10 p-0 rounded-circle" src="${sessionScope.login.avatar}" alt="User Avt">
                </div>
                <div class="profile-name">${sessionScope.login.name}</div>
                <ul id="profile-function" class="list-group">
                    <li onclick="window.location = window.location" class="function-select">
                        Change information
                    </li>
                    
                    <li onclick="ajaxLoad('./ajax/ProfileInfoCommentListAjax')">
                        Your comment
                    </li>
                    <li onclick="ajaxLoad('./ajax/LikedRecipeListAjax')">
                        Liked recipe
                    </li>
                    <li onclick="ajaxLoad('./profileinfo/profileChangePass.jsp')">
                        Change password
                    </li>
                    <li onclick="window.location ='/BakeryRecipe/LogoutController'">
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
                    <form action="ProfileInfo" method="post" enctype="multipart/form-data">
                        <div class="infor-detail">
                            <div class="row">
                                <div class="col-md-3">Email</div>
                                <div class="col-md-9">
                                    <input type="text" name="email" value="${sessionScope.login.email}" readonly="">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-3">Date Registered</div>
                                <div class="col-md-9">
                                    <input type="date" name="dateregister" value="${sessionScope.login.dateRegister}" readonly="">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-3">First Name</div>
                                <div class="col-md-9">
                                    <input type="text" name="firstname" value="${sessionScope.login.firstName}">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-3">Last Name</div>
                                <div class="col-md-9">
                                    <input type="text" name="lastname" value="${sessionScope.login.lastName}">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-3">Role</div>
                                <div class="col-md-9">
                                    <input type="text" name="role" value="${sessionScope.login.role}" readonly="">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-3">Phone Number</div>
                                <div class="col-md-9">
                                    <input type="text" name="phone" value="${sessionScope.login.phone}">
                                </div>
                            </div>    
                            <div class="row">
                                <div class="col-md-3">Birthday</div>
                                <div class="col-md-9">
                                    <input type="date" name="birthday" value="${sessionScope.login.birthday}">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-3">Gender</div>
                                <div class="col-md-9">
                                    <select name="gender">
                                        <option value="Male" ${sessionScope.login.gender == 'Male'? 'selected': ''}>Male</option>
                                        <option value="Female" ${sessionScope.login.gender == 'Female'? 'selected': ''}>Female</option>
                                        <option value="Other" ${sessionScope.login.gender == 'Other'? 'selected': ''}>Other</option>
                                    </select>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-3">Address</div>
                                <div class="col-md-9">
                                    <input type="text" name="address" value="${sessionScope.login.address}">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-3">Avatar</div>
                                <div class="col-md-9">
                                    <input type="file" name='avatar' value="${sessionScope.login.avatar}">
                                </div>
                            </div>
                        </div>
                        <input type="hidden" name="userID" value="${sessionScope.login.id}">
                        <input class="info-submit" type="submit" value="Submit" >
                       
                    </form>
                </div>
            </div>
        </div>
                            
        <jsp:include page="footer.jsp"/>
        <script src="assets/js/Jquery/jquery-core.js"></script>
        <script src="assets/js/profileInfo.js"></script>
        <script>
//            document.querySelector('#profile-function :nth-child(2)').click()
        </script>
    </body>
</html>



