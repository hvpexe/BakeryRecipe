<%-- 
    Document   : test
    Created on : Oct 7, 2022, 4:30:00 PM
    Author     : Admin
--%>

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
       
        <div id="test">scroll to understand</div>

        <div id="wrapper" style="height: 400px; overflow: auto;">
            <div id="content"> </div>
        </div>
         <script>
            // we will add this content, replace for anything you want to add
            var wrapper, content, test;
            var more = '<div style="height:1000px; background:#EEE;"></div>';

            // this is the scroll event handler
            function scroller() {
                // print relevant scroll info
                test.innerHTML = wrapper.scrollTop + " + " + wrapper.offsetHeight + " + 100 > " + content.offsetHeight;

                // add more contents if user scrolled down enough
                if (wrapper.scrollTop + wrapper.offsetHeight + 100 > content.offsetHeight) {
                    content.innerHTML += more; // NK: Here you can make an Ajax call and fetch content to append to content.innerHTML
                }
            }

            wrapper = document.getElementById("wrapper");
            content = document.getElementById("content");
            test = document.getElementById("test");

            content.innerHTML = more;

            // hook the scroll handler to scroll event
            if (wrapper.addEventListener) // NK: Works on all new browsers
                wrapper.addEventListener("scroll", scroller, false);

            else if (wrapper.attachEvent) // NK: Works on old IE
                wrapper.attachEvent("onscroll", scroller);
        </script>
    </body>
</html>
