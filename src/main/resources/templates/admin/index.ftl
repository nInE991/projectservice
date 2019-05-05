<#import "page.ftl" as a>
<@a.basis>
    <div class="container" style="margin-top:50px;">
        <div class="row mx-auto">
            <div class="col-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Пользователи</h5>
                        <div class="btn-group-vertical">
                            <a class="btn btn-link text-left" href="/admin/users/registration" style="color: black">Регистрация</a>
                            <a class="btn btn-link text-left" href="/admin/users" style="color: black">Изменение</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Прайс-Лист</h5>
                        <div class="btn-group-vertical">
                            <a class="btn btn-link  text-left" href="#" style="color: black">Добавление</a>
                            <a class="btn btn-link  text-left" href="#" style="color: black">Изменение</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</@a.basis>

