/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function()
{
  $('#statuschkbox').change(function() 
  {
    if(this.checked !== true)
    {
        $('#createstatus').text('DISABLED');
        var status = document.getElementsByClassName("newstatus");
        var i;
        for (i = 0; i < status.length; i++) {
            var changeStatus = status[i];
            if (changeStatus.classList.contains('enable')) {
                changeStatus.classList.remove('enable');
                changeStatus.classList.toggle('disable');
            }
        }
    } else if (this.checked === true) {
        $('#createstatus').text('ENABLED');
        var status = document.getElementsByClassName("newstatus");
        var i;
        for (i = 0; i < status.length; i++) {
            var changeStatus = status[i];
            if (changeStatus.classList.contains('disable')) {
                changeStatus.classList.remove('disable');
                changeStatus.classList.toggle('enable');
            }
        }
    }
  });   
});