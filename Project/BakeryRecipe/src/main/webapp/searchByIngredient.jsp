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
                    <form action="searchByIngredient" onkeydown="return event.key != 'Enter'">
                        <label for="tagsList">Ingredients you have:</label>
                        <!-- Create an empty list to hold the tags -->
                        <ul id="tagsList"></ul>
                        <!-- Create a text field for the tags input -->
                        <input type="text" name="txt" class="form-control rounded" id="tagsInput" spellcheck="false"
                               placeholder="Type an ingredient and Hit ENTER" />
                        <button class="btn" type="submit" id="search">Search</button>
                    </form>
                </div>

                <div class="recipe-list">
                    <c:forEach items="${searchByIngre}" var="re">
                        <div class="recipe row">
                            <div class="col-md-3">
                                <div class="img-container">
                                    <img class="recipe-img" alt=""
                                         src="${re.cover}" />
                                    <div class="bookmark">
                                        Save <i class="fa-regular fa-bookmark"></i>
                                    </div>
                                    <div class="react">
                                        <div>${re.like} likes</div>
                                        <div>${re.comment} comments</div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-9">
                                <div class="recipe-detail"> 
                                    <div class="recipe-name">${re.name}</div>
                                    <div class="recipe-author">
                                        <a href="#" class="text-truncate">${re.username} </a>
                                        <c:out value="${re.getDatePostFormat()}"/>
                                    </div>
                                    <div class="ingre-container">
                                        <c:forEach items="${re.ingre}" var="ingre">
                                            <span class="ingre-active">${ingre}</span>
                                        </c:forEach>
                                        <!--<span class="ingre-inactive">Water</span>-->
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>

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