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

$('.omsb-tableview').DataTable({
  "bLengthChange": false,
  "bFilter": false,
  "pageLength": 2
});

$(document).ready(function () {

  fixedButtom()

  // ak custom_script 
  // $('.omsb-datatables').DataTable({
  //   "bLengthChange": false,
  //   "bFilter": false,
  // });




  // SP custom_script 
  $("#comment").length > 0 && countChar("#comment");
  $('.omsb-footer').length > 0 && fixedButtom();
  $(window).resize(
    $('.omsb-footer').length > 0 && fixedButtom()
  );
  accordion();
  navigation();
  navigationAccordion();
});

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

function fixedButtom() {
  $('.omsb-footer').removeClass('fixed');
  if ($(window).height() > $(".omsb-footer").offset().top) {
    $('.omsb-footer').addClass('fixed')
  } else {
    $('.omsb-footer').removeClass('fixed')
  }
}
$('.bw-button').click(function () {
  $('body').toggleClass('blackandwhite');
});


// Tooltiip

$(function () {
  $('[data-toggle="tooltip"]').tooltip()
})




function determineDropDirection() {  
  //change attr of other..
  $(".dropdown .dropdown-toggle").not(this).attr("aria-expanded", "true")
  //addclass of other..
  $(".dropdown .dropdown-toggle").not(this).removeClass("collapsed")
  //remove show class from others
  $(".dropdown .dropdown-toggle").not(this).next("ul").removeClass("show")
  $(".dropdown .dropdown-menu").each(function () {
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

$('.omsb-datatables .dropdown .btn.dropdown-toggle').length && $(document.body).on('click', '.btn.dropdown-toggle', determineDropDirection);


