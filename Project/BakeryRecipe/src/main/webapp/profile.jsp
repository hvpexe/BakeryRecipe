<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${login==null}" >
    <jsp:forward page="login.jsp"/>
</c:if>
<!DOCTYPE html>
<html xmlns:h="http://xmlns.jcp.org/jsf/html" xmlns:f="http://xmlns.jcp.org/jsf/core">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="initial-scale=1, width=device-width" />
        <title></title>
        <meta name="description" content="" />


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
        <link rel="stylesheet" href="assets/css/web/bootstrap-4.3.1.min.css"/>
        <link rel="stylesheet" href="assets/css/profile.css">
    </head>
    <body>
        <c:import url="header.jsp"/>

        <div class="section container-fluid col-10 mt-3 ">
            <div class="infomation col row flex-wrap flex-lg-nowrap justify-content-around align-items-start">
                <button class="profile-option_btn">
                    <img class="profile-icon" alt="" src="public/shape.svg" />
                </button>
                <div class="profile-text d-flex flex-column flex-md-row align-items-center col-12 col-lg-8">
                    <img class="avt-icon" alt="profile picture" src="${sessionScope.login.avatar}" />
                    <div class="d-flex flex-column align-self-lg-start ml-lg-2"> 
                        <span class="profile-text_name">${sessionScope.login.name}</span>
                        <span class="profile-text_follow-status">1 Following 999 Follower</span>
                    </div>
                </div>
                <button class="edit-proile-button">
                    <div class="edit-btn">Edit Profile</div>
                </button>    
            </div>
            <button class="input-button col-8" id="inputButton">
                <i class="fas fa-plus" style="color: var(--main-theme-color) "></i>
                <div class="text-div">Add your post</div>
            </button>
            <div class="title-div col"><b class="text">Activity</b></div>

            <div class="user_post col-12 d-flex flex-column">
                <div class="post-div col-6 align-self-start p-0">
                    <img class="post-avt " alt="" src="${sessionScope.login.avatar}" />
                    <div class="d-flex flex-column">
                        <p class="post-name col p-0 d-flex align-items-center justify-content-start"><b>${sessionScope.login.name}</b></p>
                        <p class="post-time col p-0 d-flex align-items-center justify-content-start"><span>1h</span></p>
                    </div>
                </div>
                <div class="post-text p-2">
                    Added courgette and green beans, served with brown rice. Also added
                    a spoonful of rice vinegar to the sauce as suggested by others.
                    Really good!! Will definitely have again.
                </div>
                <img class="post-picture col" alt="a decorative picture" src="public/img26@2x.png" />
                <button class="post-option-btn ">
                    <img class="profile-icon col" alt="" src="public/shape4.svg" />
                </button>
            </div>
        </div>


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
