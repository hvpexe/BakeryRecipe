<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns:h="http://xmlns.jcp.org/jsf/html" xmlns:f="http://xmlns.jcp.org/jsf/core">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="initial-scale=1, width=device-width" />
        <title>${user.name}</title>
        <meta name="description" content="" />
        <c:import url="universal.jsp" />

        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

        <link rel="stylesheet" href="assets/css/profile.css">
    </head>
    <body>
        <c:import url="header.jsp"/>

        <div class="section-container">
            <div class=" section-profile">
                <div class="row profile-header">
                    <img class="col-3 avt-icon"
                         src=${requestScope.user.avatar}
                         alt="" />

                    <div class="col-9">
                        <div class="d-flex justify-content-between align-items-center">
                            <span class="profile-name">${requestScope.user.name}</span>


                            <c:if test="${requestScope.user == sessionScope.login}">
                                <a href="./profileInfo.jsp" class="btn edit-profile-button">Edit Profile</a>
                            </c:if>

                            <c:if test="${not empty sessionScope.login and sessionScope.login != requestScope.user}">
                                <div class="dropdown ml-auto">
                                    <a type="text" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true">
                                        <i class="fa-solid fa-ellipsis"></i>
                                    </a>
                                    <div class="dropdown-menu noselect" style="min-width: inherit;" aria-labelledby="dropdownMenuLink">
                                        <a class="dropdown-item" onclick="getReportUser(${requestScope.user.id})" href="#">Report</a>
                                    </div>
                                </div>
                            </c:if>
                        </div>
                        <c:if test="${not empty sessionScope.login and sessionScope.login.id != requestScope.user.id}">
                            <span class="info-user">
                                <c:choose>
                                    <c:when test="${CHECK_FOLLOW_HOME == 'False'}">
                                        <div class="btn btn-style1" onclick="followButton2(this, 'Follow', 'UnFollow', this.action)" >
                                            <i class="fa-regular fa-heart"></i>
                                            <span class="txt-follow" this="">Follow</span>
                                        </div>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="btn btn-style1 button-Follower" onclick="followButton2(this, 'Unfollow', 'Follow', this.action)" >
                                            <i class="fa-regular fa-heart"></i>
                                            <span  class="txt-follow" this="">Unfollow</span>
                                        </div>
                                    </c:otherwise>
                                </c:choose>
                            </span>
                        </c:if>
                        <div class="follow_view">
                            <span class="follow">${requestScope.user.follower} Follower</span>  
                            <span class="follow">${requestScope.user.following} Following</span>
                        </div>
                    </div>
                </div>
                <c:if test="${login.id eq user.id}">
                    <a href="./addrecipe" class="btn input-button">
                        <i class="fa-solid fa-circle-plus"></i>&nbsp;Add your recipe
                    </a>
                </c:if>
                <div class="profile-activity">
                    <b>Activity</b>
                </div>
                <c:if test="${empty profileRecipe}">
                    <div class="activity-empty">
                        ${requestScope.user.name} hasn’t posted any recipes. <br>
                        When they do, their recipes will show up here.
                    </div>
                </c:if>
                <c:forEach items="${profileRecipe}" var="re">
                    <input type="hidden" id="recipeidinprofile" value="${re.getId()}">
                    <div class="profile-recipe">
                        <div class="media recipe-header">
                            <img class="recipe-ava c-pointer"
                                 src="<c:out value="${re.getAvatar()}"/>"
                                 alt=""
                                 onclick='location = "./profile?userid=${re.userID}"'/>
                            <div class="media-body ml-3">
                                <a href="./profile?userid=${requestScope.user.id}" class="text-dark c-pointer hover-underline">${re.username}</a>
                                <div class="text-muted small"><c:out value="${re.getDatePostFormat()}"/></div>
                            </div>
                            <c:if test="${not empty sessionScope.login}">
                                <div class="dropdown">
                                    <a type="text" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true">
                                        <i class="fa-solid fa-ellipsis"></i>
                                    </a>
                                    <div class="dropdown-menu" style="min-width: inherit;" aria-labelledby="dropdownMenuLink">
                                        <a class="dropdown-item" onclick="showConfirmBoxProfile(${re.getId()}, 'recipe')">Delete</a>
                                        <a class="dropdown-item" onclick="getReportRecipeProfile(${re.getId()})">Report</a>
                                    </div>
                                </div>
                            </c:if>
                        </div>

                        <div class="recipe-text">
                            ${re.description}
                        </div>

                        <img class="recipe-img c-pointer" alt=""
                             src="${re.cover}" onclick="location = './RecipeDetail?recipeID=${re.id}'" />

                        <div class="recipe-react">
                            <c:if test="${re.like>0}">
                                <a href="javascript:void(0)" class="d-inline-block text-muted">
                                    <span class="align-middle"><strong>${re.like}</strong> Likes</span>
                                </a>
                            </c:if>
                            <c:if test="${re.comment>0}">
                                <a href="javascript:void(0)" class="d-inline-block text-muted ml-3">
                                    <span class="align-middle"><strong>${re.comment}</strong> Comments</span>
                                </a>
                            </c:if>
                            <a href="RecipeDetail?recipeID=${re.id}" class="d-inline-block text-muted ml-3">
                                <i class="fas fa-eye align-middle"></i>
                                <span class="align-middle">View detail</span>
                            </a>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
        <!--report cua comment--> 
        <div class="fixed-container " id="report_user" >
            <div class="gray-box"></div>
            <div class="content card-body col-12 col-md-4">
                <div class="col-12 p-0">
                    <div class="report-title h3 font-weight-bold">Report User</div>
                    <!--                    <form action="ReportController" class="col">-->
                    <div class="form-group">
                        <select name="typeReport" class="selectReport w-100" id="select_Rp">
                            <option value="Impersonate">Impersonate Others </option>
                            <option value="Account">Fake Account</option>
                            <option value="Posting">Posting inappropriate content</option>
                        </select>
                        <div class="form-group" >
                            <textarea name="txtReport" class="txtareaRp w-100"  id="txtReportUser" value=""></textarea>
                        </div>  
                        <div class="form-group">
                            <button class="hover" type="submit" onclick="sendReport1('User')">Send Report</button>
                        </div>

                        <!--</form>--> 
                    </div>
                </div>
                <div id="thankReport2"></div>
            </div>
        </div>

        <!--keu thuc report cua comment-->
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
                        <button class="hover" type="submit" onclick="sendReportProfile('Recipe')">Send Report</button>
                    </div>

                    <!--</form>--> 
                </div>
                <div id="thankReportProfile"></div>

            </div>
        </div>
        <!--ket thuc ham container-->
        <script>
            var userReport = ${sessionScope.login.id};
            var userReported = ${user.id};
            var recipeID = document.querySelector('#recipeidinprofile').value;

        </script>
        <script src="assets/js/Jquery/jquery-core.js"></script>
        <script src="assets/js/profile.js"></script>

    </body>
</html>
