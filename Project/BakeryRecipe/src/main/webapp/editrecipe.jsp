<%@page import="dao.UserDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <link rel="icon" href="./assets/images/logo/logo-title.png" type="image/x-icon">
        <meta name="viewport" content="initial-scale=1, width=device-width" />
        <title>Edit Your Recipe</title>
        <meta name="description" content="" />
        <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css2?family=Inter:wght@400;700&display=swap"
            />
        <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css2?family=Abhaya Libre:wght@700&display=swap"
            />
        <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css2?family=Abel:wght@400&display=swap"
            />
        <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css2?family=Gelasio:wght@400;500;700&display=swap"
            />
        <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css2?family=Beau Rivage:wght@400&display=swap"
            />
        <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css2?family=Arima Madurai:wght@800&display=swap"
            />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@8/swiper-bundle.min.css">
        <link rel="stylesheet" href="./assets/css/animation.css" />
        <link rel="stylesheet" href="./assets/css/editrecipe.css" />
        <script src="assets/js/Jquery/jquery-core.js"></script>

    </head>
    <body>
        <c:import url="header.jsp"/>
        <main class="add-recipedone-main">
            <main class="cook2-main">
                <main class="create-recipe-main col-md-10 col-12 align-self-center px-0">
                    <div class="create-recipe-div ">
                        <h2 class="text-h2" onclick="history.go(-1);">
                            <i class="fas fa-arrow-left"></i>
                            <b class="create-recipe-b d-inline-block ">Your's Recipe</b>
                        </h2>
                    </div>
                    <button class="save-button d-none" id="submit" form="add-recipe" >
                        <b class="save-b2">Save</b>
                    </button>
                    <c:if test="${ADD_RECIPE_SUCCESS !=null}">
                        <div class="text-success h6 my-auto mr-4 font-weight-bold">${ADD_RECIPE_SUCCESS}</div>
                    </c:if>
                    <c:if test="${ADD_RECIPE_FAILED !=null}">
                        <div class="text-danger h6 my-auto mr-4 font-weight-bold">${ADD_RECIPE_FAILED}</div>
                    </c:if>
                    <c:remove scope="session" var="ADD_RECIPE_FAILED"></c:remove>
                    <c:remove scope="session" var="ADD_RECIPE_SUCCESS"></c:remove>
                    </main>
                    <form action="editrecipe"  class="section-div col-12 col-md-10 align-content-center align-self-center"
                          id="add-recipe" enctype="multipart/form-data" method="post" >
                        <input name="recipeid" type="hidden" value="${recipe.id}">
                    <div class="title-div col-12">
                        <b class="label">Title</b>
                        <input name='recipe-name' class="input col-12"  type="text" placeholder="Recipe's Name "
                               value="${recipe.name}">
                        <span class="status"><span>
                                </div>
                                <div class="add-recipe-input col">
                                    <b class="label">Description</b>
                                    <textarea name="recipe-description" class="boxdes-textarea  py-3 col-12" placeholder="Add description">${recipe.description}</textarea>
                                </div>    
                                <!--                Video And Image Picture                            -->
                                <div class="add-recipe-input col" style="gap: 10px;">
                                    <div class="d-flex col p-0 justify-content-start" style="gap: 10px;">
                                        <div class="description-button"  id="add-video-btn">
                                            Add Video <i class="fa-brands fa-youtube"></i>
                                        </div>
                                        <div class="description-button"  id="add-img-btn">
                                            Add Image <i class="fa-regular fa-image"></i>
                                        </div>
                                    </div>
                                    <div class="display-image d-none col p-0" id="display-img">
                                        <div class='image'  src="./">
                                        </div>
                                        <iframe class="video"></iframe>
                                        <div class="display-image-options mb-3">
                                            <div class="fas fa-trash description-button" id='remove-image'></div>
                                            <div class="col-5 d-inline-flex"></div>
                                            <div class="description-button" form="dissabled" id="to-cover-btn">
                                                Set As Cover
                                            </div>
                                            <input type="hidden" name="cover" value="">
                                            <div class="description-button ml-2" form="dissabled" id="change-img-btn">
                                                Change Image
                                            </div>
                                        </div>
                                    </div>
                                    <c:set scope="page" var="check" value="${VIDEO_DETAIL!=null}"/>
                                    <div class="video-and-image swiper ${check?'':'d-none'} col-12 p-0">
                                        <div class="swiper-wrapper col p-0" id="img-content">
                                            <span class="col-2 p-0 swiper-slide hover-button-2 list-group-item rounded add-img"></span>
                                            <c:if test="${empty VIDEO_DETAIL}">
                                                <span class="col-2 d-none p-0 swiper-slide hover-button-2 list-group-item rounded video" onclick="selectContent(this.parentElement, this)">
                                                    <input type="hidden" name="video-url">
                                                </span>
                                            </c:if>
                                            <c:if test="${!(empty VIDEO_DETAIL)}">
                                                <span class="col-2 p-0 swiper-slide hover-button-2 list-group-item rounded video"
                                                      style='background-image: url("https://img.youtube.com/vi/${VIDEO_DETAIL}/0.jpg");'
                                                      onclick="selectContent(this.parentElement, this)">
                                                    <input type="hidden" name="video-url" value="https://www.youtube.com/watch?v=${VIDEO_DETAIL}">
                                                </span>
                                            </c:if>
                                            <c:catch var="e">
                                                <c:forEach items="${LIST_PIC}" var="pic" varStatus="i">
                                                    <span class="col-2 p-0 swiper-slide ${pic.isCover?'cover':''} hover-button-2 list-group-item rounded"
                                                          style='background-image: url("${pic.img}");'
                                                          src="${pic.img}"
                                                          onclick="selectContent(this.parentElement, this)">
                                                        <input type="hidden" name="video-imgpath" class="d-none" value="${pic.img}">
                                                        <input type="file" name="video-image" class="d-none" count="${i.index}">
                                                    </span>
                                                </c:forEach>
                                            </c:catch>
                                        </div>

                                    </div>


                                </div>
                                <!--                INGREDIENTS                            -->
                                <div class="add-recipe-input col-12">
                                    <b class="label">Ingredients</b>
                                    <div class="col p-0" id="ingredient-container">
                                        <c:catch var="e">
                                            <c:forEach items="${LIST_INGREDIENT}" var="il" varStatus="i">
                                                <div class="col p-0  align-items-center p-0 pr-2 border border-secondary" id="item${i.index+1}">
                                                    <img src="${il.img}" alt=" "/> 
                                                    <input name="ingre-name" readonly="" class="col text-capitalize" value="${il.name}">
                                                    <span>Amount:</span> 
                                                    <input name="ingre-amount" class="col-2 bg-white ml-2 mr-4" placeholder="1 oz" value="${il.amount}"/> 
                                                    <div class="item-trashbin fas fa-trash ml-auto description-button" 
                                                         onclick="this.parentElement.remove()">
                                                    </div>
                                                </div>
                                            </c:forEach>
                                        </c:catch>
                                    </div>
                                    <div class="d-flex p-0 col align-items-center" id="ingredient"  >
                                        <input class="instruction-box-input col-7 " form="disabled" name="iname" id="name" type="text" placeholder="Add one ingredient">
                                        <span class="col d-flex align-items-center pr-0">Amount:</span>
                                        <input class="instruction-box-input col-3 ml-1" form="disabled"  name="iamount" id="amount"  type="text" placeholder="1 Piece">
                                        <input type="hidden" name="count" value="${LIST_INGREDIENT.size()}">
                                    </div>
                                </div>                    
                                <!--                INSTRUCTION                            -->
                                <div class="add-recipe-input col-12">
                                    <b class="label">Instructions</b>
                                    <div class="col d-block p-0 " id="inst-container" >
                                        <c:catch var="e">
                                            <div class="col align-items-center p-0 " id="inst">
                                                <h5 class="text-secondary col-12 p-0">
                                                    Step <span>0</span>
                                                    <input name="step" disabled onchange="this.previousElementSibling.innerText = this.value" type="hidden" value="0">
                                                </h5>
                                                <div class="col hover-highlight  p-0 pr-2 d-flex align-items-center border border-secondary rounded" onclick="showDetail(this.parentElement);">
                                                    <div class="inst-img d-inline-flex fas fa-camera position-relative align-items-center justify-content-center" src="assets/images/image-29@2x.png" onclick="this.querySelector('input').click();">
                                                        <input name="inst-image" disabled id="inst-image" class="d-none" readonly="" type="file" accept="image/*" 
                                                               onchange="changeImg(this.parentElement, window.URL.createObjectURL(this.files[0]), event)">
                                                    </div>
                                                    <input class="instruction-box-input col " disabled value=""
                                                           readonly="" name="inst-description" id="inst-description" type="text">
                                                    <div class="item-trashbin fas fa-trash ml-auto description-button" onclick="removeElem(this.parentElement)"></div>
                                                </div>
                                            </div>
                                            <c:forEach items="${LIST_STEP}" var="st" varStatus="i">
                                                ${st}
                                                <div class="col align-items-center p-0 " id="inst${i.index+1}">
                                                    <h5 class="text-secondary col-12 p-0">
                                                        Step <span>${i.index+1}</span>
                                                        <input name="step" onclick="this.previousElementSibling.innerText = this.value" type="hidden" value="${i.index+1}">
                                                    </h5>
                                                    <div class="col hover-highlight  p-0 pr-2 d-flex align-items-center border border-secondary rounded" onclick="showDetail(this.parentElement);">
                                                        <div class="inst-img d-inline-flex ${empty st.img?'fas fa-camera':''} position-relative align-items-center justify-content-center" 
                                                             src="${st.img}" 
                                                             style="background-image:url(${st.img})"
                                                             onclick="this.querySelector('input').click();">
                                                            <input name="inst-image${i.index}" id="inst-image3" class="d-none" readonly="" type="file" accept="image/*" onchange="changeImg(this.parentElement, window.URL.createObjectURL(this.files[0]), event)">
                                                        </div>
                                                        <textarea class="instruction-box-input col " value="${st.detail}" readonly="" name="inst-description" id="inst-description${i.index}" type="text">${st.detail}</textarea>
                                                        <div class="item-trashbin fas fa-trash ml-auto description-button" onclick="removeElem(this.parentElement)"></div>
                                                    </div>
                                                </div>
                                            </c:forEach>
                                        </c:catch>
                                        ${e}
                                    </div>

                                </div>
                                <div class="col" id="instruction">
                                    <textarea class="instruction-box-input col-11  py-3 pr-3" form="disabled" name="idetail" type="text" placeholder="Paste one or multiple steps (e.g. Finely chop the garlic)"></textarea>
                                    <input type="hidden" name="count" value="${LIST_STEP.size()}">
                                    <div class="accept-input fas fa-check d-flex align-items-center justify-content-center col-1 hover-button-1"></div>
                                </div>
                                <!-- Prepare Time and Cook Time-->
                                <div class="time-to-cook-div col">
                                    <div class="add-recipe-input col">
                                        <label class="label col p-0">Prepare Time</label>
                                        <input class="pre-box-input col" type="number" name="prepare-time" value="${recipe.prepTime}" placeholder="30">
                                    </div>
                                    <div class="add-recipe-input col">
                                        <label class="label col p-0">Cook Time</label>
                                        <input class="pre-box-input col" type="number" name="cook-time" value="${recipe.cookTime}" placeholder="30">
                                    </div>
                                </div>
                                <div class="save-button ml-auto" onclick="submitForm('form#add-recipe')">
                                    <b class="save-b2">Add recipe</b>
                                </div>
                                </form>

                                </main>
                                </main>
                                <!--Detail Showing Video and image config-->
                                <div class="d-none" id="img-box" viewing="#img1">
                                    <div class="gray-box"></div>
                                    <div class="exit-btn "></div>
                                    <div class="container col col-md-5 p-3 rounded p-0">
                                        <div class="col-12 row justify-content-center align-content-center m-auto">
                                            <div class="video h4 font-weight-bold">Add Video</div>
                                            <i class="fas fa-youtube col-12 text-center pt-4 text-danger h3" style="font-family: 'Font Awesome 5 Brands' "></i>                
                                            <div class="col-12 p-0 my-4 d-flex justify-content-between align-items-center flex-wrap">
                                                <span class="h6 col-2 p-0 m-0">URL: </span>
                                                <input class="col-10 p-2" placeholder="Input Your Youtube URL" name="vurl">
                                                <div class="status w-100"></div>
                                            </div>
                                            <div class="col-12 d-flex justify-content-end">
                                                <div class="cancel-btn hover-button-1 col-auto font-weight-bold rounded m-2">Cancel</div>
                                                <div class="save-btn hover-button-1 col-auto font-weight-bold rounded m-2">Save</div><!-- comment -->
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!--Detail Showing item detail-->
                                <div class="d-none" id="detail" viewing="#inst">
                                    <div class="gray-box"></div>
                                    <div class="exit-btn"></div>
                                    <div class="container col col-md-6 p-3 rounded">
                                        <h4 class="step">Step <span>0</span>
                                            <input type="hidden" name="step" onclick="this.previousElementSibling.innerText = this.value" value="0">
                                        </h4>
                                        <div class="col-10 mx-auto my-2 d-flex flex-column align-items-center">
                                            <img class="col p-0 rounded mx-auto" src="assets/images/rectangle-20@2x.png" alt="Image not found" id="detail-image" >
                                            <input type="file" class="d-none" onchange="changeImg(this.previousElementSibling, window.URL.createObjectURL(files[0]), event);"> 
                                            <div class="change-img-btn mx-auto hover-button-1 col-6 font-weight-bold rounded m-2"
                                                 onclick="this.previousElementSibling.click()">Change Image</div>
                                        </div>
                                        <h5>Instruction</h5>
                                        <textarea class="rounded col border py-3 "  value="" style="min-height:7rem"></textarea> 
                                        <div class="mt-auto d-flex justify-content-end">
                                            <div class="cancel-btn hover-button-1 col-auto font-weight-bold rounded m-2">Cancel</div>
                                            <div class="save-btn hover-button-1 col-auto font-weight-bold rounded m-2">Save</div>
                                        </div>
                                    </div>
                                </div>
                                <script src="https://cdn.jsdelivr.net/npm/swiper@8/swiper-bundle.min.js"></script>
                                <script src="assets/js/validator.js"></script>
                                <script src="assets/js/editrecipe.js"></script>
                                <script></script>
                                </body>
                                </html>
