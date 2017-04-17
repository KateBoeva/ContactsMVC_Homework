$(document).ready(function() {
    $.ajax({
        method: "GET",
        crossOrigin: true,
        datatype:"json",
        url: "http://localhost:8080/1hw-2-1.0-SNAPSHOT/contact"
    }).done(function(contact){
        for(var i = 0; i < contact.length; i++){
            $('.contacts').append("<tr>" +
                "<td>"+contact[i].name+"</td>" +
                "<td>"+contact[i].email+"</td>" +
                "<td>"+contact[i].address+"</td>" +
                "<td>"+contact[i].number+"</td>" +
                "<td class='func'><button class='change' id='" + contact[i].id + "'>e</button></td>" +
                "<td class='func'><button title='" + i + "' class='delete' id='" + contact[i].id + "'>d</button></td></tr>");
        }
        $('.change').click(function(event, ui){
            console.log("change");
            document.cookie = "id=" + $(this).attr('id');
            window.location.href = "change.html";
        });
        $('.delete').click(function(event, ui){
            console.log("delete");
            deleteContact($(this).attr('id'));
        });
    }).fail(function(){
        console.log("no");
    });
});

function deleteContact(id) {
    $.ajax({
        method: "DELETE",
        dataType: 'json',
        crossDomain: true,
        url: "http://localhost:8080/1hw-2-1.0-SNAPSHOT/contact/" + id,
        contentType:'application/json; charset=utf-8'
    }).done(function(){
    }).fail(function(){
        window.location.href = "contacts.html";
    });
}