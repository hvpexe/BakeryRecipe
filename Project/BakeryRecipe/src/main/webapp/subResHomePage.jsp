<%-- Document : subResHomePage Created on : Sep 23, 2022, 7:39:32 AM Author : VO MINH MAN --%>

    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="utf-8" />
            <meta name="viewport" content="initial-scale=1, width=device-width" />
            <title></title>
            <meta name="description" content="" />

            <link rel="stylesheet" href="assets/css/subResHomePage.css" />

            <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Inter:wght@400;700&display=swap" />
            <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Abhaya Libre:wght@700&display=swap" />
            <link rel="stylesheet"
                href="https://fonts.googleapis.com/css2?family=Gelasio:wght@400;500;700&display=swap" />
            <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Abel:wght@400&display=swap" />
            <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Beau Rivage:wght@400&display=swap" />
            <link rel="stylesheet"
                href="https://fonts.googleapis.com/css2?family=Arima Madurai:wght@800&display=swap" />
        </head>

        <body>
            <div class="iphone-13-pro-max-1">
                <div class="post-section-div">
                    <div class="posting-section-div">
                        <img class="avatar-icon" alt="" src="public/avatar@2x.png" /><button class="btn-button"
                            id="btnButton">
                            <div class="add-your-post">Add your post</div>
                            <div class="div">+</div>
                        </button>
                    </div>
                    <div class="post-div">
                        <div class="user-info-div">
                            <button class="iconoptions-button">
                                <img class="shape-icon" alt="" src="public/shape.svg" />
                            </button>
                            <div class="profile-name-div">
                                <a class="trnh-thng-bnh" href="./profile.html">Trịnh Thăng Bình</a><a class="h-a"
                                    href="./cook-detaildone.html">1h</a>
                            </div>
                            <img class="avatar-icon1" alt="" src="public/ellipse-9@2x.png" id="avatarIcon1" />
                        </div>
                        <div class="user-post-div">
                            <img class="image-icon" alt="" src="public/image@2x.png" />
                            <div class="detail-div">
                                Added courgette and green beans, served with brown rice. Also
                                added a spoonful of rice vinegar to the sauce as suggested by
                                others. Really good!! Will definitely have again.
                            </div>
                        </div>
                        <div class="viewer-option-div">
                            <a class="save" href="./cook-detaildone.html"><img class="vector-icon" alt=""
                                    src="public/vector.svg" /><b class="save-b">Save</b></a><a class="view-a"
                                href="./cook-detaildone.html"><img class="icon-eye" alt=""
                                    src="public/-icon-eye.svg" /><b class="save-b">View</b></a>
                        </div>
                    </div>
                    <div class="post-div">
                        <div class="user-info-div">
                            <button class="iconoptions-button">
                                <img class="shape-icon" alt="" src="public/shape.svg" />
                            </button>
                            <div class="profile-name-div">
                                <a class="trnh-thng-bnh" href="./profile.html">Trịnh Thăng Bình</a><a class="h-a"
                                    href="./cook-detaildone.html">1h</a>
                            </div>
                            <img class="avatar-icon1" alt="" src="public/ellipse-9@2x.png" id="avatarIcon2" />
                        </div>
                        <div class="user-post-div">
                            <img class="image-icon" alt="" src="public/image@2x.png" />
                            <div class="detail-div">
                                Added courgette and green beans, served with brown rice. Also
                                added a spoonful of rice vinegar to the sauce as suggested by
                                others. Really good!! Will definitely have again.
                            </div>
                        </div>
                        <div class="viewer-option-div">
                            <a class="save" href="./cook-detaildone.html"><img class="vector-icon" alt=""
                                    src="public/vector.svg" /><b class="save-b">Save</b></a><a class="view-a"
                                href="./cook-detaildone.html"><img class="icon-eye" alt=""
                                    src="public/-icon-eye.svg" /><b class="save-b">View</b></a>
                        </div>
                    </div>
                </div>
                <img class="rectangle-icon" alt="" src="public/rectangle-35.svg" />
                <div class="frame-div">
                    <div class="frame-div1">
                        <img class="icon-cart" alt="" src="public/-icon-cart.svg" /><b class="my-cart-b">My Cart</b>
                    </div>
                    <div class="frame-div2">
                        <img class="icon-person" alt="" src="public/-icon-person.svg" /><b
                            class="accounts-setting-b">Accounts
                            Setting</b>
                    </div>
                    <div class="frame-div3">
                        <img class="icon-account-login" alt="" src="public/-icon-account-login.svg" /><b
                            class="log-out-b">Log out</b>
                    </div>
                    <div class="frame-div4">
                        <img class="icon-bookmark" alt="" src="public/-icon-bookmark.svg" /><b class="save-b2">Save</b>
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