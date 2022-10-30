<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Gelasio:wght@400;500;700&display=swap"/>
<link href="assets/css/fontawesome-free-6.1.1-web/css/all.min.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="assets/css/header.css">
<header class="header-container header py-2 py-md-0 ">
    <div class="header-left align-items-center col-sm-12 col-md-6 p-0">
        <a class="header-logo navbar-brand col-md-3 p-0" href="./home">
            <img class="mx-auto" src="assets/images/logo/logo2.png" alt="">
        </a>
        <nav class="header-links justify-content-around col-md col p-0 ">
            <a id="home" class="header-link p-0 border-0" href="./home">Home</a>
            <a id="community" class="header-link p-0 border-0" href="./community">Community</a>
            <a id="saved" class="header-link p-0 border-0" href="./savedrecipe">Saved</a>
            <a id="shopping" class="header-link p-0 border-0" href="./shopping.jsp">Shopping</a>
        </nav>
    </div>
    <div class="header-right align-items-center flex-md-nowrap col-sm-12 col-md px-2 justify-content-md-center">
        <div class="col-sm d-flex align-items-center">
            <form action="Search"> 
                <div class="searchbar">
                    <i class="px-1 searchbar-icon fa-solid fa-magnifying-glass"></i>
                    <input class="searchbar-input col p-0" type="text" placeholder="Search" name="searchKey" value="" size="40">
                    <input type="hidden" name="action" value="Recipe">
                </div>
            </form> 

            <c:set var="login" value="${login}" scope="session"></c:set>
            <c:if test="${login == null}">
                <a href="login.jsp" class="header-user ml-auto" data-type="register">
                    Sign up / Sign in
                </a>
            </c:if>
            <c:if test="${login != null}">
                <div class="d-inline-flex ml-auto">
                    <div class="p-0 d-flex align-items-center justify-content-center ml-auto">
                        <div class="hover-button-1 header-notification">
                            <i class="fa-solid fa-bell"></i>
                        </div>
                    </div>
                    <div class="header-user position-relative ml-auto">
                        <a href="profile.jsp" class="header-user-button position-relative">
                            <div class="header-button-detail p-0 pl-1 pr-5">
                                ${login.name}   
                                <img id="user_avatar" class=" d-inline m-auto rounded-circle position-absolute" src="${login.avatar}"/>
                            </div>
                        </a>
                        <div class="header-user_content  position-absolute">
                            <div class="list-group flex-column justify-content-start" href="#" >
                                <a class="list-group-item text-dark text-decoration-none nav-item" href="./profile.jsp"><div>Profile</div></a>
                                <a class="list-group-item text-dark text-decoration-none nav-item" href="./profileInfo.jsp"><div>Setting</div></a>
                                <a class="list-group-item text-dark text-decoration-none nav-item" href="logout"><div> Logout</div></a>
                            </div>
                        </div>
                    </div>
                </div>
            </c:if>
        </div>
    </div>
</header>

<script src="assets/js/header.js"></script>