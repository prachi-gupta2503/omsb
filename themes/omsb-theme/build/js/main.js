/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

/*
 * This function gets loaded when all the HTML, not including the portlets, is
 * loaded.
 */
AUI().ready(function () {});

/*
 * This function gets loaded after each and every portlet on the page.
 *
 * portletId: the current portlet's id
 * node: the Alloy Node object of the current portlet
 */
Liferay.Portlet.ready(function (_portletId, _node) {});

/*
 * This function gets loaded when everything, including the portlets, is on
 * the page.
 */
Liferay.on('allPortletsReady', function () {});

$(document).ready(function() {

$("html").attr("data-layout-mode",sessionStorage.getItem('data-layout-mode'));
});

function akinclude(file) {
  var sr  = document.createElement('script');
  sr.src  = file;
  sr.type = 'text/javascript';
  sr.defer = true;
  document.getElementsByTagName('head').item(0).appendChild(sr);
}
// console.log('js-main');
/*
akinclude('o/omsb-theme/libs/bootstrap/js/bootstrap.bundle.min.js');
akinclude('o/omsb-theme/libs/simplebar/simplebar.min.js');
akinclude('o/omsb-theme/libs/node-waves/waves.min.js');
akinclude('o/omsb-theme/libs/feather-icons/feather.min.js');
akinclude('o/omsb-theme/js/pages/plugins/lord-icon-2.1.0.js');
akinclude('o/omsb-theme/js/plugins.js');
akinclude('o/omsb-theme/libs/apexcharts/apexcharts.min.js');
akinclude('o/omsb-theme/js/pages/dashboard-crm.init.js');
akinclude('o/omsb-theme/js/print/jspdf.min.js');
akinclude('o/omsb-theme/js/print/html2pdf.bundle.min.js');
akinclude('o/omsb-theme/js/app.js');

akinclude('o/omsb-theme/js/datatables/jquery.dataTables.min.js');
akinclude('o/omsb-theme/js/datatables/dataTables.bootstrap5.min.js');
akinclude('o/omsb-theme/js/datatables/dataTables.responsive.min.js');
akinclude('o/omsb-theme/js/datatables/dataTables.buttons.min.js');
akinclude('o/omsb-theme/js/datatables/buttons.print.min.js');
akinclude('o/omsb-theme/js/datatables/buttons.html5.min.js');
akinclude('o/omsb-theme/js/datatables/vfs_fonts.js');
akinclude('o/omsb-theme/js/datatables/pdfmake.min.js');
 */
// akinclude('o/omsb-theme/js/custom_script.js');
var dlfilename= "export_data";

// for omsb-datatables file name
var cfname = $('.omsb-datatables').attr("data-download-file-name");
cfname = (cfname != "" && cfname != undefined ) ? cfname : dlfilename;

// for omsb-datatables-1 file name
var cfname1 = $('.omsb-datatables-1').attr("data-download-file-name");
cfname1 = (cfname1 != "" && cfname1 != undefined ) ? cfname1 : dlfilename;


// for omsb-datatables-2 file name
var cfname2 = $('.omsb-datatables-2').attr("data-download-file-name");
cfname2 = (cfname2 != "" && cfname2 != undefined ) ? cfname2 : dlfilename;


$('.omsb-datatables').dataTable( {
  scrollX: true,
  dom: 'Bfrtip',
  ordering: false,
  buttons:  [
              {
                extend:    'excelHtml5',
                title: '',
                filename: cfname,
                text:      '<i class="ri-file-excel-2-fill"></i>',
                titleAttr: 'Download as Excel',
                exportOptions: {
                    columns: ':visible'
                }
              },
              {
                extend:    'csvHtml5',
                title: '',
                filename: cfname,
                text:      '<i class="ri-file-text-fill "></i>',
                titleAttr: 'Download as CSV',
                exportOptions: {
                    columns: ':visible'
                }
              },
              {
                extend:    'pdfHtml5',
                title: '',
                filename: cfname,
                text:      '<i class="bx bxs-file-pdf "></i>',
                titleAttr: 'Download as PDF',
                exportOptions: {
                    columns: ':visible'
                }
              },
              {
                 extend:   'colvis',
                 text:      '<i class="ri-eye-fill "></i>',
                  titleAttr: 'Viewlist'
              }
            ],
   "language": {
        "emptyTable": "No Records Found."
      }
} );


