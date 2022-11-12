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
    </head>

    <body>
        <c:import url="header.jsp"/>
        <section class=" col-12 col-md-6 mx-auto my-3 p-0" style="gap:10px">
        </c:if>    

        <main class="col mx-auto p-0 noselect" id="notification">
            <div class="notify-title col h4 text-capitalize bg-white font-weight-bold border-bottom py-3 ">
                <span>notification</span>
                <c:if test="${not SHOW_PAGE}">
                    <a class=" bg-white m-0 mt-auto text-dark h6" href="notification?receiverID=${sessionScope.login.id}" >View Page</a>
                </c:if>
            </div>
            <div class="col d-flex border-bottom bg-white py-3" style="gap:10px">
                <div class="button-option active hover-button-1 hl-none c-pointer" id="btnAll">All</div>
                <div class="button-option hover-button-1 hl-none c-pointer" id="btnUnread">Unread</div>
            </div>
            <nav class="notify-section  bg-white col">
                <% request.setAttribute("LIST", new String[]{"Like", "Comment", "Follow", "RemoveRecipe", "Saved", "Follow", "RemoveRecipe", "Saved", "Follow", "RemoveRecipe", "Saved", "Follow", "RemoveRecipe", "Saved", "Follow", "RemoveRecipe", "Saved", "Comment", "Follow", "RemoveRecipe", "Saved"});%>


                <!--//real data--> 
                <c:forEach items="${LIST_ALL_NOTIFY}" var="noti">
                    <c:if test="${noti.typeofNotify eq 'like'}">
                        <div onclick="changeType(${noti.notifyID})">
                            <a class="notify-item ${noti.isSeen?'seen':''} hover-button-3 c-pointer text-decoration-none"  onclick="changeType(${noti.notifyID})"  href="RecipeDetail?recipeID=${noti.recipeID}">
                                <div class="col d-flex ">
                                    <img class="avatar  p-0 rounded-circle" src="${noti.coverfSender}" alt="avatar"/>
                                    <div class="notify-content col d-flex flex-column">
                                        <span class="d-block font-weight-bold hover-underline" onclick="location = '#'">${noti.nameofSender}</span>
                                        <div class="d-flex mt-2" style="gap:8px;">
                                            <i class="d-inline fas fa-heart"></i>
                                            <span class="">Liked your Recipe <span class="font-weight-bold">${noti.nameofRecipe}</span></span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </div>
                    </c:if>
                    <c:if test="${noti.typeofNotify eq 'follow'}">
                        <a class="notify-item ${noti.isSeen?'seen':''} hover-button-3 c-pointer text-decoration-none" onclick="changeType(${noti.notifyID})" href="profile?userid=${noti.senderID}" >
                            <div class="col d-flex">
                                <img class="avatar  p-0 rounded-circle" src="${noti.coverfSender}" alt="avatar"/>
                                <div class="notify-content col d-flex flex-column">
                                    <span class="d-block font-weight-bold hover-underline" onclick="location = '#'">${noti.nameofSender}</span>
                                    <div class="d-flex mt-2" style="gap:8px;">
                                        <i class="d-inline far fa-eye"></i>
                                        <span>Great Job! <span class="font-weight-bold">${noti.nameofSender}</span> is now following you</span>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </c:if>
                    <c:if test="${noti.typeofNotify eq 'comment'}">
                        <a class="notify-item ${noti.isSeen?'seen':''}  hover-button-3 c-pointer text-decoration-none" onclick="changeType(${noti.notifyID})" href="RecipeDetail?recipeID=${noti.recipeID}">
                            <div class="col d-flex">
                                <img class="avatar  p-0 rounded-circle" src="${noti.coverfSender}" alt="avatar"/>
                                <div class="notify-content col d-flex flex-column">
                                    <span class="d-block font-weight-bold hover-underline" onclick="location = 'RecipeDetail?recipeID=${noti.recipeID}'">${noti.nameofSender}</span>
                                    <div class="d-flex mt-2" style="gap:8px;">
                                        <i class="d-inline fas fa-comment-dots"></i>
                                        <span>Commented on your Recipe <span class="font-weight-bold">${noti.nameofRecipe}</span></span>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </c:if>
                </c:forEach> 
            </nav>
        </main>
        <script>
            function changeType(value) {
                console.log(value);
                $.ajax({
                    url: "ChangeTypeAjax",
                    type: "get", //send it through get method
                    data: {
                        notifyID: value
                    },
                    success: function () {
                        console.log("thanh cong roi kia");//lam vay chi
                    },
                    error: function () {
                        //Do Something to handle error
                        console.log("co loi roi kia");
                    }
                });
            }

        </script>
        <script>
            $('.notify').removeClass('loading');
            $('#notification #btnAll').click((e) => {
                $('#notification .notify-item').removeClass('d-none');
                $(e.target).addClass('active');
                $('#notification #btnUnread').removeClass('active');
            });
            $('#notification #btnUnread').click((e) => {
                $(e.target).addClass('active');
                $('#notification #btnAll').removeClass('active');
                $('#notification .notify-item.seen').addClass('d-none');
            });
            <c:if test="${U_SIZE>0}">
            $('.header-notification').attr('data-notices', '${U_SIZE}')
            </c:if>
        </script>        
        <c:if test="${SHOW_PAGE}">
        </section>
        ${U_SIZE}
        <c:import url="footer.jsp"/>
    </main>
</body>
</c:if>    

