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

    <link rel="stylesheet" href="./saved.css" />

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
          <b class="saved-b">Saved</b>
          <form class="frame-form">
            <img class="iconsearch" alt="" src="public/iconsearch.svg" /><input
              class="frame-input"
              type="text"
              placeholder="Search Recipes"
              name="search"
            />
          </form>
          <img class="frame-icon" alt="" src="public/frame-33.svg" />
        </div>
        <div class="saved-item-div">
          <div class="div1">
            <img
              class="img-icon"
              alt=""
              src="public/31200x6764-1@2x.png"
              id="imgImage"
            /><a class="mooncake"
              ><p class="mooncake-p"><span>Mooncake</span></p></a
            ><a class="trnh-thng-bnh2">Trịnh Thăng Bình </a>
          </div>
          <div class="div2">
            <img class="img-icon1" alt="" src="public/31200x6764-1@2x.png" /><a
              class="mooncake"
              ><p class="mooncake-p"><span>Mooncake</span></p></a
            ><a class="trnh-thng-bnh2">Trịnh Thăng Bình </a>
          </div>
          <div class="div3">
            <img class="img-icon1" alt="" src="public/31200x6764-1@2x.png" /><a
              class="mooncake"
              ><p class="mooncake-p"><span>Mooncake</span></p></a
            ><a class="trnh-thng-bnh2">Trịnh Thăng Bình </a>
          </div>
          <div class="div4">
            <img class="img-icon1" alt="" src="public/31200x6764-1@2x.png" /><a
              class="mooncake"
              ><p class="mooncake-p"><span>Mooncake</span></p></a
            ><a class="trnh-thng-bnh2">Trịnh Thăng Bình </a>
          </div>
          <div class="div5">
            <img class="img-icon1" alt="" src="public/31200x6764-1@2x.png" /><a
              class="mooncake"
              ><p class="mooncake-p"><span>Mooncake</span></p></a
            ><a class="trnh-thng-bnh2">Trịnh Thăng Bình </a>
          </div>
          <div class="div6">
            <img class="img-icon1" alt="" src="public/31200x6764-1@2x.png" /><a
              class="mooncake"
              ><p class="mooncake-p"><span>Mooncake</span></p></a
            ><a class="trnh-thng-bnh2">Trịnh Thăng Bình </a>
          </div>
          <div class="frame-div2">
            <div class="newest-div">Newest</div>
            <img
              class="icon-keyboard-arrow-down"
              alt=""
              src="public/-icon-keyboard-arrow-down.svg"
            />
          </div>
        </div>
      </div>
      <div class="header-div">
        <img class="px-1-icon" alt="" src="public/-800--250-px-1@2x.png" />
        <div class="frame-div3"><div class="home-div1">Home</div></div>
        <div class="community-div">Community</div>
        <div class="saved-div1">Saved</div>
        <div class="community-div">Shopping</div>
        <div class="search-div">
          <img class="rectangle-icon" alt="" src="public/rectangle-19.svg" />
          <div class="search-div1">Search</div>
          <img class="iconsearch1" alt="" src="public/iconsearch1.svg" />
        </div>
        <img class="icon-bell" alt="" src="public/-icon-bell.svg" />
        <div class="frame-div4">
          <img
            class="icon-keyboard-arrow-down1"
            alt=""
            src="public/-icon-keyboard-arrow-down1.svg"
          />
          <div class="bnh-div">Bình</div>
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

