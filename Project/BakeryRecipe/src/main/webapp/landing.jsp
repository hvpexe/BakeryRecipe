<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="assets/css/web/bootstrap-4.3.1.min.css" />
        <link rel="stylesheet" type="text/css" href="./assets/css/fontawesome-free-6.1.1-web/css/all.min.css">
        <link rel="stylesheet" href="assets/css/landing.css" />
    </head>
    <body>
    <c:import url="header.jsp" />
    <!-- Masthead-->
    <header class="masthead">
        <div class="container">
            <div class="masthead-subheading">BakeryRecipe - Website for sharing bakery recipe!</div>
            <div class="masthead-heading text-uppercase">It's Nice To Meet You</div>
            <a class="btn btn-main-color btn-xl text-uppercase" href="#services">Register Now</a>
        </div>
    </header>
    <!-- Search -->
    <section class="page-section" id="search">
        <div class="container">
            <div class="text-center">
                <h2 class="section-heading text-uppercase">Search for an idea</h2>
                <h3 class="section-subheading text-muted">Which ingredient you have in your house? Enter all here, we
                    will bring to you some recommend!</h3>
            </div>
            <div class="input-group">
                <span class="input-group-prepend">
                    <div class="input-group-text border-right-0">
                        <i class="fa fa-search"></i>
                    </div>
                </span>
                <input class="form-control py-2 border-left-0" type="search" value="..."
                       id="example-search-input" />
                <span class="input-group-append">
                    <button class="btn btn-outline-secondary border-left-0 border" type="button">
                        Search
                    </button>
                </span>
            </div>
        </div>
    </section>

    <div id="save">
        <div class="container">
            <div class="row featurette">
                <div class="col-md-7">
                    <h2 class="featurette-heading">Save ideas you like <span class="text-muted">It'll blow your
                            mind.</span></h2>
                    <p class="lead">Collect your favorites so you can get back to them later.</p>
                    <a class="btn" href="./community">Explore</a>
                </div>
                <div class="col-md-5">
                    <img class="featurette-image img-fluid mx-auto" data-src="holder.js/500x500/auto" alt="500x500"
                         style="width: 500px; height: 500px;"
                         src="https://media-cdn.tripadvisor.com/media/photo-s/11/29/40/f5/individual-desserts.jpg"
                         data-holder-rendered="true">
                </div>
            </div>
        </div>
    </div>

    <div id="explore">
        <div class="container">
            <div class="row featurette">
                <div class="col-md-7 order-md-2">
                    <h2 class="featurette-heading">See it, make it, try it, do it. <span class="text-muted">See for
                            yourself.</span>
                    </h2>
                    <p class="lead">The best part of Pinterest is discovering new things and ideas from people around the world.</p>
                    <a class="btn" href="./community">Explore</a>
                </div>
                <div class="col-md-5 order-md-1">
                    <img class="featurette-image img-fluid mx-auto" data-src="holder.js/500x500/auto" alt="500x500"
                         src="https://cloudinary-cdn.whisk.com/image/upload/c_limit,q_auto:eco,fl_progressive:semi,h_698,w_1536/v1650393017/recipe/4d34303a40bff7794e9452339537c3f7.jpg"
                         data-holder-rendered="true" style="width: 500px; height: 500px;">
                </div>
            </div>
        </div>
    </div>
    <c:import url="footer.jsp"/>

</body>
</html>
