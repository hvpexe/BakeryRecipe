<%@ taglib prefix="fmt" uri="/WEB-INF/tlds/mycustomtag.tld"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="profile-header">
    <h1 class="info-title">Your Comment: </h1>
</div>
<div class="card border-0 card-group">
        <table border="1" class="table table-hover card-body table-bordered">
            <thead class="text-center">
                <tr>
                    <th class="card-body">#</th>
                    <th class="col-5 card-body">Recipe</th>
                    <th class="col-4 card-body">Comment</th>
                    <th class="col-2 card-body">Date Post</th>
                </tr>
            </thead>
            <tbody>
                <c:set scope="page" value="${RECIPE_LIST}" var="R"/>
                <c:forEach items="${COMMENT_LIST}" var="cm" varStatus="in">
                    <tr class="">
                        <td>
                            <div class="d-flex justify-content-center font-weight-bold">
                                ${in.count}
                            </div>
                        </td>
                        <td>
                            <a href=".\RecipeDetail?recipeID=${R[in.index].id}" class="recipe text-dark d-flex align-items-center c-pointer hover-underline">
                                <img class="p-0 d-inline-block col-2" src="${R[in.index].cover}"/>
                                <span class="col p-0 ml-2">${R[in.index].name}</span>
                            </a>
                        </td>
                        <td>
                            <div class="d-flex align-items-center">
                                ${cm.comment}
                            </div>

                        </td>
                        <td>
                            <div class="d-flex align-items-center flex-wrap">
                                
                                <span class="col">
                                    <fmt:ago value = "${cm.getLastDateEdit()}" />
                                </span>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

</div>