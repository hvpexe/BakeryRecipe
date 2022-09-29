<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="initial-scale=1, width=device-width" />
        <title>HomePage</title>
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
                <link rel="stylesheet" href="assets/css/homePage.css" />

    </head>
    <body>
        <c:import url="header.jsp"/>
        <div class="home-div">
            <div class="post-section-div">
                <div class="posting-section-div">
                    <img class="avatar-icon" alt="" src=${sessionScope.login.avatar} /><button
                        class="btn-button"
                        id="btnButton"
                        >
                        <div class="add-your-post">Add your post</div>
                        <div class="div">+</div>
                    </button>
                </div>
                <div class="post-div">
                    <div class="user-info-div">
                        <button class="iconoptions-button">
                            <img class="shape-icon" alt="" src="assets/public/shape.svg" />
                        </button>
                        <div class="profile-name-div">
                            <a class="trnh-thng-bnh" href="./profile.html">Trịnh Thăng Bình</a
                            ><a class="h-a" href="./cook-detaildone.html">1h</a>
                        </div>
                        <img
                            class="avatar-icon1"
                            alt=""
                            src="assets/public/ellipse-9@2x.png"
                            id="avatarIcon1"
                            />
                    </div>
                    <div class="user-post-div">
                        <img class="image-icon" alt="" src="assets/public/image@2x.png" />
                        <div class="detail-div">
                            Added courgette and green beans, served with brown rice. Also
                            added a spoonful of rice vinegar to the sauce as suggested by
                            others. Really good!! Will definitely have again.
                        </div>
                    </div>

                    <div class="viewer-option-div">
                        <a class="save" href="./cook-detaildone.html"
                           ><img class="vector-icon" alt="" src="assets/public/vector.svg" /><b
                                class="save-b"
                                >Save</b
                            ></a
                        ><a class="view-a" href="./cook-detaildone.html"
                            ><img class="icon-eye" alt="" src="assets/public/-icon-eye.svg" /><b
                                class="save-b"
                                >View</b
                            ></a
                        >
                    </div>
                </div>
                <div class="post-div">
                    <div class="user-info-div">
                        <button class="iconoptions-button">
                            <img class="shape-icon" alt="" src="assets/public/shape.svg" />
                        </button>
                        <div class="profile-name-div">
                            <a class="trnh-thng-bnh" href="./profile.html">Trịnh Thăng Bình</a
                            ><a class="h-a" href="./cook-detaildone.html">1h</a>
                        </div>
                        <img
                            class="avatar-icon1"
                            alt=""
                            src="assets/public/ellipse-9@2x.png"
                            id="avatarIcon2"
                            />
                    </div>
                    <div class="user-post-div">
                        <img class="image-icon" alt="" src="assets/public/image@2x.png" />
                        <div class="detail-div">
                            Added courgette and green beans, served with brown rice. Also
                            added a spoonful of rice vinegar to the sauce as suggested by
                            others. Really good!! Will definitely have again.
                        </div>
                    </div>
                    <div class="viewer-option-div">
                        <a class="save" href="./cook-detaildone.html"
                           ><img class="vector-icon" alt="" src="assets/public/vector.svg" /><b
                                class="save-b"
                                >Save</b
                            ></a
                        ><a class="view-a1" href="./cook-detaildone.html"
                            ><img class="icon-eye" alt="" src="assets/public/-icon-eye.svg" /><b
                                class="save-b"
                                >View</b
                            ></a
                        >
                    </div>
                </div>
            </div>
            <div class="frame-div">
                <div class="banner-div">
                    <div class="rectangle-div"></div>
                    <img class="group-icon" alt="" src="assets/public/group-36.svg" />
                    <div class="chipchip-icon-div">
                        <div class="miscchip-icon-div">
                            <div class="rectangle-div1"></div>
                            <div class="label-div">Start Now</div>
                            <img
                                class="iconarrow-right"
                                alt=""
                                src="assets/public/iconarrowright.svg"
                                />
                        </div>
                    </div>
                    <div class="try-premium-membersh">
                        Make a cake with ingredient you haved
                    </div>
                    <div class="title-div">Make Cake without prepare!</div>
                </div>
                <div class="who-to-follow">
                    <div class="see-more-div">
                        <div class="label-div1">See more</div>
                        <img class="iconcheckbox-empty" alt="" />
                    </div>
                    <div class="user02-div">
                        <div class="user01-div">
                            <img class="button-icon" alt="" src="assets/public/button.svg" />
                            <div class="name-div">
                                <div class="subtitle-div">Los Angeles, CA</div>
                                <div class="username-div">Margie Jutten</div>
                            </div>
                            <img
                                class="avatarimage-icon"
                                alt=""
                                src="assets/public/avatarimage@2x.png"
                                />
                        </div>
                    </div>
                    <div class="user02-div2">
                        <div class="user01-div">
                            <img class="button-icon" alt="" src="assets/public/button1.svg" />
                            <div class="name-div1">
                                <div class="subtitle-div">Los Angeles, CA</div>
                                <div class="username-div">Gunther Ackner</div>
                            </div>
                            <img
                                class="avatarimage-icon"
                                alt=""
                                src="assets/public/avatarimage1@2x.png"
                                />
                        </div>
                    </div>
                    <button class="frame-button">
                        <div class="follow-div">Follow</div>
                    </button>
                    <div class="user02-div4">
                        <div class="user01-div">
                            <img class="button-icon" alt="" src="assets/public/button2.svg" />
                            <div class="name-div2">
                                <a class="subtitle-a" href="./profile.html">Los Angeles, CA</a
                                ><a class="username" href="./profile.html">Cammy Hedling</a>
                            </div>
                            <img
                                class="avatarimage-icon"
                                alt=""
                                src="assets/public/avatarimage2@2x.png"
                                />
                        </div>
                    </div>
                    <button class="frame-button1">
                        <div class="follow-div">Follow</div></button
                    ><b class="title-b">Good Cook</b
                    ><button class="frame-button2">
                        <div class="follow-div">Follow</div>
                    </button>
                </div>
                <div class="who-to-follow1">
                    <div class="user02-div6">
                        <div class="user01-div">
                            <img class="button-icon3" alt="" src="assets/public/button3.svg" />
                            <div class="username-div2">Cake 33</div>
                            <div class="avatarimage-div">
                                <img class="avatar-icon3" alt="" src="assets/public/avatar1@2x.png" />
                            </div>
                        </div>
                    </div>
                    <div class="user02-div7">
                        <div class="user01-div">
                            <img class="button-icon3" alt="" src="assets/public/button4.svg" />
                            <div class="username-div3">Cake 2</div>
                            <div class="avatarimage-div1">
                                <img class="avatar-icon3" alt="" src="assets/public/avatar2@2x.png" />
                            </div>
                        </div>
                    </div>
                    <div class="user02-div8">
                        <div class="user01-div">
                            <img class="button-icon3" alt="" src="assets/public/button5.svg" />
                            <div class="username-div3">Cake 11</div>
                            <div class="avatarimage-div2">
                                <img class="avatar-icon3" alt="" src="assets/public/avatar3@2x.png" />
                            </div>
                        </div>
                    </div>
                    <b class="title-b">Trend Cakes</b>
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

