<#import "*/director/page.ftl" as a>
<@a.basis>
    <div class="container " style="margin-top: 30px">
        <div class="row mt-3">
            <div class="col-6 mx-auto">
                <h2>Добавить услугу в Прайс-Лист</h2>
                <div class="form-group mt-3">
                    <label for="name">Название услуги:</label>
                    <input class="form-control" id="name" name="name" type="text" value="${prices.name}">
                </div>
                <div class="form-group">
                    <label for="price">Цена:</label>
                    <input class="form-control" id="price" min="0" name="price" step="0.1" type="number"
                           value="${prices.price?c}"
                           onkeypress="return (event.charCode == 8 || event.charCode == 0) ? null : event.charCode >= 48 && event.charCode <= 57">
                </div>
                <div class="text-center">
                    <button class="btn btn-primary savePrice" type="submit" data-id="${prices.id}">Сохранить</button>
                    <a class="btn" href="/admin/prices" role="button">Отмена</a>
                </div>
            </div>
        </div>
    </div>
</@a.basis>
