/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready( function () {
  $('#tbllist').dataTable( {
    "bLengthChange": false,
    "bSort": false,
    "searching": true,
    "sDom": 't<"bottom row"<"col-9"><"col-3 row"<"col-9 d-flex justify-content-end"i><"col-3 d-flex justify-content-center"p>>>',
    "pageLength": 8,
    "pagingType": "simple",
    "language": {
        "info": '<span style="color: #9FA2B4">_START_ to _END_ of _TOTAL_</span>',
        "infoEmpty": '0 to 0 of 0',
        "infoFiltered":   '<span style="color: #9FA2B4">(filtered from _MAX_)</span>',
        "paginate": {
            "next": '<i class="fas fa-angle-right" style="color: #9FA2B4;"></i>',
            "previous": '<i class="fas fa-angle-left" style="color: #9FA2B4;"></i>'
        }
    }
  } );
} );

$(document).ready( function () {
  oTable = $('#tbllist').DataTable();
  $('#searchtable').keyup(function(){
      oTable.search($(this).val()).draw() ;
});
} );