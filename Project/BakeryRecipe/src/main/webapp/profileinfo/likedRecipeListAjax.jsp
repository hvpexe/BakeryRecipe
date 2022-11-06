

<%@page import="utils.Tools"%>
<%@ taglib prefix="mct" uri="/WEB-INF/tlds/mycustomtag.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="profile-header">
    <h1 class="info-title">Liked Recipe:</h1>
</div>
<div class="row col-12 p-0 m-auto border" id="liked-list">
    <c:forEach items="${RECIPE_LIST}" var="r" >
        <div class="col-6 d-flex mt-3 " >
            <div class=" d-flex card-body c-pointer hover-highlight" onclick="window.location ='\RecipeDetail?recipeID=${r.id}'">
                <div class="col-2 d-inline-flex p-0 align-items-start" >
                    <a href=".\RecipeDetail?recipeID=${r.id}" class="col-12 rounded p-0 recipe-img" style="background-image:url(${r.cover})"></a>
                </div>
                <div class="col-10 recipe-content">
                    <a href=".\RecipeDetail?recipeID=${r.id}" class="text-dark h5 font-weight-bold hover-underline">
                        ${r.name}
                    </a>
                    <span class="h5 ">${r.description}</span>
                </div>    
                <div></div>
            </div>    
        </div>
    </c:forEach>
</div>