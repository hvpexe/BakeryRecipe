<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="assets/css/header.css">
<link href="assets/css/fontawesome-free-6.1.1-web/css/all.min.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="assets/css/web/bootstrap-4.3.1.min.css"/>
<header class="header-container header py-2 py-md-0">
    <div class="header-left col-sm-12 col-md-6 p-0">
        <a class="header-logo col-md-3 p-0" href="./home.jsp">
            <img class="mx-auto" src="assets/images/logo/logo2.png" alt="">
        </a>
        <nav class="header-links col-md col p-0 ">
            <a class="header-link col p-md-0 p-2 border-0 active" href="./home.jsp">Home</a>
            <a class="header-link col p-md-0 p-2 border-0" href="./community.jsp">Community</a>
            <a class="header-link col p-md-0 p-2 border-0" href="./saved.jsp">Saved</a>
            <a class="header-link col p-md-0 p-2 border-0" href="./shopping.jsp">Shopping</a>
        </nav>
    </div>
    <div class="header-right col-sm-12 col-md px-2 justify-content-md-center">
        <div class="searchbar col-md col px-3 px-md-0">
            <i class="searchbar-icon fa-solid fa-magnifying-glass"></i>
            <input class="searchbar-input col p-0" type="text" placeholder="Search" name="searchbar">
        </div>
        <i class="header-notification fa-solid fa-bell"></i>
        <c:if test="${login == null}">
            <a href="login.jsp" class="header-button" data-type="register">
                <div class="header-button-detail p-0">Sign up / Sign in</div>
            </a>
        </c:if>
        <c:if test="${login != null}">
            <a href="profile.jsp" class="header-button">
                <div class="header-button-detail p-0">${login.firstName}</div>
            </a>
        </c:if>
    </div>
</header>