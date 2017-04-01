$('.details-btn').on('click', function(e) {
    e.preventDefault();
    var detailsContainer = $(this).parent().find('.details-container');

    if (detailsContainer.hasClass('hidden')) {
        detailsContainer.removeClass('hidden');
        $(this).html('close details &#9650');
    } else {
        detailsContainer.addClass('hidden');
        $(this).html('details &#9660');
    }
});

// view collapse details sections
$(document)
    .on('click', '.panel-heading', function(e) {
        $(this).parents('.panel').find('.panel-collapse').collapse('toggle');
    })
    .on('show.bs.collapse', '.panel-collapse', function () {
        var $span = $(this).parents('.panel').find('.panel-heading');
        $span.find('i').removeClass('glyphicon-chevron-down').addClass('glyphicon-chevron-up');
    })
    .on('hide.bs.collapse', '.panel-collapse', function () {
        var $span = $(this).parents('.panel').find('.panel-heading');
        $span.find('i').removeClass('glyphicon-chevron-up').addClass('glyphicon-chevron-down');
    })
