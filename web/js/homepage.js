function openLogin(){
    if(document.getElementById("register").style.display == "block"){
        closePopUp("register");
    }
    if(document.getElementById("forgot-password").style.display == "block"){
        closePopUp("forgot-password");
    }
    document.getElementById('login').style.display = "block";
}

function closePopUp(eleId){
    document.getElementById(eleId).style.display = "none";
}

function openRegister(){
    if(document.getElementById("login").style.display == "block"){
        closePopUp("login");
    }
    document.getElementById('register').style.display = "block";
}

function openForgotPassword(){
    if(document.getElementById("login").style.display == "block"){
        closePopUp("login");
    }
    document.getElementById('forgot-password').style.display = "block";
}

function resetNoti(){
    alert("Please check your email inbox. Thank you!");
}

function openChangePwd(){
    document.getElementById("change-pwd").style.display = "block";
}

function openProfile(){
    document.getElementById("user-profile").style.display = "block";
}