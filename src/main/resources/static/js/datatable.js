$("document").ready(function () {
    var rowNumber = 1;
    $.getJSON("/address/all", function (data) {
        $.each(data, function () {
            var table = $('#table-id').DataTable();
            table.row.add([
                rowNumber,
                new Date(parseInt(this.dateTime)).toLocaleString(),
                this.zipCode,
                this.formattedAddress,
                this.latitude,
                this.longitude
            ]).draw(false);
            rowNumber++;
        });
    });
    $('#form-id').submit(function (event) {
        event.preventDefault();
        if (!$.isEmptyObject($('#input-id').val())) {
            var geocodingAPI = "/address?zipcode=" + $('#input-id').val();
            $.getJSON(geocodingAPI, function (data) {
                var tab = $('#table-id').DataTable();
                tab.row.add([
                    rowNumber,
                    new Date(parseInt(data.dateTime)).toLocaleString(),
                    data.zipCode,
                    data.formattedAddress,
                    data.latitude,
                    data.longitude
                ]).draw(false);
                rowNumber++;
            }).fail(function () {
                alert("Non-existent or invalid zipcode");
            });
        } else {
            alert('Please enter your zip code');
        }
    });
});

    