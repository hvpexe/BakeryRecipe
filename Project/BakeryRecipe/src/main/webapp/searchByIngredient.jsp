<%@page import="java.util.List"%>
<%@page import="dao.IngredientDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="initial-scale=1, width=device-width" />
        <title>Community</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Gelasio:wght@400;500;700&display=swap" />
        <link rel="stylesheet" href="assets/css/web/bootstrap-4.3.1.min.css" />
        <link rel="stylesheet" type="text/css" href="./assets/css/fontawesome-free-6.1.1-web/css/all.min.css">
        <link href="https://www.cssscript.com/demo/sticky.css" rel="stylesheet" type="text/css">
        <!-- Load the stylesheet -->
        <link rel="stylesheet" href="src/simple-tag-input.css" />
    </head>

    <body>
        <c:import url="header.jsp"/>
        <div class="search-ingre">
            <div class="search-section mx-auto ">
                <div class="title-container">
                    <h1 class="title">Search recipes with ingredients</h1>
                </div>

                <div class="search-container">
                    <form action="search" onkeydown="return event.key != 'Enter'">
                        <label for="tagsList">Ingredients you have:</label>
                        <!-- Create an empty list to hold the tags -->
                        <ul id="tagsList"></ul>
                        <!-- Create a text field for the tags input -->
                        <input type="text" name="txt" class="form-control rounded" id="tagsInput" spellcheck="false"
                               placeholder="Type an ingredient and Hit ENTER" />
                        <button class="btn" type="button" id="search">Search</button>
                    </form>
                </div>

                <div class="recipe-list">
                    <div class="recipe row">
                        <div class="col-md-3">
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
                        </div>
                        <div class="col-md-9">
                            <div class="recipe-detail"> 
                                <div class="recipe-name">Mooncake</div>
                                <div class="recipe-author">
                                    <a href="#" class="text-truncate">Trịnh Thăng Bình </a>
                                    2 day ago
                                </div>
                                <div class="ingre-container">
                                    <span class="ingre-active">Water</span>
                                    <span class="ingre-active">Water</span>
                                    <span class="ingre-active">Water</span>
                                    <span class="ingre-active">Water</span>
                                    <span class="ingre-active">Water</span>
                                    <span class="ingre-active">Water</span>
                                    <span class="ingre-active">Water</span>
                                    <span class="ingre-active">Water</span>
                                    <span class="ingre-active">Water</span>
                                    <!--<span class="ingre-inactive">Water</span>-->
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
        <c:import url="footer.jsp"/>

        <!-- Load the main JavaScript -->
        <script src="src/simple-tag-input.js"></script>
        <script>
            <% List<String> list = IngredientDAO.getAllIngredients(); %>
                        var ingres = [];
            <% for (String element : list) {
            %> ingres[++ingres.length] = "<%= element%>";
            <% }%>
                        console.log(ingres);
                        let options = {
                            inputEl: "tagsInput",
                            listEl: "tagsList",
                            // enable the autocomplete
                            autocompleteSearchList: ingres
                        };

                        // initialize the tags input, DONE!
                        var tagsInputWithSearch = new simpleTagsInput(options);
        </script>
    </body>