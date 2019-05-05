<#import "*/manager/page.ftl" as a>
<@a.basis>
    <div class="container" style="margin-top:30px;">
        <div class="row mt-3">
            <div class="col-6 mx-auto">
                <h2>Добавить заказ</h2>
                <div class="form-group">
                    <label for="serial">Именование устройства</label>
                    <input class="form-control" id="serial" name="name" type="text">
                </div>
                <div class="form-group">
                    <label for="serial">Клиент</label>
                    <select class="form-control" id="client" name="serial" type="text">
                        <option value=""></option>
                        <#list customerList as customer>
                            <option value="${customer.id}">${customer.name} ${customer.lastname}</option>
                        </#list>
                    </select>
                </div>
                <div class="form-group">
                    <label for="price">Услуга</label>
                    <select class="form-control prices" id="prices" name="prices" type="text">
                        <option value=""></option>
                        <#list priceList as prices>
                            <option data-price="${prices.price?c}" value="${prices.id}">${prices.name}</option>
                        </#list>
                    </select>
                </div>
                <div class="form-group">
                    <label for="price">Цена</label>
                    <input class="form-control" disabled id="price" name="price" type="number">
                </div>
                <div class="form-group">
                    <label for="note">Заметки</label>
                    <input class="form-control" id="note" name="note" type="text">
                </div>
                <div class="text-center">
                    <button class="btn btn-primary saveNewOrder" type="submit">Сохранить</button>
                    <a class="btn" href="/manager/orders" role="button">Отмена</a>
                </div>
            </div>
        </div>
    </div>
</@a.basis>