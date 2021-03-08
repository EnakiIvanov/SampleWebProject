$(function(){
	$(".navigationMenu #editUser").click(function(){
		 $("form").animate({height: "toggle", opacity: "toggle"}, "slow");
	});
	
	$(".navigationMenu #changeUserRole").click(function(){
		 $("form").animate({height: "toggle", opacity: "toggle"}, "slow");
	});

	var username = $("#isUserLogged").text().trim();
		
	 $.ajax({
         type: "GET",
         url: "/profile/getUserId",
         data: {username : username},
         datatype: String,
         success: function (data) {
        	$("#userId").attr("value", data);
         }
     });

	 $.ajax({
         type: "GET",
         url: "/profile/getLoggedUserEmail",
         data: {username : username},
         datatype: String,
         success: function (data) {
        	$("#currentUserEmail").text(data);
         }
     });
});