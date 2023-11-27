// ak custom_script Popup dropdown

//site font sizer 
$(".fontsizer").click(function () {
  var cursize = $("html").css("font-size");
  var mode = $(this).attr('data-font-size');
  var updatesize = onsize = 0;
  if (cursize) {
      onsize = cursize.split("px");
  }
  else {
      onsize = 16;
  }

  if (mode == "decrease") {
      updatesize = parseInt(onsize) - 4;
  }
  else {
      updatesize = parseInt(onsize) + 4;
  }
  if (updatesize >= 12 && updatesize <= 24) {
      $("html").css("font-size", updatesize + "px");
  }
});

$(document).ready(function () {
  
  // SP custom_script 
  $('.omsb-footer').length > 0 && fixedButtom();
  $(window).resize($('.omsb-footer').length > 0 && fixedButtom());

  $(".custom-file").length > 0 && customFileUploader();
  accordion();
  navigation();
  navigationAccordion();
});

function customFileUploader(){
    $(".custom-file input[type='file']").on("change", function () {
        var fileName = $(this).val().split("\\").pop();
        $(this).parent().siblings(".custom-file-label").addClass("selected").html(fileName);
    });
}

function navigation() {
  $(".humber-menu").click(function () {
      if ($('body').hasClass('sidebar-collspand')) {
          $('body').removeClass('sidebar-collspand');
      } else {
          $('body').addClass('sidebar-collspand');
      }
  })
}

function navigationAccordion() {
  $('.submenu-icon').click(function () {
      $('.sub-menu').slideUp();
      $('.submenu-icon').removeClass('show');
      if ($(this).next('.sub-menu').is(':visible')) {
          $(this).next('.sub-menu').slideUp();
          $(this).removeClass('show');
      } else {
          $(this).next('.sub-menu').slideDown();
          $(this).addClass('show');
      }

  })
}

function countChar(val) {
  var len = typeof val === 'string' ? $(val).val().length : val.value.length;
  if (len >= 500) {
      val.value = val.value.substring(0, 500);
  } else {
      $('.countered_points').text(500 - len);
  }
};

function accordion() {
  $(".colspan-child").click(function () {
      if ($(this).next('ul').is(":visible")) {
          $(this).next('ul').slideUp();
          $(this).text('Expand');
          $(this).removeClass('show');
      } else {
          $(this).next('ul').slideDown();
          $(this).text('Collapse');
          $(this).addClass('show');
      }
  })
}


$('.omsb-tableview').DataTable({
    "bLengthChange": false,
    "bFilter": false,
    "pageLength": 2
});

$(".rtl #lang-selector").prop("checked", true);

$("#lang-selector").change( function() {
  var lang_url = window.location.origin+'/c/portal/update_language?languageId=';
  if(this.checked){
    //arabic
    $(location).attr('href',lang_url+'ar_SA');
  }
  else{
    //english
    $(location).attr('href',lang_url+'en_US');
  }
});

function fixedButtom(){
    if($('body').outerHeight() <= $(window).height()){
        $('.omsb-footer').addClass('fixed')
    }else{
        $('.omsb-footer').removeClass('fixed')
    }
}

$("[data-bs-toggle='dropdown']").click(function() {
  $(this).siblings("ul.dropdown-menu").toggleClass("show");
});

$('.bw-button').click(function () {
  $('html').toggleClass('blackandwhite');
});
// Tooltiip

$(function () {
    $('[data-toggle="tooltip"]').tooltip()
})

function determineDropDirection() {  
  //change attr of other..
  $(".dropdown-toggle").not(this).attr("aria-expanded", "true")
  //addclass of other..
  $(".dropdown-toggle").not(this).removeClass("collapsed")
  //remove show class from others
  $(".dropdown-toggle").not(this).next("ul").removeClass("show")
  $(".dropdown-menu").each(function () {
    // Invisibly expand the dropdown menu so its true height can be calculated
    $(this).css({
      visibility: "hidden",
      display: "block"
    });

    // Necessary to remove class each time so we don't unwantedly use dropup's offset top
    $(this).parent().removeClass("dropup");

    if ($(this).offset().top - $(".omsb-datatables").offset().top > $(this).innerHeight()) {
      // Determine whether bottom of menu will be below window a current scroll position
      if ($(this).offset().top - $(".omsb-datatables").offset().top > $(".omsb-datatables").innerHeight() / 2) {
        $(this).parent().addClass("dropup");
      }
    }
    // Return dropdown menu to fully hidden state
    $(this).removeAttr("style");
  });
}
  
$('.omsb-datatables .btn.dropdown-toggle').length && $(document.body).on('click', '.btn.dropdown-toggle', determineDropDirection);
 