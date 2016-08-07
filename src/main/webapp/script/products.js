// open hide details product
$('.divToToggle').hide();

$('.aTag').click(function(e){

    e.preventDefault();
    // hide all div
    var $this = $(this).parent().find('.divToToggle');
    $(".aTag .divToToggle").not($this).hide();

    $this.toggle();

     if ($this.css('display') == 'none') {
          $(this).html('details &#9660');
     }
     else {
          $(this).html('close details &#9650');

     }
});



// view collapse details sections
$(document)
    .on('click', '.panel-heading', function(e){
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
 
    
    
// modal delete product
$(".delete-product-modal").click(function() {
    $("#delete-product-modal").modal('hide');
    $("#delete-product-modal").show();
});
