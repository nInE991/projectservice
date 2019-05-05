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
        <div class="collapse navbar-collapse justify-content-center" id="collapsibleNavbar">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="/">
                        <h4>
                            <small>Главная</small>
                        </h4>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/service">
                        <h4>
                            <small>Услуги</small>
                        </h4>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/pricelist">
                        <h4>
                            <small>Прайс-Лист</small>
                        </h4>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/tracking">
                        <h4>
                            <small>Отслеживание заказа</small>
                        </h4>
                    </a>
                </li>
                <li class="nav-item pt-1">
                    <a class="nav-link pt-1" href="/contact">
                        <h4>
                            <small>Контакты</small>
                        </h4>
                    </a>
                </li>
                <li class="nav-item pt-1">
                    <a class="nav-link pt-1" href="/login">
                        <h4>
                            <small>Вход</small>
                        </h4>
                    </a>
                </li>
            </ul>
        </div>
    </nav>
    <#nested>
    <div class="jumbotron text-center mt-5" style="margin-bottom:0">
        <p>Выпускная квалификационная работа 2019г.</p>
    </div>
    </body>
    </html>
</#macro>