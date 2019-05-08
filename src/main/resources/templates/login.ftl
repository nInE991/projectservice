<#import "./page.ftl" as a>
<@a.basis>
    <div class="row mt-5">
        <div class="col-4 mx-auto">
            <h3>
                <small>Вход только для сотрудников!</small>
            </h3>
            <form action="/login" method="post">
                <div class="form-group">
                    <label for="login">Логин:</label>
                    <input class="form-control" name="username" id="login" type="text">
                    <div class="valid-feedback">Valid.</div>
                    <div class="invalid-feedback">Please fill out this field.</div>
                </div>
                <div class="form-group">
                    <label for="pwd">Пароль:</label>
                    <input class="form-control" name="password" id="pwd" type="password">
                </div>
                <button class="btn btn-primary btn-block" type="submit">Вход</button>
            </form>
        </div>
    </div>
</@a.basis>