<%-- 
    Document   : saved
    Created on : Sep 21, 2022, 10:03:29 AM
    Author     : VO MINH MAN
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="initial-scale=1, width=device-width" />
        <title></title>
        <meta name="description" content="" />
        <c:import url="universal.jsp"/>
        <link rel="stylesheet" href="assets/css/search.css" />

    </head>
    <body>
        <c:import url="header.jsp"/>
        <div>
            <div class="community">
                <div class="community-section mx-auto ">
                    <div class="title-container">
                        <h1 class="notify-title">Search Results</h1>
                    </div>

                    <form action="Search" id="search" class="col-12 col-md-8 mx-auto mb-4">
                        <div class="search-wrap d-flex align-items-center">
                            <i class="search-icon fas fa-search mr-3 "></i>
                            <input class="search-input flex-grow-1" type="text" placeholder="Search Recipes" name="searchKey">
                            <select name="action" class="search-select">
                                <option value="Recipe">
                                    Recipe      
                                </option> 
                                <option value="Baker">
                                    Baker
                                </option>
                            </select>
                        </div>
                    </form>

                    <div class="recipe-list row container-fluid">
                        <c:forEach items="${requestScope.LIST_BAKER}" var="n">
                            <div class="col-4 col-md-3 col-lg-2 my-3 text-center">
                                <div class="mb-2">
                                    <a href="profile?userid=${n.id}">
                                        <img class="w-100 rounded-circle border" alt="avatar"
                                             src="${n.avatar}" id="imgImage"/>
                                    </a>
                                </div>
                                <a class="h5 text-decoration-none text-dark" href="profile?userid=${n.id}">${n.name}</a>
                            </div>
                        </c:forEach>
                        <c:forEach items="${requestScope.LIST_RECIPE}" var="cc">
                            <div class="recipe col-6 col-md-4 col-lg-3">
                                <div class="img-container">
                                    <a href=".\RecipeDetail?recipeID=${cc.id}">
                                        <img class="recipe-img" alt=""
                                             src="${cc.cover}" />
                                    </a>
                                    <div class="react">
                                        <div>${cc.like} likes</div>
                                        <div>${cc.comment} comments</div>
                                    </div>
                                </div>
                                <div class="recipe-name">${cc.name}</div>
                                <div class="recipe-author">
                                    <a href="#" class="text-truncate">${cc.username}</a> 
                                    <c:out value="${cc.getDatePostFormat()}"/></div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>

        <c:import url="footer.jsp"/>

        <script>
            var imgImage = document.getElementById("imgImage");
            if (imgImage) {
                imgImage.addEventListener("click", function (e) {
                    window.open("./cook-detaildone.html");
                });
            }
        </script>
    </body>
</html>

