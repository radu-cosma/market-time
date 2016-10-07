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

$("#success-message").show();
window.setTimeout(function () {
    $("#success-message").slideUp(500, function () {
         $("#success-message").hide();
     });
}, 9000);



$("#gen-error-message").show();
window.setTimeout(function () {
    $("#gen-error-message").slideUp(400, function () {
         $("#gen-error-message").hide();
     });
}, 6000);

