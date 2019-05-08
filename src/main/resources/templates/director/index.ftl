<#import "*/director/page.ftl" as a>
<@a.basis>
    <div class="container" style="margin-top:50px;">
        <div class="row mx-auto">
            <div class="col-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Отчеты по заказам</h5>
                        <div class="btn-group-vertical">
                            <a class="btn btn-link text-left" href="/director/orders/day" style="color: black">По
                                Дню</a>
                            <a class="btn btn-link  text-left" href="/director/orders/week" style="color: black">По
                                Неделе</a>
                            <a class="btn btn-link  text-left" href="/director/orders/month" style="color: black">По
                                Месяцу</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Отчеты по доходу</h5>
                        <div class="btn-group-vertical">
                            <a class="btn btn-link text-left" href="/director/cash/day" style="color: black">По Дню</a>
                            <a class="btn btn-link  text-left" href="/director/cash/week" style="color: black">По
                                Неделе</a>
                            <a class="btn btn-link  text-left" href="/director/cash/month" style="color: black">По
                                Месяцу</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Прайс-Лист</h5>
                        <div class="btn-group-vertical">
                            <a class="btn btn-link  text-left" href="/director/prices/add" style="color: black">Добавление</a>
                            <a class="btn btn-link  text-left" href="/director/prices"
                               style="color: black">Изменение</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</@a.basis>