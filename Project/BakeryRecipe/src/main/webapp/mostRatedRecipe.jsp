<%-- 
    Document   : mostRatedRecipe
    Created on : Sep 27, 2022, 7:56:56 AM
    Author     : kichi
--%>

<%@page import="dao.RecipeDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="initial-scale=1, width=device-width" />
    <title>Most Rated Recipe</title>
    <meta name="description" content="" />

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
    
    <c:set value="<%= RecipeDAO.getMostRatedRecipe()%>" var="RecipeList"/>
    <div class="communitydone-div">
      <div class="section-div">
        <div class="list-div">
          <div class="titile-div">
            <h1 class="recommend-for-you">Recommend For You</h1>
          </div>
          <div class="items-div">
              <c:forEach items="${RecipeList}" var="cc" >
                  <form action="recipe" class="col-md-4 col-lg-3  d-flex align-content-center">
                      <div class="recipe-div" value="postid">
                          <img class="img-icon" alt="" src="${cc.img}" />
                          <div class="recipe-name-div">
                              <a onclick="this.parentNode.submit()" >${cc.name}</a>
                          </div>
                          <div class="recipe-author-div">${cc.username}</div>
                      </div>
                  </form>
              </c:forEach>    
          </div>
        </div>
      </div>
    </div>
    <c:import url="footer.jsp"/>
    <script></script>
    </body>
</html>
