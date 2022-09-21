<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="initial-scale=1, width=device-width" />
    <title></title>
    <meta name="description" content="" />

    <link rel="stylesheet" href="./add-recipedone.css" />

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
        <main class="create-recipe-main">
          <div class="create-recipe-div">
            <h2 class="text-h2">
              <b class="create-recipe-b">Create Recipe</b>
            </h2>
            <img class="button-icon6" alt="" src="public/vector2.svg" />
          </div>
          <button class="save-button" id="saveButton">
            <b class="save-b2">Save</b>
          </button>
        </main>
        <div class="section-div">
          <div class="col-md-6-col-12-div">
            <b class="title-b2">Title</b
            ><input
              class="input"
              type="text"
              placeholder="Name's Cake"
              required
            />
          </div>
          <div class="add-video-and-pic">
            <button class="button" id="button">
              <b class="text-b" id="text1">Add video</b></button
            ><input class="add-picture-input" type="file" /><img
              class="vector-icon2"
              alt=""
              src="public/vector3.svg"
            />
          </div>
          <div class="description-div">
            <b class="description-b">Description</b
            ><textarea
              class="boxdes-textarea"
              placeholder="Add description"
            ></textarea>
          </div>
          <div class="ingredient-div">
            <b class="description-b">Ingredients</b
            ><input
              class="igre-screen-input"
              type="text"
              placeholder="Add one ingredient"
            />
          </div>
          <div class="description-div">
            <b class="description-b">Instructions</b
            ><input
              class="intruc-box-input"
              type="text"
              placeholder="Add one ingredient"
            />
          </div>
          <div class="time-to-cook-div">
            <div class="prepare-time-div">
              <div class="prepare-time-div1">Prepare Time</div>
              <input
                class="pre-box-input"
                type="number"
                placeholder="Minute : 0"
              />
            </div>
            <div class="prepare-time-div">
              <div class="prepare-time-div1">Cook Time</div>
              <input
                class="pre-box-input"
                type="number"
                placeholder="Minute :0"
              />
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
