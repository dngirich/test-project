$("document").ready(function () {
    var counter = 1;
    $.getJSON("/adress/", function (data) {
        $.each(data, function () {
            var t = $('#table-id').DataTable();
            t.row.add([
                counter,
                new Date(parseInt(this.dateTime)).toLocaleString(),
                this.zipCode,
                this.formattedAddress,
                this.latitude,
                this.longitude
            ]).draw(false);
            counter++;
        });
    });
    $('#form-id').submit(function (event) {
        event.preventDefault();
        if (!$.isEmptyObject($('#input-id').val())) {
            var geocodingAPI = "/adress?zipcode=" + $('#input-id').val();
            $.getJSON(geocodingAPI, function (data) {
                var tab = $('#table-id').DataTable();
                tab.row.add([
                    counter,
                    new Date(parseInt(data.dateTime)),
                    data.zipCode,
                    data.formattedAddress,
                    data.latitude,
                    data.longitude
                ]).draw(false);
                counter++;
            }).fail(function () {
                alert("Non-existent or invalid zipcode");
            });
        } else {
            alert('Please enter your zip code');
        }
    });
});

    