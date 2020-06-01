window.onload = function() {
    console.log("in onload");
    document.getElementById("trmsFormSub").disabled = true;
    document.getElementById("trmsFormSub").addEventListener("click", createFormRequest, false);
    document.getElementById("startDate").addEventListener("change", checkStartDate, false);
}


function jsonBuilder(){
    var elements = document.getElementById("trmsform").elements;
    var obj = {};
    for(var i = 0; i<elements.length-1; i++){
        var item=elements.item(i);
        obj[item.name]=item.value;
        console.log(obj);
        }
    var json=JSON.stringify(obj);
    console.log(json);
    return json
}

function createFormRequest(){
    console.log("in createFormRequest");
    var xhr= new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        console.log("in ORSC " +xhr.readyState);
        if(xhr.readyState==4 && xhr.status==200){
            console.log(xhr.responseText);
        }
    }
    xhr.open("POST", `http://localhost:8080/TRMSProjectPattonZ/TRMSForm`, true);
    var payload = jsonBuilder();
    xhr.send(payload);
    }
    
    function checkStartDate(start){
        let now=Date.now();//give milliseconds of current time
        start=Date.parse(document.getElementById("startDate").value); //give milliseconds of start date
        console.log(now+"  verus " + start);
        if(start>now+604800000){ 
            document.getElementById("tooShort").innerHTML="";
            console.log("true");
            document.getElementById("trmsFormSub").disabled = false;
        }else{
            document.getElementById("tooShort").innerHTML="<h3>The start date much be at least 7 days after the current date</h3>";
            console.log("false");
            document.getElementById("trmsFormSub").disabled = true;
    
        }
    }