$(document).ready( function () {
    $('#custOrderList').dataTable( {
      "bLengthChange": false,
      "bSort": false,
      "searching": false,"pageLength": 10,
      "pagingType": "simple",
      "language": {
          "info": '<span style="color: #9FA2B4">_START_ to _END_ of _TOTAL_</span>',
          "infoEmpty": '0 to 0 of 0',
          "infoFiltered": '<span style="color: #9FA2B4">(filtered from _MAX_)</span>',
          "paginate": {
              "next": '<i class="fas fa-angle-right" style="color: #9FA2B4;"></i>',
              "previous": '<i class="fas fa-angle-left" style="color: #9FA2B4;"></i>'
          }
      }
    } );
  } );