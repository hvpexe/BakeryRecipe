
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="initial-scale=1, width=device-width" />
        <title></title>
        <meta name="description" content="" />


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
        <!--<link href="assets/css/bootstrap-4.3.1.min.css" rel="stylesheet" type="text/css"/>-->
        <link rel="stylesheet" href="assets/css/login.css" />

    </head>
    <body>
        <section class="logindone-section " id="Login">
            <header class="header row">
                <div class="header-left col-sm-12 col-md-6 p-0">
                    <a class="header-logo col-md-3 p-0 pt-4 pt-md-0" href="./home.html">
                        <img class="w-100 " src="assets/public/800250px1@2x.png" alt=""/>
                    </a>
                    <nav class="header-links col-md-8 col p-0">
                        <a class="header-link  col-md col-12 p-md-0 p-2 border-0 active" href="./home.jsp">Home</a>
                        <a class="header-link  col-md col-12 p-md-0 p-2 border-0" href="./community.jsp">Community</a>
                        <a class="header-link  col-md col-12 p-md-0 p-2 border-0" href="./saved.jsp">Saved</a>
                        <a class="header-link  col-md col-12 p-md-0 p-2 border-0" href="./shopping.jsp">Shopping</a>
                    </nav>
                </div>
                <div class="header-right col-sm-12 col-md-6">
                    <div class="searchbar col-md-7 col">
                        <div class="searchbar-div col-12">
                            <img
                                class="searchbar-icon "
                                alt=""
                                src="assets/public/searchbaricon.svg"
                                /><input
                                class="searchbar-input col p-0"
                                type="text"
                                placeholder="Search"
                                name="searchbar"
                                />
                        </div>
                    </div>
                    <div class="group-div col-md col-12 d-flex p-0 justify-content-around">
                        <a class="header-button1  col-5"><div class="log-in-div col">Log in</div></a>
                        <a class="header-button   col-5"><div class="sign-up-div">Sign up</div></a>
                    </div>
                </div>

            </header>
            <div class="section-div d-none">
                <form class="register-form" action="home" id="register">
                    <div class="join-bakeryrecipe-div">Join BakeryRecipe!</div>
                    <div class="joining-bakeryrecipe-is-quick">
                        JOINING BAKERYRECIPE IS QUICK, EASY, AND FREE.
                    </div>
                    <input class="email-input" type="text" placeholder="Email" required name="email" />
                    <div class="name-div">
                        <input
                            class="firstname-input"
                            type="text"
                            placeholder="First name"
                            required
                            name="firstname"
                            /><input
                            class="firstname-input"
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
                    <button class="submit-button1" type="submit" id="submitButton1">
                        <b class="login-b">LOGIN</b></button
                    >
                    <img class="image-14-icon" alt="" src="assets/public/image-14@2x.png" />
                    <div class="login-with-api">
                        <div class="google">
                            <img src="assets/public/Google.png" alt=""/>
                        </div>
                    </div>
                </form>
            </div>

        </section>

        <script>
            var submitButton = document.getElementById("submitButton");
            if (submitButton) {
                submitButton.addEventListener("click", function (e) {
                    window.location.href = "./home.html";
                });
            }

            var submitButton1 = document.getElementById("submitButton1");
            if (submitButton1) {
                submitButton1.addEventListener("click", function (e) {
                    window.location.href = "./home.html";
                });
            }
        </script>
    </body>
</html>

