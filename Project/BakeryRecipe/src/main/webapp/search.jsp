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

        <link rel="stylesheet" href="assets/css/search1.css" />

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
        <link rel="stylesheet" href="assets/css/web/bootstrap-4.3.1.min.css" />
    </head>
    <body>
        <c:import url="header.jsp"/>
          <div class="saved-div">
            <div class="section-div">
                <form action="Search" id="searchRec">
                    <div class="frame-div1">
                        <b class="saved-b">Search</b>
                        <div class="frame-form">
                            <img class="iconsearch" alt="" src=".\assets\css\fontawesome-free-6.1.1-web\svgs\solid\magnifying-glass.svg" />
                            <input
                                class="frame-input"
                                type="text"
                                placeholder="Search Recipes"
                                name="searchKey"
                                />
                        </div>
                    </div>
                    <div class="mid-div2">
                        <select name="action">
                            <option value="Recipe">
                            <div class="frame-dip2 in-div1">
                                <div class="newest-div">Recipe</div>
                            </div>
                            </option> 
                            <option value="Baker">
                            <div class="frame-dip2 in-div" >
                                <div class="newest-div">Baker</div>
                            </div>
                            </option>
                        </select>
                    </div>
<!--                    <input type="submit" >-->
                </form>
         
                <div class="saved-item-div">
                    <c:forEach items="${requestScope.LIST_BAKER}" var="n">
                        <div class="div1">
                            <img
                                class="img-icon"
                                alt=""
                                src="${n.avatar}"
                                id="imgImage"
                                /><a class="mooncake"
                                ><p class="mooncake-p"><span>${n.name}</span></p></a
                            ><div class="follow-button"><div>Follow</div></div>
                        </div>
                    </c:forEach>
                    <c:forEach items="${requestScope.LIST_RECIPE}" var="cc">
                        <div class="recipe col-6 col-md-4 col-lg-3">
                            <div class="img-container">
                                <img class="recipe-img" alt=""
                                     src="${cc.cover}" />
                                <div class="bookmark">
                                    Save <i class="fa-regular fa-bookmark"></i>
                                </div>
                                <div class="react">
                                    <div>${cc.like} likes</div>
                                    <div>${cc.comment} comments</div>
                                </div>
                            </div>
                            <div class="recipe-name">${cc.name}</div>
                            <div class="recipe-author">
                                <a href="#" class="text-truncate">${cc.username}</a> 
                                
                        </div>
                                </div>
                    </c:forEach>
                
                </div>
            

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

