

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="d-flex flex-start mb-4"  id="comment-${cmt.commentID}" >
    <img class="rounded-circle border mr-2"
         src="./assets/images/avt/${cmt.avatar}" alt="avatar"
         width="60" height="60" />
    <div class="card w-100">
        <div class="card-body p-4"> 
            <div class="baseline d-flex">
                <h5 class="col p-0">${cmt.chefName}</h5>
                <!--report comment--> 
                <div class="dropdown">
                    <button ><i class="fa-solid fa-ellipsis"></i></button>
                    <div class="dropdown-options">
                        <c:catch var="ex">
                            <c:if test="${sessionScope.login.id != cmt.userID}">
                                <a   class="d-inline-block col text-muted hover-underline c-pointer mr-3" onclick="getReportComment(${RECIPE_DETAIL.getId()})">
                                    <span class="align-middle"><strong>${re.like}</strong> Report</span>
                                </a>
                            </c:if>
                            <c:if test="${(sessionScope.login.id == cmt.userID || sessionScope.login.role == 'admin')}">
                                <a class="col" onclick="showConfirmBox(${cmt.commentID}, 'comment', '#comment-${cmt.commentID}')" >Delete</a>
                            </c:if>
                        </c:catch>${ex}
                    </div>
                </div>
                <!--ket thuc comment--> 
            </div>
            <p class="small">
            <m:ago value = "${cmt.getDateComment()}" />
            </p>
            <p>
                ${cmt.comment}
            </p>
        </div>
    </div>
</div>