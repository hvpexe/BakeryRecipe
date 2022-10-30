<%-- 
    Document   : saved
    Created on : Sep 21, 2022, 10:03:29 AM
    Author     : VO MINH MAN
--%>
<%@page import="dao.RecipeDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="initial-scale=1, width=device-width" />
        <meta name="description" content="" />
        <title>Saved Recipe</title>

        <c:import url="universal.jsp" />

        <link rel="stylesheet" href="assets/css/community.css" />
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
            href="https://fonts.googleapis.com/css2?family=Beau Rivage:wght@400&display=swap"
            />
        <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css2?family=Arima Madurai:wght@800&display=swap"
            />
    </head>
    <body>
        <c:import url="header.jsp"/>

        <div class="community container">
            <div class="community-section mx-auto ">
                <div class="title-container">
                    <h1 class="title">Saved</h1>
                </div>
                <div class="recipe-list row ">
                    <c:forEach items="${RecipeList}" var="cc">
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
                <div class="paging col my-4">
                    <c:forEach begin="1" end="${totalPage}" var="i">
                        <a href="savedrecipe?index=${i}" class="paging col">${i}</a>
                    </c:forEach>
                </div> 
            </div>
        </div>

        <c:import url="footer.jsp"/>
        <script></script>
    </body>
</html>

