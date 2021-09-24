function validate(){
	var username = document.getElementById("username").value;
	var password = document.getElementById("password").value;
	if(username.length == 0){
		alert("Please enter your username")
		return false;
	}
	else if(password.length == 0){
		alert("Please enter your password")
		return false;
	}
	else if(password.length < 6){
		alert("Please enter your password with minimum 6 characters")
		return false;
	}
	else if(password.length > 10){
		alert("Please enter your password with maximum 10 characters")
		return false;
	}
	else{
		alert("Welcome :"+username)
	}
}