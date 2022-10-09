<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="assets/css/header.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Gelasio:wght@400;500;700&display=swap"/>
<link href="assets/css/fontawesome-free-6.1.1-web/css/all.min.css" rel="stylesheet" type="text/css"/>
<header class="header-container header py-2 py-md-0 ">
    <div class="header-left align-items-center col-sm-12 col-md-6 p-0">
        <a class="header-logo navbar-brand col-md-3 p-0" href="./home">
            <img class="mx-auto" src="assets/images/logo/logo2.png" alt="">
        </a>
        <nav class="header-links justify-content-around col-md col p-0 ">
            <a class="header-link p-0 border-0 active" href="./home">Home</a>
            <a class="header-link p-0 border-0" href="./community">Community</a>
            <a class="header-link p-0 border-0" href="./saved.jsp">Saved</a>
            <a class="header-link p-0 border-0" href="./shopping.jsp">Shopping</a>
        </nav>
    </div>
    <div class="header-right align-items-center flex-md-nowrap col-sm-12 col-md px-2 justify-content-md-center">
        <div class="col-sm d-flex align-items-center">
            <form action="Search"> 
                <div class="searchbar px-3 px-md-0">
                    <i class="searchbar-icon fa-solid fa-magnifying-glass"></i>
                    <input class="searchbar-input col p-0" type="text" placeholder="Search" name="searchKey" value="" size="40">
                    <input type="hidden" name="action" value="Recipe">
                </div>
            </form> 
            <div class="p-0 d-flex align-items-center justify-content-center">
                <i class="header-notification fa-solid fa-bell"></i>
            </div>
            <c:set var="login" value="${login}" scope="session"></c:set>
            <c:if test="${login == null}">
                <a href="login.jsp" class="header-user ml-auto" data-type="register">
                    Sign up / Sign in
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
    </div>
</header>

<script src="assets/js/header.js"></script>