requestUrl = "http://localhost:8081/Project1/employee-view-info";

function sendAjaxGet(url,callback){
	let xhr = new XMLHttpRequest();
	
	xhr.open("GET", url,true);
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState===4 && xhr.status===200){
			callback(xhr.getResponseHeader("employeeJSON"));
		}
	}
	xhr.send();
}

function displayEmployeeInfo(employeeJSON){
	let employee = JSON.parse(employeeJSON);
	let table = document.getElementById("emp-table");
	for(employ of employee){
		let row = document.createElement("tr");
		row.innerHTML = `<td>${employ.name}</td><td>${employ.userName}</td>`;
		table.appendChild(row);
	}
}


sendAjaxGet(requestUrl,displayEmployeeInfo);