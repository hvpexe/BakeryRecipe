<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="initial-scale=1, width=device-width" />
        <title></title>
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
        <link rel="stylesheet" href="./assets/css/animation.css" />
        <link rel="stylesheet" href="./assets/css/addrecipe.css" />
        <script src="assets/js/Jquery/jquery-core.js"></script>

    </head>
    <body>
        <c:import url="header.jsp"/>

        <main class="add-recipedone-main">
            <main class="cook2-main">
                <main class="create-recipe-main col-md-10 col-12 align-self-center px-0">
                    <div class="create-recipe-div ">
                        <h2 class="text-h2 ">
                            <i class="fas fa-arrow-left"></i>
                            <b class="create-recipe-b d-inline-block ">Create Recipe</b>
                        </h2>
                    </div>
                    <button class="save-button" form="addRecipe">
                        <b class="save-b2">Save</b>
                    </button>
                </main>
                <form class="section-div col-12 col-md-10 align-content-center align-self-center"
                      id="add-recipe">
                    <div class="title-div col-12">
                        <b class="label">Title</b>

                        <input name='name' class="input col-12"  type="text" placeholder="Recipe's Name ">
                    </div>
                    <div class="add-recipe-input col">
                        <b class="label">Description</b>
                        <textarea class="boxdes-textarea  p-2" placeholder="Add description"></textarea>
                        <div>

                        </div>
                        <div class="d-flex col p-0 justify-content-start" style="gap: 10px;">
                            <button class="description-button" disabled="disabled" id="add-video-btn">
                                Add Video <i class="fa-brands fa-youtube"></i>
                            </button>
                            <button class="description-button" disabled="disabled" id="add-img-btn">
                                Add Image <i class="fa-regular fa-image"></i>
                            </button>
                        </div>
                        <div class="display-image col p-0">
                            <div class='image'  src="./"></div>
                            <div class="display-image-options">
                                <div class="fas fa-trash description-button" id='remove-image'></div>
                                <div class="col-5 d-inline-flex"></div>
                                <button class="description-button" disabled="disabled" id="to-cover-btn">
                                    Set As Cover
                                </button>
                                <button class="description-button ml-2" disabled="disabled" id="change-img-btn">
                                    Change Image
                                </button>
                            </div>
                        </div>
                        <div class="video-and-image p-0 col list-group list-group-horizontal" id="img-content">
                            <span class="col-2 list-group-item rounded add-img"></span>
                            <span class="col-2 list-group-item rounded video" id='video'></span>
                            <span class="col-2 list-group-item rounded cover" id='pic2'></span>
                            <span class="col-2 list-group-item rounded" id='pic3'></span>
                            <span class="col-2 list-group-item rounded selected" id='pic4'
                                  style="background-image: url(assets/images/image-29@2x.png);"></span>
                        </div>


                    </div>
                    <div class="add-recipe-input col-12">
                        <b class="label">Ingredients</b>
                        <div class="col p-0" id="ingredient-container">
                            <div class="col p-0 hover-highlight align-items-center p-0 pr-2 border border-secondary" id="item">
                                <img src="assets/images/image-261@2x.png" alt=' ' > 
                                <input name="ingre-name" class="col" disabled value="black grapes">
                                <span>Amount:</span> 
                                <input name="ingre-amount" class="col-2 bg-white ml-2 mr-4" placeholder="1 oz" value=""> 
                                <div class="item-trashbin fas fa-trash ml-auto description-button"></div>
                            </div>
                        </div>
                        <div class="d-flex p-0 col align-items-center" id="ingredient"  >
                            <input class="instruction-box-input col-7 " name='name' id="name" type="text" placeholder="Add one ingredient">
                            <span class="col d-flex align-items-center pr-0">Amount:</span>
                            <input class="instruction-box-input col-3 ml-1" name='amount' id="amount"  type="text" placeholder="1 Oz">
                            <input type="hidden" name="count" value="1">
                        </div>
                    </div>
                    <div class="add-recipe-input col-12">
                        <b class="label">Instructions</b>
                        <div class="col d-block p-0 " id="inst-container" >
                            <div class="col align-items-center p-0 " id="inst">
                                <h5 class="text-secondary col-12 p-0">
                                    Step <span>0</span>
                                    <input name="step" disabled onchange="this.previousElementSibling.innerText = this.value" type="hidden" value="0">
                                </h5>
                                <div class="col hover-highlight  p-0 pr-2 d-flex align-items-center border border-secondary rounded" onclick="showDetail(this.parentElement);">
                                    <div class="inst-img d-inline-flex fas fa-camera position-relative align-items-center justify-content-center" src="assets/images/image-29@2x.png" onclick="this.querySelector('input').click();">
                                        <input name="inst-image" disabled id="inst-image" class="d-none" readonly="" type="file" accept="image/*" 
                                               onchange="changeIngrImg(this.parentElement, window.URL.createObjectURL(this.files[0]), event)">
                                    </div>
                                    <input class="instruction-box-input col " disabled value=""
                                           readonly="" name="inst-description" id="inst-description" type="text">
                                    <div class="item-trashbin fas fa-trash ml-auto description-button" onclick="this.parentElement.parentElement.remove()"></div>
                                </div>
                            </div>
                            
                        </div>

                    </div>
                    <div class="col" id="instruction">
                        <textarea class="instruction-box-input col-11 pt-2 pr-3" name="detail" type="text" placeholder="Paste one or multiple steps (e.g. Finely chop the garlic)"></textarea>
                        <input type="hidden" name="count" value="1">
                        <div class="accept-input fas fa-check d-flex align-items-center justify-content-center col-1 hover-button-1"></div>
                    </div>
                    <div class="time-to-cook-div col">
                        <div class="add-recipe-input col">
                            <div class="label col p-0">Prepare Time</div>
                            <input class="pre-box-input col" type="number"  placeholder="Minute : 0">
                        </div>
                        <div class="add-recipe-input col">
                            <div class="label col p-0">Cook Time</div>
                            <input class="pre-box-input col" type="number" placeholder="Minute :0">
                        </div>
                    </div>
            </main>
        </main>
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
                    <input type="file" class="d-none" onchange="changeIngrImg(this.previousElementSibling, window.URL.createObjectURL(files[0]), event);"> 
                    <div class="change-img-btn mx-auto hover-button-1 col-6 font-weight-bold rounded m-2"
                         onclick="this.previousElementSibling.click()">Change Image</div>
                </div>
                <h5>Instruction</h5>
                <textarea class="rounded col border py-3" value="" style="min-height:7rem"></textarea> 
                <div class="mt-auto d-flex justify-content-end">
                    <div class="cancel-btn hover-button-1 col-auto font-weight-bold rounded m-2">Cancel</div>
                    <div class="save-btn hover-button-1 col-auto font-weight-bold rounded m-2">Save</div>
                </div>
            </div>
        </div>
        <script src="assets/js/addrecipe.js"></script>
        <script src="assets/js/validator.js"></script>
        <script>
//                             showDetail(document.querySelector('#inst1'));
                             ItemCopy({
                                 selector: '#ingredient [name]',
                                 run: (result, container) => {
                                     $(container).append(result);
                                 },
                                 count: '#ingredient [name=count]',
                                 container: '#ingredient-container',
                                 url: 'ajax/GetIngredientImage',
                             });
                             ItemCopy({
                                 selector: '#instruction [name]',
                                 run: (result, container, step) => {
                                     if (step) {
                                         var count = document.querySelector(step);
                                         count.setAttribute('value', parseInt(count.value) + 1);
                                     }
                                     $(container).append(result);
                                     $('#inst-container h5, #inst-container .inst-img, #inst-container .inst-img *\n\
                                                ,#inst-container .item-trashbin, #inst-container .item-trashbin *').click(function (e) {
                                         e.stopPropagation();
                                     });
                                 },
                                 count: '#instruction [name=count]',
                                 url: 'ajax/GetInstructionTemplate',
                                 container: '#inst-container',
                             });
        </script>
    </body>
</html>
