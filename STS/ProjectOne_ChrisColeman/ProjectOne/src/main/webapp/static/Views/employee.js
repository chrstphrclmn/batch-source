document.addEventListener("load", loadFunction());
document.getElementById("reimburse").addEventListener("click", createReimbursement);
document.getElementById("profileUpdate").addEventListener("click", updateProfile);
//console.log("document found");
//let token = sessionStorage.getItem("token");
let tokenArr = token.split(":");

let inputBox = document.getElementById("value_input");

function updateProfile(){

    let username = tokenArr[0];
    let firstName = document.getElementById("user-first").value;
    let lastName = document.getElementById("user-last").value;
    let title = document.getElementById("user-title").value;
    let email = document.getElementById("user-email").value;
    let phone = document.getElementById("user-phone").value;

    let submission = {
        "username": username,
        "lastName": lastName,
        "firstName": firstName,
        "title": title,
        "email": email,
        "phone": phone
    }

    let submissionJSON = JSON.stringify(submission);
    let url = "http://localhost:8080/ERS/loginupdate";

    let xhr = new XMLHttpRequest();

    xhr.open("POST", url);
    xhr.onreadystatechange = function(){

        if(this.readyState === 4 && this.status===200){

            loadProfile();
        }
    }

    xhr.send(submissionJSON);


}

let invalidChars = [
  "-",
  "+",
  "e",
];

inputBox.addEventListener("keydown", function(e) {
  if (invalidChars.includes(e.key)) {
    e.preventDefault();
  }
});

function clearTables(){
    var elements = document.getElementsByClassName("removable");
    while(elements.length > 0){
        elements[0].parentNode.removeChild(elements[0]);
    }
}

function loadFunction(){
    //console.log("Load function initiated.")
    if(auth()){
        //console.log("authorized");
        console.log("before tables");
        loadTables();
        console.log("after tables");
    }
 
}

function loadProfile(){
    console.log("Getting Profile");

    let url = "http://localhost:8080/ERS/api/logins";

    let xhr = new XMLHttpRequest();

    xhr.open("GET", url);
    xhr.onreadystatechange = function(){

        if(this.readyState === 4 && this.status===200){

            let ret = JSON.parse(xhr.response);

            for(let temp of ret){
                if(temp.username==tokenArr[0]){

                    let first = temp.firstName;
                    if(!first){
                        first = "N/A";
                    }
                    let last = temp.lastName;
                    if(!last){
                        last = "N/A";
                    }
                    let title = temp.title;
                    if(!title){
                        title = "N/A";
                    }
                    let email = temp.email;
                    if(!email){
                        email = "N/A";
                    }
                    let phone = temp.phone || "N/A";

                    document.getElementById("display-first").innerText="First Name: "+first;
                    document.getElementById("display-last").innerText="Last Name: "+last;
                    document.getElementById("display-title").innerText="Title: "+title;
                    document.getElementById("display-email").innerText="Email: "+email;
                    document.getElementById("display-phone").innerText="Phone: "+phone;

                    document.getElementById("user-first").defaultValue=first;
                    document.getElementById("user-last").defaultValue=last;
                    document.getElementById("user-title").defaultValue=title;
                    document.getElementById("user-email").defaultValue=email;
                    document.getElementById("user-phone").defaultValue=phone;
                    break;
                }
            }
        }

    }
    xhr.send();
}

function createReimbursement(){

    console.log("Creating reimbursement.");
    let value = document.getElementById("value_input").value;


    if(value){
        let url = "http://localhost:8080/ERS/request";
        let xhr = new XMLHttpRequest();

        xhr.open("POST", url);
        xhr.onreadystatechange = function(){
            if(this.readyState === 4 && this.status===200){

                clearTables();
                loadTables();
                document.getElementById("value_input").value = "";
            }
            else if(this.readyState===4){
                document.getElementById("value_input").value = "";
            }

        }

        let req = {
            "username": tokenArr[0],
            "ammount": value
        }

        let reqa = JSON.stringify(req);
        xhr.setRequestHeader("Content-Type","application/json");
        xhr.send(reqa);
        
    }

}



function auth(){

    return true;

}

function loadTables(){

    console.log("tables loading");
    let resArr = [];
    
    let url = "http://localhost:8080/ERS/api/combined";
	let xhr = new XMLHttpRequest();
	xhr.open("GET", url);
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status===200){

            let ret = JSON.parse(xhr.response);

            for(let req of ret){
                if(req.request.username==tokenArr[0]){
                    console.log(req.request.requestId);
                    if(req.resolution){
                        console.log("has been resolved");

                        let newnode =  document.getElementById("resolved-body");

                        let newrow = document.createElement("tr");

                        newrow.classList.add("removable");
                        newnode.appendChild(newrow);
                        

                        let reqnum = req.request.requestId;
                        let ammount = req.request.ammount;

                        console.log(reqnum+" "+ammount);
                        let decision = req.resolution.decision;
                        let authority = req.resolution.managerUsername;

                        if(decision=="true"){
                            decision = "Approved";
                        }
                        else{
                            decision = "Denied";
                        }

                        let newnum = document.createElement("td");
                        let newamm = document.createElement("td");
                        newnum.appendChild(document.createTextNode(reqnum));
                        newamm.appendChild(document.createTextNode(ammount));

                        newrow.appendChild(newnum);
                        newrow.appendChild(newamm);

                        let newdec = document.createElement("td");
                        let newauth = document.createElement("td");
                        newdec.appendChild(document.createTextNode(decision));
                        newauth.appendChild(document.createTextNode(authority));

                        newrow.appendChild(newdec);
                        newrow.appendChild(newauth);
                    }
                    else{

                        
                        let newnode =  document.getElementById("pending-body");

                        let newrow = document.createElement("tr");

                        newrow.classList.add("removable");

                        newnode.appendChild(newrow);                    

                        let reqnum = req.request.requestId;
                        let ammount = req.request.ammount;

                        let newnum = document.createElement("td");
                        let newamm = document.createElement("td");
                        newnum.appendChild(document.createTextNode(reqnum));
                        newamm.appendChild(document.createTextNode(ammount));

                        newrow.appendChild(newnum);
                        newrow.appendChild(newamm);
                    }
                }
            }
			loadProfile();
		}
		if(this.readyState === 4 ){
			console.log(this);
		}
	}

	
	xhr.send();

}

function getResolved(){
    let url = "http://localhost:8080/ERS/api/resolutions";
    let xhr = new XMLHttpRequest();
    xhr.open("GET", url, false);
    xhr.onreadystatechange = function(){
        if(this.readyState === 4 && this.status===200){

            return JSON.parse(xhr.response);
        }
    }
    xhr.send();
}