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