$('.omsb-datatables-1').dataTable( {
  scrollX: true,
  dom: 'Bfrtip',
  ordering: false,
  buttons:  [
              {
                extend:    'excelHtml5',
                title: '',
                filename: cfname1,
                text:      '<i class="ri-file-excel-2-fill"></i>',
                titleAttr: 'Download as Excel'
              },
              {
                extend:    'csvHtml5',
                title: '',
                filename: cfname1,
                text:      '<i class="ri-file-text-fill "></i>',
                titleAttr: 'Download as CSV'
              },
              {
                extend:    'pdfHtml5',
                title: '',
                filename: cfname1,
                text:      '<i class="bx bxs-file-pdf "></i>',
                titleAttr: 'Download as PDF'
              },
              {
                extend:    'print',
                text:      '<i class="ri-printer-fill "></i>',
                titleAttr: 'Print'
              }
            ],
   "language": {
        "emptyTable": "No Records Found."
      }
} );

$('.omsb-datatables-2').dataTable( {
  scrollX: true,
  dom: 'Bfrtip',
  ordering: false,
  buttons:  [
              {
                extend:    'excelHtml5',
                title: '',
                filename: cfname2,
                text:      '<i class="ri-file-excel-2-fill"></i>',
                titleAttr: 'Download as Excel'
              },
              {
                extend:    'csvHtml5',
                title: '',
                filename: cfname2,
                text:      '<i class="ri-file-text-fill "></i>',
                titleAttr: 'Download as CSV'
              },
              {
                extend:    'pdfHtml5',
                title: '',
                filename: cfname2,
                text:      '<i class="bx bxs-file-pdf "></i>',
                titleAttr: 'Download as PDF'
              },
              {
                extend:    'print',
                title: '',
                filename: cfname2,
                text:      '<i class="ri-printer-fill "></i>',
                titleAttr: 'Print'
              }
            ],
   "language": {
        "emptyTable": "No Records Found."
      }
} );



function infoAlert(type,title,message){
  Swal.fire({
    icon: type,
    title: title,
    text: message,
    timerProgressBar: true,
    showCloseButton: true,
    showConfirmButton: true,
    customClass: {
      confirmButton: 'btn btn-success',
      cancelButton: 'btn btn-cancel'
    }
  })
}

function confirmResetAlert(link){
  Swal.fire({
    icon: 'warning',
    title: 'Are you sure?',
    text: "You want to reset the form value",
    
    showCancelButton: true,
    reverseButtons: true,
    confirmButtonColor: '#3085d6',
    cancelButtonColor: '#d33',
    confirmButtonText: 'ok'
  }).then((result) => {
    if (result.isConfirmed) {
      window.location.href = link;
    }
  })
}

$(".omsb-reset").click(function(evt){
  evt.preventDefault();
  var resetlink= "";
  resetlink = $(this).attr("href");
  confirmEditAlert(resetlink);
});

function confirmEditAlert(link){
  Swal.fire({
    icon: 'warning',
    title: 'Are you sure?',
    text: "You want to edit this!",
    
    showCancelButton: true,
    reverseButtons: true,
    confirmButtonColor: '#3085d6',
    cancelButtonColor: '#d33',
    confirmButtonText: 'ok'
  }).then((result) => {
    if (result.isConfirmed) {
      window.location.href = link;
    }
  })
}

$(".omsb-edit").click(function(evt){
  evt.preventDefault();
  var edtlink= "";
  edtlink = $(this).attr("href");
  confirmEditAlert(edtlink);
});

function confirmDeleteAlert(link){
  Swal.fire({
    icon: 'error',
    title: 'Are you sure?',
    text: "You won't be able to revert this!",
    
    showCancelButton: true,
    reverseButtons: true,
    confirmButtonColor: '#3085d6',
    cancelButtonColor: '#d33',
    confirmButtonText: 'ok'
  }).then((result) => {
    if (result.isConfirmed) {
      window.location.href = link;
      Swal.fire(
        'Deleted!',
        'Your data has been deleted.',
        'success'
      )
    }
  })
}

$(".omsb-delete").click(function(evt){
  evt.preventDefault();
  var dellink= "";
  dellink = $(this).attr("href");
  confirmEditAlert(dellink);
});





