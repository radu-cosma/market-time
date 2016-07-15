var validationConfig = {
	'first-name' : {
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
	'last-name' : {
		'required' : true,
		'minLength' : 3,
		'maxLength' : 30,
		'messages' : {
			'required' : 'This field is required.',
			'lessThan' : 'Last name should have at least 3 characters.',
			'moreThan' : 'Last name should have at most 30 characters',
			'invalidRegexp' : 'Invalid format.'
		}
	},
	'company-name' : {
		'required' : true,
		'minLength' : 3,
		'maxLength' : 30,
		'messages' : {
			'required' : 'This field is required.',
			'lessThan' : 'Company name should have at least 3 characters.',
			'moreThan' : 'Company name should have at most 30 characters',
			'invalidRegexp' : 'Invalid format.'
		}
	},
	'company-address' : {
		'required' : true,
		'minLength' : 3,
		'maxLength' : 100,
		'messages' : {
			'required' : 'This field is required.',
			'lessThan' : 'Company address should have at least 3 characters.',
			'moreThan' : 'Company address should have at most 100 characters',
			'invalidRegexp' : 'Invalid format.'
		}
	},
	'company-phone' : {
		'required' : true,
		'minLength' : 10,
		'maxLength' : 15,
		'regexp' : /^[0-9 \+\-\(\)]+$/,
		'messages' : {
			'required' : 'This field is required.',
			'lessThan' : 'Company phone should have at least 10 characters.',
			'moreThan' : 'Company phone should have at most 15 characters',
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
	'confirm-email' : {
		'required' : true,
		'minLength' : 7,
		'maxLength' : 127,
		'regexp' : /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/,
		'mirror' : 'email',
		'messages' : {
			'required' : 'This field is required.',
			'lessThan' : 'Email should have at least 7 characters.',
			'moreThan' : 'Email should have at most 127 characters',
			'invalidRegexp' : 'Invalid email format.',
			'mirror' : 'Emails should match.'
		}
	},
	'profile-current-password' : {
		'required' : true,
		'minLength' : 8,
		'maxLength' : 63,
		'regexp' : /^[a-zA-Z0-9!\(\)\*\+,\-\/\.:;=@\[\]\_\{\}\\?!]+$/,
		'messages' : {
			'required' : 'This field is required.',
			'lessThan' : 'Password should have at least 8 characters.',
			'moreThan' : 'Password should have at most 63 characters',
			'invalidRegexp' : 'Invalid format.'
		}
	},
	'email-current-password' : {
		'required' : true,
		'minLength' : 8,
		'maxLength' : 63,
		'regexp' : /^[a-zA-Z0-9!\(\)\*\+,\-\/\.:;=@\[\]\_\{\}\\?!]+$/,
		'messages' : {
			'required' : 'This field is required.',
			'lessThan' : 'Password should have at least 8 characters.',
			'moreThan' : 'Password should have at most 63 characters',
			'invalidRegexp' : 'Invalid format.'
		}
	},
	'password-current-password' : {
		'required' : true,
		'minLength' : 8,
		'maxLength' : 63,
		'regexp' : /^[a-zA-Z0-9!\(\)\*\+,\-\/\.:;=@\[\]\_\{\}\\?!]+$/,
		'messages' : {
			'required' : 'This field is required.',
			'lessThan' : 'Password should have at least 8 characters.',
			'moreThan' : 'Password should have at most 63 characters',
			'invalidRegexp' : 'Invalid format.'
		}
	},
	'new-password' : {
		'required' : true,
		'minLength' : 8,
		'maxLength' : 63,
		'regexp' : /^[a-zA-Z0-9!\(\)\*\+,\-\/\.:;=@\[\]\_\{\}\\?!]+$/,
		'messages' : {
			'required' : 'This field is required.',
			'lessThan' : 'Password should have at least 8 characters.',
			'moreThan' : 'Password should have at most 63 characters',
			'invalidRegexp' : 'Invalid format.'
		}
	},
	'confirm-password' : {
		'required' : true,
		'minLength' : 8,
		'maxLength' : 63,
		'regexp' : /^[a-zA-Z0-9!\(\)\*\+,\-\/\.:;=@\[\]\_\{\}\\?!]+$/,
		'mirror' : 'new-password',
		'messages' : {
			'required' : 'This field is required.',
			'lessThan' : 'Password should have at least 8 characters.',
			'moreThan' : 'Password should have at most 63 characters',
			'invalidRegexp' : 'Invalid format.',
			'mirror' : 'Passwords should match.'
		}
	}
}

/**
 * Submit customer profile form
 */
$('#customer-profile-form').on('submit', function(evt) {
	evt.preventDefault();
	
	var isValid = validateForm(this, evt);
	
	if (isValid) {
		var profileData = {},
			generalErrorMessage = $('#general-error-message'),
			successMessage = $('#success-message'), 
			button = $('#update-profile-button');
		button.prop('disabled', true);
		loadingScreen.display();

		$(this).find(':input:not(button)').each(function(i, el) {
			profileData[$(el).attr('name')] = $(el).val();
		});
		 
	    $.ajax({
	    	type: 'POST',
	        url: '/market-time/rest/profile/updateProfile',
	        dataType: 'json',
	        contentType: 'application/json',
	        data: JSON.stringify(profileData),
	        success: function(response) {
	        	if (response.generalError) {
	        		hide(successMessage);
	        		generalErrorMessage.html(response.generalError);
	        		show(generalErrorMessage);
	        	} else if (response.validationErrors) {
	        		hide(successMessage);
	        		for (var e in response.validationErrors ) {
	        			var inputId = toId(e);
	        			$('#' + inputId).toggleClass('has-error', true);
        				$('#' + inputId + '-tooltip').text(response.validationErrors[e]);
	        		}
	        	} else {
	        		hide(generalErrorMessage);
	        		successMessage.html('Profile data updated successfully.');
	        		show(successMessage);
	        		
	        		$('#first-name-info').text($('#first-name').val());
	        		$('#last-name-info').text($('#last-name').val());
	        		$('#company-name-info').text($('#company-name').val());
	        		$('#company-address-info').text($('#company-address').val());
	        		$('#company-phone-info').text($('#company-phone').val());
	        		
	        		hide($('#customer-profile-form'));
	        		show($('#customer-profile-info'));
	        	}
	        	loadingScreen.destroy();
	        	button.prop('disabled', false);
	        },  
	        error: function(e) {  
	        	generalErrorMessage.html('Something went wrong. Please try again later.')
	        	show(generalErrorMessage);
	        	loadingScreen.destroy();
	        	button.prop('disabled', false);
	        }  
	    })
	}
});

/**
 * Submit customer email form
 */
$('#customer-email-form').on('submit', function(evt) {
	evt.preventDefault();
	
	var isValid = validateForm(this, evt);
	
	if (isValid) {
		var emailData = {},
			generalErrorMessage = $('#general-error-message'),
			successMessage = $('#success-message'), 
			button = $('#update-email-button');
		button.prop('disabled', true);
		loadingScreen.display();

		$(this).find(':input:not(button)').each(function(i, el) {
			profileData[$(el).attr('name')] = $(el).val();
		});
		 
	    $.ajax({
	    	type: 'POST',
	        url: '/market-time/rest/profile/updateEmail',
	        dataType: 'json',
	        contentType: 'application/json',
	        data: JSON.stringify(emailData),
	        success: function(response) {
	        	if (response.generalError) {
	        		hide(successMessage);
	        		generalErrorMessage.html(response.generalError);
	        		show(generalErrorMessage);
	        	} else if (response.validationErrors) {
	        		hide(successMessage);
	        		for (var e in response.validationErrors ) {
	        			var inputId = toId(e);
	        			$('#' + inputId).toggleClass('has-error', true);
        				$('#' + inputId + '-tooltip').text(response.validationErrors[e]);
	        		}
	        	} else {
	        		hide(generalErrorMessage);
	        		successMessage.html('Email updated successfully.');
	        		show(successMessage);
	        		
	        		$('#email-info').text($('#email').val());
	        		
	        		hide($('#customer-email-form'));
	        		show($('#customer-email-info'));
	        	}
	        	loadingScreen.destroy();
	        	button.prop('disabled', false);
	        },  
	        error: function(e) {  
	        	generalErrorMessage.html('Something went wrong. Please try again later.')
	        	show(generalErrorMessage);
	        	loadingScreen.destroy();
	        	button.prop('disabled', false);
	        }  
	    })
	}
});

/**
 * Submit customer password form
 */
$('#customer-password-form').on('submit', function(evt) {
	evt.preventDefault();
	
	var isValid = validateForm(this, evt);
	
	if (isValid) {
		var passwordData = {},
			generalErrorMessage = $('#general-error-message'),
			successMessage = $('#success-message'), 
			button = $('#update-password-button');
		button.prop('disabled', true);
		loadingScreen.display();

		$(this).find(':input:not(button)').each(function(i, el) {
			profileData[$(el).attr('name')] = $(el).val();
		});
		 
	    $.ajax({
	    	type: 'POST',
	        url: '/market-time/rest/profile/updatePassword',
	        dataType: 'json',
	        contentType: 'application/json',
	        data: JSON.stringify(passwordData),
	        success: function(response) {
	        	if (response.generalError) {
	        		hide(successMessage);
	        		generalErrorMessage.html(response.generalError);
	        		show(generalErrorMessage);
	        	} else if (response.validationErrors) {
	        		hide(successMessage);
	        		for (var e in response.validationErrors ) {
	        			var inputId = toId(e);
	        			$('#' + inputId).toggleClass('has-error', true);
        				$('#' + inputId + '-tooltip').text(response.validationErrors[e]);
	        		}
	        	} else {
	        		hide(generalErrorMessage);
	        		successMessage.html('Password updated successfully.');
	        		show(successMessage);
	        		
	        		$('#password-info').text($('#password-current-password').val());
	        		
	        		hide($('#customer-profile-form'));
	        		show($('#customer-profile-info'));
	        	}
	        	loadingScreen.destroy();
	        	button.prop('disabled', false);
	        },  
	        error: function(e) {  
	        	generalErrorMessage.html('Something went wrong. Please try again later.')
	        	show(generalErrorMessage);
	        	loadingScreen.destroy();
	        	button.prop('disabled', false);
	        }  
	    })
	}
});

/**
 * Perform data validation on a form
 * 
 * @param evt
 */
function validateForm(form, evt) {
	var inputIds = $(form).find('input').map(function() {
		return this.id;
	}).get();

	return validator.validateForm(inputIds, validationConfig);
} 

$('.my-profile-tab-container li').on('click', function(evt, el) {
	// Close all opened forms (in edit mode) when clicking on a tab which is not active.
	if (!$(this).hasClass('active')) {
		//clearInputFields();
		$('[id^="customer-"][id$="-info"]').each(function() {
			show($(this));
		});
		$('[id^="customer-"][id$="-form"]').each(function() {
			hide($(this));
		});
	}
});

$('#edit-profile-button, #cancel-profile-button').on('click', function(evt, el) {
	toggle($('#customer-profile-info'));
	toggle($('#customer-profile-form'));
});

$('#edit-email-button, #cancel-email-button').on('click', function(evt, el) {
	//clearInputFields();
	hide($('#customer-password-form'));
	show($('#customer-password-info'));
	toggle($('#customer-email-info'));
	toggle($('#customer-email-form'));
});

$('#edit-password-button, #cancel-password-button').on('click', function(evt, el) {
	//clearInputFields();
	hide($('#customer-email-form'));
	show($('#customer-email-info'));
	toggle($('#customer-password-info'));
	toggle($('#customer-password-form'));
});

function clearInputFields() {
	$('.my-profile-tab-container [id^="customer-"][id$="-form"] input:not([disabled])').val('');
}

function toggle(element) {
	if (element.hasClass('hidden')) {
		element.removeClass('hidden');
	} else {
		element.addClass('hidden');
	}
}

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

function toId(name) {
	return name.replace(/([A-Z])/g, '-$1').toLowerCase();
}