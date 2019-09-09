$(document).keypress(function(e){
    if (e.which == 13){
        $("#login-button").click();
    }
});

function onLoginClick(){

    username = document.getElementById("username-input").value;
    password = document.getElementById("password-input").value;

    console.log(username + " : " + password);

    if(!username){

        updateErrorMessage("Please enter a username in the respective field.")
    }

    else if(!password){

        updateErrorMessage("Please enter a password in the respective field.");
    }

    else{

        resetErrorMessage();

        window.location.href = "./landing.html";
    }
}

function updateErrorMessage(str){

    let ele = document.getElementById("login-error-message");

    ele.textContent = str
    ele.hidden = false;
}

function resetErrorMessage(){

    document.getElementById("login-error-message").hidden = true;
}