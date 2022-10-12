<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="initial-scale=1, width=device-width" />
        <title>recipeDetail</title>

        <link href="assets/css/fontawesome-free-6.1.1-web/css/all.min.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" href="assets/css/web/bootstrap-4.3.1.min.css" />

        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@8/swiper-bundle.min.css" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <link rel="stylesheet" href="assets/css/recipeDetail.css?version=1" />

    </head>

    <body>
        <c:import url="header.jsp"/>
        <c:catch var="e">

            <div class="reccipe-container">
                <!-- head info -->
                <div class="row head-info">
                    <div class="col-md-4 info-img">
                        <div class="swiper">
                            <!-- Additional required wrapper -->
                            <div class="swiper-wrapper">
                                <!-- Slides -->
                                <c:forEach items="${LIST_PIC}" var="cc">
                                    <div class="swiper-slide"><img src="./assets/images/recipe/${cc}" alt=""></div>
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
                                    <div class="btn btn-style1" onclick="followButton(this, 'Follow', 'UnFollow', this.action)" >
                                        <i class="fa-solid fa-user-plus"></i>
                                        <span  class="txt-follow" this="">Follow</span>
                                    </div>

                                </c:if>
                                <!--followButton(this,'Saved','Not Saved')-->
                                <!--followButton(this,'Like','UnLike')-->
                            </span>

<<<<<<< Updated upstream
                        <c:if test="${sessionScope.login.id != USER_DETAIL.getId()}">
                            <div class="react-action">
                                <a href="#" class="btn btn-style1" onclick="followButton(this, 'Like', 'UnLike')"><i class="fa-regular fa-heart"></i> Like</a>
                                &nbsp;
                                <div class="btn btn-style1" onclick="saveButton(this, 'Saved', 'UnSaved', this.action)">
                                    <i class="fa-regular fa-bookmark"></i>
                                    <span  class="txt-follow" this="">Save</span>
                                </div>
=======
                            
                                <div class="first-div">
                                    <c:if test="${sessionScope.login.id == USER_DETAIL.id}">
                                    <span class="text-nowrap">
                                        <a href="#" class="btn btn-style2"><i class="fa-regular fa-pen-to-square"></i> Edit</a>
                                    </span>
                                </c:if>
