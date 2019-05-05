<#import "./page.ftl" as a>
<@a.basis>
    <div class="container" style="margin-top:30px;">
        <div class="row ">
            <div class="col mx-auto">
                <div class="text-center">
                    <h3>
                        <small>Прайс-лист наших услуг</small>
                    </h3>
                </div>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-8 mx-auto text-center">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>Услуги</th>
                        <th>Цены</th>
                    </tr>
                    </thead>
                    <#list priceList as prices>
                        <tbody>
                        <tr>
                            <td>${prices.name}</td>
                            <td>${prices.price}</td>
                        </tr>
                        </tbody>
                    </#list>
                </table>
            </div>
        </div>
    </div>
</@a.basis>
