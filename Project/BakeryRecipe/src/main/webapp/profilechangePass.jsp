<%-- 
    Document   : changePass
    Created on : Sep 23, 2022, 8:39:14 AM
    Author     : VO MINH MAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="initial-scale=1, width=device-width" />
    <title>Change Password</title>
    <meta name="description" content="" />

    <link rel="stylesheet" href="assets/css/changePass.css" />

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
    <div class="changepass-div">
      <div class="section-div">
        <div class="titile-div"><b class="text-b">Change Password</b></div>
        <div class="frame-div1">
            <form action="ChangePasswordController" class="form" role="form" autocomplete="off">
                <div class="current-password-div">
                    <label for="inputPasswordOld">Current Password</label>
                    
                </div>
                <div class="new-password-div">
                    <label for="inputPasswordNew">New Password</label>
                    
                </div>
                <div class="confirm-password-div">
                    <label for="inputPasswordConfirm">Confirm Password</label>
                    
                </div>
                <input class="frame-input" type="password" name="oldPassword" id="inputPasswordOld" required=""/>
                <input class="frame-input1" type="password" name="newPassword" id="inputPasswordNew" required=""/>
                <input class="frame-input2" type="password" name="confirmNewPassword" id="inputPasswordConfirm" required=""/>
                <div>
                    <button type="submit" class="frame-button3" id="frameButton">
                        <b class="save-b2">Save</b>
                    </button>
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

