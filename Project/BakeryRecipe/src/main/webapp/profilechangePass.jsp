<%-- 
    Document   : changePass
    Created on : Sep 23, 2022, 8:39:14 AM
    Author     : VO MINH MAN
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="initial-scale=1, width=device-width" />
    <title>Change Password</title>
    <meta name="description" content="" />

    <link rel="stylesheet" href="assets/css/changePass.css" />
    <link rel="stylesheet" type="text/css" href="./assets/css/web/bootstrap-4.3.1.min.css">
    <link rel="stylesheet" href="./assets/css/profile.css">
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css2?family=Inter:wght@400;700&display=swap"
    />
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css2?family=Abhaya Libre:wght@700&display=swap"
    />
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css2?family=Abel:wght@400&display=swap"
    />
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css2?family=Gelasio:wght@400;500;700&display=swap"
    />
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css2?family=Beau Rivage:wght@400&display=swap"
    />
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css2?family=Arima Madurai:wght@800&display=swap"
    />
  </head>
  <body>
    <c:import url="header.jsp"/>
    <div class="changepass-div">
      <div class="section-div">
        <div class="titile-div"><b class="text-b">Change Password</b></div>
        <div class="frame-div1">
            <form action="ChangePasswordController" class="form" role="form" autocomplete="off">
                <div class="form-group">
                    <label for="inputPasswordOld">Current Password</label>
                    <input class="form-control" type="password" name="oldPassword" id="inputPasswordOld" required=""/>
                </div>
                <div class="form-group">
                    <label for="inputPasswordNew">New Password</label>
                    <input class="form-control" type="password" name="newPassword" id="inputPasswordNew" required=""/>
                </div>
                <div class="form-group">
                    <label for="inputPasswordConfirm">Confirm Password</label>
                    <input class="form-control" type="password" name="confirmNewPassword" id="inputPasswordConfirm" required=""/>
                </div>
                <div class="form-group">
                    <input type="hidden" name="userID" value="${sessionScope.login.userID}">
                    <button type="submit" class="frame-button3" id="frameButton">
                        <b class="save-b2">Save</b>
                    </button>
                    <c:if test="${not empty requestScope.PASSWORD_ERROR}"><span class="pass-error">${requestScope.PASSWORD_ERROR}</span></c:if>
                    <c:if test="${not empty requestScope.PASSWORD_SUCCESS}"><span class="pass-success">${requestScope.PASSWORD_SUCCESS}</span></c:if>
                </div>
                
            </form>
        </div>
      </div>
    </div>

    <script>
      var frameButton = document.getElementById("frameButton");
      if (frameButton) {
        frameButton.addEventListener("click", function (e) {
          window.location.href = "./profile.html";
        });
      }
      </script>
  </body>
</html>

