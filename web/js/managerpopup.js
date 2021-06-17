/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function showPopup() {
  document.getElementById("usermenu").classList.toggle("show");
}

// Close the dropdown menu if the user clicks outside of it
window.onclick = function(event) {
  if (!event.target.matches('.ava')) {
    var dropdowns = document.getElementsByClassName("popupwrapper");
    var i;
    for (i = 0; i < dropdowns.length; i++) {
      var openDropdown = dropdowns[i];
      if (openDropdown.classList.contains('show')) {
        openDropdown.classList.remove('show');
      }
    }
  }
};

function showCreatePopup() {
  document.getElementById("createpopup").style.display="block";

}
function closeCreatePopup() {
  document.getElementById("createpopup").style.display="none";
}