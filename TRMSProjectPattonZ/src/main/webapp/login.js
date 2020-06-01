window.onload = function(){
    console.log("in onload");
    document.getElementById("unSubmitGet").addEventListener("click", postUN, false);
}

function jsonBuilder(){
    var elements=document.getElementById("unInput").elements;
    var obj = {};
    var json=JSON.stringify(obj);
    console.log(json);
    return json;
}
function postUN(){
	console.log("in postUN");
	var user_name = document.getElementById("unInput").value;
	console.log(user_name);
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        console.log("in ORSC " +xhr.readyState);
        if(xhr.readyState==4 && xhr.status==200){
            console.log(xhr.responseText);
            var un = JSON.parse(xhr.responseText);
            
        }
    }
    xhr.open("POST",`http://localhost:8080/TRMSProjectPattonZ/Login`, true);   
    var payload = jsonBuilder();
    xhr.send(payload);
}

