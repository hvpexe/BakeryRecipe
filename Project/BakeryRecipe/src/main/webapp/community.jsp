<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="initial-scale=1, width=device-width" />
        <title>Community</title>
        <c:import url="universal.jsp" />

        <link rel="stylesheet" href="assets/css/community.css" />
        <link rel="stylesheet"
              href="https://fonts.googleapis.com/css2?family=Gelasio:wght@400;500;700&display=swap"
              />


    </head>
    <body>
        <c:import url="header.jsp"/>
        <div class="community">
            <div class="community-section mx-auto ">
                <div class="title-container">
                    <h1 class="notify-title">Recommend For You</h1>
                </div>
                <div class="recipe-list row ">
                    <c:forEach items="${listRecommend}" var="cc">
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
                                <a href="profile?userid=${cc.userID}" class="text-truncate">${cc.username}</a> 
                                <c:out value="${cc.getDatePostFormat()}"/></div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>

        <div class="community">
            <div class="community-section mx-auto ">
                <div class="title-container">
                    <h1 class="notify-title">Most Popular Recipes</h1>
                    <a href="./MostRatedRecipe" class="btn seemore">See more</a>
                </div>
                <div class="recipe-list row ">
                    <c:forEach items="${listRated}" var="cc">
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
                                <a href="profile?userid=${cc.userID}" class="text-truncate">${cc.username}</a> 
                                <c:out value="${cc.getDatePostFormat()}"/></div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>

        <div class="community" id="newest">
            <div class="community-section mx-auto ">
                <div class="title-container">
                    <h1 class="notify-title">Most Recent Recipes</h1>
                    <a href="./MostRecentRecipe" class="btn seemore">See more</a>
                </div>
                <div class="recipe-list row ">
                    <c:forEach items="${listRecent}" var="cc">
                        <div class="recipe col-6 col-md-4 col-lg-3">
                            <div class="img-container">
                                <a href=".\RecipeDetail?recipeID=${cc.id}">
                                    <img class="recipe-img" alt=""
                                         src="${cc.cover}" />
                                </a>
                                <div class="react">
                                    <div>${cc.like} likes</div>
                                    <div>${cc.comment}  comments</div>
                                </div>
                            </div>
                            <div class="recipe-name">${cc.name}</div>
                            <div class="recipe-author">
                                <a href="profile?userid=${cc.userID}" class="text-truncate">${cc.username}</a> 
                                <c:out value="${cc.getDatePostFormat()}"/></div>

                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>

        <c:import url="footer.jsp"/>
        <script src="assets/js/Jquery/jquery-core.js" ></script>
        <script>
            function changeSave(elem) {
                console.log(${login.id});
                console.log(elem.getAttribute('recipeid'));
                $.ajax({
                    url: "ajax/updatesaverecipe",
                    data: {
                        user: ${login.id},
                        recipe: elem.getAttribute('recipeid')
                    },
                    success: function (data) {
                        elem.classList.toggle('check');
                        if (elem.classList.contains('check')) {
                            elem.innerHTML = elem.innerHTML.replace('Save', 'UnSave');
                        } else
                            elem.innerHTML = elem.innerHTML.replace('UnSave', 'Save');
                    }
                });
            }
        </script>
    </body>
</html>

