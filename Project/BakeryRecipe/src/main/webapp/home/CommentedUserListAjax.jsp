<%-- 
    Document   : LikedUserListAjax
    Created on : Oct 27, 2022, 3:19:50 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:if test="${USER_LIST!=null}" var="test"></c:if>
<c:if test="${test}">
    <div class="h3 col-12 text-center">People Commented</div>
    <div class="exit-btn fas fa-x"></div>
    <div class="col-12 mt-3 comment">
        <c:forEach items="${USER_LIST}" var="c">
            <div class="item rounded d-flex my-2 justify-content-start bg-gradient-dark">
                <div>
                    <img class="image mx-3 rounded-circle" src="${c.avatar}">
                </div>
                <div class="">
                    <a class="text-dark hover-underline font-weight-bold" href="./profile?userid=${c.userID}">${c.chefName}</a>
                    <div class="the-comment " onclick="$(this).toggleClass('no-clamp')">${c.comment}</div>
                </div>
            </div>
        </c:forEach>
    </div>
</c:if>
<c:if test="${!test}">
    <script>
        $('#liked-list').removeClass('d-flex');
    </script>
</c:if>
