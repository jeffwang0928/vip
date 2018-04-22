<%@page pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <strong>${message}</strong>
    <form action="/updatepassword.do" method="post">
        <p>
            <label>旧密码:<input name="oldPassword"></label>
        </p>
        <p>
            <label>新密码:<input name="newPassword"></label>
        </p>
        <p>
            <label>确认密码:<input name="newPasswordConfirm"></label>
        </p>

        <button type="submit">确定</button>
        <a href="welcome.jsp">返回</a>

    </form>
</body>
</html>