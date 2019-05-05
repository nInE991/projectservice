<#import "*/manager/page.ftl" as a>
<@a.basis>
    <div class="container " style="margin-top: 30px">
        <div class="clearfix">
            <span class="float-left"><h2>Клиенты</h2></span>
            <span class="float-right pr-5">
            <a class=" mt-1  btn btn-dark" href="/manager/customer/add" role="button">Добавить</a>
        </span>
        </div>
        <div class="float-sm-right"></div>
        <table class="table" style="text-align: center ;margin-top: 30px ">
            <thead>
            <tr>
                <th scope="col">Имя</th>
                <th scope="col">Фамилия</th>
                <th scope="col">Телефон</th>
                <th scope="col">Действия</th>
            </tr>
            </thead>
            <#list customerList as customer>
                <tr>
                    <td>
                        <div class="mt-1">${customer.name}</div>
                    </td>
                    <td>
                        <div class="mt-1">${customer.lastname}</div>
                    </td>
                    <td>
                        <div class="mt-1">${customer.telephone}</div>
                    </td>
                    <td>
                        <div class="btn-group">
                            <button type="button" class="btn btn-outline-light text-dark editCustomer"
                                    data-id="${customer.id}"><span class="oi oi-pencil"></span></button>
                            <button type="button" class="btn btn-outline-light text-dark deleteCustomer"
                                    data-id="${customer.id}"><span class="oi oi-clipboard"></span></button>
                        </div>
                    </td>
                </tr>
            </#list>
        </table>
    </div>
</@a.basis>