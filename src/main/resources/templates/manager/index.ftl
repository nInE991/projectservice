<#import "page.ftl" as a>
<@a.basis>
    <div class="container" style="margin-top:50px;">
        <div class="row mx-auto">
            <div class="col-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Заказы</h5>
                        <div class="btn-group-vertical">
                            <a class="btn btn-link text-left" href="/manager/orders" style="color: black">Список</a>
                            <a class="btn btn-link text-left" href="/manager/orders/add"
                               style="color: black">Добавить</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Касса</h5>
                        <div class="btn-group-vertical">
                            <a class="btn btn-link text-left" href="/manager/cash" style="color: black">Список</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Клиенты</h5>
                        <div class="btn-group-vertical">
                            <a class="btn btn-link text-left" href="/manager/customer" style="color: black">Список</a>
                            <a class="btn btn-link text-left" href="/manager/customer/add"
                               style="color: black">Добавить</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</@a.basis>