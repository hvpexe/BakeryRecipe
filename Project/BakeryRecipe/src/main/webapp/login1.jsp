<%-- 
    Document   : login1
    Created on : Oct 3, 2022, 8:36:01 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta charset="utf-8" />
        <meta name="viewport" content="initial-scale=1, width=device-width" />
        <meta name="description" content="" />
        <link rel="icon" href="./assets/images/logo/logo1.png" type="image/x-icon">

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
        <script src="assets/js/Jquery/jquery-core.js" 
        crossorigin="anonymous"></script>
        <!--<script
                    src="https://code.jquery.com/jquery-3.6.1.min.js"
                    integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
                crossorigin="anonymous"></script>-->
        <script src="https://accounts.google.com/gsi/client" async defer></script>
        <script src="assets/js/googleLogin.js"></script>
        <link rel="stylesheet" href="assets/css/login1.css" />
    </head>
    <body>
        <c:import url="header.jsp"/>
        <section class="section container-fluid row px-0 m-0">
            <aside class="col-12  col-sm-9 col-lg-5 mx-auto px-3" id="form-object">
                <form class="login-form mx-1 rounded flex-column align-items-center" 
                      id="formLogin" action="login" method="post">
                    <div class="invitation-text col-10">WELCOME BACK<br> to <br>Bakery Recipe </div>
                    <div class="d-none" id="g_id_onload" data-client_id="243057477675-kt58mr9lav8eh6ti9bfrj8p782j7unkd.apps.googleusercontent.com" data-login_uri="BakeryRecipe/home.jsp" data-callback="handleCredentialResponse">
                    </div>
                    <div class="g_id_signin" data-type="icon" data-size="large" placeholder="Email" data-theme="filled_blue" data-text="sign_in_with" data-shape="circle" data-logo_alignment="left"><div class="S9gUrf-YoZ4jf" style="position: relative;"><div></div><iframe src="https://accounts.google.com/gsi/button?type=icon&amp;size=large&amp;theme=filled_blue&amp;text=sign_in_with&amp;shape=circle&amp;logo_alignment=left&amp;client_id=243057477675-kt58mr9lav8eh6ti9bfrj8p782j7unkd.apps.googleusercontent.com&amp;iframe_id=gsi_812950_790204&amp;as=MCsvGUZ%2Fo6jE5lvjeZjhzQ" id="gsi_812950_790204" title="Sign in with Google Button" style="display: block; position: relative; top: 0px; left: 0px; height: 44px; width: 64px; border: 0px; margin: -2px -12px;"></iframe></div></div>
                    <div class="input col-10 p-0" placeholder="Email">
                        <input class="email-input1 col rounded" type="text" placeholder="   " form="formLogin"
                               name="email"  >
                        <span class="status"></span> 
                    </div>
                    <div class="input col-10 p-0" placeholder="Password" regex="">
                        <input class="password-input1 col rounded" type="password" placeholder="   "form="formLogin" 
                               name="password" >
                        <span class="status"></span> 
                    </div>
                    <input class="submit-button col-10" value="LOGIN" type="submit" form="formLogin">

                    <div class="forgot-pass col-10 text-center">Forgot your password?</div>
                    <div class="text-danger"></div>
                    <hr width="100%"/>
                    <div class="change-form">Sign Up</div>
                </form>
                <form class="register-form d-none mx-1 rounded flex-column align-items-center " action="register" id="formRegister" method="POST">
                    <div class="invitation-text col-10">
                        Join BakeryRecipe! 
                        <br>
                        JOINING BAKERYRECIPE IS QUICK, EASY, AND FREE.
                    </div>
                    <div class="g_id_signin"
                         data-type="icon"
                         data-size="large"
                         data-theme="filled_blue"
                         data-text="sign_in_with"
                         data-shape="circle"
                         data-logo_alignment="center">
                    </div>
                    <div class="input col-10 p-0" placeholder="Email">
                        <input class="email-input1 col rounded" type="text" placeholder="   " form="formRegister"
                               name="email"  >
                        <span class="status"></span> 
                    </div>
                    <div class=" col-10 row justify-content-between bg-white p-0">
                        <div class="input col p-0 mr-2" placeholder="First name">
                            <input class="rounded col" type="text" placeholder="  " name="firstname">
                            <span class="status"></span> 
                        </div>
                        <div class="input col p-0 ml-2" placeholder="Last name">
                            <input class="rounded col" type="text" placeholder="  "  name="lastname">
                            <span class="status"></span> 
                        </div>
                    </div>
                    <div class="input col-10 p-0" placeholder="Password">
                        <input class="col rounded" type="password" placeholder=" "  name="password">
                        <span class="status"></span> 
                    </div>
                    <div class="input col-10 p-0" placeholder="Re-enter password">
                        <input class="col rounded" type="password" placeholder=" "  name="re-password">
                        <span class="status"></span> 
                    </div>
                    <div>${REGISTER_ERROR}</div>
                    <button class="submit-button col-10" type="submit" form="formRegister">
                        <b class="join-b">JOIN</b>
                    </button>
                    <hr width="100%">
                    <div class="change-form">Sign In</div>

                </form>
            </aside>
            <aside class="col-7 d-none d-lg-flex">
            </aside>
        </section>
        <!--Google Login Dont Touch-->
        <form class="d-none" id="googleLogin" action="login" method="POST"></form>
        <script src="assets/js/validator.js"></script>
        <script>
            //expected
            Validator({
                form: '#formLogin',
                status: '.status',
                rules: [
                    Validator.isRequired('[name=email]'),
                    Validator.isEmail('[name=email]'),
                    Validator.isRequired('[name=password]'),
                    Validator.isPassword('[name=password]')
                ],
                onSubmit: (value) => {
                    //Call api here
                    console.log(value);
                }
            });
            Validator({
                form: '#formRegister',
                status: '.status',
                rules: [
                    Validator.isRequired('[name=email]'),
                    Validator.isEmail('[name=email]'),
                    Validator.isRequired('[name=firstname]'),
                    Validator.isRequired('[name=password]'),
                    Validator.isPassword('[name=password]'),
                    Validator.isRequired('[name=re-password]'),
                    Validator.isSameValue('[name=re-password]',
                            //this function return the value of re-password
                                    function () {
                                        return document.querySelector('#formRegister [name=password]').value;
                                    }
                            , "Passwords are not the same")
                        ],
                        onSubmit: (value) => {
                            //Call api here
                            console.log(value);
                        }
                    });
        </script>
        <script src="assets/js/login.js" type="text/javascript"></script>
    </body>

</html>
