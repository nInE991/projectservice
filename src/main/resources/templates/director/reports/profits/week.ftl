<#import "*/director/page.ftl" as a>
<@a.basis>
    <div class="container " style="margin-top: 30px">
        <div class="clearfix">
            <span class="float-left"><h2>Касса</h2></span>
            <span class="float-right pr-5">
             <input class="form-control mt-1" id="myInput" placeholder="Поиск" type="text">
        </span>
        </div>
        <div class="float-sm-right"></div>
        <table class="table" style="text-align: center ;margin-top: 30px ">
            <thead>
            <tr>
                <th scope="col">Дата</th>
                <th scope="col">Неделя</th>
            </tr>
            </thead>
            <tbody id="myTable">
            <#list cashList as date,value >
                <tr>
                    <td>
                        <div class="mt-1">${date}</div>
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
            $("#myInput").on("keyup", function () {
                var value = $(this).val().toLowerCase();
                $("#myTable tr").filter(function () {
                    $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                });
            });
        });
    </script>
</@a.basis>