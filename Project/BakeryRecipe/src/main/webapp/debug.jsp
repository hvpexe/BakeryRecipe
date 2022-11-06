<%-- 
    Document   : test
    Created on : Oct 7, 2022, 4:30:00 PM
    Author     : Admin
--%>
<%@page import="dao.RecipeDAO"%>
<%@page import="dto.Recipe"%>
<%@page import="java.util.List"%>
<%@page import="dto.Comment"%>
<%@page import="dao.CommentDAO"%>
<%@page import="utils.Tools"%>
<%@taglib uri="/WEB-INF/tlds/mycustomtag.tld" prefix="mct" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <c:import url="universal.jsp" />
        <title>Notification</title>
        <script src="assets/js/Jquery/jquery-core.js"></script>

    </head>
    <body>
        <%
            List<Recipe> cmtList = RecipeDAO.showRecipeList();
            request.setAttribute("LIST", cmtList);
        %>
        <c:forEach items="${LIST}" var="re" >
            <mct:ago value="${re.getDatePost()}"/><br>
        </c:forEach>
    </body>
</html>
