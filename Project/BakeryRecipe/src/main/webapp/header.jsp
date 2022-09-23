<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="assets/css/header.css">
<header class="header-container container-fluid px-0">
    <header class="header px-0 m-0">
        <div class="header-left col-sm-12 col-md-6 p-0">
            <a class="header-logo col-md-3 p-0 pt-4 pt-md-0" href="./home.html">
                <img class="w-100 " src="assets/public/800250px1@2x.png" alt="">
            </a>
            <nav class="header-links col-md col p-0 ">
                <a class="header-link col p-md-0 p-2 border-0 active" href="./home.jsp">Home</a>
                <a class="header-link col p-md-0 p-2 border-0" href="./community.jsp">Community</a>
                <a class="header-link col p-md-0 p-2 border-0" href="./saved.jsp">Saved</a>
                <a class="header-link col p-md-0 p-2 border-0" href="./shopping.jsp">Shopping</a>
            </nav>
        </div>
        <div class="header-right flex-md-nowrap col-sm-12 col-md px-2 justify-content-md-center">
            <div class="searchbar col-md col px-3 px-md-0">
                <div class="searchbar-div col">
                    <img class="searchbar-icon " alt="" src="assets/public/searchbaricon.svg">
                    <input class="searchbar-input col p-0" type="text" placeholder="Search" name="searchbar">
                </div>
            </div>
            <c:if test="${user==null}">
                <div class="group-div col-md col-12 d-flex p-0 py-2 justify-content-around">
                    <a class="header-button col-5 btn active" data-type="register">
                        <div class="col p-0">Login</div>
                    </a>
                    <a class="header-button col-5 btn " data-type="login">
                        <div class="col p-0">Signup</div>
                    </a>
                </div>
            </c:if>
        </div>
    </header>
    <script src="assets/js/header.js"></script>
</header>