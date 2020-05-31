window.onload = function() {
    console.log("in onload");
    document.getElementById("formsRequest").addEventListener("click", getYourForms, false);
}

function getYourForms(){
    let formid = document.getElementById("emp_id").value;
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        console.log("in ORSC " +xhr.readyState);
        if(xhr.readyState==4 && xhr.status==200){
            console.log(xhr.responseText);
            var forms = JSON.parse(xhr.responseText);
            CreateTableFromJSON(forms);
        }
    }
xhr.open("GET","http://localhost:8080/TRMSProjectPattonZ/ULGrade?emp_id=" + formid ,true);
    xhr.send();
}
function loadforms(forms){
    document.getElementById("form_id").innerHTML=TRMSForms.form_id;
    document.getElementById("course_title").innerHTML=TRMSForms.course_title;
}

function CreateTableFromJSON(howdy) {
    console.log(howdy);
    let abc = howdy
    // EXTRACT VALUE FOR HTML HEADER. 
    // ('Book ID', 'Book Name', 'Category' and 'Price')
    var col = [];
    for (var i = 0; i < abc.length; i++) {
        for (var key in abc[i]) {
            if (col.indexOf(key) === -1) {
                col.push(key);
            }
        }
    }

    // CREATE DYNAMIC TABLE.
    var table = document.createElement("table");

    // CREATE HTML TABLE HEADER ROW USING THE EXTRACTED HEADERS ABOVE.

    var tr = table.insertRow(-1);                   // TABLE ROW.

    for (var i = 0; i < col.length; i++) {
        var th = document.createElement("th");      // TABLE HEADER.
        th.innerHTML = col[i];
        tr.appendChild(th);
    }

    // ADD JSON DATA TO THE TABLE AS ROWS.
    for (var i = 0; i < abc.length; i++) {

        tr = table.insertRow(-1);

        for (var j = 0; j < col.length; j++) {
            var tabCell = tr.insertCell(-1);
            tabCell.innerHTML = abc[i][col[j]];
        }
    }

    // FINALLY ADD THE NEWLY CREATED TABLE WITH JSON DATA TO A CONTAINER.
    var divContainer = document.getElementById("formtable");
    divContainer.innerHTML = "";
    divContainer.appendChild(table);
}