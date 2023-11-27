// console.log('js-cus-start');

//Remove/hide value in URL bar -- need to enable for Stage & Prod not for DEV
/*(function hideMyURL() {
    var re = new RegExp(/^.*\//);
    window.history.pushState("object or string", "Title", re.exec(window.location.href));
})();
*/

$(document).ready(function() {

$(".choices__input.choices__input--cloned").attr("placeholder","Search");

//PDF print function 
	$('.print').click(function () {
		var element = document.getElementById('print-content');
	    var flname = element.dataset.filename;
	    var opt = {  margin: 1,  filename: flname, image: { type: 'jpeg', quality: 0.98 },  html2canvas:  { scale: 3 },
	           jsPDF:{ unit: 'in', format: 'letter', orientation: 'portrait' } };
	    html2pdf().set(opt).from(element).save();
	});


$("#page-header-notifications-dropdown").click( function (){
  $(this).addClass("show");
	$(this).attr("aria-expanded","true");
} );

});



//Site Direction
	$("#rtl-checked1").click(function(){
		if($("html").attr("dir") == "ltr") {
			$('html').attr('dir', 'rtl');
			$('body',"html").removeClass("rtl");
		}
		else{
			$('html').attr('dir', 'ltr');
			$('body',"html").addClass("rtl");
		}
		

	});
//site font sizer 
	$(".fontsizer").click( function () {
		var cursize = $("html").css("font-size");
		var mode = $(this).attr('data-font-size');
		var updatesize = onsize = 0;
		if(cursize){
			onsize = cursize.split("px");
		}
		else{
			onsize = 16;
		}
		
		if(mode == "decrease"){
			updatesize = parseInt(onsize) - 4;
		}
		else{
			updatesize = parseInt(onsize) + 4;
		}
		if(updatesize >= 12 && updatesize <= 24){
			$("html").css("font-size", updatesize +"px");
		}
	});

//pre-loader js
/*document.onreadystatechange = function () {
  var state = document.readyState
  if (state == 'interactive') {
       document.getElementById('preloader').style.visibility="visible";
  } else if (state == 'complete') {
      setTimeout(function(){
         document.getElementById('preloader').style.visibility="hidden";
      },1000);
  }
  setTimeout(function(){
  		console.log("Show stopper - js error/file is missing");
         document.getElementById('preloader').style.visibility="hidden";
      },5000);
}
*/


$(document).ready(function(){
    
var current_fs, next_fs, previous_fs; //fieldsets
var opacity;

$(".omsb-form-next").click(function(){
    
    current_fs = $(this).parent().parent();
    next_fs = $(this).parent().parent().next();
    
    //Add Class Active
    $(".omsb-form-progressbar li").eq($("fieldset").index(next_fs)).addClass("active");
    
    //show the next fieldset
    next_fs.show(); 
    //hide the current fieldset with style
    current_fs.animate({opacity: 0}, {
        step: function(now) {
            // for making fielset appear animation
            opacity = 1 - now;

            current_fs.css({
                'display': 'none',
                'position': 'relative'
            });
            next_fs.css({'opacity': opacity});
        }, 
        duration: 600
    });
});

$(".omsb-form-previous").click(function(){
    
    current_fs = $(this).parent().parent();
    previous_fs = $(this).parent().parent().prev();
    
    //Remove class active
    $(".omsb-form-progressbar li").eq($("fieldset").index(current_fs)).removeClass("active");
    
    //show the previous fieldset
    previous_fs.show();

    //hide the current fieldset with style
    current_fs.animate({opacity: 0}, {
        step: function(now) {
            // for making fielset appear animation
            opacity = 1 - now;

            current_fs.css({
                'display': 'none',
                'position': 'relative'
            });
            previous_fs.css({'opacity': opacity});
        }, 
        duration: 600
    });
});



/*$(".submit00").click(function(){
    return false;
})*/

//for auto fields 
//$(".omsb-auto-populate .add-row ").text("Add");
//$(".omsb-auto-populate .delete-row ").text("Remove");
    
});

// console.log('js-cus-end');

$(".omsb-light-dark-mode").click(function(){
  var cmode= $("html").attr("data-layout-mode");
  if(cmode == "light"){
    sessionStorage.setItem("data-layout-mode","dark")
  }
  else{
    sessionStorage.setItem("data-layout-mode","light")
  }

  $("html").attr("data-layout-mode",sessionStorage.getItem('data-layout-mode'));
});


$(".db-filter").click(function() {
  /* $(this).closest(".filter-area").toggleClass("d-none"); */
  $(".filter-area").toggleClass("d-none");
});


$(window).on("load",function() {
  
  $("#preloader").delay(2000).css("display","none");
});

