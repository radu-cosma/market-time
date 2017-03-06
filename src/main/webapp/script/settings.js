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

//Check do not collapse
$(".check").click(function(event) {
	  event.stopPropagation();
});

//validations
var validationConfig = {
	'email' : {
	    'required' : true,
	    'minLength' : 7,
	    'maxLength' : 127,
	    'regexp' : /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/,
	    'messages' : {
	        'required' : 'This field is required.',
	        'lessThan' : 'Not a valid email address',
	        'invalidRegexp' : 'Invalid email format.'
	    }
	},
	'password' : {
	    'required' : true,
	    'minLength' : 8,
	    'messages' : {
	        'required' : 'This field is required.',
	        'lessThan' : 'Password should have at least 8 characters.',
        }
    },
}

$('.blue').click(function(evt) {
  var form = $(this).parents('form').map(function() {
      return this.id;
  }).get();
  
  var fields = $(this).parents('form').find('input').map(function() {
      return this.id;
  }).get();
  
  form.push('comment');
  var isValid = validator.validateFormThis(form, fields, validationConfig);

  if (!isValid) {
      evt.preventDefault();
  }
});
