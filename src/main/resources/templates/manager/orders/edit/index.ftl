<#import "*/manager/page.ftl" as a>
<@a.basis>
    <div class="container w-75" style="margin-top:30px;">
        <div class="row mt-3">
            <div class="col-8 mx-auto">
                <div class="row">
                    <div class="col">
                        <h2>Заказ № ${order.id}</h2>
                    </div>
                    <div class="col mx-auto">
                        <div class="p-2"><b>Статус:</b> ${order.status.note}</div>
                    </div>

                </div>
                <div class="row">
                    <div class="col ml-3 p-2">
                        <b>Дата регистрации :</b>
                    </div>
                    <div class="col p-2">${order.date}</div>
                </div>
                <div class="row">
                    <div class="col ml-3 p-2">
                        <b>Дата выдачи клиенту :</b>
                    </div>
                    <div class="col p-2">
                        <#if order.endDate??>
                            ${order.endDate}
                        <#else>
                        </#if>
                    </div>
                </div>
                <div class="row">
                    <div class="col ml-3 p-2">
                        <b>Наименование устройства :</b>
                    </div>
                    <div class="col p-2">${order.serial}</div>
                </div>
                <div class="row">
                    <div class="col ml-3 p-2">
                        <b>Клиент :</b>
                    </div>
                    <div class="col p-2">${order.customer.name} ${order.customer.lastname}</div>
                </div>
                <div class="row">
                    <div class="col ml-3 p-2">
                        <b>Телефон :</b>
                    </div>
                    <div class="col p-2">${order.customer.telephone}</div>
                </div>
                <div class="row">
                    <div class="col ml-3 p-2">
                        <b>Услуга :</b>
                    </div>
                    <div class="col p-2">${order.price.name}</div>
                </div>
                <div class="row">
                    <div class="col ml-3 p-2">
                        <b>Цена :</b>
                    </div>
                    <div class="col p-2">${order.price.price}</div>
                </div>
                <div class="row">
                    <div class="col ml-3 p-2">
                        <b>Заметки :</b>
                    </div>
                    <div class="col p-2">${order.note}</div>
                </div>
                <div class="row mt-3">
                    <div class="col">
                        <div class="text-center">
                            <#if order.status.id==1>
                                <a class="btn btn-success text-white postWait" data-id="${order.id}" role="button">Передать
                                    на ремонт</a>
                            </#if>
                            <#if order.status.id==4&&!order.finish||order.status.id==5&&!order.finish>
                                <a class="btn btn-success text-white postFinish" data-id="${order.id}" role="button">Выдать
                                    клиенту</a>
                            </#if>
                            <#if order.status.id==1||order.status.id==2>
                                <a class="btn btn-danger  text-white postCancel" data-id="${order.id}" role="button">Отменить</a>
                            </#if>
                            <a class="btn btn-secondary" href="/manager/orders" role="button">Назад</a>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</@a.basis>