<#import "*/employees/page.ftl" as a>
<@a.basis>
    <div class="container" style="margin-top:50px;">
        <div class="clearfix">
            <span class="float-left"><h2>Заказы</h2></span>
            </span>
        </div>
        <ul class="nav nav-tabs justify-content-center mt-2" role="tablist">
            <li class="nav-item">
                <a class="nav-link" data-toggle="tab" href="#wait">В ожидании</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" data-toggle="tab" href="#perform">Выполняются</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" data-toggle="tab" href="#done">Выполненые</a>
            </li>
        </ul>
        <div class="tab-content">
            <div class="container tab-pane active" id="wait"><br>
                <table class="table" style="text-align: center ;margin-top: 30px ">
                    <thead>
                    <tr>
                        <th scope="col">Номер заказа</th>
                        <th scope="col">Дата</th>
                        <th scope="col">Название</th>
                        <th scope="col">Услуга</th>
                        <th scope="col">Клиент</th>
                        <th scope="col">Действия</th>
                    </tr>
                    </thead>
                    <#list waitList as order>
                        <tr>
                            <td>
                                <div class="mt-1">${order.id}</div>
                            </td>
                            <td>
                                <div class="mt-1">${order.date}</div>
                            </td>
                            <td>
                                <div class="mt-1">${order.serial}</div>
                            </td>
                            <td>
                                <div class="mt-1">${order.price.name}</div>
                            </td>
                            <td>
                                <div class="mt-1">${order.customer.name} ${order.customer.lastname}</div>
                            </td>
                            <td>
                                <div class="btn-group">
                                    <button class="btn btn-outline-light text-dark getorder" data-id="${order.id}"
                                            type="button"><span class="oi oi-menu"></span></button>
                                    <button class="btn btn-outline-light text-dark deleteOrder" data-id="${order.id}"
                                            type="button"><span class="oi oi-trash"></span></button>
                                </div>
                            </td>
                        </tr>
                    <#else>
                    </#list>
                </table>
            </div>
            <div class="container tab-pane fade" id="perform"><br>
                <table class="table" style="text-align: center ;margin-top: 30px ">
                    <thead>
                    <tr>
                        <th scope="col">Номер заказа</th>
                        <th scope="col">Дата</th>
                        <th scope="col">Название</th>
                        <th scope="col">Услуга</th>
                        <th scope="col">Клиент</th>
                        <th scope="col">Действия</th>
                    </tr>
                    </thead>
                    <#list performList as order>
                        <tr>
                            <td>
                                <div class="mt-1">${order.id}</div>
                            </td>
                            <td>
                                <div class="mt-1">${order.date}</div>
                            </td>
                            <td>
                                <div class="mt-1">${order.serial}</div>
                            </td>
                            <td>
                                <div class="mt-1">${order.price.name}</div>
                            </td>
                            <td>
                                <div class="mt-1">${order.customer.name} ${order.customer.lastname}</div>
                            </td>
                            <td>
                                <div class="btn-group">
                                    <button class="btn btn-outline-light text-dark getorder" data-id="${order.id}"
                                            type="button"><span class="oi oi-menu"></span></button>
                                    <button class="btn btn-outline-light text-dark deleteOrder" data-id="${order.id}"
                                            type="button"><span class="oi oi-trash"></span></button>
                                </div>
                            </td>
                        </tr>
                    <#else>
                    </#list>
                </table>
            </div>
            <div class="container tab-pane fade" id="done"><br>
                <table class="table" style="text-align: center ;margin-top: 30px ">
                    <thead>
                    <tr>
                        <th scope="col">Номер заказа</th>
                        <th scope="col">Дата</th>
                        <th scope="col">Название</th>
                        <th scope="col">Услуга</th>
                        <th scope="col">Клиент</th>
                        <th scope="col">Действия</th>
                    </tr>
                    </thead>
                    <#list doneList as order>
                        <tr>
                            <td>
                                <div class="mt-1">${order.id}</div>
                            </td>
                            <td>
                                <div class="mt-1">${order.date}</div>
                            </td>
                            <td>
                                <div class="mt-1">${order.serial}</div>
                            </td>
                            <td>
                                <div class="mt-1">${order.price.name}</div>
                            </td>
                            <td>
                                <div class="mt-1">${order.customer.name} ${order.customer.lastname}</div>
                            </td>
                            <td>
                                <div class="btn-group">
                                    <button class="btn btn-outline-light text-dark getorder" data-id="${order.id}"
                                            type="button"><span class="oi oi-menu"></span></button>
                                </div>
                            </td>
                        </tr>
                    <#else>
                    </#list>
                </table>
            </div>
        </div>
    </div>
</@a.basis>