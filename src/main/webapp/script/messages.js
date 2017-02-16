//Browse 
$(function() {

  $(document).on('change', ':file', function() {
    var input = $(this),
        numFiles = input.get(0).files ? input.get(0).files.length : 1,
        label = input.val().replace(/\\/g, '/').replace(/.*\//, '');
    input.trigger('fileselect', [numFiles, label]);
  }); 

  $(document).ready( function() {
      $(':file').on('fileselect', function(event, numFiles, label) {

          var input = $(this).parents('.input-group').find(':text'),
              log = numFiles > 1 ? numFiles + ' files selected' : label;

          if( input.length ) {
              input.val(log);
          } else {
              if( log ) alert(log);
          }

      });
  });
  
});

//Collapse section
$(document)
.on('click', '.heading-title, .heading-date', function(e) {
    $(this).parents('.panel').find('.panel-collapse').collapse('toggle');
})
.on('show.bs.collapse', '.panel-collapse', function () {
    var $span = $(this).parents('.panel').find('.heading-title, .heading-date');
    $span.find('i').removeClass('glyphicon-chevron-down').addClass('glyphicon-chevron-up');
    $span.removeClass('title-align, read');
})
.on('hide.bs.collapse', '.panel-collapse', function () {
    var $span = $(this).parents('.panel').find('.heading-title, .heading-date');
    $span.find('i').removeClass('glyphicon-chevron-up').addClass('glyphicon-chevron-down');
    $span.addClass('title-align');
})

//Change color when a mail is checked
$(".panel-heading").click(function() {
    if($(this).find(".mail-check").is(":checked")){
    $(this).addClass("panel-heading-check");
    }
    else{
    $(this).removeClass('panel-heading-check');
    }
});

//Select all
$(".select-all").change(function() {
    if($(this).is(":checked")){
    $(":checkbox").prop("checked", true);
    $(".panel-heading").addClass("panel-heading-check");
    }
    else{
    $(":checkbox").prop("checked", false);
    $(".panel-heading").removeClass("panel-heading-check");
    }
});

/*validations*/

var validationConfig = {
    'subject' : {
        'required' : true,
        'minLength' : 3,
        'maxLength' : 100,
        'messages' : {
            'required' : 'This field is required.',
            'lessThan' : 'First name should have at least 3 characters.',
            'moreThan' : 'First name should have at most 100 characters',
            'invalidRegexp' : 'Invalid format.'
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

$('#inbox .mail-check').on('click', function() {
	var selectAllInboxCheckbox = $('#select-all-inbox');
	if (!$(this).is(':checked') && $('#inbox .mail-check:checked').length === 0 && selectAllInboxCheckbox.is(':checked')) {
		selectAllInboxCheckbox.prop('checked', false);
	}
});

$('#outbox .mail-check').on('click', function() {
	var selectAllOutboxCheckbox = $('#select-all-outbox');
	if (!$(this).is(':checked') && $('#outbox .mail-check:checked').length === 0 && selectAllOutboxCheckbox.is(':checked')) {
		selectAllOutboxCheckbox.prop('checked', false);
	}
});
