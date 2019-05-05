<#import "*/admin/page.ftl" as a>
<@a.basis>
    <div class="container " style="margin-top: 30px">
        <div class="row mt-3">
            <div class="col-6 mx-auto">
                <h2>Добавить услугу в Прайс-Лист</h2>
                <div class="form-group mt-3">
                    <label for="name">Название услуги:</label>
                    <input class="form-control" id="name" name="name" type="text">
                </div>
                <div class="form-group">
                    <label for="price">Цена:</label>
                    <input class="form-control" id="price" name="price" step="0.1" type="number">
                </div>
                <div class="text-center">
                    <button class="btn btn-primary saveNewPrice" type="submit">Сохранить</button>
                    <a class="btn" href="/admin/prices" role="button">Отмена</a>
                </div>
            </div>
        </div>
    </div>
</@a.basis>
