$(function(){ 
	$("#editUserDataForm").validate({
		    rules: {
		      username: {
		    	  required: true,
		    	  minlength: 3,
		    	  remote: {
		    	        url: "/profile/checkUsername",
		    	        type: "get",
		    	        data: {
		    	          username: function() {
		    	            return $("#username").val();
		    	          },
						  id: function(){
							return $("#userId").val();
						  }
		    	        }
		    	  }
		      },
		      email: {
		        required: true,
		        email: true,
		        remote: {
	    	        url: "/profile/checkEmail",
	    	        type: "get",
	    	        data: {
	    	          email: function() {
	    	            return $("#email").val();
	    	          },
					  id: function(){
						return $("#userId").val();
					  }
	    	        }
		        }
		      },
		      password: {
		        required: true,
		        minlength: 6
		      },
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
	                 type: "put",
	                 url: "/profile/edit",
	                 data: $(form).serialize(),
	                 success: function () {
	                	 alert("You have successfully updated your info.");
	                	 window.location.replace("/profile");
	                 }
	             });
	             return false;
	         }
	});
});