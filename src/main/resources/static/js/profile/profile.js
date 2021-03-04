$(function(){
	$(".navigationMenu #editUser").click(function(){
		 $("form").animate({height: "toggle", opacity: "toggle"}, "slow");
	});
	
	$(".navigationMenu #changeUserRole").click(function(){
		 $("form").animate({height: "toggle", opacity: "toggle"}, "slow");
	});
	
	if($("#isUserLogged").text().trim() !== "Guest"){
		var username = $("#isUserLogged").text().trim();
		 $.ajax({
             type: "GET",
             url: "/profile/getLoggedUserEmail",
             data: {username : username},
             datatype: String,
             success: function (data) {
            	$("#currentUserEmail").text(data);
             }
         });
		 
		 $.ajax({
             type: "GET",
             url: "/profile/getUserId",
             data: {username : username},
             datatype: String,
             success: function (data) {
            	 console.log(data);
            	$("#userId").attr("value", data);
             }
         });
	}
	
});