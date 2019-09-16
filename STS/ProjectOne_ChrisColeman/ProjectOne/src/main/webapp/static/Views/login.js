document.getElementById("login-btn").addEventListener("click", requestLogin);
window.sessionStorage.clear();




function requestLogin(){
	let url = "http://localhost:8080/ERS/login";
	let xhr = new XMLHttpRequest();
	xhr.open("POST", url);
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status===200){


			let auth = xhr.getResponseHeader("authorized");
			sessionStorage.setItem("token", auth);
			if(auth){
				console.log("Logged in.");

				let man = xhr.getResponseHeader("manager");

				if(man){
					console.log("Logged in as manager.");
					window.location.href="http://localhost:8080/ERS/manager";
				}
				else{
					window.location.href="http://localhost:8080/ERS/employee";
				}
			}
			else{
				console.log("Invalid Credentials");
			}
			
		}
		if(this.readyState === 4 ){
			console.log(this);
		}
	}
	let user = document.getElementById("username_input").value;
	let pass = document.getElementById("password_input").value;
	let manager = document.getElementById("manager_check").checked;

	let hold = {
		"username": user,
		"password": pass,
		"manager": manager
	}
	
	let holda = JSON.stringify(hold);

	
	xhr.setRequestHeader("Content-Type","application/json");
	
	let requestBody = holda;
	
	xhr.send(requestBody);
	
	
}