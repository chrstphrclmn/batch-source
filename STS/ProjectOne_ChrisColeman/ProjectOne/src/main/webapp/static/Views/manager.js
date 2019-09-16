document.addEventListener("load", loadFunction());
//document.getElementById("reimburse").addEventListener("click", createReimbursement);
//document.getElementById("profileUpdate").addEventListener("click", updateProfile);
//console.log("document found");
//let token = sessionStorage.getItem("token");
document.getElementById("display-all").addEventListener("click", function(){
    clearTables();
    loadTables();
})
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
        loadProfile();
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
            let currentNode = document.getElementById("employee-table");
            for(let temp of ret){
                if(temp.username!=tokenArr[0]){

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
                    let username = temp.username;

                    let newrow = document.createElement("tr");

                    newrow.addEventListener("click", function(){
                        clearTables();
                        loadTables(username);
                    })

                    currentNode.appendChild(newrow);

                    let newusername = document.createElement("td");
                    let newfirst = document.createElement("td");
                    let newlast = document.createElement("td");
                    let newtitle = document.createElement("td");
                    let newemail = document.createElement("td");
                    let newphone = document.createElement("td");

                    newusername.appendChild(document.createTextNode(username));
                    newfirst.appendChild(document.createTextNode(first));
                    newlast.appendChild(document.createTextNode(last));
                    newtitle.appendChild(document.createTextNode(title));
                    newemail.appendChild(document.createTextNode(email));
                    newphone.appendChild(document.createTextNode(phone));

                    newrow.appendChild(newusername);
                    newrow.appendChild(newfirst);
                    newrow.appendChild(newlast);
                    newrow.appendChild(newtitle);
                    newrow.appendChild(newemail);
                    newrow.appendChild(newphone);
                    
                }
            }

            loadTables();
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

function loadTables(user){

    console.log("tables loading");
    let resArr = [];
    
    let url = "http://localhost:8080/ERS/api/combined";
	let xhr = new XMLHttpRequest();
	xhr.open("GET", url);
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status===200){

            let ret = JSON.parse(xhr.response);

            for(let req of ret){
                let limitCheck = false;

                if(user && req.request.username == user){
                    limitCheck = true;
                }
                else if(!user){
                    if(req.request.username!=tokenArr[0]){
                        limitCheck = true;
                    }
                }
                if(limitCheck){
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

                        console.log(decision);

                        if(decision==true){
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
                        let newdec = document.createElement("td");
                        let appbtn = document.createElement("button");
                        let denbtn = document.createElement("button");

                        appbtn.classList.add("btn");
                        appbtn.classList.add("btn-success");
                        denbtn.classList.add("btn");
                        denbtn.classList.add("btn-danger");

                        appbtn.addEventListener("click", function(){
                            resolve(reqnum, true);
                        });

                        denbtn.addEventListener("click", function(){
                            resolve(reqnum, false);
                        });

                        newnum.appendChild(document.createTextNode(reqnum));
                        newamm.appendChild(document.createTextNode(ammount));
                        appbtn.appendChild(document.createTextNode("Approve"));
                        denbtn.appendChild(document.createTextNode("Deny"));
                        newdec.appendChild(appbtn);
                        newdec.appendChild(denbtn);

                        newrow.appendChild(newnum);
                        newrow.appendChild(newamm);
                        newrow.appendChild(newdec);
                    }
                }
            }
			
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

function resolve(id, decision){
    let url ="http://localhost:8080/ERS/resolve";

    let xhr = new XMLHttpRequest();
    xhr.open("POST", url);
    xhr.onreadystatechange = function(){
        if(this.readyState === 4 && this.status===200){
            clearTables();
            loadTables();
        }
    }

    let hold = {
        "managerUsername": tokenArr[0],
        "decision": decision,
        "requestId": id
    };

    let holda = JSON.stringify(hold);

    xhr.send(holda);
}