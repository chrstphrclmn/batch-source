let requestUrl = "http://localhost:8081/Project1/employee-view-approved";

console.log("hello");


function sendAjaxGet(url, callback){
	let xhr = new XMLHttpRequest();
	
	xhr.open("GET", url,true);
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState===4 && xhr.status===200){
			
			callback(xhr.getResponseHeader("approvedreimbursementJSON"));
		}
	}

	xhr.send();
}


function showApprovedEmployeeReimbursements(approvedreimbursementJSON){
	let reimbursements = JSON.parse(approvedreimbursementJSON);
	let table = document.getElementById("approved-reimb-table");
	for(let reimbursement of reimbursements){
		let newRow = document.createElement("tr");
		newRow.innerHTML = `<td>${reimbursement.reimbId}</td><td>${reimbursement.amount}</td><td>${reimbursement.description}</td>`;
		table.appendChild(newRow);
	}
}


sendAjaxGet(requestUrl,showApprovedEmployeeReimbursements);