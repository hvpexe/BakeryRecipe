<%@page import="stackjava.com.accessgoogle.common.Constants"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>

        <meta charset="utf-8" />
        <meta name="viewport" content="initial-scale=1, width=device-width" />
        <title>Welcome to Bakery Recipe</title>
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
        <!--<script src="https://apis.google.com/js/platform.js" async defer></script>-->
        <!--<meta name="google-signin-client_id" content="243057477675-ti2g5mjdpfrnq5vsgqgdtj3ph3j4ert6">-->
        <!--<link href="assets/css/bootstrap-4.3.1.min.css" rel="stylesheet" type="text/css"/>-->
        <script src="assets/js/Jquery/jquery-core.js" ></script>
        <script src="https://accounts.google.com/gsi/client" async defer></script>
        <script>
            window.onGoogleLibraryLoad = () => {
                google.accounts.id.initialize({
                    client_id: '243057477675-kt58mr9lav8eh6ti9bfrj8p782j7unkd.apps.googleusercontent.com',
                    cancel_on_tap_outside: false,
                    prompt_parent_id: "root"
                });
                google.accounts.id.prompt((notification) => {
                    if (notification.isNotDisplayed()) {
                        console.log(notification.getNotDisplayedReason());
                    }
                });
            }
        </script>
        <link rel="stylesheet" href="assets/css/login.css" />

    </head>
    <body>
        <c:import url="header.jsp"/>
        <section class="logindone-section " id="Login">
            <div class="section-div flex-wrap flex-lg-nowrap">

                <form class="register-form col-lg mx-auto d-none d-lg-flex" action="register" id="register" method="POST">
                    <div class="join-bakeryrecipe-div col-10">Join BakeryRecipe!</div>
                    <div class="joining-bakeryrecipe-is-quick col-10">
                        JOINING BAKERYRECIPE IS QUICK, EASY, AND FREE.
                    </div>
                    <a class="google d-lg-none" href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8080/BakeryRecipe/login-google&response_type=code&client_id=243057477675-kt58mr9lav8eh6ti9bfrj8p782j7unkd.apps.googleusercontent.com&approval_prompt=force">
                        <img src="assets/public/Google.png" alt=""/>
                    </a>   
                    <input class="email-input col-10" type="email" placeholder="Email" required="" name="email">
                    <div class="name-div row col-10 p-0">
                        <input class="firstname-input col" type="text" placeholder="First name" required="" name="firstname"><input class="firstname-input col" type="text" placeholder="Last name" required="" name="lastname">
                    </div>
                    <input class="email-input col-10" type="password" placeholder="Password" required="" name="password">
                    <input class="email-input col-10" type="password" placeholder="Re-enter password" required="" name="re-password">
                    <div>${REGISTER_ERROR}</div>
                    <button class="submit-button col-10" type="submit" form="register">
                        <b class="join-b">JOIN</b>
                    </button>
                </form>

                <div class="line-div mx-auto d-none d-lg-block"></div>
                <form class="login-form col-lg mx-auto d-lg-flex" action="login" method="post" id="login">
                    <div class="join-bakeryrecipe-div col-10">Already A Member? Sign-In</div>
                    <div class="joining-bakeryrecipe-is-quick col-10">WELCOME BACK</div>
                    <a class="google" href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8080/BakeryRecipe/login-google&response_type=code&client_id=243057477675-kt58mr9lav8eh6ti9bfrj8p782j7unkd.apps.googleusercontent.com&approval_prompt=force">
                        <img src="assets/public/Google.png" alt=""/>
                    </a>   

                    <input class="email-input1 col-10" type="text" placeholder="Email" required="" name="email">
                    <input class="password-input1 col-10" type="password" placeholder="Password" required="" name="password">
                    <div>${LOGIN_ERROR}</div>
                    <div class="joining-bakeryrecipe-is-quick col-10">Forgot your password?</div>
                    <button class="submit-button col-10" type="submit" form="login">
                        <b class="login-b">LOGIN</b>
                    </button>
                    <div class="sign-up-button d-md-none col-10">
                        <b class="login-b">Don't have account? Sign up</b>
                    </div>
                </form>

            </div>

        </section>
        <c:import url="footer.jsp"/>

        <script src="assets/js/login.js" type="text/javascript"></script>
    </body>
</html>

