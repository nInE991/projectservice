<#import "./page.ftl" as a>
<@a.basis>
    <div class="container " style="margin-top: 30px">
        <div class="row">
            <div class="col mx-auto">
                <#list orderHistory>
                    <table class="table" style="text-align: center ;margin-top: 30px ">
                        <thead>
                        <tr>
                            <th scope="col">Дата</th>
                            <th scope="col">Описание</th>
                        </tr>
                        </thead>
                        <tbody id="myTable">
                        <#items as orderH>
                        <tr>
                            <td>
                                <div class="mt-1">${orderH.date?date}</div>
                            </td>
                            <td>
                                <div class="mt-1">${orderH.note}</div>
                            </td>
                            </#items>
                        </tbody>
                    </table>
                <#else>
                    <div class="text-center">
                        <h3>
                            <small>Заказ не существует!</small>
                        </h3>
                        <a class="btn btn-link" href="/tracking">Назад</a>
                    </div>
                </#list>
            </div>
        </div>
    </div>
</@a.basis>
