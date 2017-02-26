//Collapse section
$('.message-title, .message-date').click( function(e) {
    $(this).parents('.panel').find('.panel-collapse').collapse('toggle');
})
$('.panel-collapse').on('show.bs.collapse',  function () {
    var span = $(this).parents('.panel').find('.message-title, .message-date');
    span.find('i').removeClass('glyphicon-chevron-down').addClass('glyphicon-chevron-up');
    span.removeClass('title-align, read');
})
$('.panel-collapse').on('hide.bs.collapse', function () {
    var span = $(this).parents('.panel').find('.message-title, .message-date');
    span.find('i').removeClass('glyphicon-chevron-up').addClass('glyphicon-chevron-down');
    span.addClass('title-align');
});

//Change color when a mail is checked
$(".panel-heading").click(function() {
    if ($(this).find(".check").is(":checked")) {
        $(this).addClass("panel-message-check");
    } else {
        $(this).removeClass('panel-message-check');
    }
});

//Select all inbox
$("#select-all-inbox").change(function() {
    if ($(this).is(":checked")) {
        $("#inbox .check").prop("checked", true);
        $("#inbox .panel-heading").addClass("panel-message-check");
    } else {
        $("#inbox .check").prop("checked", false);
        $("#inbox .panel-heading").removeClass("panel-message-check");
    }
});

// Select all outbox
$("#select-all-outbox").change(function() {
    if ($(this).is(":checked")) {
        $("#outbox .check").prop("checked", true);
        $("#outbox .panel-heading").addClass("panel-message-check");
    } else {
        $("#outbox .check").prop("checked", false);
        $("#outbox .panel-heading").removeClass("panel-message-check");
    }
});

// Un-check select all
$('#inbox .check').on('click', function() {
    var selectAllInboxCheckbox = $('#select-all-inbox'),
    	inboxMessagesCount = $('#inbox .messages-list li').length;
    if (!$(this).is(':checked') && $('#inbox .check:checked').length < inboxMessagesCount && selectAllInboxCheckbox.is(':checked')) {
        selectAllInboxCheckbox.prop('checked', false);
    }
});

$('#outbox .check').on('click', function() {
    var selectAllOutboxCheckbox = $('#select-all-outbox'),
		outboxMessagesCount = $('#outbox .messages-list li').length;
    if (!$(this).is(':checked') && $('#outbox .check:checked').length < outboxMessagesCount && selectAllOutboxCheckbox.is(':checked')) {
        selectAllOutboxCheckbox.prop('checked', false);
    }
});

//validations
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
