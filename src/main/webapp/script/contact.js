// Google map
$(function() {

	"use strict";

	function initialize() {
		var mapProp = {
				center: new google.maps.LatLng(46.7910208,23.6524005),
				zoom:9,
				mapTypeId: google.maps.MapTypeId.ROADMAP
		};
		var map = new google.maps.Map(document.getElementById("google-map"), mapProp);
	}
	google.maps.event.addDomListener(window, 'load', initialize);
});
