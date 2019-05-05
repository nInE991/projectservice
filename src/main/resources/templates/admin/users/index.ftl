<#import "*/admin/page.ftl" as a>
<@a.basis>
    <div class="container " style="margin-top: 30px">
        <div class="clearfix">
            <span class="float-left"><h2>Список пользователей</h2></span>
            <div class="float-right">
                <div class="float-right">
                    <form class="form-inline">
                        <input class="form-control mt-1" id="myInput" placeholder="Поиск" type="text">
                        <a class=" ml-3 mt-1 mr-3 btn btn-dark" href="/admin/users/registration" role="button">Регистрация</a>
                    </form>
                </div>
            </div>
        </div>
        <div class="container" style="margin-top:50px;">
            <table class="table" style="text-align: center ;margin-top: 30px ">
                <thead>
                <tr>
                    <th scope="col">Логин</th>
                    <th scope="col">Имя</th>
                    <th scope="col">Фамилия</th>
                    <th scope="col">Телефон</th>
                    <th scope="col">Должность</th>
                    <th scope="col">Действия</th>
                </tr>
                </thead>
                <tbody id="myTable">
                <#list employeesList as employees>
                    <tr>
                        <td>
                            <div class="mt-1">${employees.users.username}</div>
                        </td>
                        <td>
                            <div class="mt-1">${employees.name}</div>
                        </td>
                        <td>
                            <div class="mt-1">${employees.lastName}</div>
                        </td>
                        <td>
                            <div class="mt-1">${employees.users.role.role}</div>
                        </td>
                        <td>
                            <div class="mt-1">${employees.telephone}</div>
                        </td>
                        <td>
                            <div class="btn-group">
                                <button class="btn btn-outline-light text-dark editUser" data-id="${employees.id}"
                                        type="button"><span class="oi oi-pencil"></span></button>
                                <button class="btn btn-outline-light text-dark deleteUser" data-id="${employees.id}"
                                        type="button"><span
                                            class="oi oi-trash"></span></button>
                            </div>
                        </td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>
    <script>
        $(document).ready(function () {
            $("#myInput").on("keyup", function () {
                var value = $(this).val().toLowerCase();
                $("#myTable tr").filter(function () {
                    $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                });
            });
        });
    </script>
</@a.basis>
