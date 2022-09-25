
<%@page import="stackjava.com.accessgoogle.common.Constants"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>

        <meta charset="utf-8" />
        <meta name="viewport" content="initial-scale=1, width=device-width" />
        <title>Welcome to Bakery Recipe</title>
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
        <section class="logindone-section " id="Login">
            <jsp:include page="header.jsp"/>

            <div class="section-div flex-wrap flex-lg-nowrap">

                <form class="register-form col-lg mx-auto d-none d-lg-flex" action="register" id="register" method="POST">
                    <div class="join-bakeryrecipe-div col-10">Join BakeryRecipe!</div>
                    <div class="joining-bakeryrecipe-is-quick col-10">
                        JOINING BAKERYRECIPE IS QUICK, EASY, AND FREE.
                    </div>
                    <input class="email-input col-10" type="email" placeholder="Email" required="" name="email">
                    <div class="name-div row col-10 p-0">
                        <input class="firstname-input col" type="text" placeholder="First name" required="" name="firstname"><input class="firstname-input col" type="text" placeholder="Last name" required="" name="lastname">
                    </div>
                    <input class="email-input col-10" type="password" placeholder="Password" required="" name="password">
                    <input class="email-input col-10" type="password" placeholder="Re-enter password" required="" name="re-password">
                    <button class="submit-button col-10" type="submit" form="register">
                        <b class="join-b">JOIN</b>
                    </button>
                </form>

                <div class="line-div mx-auto d-none d-lg-block"></div>
                <form class="login-form col-lg mx-auto d-lg-flex" action="login" method="post" id="login">
                    <div class="join-bakeryrecipe-div col-10">Already A Member? Sign-In</div>
                    <div class="joining-bakeryrecipe-is-quick col-10">WELCOME BACK</div>
                    <input class="email-input1 col-10" type="text" placeholder="Email" required="" name="email">
                    <input class="password-input1 col-10" type="password" placeholder="Password" required="" name="password">
                    <div class="joining-bakeryrecipe-is-quick col-10">Forgot your password?</div>
                    <button class="submit-button col-10" type="submit" form="login">
                        <b class="login-b">LOGIN</b></button>
                    <!--                    <img class="image-14-icon" alt="" src="assets/public/image-14@2x.png" />
                                        <div class="login-with-api">
                                            <div class="google">
                                                <img src="assets/public/Google.png" alt=""/>
                                            </div>
                                        </div>-->
                    <!--<script src="https://accounts.google.com/gsi/client" async="" defer=""></script>-->
                    <div id="g_id_onload"
                         data-client_id="<%=Constants.GOOGLE_CLIENT_ID %>"
                         data-login_uri="<%=Constants.GOOGLE_REDIRECT_URI%>"
                         data-auto_prompt="false">
                    </div>
                    <div class="g_id_signin"
                         data-type="signin"
                         data-size="large"
                         data-theme="outline"
                         data-text="sign_in_with"
                         data-shape="circle"
                         data-logo_alignment="left">
                    </div>
                    <a href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8080/BakeryRecipe/login-google&response_type=code
                       &client_id=243057477675-kt58mr9lav8eh6ti9bfrj8p782j7unkd.apps.googleusercontent.com&approval_prompt=force">Login With Google</a>  
                    <c:catch var="e">
                        <div id="root">
                            ${user.email}
                            ${user.password}
                        </div>
                    </c:catch>
                    ${e}
                </form>
            </div>

        </section>
        <script type="module">
            window.OnG
            console.log(google);
            const client = google.accounts.oauth2.initCodeClient({
                client_id: '243057477675-kt58mr9lav8eh6ti9bfrj8p782j7unkd.apps.googleusercontent.com',
                scope: 'https://localhost:8080/BakeryRecipe/',
                ux_mode: 'popup',
                callback: (response) => {
                    const xhr = new XMLHttpRequest();
                    xhr.open('POST', code_receiver_uri, true);
                    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
                    // Set custom header for CRSF
                    xhr.setRequestHeader('X-Requested-With', 'XmlHttpRequest');
                    xhr.onload = function () {
                        console.log('Auth code response: ' + xhr.responseText);
                    };
                    xhr.send('code=' + code);
                },
            });
        </script>
        <script src="assets/js/login.js" type="text/javascript">

        </script>
    </body>
</html>

