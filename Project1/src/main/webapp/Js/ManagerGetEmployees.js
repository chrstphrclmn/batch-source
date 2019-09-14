let requestUrl = "http://localhost:8081/Project1/manager-view-employees";

console.log("hello from js");

function sendAjaxGet(url, callback){
	let xhr = new XMLHttpRequest();
	
	xhr.open("GET", url,true);
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState===4 && xhr.status===200){
			
			callback(xhr.getResponseHeader("employeeJSON"));
		}
	}

	xhr.send();
}

function showEmployees(employeeJSON){
	let employees = JSON.parse(employeeJSON);
	let table = document.getElementById("managerEmp-table");
	for(let employee of employees){
		let newRow = document.createElement("tr");
		newRow.innerHTML = `<td>${employee.name}</td><td>${employee.userName}</td>`;
		table.appendChild(newRow);
	}
}


sendAjaxGet(requestUrl,showEmployees);