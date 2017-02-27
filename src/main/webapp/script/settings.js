//Collapse section
$('.market-img, .market-settings, .market-status').click( function(e) {
    $(this).parents('.panel').find('.panel-collapse').collapse('toggle');
})
$('.panel-collapse').on('show.bs.collapse',  function () {
    var span = $(this).parents('.panel').find('.market-img, .market-settings, .market-status');
    span.find('i').removeClass('glyphicon-chevron-down').addClass('glyphicon-chevron-up');
    span.removeClass('market-display');
})
$('.panel-collapse').on('hide.bs.collapse', function () {
    var span = $(this).parents('.panel').find('.market-img, .market-settings, .market-status');
    span.find('i').removeClass('glyphicon-chevron-up').addClass('glyphicon-chevron-down');
    span.addClass('market-display');
});

//Check do not collapse
$(".check").click(function() {
	$(this).collapse('hide');
});