<#import "*/manager/page.ftl" as a>
<@a.basis>
    <div class="container" style="margin-top:50px;">
        <div class="row mt-3">
            <div class="col-6 mx-auto">
                <h2>Изменить данные клиента</h2>
                <div class="form-group">
                    <label for="lastName">Фамилия </label>
                    <input class="form-control" id="lastName" name="name" type="text" value="${customer.lastname}">
                    <label for="name">Имя</label>
                    <input class="form-control" id="name" name="name" type="text" value="${customer.name}">
                </div>
                <div class="form-group">
                    <label for="telephone">Телефон:</label>
                    <input class="form-control phone_with_ddd" id="telephone" name="telephone" type="text"
                           value="${customer.telephone}">
                </div>
                <div class="text-center">
                    <button class="btn btn-primary saveCustomer" type="submit" data-id="${customer.id}">Сохранить
                    </button>
                    <a class="btn" href="/manager/customer" role="button">Отмена</a>
                </div>
            </div>
        </div>
    </div>
</@a.basis>