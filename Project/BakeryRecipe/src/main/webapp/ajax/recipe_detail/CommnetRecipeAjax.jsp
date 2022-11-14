

<%@page contentType="text/html" pageEncoding="UTF-8"%>
     <input  type="hidden" id="commentID">
                                        <input type="hidden" id="commentReportID" value="${cmt.commentID}">
                                        <div class="d-flex flex-start mb-4"  id="comment-${cmt.commentID}" >
                                            <img class="rounded-circle border mr-2"
                                                 src="./assets/images/avt/${cmt.avatar}" alt="avatar"
                                                 width="60" height="60" />
                                            <div class="card w-100">
                                                <div class="card-body p-4"> 
                                                    <div class="baseline d-flex">
                                                        <h5 class="col p-0">${cmt.chefName}</h5>
                                                        <!--report comment--> 
                                                        <c:if test="${not empty sessionScope.login.id}">
                                                            <span class="dropdown">
                                                                <a type="text" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true">
                                                                    <i class="fa-solid fa-ellipsis"></i>
                                                                </a>
                                                                <div class="dropdown-menu c-pointer noselect" style="min-width: inherit;" aria-labelledby="dropdownMenuLink">
                                                                    <c:if test="${(sessionScope.login.id == cmt.userID || sessionScope.login.role == 'admin')}">
                                                                        <a class="dropdown-item" onclick="showConfirmBox(${cmt.commentID}, 'comment', '#comment-${cmt.commentID}')" >Delete</a>
                                                                    </c:if>
                                                                </div>
                                                            </span>
                                                        </c:if>

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