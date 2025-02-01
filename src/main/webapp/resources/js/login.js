function newUser(userName, userEmail, userPass) {
    var request = $.ajax({
        url: '../view/newUser'
        , type: 'GET'
        , timeout: 999999
        , data: {
            'userName': userName.value,
            'userEmail': userEmail.value,
            'userPass': userPass.value
        }
    });
    request.done(function (response) {
        alert(response.message);
        $("#myModal").removeClass('fade').modal('hide');

    });
    request.fail(function (response) {
        console.log(response.responseJSON);
        alert(response.responseJSON.message);
    });
}