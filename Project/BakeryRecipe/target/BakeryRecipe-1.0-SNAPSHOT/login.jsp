
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="initial-scale=1, width=device-width" />
        <title></title>
        <meta name="description" content="hello" />

        <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css2?family=Gelasio:wght@400;500;700&display=swap"
            />
        <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css2?family=Inter:wght@400;700&display=swap"
            />
        <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css2?family=Abel:wght@400&display=swap"
            />
        <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css2?family=Beau Rivage:wght@400&display=swap"
            />
        <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css2?family=Arima Madurai:wght@800&display=swap"
            />
        <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css2?family=Abhaya Libre:wght@700&display=swap"
            />
        <link href="assets/css/fontawesome-free-6.1.1-web/css/all.min.css" rel="stylesheet" type="text/css"/>
        <script src="https://apis.google.com/js/platform.js" async defer></script>
        <meta name="google-signin-client_id" content="243057477675-ti2g5mjdpfrnq5vsgqgdtj3ph3j4ert6">
        <!--<link href="assets/css/bootstrap-4.3.1.min.css" rel="stylesheet" type="text/css"/>-->
        <link rel="stylesheet" href="assets/css/login.css" />
    </head>
    <body>
        <section class="logindone-section " id="Login">
            <jsp:include page="header.jsp"/>
            <div class="section-div ">
                <form class="register-form" action="home" id="register">
                    <div class="join-bakeryrecipe-div">Join BakeryRecipe!</div>
                    <div class="joining-bakeryrecipe-is-quick">
                        JOINING BAKERYRECIPE IS QUICK, EASY, AND FREE.
                    </div>
                    <input class="email-input " type="text" placeholder="Email" required name="email" />
                    <div class="name-div row">
                        <input
                            class="firstname-input col"
                            type="text"
                            placeholder="First name"
                            required
                            name="firstname"
                            /><input
                            class="firstname-input col"
                            type="text"
                            placeholder="Last name"
                            required
                            name="lastname"
                            />
                    </div>
                    <input
                        class="email-input"
                        type="password"
                        placeholder="Password"
                        required name="password"
                        /><input
                        class="email-input"
                        type="password"
                        placeholder="Re-enter password"
                        required name="re-password"
                        /><button class="submit-button" type="submit" id="submitButton">
                        <b class="join-b">JOIN</b>
                    </button>
                </form>

                <div class="line-div"></div>

                <form class="login-form" action="Home" method="post" id="login">
                    <div class="join-bakeryrecipe-div">Already A Member? Sign-In</div>
                    <div class="joining-bakeryrecipe-is-quick">WELCOME BACK</div>
                    <input
                        class="email-input1"
                        type="text"
                        placeholder="Email"
                        required
                        name="email"
                        />
                    <input
                        class="password-input1"
                        type="password"
                        placeholder="Password"
                        required
                        name="password"
                        />
                    <div class="joining-bakeryrecipe-is-quick">Forgot your password?</div>
                    <button class="submit-button" type="submit" id="submitButton1">
                        <b class="login-b">LOGIN</b></button>
                    <img class="image-14-icon" alt="" src="assets/public/image-14@2x.png" />
                    <div class="login-with-api">
                        <div class="google">
                            <img src="assets/public/Google.png" alt=""/>
                        </div>
                    </div>
                    <!--<div class="g-signin2" data-onsuccess="onSignIn" data-theme="dark"></div>-->
                    <script src="https://accounts.google.com/gsi/client" async defer></script>
                    <div id="g_id_onload"
                         data-client_id="243057477675-ti2g5mjdpfrnq5vsgqgdtj3ph3j4ert6"
                         data-context="signin"
                         data-ux_mode="popup"
                         data-login_uri="http://localhost:8080/BakeryRecipe/login.jsp"
                         data-auto_select="true"
                         data-itp_support="true">
                    </div>

                    <div class="g_id_signin"
                         data-type="icon"
                         data-shape="circle"
                         data-theme="filled_black"
                         data-text="signup_with"
                         data-size="large">
                    </div>
                    Code copied!
                </form>
            </div>

        </section>
        <script src="login.js"></script>
    </body>
</html>

