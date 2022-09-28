<%-- 
    Document   : resHomePage
    Created on : Sep 23, 2022, 7:31:56 AM
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

    <link rel="stylesheet" href="assets/css/resHomePage.css" />

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
    <div class="iphone-13-pro-max-2">
      <div class="post-section-div1">
        <div class="posting-section-div1">
          <img class="avatar-icon6" alt="" src="public/avatar@2x.png" /><button
            class="btn-button1"
            id="btnButton"
          >
            <div class="add-your-post1">Add your post</div>
            <div class="div1">+</div>
          </button>
        </div>
        <div class="user_post">
          <div class="user-info-div2">
            <button class="iconoptions-button2">
              <img class="shape-icon2" alt="" src="public/shape2.svg" />
            </button>
            <div class="profile-name-div2">
              <a class="trnh-thng-bnh2" href="./profile.html"
                >Trịnh Thăng Bình</a
              ><a class="h-a2" href="./cook-detaildone.html">1h</a>
            </div>
            <img
              class="avatar-icon7"
              alt=""
              src="public/avatar@2x.png"
              id="avatarIcon1"
            />
          </div>
          <div class="user-post-div2">
            <img class="image-icon2" alt="" src="public/image@2x.png" />
            <div class="detail-div2">
              Added courgette and green beans, served with brown rice. Also
              added a spoonful of rice vinegar to the sauce as suggested by
              others. Really good!! Will definitely have again.
            </div>
          </div>
          <div class="viewer-option-div2">
            <a class="save2" href="./cook-detaildone.html"
              ><img class="vector-icon2" alt="" src="public/vector2.svg" /><b
                class="save-b2"
                >Save</b
              ></a
            ><a class="view-a2" href="./cook-detaildone.html"
              ><img class="icon-eye2" alt="" src="public/-icon-eye.svg" /><b
                class="save-b2"
                >View</b
              ></a
            >
          </div>
        </div>
        <div class="user_post">
          <div class="user-info-div2">
            <button class="iconoptions-button2">
              <img class="shape-icon2" alt="" src="public/shape2.svg" />
            </button>
            <div class="profile-name-div2">
              <a class="trnh-thng-bnh2" href="./profile.html"
                >Trịnh Thăng Bình</a
              ><a class="h-a2" href="./cook-detaildone.html">1h</a>
            </div>
            <img
              class="avatar-icon7"
              alt=""
              src="public/avatar@2x.png"
              id="avatarIcon2"
            />
          </div>
          <div class="user-post-div2">
            <img class="image-icon2" alt="" src="public/image@2x.png" />
            <div class="detail-div2">
              Added courgette and green beans, served with brown rice. Also
              added a spoonful of rice vinegar to the sauce as suggested by
              others. Really good!! Will definitely have again.
            </div>
          </div>
          <div class="viewer-option-div2">
            <a class="save2" href="./cook-detaildone.html"
              ><img class="vector-icon2" alt="" src="public/vector2.svg" /><b
                class="save-b2"
                >Save</b
              ></a
            ><a class="view-a2" href="./cook-detaildone.html"
              ><img class="icon-eye2" alt="" src="public/-icon-eye.svg" /><b
                class="save-b2"
                >View</b
              ></a
            >
          </div>
        </div>
      </div>
    </div>

    <script>
      var btnButton = document.getElementById("btnButton");
      if (btnButton) {
        btnButton.addEventListener("click", function (e) {
          window.location.href = "./add-recipedone.html";
        });
      }
      
      var avatarIcon1 = document.getElementById("avatarIcon1");
      if (avatarIcon1) {
        avatarIcon1.addEventListener("click", function (e) {
          window.location.href = "./profile.html";
        });
      }
      
      var avatarIcon2 = document.getElementById("avatarIcon2");
      if (avatarIcon2) {
        avatarIcon2.addEventListener("click", function (e) {
          window.location.href = "./profile.html";
        });
      }
      </script>
  </body>
</html>

