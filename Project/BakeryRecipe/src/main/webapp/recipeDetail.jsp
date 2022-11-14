<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="m" uri="/WEB-INF/tlds/mycustomtag.tld" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="initial-scale=1, width=device-width" />
        <meta name="description" content="">
        <title>${RECIPE_DETAIL.name}</title>
        <c:import url="universal.jsp" />

        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@8/swiper-bundle.min.css" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <link rel="stylesheet" href="assets/css/recipeDetail.css?version=1" />
    </head>
    <body>
        <c:catch var="e"> 
            <c:import url="header.jsp"/>
            <%--<c:catch var="e">--%>
            <div class="recipe-container container">
                <!-- head info -->
                <div class="row head-info px-4">
                    <div class="col-md-4 info-img">
                        <div class="swiper">
                            <!-- Additional required wrapper -->
                            <div class="swiper-wrapper">
                                <!-- Slides -->
                                <c:forEach items="${LIST_PIC}" var="cc">
                                    <div class="swiper-slide">
                                        <img src="./assets/images/recipe/picture/${cc}" alt="">
                                    </div>
                                </c:forEach>
                                <c:if test="${not empty VIDEO_DETAIL}">
                                    <div class="swiper-slide">
                                        <iframe src="https://www.youtube.com/embed/${VIDEO_DETAIL}" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                                    </div>
                                </c:if>
                                ...
                            </div>
                            <!-- If we need pagination -->
                            <div class="swiper-pagination"></div>

                            <!-- If we need navigation buttons -->
                            <div class="swiper-button-prev"></div>
                            <div class="swiper-button-next"></div>
                        </div>
                    </div>
                    <div class="col-md-8">
                        <div class="first-div col p-0">

                            <div class="info-user">
                                <span class="">
                                    <img src="${USER_DETAIL.getAvatar()}">
                                    <a class="text-decoration-none hover-underline text-dark ml-2" href="profile?userid=${USER_DETAIL.getId()}">${USER_DETAIL.getName()}</a>
                                    <c:if test="${not empty sessionScope.login.id and sessionScope.login.id != USER_DETAIL.id}">
                                        <c:choose>
                                            <c:when test="${CHECK_FOLLOW == 'false'}">
                                                <span class="btn btn-style1" onclick="followButton(this, 'Follow', 'UnFollow', this.action)" >
                                                    <i class="fa-solid fa-user-plus"></i>
                                                    <span  class="txt-follow" this="">Follow</span>
                                                </span>
                                            </c:when>
                                            <c:otherwise>
                                                <span class="btn btn-style1 button-Follower" onclick="followButton(this, 'UnFollow', 'Follow', this.action)" >
                                                    <i class="fa-solid fa-user-plus"></i>
                                                    <span  class="txt-follow" this="">UnFollow</span>
                                                </span>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:if>
                                </span>

                                <!--followButton(this,'Saved','Not Saved')-->
                                <!--followButton(this,'Like','UnLike')-->

                                <c:if test="${not empty sessionScope.login.id}">
                                    <span class="dropdown">
                                        <a type="text" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true">
                                            <i class="fa-solid fa-ellipsis"></i>
                                        </a>
                                        <div class="dropdown-menu noselect" style="min-width: inherit;" aria-labelledby="dropdownMenuLink">
                                            <c:if test="${sessionScope.login.id != USER_DETAIL.id && sessionScope.login.role != 'admin'}">
                                                <a class="dropdown-item" onclick="getReportRecipe(${RECIPE_DETAIL.getId()})" href="#">Report</a>
                                            </c:if>
                                            <c:if test="${sessionScope.login.id == USER_DETAIL.id || sessionScope.login.role == 'admin'}">
                                                <a class="dropdown-item" onclick="showConfirmBox(${RECIPE_DETAIL.id}, 'recipe')" >Delete</a>
                                            </c:if>
                                            <c:if test="${sessionScope.login.id == USER_DETAIL.id}">
                                                <a class="dropdown-item" href="./editrecipe?recipeID=${param.recipeID}">Edit</a>
                                            </c:if>
                                        </div>
                                    </span>
                                </c:if>
                            </div>



                            <div class="recipe-name">
                                <!--White Chocolate Lemon Cupcakes White Chocolate Lemon Cupcakes-->
                                ${RECIPE_DETAIL.name}
                            </div>
                            <div class="date-post">
                                <c:out value="${RECIPE_DETAIL.getDatePostFormat()}"/>
                            </div>
                            <div class="recipe-react">
                                <span id="like-data" val>Like: ${RECIPE_DETAIL.getLike()}</span>
                                <span>Comment: ${RECIPE_DETAIL.getComment()}</span>
                                <span>Saved: ${RECIPE_DETAIL.getSave()}</span>
                            </div>

                            <div class="react-action">
                                <c:if test="${not empty sessionScope.login.id}">

                                    <c:if test="${sessionScope.login.id != USER_DETAIL.id}">
                                        <c:choose>
                                            <c:when test="${checklike == 'false'}">
                                                <div class="btn btn-style1" onclick="likeButton(this, 'Like', 'UnLike', this.action)" >
                                                    <i class="fa-solid fa-heart"></i>
                                                    <span  class="txt-follow" this="">Like</span>
                                                </div>
                                            </c:when>
                                            <c:otherwise>
                                                <div class="btn btn-style1 button-Follower" onclick="likeButton(this, 'Unlike', 'Like', this.action)" >
                                                    <i class="fa-solid fa-heart"></i>
                                                    <span  class="txt-follow" this="">Unlike</span>
                                                </div>
                                            </c:otherwise>
                                        </c:choose>
                                        &nbsp;
                                    </c:if>

                                    <c:choose>
                                        <c:when test="${checksave == 'false'}">
                                            <div class="btn btn-style1" onclick="saveButton(this, 'Save', 'Unsave', this.action)" >
                                                <i class="fa-solid fa-bookmark"></i>
                                                <span  class="txt-follow" this="">Save</span>
                                            </div>
                                        </c:when>
                                        <c:otherwise>
                                            <div class="btn btn-style2" onclick="saveButton(this, 'UnSave', 'Save', this.action)" >
                                                <i class="fa-solid fa-bookmark"></i>
                                                <span  class="txt-follow" this="">Unsave</span>
                                            </div>
                                        </c:otherwise>
                                    </c:choose>
                                </c:if>
                            </div>
                            <div class="detail">
                                <!--                        These lemon cupcakes have an ultra soft and moist texture and are served with a fragrant white
                                                        chocolate whipped cream and strawberries. This recipe is for you if you enjoy a decadent dessert
                                                        that is not too sweet.-->
                                ${RECIPE_DETAIL.getDescription()}
                            </div>
                            <div class="time">
                                <i class="fa-regular fa-clock"></i> Prep: ${RECIPE_DETAIL.getPrepTime()}min &nbsp; &nbsp; &nbsp; 
                                <i class="fa-regular fa-clock"></i> Cook: ${RECIPE_DETAIL.getCookTime()}min
                            </div>
                        </div>

                    </div>

                    <!-- ingredient & instruction & comment -->
                    <div class="row body-info col-12">
                        <div class="col-md-8">
                            <div class="ingredient-container">
                                <div class="head">
                                    INGREDIENTS
                                </div>
                                <div class="body row"> 
                                    <!--request.getAttribute('LIST_INGREDIENT')-->

                                    <c:forEach items="${requestScope.LIST_INGREDIENT}" var="di">
                                        <div class="ingredient col-md-6">
                                            <img src="${di.getImg()}">
                                            <span>
                                                <!--190 gam baking powder-->
                                                ${di.getAmount()} ${di.getName()}
                                            </span>
                                        </div>
                                    </c:forEach>
                                    <c:if test="${empty requestScope.LIST_INGREDIENT}">
                                        <div class="empty">
                                            <p>
                                                This recipe does not have any ingredients.
                                            </p>
                                            <img src="assets/images/other/empty_ingre.png" />
                                        </div>
                                    </c:if>
                                </div>
                            </div>

                            <div class="instruction-container">
                                <div class="head">
                                    INSTRUCTIONS
                                </div>
                                <div class="body" >
                                    <c:forEach items="${requestScope.LIST_STEP}" var="ep">
                                        <div class="instruction border-bottom d-flex flex-column gap-3">
                                            <div class="step h33">Step ${ep.getInsstep()}: </div>
                                            <c:if test="${not empty ep.img}">
                                                <div class="  col-auto p-0 noselect">
                                                    <img class="col-6 p-0 hover-button-4" src="${ep.img}" alt="${ep.img}" />
                                                </div>
                                            </c:if>
                                            <p>
                                                ${ep.getDetail()}
                                            </p>
                                        </div>
                                    </c:forEach>
                                    <c:if test="${empty requestScope.LIST_STEP}">
                                        <div class="empty">
                                            <p>
                                                This recipe does not have any instructions.
                                            </p>
                                            <img src="assets/images/other/empty_instruc.png" />
                                        </div>
                                    </c:if>

                                </div>
                            </div>
                            <div class="comment-container">
                                <div class="head">
                                    COMMENTS
                                </div>
                                <div class="body" >
                                    <c:if test="${not empty sessionScope.login.id}">
                                        <div class="card-body p-0 mb-3">
                                            <div class="d-flex flex-start w-100">
                                                <img class="rounded-circle border"
                                                     src="${sessionScope.login.avatar}" alt="avatar"
                                                     width="60" height="60" />
                                                <div class="w-100">
                                                    <div class="form-outline">
                                                        <textarea onkeydown="Comment(this, event)" class="form-control" id="textAreaExample" rows="4" type="textarea" name="txtCmt" value=""></textarea>
                                                    </div>
                                                </div>
                                            </div>  
                                        </div>
                                    </c:if>


                                    <c:forEach items="${COMMENT_LIST}" var="cmt">
                                  <input  type="hidden" id="commentID">
                                        <input type="hidden" id="commentReportID" value="${cmt.commentID}">
                                        <div class="d-flex flex-start mb-4"  id="comment-${cmt.commentID}" >
                                            <img class="rounded-circle border mr-2"
                                                 src="./assets/images/avt/${cmt.avatar}" alt="avatar"
                                                 width="60" height="60" />
                                            <div class="card w-100">
                                                <div class="card-body p-4"> 
                                                    <div class="baseline d-flex">
                                                        <h5 class="col p-0">${cmt.chefName}</h5>
                                                        <!--report comment--> 
                                                        <span class="dropdown">
                                                            <a type="text" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true">
                                                                <i class="fa-solid fa-ellipsis"></i>
                                                            </a>
                                                            <div class="dropdown-menu c-pointer noselect" style="min-width: inherit;" aria-labelledby="dropdownMenuLink">
                                                                <c:if test="${sessionScope.login.id != cmt.userID}">
                                                                    <a class="dropdown-item" onclick="getReportComment(${RECIPE_DETAIL.getId()})">
                                                                        <span class="align-middle"><strong>${re.like}</strong> Report</span>
                                                                    </a>
                                                                </c:if>
                                                                <c:if test="${(sessionScope.login.id == cmt.userID || sessionScope.login.role == 'admin')}">
                                                                    <a class="dropdown-item" onclick="showConfirmBox(${cmt.commentID}, 'comment', '#comment-${cmt.commentID}')" >Delete</a>
                                                                </c:if>
                                                            </div>
                                                        </span>
                                                        <!--ket thuc comment--> 
                                                    </div>
                                                    <p class="small">
                                                        <m:ago value = "${cmt.getDateComment()}" />
                                                    </p>
                                                    <p>
                                                        ${cmt.comment}
                                                    </p>
                                                </div>
                                            </div>
                                        </div>

                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Related recipes -->
                    <div class="related-container mx-auto mt-3">
                        <div class="title-container">
                            <h1 class="notify-title">Related recipes</h1>
                        </div>
                        <div class="recipe-list row ">
                            <c:forEach items="${RELATED_TOPIC}" var="to">
                                <div class="recipe col-6 col-md-3">
                                    <div class="img-container">
                                        <a  href="RecipeDetail?recipeID=${to.id}"><img class="recipe-img" alt=""
                                                                                       src="${to.cover}" /></a>
                                        <div class="react">
                                            <div>${to.like} likes</div>
                                            <div>${to.comment} comments</div>
                                        </div>
                                    </div>
                                    <div class="related-recipe-name">${to.name}</div>
                                    <div class="recipe-author"><a href="#">${to.username}</a><c:out value="${to.getDatePostFormat()}"/></div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>

            </div>

        </c:catch> ${e}

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
                        <button class="hover" type="submit" onclick="sendReport('Recipe')">Send Report</button>
                    </div>

                    <!--</form>--> 
                </div>
                <div id="thankReport"></div>

            </div>
        </div>
        <!--ket thuc ham container-->




        <!--report cua comment--> 
        <div class="fixed-container " comment id="report_comment" >
            <div class="gray-box"></div>
            <div class="content card-body col-12 col-md-4">
                <div class="col-12 p-0">
                    <div class="report-title h3 font-weight-bold">Report Comment</div>
                    <!--                    <form action="ReportController" class="col">-->
                    <div class="form-group">
                        <select name="typeReport" class="selectReport w-100" id="select_Rp">
                            <option value="Spam">Spam </option>
                            <option value="Speech">Hate Speech</option>
                            <option value="victim">Make fun of the victim</option>
                        </select>
                        <div class="form-group" >
                            <textarea name="txtReport" class="txtareaRp w-100"  id="txtReportComment" value=""></textarea>
                        </div>  
                        <div class="form-group">
                            <button class="hover" type="submit" onclick="sendReport('Comment')">Send Report</button>
                        </div>

                        <!--</form>--> 
                    </div>


                </div>
                <div id="thankReport1"></div>
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

        <script>
            var loginID = ${sessionScope.login.id};
            var recipeID =${RECIPE_DETAIL.id};
            var userID = ${USER_DETAIL.id};
            var likeNum =${RECIPE_DETAIL.getLike()};
            var commentID = document.querySelector('#commentReportID').value;

        </script>
        <script src="https://cdn.jsdelivr.net/npm/swiper@8/swiper-bundle.min.js"></script>
        <script src="assets/js/recipeDetail.js"></script>
        <c:import url="footer.jsp"/>

    </body>

</html>