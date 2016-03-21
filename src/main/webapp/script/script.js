

// Google map
$(function() {

  "use strict";

  function initialize()
  {
    var mapProp = {
      center: new google.maps.LatLng(46.7910208,23.6524005),
      zoom:9,
      mapTypeId: google.maps.MapTypeId.ROADMAP
    };
    var map = new google.maps.Map(document.getElementById("googleMap"),mapProp);
  }

  google.maps.event.addDomListener(window, 'load', initialize);

});


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
     var navMain = $("#myNavbar");
    // navMain.on("click", "#user-login", null, function () {
         navMain.collapse('hide');
     //});
     $("#forgot-password").modal('hide');
});

