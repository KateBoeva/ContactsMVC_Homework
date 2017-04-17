var contact = {
    name:"",
    email:"",
    address:"",
    number:""
};

$(document).ready(function() {
    $('.create').click(function(event, ui){
        contact.name = $('.name').val();
        contact.email = $('.email').val();
        contact.address = $('.address').val();
        contact.number = $('.number').val();
        createContact();
    });
});

function createContact() {
    $.ajax({
        method: "POST",
        dataType: 'json',
        crossDomain: true,
        url: "http://localhost:8080/1hw-2-1.0-SNAPSHOT/contact",
        data: JSON.stringify(contact),
        contentType:'application/json; charset=utf-8'
    }).done(function(){
    }).fail(function(){
        window.location.href = "contacts.html";
    });
}