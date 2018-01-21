$(document).ready(function()
{
    $("#searchUsersButton").click(function(e) { 
                                            e.stopPropagation();
                                            e.preventDefault();
                                            updateList();
                                            return false;
                                            });
    $("#searchUsersText").keyup(function(e) { 
                                            e.stopPropagation();
                                            e.preventDefault();
                                            updateList();
                                            return false;
                                            });
                                            

});
    
    
function stateSuccess(data)
{    
    //console.log("success");
    $("#elencoPersone ul").empty();
    for(var instance in data){
        $("#elencoPersone ul").append(createElement(data[instance]));
    }
}
    
function stateFailure()
{
    //console.log("failure");
    $("#elencoPersone ul").empty();    
    $("#elencoPersone ul").append($("<li>").append("Nessun utente trovato"));    
}

function createElement(user)
{
    
    var a = $("<a>")
            .append(img)
            .attr("href", "bacheca.html?action=view&owner="+user.id+"&ownerType=user")   
            .append(user.nome+" "+user.cognome);
    
    return $("<li>").append(a);
}

function updateList()
{
    $.ajax({
        url: "filter.json",
        data:{
            action:"search",
            q: $("#searchUsersText")[0].value
        },
        dataType:"json",
        success: function(data, state){
            stateSuccess(data);
        },
        error: function(data, state){
            stateFailure(data, state);
        }
    });

}


