$(document).ready( () => {
    $("#btnSubmit").click((event) => {
        //stop submit the form, we will post it manually.
        event.preventDefault();
        doAjax();
    });
 
});

function doAjax() {
    // Get form
    var form = $('#fileUploadForm')[0];
    var data = new FormData(form);
    
    var ext = $('#uploadfile').val().split('.').pop().toLowerCase();
    if($.inArray(ext, ['gif','png','jpg','jpeg']) == -1) {
        alert('invalid extension!\n Only allow to upload gif, png or jpeg. ');
        return false;
    }
    
    if($("#adDesc").val() == '') {
        alert('Please provide ads. description.');
        return false;
    }
   
    var fileSize = $('#uploadfile')[0].files[0].size /1024;
    if(Math.round(fileSize) > 600){
    	 alert('You can upload maximum to 600 kb.');
    	return false;
    }
   
    $.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url: "/admin/uploadFile",
        data: data,
        processData: false, //prevent jQuery from automatically transforming the data into a query string
        contentType: false, 
        cache: false,
        success: (data) => {
          window.location.href = "/admin/uploadAds";
        }
    });
}