/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function readURLThumb(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#avapreview')
                .attr('src', e.target.result);
            $('#avapreview')
                .attr('style', 'display:block');
        };

        reader.readAsDataURL(input.files[0]);
    }
}