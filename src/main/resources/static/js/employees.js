$(document).ready(function () {
    $.ajax({
        type: 'GET',
        url: '/username',
        dataType: 'text',
        success: function (data) {
            $('#label_username').text(data);
        }
    });
    $('.getorder').on('click', function () {
        document.location.replace("/employees/orders/" + $(this).data('id'));
    });
    $('.postPerform').on('click', function () {
        $.ajax({
            type: 'POST',
            url: '/employees/orders/' + $(this).data('id'),
            data: {
                status: 1,
            },
            success: function (data) {
                document.location.replace("/employees/orders");
            },
            error: function (xhr, status, error) {
                alert(xhr.responseText);
            }
        });
    });
    $('.postDone').on('click', function () {
        $.ajax({
            type: 'POST',
            url: '/employees/orders/' + $(this).data('id'),
            data: {
                status: 2,
            },
            success: function (data) {
                document.location.replace("/employees/orders");
            },
            error: function (xhr, status, error) {
                alert(xhr.responseText);
            }
        });
    });
});