//popup toggle action for all dropdown popups
$("[data-bs-toggle=dropdown]").click(function() {
  $(this).siblings(".dropdown-popup.dropdown-menu").addClass("show");
});

$(".dropdown-popup.dropdown-menu").on('blur',function(){
  $(".dropdown-popup.dropdown-menu.show").removeClass("show");
});

$(".dropdown.show[data-bs-toggle=dropdown]").click(function() {
  $(this).siblings(".dropdown-popup.dropdown-menu").removeClass("show");
});

//datatable search input show/hide option
$(".bt-search").click(function() {
  $(".bt-insearch").toggleClass("d-none");
});

$(".btn-cancel").click(function(evt){
  console.log("btn-cancel");
  
   Swal.fire({
    icon: 'warning',
    title: 'Do you want to exit from this page?',
    text: "",
    
    showCancelButton: true,
    reverseButtons: true,
    confirmButtonColor: '#3085d6',
    cancelButtonColor: '#d33',
    confirmButtonText: 'Yes',
    cancelButtonText: 'No'
  }).then((result) => {
    if (result.isConfirmed) {
      }
      else{
      evt.preventDefault();
    }
  })
    
});

$(".btn-backlink").click(function(evt){
  console.log("btn-backlink");
  evt.preventDefault();
   var backlink = $(this).attr('href');
   Swal.fire({
    icon: 'warning',
    title: 'Do you want to exit from this page?',
    text: "",
    
    showCancelButton: true,
    reverseButtons: true,
    confirmButtonColor: '#3085d6',
    cancelButtonColor: '#d33',
    confirmButtonText: 'Yes',
    cancelButtonText: 'No'
  }).then((result) => {
    if (result.isConfirmed) {
        window.location.href = backlink;
      }
      else{
      evt.preventDefault();
    }
  })
    
});


$(".bt-reset").click(function(evt){
  console.log("tab-reset");
  evt.preventDefault();
   Swal.fire({
    icon: 'warning',
    title: 'Do you want to discard the changes made in this page?',
    text: "The changes made in this page won't be saved.",
    
    showCancelButton: true,
    reverseButtons: true,
    confirmButtonColor: '#3085d6',
    cancelButtonColor: '#d33',
    confirmButtonText: 'Yes',
    cancelButtonText: 'No'
  }).then((result) => {
    if (result.isConfirmed) {
      $(this).parent().parent().find('input').val('');
      $(this).parent().parent().find('input').prop('checked', false);
      $(this).parent().parent().find('select').val('');
      $(this).parent().parent().find('input:checked').prop('checked', false);
      $(this).parent().parent().find('textarea').prop('checked', false);
      examEditor.setData('');
      $(this).parent().parent().find(".ck-editor__editable").text('');
      evt.preventDefault();
    }
  })
    
});


$(".bt-form-reset").click(function(evt){
  console.log("tab-reset");
  
   Swal.fire({
    icon: 'warning',
    title: 'Do you want to discard the changes made in this page?',
    text: "The changes made in this page won't be saved.",
    
    showCancelButton: true,
    reverseButtons: true,
    confirmButtonColor: '#3085d6',
    cancelButtonColor: '#d33',
    confirmButtonText: 'Ok'
  }).then((result) => {
    if (result.isConfirmed) {
      $(this).get(0).reset();
      evt.preventDefault();
    }
  })
    
});



function nexttabview(ntelement){
  current_fs = $(ntelement).parent().parent();
  next_fs = $(ntelement).parent().parent().next();
  
  //Add Class Active
  $(".omsb-form-progressbar li").eq($("fieldset").index(next_fs)).addClass("active");
  
  //show the next fieldset
  next_fs.show(); 
  //hide the current fieldset with style
  current_fs.animate({opacity: 0}, {
      step: function(now) {
          // for making fielset appear animation
          opacity = 1 - now;

          current_fs.css({
              'display': 'none',
              'position': 'relative'
          });
          next_fs.css({'opacity': opacity});
      }, 
      duration: 600
  });
}


