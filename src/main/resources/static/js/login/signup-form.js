$(function(){ 
	$("#registerForm").validate({
		    rules: {
		      username: {
		    	  required: true,
		    	  minlength: 3,
		    	  remote: "/checkUsername"
		      },
		      email: {
		        required: true,
		        email: true,
		        remote: "/checkEmail"
		      },
		      password: {
		        required: true,
		        minlength: 6
		      },
		      rePassword: {
		    	  required: true,
		    	  minlength: 6,
		    	  equalTo: "#rPassword"
		      }
		    },
		    messages: {
		      username: {
		    	  required: "Please enter your username",
		    	  minlength: "Your username must be at least 3 characters long",
		    	  remote: "This username is already taken"
		      },
		      password: {
		        required: "Please provide a password",
		        minlength: "Your password must be at least 6 characters long"
		      },
		      rePassword: {
			        required: "Please retype your password",
			        minlength: "Your password must be at least 6 characters long",
			        equalTo: "Please enter the same password as above"
			  },
		      email:{
		    	  required: "Please enter your email address",
		    	  email: "Please enter a valid email address",
		    	  remote: "This email address is already used"
		      }
		   },
		   highlight: function (element, errorClass) {
			   $(element).css("border-color","#FF0000");		    	
		   },
		   unhighlight: function (element, errorClass) {
			   $(element).css("border-color","#3AFF00");
		   },
		   submitHandler: function (form) {
	             $.ajax({
	                 type: "POST",
	                 url: "/register",
	                 data: $(form).serialize(),
	                 success: function () {
	                	$("#successfullRegistration a#modalOKbtn").attr("href", "/login");	
	             		$("#successfullRegistration").modal();
	                 }
	             });
	             return false;
	         }
	});
});