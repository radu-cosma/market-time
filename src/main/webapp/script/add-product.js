var validationConfig = {
	'name' : {
		'required' : true,
		'minLength' : 3,
		'maxLength' : 30,
		'messages' : {
			'required' : 'Please insert a name for your product.',
			'lessThan' : 'The product name should have at least 3 characters.',
			'moreThan' : 'The product name should have at most 30 characters.'
		}
	},
	'description' : {
		'required' : true,
		'minLength' : 3,
		'maxLength' : 1000,
		'messages' : {
			'required' : 'Please insert a description for your product.',
			'lessThan' : 'The product description should have at least 3 characters.',
			'moreThan' : 'The product description should have at most 1000 characters.'
		}
	},
	'tags' : {
		'required' : true,
		'minLength' : 3,
		'maxLength' : 200,
		'regexp' : /^([a-zA-Z]{3,})(,\s*[a-zA-Z]{3,})*$/,
		'messages' : {
			'required' : 'Please insert at least a tag for your product.',
			'lessThan' : 'The product tags field should have at least 3 characters.',
			'moreThan' : 'The product tags field should have at most 200 characters.',
			'invalidRegexp' : 'A tag should contain lowercase and uppercase letters only. Multiple tags should be comma separated.'
		}
	},
	'shipping' : {
		'required' : true,
		'minLength' : 3,
		'maxLength' : 10,
		'messages' : {
			'required' : 'This field is required.',
			'lessThan' : 'Shipping should have at least 3 characters.',
			'moreThan' : 'Shipping should have at most 10 characters.'
		}
	},
	'shipping-time' : {
		'required' : false,
		'minLength' : 3,
		'maxLength' : 10,
		'regexp' : /^[0-9]{1,2}-[0-9]{1,2}$/,
		'messages' : {
			'lessThan' : 'Shipping time should have at least 3 characters.',
			'moreThan' : 'Shipping time should have at most 5 characters.',
			'invalidRegexp' : 'The shipping time should be expressed as a range of days, like 15-20.'
		}
	},
	'color' : {
		'required' : false,
		'minLength' : 3,
		'maxLength' : 20,
		'messages' : {
			'lessThan' : 'The product color should have at least 3 characters.',
			'moreThan' : 'The product color should have at most 20 characters.'
		}
	},
	'size' : {
		'required' : false,
		'minLength' : 1,
		'maxLength' : 10,
		'messages' : {
			'lessThan' : 'The product size should have at least 1 character.',
			'moreThan' : 'The product size should have at most 10 characters.'
		}
	},
	'inventory' : {
		'required' : true,
		'messages' : {
			'required' : 'The number of products on stock is required.'
		}
	},
	'price' : {
		'required' : true,
		'messages' : {
			'required' : 'The product price is required.'
		}
	},
	'brand' : {
		'required' : false,
		'minLength' : 3,
		'maxLength' : 30,
		'messages' : {
			'lessThan' : 'The product brand should have at least 3 characters.',
			'moreThan' : 'The product brand should have at most 30 characters.'
		}
	},
	'presentationPageUrl' : {
		'required' : false,
		'minLength' : 10,
		'maxLength' : 50,
		'messages' : {
			'lessThan' : 'The product presentation page URL should have at least 10 characters.',
			'moreThan' : 'The product presentation page URL should have at most 50 characters.'
		}
	},
	'upc' : {
		'required' : false,
		'exactLength' : 12,
		'regexp' : /^[0-9]{12}$/,
		'messages' : {
			'lessOrMoreThan' : 'The product UPC should contain exactly 12 digits.',
			'invalidRegexp' : 'The product UPC should contain exactly 12 digits.'
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

$('.close').on('click', function(evt) {
	evt.preventDefault();
	$(this).parent().addClass('hidden');
});