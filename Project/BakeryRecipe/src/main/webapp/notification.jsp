<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:if test="${SHOW_PAGE}">
    <!DOCTYPE html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <c:import url="universal.jsp" />
        <title>Notification</title>
        <script src="assets/js/Jquery/jquery-core.js"></script>
        <link rel="stylesheet" href="assets/css/notification.css"/> 
    </head>

    <body>
        <c:import url="header.jsp"/>
        <section class=" col-12 col-md-6 mx-auto p-0" style="gap:10px">
        </c:if>    
        <main class="col-12 d-flex flex-column p-0" id="notification">
            <div class="notify-title col h4 text-capitalize bg-white font-weight-bold border-bottom py-3 ">
                <span>notification</span>
            </div>
            <div class="col d-flex border-bottom bg-white py-3" style="gap:10px">
                <div class="button-option active hover-button-1 hl-none c-pointer" id="btnAll">All</div>
                <div class="button-option hover-button-1 hl-none c-pointer" id="btnUnread">Unread</div>
            </div>
            <nav class="notify-section bg-white col">
                <% request.setAttribute("LIST", new String[]{"Like", "Comment", "Follow", "RemoveRecipe", "Saved"});%>
                <c:forEach items="${LIST}" var="noti">
                    <c:if test="${noti eq 'Like'}">
                        <a class="notify-item  hover-button-3 seen c-pointer text-decoration-none" href="#">
                            <div class="col d-flex ">
                                <img class="avatar col-1 p-0 rounded-circle" src="assets/images/avt/37.jpg" alt="avatar"/>
                                <div class="notify-content col d-flex flex-column">
                                    <span class="d-block font-weight-bold hover-underline" onclick="location = '#'">SKT T Liệt</span>
                                    <div class="d-flex mt-2" style="gap:8px;">
                                        <i class="d-inline fas fa-heart"></i>
                                        <span class="">Liked your Recipe <span class="font-weight-bold">“Recipe Name”</span></span>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </c:if>
                    <c:if test="${noti eq 'Comment'}">
                        <a class="notify-item hover-button-3 c-pointer text-decoration-none" href="#">
                            <div class="col d-flex">
                                <img class="avatar col-1 p-0 rounded-circle" src="assets/images/avt/binhnguyenthanh19242yahoo.png" alt="avatar"/>
                                <div class="notify-content col d-flex flex-column">
                                    <span class="d-block font-weight-bold hover-underline" onclick="location = '#'">It's Morbin Time</span>
                                    <div class="d-flex mt-2" style="gap:8px;">
                                        <i class="d-inline far fa-eye"></i>
                                        <span>Great Job! <span class="font-weight-bold">It's Morbin Time</span> is now following you</span>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </c:if>
                    <c:if test="${noti eq 'Saved'}">
                        <a class="notify-item hover-button-3 seen c-pointer text-decoration-none" href="#">
                            <div class="col d-flex">
                                <img class="avatar col-1 p-0 rounded-circle" src="assets/images/avt/50.jpg" alt="avatar"/>
                                <div class="notify-content col d-flex flex-column">
                                    <span class="d-block font-weight-bold hover-underline" onclick="location = '#'">Faker</span>
                                    <div class="d-flex mt-2" style="gap:8px;">
                                        <i class="d-inline fas fa-bookmark"></i>
                                        <span><span class="font-weight-bold">Faker</span> has Saved your Recipe </span>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </c:if>
                    <c:if test="${noti eq 'Follow'}">
                        <a class="notify-item hover-button-3 c-pointer text-decoration-none" href="#">
                            <div class="col d-flex">
                                <img class="avatar col-1 p-0 rounded-circle" src="assets/images/avt/15.png" alt="avatar"/>
                                <div class="notify-content col d-flex flex-column">
                                    <span class="d-block font-weight-bold hover-underline" onclick="location = '#'">A Hoàng Wibu</span>
                                    <div class="d-flex mt-2" style="gap:8px;">
                                        <i class="d-inline fas fa-comment-dots"></i>
                                        <span>Commented on your Recipe <span class="font-weight-bold">“Recipe Name”</span></span>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </c:if>
                </c:forEach> 
            </nav>
        </main>
        <script>
            $('#notification #btnAll').click((e)=>{
               $('#notification .notify-item').removeClass('d-none'); 
                $(e.target).addClass('active');
                $('#notification #btnUnread').removeClass('active');
            });
            $('#notification #btnUnread').click((e)=>{
                $(e.target).addClass('active');
                $('#notification #btnAll').removeClass('active');
               $('#notification .notify-item.seen').addClass('d-none'); 
            });
        </script>        
        <c:if test="${SHOW_PAGE}">
        </section>
        <c:import url="footer.jsp"/>
    </main>
</body>
</c:if>    

