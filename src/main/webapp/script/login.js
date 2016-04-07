$("#login-button").click(function() {
	var person = {
			"email": $("#email").val(),
			"password": $("#password").val()
		}
    $.ajax({
    	type: "POST",
        url: "/market-time/rest/login",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(person),
        success: function(response){  
            // we have the response  
            //alert("Cookie: " + xhr.getResponseHeader('Set-Cookie'));
        	if (response.loggedIn) {
        		window.location = "/market-time/home";
			}
        	if (response.generalError) {
        		$("#modal-header").append("<p style=\"color:red;\">" + "GeneralError" + "</p>")
			}
        	if (response.validationErrors.email) {
				$("#email-div").append("<p style=\"color:red;\">" + "Invalid email" + "</p>")
			}
        	if (response.validationErrors.password) {
				$("#password-div").append("<p style=\"color:red;\">" + "Invalid Password" + "</p>")
			}
          },  
          error: function(e){  
            alert('Error121212: ' + e.responseText);  
          }  
    })
});