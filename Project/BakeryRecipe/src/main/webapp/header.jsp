<script src="assets/js/Jquery/jquery-core.js" async defer></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="assets/css/header.css">
<link href="assets/css/fontawesome-free-6.1.1-web/css/all.min.css" rel="stylesheet" type="text/css"/>
<header class="header-container header position-sticky py-2 py-md-0 ">
    <div class="header-left align-items-center col-sm-12 col-md-6 p-0">
        <a class="header-logo col-md-3 p-0" href="./home.jsp">
            <img class="mx-auto" src="assets/images/logo/logo2.png" alt="">
        </a>
        <nav class="header-links justify-content-around col-md col p-0 ">
            <a class="header-link p-md-0 p-2 border-0 active" href="./home.jsp">Home</a>
            <a class="header-link  p-md-0 p-2 border-0" href="./Top8MostRecipe">Community</a>
            <a class="header-link  p-md-0 p-2 border-0" href="./saved.jsp">Saved</a>
            <a class="header-link  p-md-0 p-2 border-0" href="./shopping.jsp">Shopping</a>
        </nav>
    </div>
    <div class="header-right align-items-center flex-md-nowrap col-sm-12 col-md px-2 justify-content-md-center">
        <div class="col-12 col-sm d-flex align-items-center">
            <div class="searchbar col-md col-11 px-3 px-md-0">
                <i class="searchbar-icon fa-solid fa-magnifying-glass"></i>
                <input class="searchbar-input col p-0" type="text" placeholder="Search" name="searchbar">
            </div>
            <div class="col-1 p-0 d-flex align-items-center justify-content-center">
                <i class="header-notification fa-solid fa-bell"></i>
            </div>
        </div>
        <c:set var="login" value="${LOGIN_USER}" scope="session"></c:set>
        <c:if test="${login == null}">
            <a href="login.jsp" class="header-user" data-type="register">
                <div class="header-button-detail p-0">Sign up / Sign in</div>
            </a>
        </c:if>
        <c:if test="${login != null}">
            <div class="header-user position-relative ml-auto">
                <a href="profile.jsp" class="header-user-button position-relative">
                    <div class="header-button-detail p-0 pr-5">
                        ${login.firstName}   
                        <img id="user_avatar" class=" d-inline m-auto rounded-circle position-absolute" src="${login.avatar}"/>
                    </div>
                </a>
                <div class="header-user_content  position-absolute">
                    <div class="list-group flex-column justify-content-start" href="#" >
                        <a class="list-group-item text-dark text-decoration-none nav-item" href="./profile.jsp"><div>Profile</div></a>
                        <a class="list-group-item text-dark text-decoration-none nav-item" href="#"><div>Setting</div></a>
                        <a class="list-group-item text-dark text-decoration-none nav-item" href="logout"><div> Logout</div></a>
                    </div>
                </div>
            </div>
        </c:if>
    </div>
</header>

<script src="assets/js/header.js"></script>