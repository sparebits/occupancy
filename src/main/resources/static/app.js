var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    var socket = new SockJS('/occupancy');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/occupancy', function (occupancy) {
            showGreeting(JSON.parse(occupancy.body));
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    stompClient.send("/app/hello", {}, JSON.stringify({'name': $("#name").val()}));
}

function showGreeting(occupancy) {
    $("#parkings").append("<tr id=" + occupancy.parkingId + "><td>" + occupancy.parkingId + "</td><td>" + occupancy.freeSpaces + "</td></tr>");
}

$(function () {
    $.get("companies", function( data ) {
        for (var i=0; i< data.item.length; i++) {
            $("#companies").append("<div class='col-md-12' ><h3>" + data.item[i].name + "</h3>");
            $.get("occupancies?companyId=" + data.item[i].id, function(data) {});
        }
    });
    
    
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
});