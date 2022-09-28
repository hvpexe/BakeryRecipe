 <%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${login==null}" >
    <jsp:forward page="login.jsp"/>
</c:if>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="initial-scale=1, width=device-width" />
        <title></title>
        <meta name="description" content="" />

        <link rel="stylesheet" href="assets/css/profile.css">

        <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css2?family=Inter:wght@400;700&display=swap"
            />
        <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css2?family=Abhaya Libre:wght@700&display=swap"
            />
        <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css2?family=Abel:wght@400&display=swap"
            />
        <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css2?family=Gelasio:wght@400;500;700&display=swap"
            />
        <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css2?family=Arima Madurai:wght@800&display=swap"
            />
        <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css2?family=Archivo Narrow:wght@700&display=swap"
            />
        <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css2?family=Beau Rivage:wght@400&display=swap"
            />
    </head>
    <body>
        <c:import url="header.jsp"/>

        <section class="profile-section">
            <div class="section-div8">
                <div class="infomation-div1">

                    <img class="avt-icon" alt="" src="${sessionScope.login.avatar}" /><button
                        class="btn-button3"
                        >
                        <img class="shape-icon3" alt="" src="public/shape.svg" />
                    </button>
                    <div class="div38">
                        <h3 class="trnh-thng-bnh8">${sessionScope.login.firstName}</h3>
                        <span class="following-999-follower">1 Following 999 Follower</span>
                    </div>
                    <button class="edit-proile-button">
                        <div class="log-in-div3">Edit Profile</div>
                    </button>    
                </div>
                <button class="input-button" id="inputButton">
                    <img class="text-icon" alt="" src="assets/images/avt/text.svg" />
                    <div class="text-div">Add your post</div>
                </button>
                <div class="titile-div5"><b class="text-b2">Activity</b></div>
                <div class="post-div2">

                    <img class="avt-icon1" alt="" src="${sessionScope.login.avatar}" />
                    <img class="post-img-icon" alt="" src="public/img26@2x.png" />
                    <div class="post-text-div">
                        Added courgette and green beans, served with brown rice. Also added
                        a spoonful of rice vinegar to the sauce as suggested by others.
                        Really good!! Will definitely have again.
                    </div>
                    <div class="text-div1">
                        <p class="trnh-thng-bnh9"><b>${sessionScope.login.firstName}</b></p>
                        <p class="h-p"><span>1h</span></p>
                    </div>
                    <button class="icon-button">
                        <img class="shape-icon3" alt="" src="public/shape4.svg" /></button>
                </div>
                <div class="post-div">
                    <div class="user-info-div">
                        <button class="iconoptions-button">
                            <img class="shape-icon" alt="" src="assets/public/shape.svg">
                        </button>
                        <div class="profile-name-div">
                            <a class="trnh-thng-bnh" href="./profile.html">Trịnh Thăng Bình</a><a class="h-a" href="./cook-detaildone.html">1h</a>
                        </div>
                        <img class="avatar-icon1" alt="" src="assets/public/ellipse-9@2x.png" id="avatarIcon1">
                    </div>
                    <div class="user-post-div">
                        <img class="image-icon" alt="" src="assets/public/image@2x.png">
                        <div class="detail-div">
                            Added courgette and green beans, served with brown rice. Also
                            added a spoonful of rice vinegar to the sauce as suggested by
                            others. Really good!! Will definitely have again.
                        </div>
                    </div>

                    <div class="viewer-option-div">
                        <a class="save" href="./cook-detaildone.html"><img class="vector-icon" alt="" src="assets/public/vector.svg"><b class="save-b">Save</b></a><a class="view-a" href="./cook-detaildone.html"><img class="icon-eye" alt="" src="assets/public/-icon-eye.svg"><b class="save-b">View</b></a>
                    </div>
                </div>
            </div>

        </section>

        <script>
            var inputButton = document.getElementById("inputButton");
            if (inputButton) {
                inputButton.addEventListener("click", function (e) {
                    window.location.href = "./add-recipe.html";
                });
            }
        </script>
    </body>
</html>
