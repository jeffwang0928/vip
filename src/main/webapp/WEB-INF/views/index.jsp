<%@ page pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title>主页</title>
    <style>
        menu,h1,ul{
            margin: 0;
        }
        html,body{
            margin:0;
            height: 100%;
            font-size: 14px;
        }
        body>header{
            line-height: 80px;
            text-align:center;
            background: #999;
        }
        body>header>h1{
            display: inline;
        }

        .s1{
            position: absolute;
            top:80px;
            bottom:0;
            width:100%;
        }
        .s1>menu{
            position: absolute;
            width: 200px;
            height:100%;
            background: burlywood;
            box-sizing:border-box ;
        }
        .s1>main{
            margin-left: 200px;
            height: 100%;
            width: 100%;
            background:mediumvioletred;
            display: block;
        }
        main>iframe{
            height: 100%;
            width:100%;
            border:0;
            display: block;
        }
    </style>
</head>
<body>
<header>
    <h1>佳佳乐VIP消费查询系统</h1>
    <span>
			<b>${sessionScope.currentUser.name}</b>
            <a href="logout.do">退出登录</a>
        </span>
</header>
<section class="s1">
    <menu>
        <ul>
            <li>
                <a>VIP客户查询</a>
            </li>
            <li>
                <a>录入VIP客户</a>
            </li>
            <li>
                <a>VIP客户管理</a>
            </li>
            <li>
                <a>查看VIP消费记录</a>
            </li>
            <li>
                <a>录入VIP消费记录</a>
            </li>
            <li>
                <a>VIP消费记录管理</a>
            </li>
            <li>
                <a href="updatepassword.do" target="mainFrame">修改密码</a>
            </li>
        </ul>
    </menu>
    <main>
        <iframe name="mainFrame" src="welcome.do"></iframe>
    </main>
</section>


</body>
</html>
