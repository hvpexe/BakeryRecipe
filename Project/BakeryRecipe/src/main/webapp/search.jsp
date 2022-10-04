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
                <div class="frame-div1">
                    <b class="saved-b">Search</b>
                    <form class="frame-form">
                        <img class="iconsearch" alt="" src=".\assets\css\fontawesome-free-6.1.1-web\svgs\solid\magnifying-glass.svg" /><input
                            class="frame-input"
                            type="text"
                            placeholder="Search Recipes"
                            name="search"
                            />
                    </form>
                </div>
                <div class="mid-div2">
                    <div class="frame-dip2 in-div1">
                        <div class="newest-div">Recipe</div>
                    </div>
                    <div class="frame-dip2 in-div">
                        <div class="newest-div">Baker</div>
                    </div>
                </div>
                <div class="saved-item-div">
                    <div class="div1">
                        <img
                            class="img-icon"
                            alt=""
                            src=".\assets\images\image@2x.png"
                            id="imgImage"
                            /><a class="mooncake"
                            ><p class="mooncake-p"><span>Mooncake</span></p></a
                        ><a class="trnh-thng-bnh2">Trịnh Thăng Bình </a>
                    </div>
                    <div class="div2">
                        <img class="img-icon1" alt="" src=".\assets\images\image@2x.png" /><a
                            class="mooncake"
                            ><p class="mooncake-p"><span>Mooncake</span></p></a
                        ><a class="trnh-thng-bnh2">Trịnh Thăng Bình </a>
                    </div>

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

