<#macro basis>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <title>Сервисный центр</title>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1" name="viewport">
        <script type="text/javascript" src="/js/jquery-3.4.0.min.js"></script>
        <script type="text/javascript" src="/js/popper.min.js"></script>
        <script type="text/javascript" src="/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="/css/bootstrap.min.css">
        <link href="/open-iconic/font/css/open-iconic-bootstrap.css" rel="stylesheet">
        <style>
            .fakeimg {
                height: 200px;
                background: #aaa;
            }
        </style>
    </head>
    <body>
    <div class="jumbotron text-center" style="margin-bottom:0">
        <h1>Сервисный центр</h1>
        <p>Качественный ремонт компьтерной техники</p>
    </div>
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
        <div class="collapse navbar-collapse " id="collapsibleNavbar">
            <ul class="navbar-nav mr-auto">
            <span class="navbar-text" style="color: aliceblue">
                Панель сотрудника ремонта
            </span>
                <li class="nav-item">
                    <a class="nav-link " href="/employees">Главная</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link " href="/employees/orders">Заказы</a>
                </li>
            </ul>

            <ul class="nav justify-content-end">
                <span class="navbar-text" id="label_username"></span>
                <li class="nav-item">
                    <a class="nav-link" href="/logout" style="color: lightgrey">Выход</a>
                </li>
            </ul>
        </div>
    </nav>
    <#nested>
    <div class="jumbotron text-center" style="margin-top:10%">
        <p>Выпускная квалификационная работа 2019г.</p>
    </div>
    </body>
    <script type="text/javascript" src="/js/employees.js"></script>
    </html>
</#macro>