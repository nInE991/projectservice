<#import "*/admin/page.ftl" as a>
<@a.basis>
    <div class="container " style="margin-top: 30px">
        <div class="clearfix">
            <span class="float-left"><h2>Прайс-лист услуг</h2></span>
            <div class="float-right">
            <span class=" pr-2">
                <a class=" mt-1  btn btn-dark" href="/admin/prices/add" role="button">Добавить</a>
            </span>
            </div>

        </div>
        <div class="container" style="margin-top:50px;">
            <table class="table" style="text-align: center ;margin-top: 30px ">
                <thead>
                <tr>
                    <th scope="col">Название</th>
                    <th scope="col">Цена</th>
                    <th scope="col">Действия</th>
                </tr>
                </thead>
                <#list priceList as prices>
                    <tr>
                        <td>
                            <div class="mt-1">${prices.name}</div>
                        </td>
                        <td>
                            <div class="mt-1">${prices.price}</div>
                        </td>
                        <td>
                            <div class="btn-group">
                                <button class="btn btn-outline-light text-dark editPrice" data-id="${prices.id}"
                                        type="button"><span class="oi oi-pencil"></span></button>
                                <button class="btn btn-outline-light text-dark deletePrice" data-id="${prices.id}"
                                        type="button"><span
                                            class="oi oi-trash"></span></button>
                            </div>
                        </td>
                    </tr>
                </#list>
            </table>
        </div>
    </div>
</@a.basis>