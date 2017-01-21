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


/*validations*/

var validationConfig = {
    'name' : {
        'required' : true,
        'minLength' : 3,
        'maxLength' : 30,
        'messages' : {
            'required' : 'This field is required.',
            'lessThan' : 'First name should have at least 3 characters.',
            'moreThan' : 'First name should have at most 30 characters',
            'invalidRegexp' : 'Invalid format.'
        }
    },
    'email' : {
        'required' : true,
        'minLength' : 7,
        'maxLength' : 127,
        'regexp' : /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/,
        'messages' : {
            'required' : 'This field is required.',
            'lessThan' : 'Email should have at least 7 characters.',
            'moreThan' : 'Email should have at most 127 characters',
            'invalidRegexp' : 'Invalid email format.'
        }
    },
    'comment' : {
        'required' : true,
        'minLength' : 2,
        'maxLength' : 2000,
        'messages' : {
            'required' : 'This field is required.',
            'lessThan' : 'Comment should have at least 2 characters.',
            'moreThan' : 'Comment should have at most 2000 characters'
        }
    }
}

$('form').on('submit', function(evt) {
    var inputIds = $(this).find('input').map(function() {
        return this.id;
    }).get();

    inputIds.push('comment');
    
    var isValid = validator.validateForm(inputIds, validationConfig);

    if (!isValid) {
        evt.preventDefault();
    }
});
