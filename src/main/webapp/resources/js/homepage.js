$.fn.datepicker.defaults.format = "dd/mm/yyyy";
$('.datepicker').datepicker();
$(document).ready(function () {
    $("#myInput").on("keyup", function () {
        var value = $(this).val().toLowerCase();
        $("#tableAppointment tr").filter(function () {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });
    });
});
$('.dropdown-menu').click(function (e) {
    e.stopPropagation();
    if ($(e.target).is('[data-toggle=modal]')) {
        $($(e.target).data('target')).modal()
    }
});

function getDoctor(value) {
    var doctorName = document.getElementById(value + 'doc');
    document.getElementById("doctor").value = doctorName.innerText;
}

function newAppoint(doctor, dtAppoint, email, desc) {
    var request = $.ajax({
        url: '../view/Appointment/'
        , type: 'GET'
        , timeout: 999999
        , data: {
            'doctor': doctor.value,
            'dtAppoint': dtAppoint.value,
            'email': email.value,
            'desc': desc.value
        }
    });
    request.done(function (response) {
        alert(response.message);
        //$("#myModal").removeClass('fade').modal('hide');
        location.replace("HomePage.html");

    });
    request.fail(function (response) {
        console.log(response.responseJSON);
        alert(response.responseJSON.message);
    });
}


function findAllDoctors() {
    var request = $.ajax({
        url: '../view/doctors/'
        , type: 'GET'
        , timeout: 999999
    });
    request.done(function (response) {
        const div = document.querySelector('.dropdown-menu');
        div.innerHTML = "";
        const regions = response.data;
        regions.forEach(region => {
            div.innerHTML += `<a class="dropdown-item" id="${region.id}doc" onclick="getDoctor(${region.id})">${region.name}</a>`;
        })
    });
    request.fail(function (response) {
        console.log(response.responseJSON);
        alert(response.responseJSON.message);
    });
}

function refreshTable() {
    var request = $.ajax({
        url: '../view/grid/'
        , type: 'GET'
        , timeout: 999999
    });
    request.done(function (response) {
        const div = document.querySelector('#tableAppointment');
        div.innerHTML = "";
        const regions = response.data;
        regions.forEach(region => {
            div.innerHTML += ` <tr><td>${region.doctor}</td><td>${region.customer}</td><td>${region.desc}</td><td>${region.dtAppoint}</td></tr>`;
        });
    });
    request.fail(function (response) {
        console.log(response.responseJSON);
        alert(response.responseJSON.message);
    });
}

function logout() {
         location.replace("Login.html");
}