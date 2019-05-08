$(document).ready(function () {
    $.ajax({
        type: 'GET',
        url: '/username',
        dataType: 'text',
        success: function (data) {
            $('#label_username').text(data);
        }
    });
    $('.editPrice').on('click', function () {
        document.location.replace("/director/prices/" + $(this).data('id'));
    });
    $('.deletePrice').on('click', function () {
        $.ajax({
            type: 'DELETE',
            url: '/director/prices/' + $(this).data('id'),
            data: {},
            success: function (data) {
                document.location.replace("/director/prices");
            },
            error: function (xhr, status, error) {
                alert(xhr.responseText);
            }
        });
    });
    $('.saveNewPrice').on('click', function () {
        $.ajax({
            type: 'POST',
            url: '/director/prices/add',
            data: {
                name: $('#name').val(),
                price: $('#price').val(),
            },
            success: function (data) {
                document.location.replace("/director/prices");
            },
            error: function (xhr, status, error) {
                alert(xhr.responseText);
            }
        });
    });
    $('.savePrice').on('click', function () {
        $.ajax({
            type: 'POST',
            url: '/director/prices/' + $(this).data('id'),
            data: {
                name: $('#name').val(),
                price: $('#price').val(),
            },
            success: function (data) {
                document.location.replace("/director/prices");
            },
            error: function (xhr, status, error) {
                alert(xhr.responseText);
            }
        });
    });
});