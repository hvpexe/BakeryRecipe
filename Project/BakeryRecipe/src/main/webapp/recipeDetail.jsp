<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="initial-scale=1, width=device-width" />
        <title>${USER_DETAIL.name}</title>
        <c:import url="universal.jsp" />

        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@8/swiper-bundle.min.css" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <link rel="stylesheet" href="assets/css/recipeDetail1.css?version=1" />
    </head>
    <body>
        <c:catch var="e"> 
            <c:import url="header.jsp"/>
            <%--<c:catch var="e">--%>
            <div class="reccipe-container">
                <!-- head info -->
                <div class="row head-info">
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
                                <div class="swiper-slide">
                                    <iframe src="https://www.youtube.com/embed/${VIDEO_DETAIL}" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                                </div>
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
                        <div class="first-div">

                            <span class="info-user">
                                <img src="${USER_DETAIL.getAvatar()}">
                                <span>${USER_DETAIL.getName()}</span>
                                <c:if test="${sessionScope.login.id != USER_DETAIL.id}">
                                    <!--                                <div class="btn btn-style1" onclick="followButton(this, 'Follow', 'UnFollow', this.action)" >
                                                                        <i class="fa-solid fa-user-plus"></i>
                                                                        <span  class="txt-follow" this="">Follow</span>
                                                                    </div>-->
                                    <!--cach cua anh tú mượn mấy hôm trả-->
                                    <c:choose>
                                        <c:when test="${CHECK_FOLLOW == 'false'}">
                                            <div class="btn btn-style1" onclick="followButton(this, 'Follow', 'UnFollow', this.action)" >
                                                <i class="fa-regular fa-heart"></i>
                                                <span  class="txt-follow" this="">Follow</span>
                                            </div>
                                        </c:when>
                                        <c:otherwise>
                                            <div class="btn btn-style1 button-Follower" onclick="followButton(this, 'UnFollow', 'Follow', this.action)" >
                                                <i class="fa-regular fa-heart"></i>
                                                <span  class="txt-follow" this="">UnFollow</span>
                                            </div>
                                        </c:otherwise>
                                    </c:choose>
                                </c:if>

                                <!--followButton(this,'Saved','Not Saved')-->
                                <!--followButton(this,'Like','UnLike')-->
                                <div class="first-div">
                                    <c:if test="${sessionScope.login.id == USER_DETAIL.id}">
                                        <span class="text-nowrap">
                                            <a href="#" class="btn btn-style2"><i class="fa-regular fa-pen-to-square"></i> Edit</a>
                                        </span>
                                    </c:if>
                                </div>

                            </span>
                            <!--                             <div     class="button-recipe">
                                                        <img src=".\assets\css\fontawesome-free-6.1.1-web\svgs\solid\ellipsis-vertical.svg" height="200px" width="100px">
                                                        </div>-->

                            <div class="dropdown">
                                <button><i class="fa-solid fa-ellipsis"></i></button>
                                <div class="dropdown-options">
                                    <a   class="d-inline-block text-muted hover-underline c-pointer mr-3" onclick="getReport(${RECIPE_DETAIL.getId()})" href="#">
                                        <span class="align-middle">
                                            <strong>${re.like}</strong> Report</span></a>
                                    <a href="#">Delete</a>
                                </div>
                            </div>



                            <div class="recipe-name">
                                <!--White Chocolate Lemon Cupcakes White Chocolate Lemon Cupcakes-->
                                ${RECIPE_DETAIL.name}
                            </div>
                            <div class="date-post">
                                <c:out value="${RECIPE_DETAIL.getDatePostFormat()}"/>
                            </div>
                            <div class="recipe-react">
                                <span>Like: ${RECIPE_DETAIL.getLike()}</span>
                                <span>Comment: ${RECIPE_DETAIL.getComment()}</span>
                                <span>Saved: ${RECIPE_DETAIL.getSave()}</span>
                            </div>

                            <c:if test="${sessionScope.login.id != USER_DETAIL.getId()}">
                                <div class="react-action">
                                    <c:choose>
                                        <c:when test="${checklike == 'false'}">
                                            <div class="btn btn-style1" onclick="likeButton(this, 'Like', 'UnLike', this.action)" >
                                                <i class="fa-regular fa-heart"></i>
                                                <span  class="txt-follow" this="">Like</span>
                                            </div>
                                        </c:when>
                                        <c:otherwise>
                                            <div class="btn btn-style1 button-Follower" onclick="likeButton(this, 'UnLike', 'Like', this.action)" >
                                                <i class="fa-regular fa-heart"></i>
                                                <span  class="txt-follow" this="">UnLike</span>
                                            </div>
                                        </c:otherwise>
                                    </c:choose>
                                    &nbsp;
                                    <c:choose>
                                        <c:when test="${checksave == 'false'}">
                                            <div class="btn btn-style1" onclick="saveButton(this, 'Save', 'UnSave', this.action)" >
                                                <i class="fa-regular fa-bookmark"></i>
                                                <span  class="txt-follow" this="">Save</span>
                                            </div>
                                        </c:when>
                                        <c:otherwise>
                                            <div class="btn btn-style1 button-Follower" onclick="saveButton(this, 'UnSave', 'Save', this.action)" >
                                                <i class="fa-regular fa-bookmark"></i>
                                                <span  class="txt-follow" this="">UnSave</span>
                                            </div>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                            </c:if>
                            <div class="detail">
                                <!--                        These lemon cupcakes have an ultra soft and moist texture and are served with a fragrant white
                                                        chocolate whipped cream and strawberries. This recipe is for you if you enjoy a decadent dessert
                                                        that is not too sweet.-->
                                ${RECIPE_DETAIL.getDescription()}
                            </div>
                            <div class="time">
                                <i class="fa-regular fa-clock"></i> Prep: ${RECIPE_DETAIL.getPrepTime()}min &nbsp; &nbsp; &nbsp; Cook: ${RECIPE_DETAIL.getCookTime()}min
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
                                <div class="body">
                                    <c:forEach items="${requestScope.LIST_STEP}" var="ep">
                                        <div class="instruction">
                                            <div class="step">Step ${ep.getInsstep()}: </div>
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

                                    <div class="card-body p-2 mb-3">
                                        <div class="d-flex flex-start w-100">
                                            <img class="rounded-circle mr-2"
                                                 src="${sessionScope.login.avatar}" alt="avatar"
                                                 width="60" height="60" />
                                            <div class="w-100">
                                                <div class="form-outline">
                                                    <textarea  onkeyup="Comment(this, event)" class="form-control" id="textAreaExample" rows="4" type="textarea" name="txtCmt" value=""></textarea>
                                                </div>
                                            </div>
                                        </div>  
                                    </div>
                                    <div id="show-comment"></div>

                                    <!--test list_cmt-->

                                    <c:forEach items="${COMMENT_LIST}" var="cmt">
                                        <div class="d-flex flex-start mb-4"   >
                                            <img class="rounded-circle mr-2"
                                                 src="./assets/images/avt/${cmt.avatar}" alt="avatar"
                                                 width="60" height="60" />
                                            <div class="card w-100">
                                                <div class="card-body p-4">
                                                    <div class="">
                                                        <h5>${cmt.chefName}</h5>
                                                        <p class="small">
                                                            <c:out value="${cmt.getDateComment()}"/></p>
                                                        <p>
                                                            ${cmt.comment}
                                                        </p>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4" style="background-color: #e3a587;">
                            <!-- Phần này để nội dung gợi ý shop - làm sau -->
                        </div>
                    </div>

                    <!-- Related recipes -->
                    <div class="related-container mx-auto mt-3">
                        <div class="title-container">
                            <h1 class="title">Related recipes</h1>
                        </div>
                        <div class="recipe-list row ">
                            <c:forEach items="${RELATED_TOPIC}" var="to">
                                <div class="recipe col-6 col-md-3">
                                    <div class="img-container">
                                        <img class="recipe-img" alt=""
                                             src="${to.cover}" />
                                        <div class="react">
                                            <div>${to.like} likes</div>
                                            <div>${to.comment} comments</div>
                                        </div>
                                    </div>
                                    <div class="related-recipe-name">${to.name}</div>
                                    <div class="recipe-author"><a href="#">${to.username}</a><c:out value="${to.getDatePost()}"/></div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>

            </div>
        </c:catch> ${e}

        <!--PhuHV: nua dem fix bug cai nay, tien sư thang nao xoa script lam carousel ko chay -->
        <!--ham container-->
        <div class="fixed-container " id="report_list" >
            <div class="gray-box"></div>
            <div class="content card-body col-12 col-md-4">
                <div class="col-6">
                    <div class="report-title">Report Recipe</div>
                    <form action="ReportController">
                        <div class="form-group">
                            <select name="typeReport" class="selectReport">
                                <option value="Content">Inappropriate Content</option>
                                <option value="Intellectual">Infringement on intellectual property</option>
                                <option value="Spamming">Spamming or misleading</option>
                                <option value="Community">The recipe is not suitable for the community</option>
                            </select>
                            <input type="hidden" name="bakerID" value="${sessionScope.login.id}">
                            <input type="hidden" name="recipeID" value="${RECIPE_DETAIL.id}">
                        </div>
                        <div class="form-group">
                            <textarea name="txtReport" class="txtareaRp" value=""></textarea>
                        </div>  
                        <div class="form-group">
                            <button type="submit">Send Report</button>
                        </div>
                    </form> 
                </div>

            </div>

        </div>
        <script src="https://cdn.jsdelivr.net/npm/swiper@8/swiper-bundle.min.js"></script>
        <script>
                                                        const swiper = new Swiper('.swiper', {
                                                            pagination: {
                                                                el: '.swiper-pagination',
                                                                clickable: true
                                                            },
                                                            navigation: {
                                                                nextEl: '.swiper-button-next',
                                                                prevEl: '.swiper-button-prev',
                                                            },
                                                        });
        </script>
        <script>
            function  followButton(item, val1, val2, action) {
                //                eventac.target.style.backgroundColor = 'white';
                //                event.target.classList.toggle("button-Follower");
                ///
                //                console.log(event.target.classList);

                var action = val1;
                $.ajax({
                    url: "ajax/UpdateUserFollowAjax",
                    type: "get", //send it through get method
                    data: {
                        follower: "${USER_DETAIL.id}",
                        action: action,
                        followed: "${sessionScope.login.id}"
                    },
                    success: function () {
                        console.log(item);
                        item.classList.toggle("button-Follower");
                        let txtFollow = item.querySelector("span");
                        if (txtFollow.innerText !== val2)
                            txtFollow.innerText = val2;
                        else
                            txtFollow.innerText = val1;
                        // console.log(action);

                        //    action = unFollow;
                        console.log(action);
                        //Do Something
                    },
                    error: function () {
                        //Do Something to handle error
                        console.log("thanh cong roi kia");
                    }
                });
            }

        </script>
        <script>
            function  saveButton(item, val1, val2, action) {
                //                eventac.target.style.backgroundColor = 'white';
                //                event.target.classList.toggle("button-Follower");
                ///
                //                console.log(event.target.classList);

                var action = val1;
                $.ajax({
                    url: "ajax/updatesaverecipe",
                    type: "get", //send it through get method
                    data: {
                        recipe: "${RECIPE_DETAIL.id}",
                        action: action,
                        user: "${sessionScope.login.id}"
                    },
                    success: function () {
                        console.log(item);
                        item.classList.toggle("button-Follower");
                        let txtFollow = item.querySelector("span");
                        if (txtFollow.innerText !== val2)
                            txtFollow.innerText = val2;
                        else
                            txtFollow.innerText = val1;
                        // console.log(action);

                        //    action = unFollow;
                        console.log(action);
                        //Do Something
                    },
                    error: function () {
                        //Do Something to handle error
                        console.log("thanh cong roi kia");
                    }
                });
            }
        </script>
        <script>
            function  likeButton(item, val1, val2, action) {
                //                eventac.target.style.backgroundColor = 'white';
                //                event.target.classList.toggle("button-Follower");
                ///
                //                console.log(event.target.classList);

                var action = val1;
                $.ajax({
                    url: "ajax/likerecipe",
                    type: "get", //send it through get method
                    data: {
                        recipe: "${RECIPE_DETAIL.id}",
                        action: action,
                        user: "${sessionScope.login.id}"
                    },
                    success: function () {
                        console.log(item);
                        item.classList.toggle("button-Follower");
                        let txtFollow = item.querySelector("span");
                        if (txtFollow.innerText !== val2)
                            txtFollow.innerText = val2;
                        else
                            txtFollow.innerText = val1;
                        // console.log(action);

                        //    action = unFollow;
                        console.log(action);
                        //Do Something
                    },
                    error: function () {
                        //Do Something to handle error
                        console.log("thanh cong roi kia");
                    }
                });
            }
        </script>
        <script>
            function Comment(item, event) {
                var textCmt = item.value;
                if (event.key === "Enter") {



                    $.ajax({
                        url: "ajax/CommnetRecipeAjax",
                        type: "get", //send it through get method
                        data: {
                            txtCmt: textCmt,
                            bakerID: "${sessionScope.login.id}",
                            RecipeID: "${RECIPE_DETAIL.id}"
                        },
                        success: function (response) {
                            //Do Something
                            console.log(response);
                            var cmtShow = document.getElementById("show-comment");
                            cmtShow.innerHTML += response;
                            item.value = "";

                        },
                        error: function (xhr) {
                            console.log("that bai");
                            //Do Something to handle error
                        }
                    });
                }
            }

            function getReport(recipeID) {
                console.log("2");
                var report = $('#report_list');
                var graybox = $('#report_list .gray-box');
                var content = $('#report_list .content');
                graybox.click(() => report.removeClass('d-flex'));
                var exit_button = document.createElement("div").classList.add('exit-btn');
                //load content
                report.addClass('d-flex');
                //
                $('#report_list .exit-btn').click(() => report.removeClass('d-flex'));
            }
        </script>


        <script>
            getReport(2);
        </script>
        <c:import url="footer.jsp"/>
    </body>
</html>