$(document).ready(function () {
    $('.saveNewOrder').on('click', function () {
        $.ajax({
            type: 'POST',
            url: '/manager/orders/add',
            data: {
                serial: $('#serial').val(),
                customers: $('#client').val(),
                price: $('#prices').val(),
                note: $('#note').val(),
            },
            success: function (data) {
                document.location.replace("/manager/orders");
            },
            error: function (xhr, status, error) {
                alert(xhr.responseText);
            }
        });
    });
    $("select.prices").change(function () {
        $('#price').val($(this).children("option:selected").data('price'));
    });
    $('.deleteOrder').change(function () {
        $.ajax({
            type: 'DELETE',
            url: '/manager/orders/' + $(this).data('id'),
            data: {},
            success: function (data) {
                document.location.replace("/manager/orders/");
            },
            error: function (xhr, status, error) {
                alert(xhr.responseText);
            }
        });
    });

    $('.getorder').on('click', function () {
        document.location.replace("/manager/orders/" + $(this).data('id'));
    });
    $('.postWait').on('click', function () {
        $.ajax({
            type: 'POST',
            url: '/manager/orders/' + $(this).data('id'),
            data: {
                status: 1,
            },
            success: function (data) {
                document.location.replace("/manager/orders");
            },
            error: function (xhr, status, error) {
                alert(xhr.responseText);
            }
        });
    });
    $('.postCancel').on('click', function () {
        $.ajax({
            type: 'POST',
            url: '/manager/orders/' + $(this).data('id'),
            data: {
                status: 2,
            },
            success: function (data) {
                document.location.replace("/manager/orders");
            },
            error: function (xhr, status, error) {
                alert(xhr.responseText);
            }
        });
    });
    $('.postFinish').on('click', function () {
        $.ajax({
            type: 'POST',
            url: '/manager/orders/' + $(this).data('id'),
            data: {
                status: 3,
            },
            success: function (data) {
                document.location.replace("/manager/orders");
            },
            error: function (xhr, status, error) {
                alert(xhr.responseText);
            }
        });
    });
    $('.saveNewCustomer').on('click', function () {
        $.ajax({
            type: 'POST',
            url: '/manager/customer/add',
            data: {
                name: $('#name').val(),
                lastName: $('#lastName').val(),
                telephone: $('#telephone').val(),
            },
            success: function (data) {
                document.location.replace("/manager/customer");
            },
            error: function (xhr, status, error) {
                alert(xhr.responseText);
            }
        });
    });
    $('.saveCustomer').on('click', function () {
        $.ajax({
            type: 'POST',
            url: '/manager/customer/' + $(this).data('id'),
            data: {
                name: $('#name').val(),
                lastName: $('#lastName').val(),
                telephone: $('#telephone').val(),

            },
            success: function (data) {
                document.location.replace("/manager/customer");
            },
            error: function (xhr, status, error) {
                alert(xhr.responseText);
            }
        });
    });
    $('.editCustomer').on('click', function () {
        document.location.replace("/manager/customer/" + $(this).data('id'));
    });
    $('.deleteCustomer').on('click', function () {
        $.ajax({
            type: 'DELETE',
            url: '/manager/customer/' + $(this).data('id'),
            data: {},
            success: function (data) {
                document.location.replace("/manager/customer/");
            },
            error: function (xhr, status, error) {
                alert(xhr.responseText);
            }
        });
    });
    $('.phone_with_ddd').mask('+(996) 000 000-000');
});
