let token = sessionStorage.getItem("token");
//console.log(token);

if(!token){
	window.location.href="http://localhost:8080/ERS/login";
} else {
	let tokenArr = token.split(":");
	//console.log(tokenArr);
	if(tokenArr.length===2){

	} else {
		window.location.href="http://localhost:8080/ERS/login";
	}
}