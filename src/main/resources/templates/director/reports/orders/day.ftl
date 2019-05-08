<#import "*/director/page.ftl" as a>
<@a.basis>
    <div class="container" style="margin-top:50px;">
        <div class="clearfix">
            <span class="float-left"><h2>Отчет по заказам</h2></span>
            <span class="float-right pr-5">
                <form action="" class="form-inline ">
                    <label class="mb-2 mr-3" for="date">Выберите дату:</label>
                    <input class="form-control mb-2 mr-4" id="date" type="text">
                </form>
            </span>
        </div>
        <div class="float-sm-right"></div>
        <table class="table" style="text-align: center ;margin-top: 30px ">
            <thead>
            <tr>
                <th scope="col">Дата</th>
                <th scope="col">Выполнено заказов</th>
            </tr>
            </thead>
            <tbody id="myTable">
            <#list doneList as date,value>
                <tr>
                    <td>
                        <div class="mt-1">${date?string.iso}</div>
                    </td>
                    <td>
                        <div class="mt-1">${value}</div>
                    </td>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>
    <script>
        $(document).ready(function () {
            $("#date").on("keyup", function () {
                var value = $(this).val().toLowerCase();
                $("#myTable tr").filter(function () {
                    $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                });
            });
        });
    </script>
</@a.basis>