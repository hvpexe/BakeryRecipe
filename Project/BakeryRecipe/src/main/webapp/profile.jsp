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

        <div class="section-container">
            <div class=" section-profile">
                <div class="row profile-header">
                    <img class="col-3 avt-icon"
                         src=${sessionScope.login.avatar}
                         alt="" />
                    <div class="col-6">
                        <h3 class="profile-name">${sessionScope.login.name}</h3>
                        <span class="follow">1 Following</span>
                        <span class="follow">999 Follower</span>

                    </div>
                    <a href="./profileInfo.jsp" class="btn edit-profile-button">Edit Profile</a>
                </div>
                <a href="#" class="btn input-button">Add your post</a>
                <div class="profile-activity">
                    <b>Activity</b>
                </div>
                <c:forEach items="${profileRecipe}" var="re">
                    <div class="profile-recipe">
                        <div class="media recipe-header">
                            <img class="recipe-ava"
                                 src="${re.avatar}"
                                 alt="" />
                            <div class="media-body ml-3">
                                ${re.username}
                                <div class="text-muted small"><c:out value="${re.getDatePostFormat()}"/></div>
                            </div>
                            <i class="fa-solid fa-ellipsis"></i>
                        </div>

                        <div class="recipe-text">
                            ${re.description}
                        </div>

                        <img class="recipe-img" alt=""
                             src="${re.cover}" />

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
                            <a href="#" class="d-inline-block text-muted ml-3">
                                <i class="ion ion-md-share align-middle"></i>&nbsp;
                                <span class="align-middle">View detail</span>
                            </a>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
        <script src="assets/js/Jquery/jquery-core.js"></script>
        <script src="assets/js/profile.js"></script>
    </body>
</html>
