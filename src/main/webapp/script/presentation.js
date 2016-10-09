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

$("#agent-success-message").show();
window.setTimeout(function () {
    $("#agent-success-message").slideUp(500, function () {
         $("#agent-success-message").hide();
     });
}, 9000);



$("#agent-error-message").show();
window.setTimeout(function () {
    $("#agent-error-message").slideUp(400, function () {
         $("#agent-error-message").hide();
     });
}, 6000);


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
    'phone' : {
        'required' : true,
        'minLength' : 10,
        'maxLength' : 15,
        'regexp' : /^[0-9 ]+$/,
        'messages' : {
            'required' : 'This field is required.',
            'lessThan' : 'Company phone should have at least 10 characters.',
            'moreThan' : 'Company phone should have at most 15 characters',
            'invalidRegexp' : 'Invalid format.'
        }
    }
}

$('form').on('submit', function(evt) {
    var inputIds = $(this).find('input').map(function() {
        return this.id;
    }).get();

    var isValid = validator.validateForm(inputIds, validationConfig);

    if (!isValid) {
        evt.preventDefault();
    }
});
	    