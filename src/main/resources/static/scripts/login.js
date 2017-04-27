$('#login-button').click(function() {
    var generalErrorMessage = $('#general-error-message'),
        emailErrorMessage = $('#email-error-message'),
        passwordErrorMessage = $('#password-error-message'), 
        loginData = {
            'email': $('#login-email').val(),
            'password': $('#login-password').val()
        };
    
    $.ajax({
        type: 'POST',
        url: '/market-time/rest/login',
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify(loginData),
        success: function(response) {  
            hide(generalErrorMessage);
            hide(emailErrorMessage);
            hide(passwordErrorMessage);

            if (response.generalError) {
                generalErrorMessage.html('Login failed. Please check that your email and password are correct.')
                show(generalErrorMessage);
            } else if (response.validationErrors) {
                if (response.validationErrors.email) {
                    emailErrorMessage.html('The email cannot be empty.');
                    show(emailErrorMessage);
                }
                if (response.validationErrors.password) {
                    passwordErrorMessage.html('The password cannot be empty.');
                    show(passwordErrorMessage);
                }
            } else if (response.result != undefined && response.result.loggedIn) {
            	var returnUrl = $.urlParam('return');
            	if (returnUrl !== null) {
            		window.location = decodeURIComponent(returnUrl);
            	} else {
            		window.location = '/market-time';
            	}
            }
        },  
        error: function(e) {  
            hide(emailErrorMessage);
            hide(passwordErrorMessage);
            generalErrorMessage.html('Login failed. Please try again later.')
            show(generalErrorMessage);
        }  
    })
});

function show(element) {
    if (element.hasClass('hidden')) {
        element.removeClass('hidden');
    }
}

function hide(element) {
    if (!element.hasClass('hidden')) {
        element.addClass('hidden');
    }
}

$.urlParam = function(name) {
    var results = new RegExp('[\?&]' + name + '=([^]*)').exec(window.location.href);
    if (results == null) {
       return null;
    } else {
       return results[1] || 0;
    }
}