<#import "*/admin/page.ftl" as a>
<@a.basis>
    <div class="container " style="margin-top: 30px">
        <h2>Изменение данных пользователя</h2>
        <div class="form-group">
            <label for="name">Имя:</label>
            <input type="text" class="form-control" name="name" id="name" value="${employees.name}">
        </div>
        <div class="form-group">
            <label for="lastName">Фамилия:</label>
            <input type="text" class="form-control" name="lastName" id="lastName" value="${employees.lastName}">
        </div>
        <div class="form-group">
            <label for="role">Должность:</label>
            <select type="text" class="form-control roles" name="role">
                <#list rolesList as roles>
                    <option value="${roles.id}">${roles.role}</option>
                </#list>
            </select>
        </div>
        <div class="form-group">
            <label for="birthDate">Дата рождения:</label>
            <input type="date" class="form-control" name="birthDate" id="birthDate"
                   value="${employees.birthDate?date?string('yyyy-MM-dd')}">
        </div>
        <div class="form-group">
            <label for="telephone">Телефон:</label>
            <input type="tel" class="form-control" name="telephone" id="telephone" value="${employees.telephone}">
        </div>

        <div class="form-group">
            <label for="login">Логин:</label>
            <input type="text" class="form-control" name="login" id="login" value="${employees.users.username}">
        </div>
        <div class="form-group">
            <label for="password">Пароль:</label>
            <input type="password" class="form-control" name="password" id="password"
                   value=" ${employees.users.password}">
        </div>
        <button type="submit" class="btn btn-primary userEditSave" data-id="${employees.id}">Сохранить</button>
        <a class="btn" role="button" href="/admin/uses">Отмена</a>
    </div>
    <script type="text/javascript" src="/js/admin.js"></script>
</@a.basis>