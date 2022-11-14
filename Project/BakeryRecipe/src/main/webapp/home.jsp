<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="mct" uri="/WEB-INF/tlds/mycustomtag.tld" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="initial-scale=1, width=device-width" />
        <title>Home</title>
        <c:import url="universal.jsp" />

        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

        <link rel="stylesheet" href="assets/css/home.css" />
    </head>
    <body class="">
        <c:import url="header.jsp"/>
        <div class="home-container ">
            <div class="post-section">
                <div class="posting-section">
                    <img class="avatar-icon rounded-circle"
                         src="${login.avatar}" alt="ava" />
                    <button class="btn-button m-auto" id="btnButton">
                        <i class="fa-solid fa-circle-plus"></i>  Add your recipe
                    </button>
                </div>
                <c:if test="${not empty homeRecipe}">
                    <c:forEach items="${homeRecipe}" var="re">
                        <input type="hidden" id="recipeidinhome" value="${re.getId()}">
                        <div class="user-recipe" >
                            <div class="media recipe-header">
                                <img class="recipe-ava c-pointer"
                                     src="<c:out value="${re.getAvatar()}"/>"
                                     alt="avatar" onclick='location = "./profile?userid=${re.userID}"'/>
                                <div class="media-body ml-3">
                                    <a class="text-dark c-pointer hover-underline" href="./profile?userid=${re.userID}">${re.username}</a>
                                    <div class="text-muted small"><c:out value="${re.getDatePostFormat()}"/></div>
                                </div>
                                <div class="dropdown c-pointer noselect">
                                    <a type="text" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true">
                                        <i class="fa-solid fa-ellipsis"></i>
                                    </a>
                                    <div class="dropdown-menu" style="min-width: inherit;" aria-labelledby="dropdownMenuLink">
                                        <a class="dropdown-item" onclick="showConfirmBoxHome(${re.getId()}, 'recipe')">Delete</a>
                                        <a class="dropdown-item" onclick="getReportRecipeHome(${re.getId()})">Report</a>
                                    </div>
                                </div>

                            </div>

                            <div class="recipe-text">
                                ${re.description}
                            </div>
                            <a href=".\RecipeDetail?recipeID=${re.getId()}">
                                <img  class="recipe-img" alt=""
                                      src="${re.cover}" />
                            </a>
                            <div class="recipe-react">
                                <c:if test="${re.like>0}">
                                    <a  class="d-inline-block text-muted hover-underline c-pointer mr-3" onclick="getLikedList('${re.id}')">
                                        <span class="align-middle">
                                            <strong>${re.like}</strong> Likes</span>

                                    </a>
                                </c:if>
                                <c:if test="${re.comment>0}">
                                    <a href="javascript:void(0)" class="d-inline-block text-muted mr-3">
                                        <span class="align-middle" onclick="getCommentList('${re.id}')">
                                            <strong>${re.comment}</strong> Comments</span>
                                    </a>
                                </c:if>
                                <a href=".\RecipeDetail?recipeID=${re.getId()}" class="d-inline-block text-muted">
                                    <i class="fas fa-eye"></i>
                                    <span class="align-middle">View detail</span>
                                </a>
                            </div>
                        </div>
                    </c:forEach>
                </c:if> 
                <c:if test="${empty homeRecipe}">
                    <div class="user-recipe-empty" >
                        <div class="empty-mess ">
                            Welcome to the home page. This page shows the recipes of your follower.
                            You haven't followed any bakers, let's discover!
                        </div>
                        <img class="mx-auto d-block w-75" src="assets/images/logo/norecipe.png">
                        <a class="btn main-btn btn-sm" href="community">Discover</a>
                    </div>
                </c:if>



            </div>
            <div class="frame-div">
                <div class="banner-div">
                    <div class="rectangle-div"></div>
                    <img class="group-icon" alt="" src="assets/images/other/group-36.svg"/>
                    <div class="title-div">Make Cake without prepare!</div>
                    <div class="try-premium-membersh">
                        Make a cake with ingredient you haved
                    </div>
                    <a href="searchByIngredient.jsp" class="btn btn-start">
                        <span>Start Now <i class="fa-sharp fa-solid fa-right-to-bracket"></i></span>
                    </a>
                </div>
                <div class="recommend-wrap">
                    <b class="recommend-title">Recommend bakers</b>
                    <c:forEach items="${listUser}" var="us">
                        <div class="list-container">
                            <a class="list-info" href="profile?userid=${us.id}">
                                <div class="img-wrap ">
                                    <img class="list-img rounded-circle shadow-sm" alt="" src="${us.avatar}" />
                                </div>
                                <div class="list-name">${us.name}</div>  
                            </a>
                            <a class="btn main-btn btn-sm" href="profile?userid=${us.id}">${us.follower} Follower</a>
                        </div>
                    </c:forEach>
                </div>
                <div class="recommend-wrap">
                    <b class="recommend-title">Trend recipes</b>
                    <c:forEach items="${listRecipe}" var="re">
                        <div class="list-container">
                            <a class="list-info" href="RecipeDetail?recipeID=${re.id}">
                                <img class="list-img rounded shadow-sm" alt="" src="${re.cover}" />
                                ${re.name} 
                            </a>
                            <a class="btn main-btn btn-sm hover-button-1" href="RecipeDetail?recipeID=${re.id}">${re.like} Like</a>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
        <!--fixed Container-->
         <!--Delete confirm -->
        <div class="fixed-container" id="delete_confirm" >
            <div class="gray-box"></div>
            <div class="content flex-column d-flex  border card-body col-12 col-md-4" style="gap:10px">
                <div class="exit-btn"><i class="fas fa-x"></i></div>
                <div class="col-12 d-flex flex-column justify-content-between">
                    <div class="report-title h3 font-weight-bold text-center">Do You Want To Delete?</div>
                    <div class="d-flex justify-content-around align-items-center col-12 ">
                        <button class="hover-button-2  delete">Delete</button>
                        <button class="hover-button-2  cancel" onclick="$('#delete_confirm').removeClass('d-flex')">Cancel</button>
                    </div>
                </div>
                <div id="thankReport"></div>
            </div>
        </div>
        <!--End of Delete confirm -->
        
          <!--ham container report recipe-->
        <div class="fixed-container " id="report_recipe" >
            <div class="gray-box"></div>
            <div class="content card-body col-12 col-md-4">
                <div class="col-12 p-0">
                    <div class="report-title h3 font-weight-bold">Report Recipe </div>
                    <!--                    <form action="ReportController" class="col">-->
                    <div class="form-group">
                        <select name="typeReport" class="selectReport w-100" id="select_Rp">
                            <option value="Content">Inappropriate Content</option>
                            <option value="Intellectual">Infringement on intellectual property</option>
                            <option value="Spamming">Spamming or misleading</option>
                            <option value="Community">The recipe is not suitable for the community</option>
                        </select>

                        <input  type="hidden" id="loginID">
                        <!--                            <input type="hidden" name="bakerID" id="loginID" value="">
                                                    <input type="hidden" name="recipeID" id="recipeID" value="">-->
                    </div>
                    <div class="form-group" >
                        <textarea name="txtReport" class="txtareaRp w-100"  id="txtReport" value=""></textarea>
                    </div>  
                    <div class="form-group">
                        <button class="hover" type="submit" onclick="sendReportHome('Recipe')">Send Report</button>
                    </div>

                    <!--</form>--> 
                </div>
                <div id="thankReportHome"></div>

            </div>
        </div>
        <!--ket thuc ham container-->
        <div class="fixed-container " id="liked-list" >
            <div class="gray-box"></div>
            <div class="content card-body col-12 col-md-6">
            </div>
        </div>
        <script>
            var recipeID =document.querySelector('#recipeidinhome').value;
            var loginID = ${sessionScope.login.id};
        </script>
        <script src="assets/js/home.js"></script>
        <script>
        </script>
    </body>
</html>

