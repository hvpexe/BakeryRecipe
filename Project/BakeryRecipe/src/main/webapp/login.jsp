
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="initial-scale=1, width=device-width" />
        <title></title>
        <meta name="description" content="" />

        <link rel="stylesheet" href="assets/css/login.css" />

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

    </head>
    <body>
        <section class="logindone-section" id="Login">
            <header class="header">
                
                <a class="header-logo" href="./home.html"></a>
                <nav class="header-links ">
                    <a class="header-link active" href="./home.jsp">Home</a
                    ><a class="header-link" href="./community.jsp">Community</a
                    ><a class="header-link" href="./saved.jsp">Saved</a
                    ><a class="header-link" href="./shopping.jsp">Shopping</a>
                </nav>
                <div class="searchbar">
                    <div class="searchbar-div">
                        <img
                            class="searchbar-icon"
                            alt=""
                            src="assets/public/searchbaricon.svg"
                            /><input
                            class="searchbar-input"
                            type="text"
                            placeholder="Search"
                            name="searchbar"
                            />
                    </div>
                </div>
                <div class="group-div">
                    <a class="header-button"><div class="sign-up-div">Sign up</div></a
                    ><a class="header-button1"><div class="log-in-div">Log in</div></a>
                </div>
            </header>
            <div class="section-div">
                <form class="register-form" action="home" id="register">
                    <div class="join-bakeryrecipe-div">Join BakeryRecipe!</div>
                    <div class="joining-bakeryrecipe-is-quick">
                        JOINING BAKERYRECIPE IS QUICK, EASY, AND FREE.
                    </div>
                    <input class="email-input" type="text" placeholder="Email" required />
                    <div class="name-div">
                        <input
                            class="firstname-input"
                            type="text"
                            placeholder="First name"
                            required
                            /><input
                            class="firstname-input"
                            type="text"
                            placeholder="Last name"
                            />
                    </div>
                    <input
                        class="email-input"
                        type="password"
                        placeholder="Password"
                        required
                        /><input
                        class="email-input"
                        type="password"
                        placeholder="Re -enter passzword"
                        required
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
                        /><input
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
                        <div class="google">G</div>
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

