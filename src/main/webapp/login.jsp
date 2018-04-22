<%@ page pageEncoding="utf-8" %>

<html>
    <head>
        <meta charset="utf-8">
        <title>xxx</title>
    </head>
    <script>
        if(window.top!==window){
            window.top.location.href=window.location.href;
        }
    </script>
<body>
    <strong>${message}</strong>
    <form action="/login.do" method="post">
        <p>
            <label>Account:<input name="account"></label>
        </p>
        <p>
            <label>Password:<input name="password"></label>
        </p>
        <button type="submit">Login</button>


    </form>
    <%session.removeAttribute("message");%>
</body>
</html>
