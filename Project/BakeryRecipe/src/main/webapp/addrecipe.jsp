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
                                <input name="ingre-amount" class="col bg-white ml-2 mr-4" placeholder="1 oz" value=""> 
                                <div class="item-trashbin fas fa-trash ml-auto description-button"></div>
                            </div>
                        </div>
                        <div class="d-flex p-0 col align-items-center" id="ingredient" data-count="0" >
                            <input class="instruction-box-input col-7 " name='name' id="name" type="text" placeholder="Add one ingredient">
                            <span class="col d-flex align-items-center pr-0">Amount:</span>
                            <input class="instruction-box-input col-3 ml-1" name='amount' id="amount"  type="text" placeholder="1 Oz">
                        </div>
                    </div>
                    <div class="add-recipe-input col-12">
                        <div id="tes"></div>
                        <b class="label">Instructions</b>
                        <div class="col d-block p-0 " id="inst-container">
                            <div class="col align-items-center p-0 " id="inst">
                                <h5 class="text-secondary col-12 p-0">
                                    Step 0
                                    <input name="step" type="hidden" value="0">
                                </h5>
                                <div class="col hover-highlight p-0 pr-2 d-flex align-items-center border border-secondary rounded"
                                     onclick='showDetail(this)' >
                                    <div class="inst-img d-inline-flex align-items-center justify-content-center" 
                                         onclick="this.querySelector('input').click();"
                                         >
                                        <input name='inst-image'  id='inst-image' class="d-none" readonly type="file" 
                                               accept="image/*" onchange="changeImg(this.parentElement, window.URL.createObjectURL(this.files[0]))">
                                    </div>
                                    <input class="instruction-box-input col " value="detail" readonly name='inst-description' id="inst-description"  type="text">
                                    <div class="item-trashbin fas fa-trash ml-auto description-button"></div>
                                </div>
                            </div>
                        </div>

                    </div>
                    <div class="col" id="instruction">
                        <textarea class="instruction-box-input col pr-3" name='detail' type="text"
                                  placeholder="Paste one or multiple steps (e.g. Finely chop the garlic)"></textarea>
                        <input type="hidden" name="count" value="1">
                        <div class="accept-input fas fa-check d-flex align-items-center justify-content-center hover-button-1" ></div>
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
        <script src="assets/js/addrecipe.js"></script>
        <script src="assets/js/validator.js"></script>
        <script>
                                                   ItemCopy({
                                                       selector: '#ingredient [name]',
                                                       run: (result, container) => {
                                                           $(container).append(result);
                                                       },
                                                       container: '#ingredient-container',
                                                       url: 'ajax/GetIngredientImage',
                                                   });
                                                   ItemCopy({
                                                       selector: '#instruction [name]',
                                                       run: (result, container) => {
                                                           $(container).append(result);
                                                       },
                                                       url: 'ajax/GetInstructionTemplate',
                                                       container: '#inst-container',
                                                   });
        </script>
    </body>
</html>
