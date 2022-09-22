<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="initial-scale=1, width=device-width" />
        <title></title>
        <meta name="description" content="" />

        <link rel="stylesheet" href="./assets/css/addrecipe.css" />

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
    </head>
    <body>
        <main class="add-recipedone-main">
            <main class="cook2-main">
                <main class="create-recipe-main col-md-6 col-12 align-self-center px-0">
                    <div class="create-recipe-div">
                        <h2 class="text-h2 d-none d-sm-block">
                            <b class="create-recipe-b">Create Recipe</b>
                        </h2>
                        <img class="button-icon6" alt="" src="assets/public/vector2.svg">
                    </div>
                    <button class="save-button" id="addRecipe">
                        <b class="save-b2">Save</b>
                    </button>
                </main>
                <form class="section-div col-12 col-md-6 align-content-center align-self-center"
                      id="addRecipe">
                    <div class="title-div col-12">
                        <b class="title-b2">Title</b>
                        <input name='name' class="input col-12"  type="text" placeholder="Cake's Name " required>
                    </div>
                    <div class="add-video-and-pic col-12">
                        <div class="d-flex col-12 justify-content-between">
                            <button class="button" id="button">
                                <span class="text-b" id="text1">Add video</span>
                            </button>
                            <img class="vector-icon2" alt="" src="assets/public/vector3.svg">
                        </div>
                        <input name='picture1'
                               id="addfile" class="add-picture-input px-3 pt-2" type="file">
                    </div>
                    <div class="description-div col-12">
                        <b class="description-b">Description</b>
                        <textarea class="boxdes-textarea  p-2" placeholder="Add description"></textarea>
                    </div>
                    <div class="ingredient-div col-12">
                        <b class="description-b">Ingredients</b>
                        <input name='igredient'
                               class="igre-screen-input" type="text" placeholder="Add one ingredient">
                    </div>
                    <div class="description-div col-12">
                        <b class="description-b">Instructions</b>
                        <input name='instruction'
                               class="intruc-box-input" type="text" placeholder="Add one ingredient">
                    </div>
                    <div class="time-to-cook-div col">
                        <div class="prepare-time-div col">
                            <div class="prepare-time-div1 col p-0">Prepare Time</div>
                            <input class="pre-box-input col" type="number" placeholder="Minute : 0">
                        </div>
                        <div class="prepare-time-div col">
                            <div class="prepare-time-div1 col p-0">Cook Time</div>
                            <input class="pre-box-input col" type="number" placeholder="Minute :0">
                        </div>
                    </div>
                </div>
            </main>
        </main>
        
        <script>
            var saveButton = document.getElementById("saveButton");
            if (saveButton) {
                saveButton.addEventListener("click", function (e) {
                    window.location.href = "./profile.html";
                });
            }

            var text1 = document.getElementById("text1");
            if (text1) {
                text1.addEventListener("click", function (e) {
                    window.open("./add-video.html");
                });
            }

            var button = document.getElementById("button");
            if (button) {
                button.addEventListener("click", function (e) {
                    window.location.href = "./add-video.html";
                });
            }
        </script>
    </body>
</html>
