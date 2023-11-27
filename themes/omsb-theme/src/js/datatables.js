
akinclude('o/omsb-theme/js/datatables/jquery.dataTables.min.js');
akinclude('o/omsb-theme/js/datatables/dataTables.bootstrap5.min.js');
akinclude('o/omsb-theme/js/datatables/dataTables.responsive.min.js');
akinclude('o/omsb-theme/js/datatables/dataTables.buttons.min.js');
akinclude('o/omsb-theme/js/datatables/buttons.print.min.js');
akinclude('o/omsb-theme/js/datatables/buttons.html5.min.js');
akinclude('o/omsb-theme/js/datatables/vfs_fonts.js');
akinclude('o/omsb-theme/js/datatables/pdfmake.min.js');


document.writeln("<script type='text/javascript' src='o/omsb-theme/js/datatables/jquery.dataTables.min.js'></script>");
document.writeln("<script type='text/javascript' src='o/omsb-theme/js/datatables/dataTables.bootstrap5.min.js'></script>");
document.writeln("<script type='text/javascript' src='o/omsb-theme/js/datatables/dataTables.responsive.min.js'></script>");
document.writeln("<script type='text/javascript' src='o/omsb-theme/js/datatables/dataTables.buttons.min.js'></script>");
document.writeln("<script type='text/javascript' src='o/omsb-theme/js/datatables/buttons.print.min.js'></script>");
document.writeln("<script type='text/javascript' src='o/omsb-theme/js/datatables/buttons.html5.min.js'></script>");
document.writeln("<script type='text/javascript' src='o/omsb-theme/js/datatables/vfs_fonts.js'></script>");
document.writeln("<script type='text/javascript' src='o/omsb-theme/js/datatables/pdfmake.min.js'></script>");
$('.omsb-datatables').dataTable( {
   "scrollX": true,
   fixedColumns:   {
   			left: 1,
            right: 1
        }

} );



