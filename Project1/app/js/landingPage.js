$('.collapse').collapse()


function onNavbarEntryClick(e){

    let element = document.getElementsByClassName("active")[0];
    element.classList.remove("active");

    e.classList.add("active");
}

function hideAll(){

    let elements = document.getElementsByClassName("landing-div");

    for(let ele of elements){

        ele.hidden = true;
    }
}

function loadHome(){

    hideAll();
    document.getElementById("landing-home-div").hidden = false;
}

function loadMyAccount(){

    hideAll();
    document.getElementById("landing-my-account-div").hidden = false;
}