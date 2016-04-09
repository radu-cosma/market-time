$('#login-button').click(function() {
	var loginData = {
			'email': $('#email').val(),
			'password': $('#password').val()
		}
    $.ajax({
    	type: 'POST',
        url: '/market-time/rest/login',
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify(loginData),
        success: function(response){  
        	if (response.loggedIn) {
        		window.location = '/market-time/home';
			} else {
				var generalErrorMessage = $('#general-error-message');
				var emailErrorMessage = $('#email-error-message');
				var passwordErrorMessage = $('#password-error-message');
				if (!generalErrorMessage.hasClass('hidden')) {
					generalErrorMessage.addClass('hidden');
				}
				if (!emailErrorMessage.hasClass('hidden')) {
					emailErrorMessage.addClass('hidden');
				}
				if (!passwordErrorMessage.hasClass('hidden')) {
					passwordErrorMessage.addClass('hidden');
				}
				if (response.generalError) {
					generalErrorMessage.html('Login failed. Please check that your email and password are correct.')
					if (generalErrorMessage.hasClass('hidden')) {
						generalErrorMessage.removeClass('hidden');
					}
				}
				if (response.validationErrors && response.validationErrors.email) {
					emailErrorMessage.html('The email cannot be empty.');
					if (emailErrorMessage.hasClass('hidden')) {
						emailErrorMessage.removeClass('hidden');
					}
				}
				if (response.validationErrors && response.validationErrors.password) {
					passwordErrorMessage.html('The password cannot be empty.');
					if (passwordErrorMessage.hasClass('hidden')) {
						passwordErrorMessage.removeClass('hidden');
					}
				}
			}
          },  
          error: function(e){  
        	  var generalErrorMessage = $('#general-error-message');
        	  generalErrorMessage.html.html('Login failed. Please try again later.')
        	  if (generalErrorMessage.hasClass('hidden')) {
        			generalErrorMessage.removeClass('hidden');
        		}
          }  
    })
});
