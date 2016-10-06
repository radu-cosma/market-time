$("#forgot-psw").click(function() {
    $("#user-login").modal('hide');
    $("#forgot-password").show();
});

$(function() { 
	var navMain = $("#nav-main");
	navMain.on("click", "a", null, function () {
		navMain.collapse('hide');
	});
});

$("#log-in").click(function() {
     var navMain = $("#myNavbar").collapse('hide');
});

/*alerts*/



$("#success-alert").show();
window.setTimeout(function () {
    $("#success-alert").slideUp(500, function () {
         $("#success-alert").hide();
     });
}, 5000);



$("#danger-alert").show();
window.setTimeout(function () {
    $("#danger-alert").slideUp(400, function () {
         $("#danger-alert").hide();
     });
}, 4000);