///MCB--Multiple check box in select

 $(document).ready(function () {

  $(document).on("click", ".MCB", function () {
    var detail = $(this).next();
    detail.show();
  });

  $(document).on("click", ".MCBDetailHeader input", function (e) {
    e.stopPropagation();
    var hc = $(this).prop("checked");
    $(this)
      .closest(".MCBDetail")
      .find(".MCBDetailBody input")
      .prop("checked", hc);
    $(this).closest(".MCBDetail").next().UpdateSelect();
  });

  $(document).on("click", ".MCBDetailHeader", function (e) {
    var inp = $(this).find("input");
    var chk = inp.prop("checked");
    inp.prop("checked", !chk);
    $(this)
      .closest(".MCBDetail")
      .find(".MCBDetailBody input")
      .prop("checked", !chk);
    $(this).closest(".MCBDetail").next().UpdateSelect();
  });

  $(document).on("click", ".MCBDetail .cont input", function (e) {
    e.stopPropagation();
    $(this).closest(".MCBDetail").next().UpdateSelect();

    var val =
      $(".MCBDetailBody input:checked").length ==
      $(".MCBDetailBody input").length;
    $(".MCBDetailHeader input").prop("checked", val);
  });

  $(document).on("click", ".MCBDetail .cont", function (e) {
    var inp = $(this).find("input");
    var chk = inp.prop("checked");
    inp.prop("checked", !chk);

    var MCBDetail = $(this).closest(".MCBDetail");
    var MCBDetailBody = $(this).closest(".MCBDetailBody");
    MCBDetail.next().UpdateSelect();

    var val =
      $(".MCBDetailBody input:checked").length ==
      $(".MCBDetailBody input").length;
    $(".MCBDetailHeader input").prop("checked", val);
  });

  $(document).mouseup(function (e) {
    var container = $(".MCBDetail");
    if (!container.is(e.target) && container.has(e.target).length === 0) {
      container.hide();
    }
  });
});

var defaultMCBOption = {
  width: "220px",
  defaultText: "Select Below",
  height: "200px"
};

jQuery.fn.extend({
  createMCB: function (options) {
    var localOption = {};
    localOption.width =
      options != null && options.width != null && options.width != undefined
        ? options.width
        : defaultMCBOption.width;
    localOption.defaultText =
      options != null &&
      options.defaultText != null &&
      options.defaultText != undefined
        ? options.defaultText
        : defaultMCBOption.defaultText;
    localOption.height =
      options != null && options.height != null && options.height != undefined
        ? options.height
        : defaultMCBOption.height;

    this.hide();
    this.attr("multiple", "multiple");
    var divSel = $(
      "<div class='MCB MCB-selected form-control "+options.setClass+"'>"+localOption.defaultText +"</div>"
    ).insertBefore(this);
    divSel.css({ width: localOption.width });

    var detail = $(
      "<div class='MCBDetail "+options.setClass+"'><div class='MCBDetailHeader'><div class='ri-checkbox-indeterminate-line'><input type='checkbox' class='mulinput' value='-1982' /></div><div>Select All</div></div><div class='MCBDetailBody'></div></div>"
    ).insertAfter(divSel);
    detail.css({
      width: parseInt(options.width) + 10,
      "max-height": localOption.height
    });
    var MCBDetailBody = detail.find(".MCBDetailBody");

    this.find("option").each(function () {
      var val = $(this).attr("value");

      if (val == undefined) val = "";

      MCBDetailBody.append(
        "<div class='cont'><div><input type='checkbox' class='mulinput' value='" +
          val +
          "' /></div><div class='mulinput-value'>" +
          $(this).text() +
          "</div></div>"
      );
    });

    MCBDetailBody.css(
      "max-height",
      parseInt($(".MCBDetail").css("max-height")) - 28 + "px"
    );
  },
  UpdateSelect: function () {
    var arr = [];
    var upddata="";
    this.prev()
      .find(".mulinput:checked")
      .each(function () {
        arr.push($(this).val());
         // console.log("current value-text"+$(this).closest('div.cont').find(".mulinput-value").text());
         // console.log("current value-html"+$(this).closest('div.cont').find(".mulinput-value").html());
         upddata = upddata +"  "+ $(this).closest('div.cont').find(".mulinput-value").text();
        
        
      });
      console.log("upddata"+upddata);
      // $(this).closest('div.cont').find('.MCB-selected')
     this.val(arr);
     $(this).closest('div').find(".MCB.MCB-selected").html("");
    if(!upddata){
    
    $(this).closest('div').find(".MCB.MCB-selected").append("Select");
  }else{
    $(this).closest('div').find(".MCB.MCB-selected").append(upddata);
    }
  }
});

///MCB--Multiple check box in select

/*function marquee(selector, speed) {
  const parentSelector = document.querySelector(selector);
  const clone = parentSelector.innerHTML;
  const firstElement = parentSelector.children[0];
  let i = 0;

  parentSelector.insertAdjacentHTML("beforeend", clone);
  parentSelector.insertAdjacentHTML("beforeend", clone);

  setInterval(function () {
    firstElement.style.marginLeft = `-${i}px`;
    if (i > firstElement.clientWidth) {
      i = 0;
    }
    i = i + speed;
  }, 0);
}


window.addEventListener("load", marquee(".user_notifications", 0.2));
*/