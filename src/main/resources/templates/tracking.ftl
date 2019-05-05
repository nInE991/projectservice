<#import "./page.ftl" as a>
<@a.basis>
    <div class="container" style="margin-top:30px;">
        <div class="row ">
            <div class="col mx-auto">
                <div class="text-center">
                    <h3>
                        <small>Проверьте готовность своего заказа</small>
                    </h3>
                </div>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-4 mx-auto">
                <form action="/track">
                    <div class="form-group">
                        <label for="number">Номер заказа :</label>
                        <input class="form-control" id="number" name="order" type="text">
                    </div>
                    <button class="btn btn-primary btn-block" type="submit">Проверить</button>
                </form>
            </div>
        </div>
    </div>
</@a.basis>
