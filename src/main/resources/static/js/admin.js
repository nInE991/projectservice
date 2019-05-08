$(document).ready(function () {
    $('.registration').on('click', function () {
        $.ajax({
            type: 'POST',
            url: '/admin//users/registration',
            data: {
                name: $('#name').val(),
                lastName: $('#lastName').val(),
                birthDate: $('#birthDate').val(),
                telephone: $('#telephone').val(),
                login: $('#login').val(),
                password: $('#password').val(),
                roles: $('.roles').val(),
            },
            success: function (data) {
                document.location.replace("/admin/users");
            },
            error: function (xhr, status, error) {
                alert(xhr.responseText);
            }
        });
    });
    $('.editUser').on('click', function () {
        document.location.replace("/admin/users/" + $(this).data('id'));
    });
    $('.deleteUser').on('click', function () {
        $.ajax({
            type: 'DELETE',
            url: '/admin/users/' + $(this).data('id'),
            data: {},
            success: function (data) {
                document.location.replace("/admin/users");
            },
            error: function (xhr, status, error) {
                alert(xhr.responseText);
            }
        });
    });
    $('.deleteUser').on('click', function () {
        $.ajax({
            type: 'DELETE',
            url: '/admin/users/' + $(this).data('id'),
            data: {},
            success: function (data) {
                document.location.replace("/admin/employees");
            },
            error: function (xhr, status, error) {
                alert(xhr.responseText);
            }
        });
    });
    $('.userEditSave').on('click', function () {
        $.ajax({
            type: 'POST',
            url: '/admin/users/' + $(this).data('id'),
            data: {

                name: $('#name').val(),
                lastName: $('#lastName').val(),
                birthDate: $('#birthDate').val(),
                telephone: $('#telephone').val(),
                login: $('#login').val(),
                password: $('#password').val(),
                roles: $('.roles').val()
            },
            success: function (data) {
                document.location.replace("/admin/users");
            },
            error: function (xhr, status, error) {
                alert(xhr.responseText);
            }
        });
    });
    $('.editPrice').on('click', function () {
        document.location.replace("/admin/prices/" + $(this).data('id'));
    });
    $('.deletePrice').on('click', function () {
        $.ajax({
            type: 'DELETE',
            url: '/admin/prices/' + $(this).data('id'),
            data: {},
            success: function (data) {
                document.location.replace("/admin/prices");
            },
            error: function (xhr, status, error) {
                alert(xhr.responseText);
            }
        });
    });
    $('.saveNewPrice').on('click', function () {
        $.ajax({
            type: 'POST',
            url: '/admin/prices/add',
            data: {
                name: $('#name').val(),
                price: $('#price').val(),
            },
            success: function (data) {
                document.location.replace("/admin/prices");
            },
            error: function (xhr, status, error) {
                alert(xhr.responseText);
            }
        });
    });
    $('.savePrice').on('click', function () {
        $.ajax({
            type: 'POST',
            url: '/admin/prices/' + $(this).data('id'),
            data: {
                name: $('#name').val(),
                price: $('#price').val(),
            },
            success: function (data) {
                document.location.replace("/admin/prices");
            },
            error: function (xhr, status, error) {
                alert(xhr.responseText);
            }
        });
    });
    $('.phone_with_ddd').mask('+(996) 000 000-000');
});