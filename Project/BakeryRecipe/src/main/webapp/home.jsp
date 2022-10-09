<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="initial-scale=1, width=device-width" />
        <title>Home</title>
        <link rel="stylesheet" href="assets/css/web/bootstrap-4.3.1.min.css" />
        <link rel="stylesheet" type="text/css" href="./assets/css/fontawesome-free-6.1.1-web/css/all.min.css">
        <link rel="stylesheet" href="assets/css/home.css" />

    </head>
    <body>
        <c:import url="header.jsp"/>
        <div class="home-container">
            <div class="post-section">
                <div class="posting-section">
                    <img class="avatar-icon"
                         src="${login.avatar}" alt="ava" />
                    <button class="btn-button" id="btnButton">
                        <i class="fa-solid fa-plus"></i> Add your post
                    </button>
                </div>
                <c:forEach items="${homeRecipe}" var="re">
                    <div class="user-recipe">
                        <div class="media recipe-header">
                            <img class="recipe-ava"
                                 src="<c:out value="${re.getAvatar()}"/>"
                                 alt="avatar" />
                            <div class="media-body ml-3">
                                ${re.username}
                                <div class="text-muted small"><c:out value="${re.getDatePostFormat()}"/></div>
                            </div>
                            <i class="fa-solid fa-ellipsis"></i>
                        </div>

                        <div class="recipe-text">
                            ${re.description}
                        </div>
                        <a href=".\RecipeDetailController?ID=${re.getUserID()}&recipeID=${re.getId()}">
                            <img  class="recipe-img" alt=""
                                  src="${re.cover}" />
                        </a>
                        <div class="recipe-react">
                            <a href="javascript:void(0)" class="d-inline-block text-muted">
                                <span class="align-middle">
                                    <strong>${re.like}</strong> Likes</span>
                            </a>
                            <a href="javascript:void(0)" class="d-inline-block text-muted ml-3">
                                <span class="align-middle">
                                    <strong>${re.comment}</strong> Comments</span>
                            </a>
                            <a href="#" class="d-inline-block text-muted ml-3">
                                <i class="ion ion-md-share align-middle"></i>&nbsp;
                                <span class="align-middle">Save</span>
                            </a>
                            <a href="./cookdetail.jsp" class="d-inline-block text-muted ml-3">
                                <i class="ion ion-md-share align-middle"></i>&nbsp;
                                <span class="align-middle">View detail</span>
                            </a>
                        </div>
                    </div>
                </c:forEach>


            </div>
            <div class="frame-div">
                <div class="banner-div">
                    <div class="rectangle-div"></div>
                    <img class="group-icon" alt="" src="assets/images/other/group-36.svg"/>
                    <div class="title-div">Make Cake without prepare!</div>
                    <div class="try-premium-membersh">
                        Make a cake with ingredient you haved
                    </div>
                    <a href="#" class="btn btn-start">
                        <span>Start Now <i class="fa-sharp fa-solid fa-right-to-bracket"></i></span>
                    </a>
                </div>
                <div class="recommend-cook">
                    <b class="cook-title">Good Cook</b>
                    <div class="cook-container">
                        <a class="cook-info" href="./profile.html">
                            <img class="cook-ava" alt="" src="assets/images/avt/avatarimage2@2x.png" />
                            Cammy Hedling
                        </a>
                        <a class="btn follow-btn" href="#">Follow</a>
                    </div>
                </div>
                <div class="trend-cake">
                    <b class="cake-title">Trend Cakes</b>
                    <div class="cake-container">
                        <a class="cake-info" href="#">
                            <img class="cake-img" alt="" src="assets/images/avt/avatar1@2x.png" />
                            Tiramisu
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <script>
            var btnButton = document.getElementById("btnButton");
            if (btnButton) {
                btnButton.addEventListener("click", function (e) {
                    window.location.href = "./addrecipe.jsp";
                });
            }
        </script>
    </body>
</html>

