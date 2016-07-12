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
		'regexp' : /^[0-9 ]+$/,
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
	'password' : {
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
		'mirror' : 'password',
		'messages' : {
			'required' : 'This field is required.',
			'lessThan' : 'Password should have at least 8 characters.',
			'moreThan' : 'Password should have at most 63 characters',
			'invalidRegexp' : 'Invalid format.',
			'mirror' : 'Passwords should match.'
		}
	}
}

$('form').on('submit', function(evt) {
	var inputIds = $(this).find('input').map(function() {
		return this.id;
	}).get();

	var valid = validator.validateForm(inputIds, validationConfig);

	if (!valid) {
		evt.preventDefault();
	}
});