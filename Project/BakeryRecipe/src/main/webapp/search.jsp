<%-- 
    Document   : saved
    Created on : Sep 21, 2022, 10:03:29 AM
    Author     : VO MINH MAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="initial-scale=1, width=device-width" />
        <title></title>
        <meta name="description" content="" />

        <link rel="stylesheet" href="assets/css/search.css" />

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
                            ><a class="trnh-thng-bnh2">Trịnh Thăng Bình </a>
                        </div>
                    </c:forEach>
                    <c:forEach items="${requestScope.LIST_RECIPE}" var="n">
                        <div class="div2">
                            <img class="img-icon1" alt="" src="${n.img}" /><a
                                class="mooncake"
                                ><p class="mooncake-p"><span>Mooncake</span></p></a
                            ><a class="trnh-thng-bnh2">Trịnh Thăng Bình </a>
                        </div>
                    </c:forEach>
                </div>

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

