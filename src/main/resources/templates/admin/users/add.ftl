<#import "*/admin/page.ftl" as a>
<@a.basis>
    <div class="container " style="margin-top: 30px">
        <div class="row mt-3">
            <div class="col-6 mx-auto">
                <h2>Регистрация пользователя</h2>
                <div class="form-group">
                    <label for="name">Имя:</label>
                    <input class="form-control" id="name" name="name" type="text">
                </div>
                <div class="form-group">
                    <label for="lastName">Фамилия:</label>
                    <input class="form-control" id="lastName" name="lastName" type="text">
                </div>
                <div class="form-group">
                    <label>Должность:</label>
                    <select class="form-control roles" name="role" type="text">
                        <option value=""></option>
                        <#list rolesList as roles>
                            <option value="${roles?index}">${roles}</option>
                        </#list>
                    </select>
                    </select>
                </div>
                <div class="form-group">
                    <label for="birthDate">Дата рождения:</label>
                    <input class="form-control" id="birthDate" name="birthDate" type="date">
                </div>
                <div class="form-group">
                    <label for="telephone">Телефон:</label>
                    <input class="form-control phone_with_ddd" id="telephone" name="telephone" type="text"
                           value="+996 ">
                </div>

                <div class="form-group">
                    <label for="login">Логин:</label>
                    <input class="form-control" id="login" name="login" type="text">
                </div>
                <div class="form-group">
                    <label for="password">Пароль:</label>
                    <input class="form-control" id="password" name="password" type="password">
                </div>
                <div class="text-center">
                    <button class="btn btn-primary registration" type="submit">Сохранить</button>
                    <a class="btn" href="/admin/users" role="button">Отмена</a>
                </div>
            </div>
        </div>
    </div>
</@a.basis>