>>>>>>> Stashed changes
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
                                    <a href="#" class="btn btn-style1" onclick="followButton(this, 'Like', 'UnLike')"><i class="fa-regular fa-heart"></i> Like</a>
                                    &nbsp;
                                    <a href="#" class="btn btn-style1" onclick="followButton(this, 'Saved', 'Not Saved')"><i class="fa-regular fa-bookmark"></i> Save</a>
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
                    <div class="row body-info">
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
                                </div>
                            </div>

                            <div class="instruction-container">
                                <div class="head">
                                    INSTRUCTIONS
                                </div>
                                <div class="body">
                                    <c:forEach items="${requestScope.LIST_STEP}" var="ep">
                                        <div class="instruction">
                                            <div class="step">step : ${ep.getInsstep()}</div>
                                            <p>
                                                ${ep.getDetail()}
                                            </p>
                                        </div>
                                    </c:forEach>

                                </div>
                            </div>
                            <div class="comment-container">
                                <div class="head">
                                    COMMENTS
                                </div>
                                <div class="body">
                                    <div class="card-body p-2 mb-3">
                                        <div class="d-flex flex-start w-100">
                                            <img class="rounded-circle mr-2"
                                                 src="${sessionScope.login.avatar}" alt="avatar"
                                                 width="60" height="60" />
                                            <div class="w-100">
                                                <form action="CommentController">
                                                <div class="form-outline">
                                                    <input class="form-control" id="textAreaExample" rows="4" type="textarea" name="txtCmt">
                                                    <!--<textarea class="form-control" id="textAreaExample" rows="4"></textarea>-->
                                                    <label class="form-label" for="textAreaExample">What is your view?</label>
                                                </div>
                                                <div>
                                                    <button type="button" class="btn btn-style1 float-right">
                                                        Send <i class="fas fa-long-arrow-alt-right ms-1"></i>
                                                    </button>
                                                </div>
                                            </form>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="d-flex flex-start mb-4">
                                        <img class="rounded-circle mr-2"
                                             src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/img%20(32).webp" alt="avatar"
                                             width="60" height="60" />
                                        <div class="card w-100">
                                            <div class="card-body p-4">
                                                <div class="">
                                                    <h5>Johny Cash</h5>
                                                    <p class="small">3 hours ago</p>
                                                    <p>
                                                        Cras sit amet nibh libero, in gravida nulla. Nulla vel metus
                                                        scelerisque
                                                        ante sollicitudin. Cras purus odio, vestibulum in vulputate at,
                                                        tempus
                                                        viverra turpis. Fusce condimentum nunc ac nisi vulputate
                                                        fringilla.
                                                        Donec lacinia congue felis in faucibus ras purus odio,
                                                        vestibulum in
                                                        vulputate at, tempus viverra turpis.
                                                    </p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
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
                                             src="https://thermomidxvietnam.vn/wp-content/themes/yootheme/cache/tiramisu-truyen-thong-9cdd0569.jpeg" />
                                        <div class="bookmark">
                                            Save <i class="fa-regular fa-bookmark"></i>
                                        </div>
                                        <div class="react">
                                            <div>12 likes</div>
                                            <div>12 comments</div>
                                        </div>
                                    </div>
                                    <div class="related-recipe-name">${to}</div>
                                    <div class="recipe-author"><a href="#">Trịnh Thăng Bình</a> 2 day ago</div>
                                </div>
                            </c:forEach>
                            <div class="recipe col-6 col-md-3">
                                <div class="img-container">
                                    <img class="recipe-img" alt=""
                                         src="https://thermomixvietnam.vn/wp-content/themes/yootheme/cache/tiramisu-truyen-thong-9cdd0569.jpeg" />
                                    <div class="bookmark">
                                        Save <i class="fa-regular fa-bookmark"></i>
                                    </div>
                                    <div class="react">
                                        <div>12 likes</div>
                                        <div>12 comments</div>
                                    </div>
                                </div>
                                <div class="related-recipe-name">Mooncake</div>
                                <div class="recipe-author"><a href="#">Trịnh Thăng Bình</a> 2 day ago</div>
                            </div>
                            <div class="recipe col-6 col-md-3">
                                <div class="img-container">
                                    <img class="recipe-img" alt=""
                                         src="https://thermomixvietnam.vn/wp-content/themes/yootheme/cache/tiramisu-truyen-thong-9cdd0569.jpeg" />
                                    <div class="bookmark">
                                        Save <i class="fa-regular fa-bookmark"></i>
                                    </div>
                                    <div class="react">
                                        <div>12 likes</div>
                                        <div>12 comments</div>
                                    </div>
                                </div>
                                <div class="related-recipe-name">Mooncake</div>
                                <div class="recipe-author"><a href="#">Trịnh Thăng Bình</a> 2 day ago</div>
                            </div>
                            <div class="recipe col-6 col-md-3">
                                <div class="img-container">
                                    <img class="recipe-img" alt=""
                                         src="https://thermomixvietnam.vn/wp-content/themes/yootheme/cache/tiramisu-truyen-thong-9cdd0569.jpeg" />
                                    <div class="bookmark">
                                        Save <i class="fa-regular fa-bookmark"></i>
                                    </div>
                                    <div class="react">
                                        <div>12 likes</div>
                                        <div>12 comments</div>
                                    </div>
                                </div>
                                <div class="related-recipe-name">Mooncake</div>
                                <div class="recipe-author"><a href="#">Trịnh Thăng Bình</a> 2 day ago</div>
                            </div>
                            <div class="recipe col-6 col-md-3">
                                <div class="img-container">
                                    <img class="recipe-img" alt=""
                                         src="https://thermomixvietnam.vn/wp-content/themes/yootheme/cache/tiramisu-truyen-thong-9cdd0569.jpeg" />
                                    <div class="bookmark">
                                        Save <i class="fa-regular fa-bookmark"></i>
                                    </div>
                                    <div class="react">
                                        <div>12 likes</div>
                                        <div>12 comments</div>
                                    </div>
                                </div>
                                <div class="related-recipe-name">Mooncake</div>
                                <div class="recipe-author"><a href="#">Trịnh Thăng Bình</a> 2 day ago</div>
                            </div>
                            <div class="recipe col-6 col-md-3">
                                <div class="img-container">
                                    <img class="recipe-img" alt=""
                                         src="https://thermomixvietnam.vn/wp-content/themes/yootheme/cache/tiramisu-truyen-thong-9cdd0569.jpeg" />
                                    <div class="bookmark">
                                        Save <i class="fa-regular fa-bookmark"></i>
                                    </div>
                                    <div class="react">
                                        <div>12 likes</div>
                                        <div>12 comments</div>
                                    </div>
                                </div>
                                <div class="related-recipe-name">Mooncake</div>
                                <div class="recipe-author"><a href="#">Trịnh Thăng Bình</a> 2 day ago</div>
                            </div>
                            <div class="recipe col-6 col-md-3">
                                <div class="img-container">
                                    <img class="recipe-img" alt=""
                                         src="https://thermomixvietnam.vn/wp-content/themes/yootheme/cache/tiramisu-truyen-thong-9cdd0569.jpeg" />
                                    <div class="bookmark">
                                        Save <i class="fa-regular fa-bookmark"></i>
                                    </div>
                                    <div class="react">
                                        <div>12 likes</div>
                                        <div>12 comments</div>
                                    </div>
                                </div>
                                <div class="related-recipe-name">Mooncake</div>
                                <div class="recipe-author"><a href="#">Trịnh Thăng Bình</a> 2 day ago</div>
                            </div>
                            <div class="recipe col-6 col-md-3">
                                <div class="img-container">
                                    <img class="recipe-img" alt=""
                                         src="https://thermomixvietnam.vn/wp-content/themes/yootheme/cache/tiramisu-truyen-thong-9cdd0569.jpeg" />
                                    <div class="bookmark">
                                        Save <i class="fa-regular fa-bookmark"></i>
                                    </div>
                                    <div class="react">
                                        <div>12 likes</div>
                                        <div>12 comments</div>
                                    </div>
                                </div>
                                <div class="related-recipe-name">Mooncake</div>
                                <div class="recipe-author"><a href="#">Trịnh Thăng Bình</a> 2 day ago</div>
                            </div>

                        </div>
                    </div>
                </div>
<<<<<<< Updated upstream
            </div>
        </c:catch> ${e}

        <c:import url="footer.jsp"/>

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
            function  followButton(item, val1, val2,action) {
//                eventac.target.style.backgroundColor = 'white';
//                event.target.classList.toggle("button-Follower");
///
//                console.log(event.target.classList);

var action =val1;
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
            function  saveButton(item, val1, val2,action) {
//                eventac.target.style.backgroundColor = 'white';
//                event.target.classList.toggle("button-Follower");
///
//                console.log(event.target.classList);

var action =val1;
                $.ajax({
                    url: "/ajax/updatesaverecipe",
                    type: "get", //send it through get method
                    data: {
                        recipe: "${RECIPE_DETAIL.getid()}",
                        action: action,
                        user: "${sessionScope.login.id}"
                    },
                    success: function () {
                        console.log(item);
                        item.classList.toggle("button-Follow");

                        let txtSave = item.querySelector("span");
                        if (txtSave.innerText !== val2)
                            txtSave.innerText = val2;
                        else
                            txtSave.innerText = val1;
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
=======
            </c:catch> ${e}

            <c:import url="footer.jsp"/>

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
>>>>>>> Stashed changes
    </body>

</html>