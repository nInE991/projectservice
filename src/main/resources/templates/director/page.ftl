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
                    Панель директора
                </span>
                <li class="nav-item">
                    <a class="nav-link " href="/director">Главная</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" id="navbardrop">
                        Отчет по заказам
                    </a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="/director/orders/day">По дню</a>
                        <a class="dropdown-item" href="/director/orders/week">По неделе</a>
                        <a class="dropdown-item" href=/director/orders/month">По месяцу</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" id="navbardrop">
                        Отчет по доходу
                    </a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="/director/cash/day">По дню</a>
                        <a class="dropdown-item" href="/director/cash/week">По неделе</a>
                        <a class="dropdown-item" href="/director/cash/month">По месяцу</a>
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link " href="/director/prices">Прайс-лист</a>
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
    <script type="text/javascript" src="/js/director.js"></script>
    </html>
</#macro>