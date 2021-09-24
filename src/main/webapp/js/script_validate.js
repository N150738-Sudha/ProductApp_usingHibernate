function validateSignUpForm(){
	
	var allFields = new Array();
	
	for(i=0;i<5;i++)
	{
		allFields[i] = document.forms[0].elements[i].value
		if(i==3){
			if(allFields[1] != allFields[2]){
				alert("confirm password is not matching with password")
				return false
			}
		else if(allFields[i].length == 0){
			alert(allFields[i]+"is mandatory")
			return false
		}
 
		}
	}
	if(allFields[1] != allFields[2]){
		alert("confirm password is not matching with password")
		return false
	}
	if(document.getElementById("gender").checked == false){
		alert("Please select gender")
		return false
	}
	/*var paymentOptions = document.getElementById("paymentOptions").value;
	if(document.getElementById("gender").checked == false){
		alert("Please select gender")
		return false
	}
	else if(document.getElementById('notification').checked == null){
		alert("Please select atleast one notification")
		return false
		
	}
	else if(paymentOptions == "select"){
		alert("Please select payment option")
		return false
	}*/
	else{
		console.log(gender);
		console.log(notifications);
		console.log(paymentOptions);
		return false
	}
	return false
}