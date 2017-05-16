<%@ page language="java" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>



    <base href="<%=basePath%>"/>
    <script type="text/javascript" src="../js/jquery-1.4.2.min.js"></script>

    <script type="text/javascript">
        $().ready(function () {
            redirect();
        });
        function redirect() {
            parent.window.location.href = "/login.action";
        }
    </script>
</head>
</html>