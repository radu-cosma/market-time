var emailValidationConfig = {
	    'required' : true,
	    'minLength' : 7,
	    'maxLength' : 127,
	    'regexp' : /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/,
	    'messages' : {
	        'required' : 'This field is required.',
	        'lessThan' : 'Not a valid email address',
            'moreThan' : 'Email should have at most 127 characters',
	        'invalidRegexp' : 'Invalid email format.'
	    }
	},
    passwordValidationConfig = {
		'required' : true,
	    'minLength' : 8,
        'maxLength' : 63,
	    'messages' : {
	        'required' : 'This field is required.',
	        'lessThan' : 'Password should have at least 8 characters.',
            'moreThan' : 'Password should have at most 63 characters',
            'invalidRegexp' : 'Invalid format.'
        }	
    },
    validationConfig = {};

$(document).ready(function() {
	var inputIds = $('input.form-control').map(function() {
		return this.id; 
	}).get();
	$.each(inputIds, function(index, id) {
		if (id.endsWith('email')) {
			validationConfig[id] = emailValidationConfig;
		} else if (id.endsWith('password')) {
			validationConfig[id] = passwordValidationConfig;
		}
	});
});

$('input[readonly]').on('focus', function() {
	$(this).removeAttr('readonly');
});
	

//Collapse section
$('.market-img, .market-settings, .collapse-btn').click( function(e) {
    $(this).parents('.panel').find('.panel-collapse').collapse('toggle');
})
$('.panel-collapse').on('show.bs.collapse',  function () {
    var span = $(this).parents('.panel').find('.market-img, .market-settings, .collapse-btn');
    span.find('i').removeClass('glyphicon-chevron-down').addClass('glyphicon-chevron-up');
    span.removeClass('market-display');
})
$('.panel-collapse').on('hide.bs.collapse', function () {
    var span = $(this).parents('.panel').find('.market-img, .market-settings, .collapse-btn');
    span.find('i').removeClass('glyphicon-chevron-up').addClass('glyphicon-chevron-down');
    span.addClass('market-display');
});

//Don't collapse when clicking on check and on links
$(".check").click(function(event) {
	  event.stopPropagation();
});
$(".market-url").click(function(event) {
	  event.stopPropagation();
});

$('form').submit(function(evt) {
  var fields = $(this).find('input').map(function() {
      return this.id;
  }).get();
  
  var isValid = validator.validateForm(fields, validationConfig);

  if (!isValid) {
      evt.preventDefault();
  }
});
