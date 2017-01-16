$(document).ready(function() {
	$('.toggle-description').on('click', function(el) {
		var $info = $(this).siblings('.info');
		var willBeVisible = !$info.is(':visible');

		$('.market-integration').removeClass('market-integration-active');
		$(this).parents('.integration-details').find('.info').hide();

		if (willBeVisible) {
			$info.show();
			$(this).find('.market-integration').addClass('market-integration-active');
		}
	});

	$('.info a.close').on('click', function(el) {
		$(this).parents('.info').hide();
		var logoId = $(this).parents('.info').attr('for-market');
		$('#' + logoId).removeClass('market-integration-active');
	});
});