var newContact = {
    name:"",
    email:"",
    address:"",
    number:""
};

$(document).ready(function() {
    var id = getCookie("id");
    document.cookie = "id=-1";
    $.ajax({
        method: "GET",
        crossOrigin: true,
        datatype:"json",
        url: "http://localhost:8080/1hw-2-1.0-SNAPSHOT/contact/" + id
    }).done(function(contact){
        $('.name').val(contact.name);
        $('.email').val(contact.email);
        $('.address').val(contact.address);
        $('.number').val(contact.number);

        $('.change').click(function(event, ui){
            newContact.name = $('.name').val();
            newContact.email = $('.email').val();
            newContact.address = $('.address').val();
            newContact.number = $('.number').val();
            newContact.id = id;
            changeContact();
        });
    }).fail(function(){
        console.log("no");
    });
});

function changeContact() {
    $.ajax({
        method: "PUT",
        dataType: 'json',
        crossDomain: true,
        url: "http://localhost:8080/1hw-2-1.0-SNAPSHOT/contact",
        data: JSON.stringify(newContact),
        contentType:'application/json; charset=utf-8'
    }).done(function(){
        window.location.href = "contacts.html";
    }).fail(function(){
    });
}

function getCookie(name) {
    var cookie = " " + document.cookie;
    var search = " " + name + "=";
    var setStr = null;
    var offset = 0;
    var end = 0;
    if (cookie.length > 0) {
        offset = cookie.indexOf(search);
        if (offset != -1) {
            offset += search.length;
            end = cookie.indexOf(";", offset)
            if (end == -1) {
                end = cookie.length;
            }
            setStr = unescape(cookie.substring(offset, end));
        }
    }
    return(setStr);
}