//Modal user-login

$("#forgot-psw").click(function() {
    $("#user-login").modal('hide');
    $("#forgot-password").show();
});



$(function(){ 
     var navMain = $("#nav-main");
     navMain.on("click", "a", null, function () {
         navMain.collapse('hide');
     });
 });


$("#log-in").click(function() {
     var navMain = $("#myNavbar").collapse('hide');
});
