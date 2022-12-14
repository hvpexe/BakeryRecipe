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
        <c:import url="universal.jsp"/>
        <link href="https://www.cssscript.com/demo/sticky.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="src/simple-tag-input.css" />
    </head>

    <body>
        <c:import url="header.jsp"/>
        <div class="search-ingre">
            <div class="search-section mx-auto ">
                <div class="title-container">
                    <h1 class="notify-title">Search recipes with ingredients</h1>
                </div>

                <div class="search-container">
                    <form action="searchByIngredient" onkeydown="return event.key != 'Enter'">
                        <label for="tagsList">Ingredients you have:</label>
                        <!-- Create an empty list to hold the tags -->
                        <ul id="tagsList"></ul>
                        <!-- Create a text field for the tags input -->
                        <input type="text" class="form-control rounded" id="tagsInput" spellcheck="false"
                               placeholder="Type an ingredient and Hit ENTER" />
                        <button class="btn" type="submit" id="search">Search</button>
                        &nbsp;<span class="text-danger">${ERROR_MESSAGE}</span>
                    </form>
                </div>

                <div class="recipe-list">
                    <c:forEach items="${searchByIngre}" var="re" begin="0" end="19">
                        <c:if test="${re.match > 0}">
                            <div class="recipe row">
                                <div class="col-md-3 col-sm-4">
                                    <div class="img-container">
                                        <a href=".\RecipeDetail?recipeID=${re.id}">
                                            <img class="recipe-img" alt=""
                                                 src="${re.cover}" />
                                        </a>
                                        <div class="react">
                                            <div>${re.like} likes</div>
                                            <div>${re.comment} comments</div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-9 col-sm-8">
                                    <div class="recipe-detail"> 
                                        <div class="recipe-name">${re.name}</div>
                                        <div class="recipe-author">
                                            <a href="#" class="text-truncate">${re.username}</a>
                                            <c:out value="${re.getDatePostFormat()}"/>
                                        </div>
                                        <div class="ingre-container">
                                            <c:forEach items="${re.ingreFound}" var="ingre">
                                                <c:if test="${ingre.value}">
                                                    <span class="ingre-active">${ingre.key}</span>
                                                </c:if>
                                                <c:if test="${!ingre.value}">
                                                    <span class="ingre-inactive">${ingre.key}</span>
                                                </c:if>
                                            </c:forEach>
                                        </div>
                                        <!--                                        
                                        <div class="ingre-container">
                                        <c:forEach items="${re.ingre}" var="ingre">
                                        <span class="ingre-active">${ingre}</span>
                                        </c:forEach>
                                        ${re.match}
                                   </div>-->
                                    </div>
                                </div>
                            </div>
                        </c:if>
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
            %>
                        ingres[++ingres.length] = "<%= element%>";
            <%
                }%>
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